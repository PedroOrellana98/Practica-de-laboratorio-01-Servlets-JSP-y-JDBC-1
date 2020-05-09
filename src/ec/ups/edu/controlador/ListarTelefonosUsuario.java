package ec.ups.edu.controlador;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ec.ups.edu.dao.DAOFactory;
import ec.ups.edu.dao.TelefonoDAO;
import ec.ups.edu.dao.UsuarioDAO;
import ec.ups.edu.modelo.Telefono;

/**
 * Servlet implementation class ListarTelefonosUsuario
 */
@WebServlet("/ListarTelefonosUsuario")
public class ListarTelefonosUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private TelefonoDAO telfDAO;
	private UsuarioDAO usuDAO;
	private List<Telefono> listaTelefono;
	private String cdi ="";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListarTelefonosUsuario() {
        super();
        telfDAO = DAOFactory.getFactory().getTelefonoDAO();
        usuDAO = DAOFactory.getFactory().getUsuarioDAO();
        
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		try {
			
			listaTelefono = telfDAO.find();
			
			request.setAttribute("listaTelefono", listaTelefono);
			System.out.println("desde el controlador"+listaTelefono);
			getServletContext().getRequestDispatcher("/Practica-1/JSPs/IndexUsuario.jsp").forward(request, response);
		}catch(Exception e) {
		}
		
	}
/*
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	/*
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
*/
}
