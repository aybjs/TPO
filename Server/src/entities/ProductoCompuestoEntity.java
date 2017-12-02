package entities;

import java.util.Vector;

public class ProductoCompuestoEntity extends Producto {

	private Vector<Producto> items;
	private Vector<Integer> cantItem;
	private int tiempoElaboracion; // siempre en minutos

	public ProductoCompuestoEntity(int codigo, String nombre, int sectorEncargado,
			float minimo, float comisionExtra, float consumoEstimado, int tiempo)
			throws Exception {
		super(codigo, nombre, sectorEncargado, minimo, comisionExtra,
				consumoEstimado);

		this.items = null;
		this.cantItem = null;
		this.tiempoElaboracion = tiempo;
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
		for (Producto p : items) {
			precio = precio + p.getPrecio();
		}
		return precio;

	}

	public int getTiempoElaboracion() {
		return tiempoElaboracion;
	}

	public void setTiempoElaboracion(int tiempoElaboracion) {
		this.tiempoElaboracion = tiempoElaboracion;
	}

	public void agregarItem(Producto p) {
		items.add(p);
	}

	public String getItems() {
		String rta = null;
		for (Producto item : items)
			rta = rta + item.getNombre() + ", ";
		return rta;
	}

}
