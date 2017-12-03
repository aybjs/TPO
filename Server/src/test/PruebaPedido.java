package test;

import controllers.ControladorCentral;
import dto.PedidoDTO;
import dto.ProductoDTO;
import negocio.Pedido;

public class PruebaPedido {

	public static void main(String[] args) {
		PedidoDTO pedidodto = new PedidoDTO();
		for(ProductoDTO productos : ControladorCentral.getInstancia().getTodosLosProductos()){
			System.out.println(productos.getNombre() + productos.getStock());
			pedidodto.agregarItem(productos);
		}
		
		System.out.println(ControladorCentral.getInstancia().GenerarPedido(pedidodto));
		
		
		

	}

}
