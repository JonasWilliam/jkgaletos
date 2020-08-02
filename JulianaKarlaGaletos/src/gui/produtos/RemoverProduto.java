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

public class RemoverProduto extends JFrame {

	private JPanel contentPane;
	private JTextField textCodigo;
	private static JFrame telaRemoverProdutoinstance;

	public static JFrame getInstance() {
		if (RemoverProduto.telaRemoverProdutoinstance == null)
			RemoverProduto.telaRemoverProdutoinstance = new RemoverProduto();

		return RemoverProduto.telaRemoverProdutoinstance;

	}
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RemoverProduto frame = new RemoverProduto();
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
	public RemoverProduto() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Remover Produto\r\n");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 23));
		lblNewLabel.setBounds(95, 11, 274, 31);
		contentPane.add(lblNewLabel);
		
		textCodigo = new JTextField();
		textCodigo.setBounds(168, 112, 201, 20);
		contentPane.add(textCodigo);
		textCodigo.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Informe o c\u00F3digo:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1.setBounds(30, 115, 128, 14);
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("Remover");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
				if (textCodigo.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Digite o Codigo do Produto que deseja remover");
					textCodigo.setText("");
				} else {
					Produto p = new Produto();
					p = Fachada.getInstance().procurarProduto(textCodigo.getText());
					if (p == null) {
						JOptionPane.showMessageDialog(null, "Nao existe nenhum Produto com esse codigo");
						textCodigo.setText("");
					} else {
						Fachada.getInstance().removerProduto(textCodigo.getText());
						JOptionPane.showMessageDialog(null, "Produto removido com sucesso");
						telaRemoverProdutoinstance = null;
						dispose();
						TelaPrincipal.getInstance().setVisible(true);
						textCodigo.setText("");
					}
				}
			}
			
		});
		btnNewButton.setBounds(81, 197, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Voltar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				TelaPrincipal.getInstance().setVisible(true);
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_1.setBounds(280, 197, 89, 23);
		contentPane.add(btnNewButton_1);
	}
}
