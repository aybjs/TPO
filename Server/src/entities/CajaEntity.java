package entities;

import java.util.Date;
import java.util.Vector;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import enumerators.FormaPago;

@Entity
@Table(name="CajaEntity")

public class CajaEntity {

	@Id
	@GeneratedValue
	@Column(name="montoDiarioEfectivo")
	private float montoDiarioEfectivo;
	@Column(name=" montoDiarioInicial")
	private float montoDiarioInicial;
	@Column(name="montoDiarioTarjeta")
	private float montoDiarioTarjeta;
	@Column(name="catVentasTarjeta")
	private int cantVentasTarjeta;
	@Column(name="estado")
	private boolean estado;
	@Column(name="cierre")
	private Date cierre;
	@OneToMany
	@JoinColumn(name="nroFactura")
	private Vector<FacturaEntity> facturas;
	@OneToMany
	@JoinColumn(name="nroEmpleado")
	private Vector<Float> comisiones;
	
	public CajaEntity(){
	}

	public float getMontoDiarioEfectivo() {
		return montoDiarioEfectivo;
	}

	public float getMontoDiarioInicial() {
		return montoDiarioInicial;
	}

	public void setMontoDiarioInicial(float montoDiarioInicial) {
		this.montoDiarioInicial = montoDiarioInicial;
	}

	public float getMontoDiarioTarjeta() {
		return montoDiarioTarjeta;
	}

	public int getCantVentasTarjeta() {
		return cantVentasTarjeta;
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	public Date getCierre() {
		return cierre;
	}

	public Vector<Float> getComisiones() {
		return comisiones;
	}

	public void setComisiones(Vector<Float> comisiones) {
		this.comisiones = comisiones;
	}

}
