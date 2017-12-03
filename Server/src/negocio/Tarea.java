package negocio;

import dto.TareaDTO;
import enumerators.EstadoTarea;

public class Tarea {

	private static long id;
	private String nombre;
	private String categoria;
	private Producto producto;
	private int cantidadUnidades;
	private float completo; // numero de 0 a 1 q indica porcentaje de avance
	private EstadoTarea estado;

	public Tarea(String nombre, String categoria,
			Producto producto, int cantidadUnidades) {
		id++;
		this.nombre = nombre;
		this.categoria = categoria;
		this.producto = producto;
		this.cantidadUnidades = cantidadUnidades;
		this.completo = 0;
		this.estado = EstadoTarea.NoIniciado;
	}

	public void actualizarHs(int tiempo) {
		if (estado == EstadoTarea.NoIniciado)
			estado.next();
		float mas = tiempo / producto.getTiempoElaboracion();
		if ((completo + mas) > 1) {
			completo = 1;
			estado = EstadoTarea.Finalizado;
		} else
			completo = completo + mas;
	}

	public void cancelar() {
		estado = EstadoTarea.Cancelado;
	}

	public float getCompleado() {
		return completo;
	}
	
	public String getEstado(){
		return estado.toString();
	}
	
	public int getTiempoRestante(){
		return Math.round(producto.getTiempoElaboracion()*(1-completo));
	}
	
	public void setAsignado(){
		estado = EstadoTarea.Asignado;
	}
	
	public String getCategoria(){
		return categoria;
	}
	
	public TareaDTO toDTO(){
		return new TareaDTO(this.nombre, this.categoria, this.producto.getNombre(),
				this.cantidadUnidades, this.completo, this.estado.toString());
	}

}
