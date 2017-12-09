package entities;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name="Recetas")
public class ItemRecetaEntity implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private ProductoEntity item;
	private Integer cantidad;
	public ItemRecetaEntity() {
	}
	public ProductoEntity getItem() {
		return item;
	}
	public void setItem(ProductoEntity item) {
		this.item = item;
	}
	public Integer getCantidad() {
		return cantidad;
	}
	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}
	
	
	
	}