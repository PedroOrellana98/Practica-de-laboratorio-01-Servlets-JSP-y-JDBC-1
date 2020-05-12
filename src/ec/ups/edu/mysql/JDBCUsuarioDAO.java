package ec.ups.edu.mysql;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ec.ups.edu.dao.UsuarioDAO;
import ec.ups.edu.modelo.*;

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
		jdbc1.update("INSERT Usuario VALUES ('"+entity.getCedula()+"', '" +entity.getNombre()+
				"','"+entity.getApellido()+"','"+ entity.getCorreo()+"','" + entity.getPwd()+"')");
	}

	
	@Override
	public Usuario read(String id) {
		// TODO Auto-generated method stub
		Usuario usuOBJ = null;
		ResultSet rs = jdbc1.query("SELECT * FROM Usuario WHERE cedula=" + id);
		try {
			if (rs != null && rs.next()) {
				usuOBJ = new Usuario(rs.getString("cedula"), rs.getString("nombre"), rs.getString("apellido"), rs.getString("correo"), rs.getString("contrasena"));
			}
		}catch(SQLException e) {
			System.out.println("WARNING>> (JDBCUsuarioDAO):read "+e.getMessage());
		}
		return usuOBJ;
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
		//, usuario where usuario.cedula = telefono.tel_cedula
		ResultSet rs = jdbc.query("SELECT * FROM Usuario");
		try {
			while(rs.next()) {
				list.add(new Usuario(rs.getString("cedula"), rs.getString("nombre"), rs.getString("correo"), rs.getString("contrasena"), rs.getString("contrasena")));
			}
		}catch(SQLException e) {
			System.out.println(">>>Warning (JDBCUsuarioDAO:find): " + e.getMessage());
		}
		for(Usuario usu: list) {
			System.out.println(usu.getCedula() +", "+ usu.getNombre()+", "+usu.getNombre());
		}
		return list;
	}


	@Override
	public Usuario buscar(String email, String pwd) {
		// TODO Auto-generated method stub
		
		//System.out.println("Email: ------------- "+email.toString());
		int i=0;
		Usuario usuarioObject = null;
		ResultSet rs = jdbc1.query("SELECT * FROM Usuario WHERE  correo=" +  "'" + email + "'" + "AND contrasena=" +  "'" + pwd + "'" );
		try {
			if (rs != null && rs.next()) {
				i=1;
				usuarioObject = new Usuario (rs.getString("cedula"), rs.getString("nombre"), rs.getString("apellido"),rs.getString("correo"), rs.getString("contrasena"));
			}
		} catch (SQLException e) {
			System.out.println(">>>WARNING (JDBCUsuarioDAO:read): " + e.getMessage());
		}
		return usuarioObject;
	}


	@Override
	public String cedula(String cdi) {
		// TODO Auto-generated method stub
		return null;
	}



}
