package entities;

import java.util.Vector;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Deposito")

public class DepositoEntity {

	@Id
	@GeneratedValue
	@OneToMany
	@JoinColumn(name="producto")
	private Vector<StockEntity> productos;
	@OneToMany
	@JoinColumn(name="id")
	private Vector<RemitoEntity> remitos;
	@OneToMany
	@JoinColumn(name="id")
	private Vector<NotaDevEntity> notasDevolucion;
	@OneToMany
	@JoinColumn(name="id") //ver como queda en el autogenerado
	private Vector<MovStockEntity> movimientos;
	@Column(name="responsable")
	private String responsable;

	public DepositoEntity(){
		
	}
	public DepositoEntity(String responsable) {
		this.responsable = responsable;
		productos = new Vector<StockEntity>();
		remitos = new Vector<RemitoEntity>();
		notasDevolucion = new Vector<NotaDevEntity>();
		movimientos = new Vector<MovStockEntity>();
	}
	public Vector<StockEntity> getProductos() {
		return productos;
	}
	public void setProductos(Vector<StockEntity> productos) {
		this.productos = productos;
	}
	public Vector<RemitoEntity> getRemitos() {
		return remitos;
	}
	public void setRemitos(Vector<RemitoEntity> remitos) {
		this.remitos = remitos;
	}
	public Vector<NotaDevEntity> getNotasDevolucion() {
		return notasDevolucion;
	}
	public void setNotasDevolucion(Vector<NotaDevEntity> notasDevolucion) {
		this.notasDevolucion = notasDevolucion;
	}
	public Vector<MovStockEntity> getMovimientos() {
		return movimientos;
	}
	public void setMovimientos(Vector<MovStockEntity> movimientos) {
		this.movimientos = movimientos;
	}
	public String getResponsable() {
		return responsable;
	}
	public void setResponsable(String responsable) {
		this.responsable = responsable;
	}
	

}
