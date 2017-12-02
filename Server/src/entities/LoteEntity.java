package entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Entity
@Table(name="Lotes")
public class LoteEntity implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="nroLote",nullable=false)
	private Integer nroLote;
	@Column(name="cantidad")
	private float cantidad;
	@Column(name="FechaCompra")
	private Date FechaCompra ;
	@Column(name="FechaVenta")
	private Date FechaVenta ;
	
	public LoteEntity() {}

	public Integer getNroLote() {
		return nroLote;
	}

	public void setNroLote(Integer nroLote) {
		this.nroLote = nroLote;
	}

	public float getCantidad() {
		return cantidad;
	}

	public void setCantidad(float cantidad) {
		this.cantidad = cantidad;
	}

	public Date getFechaCompra() {
		return FechaCompra;
	}

	public void setFechaCompra(Date fechaCompra) {
		FechaCompra = fechaCompra;
	}

	public Date getFechaVenta() {
		return FechaVenta;
	}

	public void setFechaVenta(Date fechaVenta) {
		FechaVenta = fechaVenta;
	}
	
	
	
	
	
	
}

