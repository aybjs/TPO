package entities;

import java.time.LocalDate;
import java.util.Vector;
import java.time.LocalDate;

import javafx.util.converter.LocalDateStringConverter;

import javax.persistence.*;

import negocio.ItemRemito;

@Entity
@Table(name="remitos")
public class RemitoEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id = 0;
	@OneToMany
	private Vector<ItemRemitoEntity> items;
	//ojo con el formato de la fecha
	private String fecha;
	
	public RemitoEntity(){}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Vector<ItemRemitoEntity> getItems() {
		return items;
	}

	public void setItems(Vector<ItemRemitoEntity> items) {
		this.items = items;
	}

	public LocalDate getFecha() {
		return new LocalDateStringConverter().fromString(this.fecha);
	}
	
	public void setFecha(LocalDate fecha) {
		this.fecha = fecha.toString();
	}
	
	

}
