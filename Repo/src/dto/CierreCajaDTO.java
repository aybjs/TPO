package dto;

import java.io.Serializable;

public class CierreCajaDTO implements Serializable{
	
	String nroSucursal;
	float totalTarjeta;
	float totalEfectivo;
	
	public CierreCajaDTO(){}
	
	public CierreCajaDTO(String nroSucursal){
		this.nroSucursal=nroSucursal;
	}

	public String getNroSucursal() {
		return nroSucursal;
	}

	public void setNroSucursal(String nroSucursal) {
		this.nroSucursal = nroSucursal;
	}

	public float getTotalTarjeta() {
		return totalTarjeta;
	}

	public void setTotalTarjeta(float totalTarjeta) {
		this.totalTarjeta = totalTarjeta;
	}

	public float getTotalEfectivo() {
		return totalEfectivo;
	}

	public void setTotalEfectivo(float totalEfectivo) {
		this.totalEfectivo = totalEfectivo;
	}
	
	

}
