package ec.edu.usp.controlador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDAO {
	public static final String DRIVER = "com.mysql.jdc.Driver";
	public static final String URL = "jdbc:mysql://localhost:3306/agenda";
	public static final String USER = "root";
	public static final String pass="cuenca";
	
	public static boolean validar(String correo, String contrasena) {
		boolean estado = false;
		
		try {
			Class.forName(DRIVER);
			Connection con  = DriverManager.getConnection(URL,USER,pass);
			PreparedStatement ps = con.prepareStatement("select * from Usuario where correo=? and contrasena=?");
			ps.setString(1, correo);
			ps.setString(2, contrasena);
			ResultSet rs = ps.executeQuery();
		}catch(SQLException e) {
			System.out.println("Error al crear conexion, loginDAO");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return estado;
	}
	

}
