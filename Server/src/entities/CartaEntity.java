package entities;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.Vector;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Carta")

public class CartaEntity {
	
	@Id
	@GeneratedValue
	@OneToMany
	@JoinColumn(name="codigo")
	private Vector<ProductoEntity> productos;
	@Column(name="idCarta")
	private static int idCarta = 0;
	@Column(name="desde")
	private LocalDate desde;
	@Column(name="hasta")
	private LocalDate hasta;

	public CartaEntity(){
		
	}

	public Vector<ProductoEntity> getProductos() {
		return productos;
	}

	public void setProductos(Vector<ProductoEntity> productos) {
		this.productos = productos;
	}

	public static int getIdCarta() {
		return idCarta;
	}

	public static void setIdCarta(int idCarta) {
		CartaEntity.idCarta = idCarta;
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
	
	/*public Carta() {
		idCarta++;
		productos = new Vector<Producto>();
		desde = LocalDate.now();
		hasta = LocalDate.now().plusYears(1);
	}*/

	/*public void agregarProducto(ProductoEntity p) {
		productos.add(p);
	}

	public Vector<String[]> listarProductos() {
		Vector<String[]> rta = new Vector<String[]>();
		for (Producto p : productos) {
			rta.add(new String[] { p.getNombre(), Float.toString(p.getPrecio()) });
		}
		return rta;
	}*/
	

}
