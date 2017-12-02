package negocio;

import java.util.Date;
import java.util.List;

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
	public LoteDTO toLoteDTO(List<Lote> lote){
		LoteDTO aux = new ;
		
		return aux;
	}
}
