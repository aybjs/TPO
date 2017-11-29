package negocio;

public class ItemRemito {

	private Producto prod;
	private float cantidad;

	public ItemRemito() {
	}

	public ItemRemito(Producto prod, float cantidad) {
		this.prod = prod;
		this.cantidad = cantidad;
	}

	public Producto getProd() {
		return prod;
	}

	public void setProd(Producto prod) {
		this.prod = prod;
	}

	public float getCantidad() {
		return cantidad;
	}

	public void setCantidad(float cantidad) {
		this.cantidad = cantidad;
	}

}
