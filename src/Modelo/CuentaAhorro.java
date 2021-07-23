package Modelo;

import java.util.ArrayList;

/**
 * Clase de tipo Cuenta de Ahorro la cual el la encargada de recibir dinero y
 * crear un bolsillo si es que así el usuario lo requiere para su correcto
 * ahorro de dinero
 * 
 * @author Tatiana Arboleda, Cristhian Ortiz y Diego Valencia
 *
 */
public class CuentaAhorro {
	private String numCuenta;
	private String cliente;
	private Double saldo;
	private Bolsillo bolsillos;

	/**
	 * Método constructor encargado de crear al cliente con su respectivo nombre
	 * 
	 * @param cliente
	 */
	public CuentaAhorro(String cliente) {
		super();
		this.cliente = cliente;
		this.saldo = 0.0;

	}
	//*********************************METODOS GETS Y SETS***********************************
	public String getNumCuenta() {
		return numCuenta;
	}

	public void setNumCuenta(String numCuenta) {
		this.numCuenta = numCuenta;
	}

	public String getCliente() {
		return cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

	public Double getSaldo() {
		return saldo;
	}

	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}

	public Bolsillo getBolsillos() {
		return bolsillos;
	}

	public void setBolsillos(Bolsillo bolsillos) {
		this.bolsillos = bolsillos;
	}

}
