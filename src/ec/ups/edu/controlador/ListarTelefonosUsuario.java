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
	private TelefonoDAO telDAO;
	private UsuarioDAO usuDAO;
	private List<Telefono> telList;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListarTelefonosUsuario() {
        super();
        // TODO Auto-generated constructor stub
        telDAO = DAOFactory.getFactory().getTelefonoDAO();

    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		String url= null;
		try {
			telList = telDAO.find();
			
			System.out.println("recuperando lsita de telefonos");
			System.out.println(telList);
			
			request.setAttribute("telefonos", telList);
			url="/JSPs/IndexUsuario.jsp";
			
		}catch(Exception e) {
			System.out.println("Problemas en listartel" + e.getMessage());
		}
		getServletContext().getRequestDispatcher(url).forward(request, response);
		
	}
/*
	
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
