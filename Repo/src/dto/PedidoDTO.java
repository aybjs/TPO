package dto;

import java.io.Serializable;
import java.util.Vector;

public class PedidoDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4590437813919959892L;
	/**
	 * 
	 */
	
	
	private static double id = 0;
	private MesaDTO mesa;
	private Vector<ProductoDTO> items;
	private float precio;
	
	public PedidoDTO(MesaDTO mesa, Vector<ProductoDTO> items) {
		super();
		this.mesa = mesa;
		this.items = items;
		//this.items = new Vector<ProductoDTO>();
	}
	
	public PedidoDTO(){
		this.items = new Vector<ProductoDTO>();
	};
	
	public MesaDTO getMesa() {
		return mesa;
	}
	public void setMesa(MesaDTO mesa) {
		this.mesa = mesa;
	}
	public Vector<ProductoDTO> getItems() {
		return items;
	}
	
	/*
	public void setItems(Vector<ProductoDTO> items) {
		this.items = items;
	}*/
	
	public void agregarItem(ProductoDTO p){
		this.items.addElement(p);
	}

	public double getId() {
		return id;
	}

	public static void setId(double id) {
		PedidoDTO.id = id;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public void setItems(Vector<ProductoDTO> items) {
		this.items = items;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}
	
	
	
}
