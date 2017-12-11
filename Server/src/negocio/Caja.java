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
			//Se omite la excepci�n para que se pueda visualizar el cierre siempre (sirve para desarrollo)
			//Una vez puesto en producci�n habr� que eliminar las siguientes lineas y DEScomentar la primera del "else"
			calcularTotales();
			calcularComisiones(codResto);
			cierre = new Date();
			estado = false;
		}
	}

	private void calcularTotales() {
		for (Factura f : facturas) {
			if (f.getFormaPago().compareToIgnoreCase("Efectivo")==0 )
				montoDiarioEfectivo = montoDiarioEfectivo + f.calcularTotal();
			if (f.getFormaPago().compareToIgnoreCase("Tarjeta") == 0) {
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
	
	public Vector<ComisionesDTO> getComisiones(){
		return comisiones;
	}

	
	private void calcularComisiones(String codigoResto){
		Vector<ComisionesDTO> rta = new Vector<ComisionesDTO>();
		for(Factura f : facturas){
			String mozo = f.getPedido().getMesa().getMozo().getNombre();
			float extra = f.getPedido().getMesa().getMozo().getComision() / 100;
			float base = 0;
			for (ProductoCompuesto p : f.getPedido().getItems()){
				float complato = p.getComisionExtra();
				float cometa = complato + extra; 
				base = base  + p.getPrecio() * cometa;
			}
			Integer indice = BuscarMozo(rta, mozo);
			if (indice == null)
				rta.add(new ComisionesDTO(mozo, base, codigoResto));
			else{
				rta.elementAt(indice).setComision(base + rta.elementAt(indice).getComision());
			}
		}
		this.comisiones = rta;
	}
	
	private Integer BuscarMozo(Vector<ComisionesDTO> rta, String mozo) {
		// TODO Auto-generated method stub
		int i = 0;
		for (ComisionesDTO cometa : rta){
			if (cometa.getMozo().compareToIgnoreCase(mozo)==0)
				return i;
			i++;			
		}
		return null;
	}

	public void agregarFactura (Factura factura){
		this.facturas.add(factura);
	}

}
