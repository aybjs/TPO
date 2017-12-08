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
		String cant = request.getParameter("cant");
		String suc = request.getParameter("suc");
		response.getWriter().write(responder(suc, lista, Integer.parseInt(mesa), Integer.parseInt(cant)));
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	private String responder(String suc, String lista, Integer mesa, Integer cantidad) {
		String resp;
		String[] array = lista.split(",");
		Integer sucursal = 0;
		if (suc.equals("A")) {
			sucursal = 0;
		}
		else if (suc.equals("B")) {
			sucursal = 1;
		}
		else if (suc.equals("C")) {
			sucursal = 2;
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
			
			resp = sys.GenerarPedido(new PedidoDTO(lamesa, losPedidos), sucursal) + "";
			
		} catch (BusinessDelegateException e1) {
			resp = "Error RMI";
		}
		
		return resp;
	}

}
