package negocios;


import negocios.controles.ControleCliente;
import negocios.controles.ControlePedido;
import negocios.controles.ControleProduto;



public class Fachada {

	private static Fachada instance;
	private ControleProduto produtos;
	private ControleCliente clientes;
	private ControlePedido pedidos;
	

	public Fachada() {
		produtos = new ControleProduto();
		clientes = new ControleCliente();
		pedidos = new ControlePedido();
	}
	
	public static Fachada getInstance() {
		if (Fachada.instance == null) {
			Fachada.instance = new Fachada();
		}
		return Fachada.instance;
	}
	// Produtos
	public void cadastrarProduto(Produto p){
		produtos.cadastrarProduto(p);
	}

	public void removerProduto(String codigo) {
		produtos.removerProduto(codigo);
	}

	public Produto[] listarProdutos() {
		return produtos.listarProdutos();
	}

	public Produto procurarProduto(String nome) {
		return produtos.procurarProduto(nome);
	}

	public void alterarValor(String id, float valor) {
		produtos.alterarValor(id, valor);
	}
	// Clientes
	
	public void cadastrarCliente(Cliente c) {
		clientes.cadastrarCliente(c);
	}
	public void removerCliente(String telefone) {
		clientes.removerCliente(telefone);
	}
	public Cliente[] listarClientes() {
		return clientes.listarClientes();
	}
	public Cliente procurarClientes(String telefone) {
		return clientes.procurarClientes(telefone);
	}
	public void alterarEndereco(String telefone, String endereco, String numCasa, String pontoReferencia) {
		clientes.alterarEndereco(telefone, endereco, numCasa, pontoReferencia);
	}
	// pedido
	
	public void criarPedido(Pedido pedido) {
		pedidos.criarPedido(pedido);
	}

	public void removerPedido(int id) {
		pedidos.removerPedido(id);
	}

	public Pedido[] listarPedidos() {
		return pedidos.listarPedidos();
	}

	public Pedido procurarPedido(int id) {
		return pedidos.procurarPedido(id);
	}
	
}
