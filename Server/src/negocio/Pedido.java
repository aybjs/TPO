package negocio;

import java.util.Vector;

import dto.PedidoDTO;
import dto.ProductoDTO;

public class Pedido {

	private static double id = 0;
	private Mesa mesa;
	private Vector<ProductoCompuesto> items;

	public Pedido(Mesa mesa) {
		this.mesa = mesa;
		Pedido.id++;
		this.items = new Vector<ProductoCompuesto>();
	}
	
	public Pedido(PedidoDTO p){
		this.mesa = new Mesa(p.getMesa());
		Pedido.id = p.getId();
		for(ProductoDTO ped: p.getItems()){
			
			ProductoCompuesto pc = new ProductoCompuesto(ped);
			this.items.addElement(pc);
			
			
		}
		
	}

	public Pedido() {
		// TODO Auto-generated constructor stub
	}

	public float subTotal() {
		float st = 0;
		for (ProductoCompuesto p : items)
			st = st + p.getPrecio();
		return st;
	}

	public void agregarItem(ProductoCompuesto producto) {
		items.add(producto);
	}

	public String getPedido() {
		String rta = "";
		for (ProductoCompuesto item : items)
			rta += "id: " + item.getCodigo() + " " + item.getNombre()+ "\n";
		return rta;
	}

	public double getId() {
		return id;
	}

	public static void setId(double id) {
		Pedido.id = id;
	}

	public Mesa getMesa() {
		return mesa;
	}

	public void setMesa(Mesa mesa) {
		this.mesa = mesa;
	}

	public Vector<ProductoCompuesto> getItems() {
		return items;
	}

	public void setItems(Vector<ProductoCompuesto> items) {
		this.items = items;
	}

	/*
	public void cambiarEstadoItem(ProductoCompuesto item, String estado)
			throws Exception {
		boolean cambio = false;
		for (ProductoCompuesto i : items)
			if (i.getNombre().equalsIgnoreCase(item.getNombre())) {
				i.setEstado(estado);
				cambio = true;
			}
		if (cambio = false)
			throw new Exception("item no encontrado");
	}
	*/
	
	

}
