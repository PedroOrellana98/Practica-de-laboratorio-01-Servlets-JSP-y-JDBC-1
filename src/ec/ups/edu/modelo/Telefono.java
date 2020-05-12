package ec.ups.edu.modelo;

import java.io.Serializable;

public class Telefono implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private int telf_id;
	private String codigo;
	private String numero;
	private String tipo;
	private String operadora;

	
	public Telefono() {
		
	}
	
	public Telefono(int telf_id, String codigo, String numero, String tipo, String operadora) {
		super();
		this.telf_id = telf_id;
		this.codigo = codigo;
		this.numero = numero;
		this.tipo = tipo;
		this.operadora = operadora;
	}
	
	public Telefono(String codigo, String numero, String tipo, String operadora) {
		super();
		this.codigo = codigo;
		this.numero = numero;
		this.tipo = tipo;
		this.operadora = operadora;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getOperadora() {
		return operadora;
	}
	public void setOperadora(String operadora) {
		this.operadora = operadora;
	}
	
	



	public int getTelf_id() {
		return telf_id;
	}

	public void setTelf_id(int telf_id) {
		this.telf_id = telf_id;
	}
	

}
