package controllers;

import java.util.Vector;

import dto.*;
import exceptions.CierreException;
import negocio.*;

public class Sucursal {
	
	private String codigoResto;
	private Vector<Mesa> mesas;
	private Caja caja;
	private Deposito deposito;
	private Carta carta;
	private Vector<AreaProduccion> areas;
	private Vector<Mozo> mozos; //los mozos se cargan de la DB cuando se abre la app
	private Vector<Pedido> pedidos; //sigo pensando que los pedidos van en la mesa

	public Sucursal(){
		
	}
	
	public Sucursal(String codigoResto){
		this.codigoResto = codigoResto;
		mesas = new Vector<Mesa>();
		caja = new Caja();
		deposito = new Deposito("responsable");
		carta = new Carta();
		mozos = new Vector<Mozo>();
		pedidos = new Vector<Pedido>();
		init();
	}	

	public void AbrirMesa(int nroEmpleado, Vector<Integer> mesas, int cantPersonas){
		Mozo mozo = getMozo(nroEmpleado);
		if (mesas.size() == 1)
			AbrirMesaIndividual(mesas.firstElement(), mozo, cantPersonas);
		else
			AbrirMesaCompuesta(mesas, mozo, cantPersonas);		
	}
	 public void GenerarPedido (int nroMesa, Vector<Pedido> pedidos ){
		 //FALTA
	 }
	 
	 public int getTiempoTareas(String area) {
		 // TODO Auto-generated method stub
		 AreaProduccion aux = getArea(area);
		 return aux.getTiempoRestante();
		}
	 
		public Vector<TareaDTO> getTareas() {
			// TODO Auto-generated method stub
			Vector<TareaDTO> rta = new Vector<TareaDTO>();
			Vector<Tarea> aux = new Vector<Tarea>();
			for (AreaProduccion area : areas)
				for (Tarea t : area.getTareas())			
					aux.add(t);
			for (Tarea t : aux)
				rta.add(t.toDTO());			
			return rta;
		}
		
		public CierreCajaDTO cierreCaja() throws CierreException{
			this.caja.CerrarCaja(this.codigoResto);
			CierreCajaDTO cierre = new CierreCajaDTO(codigoResto);
			cierre.setTotalEfectivo(caja.getMontoDiarioEfectivo());
			cierre.setTotalTarjeta(caja.getMontoDiarioTarjeta());
			return cierre;	
		}
		
		public Vector<ComisionesDTO> getComisiones() throws CierreException{
			return caja.getComisiones();
		}
		

		

		/***** Metodos privados *****/
	
	 private AreaProduccion getArea(String area) {
		// TODO Auto-generated method stub
		 for (AreaProduccion aux : areas)
			 if (aux.getNombreArea().compareToIgnoreCase(area)== 0)
				 return aux;
		 return null;
	}


	
	private void init() {
		// metodo que hace todo lo necesario al iniciar la aplicacion
		
	}
	private Mozo getMozo(int nroEmpleado) {
		return null;
	}
	
	private void AbrirMesaIndividual(Integer firstElement, Mozo mozo, int cantPersonas) {
		// TODO Auto-generated method stub
		
	}
	
	private void AbrirMesaCompuesta(Vector<Integer> mesas2, Mozo mozo, int cantPersonas) {
		// TODO Auto-generated method stub
		
	}

	public String getCodigoResto() {
		return codigoResto;
	}

	public void setCodigoResto(String codigoResto) {
		this.codigoResto = codigoResto;
	}

	public Vector<Mesa> getMesas() {
		return mesas;
	}

	public void setMesas(Vector<Mesa> mesas) {
		this.mesas = mesas;
	}

	public Caja getCaja() {
		return caja;
	}

	public void setCaja(Caja caja) {
		this.caja = caja;
	}

	public Deposito getDeposito() {
		return deposito;
	}

	public void setDeposito(Deposito deposito) {
		this.deposito = deposito;
	}

	public Carta getCarta() {
		return carta;
	}

	public void setCarta(Carta carta) {
		this.carta = carta;
	}

	public Vector<AreaProduccion> getAreas() {
		return areas;
	}

	public void setAreas(Vector<AreaProduccion> areas) {
		this.areas = areas;
	}

	public Vector<Mozo> getMozos() {
		return mozos;
	}

	public void setMozos(Vector<Mozo> mozos) {
		this.mozos = mozos;
	}

	public Vector<Pedido> getPedidos() {
		return pedidos;
	}

	public void setPedidos(Vector<Pedido> pedidos) {
		this.pedidos = pedidos;
	}
	
	public void abrirCaja(){
		caja.setEstado(true);
	}



}
