package entities;

public class ClientePedido {
	private int dni_cliente;
	private int numero_pedido;
	private double precio;
	
	public int getDni_cliente() {
		return dni_cliente;
	}
	public void setDni_cliente(int dni_cliente) {
		this.dni_cliente = dni_cliente;
	}
	public int getNumero_pedido() {
		return numero_pedido;
	}
	public void setNumero_pedido(int numero_pedido) {
		this.numero_pedido = numero_pedido;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	
	
}
