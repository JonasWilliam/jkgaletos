package gui.produtos;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import gui.TelaPrincipal;
import negocios.Fachada;
import negocios.Produto;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.event.AncestorListener;
import javax.swing.event.AncestorEvent;

public class ListarProdutos extends JFrame {

	private JPanel contentPane;
	private static JFrame telaListarProdutoinstance;
	private JTable table;
	ProdutoTableModel modelo = new ProdutoTableModel();
	private JButton btnNewButton;
	private JButton btnNewButton_1;

	public static JFrame getInstance() {
		if (ListarProdutos.telaListarProdutoinstance == null)
			ListarProdutos.telaListarProdutoinstance = new ListarProdutos();

		return ListarProdutos.telaListarProdutoinstance;

	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListarProdutos frame = new ListarProdutos();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ListarProdutos() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Lista de Produtos");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 35));
		lblNewLabel.setBounds(121, 11, 327, 50);
		contentPane.add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 87, 564, 158);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(modelo);
		table.setFont(new Font("Serif", Font.PLAIN, 16));
		
		btnNewButton = new JButton("Listar Todos");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				modelo.limparLista();
				Produto[] produtos = Fachada.getInstance().listarProdutos();
				for(int i = 0; i < produtos.length;i++) {
					if(produtos[i] != null) {
						modelo.addRow(produtos[i]);
					}
				}
				
			
			}
		});
		btnNewButton.setBounds(58, 276, 132, 23);
		contentPane.add(btnNewButton);
		
		btnNewButton_1 = new JButton("Voltar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				TelaPrincipal.getInstance().setVisible(true);
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_1.setBounds(392, 276, 89, 23);
		contentPane.add(btnNewButton_1);
	}

}
