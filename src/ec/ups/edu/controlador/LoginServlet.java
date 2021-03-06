package ec.ups.edu.controlador;

import java.io.IOException;

import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
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
import ec.ups.edu.mysql.ContextJDBC;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet(name = "LoginServlet", urlPatterns = { "/LoginServlet" })
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html:charset=UTF-8");

		UsuarioDAO usuarioDao = DAOFactory.getFactory().getUsuarioDAO();
		String correo = "";
		String contrasena = "";
		String url = null;
		int i = 0;

		String accion = request.getParameter("resp");
		Usuario user = new Usuario();
		HttpSession sesion = request.getSession(true);

		sesion.setAttribute("accesos", sesion.getId());
		System.out.println("ID sesion: " + String.valueOf(sesion.getId()));
		if (accion.equals("Login")) {
			correo = request.getParameter("user");
			contrasena = request.getParameter("password");
			user = usuarioDao.buscar(correo, contrasena);
			System.out.println("retorno de usuario: "+ usuarioDao.buscar(correo, contrasena));
			url="/JSPs/IndexUsuario.jsp";
			try {
				if (user != null) {
					TelefonoDAO telfDAO = DAOFactory.getFactory().getTelefonoDAO();

					request.setAttribute("telefono", telfDAO.buscarCedula(user.getCedula()));
					request.setAttribute("usuario", user);
					
					getServletContext().getRequestDispatcher(url).forward(request, response);
				} 
			} catch (Exception e) {
				System.out.println("Error en el login: " + e.getMessage());
			}
		}else {
			getServletContext().getRequestDispatcher("/JSPs/Login.jsp").forward(request, response);
		}
		

	}

}
