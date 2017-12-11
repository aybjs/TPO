package servlets;

import java.io.IOException;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.MesaDTO;
import dto.PedidoDTO;
import dto.ProductoDTO;
import exceptions.BusinessDelegateException;
import exceptions.MesaException;
import rmi.BusinessDelegate;

@WebServlet("/AgregarAlPedido")
public class AgregarAlPedido extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AgregarAlPedido() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/xml");
		response.setHeader("Cache-Control", "no-cache");
		String lista = request.getParameter("array");
		String mesa = request.getParameter("mesa");
		String suc = request.getParameter("sucursal");
		String pedido = request.getParameter("pedido");
		response.getWriter().write(responder(lista, Integer.parseInt(mesa), suc, pedido));
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	private String responder(String lista, Integer mesa, String suc, String pedido) {
		String resp;
		String[] array = lista.split(",");
		Integer sucursal = 0;
		double idPedido = Double.parseDouble(pedido);
		if(suc.compareToIgnoreCase("A") == 0)
			sucursal = 0;
		if(suc.compareToIgnoreCase("B") == 0)
			sucursal = 1;
		if(suc.compareToIgnoreCase("C") == 0)
			sucursal = 2;
		BusinessDelegate sys;
		try {
			sys = BusinessDelegate.getInstancia();
			Vector<ProductoDTO> productos = sys.getTodosLosProductos();			
			Vector<ProductoDTO> losPedidos = new Vector<ProductoDTO>();
			
			for(int i = 0; i < array.length; i++) {
				for (int j = 0; j < productos.size(); j++) {
					if (array[i].equals(productos.elementAt(j).getCodigo() + "")) {
						losPedidos.add(productos.elementAt(j));
					}
				}
			}
			
			sys.agregarItem(idPedido,  sucursal,  losPedidos);
			
			resp = "1";
			
		} 
		catch (BusinessDelegateException e1) { resp = "0"; }
		
		return resp;
	}

}
