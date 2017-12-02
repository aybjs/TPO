package entities;

import java.io.Serializable;
import java.util.Vector;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Entity;

import enumerators.SectorEncargado;
import negocio.Lote;

@Entity
@Table(name="productos")  // tabla unica
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="tipoProducto", discriminatorType=DiscriminatorType.STRING)
public abstract class ProductoEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	@Id
	private int codigo;
	@Column(name="nombre")
	private String nombre;
	@ManyToMany
	private SectorEncargado sectorEncargado;
	@Column(name="minimo")
	private float minimo;
	@Column(name="comisionExtra")
	private float comisionExtra;
	@OneToMany
	private Vector<Lote> lotes;
	@Column(name="consumoEstimado")
	private float consumoEstimado;
	
	
	
	public ProductoEntity(int codigo, String nombre, SectorEncargado sectorEncargado, float minimo, float comisionExtra,
			Vector<Lote> lotes, float consumoEstimado) {
		this.codigo = codigo;
		this.nombre = nombre;
		this.sectorEncargado = sectorEncargado;
		this.minimo = minimo;
		this.comisionExtra = comisionExtra;
		this.lotes = lotes;
		this.consumoEstimado = consumoEstimado;
	}
	
	





	public ProductoEntity(int codigo2, String nombre2, SectorEncargado sectorEncargado2, float minimo2, float comisionExtra2,
			float consumoEstimado2) {
		this.codigo = codigo2;
		this.nombre = nombre2;
		this.sectorEncargado = sectorEncargado2;
		this.minimo = minimo2;
		this.comisionExtra = comisionExtra2;
		this.consumoEstimado = consumoEstimado2;
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
	public SectorEncargado getSectorEncargado() {
		return sectorEncargado;
	}
	public void setSectorEncargado(SectorEncargado sectorEncargado) {
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
	public Vector<Lote> getLotes() {
		return lotes;
	}
	public void setLotes(Vector<Lote> lotes) {
		this.lotes = lotes;
	}
	public float getConsumoEstimado() {
		return consumoEstimado;
	}
	public void setConsumoEstimado(float consumoEstimado) {
		this.consumoEstimado = consumoEstimado;
	}
	
	
	
	
}
