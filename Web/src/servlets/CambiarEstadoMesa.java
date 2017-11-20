package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/CambiarEstadoMesa")
public class CambiarEstadoMesa extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CambiarEstadoMesa() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String mesa = request.getParameter("mesa");
		if ((mesa != null)) {
			response.setContentType("text/xml ");
			response.setHeader("Cache-Control", "no-cache");
			response.getWriter().write("AJAX OK");
		} else {
			response.setContentType("text/xml ");
			response.setHeader("Cache-Control", "no-cache");
			response.getWriter().write("AJ0"
					+ "AX OK 2");
		}
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
