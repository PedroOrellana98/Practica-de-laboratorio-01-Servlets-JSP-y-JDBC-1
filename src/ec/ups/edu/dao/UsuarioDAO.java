package ec.ups.edu.dao;

import ec.edu.ups.modelo.*;
import java.util.List;

public interface UsuarioDAO {
	
	void insertarUsuario(Usuario u);
	
	void eliminarUsuario(Usuario u);
	
	List<Usuario> obtenerTodos();

}
