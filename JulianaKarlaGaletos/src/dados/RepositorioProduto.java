package dados;

import negocios.Produto;

public interface RepositorioProduto {

	public void cadastrarProduto(Produto p);
	public void removerProduto(String codigo);
	public Produto[] listarProdutos();
	public Produto procurarProduto(String nome);
	public void alterarValor(String id, float valor);
	
}
