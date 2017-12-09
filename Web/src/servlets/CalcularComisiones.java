package servlets;

import java.io.IOException;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.CierreCajaDTO;
import dto.ComisionesDTO;
import exceptions.BusinessDelegateException;
import exceptions.CierreException;
import rmi.BusinessDelegate;

@WebServlet("/CalcularComisiones")
public class CalcularComisiones extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CalcularComisiones() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/xml");
		response.setHeader("Cache-Control", "no-cache");
		response.getWriter().write(respuesta());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	private String respuesta() {	
		String resp = "";
		
		BusinessDelegate sys;
		try {
			sys = BusinessDelegate.getInstancia();
			Vector<ComisionesDTO> comisiones = sys.getComisiones();
			resp = resp + "<table id=\"comisiones\"><tr><th>Sucursal</th><th>Mozo</th><th>Comision</th><tr>";
			for (int i = 0; i < comisiones.size(); i++) {
				resp = resp + "<tr>";
				resp = resp + "<td>" + comisiones.elementAt(i).getSucursal() + "</td>";
				resp = resp + "<td>" + comisiones.elementAt(i).getMozo() + "</td>";
				resp = resp + "<td>" + comisiones.elementAt(i).getComision() + "</td>";
				resp = resp + "</tr>";
			}
			resp = resp + "</table>";
		} catch (BusinessDelegateException e1) {
			return "Error RMI en CerrarCaja";
		} 		
		return resp;
	}

}
