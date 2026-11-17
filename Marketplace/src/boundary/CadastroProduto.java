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
	ProdutoController pc = new ProdutoController();


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
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public CadastroProduto() throws ClassNotFoundException, SQLException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 647, 407);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textFieldNomeProduto = new JTextField();
		textFieldNomeProduto.setFont(new Font("Arial", Font.PLAIN, 12));
		textFieldNomeProduto.setBounds(54, 70, 218, 29);
		contentPane.add(textFieldNomeProduto);
		textFieldNomeProduto.setColumns(10);
		
		JLabel lblNomeProduto = new JLabel("Nome:");
		lblNomeProduto.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNomeProduto.setBounds(54, 45, 46, 14);
		contentPane.add(lblNomeProduto);
		
		JTextArea textAreaDescricaoProduto = new JTextArea();
		textAreaDescricaoProduto.setFont(new Font("Arial", Font.PLAIN, 12));
		textAreaDescricaoProduto.setBounds(54, 188, 526, 114);
		contentPane.add(textAreaDescricaoProduto);
		
		JLabel lblDescricaoProduto = new JLabel("Descrição:");
		lblDescricaoProduto.setFont(new Font("Arial", Font.PLAIN, 14));
		lblDescricaoProduto.setBounds(54, 163, 133, 14);
		contentPane.add(lblDescricaoProduto);
		
		comboBoxCategoriaProduto = new JComboBox<>();
		comboBoxCategoriaProduto.setFont(new Font("Arial", Font.PLAIN, 12));
		comboBoxCategoriaProduto.setBounds(362, 70, 218, 30);
		contentPane.add(comboBoxCategoriaProduto);
		carregarCategorias();
		
		JLabel lblCategoriaProduto = new JLabel("Categoria:");
		lblCategoriaProduto.setFont(new Font("Arial", Font.PLAIN, 12));
		lblCategoriaProduto.setBounds(362, 45, 89, 14);
		contentPane.add(lblCategoriaProduto);
		
		JButton btnNewButton = new JButton("Enviar");
		btnNewButton.setFont(new Font("Arial", Font.PLAIN, 11));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try 
				{
					Produto p = new Produto();
					Categoria c = (Categoria) comboBoxCategoriaProduto.getSelectedItem();
					
					p.setNome(textFieldNomeProduto.getText());
					p.setDescricao(textAreaDescricaoProduto.getText());
					p.setId_categoria(c.getId());
					
					pc.createProduto(p);
					JOptionPane.showMessageDialog(null,
		                    "Produto Inserido com Sucesso",
		                    "SUCESSO",
		                    JOptionPane.INFORMATION_MESSAGE);
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
		btnNewButton.setBounds(516, 328, 105, 29);
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
		btnMenu.setBounds(545, 11, 76, 34);
		contentPane.add(btnMenu);

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
}
