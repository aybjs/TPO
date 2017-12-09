package negocio;

import java.util.Vector;

import dao.ProductoCompuestoDAO;
import dao.ProductoSimpleDAO;
import dto.ProductoDTO;

public class ProductoCompuesto extends Producto {

	private Vector<ItemReceta> receta;
	private float precio;
	private int tiempoElaboracion;


	

	public ProductoCompuesto(int codigo, String nombre, String sectorEncargado,
			float minimo, float comisionExtra, float consumoEstimado, int tiempo,float precio)
			throws Exception {
		super(codigo, nombre, sectorEncargado, minimo, comisionExtra,
				consumoEstimado,precio);

		this.receta = new Vector<ItemReceta>();
		this.tiempoElaboracion = tiempo;
	}

	public ProductoCompuesto() {
		// TODO Auto-generated constructor stub
		receta = new Vector<ItemReceta>();
	}

	public ProductoCompuesto(ProductoDTO prod) {
		this.codigo = prod.getCodigo();
		this.comisionExtra = prod.getComisionExtra();
		this.precio = prod.getPrecio();
		this.nombre = prod.getNombre();
		for (int i=0 ; i < prod.getIngredientes().size(); i++){
			ItemReceta aux = new ItemReceta(
					ProductoSimpleDAO.getInstance().recuperarProductoNombre(prod.getIngredientes().elementAt(i)),
					prod.getCantidades().elementAt(i));
		}
		ProductoCompuestoDAO.getInstance().grabarProducto(this);		
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

	public void setPrecio(float d) {
		this.precio = d;
	}

	@Override
	public float getStockActual() {
		// TODO Auto-generated method stub
		return super.getStock();
	}



}
