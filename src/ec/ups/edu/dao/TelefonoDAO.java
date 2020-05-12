package ec.ups.edu.dao;

import ec.ups.edu.modelo.Telefono;

import java.util.List;
import ec.ups.edu.modelo.*;

public interface TelefonoDAO extends GenericDAO<Telefono, String> {

	List<Contacto> buscarCorreo(String correo);
	List<Telefono> buscarCedula(String cedula);
	List<Contacto> obtenerContacto();

	List<Contacto> buscarCedInv(String cedula);
	void eliminar2(String tel_id);
		
}
