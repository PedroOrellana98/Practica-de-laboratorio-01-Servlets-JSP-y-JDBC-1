package ec.edu.usp.controlador;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;

public class ContextJDBC {
	
	public static final String DRIVER = "com.mysql.jdc.Driver";
	public static final String URL = "jdbc:mysql://localhost:3306/agenda";
	public static final String USER = "root";
	public static final String pass="";
	
	private static ContextJDBC jdbc = null;
	private Statement statement = null;
	
	public ContextJDBC() throws SQLException {
		this.connect();
	}
	
	protected static ContextJDBC getJDBC() throws SQLException {
		if(jdbc == null) jdbc = new ContextJDBC();
		return jdbc;
	}
	
	private void connect() throws SQLException {
		try {
			Class.forName(DRIVER);
			Connection connection  = DriverManager.getConnection(URL,USER,pass);
			this.statement = connection.createStatement();
			
		}catch(ClassNotFoundException e) {
			System.out.println("Imposible cargar el driver: "+e.getMessage());
		}
	}
	
	
	public ResultSet query(String sql) {
		try {
			return this.statement.executeQuery(sql);
			
		}catch(SQLException e) {
			System.out.println("Problema en el query: "+sql+"---"+e);
		}
		return null;
	}
	
	public boolean update(String sql) {
		try {
			this.statement.executeUpdate(sql);
			return true;
		}catch(SQLException e) {
			System.out.println("Problema en el query update: "+sql+"---"+e);
		}
		
		return false;
	}

}
