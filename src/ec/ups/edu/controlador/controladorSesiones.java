package ec.ups.edu.controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ec.ups.edu.dao.DAOFactory;
import ec.ups.edu.dao.TelefonoDAO;
import ec.ups.edu.dao.UsuarioDAO;
import ec.ups.edu.modelo.Usuario;

/**
 * Servlet implementation class controladorSesiones
 */
@WebServlet("/controladorSesiones")
public class controladorSesiones extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public controladorSesiones() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		HttpSession sesion = request.getSession();
		sesion.setAttribute("accesos", sesion.getAttribute("accesos"));
		
		TelefonoDAO telfDAO = DAOFactory.getFactory().getTelefonoDAO();
		Usuario usuario = new Usuario();
		UsuarioDAO usuarioDao = DAOFactory.getFactory().getUsuarioDAO();
		
		
		if(Integer.parseInt(request.getParameter("id"))==1) {
			
			UsuarioDAO usuDAO = DAOFactory.getFactory().getUsuarioDAO();
			request.setAttribute("idc", request.getParameter("c"));
			request.setAttribute("usuarios", usuDAO.find());
			
			getServletContext().getRequestDispatcher("/JSPs/CrearUsuario.jsp").forward(request, response);
		}else if(Integer.parseInt(request.getParameter("id"))==2) {
			
			usuario = usuarioDao.read(request.getParameter("idU"));
			request.setAttribute("telefonos", telfDAO.buscarCedula(usuario.getCedula()));
			request.setAttribute("usuario", usuario);
			
			getServletContext().getRequestDispatcher("/JSPs/IndexUsuario.jsp").forward(request, response);
		}
		
		if(Integer.parseInt(request.getParameter("id"))==3) {
			System.out.println("Ingresando...");
			request.setAttribute("telefonos", telfDAO.find());
			
			
			getServletContext().getRequestDispatcher("/JSPs/ModoInvitado.jsp").forward(request, response);
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
