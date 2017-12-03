package negocio;

import java.util.Vector;

import dao.TareaDAO; 

public class AreaProduccion {

	private String nombreArea;
	private Vector<Tarea> tareas;
	private int tiempoLibre; // siempre en minutos

	public AreaProduccion(String nombreArea, int tiempoLibre) {
		this.nombreArea = nombreArea;
		this.tareas = TareaDAO.getInsatancia().getActivas();
		this.tiempoLibre = tiempoLibre;
		getTareasFromDB();
	}

	private void getTareasFromDB() {
		// TODO Auto-generated method stub
		
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

	public int getTiempoRestante() {
		// TODO Auto-generated method stub
		int tiempo = 0;
		for (Tarea tarea : tareas)
			tiempo = tiempo + tarea.getTiempoRestante();
		return tiempo;
	}

}
