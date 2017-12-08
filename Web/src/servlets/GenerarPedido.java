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
		String sucursal = request.getParameter("sucursal");
		String cant = request.getParameter("cant");
		response.getWriter().write(responder(sucursal, lista, Integer.parseInt(mesa), Integer.parseInt(cant)));
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	private String responder(String sucursal, String lista, Integer mesa, Integer cantidad) {
		String resp;
		String[] array = lista.split(",");
		Integer suc = 0;
		if(sucursal.equals("A")) {
			suc = 0;
		}
		else if (sucursal.equals("B")) {
			suc = 1;

		}
		else if (sucursal.equals("C")) {
			suc = 2;
		}
		BusinessDelegate sys;
		try {
			sys = BusinessDelegate.getInstancia();
			Vector<ProductoDTO> productos = sys.getTodosLosProductos();			
			MesaDTO lamesa = new MesaDTO(mesa,"Resto");
			lamesa.setCantComen(cantidad);
			Vector<ProductoDTO> losPedidos = new Vector<ProductoDTO>();
			
			for(int i = 0; i < array.length; i++) {
				for (int j = 0; j < productos.size(); j++) {
					if (array[i].equals(productos.elementAt(j).getCodigo() + "")) {
						losPedidos.add(productos.elementAt(j));
					}
				}
			}
			
			resp = sys.GenerarPedido(new PedidoDTO(lamesa, losPedidos), suc) + "";
			
		} catch (BusinessDelegateException e1) {
			resp = "Error RMI";
		}
		
		return resp;
	}

}
