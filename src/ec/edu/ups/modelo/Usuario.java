package ec.edu.ups.modelo;

import java.awt.List;

import ec.edu.ups.modelo.*;

public class Usuario {
	
	private String cedula;
	private String nombre;
	private String apellido;
	private String correo;
	private String pwd;
	//private List telefonoList;
	
	public Usuario() {
		
	}
	
	public Usuario(String cedula, String nombre, String apellido, String correo) {
		this.setCedula(cedula);
		this.setNombre(nombre);
		this.setApellido(apellido);
		this.setCorreo(correo);
	}
	
	
	public String getCedula() {
		return cedula;
	}
	public void setCedula(String cedula) {
		this.cedula = cedula;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	
	

}
