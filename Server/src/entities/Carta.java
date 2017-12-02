package entities;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.Vector;

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

	public void agregarProducto(Producto p) {
		productos.add(p);
	}

	public Vector<String[]> listarProductos() {
		Vector<String[]> rta = new Vector<String[]>();
		for (Producto p : productos) {
			rta.add(new String[] { p.getNombre(), Float.toString(p.getPrecio()) });
		}
		return rta;
	}

}
