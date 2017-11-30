package negocio;

public class ItemOCEntity {

	private Producto producto;
	private float cantidad;
	private int diasHastaVto;

	public ItemOCEntity(Producto producto, float cantidad, int diasHastaVto) {
		this.producto = producto;
		this.cantidad = cantidad;
		this.diasHastaVto = diasHastaVto;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public float getCantidad() {
		return cantidad;
	}

	public void setCantidad(float cantidad) {
		this.cantidad = cantidad;
	}

	public int getDiasHastaVto() {
		return diasHastaVto;
	}

	public void setDiasHastaVto(int diasHastaVto) {
		this.diasHastaVto = diasHastaVto;
	}

}
