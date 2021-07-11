package Modelo;

import java.util.ArrayList;

public class CuentaAhorro {
	private String numCuenta;
	private String cliente;
	private Double saldo;
	private Bolsillo bolsillos;

	public CuentaAhorro(String cliente) {
		super();
		this.cliente = cliente;
		this.saldo = 0.0;

	}

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
