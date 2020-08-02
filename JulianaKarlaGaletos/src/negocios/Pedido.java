package negocios;

import java.io.Serializable;
import java.util.ArrayList;

public class Pedido implements Serializable {

	private Cliente cliente;
	private ArrayList<Produto> produtos;
	private int id;
	private float total;

	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public ArrayList<Produto> getProdutos() {
		return produtos;
	}
	public void setProdutos(ArrayList<Produto> produtos) {
		this.produtos = produtos;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public float getTotal() {
		return total;
	}
	public void setTotal(float total) {
		this.total = total;
	}
	
	public Pedido(Cliente cliente, ArrayList<Produto> produtos, int id, float total) {
		super();
		this.cliente = cliente;
		this.produtos = produtos;
		this.id = id;
		this.total = total;
	}
	public Pedido() {
		super();
	}
	
	
	
	
	
	
}
