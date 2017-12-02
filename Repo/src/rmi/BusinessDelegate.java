package rmi;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.List;

import dto.*;
import exceptions.*;
import tda.*;

//El BusinessDelegate NO DEBE implementar la Interfaz (TDA), solo usarlo
//Todas las RemoteExceptions deben ser tomadas por este

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
    		ControladorCentralRemoto = (TDAControladorCentralRemoto)Naming.lookup ("//localhost/ControladorRemoto");
    	}
    	catch (MalformedURLException | RemoteException | NotBoundException e) { throw new BusinessDelegateException("Problemas con RMI"); }
    }
    
    public void crearMateria(String codigo, String descripcion) throws BusinessDelegateException{
    	try{
    		ControladorCentralRemoto.crearMateria(codigo,  descripcion);
    	}
    	catch (RemoteException  e) { throw new BusinessDelegateException("Problemas con RMI"); }	
    }
	
}