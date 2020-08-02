package negocios.controles;

import dados.RepositorioCliente;
import dados.RepositorioClienteArray;
import negocios.Cliente;


public class ControleCliente {

	RepositorioCliente clientes = RepositorioClienteArray.getInstance();

	
	
	public void cadastrarCliente(Cliente c) {
		clientes.cadastrarCliente(c);
		RepositorioClienteArray.getInstance().salvarArquivo();
	}
	
	public void removerCliente(String telefone) {
		clientes.removerCliente(telefone);
		RepositorioClienteArray.getInstance().salvarArquivo();
	}
	
	public Cliente[] listarClientes() {
		RepositorioClienteArray.getInstance();
		clientes.listarClientes();
		return clientes.listarClientes();
	}
	
	public Cliente procurarClientes(String telefone) {
		if (telefone != null & telefone != "") {
			RepositorioClienteArray.getInstance();
			clientes.procurarClientes(telefone);
		}
		return clientes.procurarClientes(telefone);
	}
	
	public void alterarEndereco(String telefone, String endereco, String numCasa, String pontoReferencia) {
		Cliente c = new Cliente();
		RepositorioClienteArray.getInstance();
		c = procurarClientes(telefone);
		c.setEndereco(endereco);
		c.setNumCasa(numCasa);
		c.setPontoReferencia(pontoReferencia);
		RepositorioClienteArray.getInstance().salvarArquivo();
	}
	
}
