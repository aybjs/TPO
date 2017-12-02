package entities;

import java.util.Vector;

// no lo vamos a usar
public class PedidoEntity {

	private static double id = 0;
	private Mesa mesa;
	private Vector<ItemPedido> items;

	public PedidoEntity(Mesa mesa) {
		this.mesa = mesa;
		this.id++;
		this.items = new Vector<ItemPedido>();
	}

	public float subTotal() {
		float st = 0;
		for (ItemPedido i : items)
			st = st + i.subTotal();
		return st;
	}

	public void agregarItem(ProductoEntity producto, int cantidad) {
		//items.add(new ItemPedido(producto, cantidad, "si", "pedido"));
	}

	public String getPedido() {
		String rta = "";
		for (ItemPedido item : items)
			rta += "id: " + item.getId() + " " + item.getItem() + "\n";
		return rta;
	}

	public void cambiarEstadoItem(ItemPedido item, String estado)
			throws Exception {
		boolean cambio = false;
		for (ItemPedido i : items)
			if (i.getProducto().equalsIgnoreCase(item.getProducto())) {
				i.setEstado(estado);
				cambio = true;
			}
		if (cambio = false)
			throw new Exception("item no encontrado");
	}

}
