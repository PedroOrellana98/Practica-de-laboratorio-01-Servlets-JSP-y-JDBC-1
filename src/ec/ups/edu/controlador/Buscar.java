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
		UsuarioDAO usuDAO = DAOFactory.getFactory().getUsuarioDAO();
		TelefonoDAO telDAO = DAOFactory.getFactory().getTelefonoDAO();
		Telefono telefono = new Telefono();
		String cedula = null;
		String url= null;
		/*
		if(Integer.parseInt(request.getParameter("id")) == 1) {
			if(request.getParameter("cedula") != null) {
				System.out.println("cedula a buscar");
				request.setAttribute("telefono", telDAO.cedula(request.getParameter("cedula")));
				url = "/Practica-1/JSPs/ModoInvitado.jsp";
				getServletContext().getRequestDispatcher(url).forward(request, response);;
				
			}
		}else {
			if(Integer.parseInt(request.getParameter("id")) == 2) {
				
			}else {
				
			}
		}*/
		
		try {
			cedula = request.getParameter("cedula");
			telefono = telDAO.read(cedula);
			//telDAO;
			request.setAttribute("telefono", telefono);
			url ="/JSPs/Busquedas.jsp";
		}catch(Exception e) {
			System.out.println("BuscarCedulaServlet error: " + e.getMessage());
		}
		getServletContext().getRequestDispatcher(url).forward(request, response);;
		
	}

}
