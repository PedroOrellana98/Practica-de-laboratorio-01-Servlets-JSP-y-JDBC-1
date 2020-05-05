package ec.edu.usp.controlador;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class ContextJDBC {
	
	private static final String DRIVER = "com.mysql.jdc.Driver";
	private static final String URL = "jdbc:mysql://localhost:3306/agenda";
	private static final String USER = "root";
	private static final String pass = "cuenca";
	private static ContextJDBC jdbc1 = null;
	private static ContextJDBC jdbc2 = null;
	
	
	private static ContextJDBC jdbc = null;
	private Statement statement = null;
	
	public ContextJDBC() throws SQLException {
		this.connect();
	}
	
	protected static ContextJDBC getJDBC(){
		if(jdbc == null)
			try {
				jdbc = new ContextJDBC();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return jdbc;
	}
	
	public void connect() {
		try {
			Class.forName(DRIVER);
			Connection connection  = DriverManager.getConnection(URL,USER,pass);
			this.statement = connection.createStatement();
			
		}catch(SQLException e) {
			System.out.println("Imposible cargar el driver: "+e.getMessage());
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
			System.out.println("Problema en el query update: " + sql + "---" + e);
		}
		
		return false;
	}
	
	protected static ContextJDBC getJDBC1() {
		// creación de la conexión a la base de datos solo si no ha sido creada patrón
		// de diseño singleton
		if (jdbc1 == null) {
			try {
				jdbc1 = new ContextJDBC();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return jdbc1;

	}

	/**
	 * Método getJDBC.
	 * 
	 * Obtiene una conexión activa a la base de datos
	 * 
	 * @return jdbc
	 */
	protected static ContextJDBC getJDBC2() {
		// creación de la conexión a la base de datos solo si no ha sido creada patrón
		// de diseño singleton
		if (jdbc2 == null) {
			try {
				jdbc2 = new ContextJDBC();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return jdbc2;

	}

}
