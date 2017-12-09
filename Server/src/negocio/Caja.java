package negocio;

import java.util.Date;

import exceptions.*;

import java.util.Vector;

import dto.ComisionesDTO;
import enumerators.FormaPago;

public class Caja {

	private float montoDiarioEfectivo;
	private float montoDiarioInicial;
	private float montoDiarioTarjeta;
	private int cantVentasTarjeta;
	private boolean estado;
	private Date cierre;
	private Vector<Factura> facturas;
	private Vector<ComisionesDTO> comisiones;

	public Caja() {
		montoDiarioEfectivo = 0;
		montoDiarioInicial = 0;
		montoDiarioTarjeta = 0;
		cantVentasTarjeta = 0;
		comisiones = new Vector<ComisionesDTO>();
		estado = true; // TRUE es abierta
		cierre = null;
		facturas = new Vector<Factura>();
	}

	public void CerrarCaja(String codResto) throws CierreException {
		if (estado) {
			calcularTotales();
			calcularComisiones(codResto);
			cierre = new Date();
			estado = false;
		} else {
			//throw new CierreException("la caja ya estaba cerrada");
			//Se omite la excepción para que se pueda visualizar el cierre siempre (sirve para desarrollo)
			//Una vez puesto en producción habrá que eliminar las siguientes lineas y DEScomentar la primera del "else"
			calcularTotales();
			calcularComisiones(codResto);
			cierre = new Date();
			estado = false;
		}
	}

	private void calcularTotales() {
		for (Factura f : facturas) {
			if (f.getFormaPago().equals("efectivo") )
				montoDiarioEfectivo = montoDiarioEfectivo + f.calcularTotal();
			if (f.getFormaPago().equals("tarjeta")) {
				montoDiarioTarjeta = montoDiarioTarjeta + f.calcularTotal();
				cantVentasTarjeta++;
			}
		}
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
	
	public Vector<ComisionesDTO> getComisiones() throws CierreException{
		if(!estado)
			return comisiones;
		else throw new CierreException("la caja todavia esta abierta");
	}

	
	private Vector<ComisionesDTO> calcularComisiones(String codigoResto){
		Vector<ComisionesDTO> rta = new Vector<ComisionesDTO>();
		for(Factura f : facturas){
			String mozo = f.getPedido().getMesa().getMozo().getNombre();
			float extra = f.getPedido().getMesa().getMozo().getComision();
			float base = 0;
			for (ProductoCompuesto p : f.getPedido().getItems()){
				float complato = p.getComisionExtra();
				float cometa = complato + extra; 
				base = base  + p.getPrecio() * cometa;
			}
			rta.add(new ComisionesDTO(mozo, base, codigoResto));
		}
		return rta;
	}

}
