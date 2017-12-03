package negocio;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.Vector;

import dto.CartaDTO;
import dto.ProductoDTO;

public class Carta {

	private Vector<Producto> productos;
	private static int idCarta = 0;
	private LocalDate desde;
	private LocalDate hasta;

	public Carta() {
		idCarta++;
		productos = new Vector<Producto>();
		desde = LocalDate.now();
		hasta = LocalDate.now().plusYears(1);
	}

	public void agregarProducto(Vector<ProductoCompuesto> vector) {
		productos.addAll(vector);
	}

	public Vector<String[]> listarProductos() {
		Vector<String[]> rta = new Vector<String[]>();
		for (Producto p : productos) {
			rta.add(new String[] { p.getNombre(), Integer.toString(p.getCodigo())}); //revisen cambie el getPrecio 
		}
		return rta;
	}
	public CartaDTO toDTO(){
		CartaDTO carta = new CartaDTO();
		Vector<ProductoDTO> p = new Vector<ProductoDTO>();
		for(Producto prod : productos){
			p.add(prod.toProdDTO());
		}
		carta.setProductos(p);
		carta.setIdCarta(idCarta);
		carta.setDesde(desde);
		carta.setHasta(hasta);
		return carta;
		
		
	}

	public Vector<Producto> getProductos() {
		return productos;
	}

	public void setProductos(Vector<Producto> productos) {
		this.productos = productos;
	}

	public static int getIdCarta() {
		return idCarta;
	}

	public static void setIdCarta(int idCarta) {
		Carta.idCarta = idCarta;
	}

	public LocalDate getDesde() {
		return desde;
	}

	public void setDesde(LocalDate desde) {
		this.desde = desde;
	}

	public LocalDate getHasta() {
		return hasta;
	}

	public void setHasta(LocalDate hasta) {
		this.hasta = hasta;
	}
	
}
