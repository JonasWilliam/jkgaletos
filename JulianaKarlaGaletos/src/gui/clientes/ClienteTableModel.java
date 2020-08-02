package gui.clientes;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import negocios.Cliente;


public class ClienteTableModel extends AbstractTableModel {

	private List<Cliente> clientes = new ArrayList<>();
	private String[] colunas = { "Nome", "Telefone", "Endereço", "N° casa" , "P. de Referência" };
	
	@Override
	public String getColumnName(int column) {
		// TODO Auto-generated method stub
		return colunas[column];
	}

	@Override
	public int getRowCount() {
		return clientes.size();
	}

	@Override
	public int getColumnCount() {
		return colunas.length;
	}

	@Override
	public Object getValueAt(int linha, int coluna) {
		switch (coluna) {
	
			
		case 0:
			return clientes.get(linha).getNome();
		case 1:
			return clientes.get(linha).getTelefone();
		case 2: 
			return clientes.get(linha).getEndereco();
		case 3:
			return clientes.get(linha).getNumCasa();
		case 4:
			return clientes.get(linha).getPontoReferencia();
		
		}
		return null;
	}
	public void addRow(Cliente c) {
		this.clientes.add(c);
		this.fireTableDataChanged();
	}

	public void limparLista() {
		this.clientes.clear();
		
	}
	public void att() {
		this.fireTableDataChanged();
	}


}
