package negocios;

import java.io.Serializable;

public class Produto implements Serializable {

	private String nome;
	protected float valor;
	private String id;
	private int quantidade;
	
	// gets e sets
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public float getValor() {
		return valor;
	}
	public void setValor(float valor) {
		this.valor = valor;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	//construtor
	public Produto(String nome, float valor) {
		super();
		this.nome = nome;
		this.valor = valor;
		this.quantidade = 1;
	}
	public Produto() {
		super();
		
	}
	@Override
	public String toString() {
		return "Nome: " + nome + "\n valor: " + valor + "Id: " + id;
	}

	


}
