package tda;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Date;
import java.util.List;

import dto.*;
import exceptions.*;

public interface TDAControladorCentralRemoto extends Remote {
		 	
	public List<ProductoDTO> getComprasPendiente() throws RemoteException, ComprasPendientesException;
	
	public void ingresarProducto(String codigo, int cantidad, int lote, Date vencimiento) throws RemoteException;
	
	public void ingresarTarea(String codigo, String nombre, String categoria, int minutos) throws RemoteException;
	
	public void asignarTarea(String codigo, int cantidad, String resto) throws RemoteException;
	
	public void noFacturable(String resto, String nroEmpleado, int cantidad) throws RemoteException;
	
	public void tomarOrden(String resto, String nroEmpleado, int itemCarta, int cantidad, boolean facturable) throws RemoteException;
	
	public void solicitarMovimiento(String resto, String producto, int cantidad, String destino) throws RemoteException;
	
	public void solicitarMovimientoCentral(String resto, String producto, int cantidad) throws RemoteException;
	
	public List<ReposicionDTO> recibirListaReposicion(List<ReposicionDTO> lista) throws RemoteException;
	
	public void crearOC() throws RemoteException;
	
	public void solicitarInsumosNormal(String codResto) throws RemoteException;
	
	public void solicitarInsumosExtra(String codResto, String producto, int cantidad, String solicitante) throws RemoteException;
	
	public void generarMovimientoStock() throws RemoteException;
	
	public String test(String aux) throws RemoteException;
	
}