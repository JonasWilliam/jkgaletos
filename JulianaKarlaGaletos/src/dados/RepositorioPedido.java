package dados;

import negocios.Pedido;

public interface RepositorioPedido {



		public void criarPedido(Pedido pedido);
		public void removerPedido(int id);
		public Pedido[] listarPedidos();
		public Pedido procurarPedido(int id);
		//public void alterarStatus(int id);
		
	

	
}
