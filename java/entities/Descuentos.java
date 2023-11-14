package entities;

import java.util.Date;

public class Descuentos {
	private int id;
	private double monto_descuento;
	private double porcentaje;
	private Date fecha_desde;
	private Date fecha_hasta;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getMonto_descuento() {
		return monto_descuento;
	}
	public void setMonto_descuento(double monto_descuento) {
		this.monto_descuento = monto_descuento;
	}
	public double getPorcentaje() {
		return porcentaje;
	}
	public void setPorcentaje(double porcentaje) {
		this.porcentaje = porcentaje;
	}
	public Date getFecha_desde() {
		return fecha_desde;
	}
	public void setFecha_desde(Date fecha_desde) {
		this.fecha_desde = fecha_desde;
	}
	public Date getFecha_hasta() {
		return fecha_hasta;
	}
	public void setFecha_hasta(Date fecha_hasta) {
		this.fecha_hasta = fecha_hasta;
	}
	@Override
	public String toString() {
		return "Descuentos [id=" + id + ", monto_descuento=" + monto_descuento + ", porcentaje=" + porcentaje
				+ ", fecha_desde=" + fecha_desde + ", fecha_hasta=" + fecha_hasta + "]";
	}
	
	
	
}
