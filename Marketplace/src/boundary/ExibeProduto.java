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
import java.awt.Font;
import javax.swing.DefaultComboBoxModel;

public class ExibeProduto extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	protected JTextField textFieldProdutoID;
	private ProdutoController pc = new ProdutoController();
	private CategoriaController cc = new CategoriaController();
	protected JTextField textFieldNomeProduto;
	protected JTextField textFieldCorProduto;
	protected JTextArea textAreaDescricaoProduto;
	protected JTextField textFieldNomeCategoria;
	private JLabel lblNomeProduto;
	private JLabel lblCategoria;
	protected JLabel lblProdutoID;
	private JButton btnMenu;
	protected JButton btnBuscar;
	private JLabel lblDesc;
	protected JButton btnEnviar;
	protected JComboBox<String> comboBoxCondicaoProduto;
	protected JComboBox<Categoria> comboBoxCategoriaProduto;
	protected JTextField textFieldCategoriaProduto;
	protected JTextField textFieldMarcaProduto;
	protected JTextField textFieldCondicaoProduto;

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
	 * @param title 
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public ExibeProduto() throws ClassNotFoundException, SQLException 
	{
		setTitle("Procura um produto");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 850, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		textFieldProdutoID = new JTextField();
		textFieldProdutoID.setBounds(147, 11, 126, 34);
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
					Categoria c = new Categoria();
					
					p.setId(Integer.parseInt(textFieldProdutoID.getText()));
					
					p = pc.findOneProduto(p);
					c = cc.findOneCategoria(p.getId_categoria());
					
					textFieldNomeProduto.setText(p.getNome());
					textFieldNomeCategoria.setText(c.getNome());
					textFieldCorProduto.setText(p.getCor());
					comboBoxCategoriaProduto.setSelectedIndex(p.getId_categoria());
					textAreaDescricaoProduto.setText(p.getDescricao());
					textFieldMarcaProduto.setText(p.getMarca());
					textFieldCondicaoProduto.setText(p.getCondicao());
					
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
		btnBuscar.setBounds(305, 11, 87, 34);
		contentPane.add(btnBuscar);
		
		textFieldNomeProduto = new JTextField();
		textFieldNomeProduto.setEditable(false);
		textFieldNomeProduto.setEditable(false);
		textFieldNomeProduto.setBounds(34, 84, 340, 34);
		contentPane.add(textFieldNomeProduto);
		textFieldNomeProduto.setColumns(10);
		
		textFieldNomeCategoria = new JTextField();
		textFieldNomeCategoria.setEditable(false);
		textFieldNomeCategoria.setBounds(437, 84, 372, 34);
		contentPane.add(textFieldNomeCategoria);
		textFieldNomeCategoria.setColumns(10);
		
		textFieldCorProduto = new JTextField();
		textFieldCorProduto.setEditable(false);
		textFieldCorProduto.setBounds(34, 173, 233, 34);
		contentPane.add(textFieldCorProduto);
		
		textAreaDescricaoProduto = new JTextArea();
		textAreaDescricaoProduto.setEditable(false);
		textAreaDescricaoProduto.setBounds(34, 313, 775, 173);
		textAreaDescricaoProduto.setColumns(10);
		contentPane.add(textAreaDescricaoProduto);
		
		lblNomeProduto = new JLabel("Produto:");
		lblNomeProduto.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNomeProduto.setBounds(34, 58, 63, 14);
		contentPane.add(lblNomeProduto);
		
		lblCategoria = new JLabel("Categoria:");
		lblCategoria.setFont(new Font("Arial", Font.PLAIN, 14));
		lblCategoria.setBounds(437, 58, 126, 14);
		contentPane.add(lblCategoria);
		
		
		lblProdutoID = new JLabel("Id do Produto:");
		lblProdutoID.setFont(new Font("Arial", Font.PLAIN, 14));
		lblProdutoID.setBounds(33, 21, 120, 14);
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
		btnMenu.setBounds(731, 11, 78, 34);
		contentPane.add(btnMenu);
		
		lblDesc = new JLabel("Descrição:");
		lblDesc.setFont(new Font("Arial", Font.PLAIN, 14));
		lblDesc.setBounds(33, 276, 100, 14);
		contentPane.add(lblDesc);
		
		btnEnviar = new JButton("Enviar");
		btnEnviar.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				try 
				{
					Produto p = new Produto();
					Categoria c = (Categoria) comboBoxCategoriaProduto.getSelectedItem();
					String condicao = (String) comboBoxCondicaoProduto.getSelectedItem();
					
					p.setId(Integer.parseInt(textFieldProdutoID.getText()));
					p.setNome(textFieldNomeProduto.getText());
					p.setDescricao(textAreaDescricaoProduto.getText());
					p.setId_categoria(c.getId());
					p.setCor(textFieldCorProduto.getText());
					p.setMarca(textFieldMarcaProduto.getText());
					p.setCondicao(condicao);
					
					pc.updateProduto(p);
					JOptionPane.showMessageDialog(null,
		                    "Produto Atualizado com Sucesso",
		                    "SUCESSO",
		                    JOptionPane.INFORMATION_MESSAGE);
					
					limpaCampos();
					
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
		btnEnviar.setBounds(709, 506, 100, 30);
		btnEnviar.setVisible(false);
		contentPane.add(btnEnviar);
		
		comboBoxCategoriaProduto = new JComboBox<>();
		comboBoxCategoriaProduto.setBounds(437, 84, 372, 34);
		contentPane.add(comboBoxCategoriaProduto);
		
		JLabel lblCorProduto = new JLabel("Cor:");
		lblCorProduto.setFont(new Font("Arial", Font.PLAIN, 14));
		lblCorProduto.setBounds(34, 151, 63, 14);
		contentPane.add(lblCorProduto);
		
		textFieldMarcaProduto = new JTextField();
		textFieldMarcaProduto.setEditable(false);
		textFieldMarcaProduto.setBounds(305, 173, 239, 34);
		contentPane.add(textFieldMarcaProduto);
		
		textFieldCondicaoProduto = new JTextField();
		textFieldCondicaoProduto.setEditable(false);
		textFieldCondicaoProduto.setBounds(576, 173, 233, 34);
		contentPane.add(textFieldCondicaoProduto);
		
		JLabel lblMarcaProduto = new JLabel("Marca:");
		lblMarcaProduto.setFont(new Font("Arial", Font.PLAIN, 14));
		lblMarcaProduto.setBounds(305, 152, 63, 14);
		contentPane.add(lblMarcaProduto);
		
		comboBoxCondicaoProduto = new JComboBox<String>();
		comboBoxCondicaoProduto.setFont(new Font("Arial", Font.PLAIN, 12));
		comboBoxCondicaoProduto.setModel(new DefaultComboBoxModel<>(new String[] {"USADO", "NOVO", "SEMI-NOVO"}));
		comboBoxCondicaoProduto.setBounds(576, 173, 233, 34);
		comboBoxCondicaoProduto.setVisible(false);
		contentPane.add(comboBoxCondicaoProduto);
		
		JLabel lblCondicaoProduto = new JLabel("Condicao:");
		lblCondicaoProduto.setFont(new Font("Arial", Font.PLAIN, 14));
		lblCondicaoProduto.setBounds(576, 151, 87, 14);
		contentPane.add(lblCondicaoProduto);
		carregarCategorias();
		
		
	}
	private void carregarCategorias() throws ClassNotFoundException, SQLException
	{
		CategoriaController catCtr = new CategoriaController();
		List<Categoria> categorias = catCtr.findAllCategoria();
        for (Categoria c : categorias) 
        {
            comboBoxCategoriaProduto.addItem(c);
        }

        if (comboBoxCategoriaProduto.getItemCount() > 0) 
        {
            comboBoxCategoriaProduto.setSelectedIndex(0);
        }
	}
	private void limpaCampos()
	{
		textFieldNomeProduto.setText("");
		textFieldMarcaProduto.setText("");
		textFieldCorProduto.setText("");
		textAreaDescricaoProduto.setText("");
		comboBoxCondicaoProduto.setSelectedIndex(-1);
		comboBoxCategoriaProduto.setSelectedIndex(-1);
	}
}
