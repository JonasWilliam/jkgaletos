package negocios.controles;



import dados.RepositorioPedido;
import dados.RepositorioPedidoArray;
import negocios.Pedido;
import negocios.Produto;


public class ControlePedido {

	RepositorioPedido pedidos =  RepositorioPedidoArray.getInstance();

	public void criarPedido(Pedido pedido) {
			pedidos.criarPedido(pedido);
			RepositorioPedidoArray.getInstance().salvarArquivo();
	}

	public void removerPedido(int id) {
		pedidos.removerPedido(id);
		RepositorioPedidoArray.getInstance().salvarArquivo();
	}

	public Pedido[] listarPedidos() {
		RepositorioPedidoArray.getInstance();
		return pedidos.listarPedidos();
	}

	public Pedido procurarPedido(int id) {
			RepositorioPedidoArray.getInstance();
			pedidos.procurarPedido(id);

		return pedidos.procurarPedido(id);
	}
	
	/*public void alterarStatus(int id) {
		RepositorioPedidoArray.getInstance();
		pedidos.alterarStatus(id);
		RepositorioPedidoArray.getInstance().salvarArquivo();
	}
*/
	
}
