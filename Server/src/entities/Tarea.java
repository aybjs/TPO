package entities;

import enumerators.EstadoTarea;

public class Tarea {

	private static long id;
	private String nombre;
	private String codigo;
	private String categoria;
	private Producto producto;
	private int cantidadUnidades;
	private float completo; // numero de 0 a 1 q indica porcentaje de avance
	private EstadoTarea estado;

	public Tarea(String nombre, String codigo, String categoria,
			Producto producto, int cantidadUnidades) {
		id++;
		this.nombre = nombre;
		this.codigo = codigo;
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

}
