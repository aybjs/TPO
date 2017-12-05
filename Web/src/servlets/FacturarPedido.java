package servlets;

import java.io.IOException;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.ProductoDTO;
import exceptions.BusinessDelegateException;
import rmi.BusinessDelegate;

@WebServlet("/FacturarPedido")
public class FacturarPedido extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public FacturarPedido() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pedido = request.getParameter("pedido");
		response.setContentType("text/xml");
		response.setHeader("Cache-Control", "no-cache");
		response.getWriter().write(Fact(Double.parseDouble(pedido)));
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	private String Fact(Double pedido) {
		BusinessDelegate sys;
		try {
			sys = BusinessDelegate.getInstancia();
			return sys.facturar(pedido) + "";
			
		} catch (BusinessDelegateException e1) {
			return "Error RMI";
		}			

	}

}
