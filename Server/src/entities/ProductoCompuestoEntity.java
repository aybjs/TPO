package entities;

import java.util.Vector;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;



@Entity
@Table(name="elaborados")
public class ProductoCompuestoEntity extends ProductoEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@ManyToMany(cascade=CascadeType.ALL)
	@LazyCollection(LazyCollectionOption.FALSE) 
	@JoinTable(name="items",joinColumns=@JoinColumn (name="IDProdComp",referencedColumnName="codigo"),inverseJoinColumns=@JoinColumn(name="IDProdSimple",referencedColumnName="codigo"))
	private Vector<ProductoSimpleEntity> items;
	//@OneToMany(cascade=CascadeType.ALL)
	//private Vector<Integer> cantItem;
	@Column(name="tiempoElaboracion")
	private int tiempoElaboracion; 
	@Column(name="precio")
	private float precio;

	public ProductoCompuestoEntity(int codigo, String nombre, String sectorEncargado,
			float minimo, float comisionExtra, float consumoEstimado, int tiempo)
			throws Exception {
		super(codigo, nombre, sectorEncargado, minimo, comisionExtra,
				consumoEstimado);

		this.items = null;
		//this.cantItem = null;
		this.tiempoElaboracion = tiempo;
	}

	public ProductoCompuestoEntity() {
		// TODO Auto-generated constructor stub
	}

	public Vector<ProductoSimpleEntity> getItems() {
		return items;
	}

	public void setItems(Vector<ProductoSimpleEntity> items) {
		this.items = items;
	}
	
	public void agregarItems(ProductoSimpleEntity item) {
		this.items.addElement(item);
	}

	public int getTiempoElaboracion() {
		return tiempoElaboracion;
	}

	public void setTiempoElaboracion(int tiempoElaboracion) {
		this.tiempoElaboracion = tiempoElaboracion;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}
	
	
	
	
	
	

}
