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

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
    	String nombre = request.getParameter("mesa");
		if ((nombre != null)) {
			response.setContentType("text/xml ");
			response.setHeader("Cache-Control", "no-cache");
			response.getWriter().write("AJAX OK" + " para mesa " + nombre);
		} else {
			response.setContentType("text/xml ");
			response.setHeader("Cache-Control", "no-cache");
			response.getWriter().write("AJAX OK 2");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
