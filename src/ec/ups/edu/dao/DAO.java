package ec.ups.edu.dao;

import java.util.*;

public interface DAO<T, K> {
	
	void insertar(T K);
	
	void modificar(T K);
	
	void eliminar(T K);
	
	List<T> obtenerTodos();
	
	T obtener(K id);

}
