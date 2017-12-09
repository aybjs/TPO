package dto;

import java.io.Serializable;

public class RecetaDTO implements Serializable {
	
	String ingrediente;
	Integer cantidad;

	public RecetaDTO() {
		// TODO Auto-generated constructor stub
	}

	public String getIngrediente() {
		return ingrediente;
	}

	public void setIngrediente(String ingrediente) {
		this.ingrediente = ingrediente;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	@Override
	public String toString() {
		return ingrediente + cantidad;
	}
	
	

}
