package entities;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "Mozos")
public class MozoEntity implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "nroEmpleado", nullable = false)
	private Integer nroEmpleado;
	@Column(name = "nombre")
	private String nombre;
	@Column(name = "comision")
	private Float comision;

	public MozoEntity() {
	}

	public Integer getNroEmpleado() {
		return nroEmpleado;
	}

	public void setNroEmpleado(Integer nroEmpleado) {
		this.nroEmpleado = nroEmpleado;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Float getComision() {
		return comision;
	}

	public void setComision(Float comision) {
		this.comision = comision;
	}


}
