package entities;

import java.util.Vector;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="AreaProduccion")

public class AreaProduccion {

	@Id
	@Column(name="nombreArea")
	private String nombreArea;
	@OneToOne
	@JoinColumn(name="id")
	private Vector<Tarea> tareas;
	@Column(name="tiempoLibre")
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
