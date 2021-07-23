package Modelo;

/**
 * Clase de tipo Bolsillo el cual tiene como función guardar el dinero que se le
 * transfiera desde la cuenta donde fue creado y guardarlo como un ahorro
 * 
 * @author Tatiana Arboleda, Cristhian Ortiz y Diego Valencia
 *
 */
public class Bolsillo {
	private String numCuenta;
	private Double saldo;

	/**
	 * Método constructor el cual necesita el número de la cuenta donde pertenece
	 * 
	 * @param numCuenta
	 */
	public Bolsillo(String numCuenta) {
		super();
		this.numCuenta = numCuenta + "b";
		this.saldo = 0.0;
	}

	// *****************************METODOS GETS Y SETS****************************************
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
