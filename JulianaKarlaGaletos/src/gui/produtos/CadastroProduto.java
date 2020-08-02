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
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CadastroProduto extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldNome;
	private JTextField textFieldValor;
	private JTextField textFieldId;
	private static JFrame CadastroProdutointance;
	Produto p = new Produto();

	/**
	 * Launch the application.
	 */
	public static JFrame getInstance() {
		if (CadastroProduto.CadastroProdutointance == null)
			CadastroProduto.CadastroProdutointance = new CadastroProduto();

		return CadastroProduto.CadastroProdutointance;

	}

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
	 */
	public CadastroProduto() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 475, 292);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel(" Cadastro Produto");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 35));
		lblNewLabel.setBounds(60, 11, 327, 50);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Informe o Nome: ");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setBounds(20, 100, 131, 21);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Informe o Valor:\r\n");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2.setBounds(20, 130, 118, 21);
		contentPane.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("Informe o Id:\r\n");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_3.setBounds(20, 160, 118, 14);
		contentPane.add(lblNewLabel_3);

		textFieldNome = new JTextField();
		textFieldNome.setBounds(155, 105, 270, 20);
		contentPane.add(textFieldNome);
		textFieldNome.setColumns(10);

		textFieldValor = new JTextField();
		textFieldValor.setBounds(155, 130, 270, 20);
		contentPane.add(textFieldValor);
		textFieldValor.setColumns(10);

		textFieldId = new JTextField();
		textFieldId.setBounds(155, 160, 270, 20);
		contentPane.add(textFieldId);
		textFieldId.setColumns(10);

		JButton btnNewButton = new JButton("Cadastrar\r\n");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				p.setId(textFieldId.getText());
				p.setValor(Float.parseFloat(textFieldValor.getText()));
				p.setNome(textFieldNome.getText());
				Produto p1;
				p1 = Fachada.getInstance().procurarProduto(textFieldId.getText());
				if (p1 == null) {
					Fachada.getInstance().cadastrarProduto(p);
					JOptionPane.showMessageDialog(null, "Novo Produto adicionado ao repositorio com sucesso");
					textFieldNome.setText("");
					textFieldId.setText("");
					textFieldValor.setText("");
					CadastroProdutointance = null;
					dispose();
					TelaPrincipal.getInstance().setVisible(true);
					
				} else {
					JOptionPane.showMessageDialog(null, "Já existe um Produto adicionado ao repositorio com esse Código.");
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.setBounds(207, 208, 118, 23);
		contentPane.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Reset");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textFieldNome.setText("");
				textFieldId.setText("");
				textFieldValor.setText("");
				CadastroProduto.getInstance().setVisible(true);
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton_1.setBounds(104, 208, 89, 23);
		contentPane.add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("Voltar");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					dispose();
					TelaPrincipal.getInstance().setVisible(true);
				
			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton_2.setBounds(336, 207, 89, 25);
		contentPane.add(btnNewButton_2);
	}
}
