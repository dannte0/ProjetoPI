package boundary;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.CategoriaController;
import controller.ProdutoController;
import entity.Categoria;
import entity.Produto;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.JComboBox;

public class ExibeProduto extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	protected JTextField textFieldProdutoID;
	private ProdutoController pc = new ProdutoController();
	protected JTextField textFieldNome;
	protected JTextField textFieldStatus;
	protected JTextArea textAreaDesc;
	protected JTextField textFieldNomeCategoria;
	private JLabel lblNomeProduto;
	private JLabel lblCategoria;
	private JLabel lblNewLabel;
	protected JLabel lblProdutoID;
	private JButton btnMenu;
	protected JButton btnBuscar;
	private JLabel lblDesc;
	protected JButton btnEnviar;
	protected JComboBox<Categoria> comboBoxCategoriaProduto;
	private JTextField textFieldCategoriaProduto;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ExibeProduto frame = new ExibeProduto();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public ExibeProduto() throws ClassNotFoundException, SQLException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 651, 449);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		textFieldProdutoID = new JTextField();
		textFieldProdutoID.setBounds(121, 11, 126, 34);
		contentPane.add(textFieldProdutoID);
		textFieldProdutoID.setColumns(10);
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				try
				{
					Produto p = new Produto();
					
					p.setId(Integer.parseInt(textFieldProdutoID.getText()));
					
					p = pc.findOneProduto(p);
					
					textFieldNome.setText(p.getNome());
					textFieldNomeCategoria.setText(p.getNome_categoria());
					textFieldStatus.setText(p.getStatus());
					textAreaDesc.setText(p.getDescricao());
			
					
				}
				catch(Exception exc)
				{
					String exception = exc.getMessage();
		            JOptionPane.showMessageDialog(null,
		                    exception,
		                    "ERRO",
		                    JOptionPane.ERROR_MESSAGE);
				}
			
			}
		});
		btnBuscar.setBounds(257, 11, 87, 34);
		contentPane.add(btnBuscar);
		
		textFieldNome = new JTextField();
		textFieldNome.setEditable(false);
		textFieldNome.setEditable(false);
		textFieldNome.setBounds(33, 84, 306, 34);
		contentPane.add(textFieldNome);
		textFieldNome.setColumns(10);
		
		textFieldNomeCategoria = new JTextField();
		textFieldNomeCategoria.setEditable(false);
		textFieldNomeCategoria.setBounds(33, 164, 306, 34);
		contentPane.add(textFieldNomeCategoria);
		textFieldNomeCategoria.setColumns(10);
		
		textFieldStatus = new JTextField();
		textFieldStatus.setEditable(false);
		textFieldStatus.setBounds(499, 84, 100, 34);
		contentPane.add(textFieldStatus);
		
		textAreaDesc = new JTextArea();
		textAreaDesc.setEditable(false);
		textAreaDesc.setBounds(33, 230, 565, 128);
		textAreaDesc.setColumns(10);
		contentPane.add(textAreaDesc);
		
		lblNomeProduto = new JLabel("Produto:");
		lblNomeProduto.setBounds(33, 59, 63, 14);
		contentPane.add(lblNomeProduto);
		
		lblCategoria = new JLabel("Categoria:");
		lblCategoria.setBounds(33, 139, 126, 14);
		contentPane.add(lblCategoria);
		
		lblNewLabel = new JLabel("Status:");
		lblNewLabel.setBounds(499, 59, 46, 14);
		contentPane.add(lblNewLabel);
		
		lblProdutoID = new JLabel("Id do Produto:");
		lblProdutoID.setBounds(33, 21, 78, 14);
		contentPane.add(lblProdutoID);
//		carregarCategorias();
		
		btnMenu = new JButton("Menu");
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
		
		lblDesc = new JLabel("Descrição:");
		lblDesc.setBounds(33, 205, 63, 14);
		contentPane.add(lblDesc);
		
		btnEnviar = new JButton("Enviar");
		btnEnviar.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				ListaProduto tela;
				try 
				{
					Produto p = new Produto();
					Categoria c = (Categoria) comboBoxCategoriaProduto.getSelectedItem();
					
					p.setId(Integer.parseInt(textFieldProdutoID.getText()));
					p.setNome(textFieldNome.getText());
					p.setDescricao(textAreaDesc.getText());
					p.setId_categoria(c.getId());
					p.setStatus(textFieldStatus.getText());
					
					pc.updateProduto(p);
					JOptionPane.showMessageDialog(null,
		                    "Produto Atualizado com Sucesso",
		                    "SUCESSO",
		                    JOptionPane.INFORMATION_MESSAGE);
					tela = new ListaProduto();
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
		btnEnviar.setBounds(499, 369, 100, 30);
		btnEnviar.setVisible(false);
		contentPane.add(btnEnviar);
		
		comboBoxCategoriaProduto = new JComboBox<>();
		comboBoxCategoriaProduto.setBounds(33, 164, 306, 34);
		contentPane.add(comboBoxCategoriaProduto);
		carregarCategorias();
		
		
	}
	private void carregarCategorias() throws ClassNotFoundException, SQLException
	{
		CategoriaController catCtr = new CategoriaController();
		List<Categoria> categorias = catCtr.findAllCategoria();
        for (Categoria c : categorias) {
            comboBoxCategoriaProduto.addItem(c);
        }

        if (comboBoxCategoriaProduto.getItemCount() > 0) {
            comboBoxCategoriaProduto.setSelectedIndex(0);
        }
	}
}
