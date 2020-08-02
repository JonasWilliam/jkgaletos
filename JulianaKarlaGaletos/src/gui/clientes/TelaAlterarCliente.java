package gui.clientes;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import gui.TelaPrincipal;
import gui.produtos.AlterarValor;
import negocios.Cliente;
import negocios.Fachada;
import negocios.Produto;

public class TelaAlterarCliente extends JFrame {

	private JPanel contentPane;
	
	private JTextField textFieldtelefone;
	private JTextField textFieldRua;
	private JTextField textFieldNcasa;
	Produto p = new Produto();
	private JTextField textFieldAlterar;
	private JTextField textFieldRef;
	private JTextField textFieldNome;
	
	private static JFrame telaAlterarClienteinstance;
	ClienteTableModel modelo = new ClienteTableModel();
	public static JFrame getInstance() {
		if (TelaAlterarCliente.telaAlterarClienteinstance == null)
			TelaAlterarCliente.telaAlterarClienteinstance = new TelaAlterarCliente();

		return TelaAlterarCliente.telaAlterarClienteinstance;

	}
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaAlterarCliente frame = new TelaAlterarCliente();
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
	public TelaAlterarCliente() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 409);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Alterar Cliente");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 35));
		lblNewLabel.setBounds(143, 11, 327, 50);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Telefone: ");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setBounds(20, 188, 168, 21);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Rua:\r\n");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2.setBounds(20, 220, 118, 21);
		contentPane.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("N\u00FAmero da casa:\r\n");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_3.setBounds(20, 259, 118, 14);
		contentPane.add(lblNewLabel_3);

		textFieldtelefone = new JTextField();
		textFieldtelefone.setEditable(false);
		textFieldtelefone.setBounds(155, 190, 315, 20);
		contentPane.add(textFieldtelefone);
		textFieldtelefone.setColumns(10);

		textFieldRua = new JTextField();
		textFieldRua.setBounds(155, 222, 315, 20);
		contentPane.add(textFieldRua);
		textFieldRua.setColumns(10);

		textFieldNcasa = new JTextField();
		textFieldNcasa.setBounds(155, 258, 315, 20);
		contentPane.add(textFieldNcasa);
		textFieldNcasa.setColumns(10);

		JButton btnNewButton = new JButton("Alterar\r\n");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			Fachada.getInstance().alterarEndereco(textFieldtelefone.getText(), textFieldRua.getText(), textFieldNcasa.getText(), textFieldRef.getText());
			JOptionPane.showMessageDialog(null, "Valor alterado com sucesso");
			dispose();
			TelaPrincipal.getInstance().setVisible(true);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.setBounds(155, 336, 118, 23);
		contentPane.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Reset");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textFieldtelefone.setText("");
				textFieldNcasa.setText("");
				textFieldRua.setText("");
				textFieldAlterar.setText("");
				
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton_1.setBounds(282, 336, 89, 23);
		contentPane.add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("Voltar");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					dispose();
					TelaPrincipal.getInstance().setVisible(true);
				
			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton_2.setBounds(381, 335, 89, 25);
		contentPane.add(btnNewButton_2);
		
		JLabel lblNewLabel_4 = new JLabel("Informe o Telefone do Cliente:");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_4.setBounds(20, 103, 253, 21);
		contentPane.add(lblNewLabel_4);
		
		textFieldAlterar = new JTextField();
		textFieldAlterar.setBounds(283, 105, 187, 20);
		contentPane.add(textFieldAlterar);
		textFieldAlterar.setColumns(10);
		
		JButton btnNewButton_3 = new JButton("Procurar");
		btnNewButton_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				if(textFieldAlterar.getText().equals("")) {
					modelo.limparLista();
					Cliente[] clientes = Fachada.getInstance().listarClientes();
					for(int i = 0; i < clientes.length;i++) {
						if(clientes[i] != null) {
							modelo.addRow(clientes[i]);
						}
					}
				}
					
				else {

					Cliente achouCliente = Fachada.getInstance().procurarClientes(textFieldAlterar.getText());
					 if(achouCliente == null){
						 JOptionPane.showMessageDialog(null, "Cliente não existe.");
						 textFieldAlterar.setText("");
					 }else{
						 JOptionPane.showMessageDialog(null, "Cliente existe.");
						
						 modelo.addRow(achouCliente);
						 textFieldAlterar.setText("");
						 textFieldtelefone.setText(achouCliente.getTelefone());
						 textFieldRua.setText(achouCliente.getEndereco());;
						 textFieldNcasa.setText(achouCliente.getNumCasa()); 
						 textFieldRef.setText(achouCliente.getPontoReferencia());
						 textFieldNome.setText("Clinete: " + achouCliente.getNome());
					 }
					 
				}
				
			}
		});
		btnNewButton_3.setBounds(283, 145, 89, 23);
		contentPane.add(btnNewButton_3);
		
		textFieldRef = new JTextField();
		textFieldRef.setBounds(155, 288, 315, 20);
		contentPane.add(textFieldRef);
		textFieldRef.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("P. de Refer\u00EAncia:\r\n");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_5.setBounds(20, 289, 125, 14);
		contentPane.add(lblNewLabel_5);
		
		textFieldNome = new JTextField();
		textFieldNome.setEditable(false);
		textFieldNome.setFont(new Font("Tahoma", Font.BOLD, 11));
		textFieldNome.setBounds(20, 135, 168, 20);
		contentPane.add(textFieldNome);
		textFieldNome.setColumns(10);
	}
}
