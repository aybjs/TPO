package controllers;

import java.util.Vector;

import negocio.*;

public class Sucursal {
	
	@SuppressWarnings("unused")
	private String codigoResto;
	@SuppressWarnings("unused")
	private Vector<Mesa> mesas;
	@SuppressWarnings("unused")
	private Caja caja;
	@SuppressWarnings("unused")
	private Deposito deposito;
	@SuppressWarnings("unused")
	private Carta carta;
	@SuppressWarnings("unused")
	private Vector<Mozo> mozos; //los mozos se cargan de la DB cuando se abre la app
	@SuppressWarnings("unused")
	private Vector<Pedido> pedidos; //sigo pensando que los pedidos van en la mesa

	@SuppressWarnings("unused")
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

	/***** Metodos privados *****/
	
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

}
