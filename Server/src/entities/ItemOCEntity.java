package entities;

import java.io.Serializable;

import javax.persistence.*;

import negocio.Producto;

@Entity
@Table(name="OCItems")
public class ItemOCEntity implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id", nullable =false)
	private long id;
	@OneToOne
	private ProductoEntity producto;
	private float cantidad;
	private int diasHastaVto;
	
	public ItemOCEntity(){}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public ProductoEntity getProducto() {
		return producto;
	}

	public void setProducto(ProductoEntity producto) {
		this.producto = producto;
	}

	public float getCantidad() {
		return cantidad;
	}

	public void setCantidad(float cantidad) {
		this.cantidad = cantidad;
	}

	public int getDiasHastaVto() {
		return diasHastaVto;
	}

	public void setDiasHastaVto(int diasHastaVto) {
		this.diasHastaVto = diasHastaVto;
	}
	
	

}
