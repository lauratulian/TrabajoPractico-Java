package entities;

import java.time.LocalDateTime;

public class Pedido {
	private int id_pedido;
	private LocalDateTime fechapedido;
	
	public int getId_pedido() {
		return id_pedido;
	}
	public void setId_pedido(int id_pedido) {
		this.id_pedido = id_pedido;
	}
	public LocalDateTime getFechapedido() {
		return fechapedido;
	}
	public void setFechapedido(LocalDateTime fechapedido) {
		this.fechapedido = fechapedido;
	}
	@Override
	public String toString() {
		return "Pedido [id_pedido=" + id_pedido + ", fechapedido=" + fechapedido + "]";
	}
	
	
}
