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
import rmi.BusinessDelegate;

@WebServlet("/GenerarPedido")
public class GenerarPedido extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public GenerarPedido() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/xml");
		response.setHeader("Cache-Control", "no-cache");
		String lista = request.getParameter("array");
		String mesa = request.getParameter("mesa");
		response.getWriter().write(responder(lista, Integer.parseInt(mesa)));
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	private String responder(String lista, Integer mesa) {
		String resp;
		String[] array = lista.split(",");
		BusinessDelegate sys;
		try {
			sys = BusinessDelegate.getInstancia();
			Vector<ProductoDTO> productos = sys.getTodosLosProductos();			
			MesaDTO lamesa = new MesaDTO(mesa,"Resto");
			Vector<ProductoDTO> losPedidos = new Vector<ProductoDTO>();
			
			for(int i = 0; i < array.length; i++) {
				for (int j = 0; j < productos.size(); j++) {
					if (productos.elementAt(j).getCodigo() + "" == array[i]) {
						losPedidos.addElement(productos.elementAt(j));
					}
				}
			}
			
			resp = sys.GenerarPedido(new PedidoDTO(lamesa, losPedidos)) + "";
		} catch (BusinessDelegateException e1) {
			resp = "Error RMI";
		}
		return resp;
	}

}
