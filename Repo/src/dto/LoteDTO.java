package dto;

import java.io.Serializable;
import java.util.Date;

public class LoteDTO implements Serializable {

	private static final long serialVersionUID = 1066814429833576977L;
	
	private int nro;
	private Date fechaCompra;
	private Date fechaVto;
	private float cantidad;
	
	public LoteDTO(int nro, Date fechaCompra, Date fechaVto, float cantidad) {
		this.nro = nro;
		this.fechaCompra = fechaCompra;
		this.fechaVto = fechaVto;
		this.cantidad = cantidad;
	}

	public int getNro() {
		return nro;
	}

	public void setNro(int nro) {
		this.nro = nro;
	}

	public Date getFechaCompra() {
		return fechaCompra;
	}

	public void setFechaCompra(Date fechaCompra) {
		this.fechaCompra = fechaCompra;
	}

	public Date getFechaVto() {
		return fechaVto;
	}

	public void setFechaVto(Date fechaVto) {
		this.fechaVto = fechaVto;
	}

	public float getCantidad() {
		return cantidad;
	}

	public void setCantidad(float cantidad) {
		this.cantidad = cantidad;
	}
}
