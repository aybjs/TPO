package negocio;

public class Mozo {
	
	private int nroEmpleado;
	private String nombre;
	private float comision;
	
	public Mozo(int nroEmpleado, String nombre, float comision) {
		this.nroEmpleado = nroEmpleado;
		this.nombre = nombre;
		this.comision = comision;
	}

	public int getNroEmpleado() {
		return nroEmpleado;
	}

	public void setNroEmpleado(int nroEmpleado) {
		this.nroEmpleado = nroEmpleado;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public float getComision() {
		return comision;
	}

	public void setComision(float comision) {
		this.comision = comision;
	}
	
	

}
