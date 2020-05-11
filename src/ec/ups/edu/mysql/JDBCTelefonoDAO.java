package ec.ups.edu.mysql;

import java.sql.ResultSet;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ec.ups.edu.dao.TelefonoDAO;
import ec.ups.edu.modelo.Contacto;
import ec.ups.edu.modelo.Telefono;
import ec.ups.edu.modelo.Usuario;


public class JDBCTelefonoDAO extends JDBCGenericDAO<Telefono, String> implements TelefonoDAO{
	/*
	@Override
	public void createTable() {
		// TODO Auto-generated method stub
		jdbc.update("DROP TABLE IF EXISTS Telefono");
		jdbc.update("CREATE TABLE Telefono(\r\n" + 
				"	tel_codigo int AUTO_INCREMENT,\r\n" + 
				"	usu_cedula varchar(25) not null,\r\n" + 
				"	tel_numero varchar(255) null,\r\n" + 
				"	tel_tipo varchar(255) null,\r\n" + 
				"	tel_operadora varchar(255) null,\r\n" + 
				"	PRIMARY KEY (tel_codigo), \r\n" + 
				"	FOREIGN KEY (usu_cedula)\r\n" + 
				"		REFERENCES  Usuario (cedula)\r\n" + 
				")");
	}*/
	
	@Override
	public void create(Telefono entity) {
		// TODO Auto-generated method stub
		jdbc1.update("INSERT into telefono (tel_cedula, tel_numero, tel_tipo, tel_operadora) values"
				+ " ( '" + entity.getCodigo() + "', '"
		+ entity.getNumero() + "','"+entity.getTipo()+"','"+entity.getOperadora()+"' )");
	}

	@Override
	public Telefono read(String id) {
		// TODO Auto-generated method stub
		
		Telefono t = null;
		ResultSet rs = jdbc.query("SELECT * FROM Telefono where tel_cedula='" + id+"'");
		
		try {
			if(rs.next()) {
				t = new Telefono(String.valueOf(rs.getInt("tel_codigo")), rs.getString("tel_numero"), rs.getString("tel_tipo"), rs.getString("tel_operadora"));
			}
		}catch(SQLException e) {
			System.out.println(">>> Warning (TelefonoDAO:read): "+ e.getMessage());
		}
		
		
		return t;
	}

	@Override
	public void update(Telefono entity) {
		// TODO Auto-generated method stub
		jdbc.update("UPDATE Telefono SET tel_numero = '" + entity.getNumero() + "', tel_tipo = '" +  entity.getTipo() + 
				"', tel_operadora = '" + entity.getOperadora() + "'WHERE tel_codigo = " + entity.getCodigo());
	}

	@Override
	public void delete(Telefono entity) {
		// TODO Auto-generated method stub
		jdbc.update("DELETE FROM Telefono WHERE tel_codigo =" + entity.getCodigo());
	}

	@Override
	public List<Telefono> find() {
		// TODO Auto-generated method stub
		List<Telefono> listTelefono = new ArrayList<Telefono>();
		ResultSet rs = jdbc.query("SELECT * FROM Telefono");
		try {
			while(rs.next()) {
				listTelefono.add(new Telefono(String.valueOf(rs.getInt("tel_codigo")), rs.getString("tel_numero"), rs.getString("tel_tipo"), rs.getString("tel_operadora")));
				//System.out.println("desde el jdbcTelefono"+listTelefono);
			}
		}catch(SQLException e) {
			System.out.println(">>> WARNING (JDBCTelefonoDAO: find) : " + e.getMessage());
		}
		
		
		return listTelefono;
	}
	

	@Override
	public Usuario buscar(String email, String pwd) {
		// TODO Auto-generated method stub
		System.out.println("Email: ------------- "+email.toString());
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
		String ced = null;
		Usuario us = null;
		ced = us.getCedula();
		ResultSet rs = jdbc1.query("SELECT * FROM Usuario WHERE cedula='"+cdi+"'");
		try {
			if( rs != null && rs.next()) {
				ced = rs.getString("cedula");
			}
		}catch(SQLException e) {
			
		}
		return ced;
		

	}

