package ec.ups.edu.mysql;

import java.sql.ResultSet;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ec.ups.edu.dao.TelefonoDAO;
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
		jdbc.update("INSERT Telefono VALUES ("+entity.getCodigo() +",'" + entity.getNumero() 
		+ "','" + entity.getTipo() + "','" + entity.getOperadora() + "')");
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
	public int buscar(String email, String pwd) {
		// TODO Auto-generated method stub
		return 0;
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


	

}
