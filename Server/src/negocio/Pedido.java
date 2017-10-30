package negocio;

import java.util.Vector;

public class Pedido {
	
	private static double id = 0;
	private Mesa mesa;
	private Vector<ItemPedido> items;
	
	public Pedido (Mesa mesa){
		this.mesa=mesa;
		this.id++;
		this.items=null;
	}
	
	public void agregarItem(Producto producto, int cantidad){
		items.add(new ItemPedido(producto, cantidad, "si", "pedido"));
	}
	
	public String getPedido(){
		String rta = "";
		for (ItemPedido item : items)
			rta += "id: " + item.getId() + " " + item.getItem() + "\n";
		return rta;
	}
	
	
}
