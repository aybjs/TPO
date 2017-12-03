package dto;

import java.io.Serializable;



public class TareaDTO implements Serializable{
	
	private String nombre;
	private String categoria;
	private String producto;
	private int cantidadUnidades;
	private float completo; // numero de 0 a 1 q indica porcentaje de avance
	private String estado;
	
	public TareaDTO(){}

	public TareaDTO(String nombre, String categoria, String producto,
			int cantidadUnidades, float completo, String estado) {
		this.nombre = nombre;
		this.categoria = categoria;
		this.producto = producto;
		this.cantidadUnidades = cantidadUnidades;
		this.completo = completo;
		this.estado = estado;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getProducto() {
		return producto;
	}

	public void setProducto(String producto) {
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

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	@Override
	public String toString() {
		return "Tarea [nombre=" + nombre + ", Area de Produccion=" + categoria
				+ ", producto=" + producto + ", Cantidad="
				+ cantidadUnidades + ", Avance=" + completo + ", estado="
				+ estado + "]";
	}
	
	
	

}
