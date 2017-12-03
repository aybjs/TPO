package entities;

import java.io.Serializable;
import java.util.Vector;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Entity;

import enumerators.SectorEncargado;
import negocio.Lote;

@MappedSuperclass
//@Table(name="productos")  // tabla unica
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
public abstract class ProductoEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	@Id
	@GeneratedValue
	@Column(name="IdProductoCompuesto")
	private int codigo;
	@Column(name="nombre")
	private String nombre;
	@Column(name="Sector")
	private String sectorEncargado;
	@Column(name="minimo")
	private float minimo;
	@Column(name="comisionExtra")
	private float comisionExtra;
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="codigo")
	private Vector<LoteEntity> lotes;
	@Column(name="consumoEstimado")
	private float consumoEstimado;
	@Column(name="precio")
	private float precio;
	
	public ProductoEntity(){
		
	}
	
	public ProductoEntity(int codigo, String nombre, String sectorEncargado, float minimo, float comisionExtra,
			Vector<LoteEntity> lotes, float consumoEstimado, float precio) {
		this.codigo = codigo;
		this.nombre = nombre;
		this.sectorEncargado = sectorEncargado;
		this.minimo = minimo;
		this.comisionExtra = comisionExtra;
		this.lotes = lotes;
		this.consumoEstimado = consumoEstimado;
		this.precio = precio;
	}
	
	





	public ProductoEntity(int codigo2, String nombre2, String sectorEncargado2, float minimo2, float comisionExtra2,
			float consumoEstimado2, float precio) {
		this.codigo = codigo2;
		this.nombre = nombre2;
		this.sectorEncargado = sectorEncargado2;
		this.minimo = minimo2;
		this.comisionExtra = comisionExtra2;
		this.consumoEstimado = consumoEstimado2;
		this.precio = precio;
	}







	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getSectorEncargado() {
		return sectorEncargado;
	}
	public void setSectorEncargado(String sectorEncargado) {
		this.sectorEncargado = sectorEncargado;
	}
	public float getMinimo() {
		return minimo;
	}
	public void setMinimo(float minimo) {
		this.minimo = minimo;
	}
	public float getComisionExtra() {
		return comisionExtra;
	}
	public void setComisionExtra(float comisionExtra) {
		this.comisionExtra = comisionExtra;
	}
	public Vector<LoteEntity> getLotes() {
		return lotes;
	}
	public void setLotes(Vector<LoteEntity> lotes) {
		this.lotes = lotes;
	}
	public float getConsumoEstimado() {
		return consumoEstimado;
	}
	public void setConsumoEstimado(float consumoEstimado) {
		this.consumoEstimado = consumoEstimado;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}
	
	public void addLote(LoteEntity l){
		this.lotes.addElement(l);
	}
	
	
	
}
