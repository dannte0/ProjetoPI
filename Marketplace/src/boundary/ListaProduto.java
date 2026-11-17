package boundary;

import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;

import javax.swing.AbstractCellEditor;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;

import controller.CategoriaController;
import controller.ProdutoController;
import entity.Categoria;
import entity.Produto;

public class ListaProduto extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	ProdutoController pc = new ProdutoController();
	CategoriaController cc = new CategoriaController();
	private JButton btnNewButton;
	private static final int COL_ACOES = 7;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListaProduto frame = new ListaProduto();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public ListaProduto() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1110, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 51, 1074, 399);
		contentPane.add(scrollPane);

		JButton btnMenu = new JButton("Menu");
		btnMenu.setForeground(new Color(255, 255, 255));
		btnMenu.setBackground(new Color(0, 0, 0));
		btnMenu.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				MenuInicial tela;
				try 
				{
					tela = new MenuInicial();
					tela.setVisible(true);
					dispose();
				} 
				catch (Exception exc) 
				{
					
					 String exception = exc.getMessage();
			           JOptionPane.showMessageDialog(null,
			                  exception,
			                  "ERRO",
			                  JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnMenu.setBounds(517, 11, 78, 34);
		contentPane.add(btnMenu);
		
		table = new JTable();
		table.setRowHeight(32);
		table.setModel(new DefaultTableModel(
			new Object[][] {},
			new String[] {
				"ID", "Produto", "Descricao", "Categoria", "Marca", "Condição", "Cor", "A\u00E7\u00F5es"
			}
		) {
			private static final long serialVersionUID = 1L;

			@Override
			public boolean isCellEditable(int row, int column) {
				return column == COL_ACOES;
			}
		});
		table.getColumnModel().getColumn(0).setPreferredWidth(15);
		table.getColumnModel().getColumn(COL_ACOES).setPreferredWidth(170);
		table.getColumnModel().getColumn(COL_ACOES).setCellRenderer(new AcoesRenderer());
		table.getColumnModel().getColumn(COL_ACOES).setCellEditor(new AcoesEditor());
		scrollPane.setViewportView(table);

		btnNewButton = new JButton("Listar Produtos");
		btnNewButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent e) {
				try {
					listarTabela();
				} catch (ClassNotFoundException | SQLException exc) {
					JOptionPane.showMessageDialog(null, exc.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnNewButton.setBounds(264, 11, 133, 23);
		contentPane.add(btnNewButton);
	}

	private void listarTabela() throws ClassNotFoundException, SQLException {
		try {
			List<Produto> lista = pc.findAllProduto();
			DefaultTableModel model = (DefaultTableModel) table.getModel();
			model.setRowCount(0);
			for (Produto produto : lista) {
				Categoria c = new Categoria();
				
				c.setId(produto.getId_categoria());
				c = cc.findOneCategoria(c.getId());
				
				Object[] linha = new Object[9];
				linha[0] = produto.getId();
				linha[1] = produto.getNome();
				linha[2] = produto.getDescricao();
				linha[3] = c.getNome();
				linha[4] = produto.getMarca();
				linha[5] = produto.getCondicao();
				linha[6] = produto.getCor();
				linha[COL_ACOES] = "";
				model.addRow(linha);
			}
		} catch (Exception exc) {
			JOptionPane.showMessageDialog(null, exc.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
		}
	}

	private void editar(int id) 
	{
		ExibeProduto tela;
		try 
		{
			Produto p = new Produto();
			tela = new ExibeProduto();
			tela.setVisible(true);
			p.setId(id);
			p = pc.findOneProduto(p);
			//tela.textFieldProdutoID.setText(String.valueOf(id));
			tela.textFieldNome.setText(p.getNome());
			tela.textFieldNome.setEditable(true);
//			tela.textFieldNomeCategoria.setText(p.getNome_categoria());
//			tela.textFieldNomeCategoria.setEditable(true);
			tela.textFieldNomeCategoria.setVisible(false);
//			tela.textFieldStatus.setText(p.getStatus());
			tela.textFieldStatus.setEditable(true);
			tela.textAreaDesc.setText(p.getDescricao());
			tela.textAreaDesc.setEditable(true);
			tela.comboBoxCategoriaProduto.setEnabled(true);
			tela.lblProdutoID.setVisible(false);
			tela.textFieldProdutoID.setVisible(false);
			tela.textFieldProdutoID.setText(String.valueOf(id));
			tela.btnBuscar.setVisible(false);
			tela.btnEnviar.setVisible(true);
			
			dispose();
		}
		catch(Exception exc)
		{
			
		}
	}

	private void excluir(int id) 
	{
		int op = JOptionPane.showConfirmDialog(this, "Excluir o produto " + id + "?",
				"Confirmacao", JOptionPane.YES_NO_OPTION);
		if (op == JOptionPane.YES_OPTION) 
		{
			try 
			{
				Produto p = new Produto();
				p.setId(id);
				pc.deleteProduto(p);
				listarTabela();
			} 
			catch (ClassNotFoundException | SQLException exc) 
			{
				JOptionPane.showMessageDialog(null, exc.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
			}
		}
	}

	private class AcoesRenderer implements TableCellRenderer {
		@Override
		public Component getTableCellRendererComponent(JTable t, Object value,
				boolean isSelected, boolean hasFocus, int row, int column) {
			JPanel p = new JPanel(new FlowLayout(FlowLayout.CENTER, 5, 3));
			p.add(new JButton("Editar"));
			p.add(new JButton("Excluir"));
			return p;
		}
	}

	private class AcoesEditor extends AbstractCellEditor implements TableCellEditor {
		private static final long serialVersionUID = 1L;
		private JButton btnEditar = new JButton("Editar");
		private JButton btnExcluir = new JButton("Excluir");
		private JPanel painel = new JPanel(new FlowLayout(FlowLayout.CENTER, 5, 3));
		private int linha;

		AcoesEditor() {
			painel.add(btnEditar);
			painel.add(btnExcluir);

			btnEditar.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					int id = (int) table.getModel().getValueAt(linha, 0);
					fireEditingStopped();
					editar(id);
				}
			});

			btnExcluir.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					int id = (int) table.getModel().getValueAt(linha, 0);
					fireEditingStopped();
					excluir(id);
				}
			});
		}

		@Override
		public Component getTableCellEditorComponent(JTable t, Object value,
				boolean isSelected, int row, int column) {
			linha = t.convertRowIndexToModel(row);
			return painel;
		}

		@Override
		public Object getCellEditorValue() {
			return "";
		}
	}
}