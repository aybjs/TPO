package server;

import java.rmi.*;
import java.rmi.registry.LocateRegistry;

import controllers.*;
import tda.*;

public class Server {
    
	TDAControladorCentralRemoto ControladorCentralRemoto;
	
	public static void main(String[] args)
	{
		new Server();
	}
	
	public Server() {
		iniciar();
	}
	
    public void iniciar() {
    	try {
    		ControladorCentralRemoto = new ControladorCentralRemoto();
    		LocateRegistry.createRegistry(1099);
    		Naming.rebind ("//localhost/ControladorCentralRemoto", ControladorCentralRemoto);
            System.out.println("Servidor online en //localhost/ControladorCentralRemoto");
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
}
