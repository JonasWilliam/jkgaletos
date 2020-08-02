package gui.clientes;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import gui.TelaPrincipal;
import gui.produtos.CadastroProduto;
import negocios.Cliente;
import negocios.Fachada;
import negocios.Produto;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CadastroCliente extends JFrame {

	private JPanel contentPane;
	private static JFrame CadastroClienteintance;
	Cliente c = new Cliente();
	private JTextField textFieldNome;
	private JTextField textFieldTelefone;
	private JTextField textFieldEndereco;
	private JTextField textFieldCasa;
	private JTextField textFieldReferencia;
	private JTextField textFieldBairro;

	/**
	 * Launch the application.
	 */
	public static JFrame getInstance() {
		if (CadastroCliente.CadastroClienteintance == null)
			CadastroCliente.CadastroClienteintance = new CadastroCliente();

		return CadastroCliente.CadastroClienteintance;

	}


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroCliente frame = new CadastroCliente();
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
	public CadastroCliente() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 475, 374);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel(" Cadastro Cliente");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 35));
		lblNewLabel.setBounds(60, 11, 327, 50);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Nome: ");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setBounds(20, 100, 168, 21);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Telefone:\r\n\r\n");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2.setBounds(20, 130, 149, 21);
		contentPane.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("Endere\u00E7o:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_3.setBounds(20, 160, 149, 21);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("N\u00B0 da casa:");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		lblNewLabel_4.setBounds(20, 190, 149, 14);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Ponto de Refer\u00EAncia:");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_5.setBounds(20, 220, 149, 14);
		contentPane.add(lblNewLabel_5);
		
		textFieldNome = new JTextField();
		textFieldNome.setBounds(179, 100, 245, 20);
		contentPane.add(textFieldNome);
		textFieldNome.setColumns(10);
		
		textFieldTelefone = new JTextField();
		textFieldTelefone.setBounds(179, 130, 245, 20);
		contentPane.add(textFieldTelefone);
		textFieldTelefone.setColumns(10);
		
		textFieldEndereco = new JTextField();
		textFieldEndereco.setBounds(179, 160, 245, 20);
		contentPane.add(textFieldEndereco);
		textFieldEndereco.setColumns(10);
		
		textFieldCasa = new JTextField();
		textFieldCasa.setBounds(179, 190, 245, 20);
		contentPane.add(textFieldCasa);
		textFieldCasa.setColumns(10);
		
		textFieldReferencia = new JTextField();
		textFieldReferencia.setBounds(179, 220, 245, 20);
		contentPane.add(textFieldReferencia);
		textFieldReferencia.setColumns(10);
		
		JButton btnNewButton = new JButton("Reset");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textFieldNome.setText("");
				textFieldTelefone.setText("");
				textFieldEndereco.setText("");
				textFieldCasa.setText("");
				textFieldReferencia.setText("");
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.setBounds(99, 300, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Cadastrar\r\n");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				c.setNome(textFieldNome.getText());
				c.setEndereco(textFieldEndereco.getText());
				c.setTelefone(textFieldTelefone.getText());
				c.setNumCasa(textFieldCasa.getText());
				c.setPontoReferencia(textFieldReferencia.getText());
				c.setBairro(textFieldBairro.getText());
				Cliente c1;
				c1 = Fachada.getInstance().procurarClientes(textFieldTelefone.getText());
				if (c1 == null) {
					Fachada.getInstance().cadastrarCliente(c);
					JOptionPane.showMessageDialog(null, "Novo Cliente Cadastrado com sucesso");
					textFieldNome.setText("");
					textFieldTelefone.setText("");
					textFieldEndereco.setText("");
					textFieldCasa.setText("");
					textFieldReferencia.setText("");
					textFieldBairro.setText("");
					CadastroClienteintance = null;
					
				} else {
					JOptionPane.showMessageDialog(null, "Já existe um Cliente adicionado ao repositorio com esse Telefone.");
				}
			}
			
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton_1.setBounds(207, 299, 105, 25);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Voltar");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				TelaPrincipal.getInstance().setVisible(true);
			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton_2.setBounds(335, 298, 89, 25);
		contentPane.add(btnNewButton_2);
		
		textFieldBairro = new JTextField();
		textFieldBairro.setBounds(178, 250, 246, 20);
		contentPane.add(textFieldBairro);
		textFieldBairro.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Bairro:");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_6.setBounds(20, 250, 98, 14);
		contentPane.add(lblNewLabel_6);
		
		
	}
}
