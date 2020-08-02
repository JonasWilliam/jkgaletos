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
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.Color;

public class ProcurarProduto extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JButton btnNewButton;
	private JTextField textField;
	private JLabel lblNewLabel_1;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;
	private JButton btnNewButton_3;
	private JButton btnNewButton_4;
	
	ProdutoTableModel modelo = new ProdutoTableModel();
	private static JFrame telaProcurarProdutoinstance;
	
	public static JFrame getInstance() {
		if (ProcurarProduto.telaProcurarProdutoinstance == null)
			ProcurarProduto.telaProcurarProdutoinstance = new ProcurarProduto();

		return ProcurarProduto.telaProcurarProdutoinstance;

	}
	


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProcurarProduto frame = new ProcurarProduto();
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
	public ProcurarProduto() {
		
		modelo.limparLista();
		Produto[] produtos = Fachada.getInstance().listarProdutos();
		for(int i = 0; i < produtos.length;i++) {
			if(produtos[i] != null) {
				modelo.addRow(produtos[i]);
			}
		}
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 621, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Altera\u00E7\u00E3o Produto");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 35));
		lblNewLabel.setBounds(126, 11, 324, 50);
		contentPane.add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 87, 564, 158);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(modelo);
		
		btnNewButton = new JButton("Procurar");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				modelo.limparLista();
				if(textField.getText().equals("")) {
					modelo.limparLista();
					Produto[] produtos = Fachada.getInstance().listarProdutos();
					for(int i = 0; i < produtos.length;i++) {
						if(produtos[i] != null) {
							modelo.addRow(produtos[i]);
						}
					}
				}
					
				else {

					Produto achouProduto = Fachada.getInstance().procurarProduto(textField.getText());
					 if(achouProduto == null){
						 JOptionPane.showMessageDialog(null, "Produto não existe.");
						 textField.setText("");
					 }else{
						 JOptionPane.showMessageDialog(null, "Produto existe.");
						
						 modelo.addRow(achouProduto);
						 textField.setText("");
					 }
					 
				}
				
			}
		});
		btnNewButton.setBounds(304, 270, 89, 23);
		contentPane.add(btnNewButton);
		
		textField = new JTextField();
		textField.setBounds(147, 271, 126, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		lblNewLabel_1 = new JLabel("Informe o Codigo:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1.setForeground(Color.BLACK);
		lblNewLabel_1.setBounds(10, 269, 115, 23);
		contentPane.add(lblNewLabel_1);
		
		btnNewButton_1 = new JButton("Voltar");
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				TelaPrincipal.getInstance().setVisible(true);
			}
		});
		btnNewButton_1.setBounds(516, 310, 79, 23);
		contentPane.add(btnNewButton_1);
		
		btnNewButton_2 = new JButton("Remover\r\n");
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (textField.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Digite o Codigo do Produto que deseja remover");
					textField.setText("");
				} else {
					Produto p = new Produto();
					p = Fachada.getInstance().procurarProduto(textField.getText());
					if (p == null) {
						JOptionPane.showMessageDialog(null, "Nao existe nenhum Produto com esse codigo");
						textField.setText("");
					} else {
						Fachada.getInstance().removerProduto(textField.getText());
						JOptionPane.showMessageDialog(null, "Produto removido com sucesso");
						telaProcurarProdutoinstance = null;
						dispose();
						ProcurarProduto.getInstance().setVisible(true);
						textField.setText("");
					}
				}
			}
		});
		btnNewButton_2.setBounds(304, 310, 89, 23);
		contentPane.add(btnNewButton_2);
		
		btnNewButton_3 = new JButton("Adicionar");
		btnNewButton_3.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				CadastroProduto.getInstance().setVisible(true);
			}
		});
		btnNewButton_3.setBounds(414, 270, 89, 23);
		contentPane.add(btnNewButton_3);
		
		btnNewButton_4 = new JButton("Alterar");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				AlterarValor.getInstance().setVisible(true);
			}
		});
		btnNewButton_4.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton_4.setBounds(414, 310, 89, 23);
		contentPane.add(btnNewButton_4);
	}
}