	@Override
	public List<Contacto> buscarCorreo(String correo) {
		// TODO Auto-generated method stub
		List<Contacto> listCont = new ArrayList<Contacto>();
		System.out.print("Consultando.....");
		
		List<Telefono> list = new ArrayList<Telefono>();
		ResultSet rs = jdbc.query("SELECT * FROM telefono, usuario where usuario.cedula=telefono.tel_cedula and usuario.correo="+"'"+ correo+"'");
		//ResultSet t = null;
		try {
			while (rs.next()) {
				Contacto cont=new Contacto();
				//list.add(new telefono(rs.getInt("tel_codigo"), rs.getString("tel_cedula"), rs.getString("tel_numero"),rs.getString("tel_tipo"), rs.getString("tel_operadora")));
				cont.setNumero(rs.getString("tel_numero"));
				
				cont.setOperadora(rs.getString("tel_operadora"));
				
				cont.setTipo(rs.getString("tel_tipo"));
				
				cont.setNombres(rs.getString("nombre"));
				
				cont.setApellidos(rs.getString("apellido"));
				
				cont.setCorreo(rs.getString("correo"));

				listCont.add(cont);
				
			}

		} catch (SQLException e) {
			System.out.println(">>>WARNING (JDBCTelefonoDAO:obtenerContacto): " + e.getMessage());
		}
		
		return listCont;
	}

	@Override
	public List<Telefono> buscarCedula(String cedula) {
		List<Telefono> list = new ArrayList<Telefono>();
		ResultSet rs = jdbc.query("SELECT * FROM usuario, telefono WHERE telefono.tel_cedula=usuario.cedula and usuario.cedula="+ cedula);
		try {
			while (rs.next()) {
				list.add(new Telefono(String.valueOf(rs.getInt("tel_codigo")), rs.getString("tel_numero"), rs.getString("tel_tipo"), rs.getString("tel_operadora")));
				//System.out.println("desde el jdbcTelefono"+listTelefono);
			
			}

		} catch (SQLException e) {
			System.out.println(">>>WARNING (JDBCTelefonoDAO:find): " + e.getMessage());
		}
		return list;
	}

	@Override
	public List<Contacto> obtenerContacto() {
		// TODO Auto-generated method stub
		List<Contacto> listCont = new ArrayList<Contacto>();
		System.out.print("Consultando.....");
		
		//Usuario user = new Usuario();
		
		List<Telefono> list = new ArrayList<Telefono>();
		ResultSet rs = jdbc1.query("SELECT * FROM telefono, usuario where usuario.cedula=telefono.tel_cedula");
		//ResultSet t = null;
		try {
			while (rs.next()) {
				Contacto cont=new Contacto();
				//list.add(new telefono(rs.getInt("tel_codigo"), rs.getString("tel_cedula"), rs.getString("tel_numero"),rs.getString("tel_tipo"), rs.getString("tel_operadora")));
				cont.setNumero(rs.getString("tel_numero"));
				
				cont.setOperadora(rs.getString("tel_operadora"));
				
				cont.setTipo(rs.getString("tel_tipo"));
				
				cont.setNombres(rs.getString("nombre"));
				
				cont.setApellidos(rs.getString("apellido"));
				
				cont.setCorreo(rs.getString("correo"));
				
				
				
				
				
				listCont.add(cont);
				
			}

		} catch (SQLException e) {
			System.out.println(">>>WARNING (JDBCTelefonoDAO:obtenerContacto): " + e.getMessage());
		}
		
		

		return listCont;
}

	@Override
	public List<Contacto> buscarCedInv(String cedula) {
		// TODO Auto-generated method stub
		List<Contacto> listCont = new ArrayList<Contacto>();
		System.out.print("Consultando.....");
		
		List<Telefono> list = new ArrayList<Telefono>();
		ResultSet rs = jdbc1.query("SELECT * FROM telefono, usuario where usuario.cedula=telefono.tel_cedula and usuario.cedula="+"'"+cedula+"'");
		//ResultSet t = null;
		try {
			while (rs.next()) {
				Contacto cont=new Contacto();
				//list.add(new telefono(rs.getInt("tel_codigo"), rs.getString("tel_cedula"), rs.getString("tel_numero"),rs.getString("tel_tipo"), rs.getString("tel_operadora")));
				cont.setNumero(rs.getString("tel_numero"));
				
				cont.setOperadora(rs.getString("tel_operadora"));
				
				cont.setTipo(rs.getString("tel_tipo"));
				
				cont.setNombres(rs.getString("nombre"));
				
				cont.setApellidos(rs.getString("apellido"));
				
				cont.setCorreo(rs.getString("correo"));

				listCont.add(cont);
				
			}

		} catch (SQLException e) {
			System.out.println(">>>WARNING (JDBCTelefonoDAO:obtenerContacto): " + e.getMessage());
		}
		return listCont;
	}


	

}
