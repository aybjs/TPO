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

@WebServlet("/SumarPedidos")
public class SumarPedidos extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SumarPedidos() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/xml");
		response.setHeader("Cache-Control", "no-cache");
		response.getWriter().write(sumarProductos());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	private String sumarProductos() {
		String resp = "";
		int codigo;
		float precio;
		String nombre;
		float stock;
		float comisionExtra;
		BusinessDelegate sys;
		try {
			sys = BusinessDelegate.getInstancia();
			Vector<ProductoDTO> productos = sys.getTodosLosProductos();
			//resp = "<table><tr><th>codigo</th><th>precio</th><th>nombre</th><th>stock</th><th>comision</th><th>agregar</th></tr>";
			resp = "<table><tr><th>codigo</th><th>precio</th><th>nombre</th><th>agregar</th></tr>";
			for (int i = 0; i < productos.size(); i++) {
				codigo = productos.elementAt(i).getCodigo();
				precio = productos.elementAt(i).getPrecio();
				nombre = productos.elementAt(i).getNombre();
				stock = productos.elementAt(i).getStock();
				comisionExtra = productos.elementAt(i).getComisionExtra();
				resp = resp + "<tr>";
				resp = resp + "<td>" + codigo + "</td>";
				resp = resp + "<td>" + precio + "</td>";
				resp = resp + "<td>" + nombre + "</td>";
				//resp = resp + "<td>" + stock + "</td>";
				//resp = resp + "<td>" + comisionExtra + "</td>";
				resp = resp + "<td> <input type=\"checkbox\" value=\"" + codigo + "\" >";
				resp = resp + "</tr>";
			}
			resp = resp + "</table>";
			resp = resp + "<br />";
			resp = resp + "<button class=\"pedir\" type=\"button\" id=\"sumar\" onclick=\"sumarAlPedido()\">Sumar productos</button>";
			
		} catch (BusinessDelegateException e1) {
			resp = "Error RMI";
		}
		return resp;
	}

}
