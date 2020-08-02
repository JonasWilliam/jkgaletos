package gui.pedidos;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import gui.TelaPrincipal;
import gui.clientes.ClienteTableModel;
import gui.clientes.TelaAlterarCliente;
import gui.produtos.ProdutoTableModel;
import negocios.Cliente;
import negocios.Fachada;
import negocios.Pedido;
import negocios.Produto;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;

import javax.print.DocFlavor;
import javax.print.DocPrintJob;
import javax.print.PrintException;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.print.SimpleDoc;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;
import javax.print.attribute.standard.JobName;
import javax.print.attribute.standard.MediaSizeName;
import javax.print.attribute.standard.OrientationRequested;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Color;
import javax.swing.JCheckBox;

public class CadastroPedido extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textFieldNome;
	private JTextField textFieldRua;
	private JTextField textFieldRef;
	private JTextField textFieldNcasa;
	private static JFrame telaCadastroPedidoinstance;
	ClienteTableModel modelo = new ClienteTableModel();
	private JTable table;
	ProdutoTableModel modelo1 = new ProdutoTableModel();
	private JTextField textFieldProduto;
	ArrayList<Produto> produtos = new ArrayList<Produto>();
	private JTextField textFieldTotal;
	private JTextField txtQtd;
	Pedido p1 = new Pedido();
	private JTextField textFieldBairro;
	private JTextField textFieldTaxa;
	private JTextField textFieldTroco;
	private JTextField observacao;
	private JTextField textHora;

	public static JFrame getInstance() {
		if (CadastroPedido.telaCadastroPedidoinstance == null)
			CadastroPedido.telaCadastroPedidoinstance = new CadastroPedido();

		return CadastroPedido.telaCadastroPedidoinstance;

	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroPedido frame = new CadastroPedido();
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
	public CadastroPedido() {

		/*
		 * Produto[] produtos = Fachada.getInstance().listarProdutos(); for(int i = 0; i
		 * < produtos.length;i++) { if(produtos[i] != null) {
		 * modelo1.addRow(produtos[i]); } }
		 */
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 886, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Novo Pedido");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 50));
		lblNewLabel.setBounds(282, 0, 324, 70);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Telefone do Cliente:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setBounds(21, 113, 151, 24);
		contentPane.add(lblNewLabel_1);

		JButton btnNewButton = new JButton("Buscar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				if (textField.getText().equals("")) {
					modelo.limparLista();
					Cliente[] clientes = Fachada.getInstance().listarClientes();
					for (int i = 0; i < clientes.length; i++) {
						if (clientes[i] != null) {
							modelo.addRow(clientes[i]);
						}
					}
				}

				else {

					Cliente achouCliente = Fachada.getInstance().procurarClientes(textField.getText());
					if (achouCliente == null) {
						JOptionPane.showMessageDialog(null, "Cliente não existe.");
						
					} else {
						JOptionPane.showMessageDialog(null, "Cliente existe.");

						// modelo.addRow(achouCliente);
						
						textFieldRua.setText(achouCliente.getEndereco());
						;
						textFieldNcasa.setText(achouCliente.getNumCasa());
						textFieldRef.setText(achouCliente.getPontoReferencia());
						textFieldNome.setText("Cliente: " + achouCliente.getNome());
						textFieldBairro.setText(achouCliente.getBairro());
					}

				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton.setBounds(343, 116, 89, 23);
		contentPane.add(btnNewButton);

		textField = new JTextField();
		textField.setBounds(176, 117, 141, 20);
		contentPane.add(textField);
		textField.setColumns(10);

		textFieldNome = new JTextField();
		textFieldNome.setEditable(false);
		textFieldNome.setBounds(142, 173, 141, 20);
		contentPane.add(textFieldNome);
		textFieldNome.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("Nome:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_2.setBounds(26, 173, 129, 14);
		contentPane.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("Rua:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_3.setBounds(30, 203, 46, 24);
		contentPane.add(lblNewLabel_3);

		textFieldRua = new JTextField();
		textFieldRua.setEditable(false);
		textFieldRua.setBounds(142, 203, 141, 20);
		contentPane.add(textFieldRua);
		textFieldRua.setColumns(10);

		textFieldRef = new JTextField();
		textFieldRef.setEditable(false);
		textFieldRef.setBounds(142, 233, 141, 20);
		contentPane.add(textFieldRef);
		textFieldRef.setColumns(10);

		JLabel lblNewLabel_4 = new JLabel("P. Refer\u00EAncia:");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_4.setBounds(30, 233, 102, 14);
		contentPane.add(lblNewLabel_4);

		JLabel lblNewLabel_5 = new JLabel("N\u00B0 Casa:");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_5.setBounds(30, 263, 67, 14);
		contentPane.add(lblNewLabel_5);

		textFieldNcasa = new JTextField();
		textFieldNcasa.setEditable(false);
		textFieldNcasa.setBounds(142, 263, 141, 20);
		contentPane.add(textFieldNcasa);
		textFieldNcasa.setColumns(10);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setEnabled(false);
		scrollPane.setBounds(458, 168, 387, 193);
		contentPane.add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(modelo1);

		JLabel lblNewLabel_6 = new JLabel("Lista de Produtos:");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_6.setBounds(458, 113, 387, 24);
		contentPane.add(lblNewLabel_6);

		textFieldProduto = new JTextField();
		textFieldProduto.setBounds(633, 387, 107, 20);
		contentPane.add(textFieldProduto);
		textFieldProduto.setColumns(10);

		JButton btnNewButton_1 = new JButton("Add");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Produto p;
				p = Fachada.getInstance().procurarProduto(textFieldProduto.getText());
				if (textFieldProduto.getText().equals("") || textFieldProduto.getText().equals(null)) {
					JOptionPane.showMessageDialog(null, "informe um codigo");
				} else if (textFieldProduto.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "informe uma Quantidade");
				}

				else if (p == null) {
					JOptionPane.showMessageDialog(null, "Produto não existe");
				} else {
					if (produtos.contains(p)) {
						p.setQuantidade(p.getQuantidade() + Integer.parseInt(txtQtd.getText()));
						textFieldProduto.setText("");
						txtQtd.setText("");
						modelo1.limparLista();
						for (int i = 0; i < produtos.size(); i++) {
							if (produtos.get(i) != null) {
								modelo1.addRow(produtos.get(i));
							}

						}
					} else {
						modelo1.addRow(p);
						p.setQuantidade(Integer.parseInt(txtQtd.getText()));
						produtos.add(p);
						textFieldProduto.setText("");
						txtQtd.setText("");
					}
				}

			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_1.setBounds(756, 384, 89, 23);
		contentPane.add(btnNewButton_1);

		JLabel lblNewLabel_7 = new JLabel("Id:");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_7.setBounds(586, 387, 46, 14);
		contentPane.add(lblNewLabel_7);

		JLabel lblNewLabel_8 = new JLabel("Total:");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_8.setBounds(21, 511, 107, 25);
		contentPane.add(lblNewLabel_8);

		textFieldTotal = new JTextField();
		textFieldTotal.setEditable(false);
		textFieldTotal.setBounds(142, 514, 86, 25);
		contentPane.add(textFieldTotal);
		textFieldTotal.setColumns(10);

		JLabel lblNewLabel_9 = new JLabel("Qtd:");
		lblNewLabel_9.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_9.setBounds(458, 387, 46, 14);
		contentPane.add(lblNewLabel_9);

		txtQtd = new JTextField();
		txtQtd.setBounds(499, 387, 67, 20);
		contentPane.add(txtQtd);
		txtQtd.setColumns(10);

		JCheckBox cartao = new JCheckBox("Cart\u00E3o");
		cartao.setFont(new Font("Tahoma", Font.BOLD, 14));
		cartao.setBounds(21, 394, 97, 23);
		contentPane.add(cartao);

		JButton btnNewButton_3 = new JButton("Confirmar");
		btnNewButton_3.setBackground(Color.GREEN);
		btnNewButton_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Cliente achouCliente = Fachada.getInstance().procurarClientes(textField.getText());
				p1 = new Pedido(achouCliente, produtos, 2, 10);
				System.out.print("gg");
				if (textFieldTaxa.equals("") || textFieldTaxa.equals(null)) {
					JOptionPane.showMessageDialog(null, "informe o valor da taxa de Entrega.");
				}
				imprimirCupom(achouCliente, produtos);
				/*
				 * if(textFieldTaxa.getText().equals("null")) {
				 * JOptionPane.showMessageDialog(null, "informe o valor da taxa de Entrega."); }
				 */
			}

			private void imprimirCupom(Cliente achouCliente, ArrayList<Produto> produtos) {
				Date data = new Date();
				SimpleDateFormat formatar = new SimpleDateFormat("dd/MM/yyyy H:mm");
				String dataFormatada = formatar.format(data);
				Float total = (float) 0;
				String conteudoImprimir = "";
				String hora= textHora.getText();
				String obs = observacao.getText();
				
				for (int i = 0; i < produtos.size(); i++) {
					conteudoImprimir += produtos.get(i).getQuantidade() + "       " + produtos.get(i).getValor()
							+ "     " + produtos.get(i).getNome() + "\n\r";

				}
				for (int i = 0; i < produtos.size(); i++) {
					total += produtos.get(i).getValor() * produtos.get(i).getQuantidade();
				}
				if (textFieldTaxa.equals("") || textFieldTaxa.equals(null)) {
					JOptionPane.showMessageDialog(null, "informe o valor da taxa de Entrega.");
				} else {
					if (cartao.isSelected()) {
						total = total + Float.parseFloat(textFieldTaxa.getText()) + 1;
					} else {
						total = total + Float.parseFloat(textFieldTaxa.getText());
					}
				}
				String total1 = total + "";
				textFieldTotal.setText(total1);
				Float troco = null;
				String metPagamento = "";
				String troco1= "";
				
				
				if (cartao.isSelected()) {
					metPagamento = "Cartão, Taxa de R$1.0";

				} else {
					
					troco = Float.parseFloat(textFieldTroco.getText()) - total;
					troco1 = troco+"";
					metPagamento = "Troco para: R$" + textFieldTroco.getText() + "\n\rTroco: R$" + troco1;
					
				}
				/*
				 * String endereco = "Rua:" + textFieldRua.getText() + "\n\r" +
				 * "Número da casa: " + achouCliente.getNumCasa() + "\n\r" +
				 * "Ponto de referência: " + achouCliente.getPontoReferencia() + "\n\r";
				 */
				this.imprimir("\n\r" + "Juliana Karla Galetos \n\r"
						+ "----------------------------------------------------------------\n\r"
						+ "        Cupom Não Fiscal \n\r"
						+ "----------------------------------------------------------------\n\r" + "Data e hora: "
						+ dataFormatada + "\n\r"
						+ "Cliente: " + textFieldNome.getText() + "\n\r" + "Rua:" + textFieldRua.getText() + "\n\r"
						+ "Número da casa: " + textFieldNcasa.getText() + "\n\r" + "Bairro: "+ textFieldBairro.getText() 
						+ "\n\r" + "Ponto de Referência: " + textFieldRef.getText() + "\n\r"
						+ "Telefone:" + textField.getText() + "\n\r"
						+ "----------------------------------------------------------------\n\r"
						+ "\n\rPEDIDO: \n\r" + "Qt     Valor     Nome     \n\r" + conteudoImprimir + "\n\r"
						+ "Taxa de Entrega: R$" + textFieldTaxa.getText()+".0" + "\n\r"
						+ "Hora:" + hora +"\n\r"
						+ "Oberservações: " + obs +"\n\r"
						+ "Pagamento: " + metPagamento + "\n\r"
						+ "----------------------------------------------------------------\n\r" + "Total: " + total
						+ "\n\r" + "----------------------------------------------------------------\n\r"
						+ "Volte Sempre \n\r" + "                  \n\r");

			}

			public void imprimir(String pTexto) {
				try {
					InputStream prin = new ByteArrayInputStream(pTexto.getBytes());
					DocFlavor docFlavor = DocFlavor.INPUT_STREAM.AUTOSENSE;
					SimpleDoc documentoTexto = new SimpleDoc(prin, docFlavor, null);
					PrintService impressora = PrintServiceLookup.lookupDefaultPrintService();
					// pega a impressora padrão
					PrintRequestAttributeSet printerAttributes = new HashPrintRequestAttributeSet();
					printerAttributes.add(new JobName("impressão", null));
					printerAttributes.add(OrientationRequested.PORTRAIT);
					printerAttributes.add(MediaSizeName.ISO_A4);
					// Informa tipo de folha
					DocPrintJob printJob = impressora.createPrintJob();

					try {
						printJob.print(documentoTexto, (PrintRequestAttributeSet) printerAttributes);
					} catch (PrintException e) {
						JOptionPane.showMessageDialog(null, "Não foi possível imrprimir", "Erro",
								JOptionPane.ERROR_MESSAGE);
					}
					prin.close();
				} catch (Exception e) {

				}
			}

		});
		btnNewButton_3.setBounds(458, 513, 114, 23);
		contentPane.add(btnNewButton_3);

		JLabel lblNewLabel_10 = new JLabel("Bairro:");
		lblNewLabel_10.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_10.setBounds(30, 293, 89, 14);
		contentPane.add(lblNewLabel_10);

		textFieldBairro = new JTextField();
		textFieldBairro.setEditable(false);
		textFieldBairro.setBounds(142, 293, 141, 20);
		contentPane.add(textFieldBairro);
		textFieldBairro.setColumns(10);

		JLabel lblNewLabel_11 = new JLabel("Taxa de Entrega:");
		lblNewLabel_11.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_11.setBounds(21, 361, 129, 18);
		contentPane.add(lblNewLabel_11);

		textFieldTaxa = new JTextField();
		textFieldTaxa.setBounds(160, 362, 86, 20);
		contentPane.add(textFieldTaxa);
		textFieldTaxa.setColumns(10);

		JButton btnNewButton_4 = new JButton("Voltar");
		btnNewButton_4.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				TelaPrincipal.getInstance().setVisible(true);
			}
		});
		btnNewButton_4.setBounds(756, 514, 89, 23);
		contentPane.add(btnNewButton_4);

		JLabel lblNewLabel_12 = new JLabel("Precisa de troco?");
		lblNewLabel_12.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_12.setBounds(21, 424, 134, 14);
		contentPane.add(lblNewLabel_12);

		textFieldTroco = new JTextField();
		textFieldTroco.setBounds(160, 423, 86, 20);
		contentPane.add(textFieldTroco);
		textFieldTroco.setColumns(10);
		
		JButton btnNewButton_5 = new JButton("Reset");
		btnNewButton_5.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textFieldRua.setText("");
				textFieldNcasa.setText("");
				textFieldRef.setText("");
				textFieldNome.setText("");
				textFieldBairro.setText("");
				modelo1.limparLista();
				textField.setText("");
				telaCadastroPedidoinstance = null;
				dispose();
				CadastroPedido.getInstance().setVisible(true);
				
			}
		});
		btnNewButton_5.setBounds(618, 514, 89, 23);
		contentPane.add(btnNewButton_5);
		
		JLabel lblNewLabel_13 = new JLabel("Observa\u00E7\u00E3o: ");
		lblNewLabel_13.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_13.setBounds(458, 439, 102, 24);
		contentPane.add(lblNewLabel_13);
		
		observacao = new JTextField();
		observacao.setBounds(570, 439, 275, 20);
		contentPane.add(observacao);
		observacao.setColumns(10);
		
		JLabel lblNewLabel_14 = new JLabel("Hora:");
		lblNewLabel_14.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_14.setBounds(458, 474, 46, 14);
		contentPane.add(lblNewLabel_14);
		
		textHora = new JTextField();
		textHora.setBounds(570, 474, 86, 20);
		contentPane.add(textHora);
		textHora.setColumns(10);

	}
}
