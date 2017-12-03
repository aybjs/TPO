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
	
	public PedidoDTO(MesaDTO mesa, Vector<ProductoDTO> items) {
		super();
		this.mesa = mesa;
		this.items = items;
		this.items = new Vector<ProductoDTO>();
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
	
}
