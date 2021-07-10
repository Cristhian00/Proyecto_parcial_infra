package Modelo;

import java.util.HashMap;

public class Cliente {
	private String nombre;
	private int contrasena;
	private CuentaAhorro cuentaCliente;
	private HashMap<Integer, Transaccion> transacciones;
	
	public Cliente( String nombre,  int contrase�a) {
		super();
		this.nombre = nombre;
		this.contrasena = contrasena;
		this.transacciones= new HashMap<Integer, Transaccion>();
		
	}



	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public int getContrasena() {
		return contrasena;
	}

	public void setContrasena(int contrase�a) {
		this.contrasena = contrase�a;
	}

	public CuentaAhorro getCuentaCliente() {
		return cuentaCliente;
	}

	public void setCuentaCliente(CuentaAhorro cuentaCliente) {
		this.cuentaCliente = cuentaCliente;
	}

	public HashMap<Integer, Transaccion> getTransacciones() {
		return transacciones;
	}

	public void setTransacciones(HashMap<Integer, Transaccion> transacciones) {
		this.transacciones = transacciones;
	}
	
	
	
	
	
	

}
