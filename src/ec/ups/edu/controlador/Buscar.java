package ec.ups.edu.controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ec.ups.edu.dao.DAOFactory;
import ec.ups.edu.dao.TelefonoDAO;
import ec.ups.edu.dao.UsuarioDAO;
import ec.ups.edu.modelo.Telefono;
import ec.ups.edu.modelo.Usuario;

/**
 * Servlet implementation class BuscarPorCedula
 */
@WebServlet("/BuscarPorCedula")
public class Buscar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Buscar() {
        super();
        // TODO Auto-generated constructor stub
        
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		TelefonoDAO telefonoDao = DAOFactory.getFactory().getTelefonoDAO();

		// out.println("<h1>Gracias por acceder al servidor</h1>");
		// sesion.setAttribute("accesos", 1);
		System.out.println("Buscando");
		if (Integer.parseInt(request.getParameter("id")) == 1) {
			// Correo
			if (request.getParameter("correo") != null) {
				System.out.print("Correo: " + request.getParameter("correo"));

				request.setAttribute("telefono", telefonoDao.buscarCorreo(request.getParameter("correo")));
				getServletContext().getRequestDispatcher("/Practica-1/JSPs/Busquedas.jsp").forward(request, response);

			}

		} else {

		}

		if (Integer.parseInt(request.getParameter("id")) == 2) {
			// Cedula
			if (request.getParameter("cedula") != null) {
				System.out.print("Cedula: " + request.getParameter("cedula"));
				request.setAttribute("telefono", telefonoDao.buscarCedInv(request.getParameter("cedula")));
				getServletContext().getRequestDispatcher("/Practica-1/JSPs/Busquedas.jsp").forward(request, response);
			}
		} else {

		}
		
	}

}
