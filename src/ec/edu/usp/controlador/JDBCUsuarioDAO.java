package ec.edu.usp.controlador;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.UsuarioDAO;
import modelo.*;

public class JDBCUsuarioDAO extends JDBCGenericDAO<Usuario, String> implements UsuarioDAO{



	/*@Override
	public void createTable() {
		// TODO Auto-generated method stub
		jdbc.update("DROP TABLE IF EXISTS Usuario");
		jdbc.update("CREATE TABLE Usuario(\r\n" + 
				"	cedula varchar(25) PRIMARY KEY,\r\n" + 
				"	nombre varchar(255) not null,\r\n" + 
				"	apellido varchar(255) not null,\r\n" + 
				"	correo varchar(255) not null,\r\n" + 
				"	contrasena varchar(255) not null\r\n" + 
				")");
	}
	*/
	
	@Override
	public void create(Usuario entity) {
		// TODO Auto-generated method stub
		jdbc.update("INSERT Usuario VALUES ('"+entity.getCedula()+"','" +entity.getNombre()+
				"','"+entity.getApellido()+"','"+ entity.getCorreo()+"','" + entity.getPwd()+"')");
	}

	
	@Override
	public Usuario read(String id) {
		// TODO Auto-generated method stub
		Usuario usu = null;
		ResultSet rs = jdbc.query("SELECT * FROM Usuario WHERE cedula="+id);
		try {
			if (rs != null && rs.next()) {
				usu = new Usuario(rs.getString("cedula"), rs.getString("nombre"), rs.getString("apellido"), rs.getString("correo"), rs.getString("contrasena"));
			}
		}catch(SQLException e) {
			System.out.println("Error al leer usuario >>"+e.getMessage());
		}
		return null;
	}

	@Override
	public void update(Usuario entity) {
		// TODO Auto-generated method stub
		jdbc.update("'UPDATE Usuario set nombre='"+ entity.getNombre() + "',apellido='"+entity.getApellido()+
				"'Where cedula='"+entity.getCedula()+"");
	}

	@Override
	public void delete(Usuario entity) {
		// TODO Auto-generated method stub
		jdbc.update("DELETE FROM Usuario WHERE cedula="+entity.getCedula());
	}

	@Override
	public List<Usuario> find() {
		// TODO Auto-generated method stub
		List<Usuario> list = new ArrayList<Usuario>();
		
		ResultSet rs = jdbc.query("SELECT * FROM Usuario");
		try {
			while(rs.next()) {
				list.add(new Usuario(rs.getString("cedula"), rs.getString("nombre"), rs.getString("correo"), rs.getString("contrasena"), rs.getString("contrasena")));
			}
		}catch(SQLException e) {
			System.out.println(">>>Warning (JDBCUsuarioDAO:find): " + e.getMessage());
		}
		return list;
	}



	
}
