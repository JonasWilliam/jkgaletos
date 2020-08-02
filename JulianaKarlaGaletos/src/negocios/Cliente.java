package negocios;

import java.io.Serializable;

public class Cliente implements Serializable{

	private String nome;
	private String telefone;
	private String endereco;
	private String numCasa;
	private String pontoReferencia;
	private String bairro;
	
	public Cliente(String nome, String telefone, String endereco, String numCasa, String pontoReferencia, String bairro) {
		super();
		this.nome = nome;
		this.telefone = telefone;
		this.endereco = endereco;
		this.numCasa = numCasa;
		this.pontoReferencia = pontoReferencia;
		this.bairro = bairro;
	}
	
	public Cliente() {
		
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getNumCasa() {
		return numCasa;
	}

	public void setNumCasa(String numCasa) {
		this.numCasa = numCasa;
	}

	public String getPontoReferencia() {
		return pontoReferencia;
	}

	public void setPontoReferencia(String pontoReferencia) {
		this.pontoReferencia = pontoReferencia;
	}
	
	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	@Override
	public String toString() {
		return "Nome: " + nome + "\n Telefone: " + telefone + "\n Endereço: " + endereco + "\n Número da Casa: " + numCasa
				+ "\n Ponto de Referencia: " + pontoReferencia;
	}
	
	
	

}
