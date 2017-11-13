package negocio;

public class Stock {
	
	private Producto producto;
	private float cantidad;
	
	public Stock(Producto producto, float cantidad) {
		this.producto = producto;
		this.cantidad = cantidad;
	}

	public float getCantidad() {
		return cantidad;
	}

	public void setCantidad(float cantidad) {
		this.cantidad = cantidad;
	}

	public Producto getProducto() {
		return producto;
	}
	
	
	
	

}
