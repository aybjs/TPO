package negocio;

import java.util.Vector;

public class OrdenCompra {

	private static long id = 0;
	private Vector<ItemOC> items;
	private Proveedor proveedor;
	private String responsable;
	private String destino;

	public OrdenCompra() {
		id++;
		items = new Vector<ItemOC>();
	}

	public OrdenCompra(Proveedor proveedor, String responsable, String destino) {
		id++;
		items = new Vector<ItemOC>();
		this.proveedor = proveedor;
		this.responsable = responsable;
		this.destino = destino;
	}

	public Proveedor getProveedor() {
		return proveedor;
	}

	public void setProveedor(Proveedor proveedor) {
		this.proveedor = proveedor;
	}

	public String getResponsable() {
		return responsable;
	}

	public void setResponsable(String responsable) {
		this.responsable = responsable;
	}

	public String getDestino() {
		return destino;
	}

	public void setDestino(String destino) {
		this.destino = destino;
	}

	public static long getId() {
		return id;
	}

	public void agregarItem(ItemOC item) {
		this.items.add(item);
	}

	public Vector<ItemOC> getItems() {
		return items;
	}

}
