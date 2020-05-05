package test;

import dao.*;
import modelo.*;

public class testUsuario {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		UsuarioDAO usuDAO = DAOFactory.getFactory().getUsuarioDAO();
		
		
		Usuario u1, u2, u3, u4, u5;
		
		u1 = new Usuario("1400923302", "jessiel","gonzalez", "ralexjessiel2@gmail.com","123");
		u2 = new Usuario("1400", "sharon","gonzalez", "ralexjessiel1@gmail.com","123");
		
		usuDAO.create(u1);
		usuDAO.create(u2);
		System.out.println("Creacion de usuario " + usuDAO.find());
		
		usuDAO.delete(u2);
		System.out.println("Eliminando un usuario: " + usuDAO.find());
		

	}

}
