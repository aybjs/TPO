package dto;

import java.io.Serializable;
import java.util.Vector;

public class PedidoDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static double id = 0;
	private MesaDTO mesa;
	private Vector<ProductoDTO> items;
	
	public PedidoDTO(MesaDTO mesa, Vector<ProductoDTO> items) {
		super();
		this.mesa = mesa;
		this.items = items;
	}
	
	public PedidoDTO(){};
	
	public MesaDTO getMesa() {
		return mesa;
	}
	public void setMesa(MesaDTO mesa) {
		this.mesa = mesa;
	}
	public Vector<ProductoDTO> getItems() {
		return items;
	}
	public void setItems(Vector<ProductoDTO> items) {
		this.items = items;
	}
}
