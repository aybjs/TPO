package test;

import controllers.ControladorCentral;
import dao.MozoDAO;
import dto.MesaDTO;
import dto.MozoDTO;
import dto.PedidoDTO;
import dto.ProductoDTO;
import negocio.Pedido;

public class PruebaPedido {

	public static void main(String[] args) throws Exception {
		ControladorCentral negocio = ControladorCentral.getInstancia();
		System.out.println("armo el pedido");
		PedidoDTO pedidodto = new PedidoDTO();
		for(ProductoDTO productos : ControladorCentral.getInstancia().getTodosLosProductos()){
			System.out.println(productos.getNombre() + " " + productos.getPrecio());
			pedidodto.agregarItem(productos);
		}
		MesaDTO m = new MesaDTO();
		m.setId(2);
		pedidodto.setMesa(m);
		m.setMozo(MozoDAO.getInstance().recuperarMozo(7).toDTO());
		double id = ControladorCentral.getInstancia().GenerarPedido(pedidodto);
		Pedido ped = ControladorCentral.getInstancia().getPedido(id);
		System.out.println("Valor: " + ped.subTotal());
		
		
		
		

	}

}
