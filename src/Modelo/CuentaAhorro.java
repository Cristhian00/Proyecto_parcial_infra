package Modelo;

import java.util.ArrayList;

public class CuentaAhorro {
	private String numCuenta;
	private Cliente usuario;
	private Double saldo;
	private Bolsillo bolsillos ;
	
	public CuentaAhorro( Cliente usuario) {
		super();
		this.usuario = usuario;
		this.saldo = 0.0;
		
	}
	public String getNumCuenta() {
		return numCuenta;
	}
	public void setNumCuenta(String numCuenta) {
		this.numCuenta = numCuenta;
	}
	public Cliente getUsuario() {
		return usuario;
	}
	public void setUsuario(Cliente usuario) {
		this.usuario = usuario;
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
