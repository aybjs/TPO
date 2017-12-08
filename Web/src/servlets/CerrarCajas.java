package servlets;

import java.io.IOException;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.CierreCajaDTO;
import exceptions.BusinessDelegateException;
import exceptions.CierreException;
import rmi.BusinessDelegate;

@WebServlet("/CerrarCajas")
public class CerrarCajas extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CerrarCajas() {
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
			Vector<CierreCajaDTO> cajas = sys.CerrarSucursales();
			resp = resp + "<table id=\"tablacajas\"><tr><th>Sucursal</th><th>Tarjeta</th><th>Efectivo</th><tr>";
			for (int i = 0; i < cajas.size(); i++) {
				resp = resp + "<tr>";
				resp = resp + "<td>" + cajas.elementAt(i).getNroSucursal() + "</td>";
				resp = resp + "<td>" + cajas.elementAt(i).getTotalTarjeta() + "</td>";
				resp = resp + "<td>" + cajas.elementAt(i).getTotalEfectivo() + "</td>";
				resp = resp + "</tr>";
			}
			resp = resp + "</table>";
		} catch (BusinessDelegateException e1) {
			return "Error RMI en CerrarCaja";
		} catch (CierreException e) {
			return "Error por Excepciónd de Cierre Caja";
		}			
		return resp;
	}

}
