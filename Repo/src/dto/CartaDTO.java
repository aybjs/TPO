package dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.Vector;

public class CartaDTO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4428099681924500167L;

	private Vector<ProductoDTO> productos;
	private static int idCarta = 0;
	private LocalDate desde;
	private LocalDate hasta;

	public CartaDTO() {
		idCarta++;
		productos = new Vector<ProductoDTO>();
		desde = LocalDate.now();
		hasta = LocalDate.now().plusYears(1);
	}

	public Vector<ProductoDTO> getProductos() {
		return productos;
	}

	public void setProductos(Vector<ProductoDTO> productos) {
		this.productos = productos;
	}

	public static int getIdCarta() {
		return idCarta;
	}

	public static void setIdCarta(int idCarta) {
		CartaDTO.idCarta = idCarta;
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
