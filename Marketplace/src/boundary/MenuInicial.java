package boundary;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MenuInicial extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuInicial frame = new MenuInicial();
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
	 */
	public MenuInicial() {
		setTitle("Menu principal");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 830, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Cadastrar Produto");
		btnNewButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				CadastroProduto tela;
				try 
				{
					tela = new CadastroProduto();
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
		btnNewButton.setBounds(279, 119, 224, 33);
		contentPane.add(btnNewButton);
		
		JButton btnAcharUmProduto = new JButton("Achar um produto");
		btnAcharUmProduto.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				ExibeProduto tela;
				try 
				{
					tela = new ExibeProduto();
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
		btnAcharUmProduto.setBounds(279, 198, 224, 33);
		contentPane.add(btnAcharUmProduto);
		
		JButton btnVisualizarTodosOs = new JButton("Visualizar todos os produtos");
		btnVisualizarTodosOs.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				ListaProduto tela;
				try 
				{
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
		btnVisualizarTodosOs.setBounds(279, 280, 230, 33);
		contentPane.add(btnVisualizarTodosOs);

	}

}
