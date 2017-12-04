package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import exceptions.BusinessDelegateException;
import rmi.BusinessDelegate;

@WebServlet("/AgregarIngrediente")
public class AgregarIngrediente extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public AgregarIngrediente() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/xml");
		response.setHeader("Cache-Control", "no-cache");
		String nombre = request.getParameter("nombre");
		String ingrediente = request.getParameter("ingrediente");
		String cantidad = request.getParameter("cantidad");
		response.getWriter().write(agregarIngrediente(nombre, ingrediente, Float.parseFloat(cantidad)));
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	private String agregarIngrediente(String nombre, String ingrediente, Float cantidad) {
		String resp = "";
		BusinessDelegate sys;
		try {
			System.out.println(sys.test("hola"));
		} catch (BusinessDelegateException e) {
			resp = "Error RMI en agregarIngrediente";
		}
		return resp;
	}
}
