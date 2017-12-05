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

@WebServlet("/CrearPlato")
public class CrearPlato extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CrearPlato() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String precioS = request.getParameter("precio");
		String nombreS = request.getParameter("nombre");
		String stockS = request.getParameter("stock");
		String comisionExtraS = request.getParameter("comisionExtra");
		String areaProd = request.getParameter("areaProd");

		float precio = Float.parseFloat(precioS);
		String nombre = nombreS;
		float stock = Float.parseFloat(stockS);
		float comisionExtra = Float.parseFloat(comisionExtraS);
		
		response.setContentType("text/xml");
		response.setHeader("Cache-Control", "no-cache");
		
		if (precio != 0 && nombre != null && stock != 0 && comisionExtra != 0 && areaProd != null) {
			response.getWriter().write(crearPlato(precio, nombre, stock, comisionExtra));
		}
		else {
			response.getWriter().write("Falta Nombre, Area y/o numeros en 0");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	private String crearPlato(float precio, String nombre, float stock, float comisionExtra) {
		String resp = "";
		
		BusinessDelegate sys = null;
		ProductoDTO prod = new ProductoDTO();
		prod.setComisionExtra(comisionExtra);
		prod.setNombre(nombre);
		prod.setPrecio(precio);
		prod.setStock(stock);
		
		try {
			sys = BusinessDelegate.getInstancia();
			Vector<String> ingredientes = sys.agregarPlato(prod);
			resp = resp + "<table><tr><th>Ingrediente</th><th>cantidad</th></tr>";
			for (int i = 0; i < ingredientes.size(); i++) {
				resp = resp + "<tr>";
				resp = resp + "<td><span class=\"ing\" id=\"ing." + ingredientes.elementAt(i) + "\"> " + ingredientes.elementAt(i) + "</td>";
				resp = resp + "<td><input type=\"text\" class=\"cant\" id=\"cant. " + ingredientes.elementAt(i) + "\" value=\"0\" ></td>";
				resp = resp + "</tr>";
			}
			resp = resp + "</table>";
			
			resp = resp + "<button class=\"pedir\" type=\"button\" id=\"agregarIngredientes\" onclick=\"agregarIngredientes()\" >Agregar Ingredientes</button>";
			
		} catch (BusinessDelegateException e) {
			resp = "Error RMI en CrearPlato";
			e.printStackTrace();
		}
		
		return resp;		
	}
	
}
