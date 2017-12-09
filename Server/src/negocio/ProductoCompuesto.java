package negocio;

import java.util.Vector;

import dto.ProductoDTO;

public class ProductoCompuesto extends Producto {

	private Vector<ProductoSimple> items;
	//private Vector<Integer> cantItem;
	private int tiempoElaboracion; // siempre en minutos
	private float stock;
	private float precio;

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

	public ProductoCompuesto(ProductoDTO prod) {
		this.codigo = prod.getCodigo();
		this.comisionExtra = prod.getComisionExtra();
		this.precio = prod.getPrecio();
		this.nombre = prod.getNombre();
		this.stock = prod.getStock();
	}

	@Override
	public float getStockActual() {
	/*
		// TODO Auto-generated method stub
		float stock = 0;
		for (Producto item : items)
			stock = stock + item.getStockActual();
			*/
		return this.stock;
	}

	public float getPrecio() {
		return this.precio;

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

	public void setPrecio(float d) {
		this.precio = d;
	}


	public Vector<ProductoSimple> getItems() {
		return items;
	}



}
