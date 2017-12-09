package dto;

import java.io.Serializable;

public class ComisionesDTO implements Serializable{
	private static final long serialVersionUID = 4288074826289301213L;
	String sucursal;
	String mozo;
	float comision;
	
	public ComisionesDTO() {
	}
	public ComisionesDTO(String mozo, float comision, String nroSucursal) {
		this.sucursal = nroSucursal;
		this.mozo = mozo;
		this.comision = comision;
	}
	
	public void setSucursal(String sucursal){
		this.sucursal = sucursal;
	}
	
	public String getSucursal(){
		return sucursal;
	}
	public String getMozo() {
		return mozo;
	}
	public void setMozo(String mozo) {
		this.mozo = mozo;
	}
	public float getComision() {
		return comision;
	}
	public void setComision(float comision) {
		this.comision = comision;
	}
}
