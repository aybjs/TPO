package negocio;

import java.util.Date;

import dto.LoteDTO;

public class Lote {

	private int nro;
	private Date fechaCompra;
	private Date fechaVto;
	private float cantidad;

	public Lote(int nro, Date fechaCompra, Date fechaVto, float cantidad) {
		super();
		this.nro = nro;
		this.fechaCompra = fechaCompra;
		this.fechaVto = fechaVto;
		this.cantidad = cantidad;
	}

	public Lote() {
		// TODO Auto-generated constructor stub
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
	
	public LoteDTO toLoteDTO(){
		LoteDTO aux = new LoteDTO(this.getNro(), this.getFechaCompra(), this.getFechaVto(), this.getCantidad());		
		return aux;
	}
	
}
