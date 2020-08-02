package dados;

import negocios.Cliente;
import negocios.Produto;

public interface RepositorioCliente {

	public void cadastrarCliente(Cliente c);
	public void removerCliente(String telefone);
	public Cliente[] listarClientes();
	public Cliente procurarClientes(String telefone);
	public void alterarEndereco(String telefone, String endereco, String numCasa, String pontoReferencia);
	
	
}
