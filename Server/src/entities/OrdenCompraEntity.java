package entities;

import java.util.Vector;
import javax.persistence.*;

import negocio.ItemOC;
import negocio.Proveedor;

@Entity
@Table(name="OCs")
public class OrdenCompraEntity {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy  = GenerationType.AUTO)
	@Column(name ="id", nullable=false)
	private long id = 0;
	@OneToMany
	private Vector<ItemOCEntity> items;
	@OneToOne
	private ProveedorEntity proveedor;
	private String responsable;
	private String destino;
	
	public OrdenCompraEntity(){}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Vector<ItemOCEntity> getItems() {
		return items;
	}

	public void setItems(Vector<ItemOCEntity> items) {
		this.items = items;
	}

	public ProveedorEntity getProveedor() {
		return proveedor;
	}

	public void setProveedor(ProveedorEntity proveedor) {
		this.proveedor = proveedor;
	}

	public String getResponsable() {
		return responsable;
	}

	public void setResponsable(String responsable) {
		this.responsable = responsable;
	}

	public String getDestino() {
		return destino;
	}

	public void setDestino(String destino) {
		this.destino = destino;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

}
