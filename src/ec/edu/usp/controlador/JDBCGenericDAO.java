package ec.edu.usp.controlador;

import dao.GenericDAO;

public abstract class JDBCGenericDAO<T, ID> implements GenericDAO<T, ID>{
	
	protected ContextJDBC jdbc = ContextJDBC.getJDBC();
	
}
