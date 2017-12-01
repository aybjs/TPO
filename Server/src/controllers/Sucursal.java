package controllers;

import java.util.ArrayList;
import java.util.Vector;

import negocio.*;

public class Sucursal {
	
	private String codigoResto;
	private Vector<Mesa> mesas; 
	private Caja caja;
	private Deposito deposito;
	private Carta carta;
	private Vector<Mozo> mozos; //los mozos se cargan de la DB cuando se abre la app
	private Vector<Pedido> pedidos; //sigo pensando que los pedidos van en la mesa
	
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
	 public GenerarPedido (int nroMesa ){}
	


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
