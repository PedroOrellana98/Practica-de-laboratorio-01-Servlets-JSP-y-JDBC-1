package ec.ups.edu.controlador;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ec.ups.edu.dao.DAOFactory;
import ec.ups.edu.dao.TelefonoDAO;
import ec.ups.edu.dao.UsuarioDAO;
import ec.ups.edu.mysql.ContextJDBC;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
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
		response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html:charset=UTF-8");
		
		UsuarioDAO usuDAO = DAOFactory.getFactory().getUsuarioDAO();
		String email ="";
		String pwd = "";
		String url=null;
		int i=0;
		
		String resp = request.getParameter("resp");
		
		if(resp.equals("Login")) {
			email = request.getParameter("user");
			pwd = request.getParameter("password");
			
			i = usuDAO.buscar(email, pwd);
			System.out.println(i);
		}
		try {
			if(i>0) {
				//TelefonoDAO telDAO = DAOFactory.getFactory().getTelefonoDAO();
				
				//request.setAttribute("Telefono", telDAO.find());
				getServletContext().getRequestDispatcher("/JSPs/IndexUsuario.jsp").forward(request, response);
			}else {
				getServletContext().getRequestDispatcher("/Practica-1//welcome.html").forward(request, response);
			}
		}catch(Exception e) {
			System.out.println(">>>WARNING (LOGINSERVEL):DOPOS: T"+e.getMessage());
		}
		
		
				
		
	
	}

}
