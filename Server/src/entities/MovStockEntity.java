package entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

//import javafx.util.converter.LocalDateStringConverter;

import javax.persistence.*;
@Entity
@Table (name="movimientos")
public class MovStockEntity implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id", nullable =false)
	private long id;
	@ManyToOne
	private ProductoEntity producto;
	private String origen;
	private String destino;
	private boolean entrante;
	private float cantidad;
	private String fecha;
	private String solicitante;
	private String responsable;

	public MovStockEntity(String origen, String destino, ProductoEntity producto,
			String solicitante, String responsable, float cantidad, LocalDate fecha,
			boolean entrante) {
		this.origen = origen;
		this.destino = destino;
		this.entrante = entrante;
		this.producto = producto;
		this.fecha = fecha.toString();
		this.solicitante = solicitante;
		this.responsable = responsable;
		this.cantidad = cantidad;
	}
	
	public MovStockEntity(){}

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

	public ProductoEntity getProducto() {
		return producto;
	}

	public void setProducto(ProductoEntity producto) {
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

	public LocalDate getFecha() {
		//return new LocalDateStringConverter().fromString(this.fecha);
		return null;
	}
	
	public void setFecha(LocalDate fecha){
		fecha.toString();
	}

}
