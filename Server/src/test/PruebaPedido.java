package test;

import controllers.ControladorCentral;
import dao.MozoDAO;
import dto.MesaDTO;
import dto.MozoDTO;
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
		MesaDTO m = new MesaDTO();
		m.setId(2);
		pedidodto.setMesa(m);
		m.setMozo(new MozoDTO(1,"Ger",1));
		
		System.out.println(ControladorCentral.getInstancia().GenerarPedido(pedidodto));
		
		
		

	}

}
