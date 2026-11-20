package boundary;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.CategoriaController;
import controller.ProdutoController;
import entity.Categoria;
import entity.Produto;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;

public class CadastroProduto extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldNomeProduto;
	private JComboBox<Categoria> comboBoxCategoriaProduto;
	private JComboBox<String> comboBoxCondicaoProduto;
	ProdutoController pc = new ProdutoController();
	private JTextField textFieldCorProduto;
	private JTextField textFieldMarcaProduto;
	private JTextArea textAreaDescricaoProduto;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroProduto frame = new CadastroProduto();
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
	public CadastroProduto() throws ClassNotFoundException, SQLException {
		setTitle("Cadastra produtos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 817, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textFieldNomeProduto = new JTextField();
		textFieldNomeProduto.setFont(new Font("Arial", Font.PLAIN, 12));
		textFieldNomeProduto.setBounds(55, 100, 367, 29);
		contentPane.add(textFieldNomeProduto);
		textFieldNomeProduto.setColumns(10);
		
		JLabel lblNomeProduto = new JLabel("Nome:");
		lblNomeProduto.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNomeProduto.setBounds(55, 70, 46, 14);
		contentPane.add(lblNomeProduto);
		
		textAreaDescricaoProduto = new JTextArea();
		textAreaDescricaoProduto.setFont(new Font("Arial", Font.PLAIN, 12));
		textAreaDescricaoProduto.setBounds(55, 294, 702, 153);
		contentPane.add(textAreaDescricaoProduto);
		
		JLabel lblDescricaoProduto = new JLabel("Descrição:");
		lblDescricaoProduto.setFont(new Font("Arial", Font.PLAIN, 14));
		lblDescricaoProduto.setBounds(55, 269, 133, 14);
		contentPane.add(lblDescricaoProduto);
		
		comboBoxCategoriaProduto = new JComboBox<>();
		comboBoxCategoriaProduto.setFont(new Font("Arial", Font.PLAIN, 12));
		comboBoxCategoriaProduto.setBounds(461, 99, 296, 30);
		contentPane.add(comboBoxCategoriaProduto);
		carregarCategorias();
		
		JLabel lblCategoriaProduto = new JLabel("Categoria:");
		lblCategoriaProduto.setFont(new Font("Arial", Font.PLAIN, 14));
		lblCategoriaProduto.setBounds(461, 70, 89, 14);
		contentPane.add(lblCategoriaProduto);
		
		JButton btnNewButton = new JButton("Cadastrar Produto");
		btnNewButton.setFont(new Font("Arial", Font.PLAIN, 12));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try 
				{
					Produto p = new Produto();
					Categoria c = (Categoria) comboBoxCategoriaProduto.getSelectedItem();
					String cond = (String) comboBoxCondicaoProduto.getSelectedItem();
					
					p.setNome(textFieldNomeProduto.getText());
					p.setDescricao(textAreaDescricaoProduto.getText());
					p.setMarca(textFieldMarcaProduto.getText());
					p.setCondicao(cond);
					p.setMarca(textFieldMarcaProduto.getText());
					p.setCor(textFieldCorProduto.getText());
					p.setId_categoria(c.getId());
					
					pc.createProduto(p);
					JOptionPane.showMessageDialog(null,
		                    "Produto Inserido com Sucesso",
		                    "SUCESSO",
		                    JOptionPane.INFORMATION_MESSAGE);
					limpaCampos();
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
		btnNewButton.setBounds(589, 510, 168, 29);
		contentPane.add(btnNewButton);
		
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
		btnMenu.setBounds(681, 11, 76, 34);
		contentPane.add(btnMenu);
		
		comboBoxCondicaoProduto = new JComboBox<String>();
		comboBoxCondicaoProduto.setModel(new DefaultComboBoxModel<>(new String[] {"USADO", "NOVO", "SEMI-NOVO"}));
		comboBoxCondicaoProduto.setFont(new Font("Arial", Font.PLAIN, 12));
		comboBoxCondicaoProduto.setBounds(539, 190, 218, 30);
		contentPane.add(comboBoxCondicaoProduto);
		
		JLabel lblCondicaoProduto = new JLabel("Condição:");
		lblCondicaoProduto.setFont(new Font("Arial", Font.PLAIN, 14));
		lblCondicaoProduto.setBounds(539, 165, 89, 14);
		contentPane.add(lblCondicaoProduto);
		
		textFieldCorProduto = new JTextField();
		textFieldCorProduto.setFont(new Font("Arial", Font.PLAIN, 12));
		textFieldCorProduto.setColumns(10);
		textFieldCorProduto.setBounds(55, 191, 218, 29);
		contentPane.add(textFieldCorProduto);
		
		JLabel lblCorProduto = new JLabel("Cor:");
		lblCorProduto.setFont(new Font("Arial", Font.PLAIN, 14));
		lblCorProduto.setBounds(55, 165, 46, 14);
		contentPane.add(lblCorProduto);
		
		textFieldMarcaProduto = new JTextField();
		textFieldMarcaProduto.setFont(new Font("Arial", Font.PLAIN, 12));
		textFieldMarcaProduto.setColumns(10);
		textFieldMarcaProduto.setBounds(296, 191, 218, 29);
		contentPane.add(textFieldMarcaProduto);
		
		JLabel lblMarcaProduto = new JLabel("Marca:");
		lblMarcaProduto.setFont(new Font("Arial", Font.PLAIN, 14));
		lblMarcaProduto.setBounds(296, 165, 46, 14);
		contentPane.add(lblMarcaProduto);

	}
	
	private void carregarCategorias() throws ClassNotFoundException, SQLException
	{
		CategoriaController catCtr = new CategoriaController();
		List<Categoria> categorias = catCtr.findAllCategoria();
		
	    comboBoxCategoriaProduto.removeAllItems();
        for (Categoria c : categorias) {
            comboBoxCategoriaProduto.addItem(c);
        }

        if (comboBoxCategoriaProduto.getItemCount() > 0) {
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
