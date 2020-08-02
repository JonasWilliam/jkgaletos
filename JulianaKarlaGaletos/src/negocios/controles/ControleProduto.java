package negocios.controles;

import dados.RepositorioProduto;
import dados.RepositorioProdutoArray;
import negocios.Produto;

public class ControleProduto {

	RepositorioProduto produtos = RepositorioProdutoArray.getInstance();

	
	
	public void cadastrarProduto(Produto p) {
			produtos.cadastrarProduto(p);
			RepositorioProdutoArray.getInstance().salvarArquivo();
			System.out.println("Produto: " + p.getNome() + " cadastrado com sucesso");
	}

	public void removerProduto(String codigo) {
		produtos.removerProduto(codigo);
		RepositorioProdutoArray.getInstance().salvarArquivo();
	}

	public Produto[] listarProdutos() {
		RepositorioProdutoArray.getInstance();
		produtos.listarProdutos();
		return produtos.listarProdutos();
	}

	public Produto procurarProduto(String nome) {
		if (nome != null & nome != "") {
			RepositorioProdutoArray.getInstance();
			produtos.procurarProduto(nome);
		}
		return produtos.procurarProduto(nome);
	}
	
	public void alterarValor(String id, float valor) {
		RepositorioProdutoArray.getInstance();
		Produto p = new Produto();
		p = procurarProduto(id);
		p.setValor(valor);
		RepositorioProdutoArray.getInstance().salvarArquivo();
	}
	
}