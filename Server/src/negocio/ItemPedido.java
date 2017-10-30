package negocio;

public class ItemPedido {
	
	private static double id = 0; //me parece que esto no va
	private Producto producto;
	private int cantidad;
	private String facturable;
	private String estado;
	
	public ItemPedido(Producto producto, int cantidad,
			String facturable, String estado) {
		this.id++; //creo que no va
		this.producto = producto;
		this.cantidad = cantidad;
		this.facturable = facturable;
		this.estado = estado;
	}
	public String getFacturable() {
		return facturable;
	}
	public void setFacturable(String facturable) {
		this.facturable = facturable;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public double getId() {
		return id;
	}
	public String getProducto() {
		return producto.getNombre();
	}
	public int getCantidad() {
		return cantidad;
	}
	
	public String getItem(){
		return cantidad + "x " + producto.getNombre();
	}
	
	
	
	

}
