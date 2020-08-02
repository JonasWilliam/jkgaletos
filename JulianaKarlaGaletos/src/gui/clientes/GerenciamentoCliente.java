package gui.clientes;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import gui.TelaPrincipal;
import gui.produtos.AlterarValor;
import gui.produtos.CadastroProduto;
import gui.produtos.ProcurarProduto;
import gui.produtos.ProdutoTableModel;
import negocios.Cliente;
import negocios.Fachada;
import negocios.Produto;


public class GerenciamentoCliente extends JFrame {

	private JPanel contentPane;
	private JButton btnNewButton;
	private JTextField textField;
	private JLabel lblNewLabel_1;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;
	private JButton btnNewButton_3;
	private JButton btnNewButton_4;
	ClienteTableModel modelo = new ClienteTableModel();
	private static JFrame telaGerenciamentoClienteinstance;
	
	public static JFrame getInstance() {
		if (GerenciamentoCliente.telaGerenciamentoClienteinstance == null)
			GerenciamentoCliente.telaGerenciamentoClienteinstance = new GerenciamentoCliente();

		return GerenciamentoCliente.telaGerenciamentoClienteinstance;

	}
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GerenciamentoCliente frame = new GerenciamentoCliente();
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
	public GerenciamentoCliente() {
		
		modelo.limparLista();
		Cliente[] clientes = Fachada.getInstance().listarClientes();
		for(int i = 0; i < clientes.length;i++) {
			if(clientes[i] != null) {
				modelo.addRow(clientes[i]);
			}
		}
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 615, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Gerenciamento de Clientes");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 35));
		lblNewLabel.setBounds(41, 11, 484, 50);
		contentPane.add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 87, 564, 158);
		contentPane.add(scrollPane);
		
		JTable table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(modelo);
		
		btnNewButton = new JButton("Procurar");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				modelo.limparLista();
				if(textField.getText().equals("")) {
					modelo.limparLista();
					Cliente[] clientes = Fachada.getInstance().listarClientes();
					for(int i = 0; i < clientes.length;i++) {
						if(clientes[i] != null) {
							modelo.addRow(clientes[i]);
						}
					}
				}
					
				else {

					Cliente achouCliente = Fachada.getInstance().procurarClientes(textField.getText());
					 if(achouCliente == null){
						 JOptionPane.showMessageDialog(null, "Cliente não existe.");
						 textField.setText("");
					 }else{
						 JOptionPane.showMessageDialog(null, "Cliente existe.");
						
						 modelo.addRow(achouCliente);
						 textField.setText("");
					 }
					 
				}
				
			}
		});
		btnNewButton.setBounds(304, 270, 89, 23);
		contentPane.add(btnNewButton);
		
		textField = new JTextField();
		textField.setBounds(154, 271, 119, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		lblNewLabel_1 = new JLabel("Informe o Telefone:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1.setForeground(Color.BLACK);
		lblNewLabel_1.setBounds(10, 269, 134, 23);
		contentPane.add(lblNewLabel_1);
		
		btnNewButton_1 = new JButton("Voltar");
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				TelaPrincipal.getInstance().setVisible(true);
			}
		});
		btnNewButton_1.setBounds(516, 310, 73, 23);
		contentPane.add(btnNewButton_1);
		
		btnNewButton_2 = new JButton("Remover\r\n");
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (textField.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Digite o Telefone do Cliente que deseja remover");
					textField.setText("");
				} else {
					Cliente c = new Cliente();
					c = Fachada.getInstance().procurarClientes(textField.getText());
					if (c == null) {
						JOptionPane.showMessageDialog(null, "Nao existe nenhum Cliente com esse Telefone");
						textField.setText("");
					} else {
						Fachada.getInstance().removerCliente(textField.getText());
						JOptionPane.showMessageDialog(null, "Cliente removido com sucesso");
						telaGerenciamentoClienteinstance = null;
						dispose();
						GerenciamentoCliente.getInstance().setVisible(true);
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
				CadastroCliente.getInstance().setVisible(true);
			}
		});
		btnNewButton_3.setBounds(414, 270, 89, 23);
		contentPane.add(btnNewButton_3);
		
		btnNewButton_4 = new JButton("Alterar");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				TelaAlterarCliente.getInstance().setVisible(true);
			}
		});
		btnNewButton_4.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton_4.setBounds(414, 310, 89, 23);
		contentPane.add(btnNewButton_4);
	}

}
