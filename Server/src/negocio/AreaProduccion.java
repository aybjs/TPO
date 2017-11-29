package negocio;

import java.util.Vector;

public class AreaProduccion {

	private String nombreArea;
	private Vector<Tarea> tareas;
	private int tiempoLibre; // siempre en minutos

	public AreaProduccion(String nombreArea, int tiempoLibre) {
		this.nombreArea = nombreArea;
		this.tareas = new Vector<Tarea>();
		this.tiempoLibre = tiempoLibre;
	}

	public void agregarTarea(Tarea tarea) {
		tareas.add(tarea);
	}

	public String getNombreArea() {
		return nombreArea;
	}

	public void setNombreArea(String nombreArea) {
		this.nombreArea = nombreArea;
	}

	public int getTiempoLibre() {
		return tiempoLibre;
	}

	public void setTiempoLibre(int tiempoLibre) {
		this.tiempoLibre = tiempoLibre;
	}

	public Vector<Tarea> getTareas() {
		return tareas;
	}

}
