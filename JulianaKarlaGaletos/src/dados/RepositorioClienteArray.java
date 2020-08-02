package dados;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import negocios.Cliente;


public class RepositorioClienteArray implements RepositorioCliente, Serializable {

	private Cliente[] clientes;
	private int indice;
	private final static int TAMANHO = 100;
	private static RepositorioClienteArray instance;
	

	public static RepositorioClienteArray getInstance() {
		if (instance == null) {
			instance = lerDoArquivo();
		}
		return instance;
	}

	public RepositorioClienteArray() {
		this.clientes = new Cliente[TAMANHO];
		this.indice = 0;
	}

	
	@Override
	public void cadastrarCliente(Cliente c) {
		
		this.clientes[indice] = c;
		this.indice = this.indice + 1;
		
	}

	@Override
	public void removerCliente(String telefone) {
		for (int i = 0; i < indice; i++) {
			if (clientes[i].getTelefone().equals(telefone)) {
				clientes[i] = null;
				indice--;

				for (int j = 0; j < indice; j++) {

					if (clientes[j] == null) {
						if (clientes[j + 1] != null) {
							clientes[j] = clientes[j + 1];
							clientes[j + 1] = null;
							break;
						}

					}
				}
			}
		}
		
	}

	@Override
	public Cliente[] listarClientes() {
		for (int i = 0; i < indice; i++) {

		}
		return clientes;
	}

	@Override
	public Cliente procurarClientes(String telefone) {
		Cliente p = null;
		for (int i = 0; i < indice; i++) {
			if (clientes[i] != null) {
				if (clientes[i].getTelefone().equals(telefone)) {

					return clientes[i];
				}
			} else
				p = null; 
		}
		return p;
	}

	@Override
	public void alterarEndereco(String telefone, String endereco, String numCasa, String pontoReferencia) {
		Cliente c = new Cliente();
		c = procurarClientes(telefone);
		c.setEndereco(endereco);
		c.setNumCasa(numCasa);
		c.setPontoReferencia(pontoReferencia);
		
	}

	private static RepositorioClienteArray lerDoArquivo() {
		RepositorioClienteArray instanciaLocal = null;

		File in = new File("clientes.dat");
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		try {
			fis = new FileInputStream(in);
			ois = new ObjectInputStream(fis);
			Object o = ois.readObject();
			instanciaLocal = (RepositorioClienteArray) o;
		} catch (Exception e) {
			instanciaLocal = new RepositorioClienteArray();
		} finally {
			if (ois != null) {
				try {
					ois.close();
				} catch (IOException e) {/* Silent exception */
				}
			}
		}

		return instanciaLocal;
	}

	public void salvarArquivo() {
		if (instance == null) {
			return;
		}
		File out = new File("clientes.dat");
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;

		try {
			fos = new FileOutputStream(out);
			oos = new ObjectOutputStream(fos);
			oos.writeObject(instance);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (oos != null) {
				try {
					oos.close();
				} catch (IOException e) {
					/* Silent */}
			}
		}
	}
	
	
}
