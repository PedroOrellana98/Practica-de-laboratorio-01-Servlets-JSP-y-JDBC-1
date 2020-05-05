package ec.edu.usp.controlador;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import ec.edu.ups.modelo.Telefono;


public class JDBCTelefonoDAO extends JDBCGenericDAO<Telefono, String>{

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
	}
	
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
		ResultSet rs = jdbc.query("SELECT * FROM Telefono where tel_codigo=" + id);
		
		try {
			if(rs != null ) {
				t = new Telefono(String.valueOf(rs.getInt("tel_codigo")), rs.getString("tel_numero"), rs.getString("tel_tipo"), rs.getString("tel_operadora"));
			}
		}catch(SQLException e) {
			System.out.println(">>> Warning (TelefonoDAO:read): "+ e.getMessage());
		}
		
		
		return null;
	}

	@Override
	public void update(Telefono entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Telefono entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Telefono> find() {
		// TODO Auto-generated method stub
		return null;
	}

	

	

}
