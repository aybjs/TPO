package negocio;

import java.util.Vector;

public class Deposito {
	
	private Vector<Stock> productos;
	private Vector<Remito> remitos;
	private Vector<NotaDevolucion> notasDevolucion;
	private Vector<MovStock> movimientos;
	private String responsable;
	
	public Deposito(String responsable) {
		this.responsable = responsable;
		productos = new Vector<Stock>();
		remitos = new Vector<Remito>();
		notasDevolucion = new Vector<NotaDevolucion>();
		movimientos = new Vector<MovStock>();
		init();
	}

	

	public String getResponsable() {
		return responsable;
	}

	public void setResponsable(String responsable) {
		this.responsable = responsable;
	}

	public Vector<Stock> getProductos() {
		return productos;
	}

	public Vector<Remito> getRemitos() {
		return remitos;
	}

	public Vector<NotaDevolucion> getNotasDevolucion() {
		return notasDevolucion;
	}

	public Vector<MovStock> getMovimientos() {
		return movimientos;
	}
	
	public void agregarProducto(Producto producto, float cantidad){
		Stock item = buscarItem(producto);
		if (item != null){
			item.setCantidad(item.getCantidad() + cantidad);
		} else {
			productos.add(new Stock(producto, cantidad));
		}
		
	}
	
	public void moverStock(String origen, String destino, Producto prod, float cant, String solicitante, String responsable, boolean entrante) throws Exception{
		MovStock mov = new MovStock(origen, destino, prod, solicitante, responsable, cant, entrante);
		if (entrante)
			agregarProducto(prod, cant);
		else{
			if (hayStock(prod, cant))
				restarStock(prod, cant);
			else
				throw new Exception("no hay suficiente stock");
		}
			
		
	}

	private void restarStock(Producto prod, float cant) {
		// TODO Auto-generated method stub
		Stock item = buscarItem(prod);
		item.setCantidad(item.getCantidad()-cant);		
	}

	private boolean hayStock(Producto prod, float cant) {
		// TODO Auto-generated method stub
		Stock item = buscarItem(prod);
		if (item == null || item.getCantidad()<cant)
			return false;
		else	
			return true;
	}

	private Stock buscarItem(Producto producto) {
		// TODO Auto-generated method stub
		Stock item = null;
		for (Stock s : productos){
			if (s.getProducto().getCodigo()==producto.getCodigo())
				item = s;
		}
		return item;
	}
	
	private void init() {
		// TODO Auto-generated method stub
		
	}

	

}
