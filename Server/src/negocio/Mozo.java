package negocio;

import dto.MozoDTO;

public class Mozo {

	private int nroEmpleado;
	private String nombre;
	private float comision;

	public Mozo(int nroEmpleado, String nombre, float comision) {
		this.nroEmpleado = nroEmpleado;
		this.nombre = nombre;
		this.comision = comision;
	}
	
	public Mozo(MozoDTO m){
		this.nroEmpleado = m.getNroEmpleado();
		this.nombre = m.getNombre();
		this.comision = m.getComision();
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
	public MozoDTO toDTO(){
		MozoDTO mozo = new MozoDTO(nroEmpleado, nombre, comision);
		return mozo;
	}
	
}
