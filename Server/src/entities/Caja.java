package entities;

import java.util.Date;
import java.util.Vector;

import enumerators.FormaPago;

public class Caja {

	private float montoDiarioEfectivo;
	private float montoDiarioInicial;
	private float montoDiarioTarjeta;
	private int cantVentasTarjeta;
	private boolean estado;
	private Date cierre;
	private Vector<Factura> facturas;
	private Vector<Float> comisiones;

	public Caja() {
		montoDiarioEfectivo = 0;
		montoDiarioInicial = 0;
		montoDiarioTarjeta = 0;
		cantVentasTarjeta = 0;
		estado = true; // TRUE es abierta
		cierre = null;
		facturas = new Vector<Factura>();
		comisiones = new Vector<Float>();
	}

	public void CerrarCaja() throws Exception {
		if (estado) {
			calcularTotales();
			calcularComisiones();
			cierre = new Date();
			estado = false;
		} else {
			throw new Exception("la caja ya estaba cerrada");
		}
	}

	private void calcularTotales() {
		for (Factura f : facturas) {
			if (f.getFormaPago() == FormaPago.efectivo)
				montoDiarioEfectivo = montoDiarioEfectivo + f.calcularTotal();
			if (f.getFormaPago() == FormaPago.tarjeta) {
				montoDiarioTarjeta = montoDiarioTarjeta + f.calcularTotal();
				cantVentasTarjeta++;
			}
		}
	}

	private void calcularComisiones() {

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
