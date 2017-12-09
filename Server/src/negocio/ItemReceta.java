package negocio;

public class ItemReceta {
	
	private Producto item;
	private int cantidad;
	
	public ItemReceta(Producto item, int cantidad) {
		this.item = item;
		this.cantidad = cantidad;
	}

	public Producto getItem() {
		return item;
	}

	public void setItem(Producto item) {
		this.item = item;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
}
