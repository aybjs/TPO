package entities;

//import javafx.util.converter.LocalDateStringConverter;

import javax.persistence.*;

import negocio.Remito;

import java.time.LocalDate;

@Entity
@Table(name="NotasDevolucion")
public class NotaDevEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@OneToOne
	private Remito remito;
	private String fecha;
	
	public NotaDevEntity(){}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Remito getRemito() {
		return remito;
	}

	public void setRemito(Remito remito) {
		this.remito = remito;
	}

	public LocalDate getFecha() {
		//return new LocalDateStringConverter().fromString(this.fecha);
		return null;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha.toString();
	}
	
	

	
	

}
