package gui.produtos;

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
import negocios.Fachada;
import negocios.Produto;

public class AlterarValor extends JFrame {

	private JPanel contentPane;
	private static JFrame telaAlterarProdutoinstance;
	private JTextField textFieldNome;
	private JTextField textFieldValor;
	private JTextField textFieldId;
	Produto p = new Produto();
	private JTextField textFieldAlterar;
	
	public static JFrame getInstance() {
		if (AlterarValor.telaAlterarProdutoinstance == null)
			AlterarValor.telaAlterarProdutoinstance = new AlterarValor();

		return AlterarValor.telaAlterarProdutoinstance;

	}
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AlterarValor frame = new AlterarValor();
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
	public AlterarValor() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Alterar Produto");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 35));
		lblNewLabel.setBounds(143, 11, 327, 50);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Informe o Nome: ");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setBounds(20, 195, 168, 21);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Informe o Valor:\r\n");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2.setBounds(20, 227, 118, 21);
		contentPane.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("Informe o Id:\r\n");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_3.setBounds(20, 259, 118, 14);
		contentPane.add(lblNewLabel_3);

		textFieldNome = new JTextField();
		textFieldNome.setEditable(false);
		textFieldNome.setBounds(155, 190, 315, 20);
		contentPane.add(textFieldNome);
		textFieldNome.setColumns(10);

		textFieldValor = new JTextField();
		textFieldValor.setBounds(155, 227, 315, 20);
		contentPane.add(textFieldValor);
		textFieldValor.setColumns(10);

		textFieldId = new JTextField();
		textFieldId.setEditable(false);
		textFieldId.setBounds(155, 258, 315, 20);
		contentPane.add(textFieldId);
		textFieldId.setColumns(10);

		JButton btnNewButton = new JButton("Alterar\r\n");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Fachada.getInstance().alterarValor(textFieldId.getText(),Float.parseFloat(textFieldValor.getText()));
				JOptionPane.showMessageDialog(null, "Valor alterado com sucesso");
				dispose();
				TelaPrincipal.getInstance().setVisible(true);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.setBounds(155, 314, 118, 23);
		contentPane.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Reset");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textFieldNome.setText("");
				textFieldId.setText("");
				textFieldValor.setText("");
				textFieldAlterar.setText("");
				
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton_1.setBounds(283, 314, 89, 23);
		contentPane.add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("Voltar");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					dispose();
					TelaPrincipal.getInstance().setVisible(true);
				
			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton_2.setBounds(381, 313, 89, 25);
		contentPane.add(btnNewButton_2);
		
		JLabel lblNewLabel_4 = new JLabel("Informe o c\u00F3digo do Produto:");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_4.setBounds(20, 103, 253, 21);
		contentPane.add(lblNewLabel_4);
		
		textFieldAlterar = new JTextField();
		textFieldAlterar.setBounds(283, 105, 187, 20);
		contentPane.add(textFieldAlterar);
		textFieldAlterar.setColumns(10);
		
		JButton btnNewButton_3 = new JButton("Procurar");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				if(textFieldAlterar.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Digite o Nome do Produto.");
				}
					
				else {

					Produto achouProduto = Fachada.getInstance().procurarProduto(textFieldAlterar.getText());
					 if(achouProduto == null){
						 JOptionPane.showMessageDialog(null, "Produto não existe.");
					 }else{
						 JOptionPane.showMessageDialog(null, "Produto existe.");
						
						textFieldNome.setText(achouProduto.getNome());
						textFieldId.setText(achouProduto.getId());
						textFieldValor.setText("");
					 }
					 
				}
			}
		});
		btnNewButton_3.setBounds(283, 145, 89, 23);
		contentPane.add(btnNewButton_3);
	}

}
