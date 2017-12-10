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
		

			/***************************GENERO PEDIDOS*********************/
			//Vector<ProductoDTO> productos = negocio.getTodosLosProductos();
			/**System.out.println("Generando pedido");
			MesaDTO laMesa = negocio.getMesa(0, 0);
			laMesa.setCantComen(2);
			laMesa.setEstado("Ocupada");
			double nroPedido = negocio.GenerarPedido(new PedidoDTO(laMesa, productos), 0);
			System.out.println("nro de pedido: " + nroPedido);
			System.out.println("fin creación de pedido");
			System.out.println("Generando pedido2");
			laMesa = negocio.getMesa(0, 1);
			laMesa.setCantComen(3);
			laMesa.setEstado("Ocupada");
			double nroPedido2 = negocio.GenerarPedido(new PedidoDTO(laMesa, productos), 0);
			System.out.println("nro de pedido: " + nroPedido2);
			System.out.println("fin creación de pedido");**/
			/**System.out.println("Generando pedido3");
			laMesa = negocio.getMesa(2, 7);
			laMesa.setCantComen(1);
			laMesa.setEstado("Ocupada");
			double nroPedido3 = negocio.GenerarPedido(new PedidoDTO(laMesa, productos), 1);
			System.out.println("nro de pedido: " + nroPedido3);
			System.out.println("fin creación de pedido");**/
			/****************CERRAR LA MESAS********************************/
			//System.out.println(negocio.facturar(nroPedido, "Efectivo"));
			//System.out.println(negocio.facturar(nroPedido2, "Efectivo"));
			//System.out.println(negocio.facturar(nroPedido3, "Tarjeta"));
			/****************CERRAR LAS CAJAS******************************/
			for (CierreCajaDTO aux : negocio.CerrarSucursales()){
				System.out.println("Sucursal: "+ aux.getNroSucursal() + " Total Efectivo: $" + aux.getTotalEfectivo()
						+ " Total Tarjetas: $" + aux.getTotalTarjeta());
			}
				
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

}
