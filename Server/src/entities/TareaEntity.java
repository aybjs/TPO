package entities;

import java.io.Serializable;

import javax.persistence.*;

import enumerators.EstadoTarea;



@Entity
@Table (name="tareas")
public class TareaEntity implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id", nullable =false)
	private long id;
	private String nombre;
	private String codigo;
	private String categoria;
	@OneToOne
	private ProductoEntity producto;
	private int cantidadUnidades;
	private float completo; // numero de 0 a 1 q indica porcentaje de avance
	@Transient
	private EstadoTarea estado;

	public TareaEntity(){}
	
	public TareaEntity(String nombre, String codigo, String categoria,
			ProductoEntity producto, int cantidadUnidades) {
		id++;
		this.nombre = nombre;
		this.codigo = codigo;
		this.categoria = categoria;
		this.producto = producto;
		this.cantidadUnidades = cantidadUnidades;
		this.completo = 0;
		this.estado = EstadoTarea.NoIniciado;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public ProductoEntity getProducto() {
		return producto;
	}

	public void setProducto(ProductoEntity producto) {
		this.producto = producto;
	}

	public int getCantidadUnidades() {
		return cantidadUnidades;
	}

	public void setCantidadUnidades(int cantidadUnidades) {
		this.cantidadUnidades = cantidadUnidades;
	}

	public float getCompleto() {
		return completo;
	}

	public void setCompleto(float completo) {
		this.completo = completo;
	}

	public EstadoTarea getEstado() {
		return estado;
	}

	public void setEstado(EstadoTarea estado) {
		this.estado = estado;
	}



}
