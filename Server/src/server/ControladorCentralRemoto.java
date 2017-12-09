package server;

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
	
	public Vector<ComisionesDTO> getComisiones() throws CierreException, RemoteException{
		return negocio.getComisiones();
	}
	
	public Vector<CierreCajaDTO> cerrarSucursales() throws RemoteException{
		return negocio.cerrarCajas();
	}
	
	public List<ProductoDTO> getComprasPendiente() throws ComprasPendientesException, RemoteException{
		return negocio.getComprasPendiente();		
	}
	
	public void ingresarProducto(String codigo, int cantidad, int lote, Date vencimiento) throws RemoteException{
		negocio.ingresarProducto(codigo, cantidad, lote, vencimiento);
	}
	
	public void noFacturable(String resto, String nroEmpleado, int cantidad) throws RemoteException{
		negocio.noFacturable(resto, nroEmpleado, cantidad);
	}
	
	public void tomarOrden(String resto, String nroEmpleado, int itemCarta, int cantidad, boolean facturable) 
			throws RemoteException{
		negocio.tomarOrden(resto, nroEmpleado, itemCarta, cantidad, facturable);
	}
	
	public void solicitarMovimiento(String resto, String producto, int cantidad, String destino) 
			throws RemoteException{
		negocio.solicitarMovimiento(resto, producto, cantidad, destino);
	}
	
	public void solicitarMovimientoCentral(String resto, String producto, int cantidad) throws RemoteException{
		negocio.solicitarMovimientoCentral(resto, producto, cantidad);
	}
	
	public List<ReposicionDTO> recibirListaReposicion(List<ReposicionDTO> lista) throws RemoteException{
		return negocio.recibirListaReposicion(lista);
	}
	
	public void crearOC() throws RemoteException{
		negocio.crearOC();
	}
	
	public void solicitarInsumosNormal(String codResto) throws RemoteException{
		negocio.solicitarInsumosNormal(codResto);
	}
	
	public void solicitarInsumosExtra(String codResto, String producto, int cantidad, String solicitante) throws RemoteException{
		negocio.solicitarInsumosExtra(codResto, producto, cantidad, solicitante);
	}
	
	public void generarMovimientoStock() throws RemoteException{
		negocio.generarMovimientoStock();
	}
	
	public String test(String aux)  throws RemoteException{
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

	public double GenerarPedido(PedidoDTO p, int suc) throws RemoteException{
		return negocio.GenerarPedido(p, suc);
	}

	public void agregarPlato(ProductoDTO p) throws RemoteException, ProductoException {
		negocio.agregarPlato(p);
		
	}

	public void agregarIngredientes(String nombre, String sector, Float minimo, 
			Float comision, Float consumo, String medida) throws RemoteException {
		negocio.agregarIngredientes(nombre, sector, minimo,comision, consumo, medida);
		
	}

	public float facturar(double idPedido) throws RemoteException {
		// TODO Auto-generated method stub
		float facturar=0;
		facturar = ControladorCentral.getInstancia().facturar(idPedido);
		return facturar;
	}
}
