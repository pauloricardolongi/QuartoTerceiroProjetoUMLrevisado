package entidades;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entidades.enums.EstadoPedido;


public class Pedido {
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	private Date momento;
	private EstadoPedido estado;
	
	private Cliente cliente;
	
	private List<ItemPedido> itens = new ArrayList<ItemPedido>();

	public Pedido() {
		
	}

	public Pedido(Date momento, EstadoPedido estado, Cliente cliente) {
		
		this.momento = momento;
		this.estado = estado;
		this.cliente = cliente;
	}


	public Date getMomento() {
		return momento;
	}

	public void setMomento(Date momento) {
		this.momento = momento;
	}

	public EstadoPedido getEstado() {
		return estado;
	}

	public void setEstado(EstadoPedido estado) {
		this.estado = estado;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public void addItem(ItemPedido item) {
		itens.add(item);
	}
	
	public void removeItem(ItemPedido item) {
		itens.remove(item);
	}
	
	public double total() {
		double sum = 0.0;
		for (ItemPedido ip : itens) {
			sum += ip.subTotal();
		}
		return sum;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Sumário do Pedido: ");
		sb.append(sdf.format(momento) + "\n");
		sb.append("Estado do Pedido: ");
		sb.append(estado + "\n");
		sb.append("Cliente: ");
		sb.append(cliente + "\n");
		sb.append("Item do Pedido:\n");
		for (ItemPedido item : itens) {
			sb.append(item + "\n");
		}
		sb.append("Total preço: $");
		sb.append(String.format("%.2f", total()));
		return sb.toString();
	}	
}
