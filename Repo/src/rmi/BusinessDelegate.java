package rmi;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Date;
import java.util.List;

import dto.*;
import exceptions.*;
import tda.*;

public class BusinessDelegate{

	private static BusinessDelegate Instancia;
	
	private TDAControladorCentralRemoto ControladorCentralRemoto;
	
    public static BusinessDelegate getInstancia() throws BusinessDelegateException{
    	if (Instancia==null){
    		Instancia = new BusinessDelegate();
    	}
    	return Instancia;
    }
        
    private BusinessDelegate() throws BusinessDelegateException{
    	try{
    		ControladorCentralRemoto = (TDAControladorCentralRemoto)Naming.lookup ("//localhost/ControladorCentralRemoto");
    	}
    	catch (MalformedURLException | RemoteException | NotBoundException e) { throw new BusinessDelegateException("Problemas con RMI"); }
    }
    
	public List<ProductoDTO> getComprasPendiente() throws ComprasPendientesException, BusinessDelegateException{
		try{
			return ControladorCentralRemoto.getComprasPendiente();
		}
    	catch (RemoteException  e) { throw new BusinessDelegateException("Problemas con RMI"); }
	}
	
	public void ingresarProducto(String codigo, int cantidad, int lote, Date vencimiento) throws BusinessDelegateException{
		try{
			ControladorCentralRemoto.ingresarProducto(codigo, cantidad, lote, vencimiento);
		}
    	catch (RemoteException  e) { throw new BusinessDelegateException("Problemas con RMI"); }
	}
	
	public void ingresarTarea(String codigo, String nombre, String categoria, int minutos) throws BusinessDelegateException{
		try{
			ControladorCentralRemoto.ingresarTarea(codigo, nombre, categoria, minutos);
		}
    	catch (RemoteException  e) { throw new BusinessDelegateException("Problemas con RMI"); }
	}
	
	public void asignarTarea(String codigo, int cantidad, String resto) throws BusinessDelegateException{
		try {
			ControladorCentralRemoto.asignarTarea(codigo, cantidad, resto);
		} 
    	catch (RemoteException  e) { throw new BusinessDelegateException("Problemas con RMI"); }
	}
	
	public void noFacturable(String resto, String nroEmpleado, int cantidad) throws BusinessDelegateException{
		try {
			ControladorCentralRemoto.noFacturable(resto, nroEmpleado, cantidad);
		} 
    	catch (RemoteException  e) { throw new BusinessDelegateException("Problemas con RMI"); }
	}
	
	public void tomarOrden(String resto, String nroEmpleado, int itemCarta, int cantidad, boolean facturable) throws BusinessDelegateException{
		try {
			ControladorCentralRemoto.tomarOrden(resto, nroEmpleado, itemCarta, cantidad, facturable);
		} 
    	catch (RemoteException  e) { throw new BusinessDelegateException("Problemas con RMI"); }
	}
	
	public void solicitarMovimiento(String resto, String producto, int cantidad, String destino) throws BusinessDelegateException{
		try {
			ControladorCentralRemoto.solicitarMovimiento(resto, producto, cantidad, destino);
		} 
    	catch (RemoteException  e) { throw new BusinessDelegateException("Problemas con RMI"); }
	}
	
	public void solicitarMovimientoCentral(String resto, String producto, int cantidad) throws BusinessDelegateException{
		try {
			ControladorCentralRemoto.solicitarMovimientoCentral(resto, producto, cantidad);
		} 
    	catch (RemoteException  e) { throw new BusinessDelegateException("Problemas con RMI"); }
	}
	
	public List<ReposicionDTO> recibirListaReposicion(List<ReposicionDTO> lista) throws BusinessDelegateException{
		try {
			return ControladorCentralRemoto.recibirListaReposicion(lista);
		} 
    	catch (RemoteException  e) { throw new BusinessDelegateException("Problemas con RMI"); }
	}
	
	public void crearOC() throws BusinessDelegateException{
		try {
			ControladorCentralRemoto.crearOC();
		} 
    	catch (RemoteException  e) { throw new BusinessDelegateException("Problemas con RMI"); }
	}
	
	public void solicitarInsumosNormal(String codResto) throws BusinessDelegateException{
		try {
			ControladorCentralRemoto.solicitarInsumosNormal(codResto);
		} 
    	catch (RemoteException  e) { throw new BusinessDelegateException("Problemas con RMI"); }
	}
	
	public void solicitarInsumosExtra(String codResto, String producto, int cantidad, String solicitante) throws BusinessDelegateException{
		try {
			ControladorCentralRemoto.solicitarInsumosExtra(codResto, producto, cantidad, solicitante);
		} 
    	catch (RemoteException  e) { throw new BusinessDelegateException("Problemas con RMI"); }
	}
	
	public void generarMovimientoStock() throws BusinessDelegateException{
		try {
			ControladorCentralRemoto.generarMovimientoStock();
		} 
    	catch (RemoteException  e) { throw new BusinessDelegateException("Problemas con RMI"); }
	}
	
	public String test(String aux) throws BusinessDelegateException {
		try {
			return ControladorCentralRemoto.test(aux);
		} 
    	catch (RemoteException  e) { throw new BusinessDelegateException("Problemas con RMI"); }
	}
	

	
}