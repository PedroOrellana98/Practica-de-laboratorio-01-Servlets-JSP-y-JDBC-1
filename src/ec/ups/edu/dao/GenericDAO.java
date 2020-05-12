package ec.ups.edu.dao;

import java.util.List;

import ec.ups.edu.modelo.Usuario;

public interface GenericDAO<T, ID> {
	
	//public void createTable();
	public void create(T entity);
	
	public T read(ID id);
	
	public void update(T entity);
	public void delete(T entity);
	public List<T> find();
	Usuario buscar(String email, String pwd);
	String cedula(String cdi);
}
