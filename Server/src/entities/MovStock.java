package entities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class MovStock {

	private String origen;
	private String destino;
	private boolean entrante;
	private Producto producto;
	private float cantidad;
	private LocalDate fecha;
	private String solicitante;
	private String responsable;

	public MovStock(String origen, String destino, Producto producto,
			String solicitante, String responsable, float cantidad,
			boolean entrante) {
		this.origen = origen;
		this.destino = destino;
		this.entrante = entrante;
		this.producto = producto;
		this.fecha = LocalDate.now();
		this.solicitante = solicitante;
		this.responsable = responsable;
		this.cantidad = cantidad;
	}

	public String getOrigen() {
		return origen;
	}

	public void setOrigen(String origen) {
		this.origen = origen;
	}

	public String getDestino() {
		return destino;
	}

	public void setDestino(String destino) {
		this.destino = destino;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public String getSolicitante() {
		return solicitante;
	}

	public void setSolicitante(String solicitante) {
		this.solicitante = solicitante;
	}

	public String getResponsable() {
		return responsable;
	}

	public void setResponsable(String responsable) {
		this.responsable = responsable;
	}

	public String getFecha() {
		return fecha.toString();
	}

}
