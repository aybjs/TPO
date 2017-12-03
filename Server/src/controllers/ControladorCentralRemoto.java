package controllers;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Date;
import java.util.List;
import java.util.Vector;

import controllers.*;
import dto.*;
import negocio.*;
import tda.*;
import exceptions.*;

@SuppressWarnings("unused")
public class ControladorCentralRemoto extends UnicastRemoteObject implements TDAControladorCentralRemoto{

	private static final long serialVersionUID = -5979120908112077617L;
	
	private ControladorCentral negocio;

	public ControladorCentralRemoto() throws RemoteException {
		super();
		negocio = ControladorCentral.getInstancia();
	}
	
	public List<ProductoDTO> getComprasPendiente() throws ComprasPendientesException{
		return negocio.getComprasPendiente();		
	}
	
	public void ingresarProducto(String codigo, int cantidad, int lote, Date vencimiento){
		negocio.ingresarProducto(codigo, cantidad, lote, vencimiento);
	}
	
	public void noFacturable(String resto, String nroEmpleado, int cantidad){
		negocio.noFacturable(resto, nroEmpleado, cantidad);
	}
	
	public void tomarOrden(String resto, String nroEmpleado, int itemCarta, int cantidad, boolean facturable){
		negocio.tomarOrden(resto, nroEmpleado, itemCarta, cantidad, facturable);
	}
	
	public void solicitarMovimiento(String resto, String producto, int cantidad, String destino){
		negocio.solicitarMovimiento(resto, producto, cantidad, destino);
	}
	
	public void solicitarMovimientoCentral(String resto, String producto, int cantidad){
		negocio.solicitarMovimientoCentral(resto, producto, cantidad);
	}
	
	public List<ReposicionDTO> recibirListaReposicion(List<ReposicionDTO> lista){
		return negocio.recibirListaReposicion(lista);
	}
	
	public void crearOC(){
		negocio.crearOC();
	}
	
	public void solicitarInsumosNormal(String codResto){
		negocio.solicitarInsumosNormal(codResto);
	}
	
	public void solicitarInsumosExtra(String codResto, String producto, int cantidad, String solicitante){
		negocio.solicitarInsumosExtra(codResto, producto, cantidad, solicitante);
	}
	
	public void generarMovimientoStock(){
		negocio.generarMovimientoStock();
	}
	
	public String test(String aux) {
		return negocio.test(aux);
	}

	public Vector<ProductoDTO> getTodosLosProductos() throws RemoteException {
		return negocio.getTodosLosProductos();
	}

	public ProductoDTO getProducto(int idProducto) throws RemoteException {
		return negocio.getProducto(idProducto);
	}

	public void ingresarTarea(Integer codigo, String nombre, String categoria, int cantidad) throws RemoteException {
		negocio.ingresarTarea(codigo, nombre, categoria, cantidad);
	}

	public void asignarTareas() throws RemoteException {
		negocio.asignarTareas();
	}

	public double GenerarPedido(PedidoDTO p) {
		return negocio.GenerarPedido(p);
	}
}
