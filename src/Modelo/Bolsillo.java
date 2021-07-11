package Modelo;

public class Bolsillo {
	private String numCuenta;
	private Double saldo;

	public Bolsillo(String numCuenta) {
		super();
		this.numCuenta = numCuenta + "b";
		this.saldo = 0.0;
	}

	public String getNumCuenta() {
		return numCuenta;
	}

	public void setNumCuenta(String numCuenta) {
		this.numCuenta = numCuenta;
	}

	public Double getSaldo() {
		return saldo;
	}

	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}

}
