package test;

import java.util.Vector;

import objetoRemoto.ControladorCentralRemoto;
import rmi.BusinessDelegate;
import controllers.ControladorCentral;
import dto.*;
import exceptions.BusinessDelegateException;

public class Testing {

	public static void main(String[] args) {
		// Acá podemos hacer pruebas de metodos.

		BusinessDelegate negocio;
		try {
			negocio = BusinessDelegate.getInstancia();

		
		// EMPEZAR ACA
		

			/***************************GENERO PEDIDO*********************/
			System.out.println("Generando pedido");
			Vector<ProductoDTO> productos = negocio.getTodosLosProductos();
			MesaDTO laMesa = negocio.getMesa(0, 0);
			laMesa.setCantComen(2);
			laMesa.setEstado("Ocupada");
			double nroPedido = negocio.GenerarPedido(new PedidoDTO(laMesa, productos), 0);
			System.out.println("nro de pedido: " + nroPedido);
			System.out.println("fin creación de pedido");
			/****************CERRAR LA MESA********************************/
			System.out.println(negocio.facturar(nroPedido));
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

}
