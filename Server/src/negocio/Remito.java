package negocio;

import java.time.LocalDate;
import java.util.Vector;

public class Remito {

	private static int id = 0;
	private Vector<ItemRemito> items;
	private LocalDate fecha;

	public Remito() {
		id++;
		this.items = new Vector<ItemRemito>();
		this.fecha = LocalDate.now();
	}

	public Vector<ItemRemito> getItems() {
		return items;
	}

	public void setItems(Vector<ItemRemito> items) {
		this.items = items;
	}

	public static int getId() {
		return id;
	}

	public LocalDate getFecha() {
		return fecha;
	}

}
