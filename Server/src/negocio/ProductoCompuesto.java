package negocio;

import java.util.Vector;

public class ProductoCompuesto extends Producto {

	private Vector<ProductoSimple> items;
	//private Vector<Integer> cantItem;
	private int tiempoElaboracion; // siempre en minutos

	public ProductoCompuesto(int codigo, String nombre, String sectorEncargado,
			float minimo, float comisionExtra, float consumoEstimado, int tiempo,float precio)
			throws Exception {
		super(codigo, nombre, sectorEncargado, minimo, comisionExtra,
				consumoEstimado,precio);

		this.items = null;
		//this.cantItem = null;
		this.tiempoElaboracion = tiempo;
	}

	public ProductoCompuesto() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public float getStockActual() {
		// TODO Auto-generated method stub
		float stock = 0;
		for (Producto item : items)
			stock = stock + item.getStockActual();
		return stock;
	}

	public float getPrecio() {
		float precio = 0;
		for (ProductoSimple p : items) {
			precio = precio + p.getPrecioUnitario();
		}
		return precio;

	}

	public int getTiempoElaboracion() {
		return tiempoElaboracion;
	}

	public void setTiempoElaboracion(int tiempoElaboracion) {
		this.tiempoElaboracion = tiempoElaboracion;
	}

	public void agregarItem(ProductoSimple p) {
		items.add(p);
	}
/*
	public String getItems() {
		String rta = null;
		for (Producto item : items)
			rta = rta + item.getNombre() + ", ";
		return rta;
	}

	public Vector<Integer> getCantItem() {
		return cantItem;
	}

	public void setCantItem(Vector<Integer> cantItem) {
		this.cantItem = cantItem;
	}
*/
	public void setItems(Vector<ProductoSimple> items) {
		this.items = items;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	public Vector<ProductoSimple> getItems() {
		return items;
	}

	
	

}
