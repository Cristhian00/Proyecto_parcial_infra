package Modelo;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import Persistencia.LeerArchivo;

/**
 * Clase de tipo Banco la cual es la encargada de crear todos los procesos que
 * se vayan a hacer con las cuentas sea crear, actualizar, eliminar, consultar,
 * etc
 * 
 * @author Tatiana Arboleda, Cristhian Ortiz y Diego Valencia
 *
 */
public class Banco {

	private ArrayList<CuentaAhorro> listaCuentaAhorros;
	private ArrayList<Bolsillo> listaBolsillo;
	private int numeroCuenta;
	private int numTransaccion;
	private HashMap<String, Transaccion> transacciones;
	private LeerArchivo miArchivo;

	public Banco() {
		super();
		this.listaCuentaAhorros = new ArrayList<CuentaAhorro>();
		this.listaBolsillo = new ArrayList<Bolsillo>();
		this.numeroCuenta = 0;
		this.numTransaccion = 1;
		this.transacciones = new HashMap<String, Transaccion>();
		this.miArchivo = new LeerArchivo();
	}


	// ******************************CRUD Y OTROS MÉTODOS DE CUENTA*************************************

	/**
	 * Método encargado de crear una cuenta de ahorro verificando que la cuenta no
	 * sea repetida y tambien que la cuenta exista
	 * 
	 * @param cuenta
	 * @throws Exception
	 */
	public void crearCuenta(CuentaAhorro cuenta) {

		listaCuentaAhorros.add(cuenta);
		setNumeroCuenta(getNumeroCuenta() + 1);

		registraTransaccion(cuenta.getNumCuenta(), "ABRIR_CUENTA");

		imprimirDatos();
	}
	
	/**
	 * Método encargado de consultar el saldo de una cuenta consultando por su
	 * número correspondiente, eso sí, la cuenta debe de existir
	 * 
	 * @param numCuenta
	 * @return numero de saldo que tiene la cuenta a consultar
	 * @throws Exception
	 */	
	public double consultarSaldoCuenta(String numCuenta) {

		double saldo = 0.0;
		for (int i = 0; i < listaCuentaAhorros.size(); i++) {

			if (listaCuentaAhorros.get(i).getNumCuenta().equals(numCuenta)) {
				saldo = listaCuentaAhorros.get(i).getSaldo();
			}
		}
		registraTransaccion(numCuenta, "CONSULTAR_SALDO_CUENTA");
		return saldo;
	}

	/**
	 * Método encargado de eliminar una cuenta dado su numero correspondiente, la
	 * cuenta debe de existir y no tener dinero en ella
	 * 
	 * @param numCuenta
	 * @throws Exception
	 */
	public void eliminarCuenta(String numCuenta) {

		for (int i = 0; i < listaCuentaAhorros.size(); i++) {
			if (listaCuentaAhorros.get(i).getNumCuenta().equals(numCuenta)) {
				listaCuentaAhorros.remove(i);
				break;
			}
		}

		registraTransaccion(numCuenta, "CANCELAR_CUENTA");

		// imprimirDatos();
	}
	
	/**
	 * Método encargado de depositar dinero en una cuenta existente dado su numero
	 * correspondiente y el monto correspondiente
	 * 
	 * @param numCuenta
	 * @param saldo
	 * @throws Exception
	 */
	public void depositarDinero(String numCuenta, double saldo) {

		double nuevoSaldo = 0.0;
		for (int i = 0; i < listaCuentaAhorros.size(); i++) {
			if (listaCuentaAhorros.get(i).getNumCuenta().equals(numCuenta)) {
				nuevoSaldo = listaCuentaAhorros.get(i).getSaldo() + saldo;
				listaCuentaAhorros.get(i).setSaldo(nuevoSaldo);
				break;
			}
		}

		registraTransaccion(numCuenta, "DEPOSITAR");
	}

	/**
	 * Método encargado de mirar si la cuenta tiene saldo,sin necesidad de generar
	 * una transaccion
	 * @param numCuenta
	 * @retun double con el valor del saldo que tiene la cuenta
	 */

	public double consultarSaldoCuentaSinTransaccion(String numCuenta) {

		double saldo = 0.0;
		for (int i = 0; i < listaCuentaAhorros.size(); i++) {

			if (listaCuentaAhorros.get(i).getNumCuenta().equals(numCuenta)) {
				saldo = listaCuentaAhorros.get(i).getSaldo();
			}
		}
		return saldo;
	}
	
	/**
	 * Método encargado de realizar el proceso que es sacar dinero de una cuenta
	 * dado el número y el monto a retirar siempre y cuando la cuenta exista
	 * 
	 * @param numCuenta
	 * @param saldo
	 * @throws Exception
	 */
	public void retirarDineroCuenta(String numCuenta, double saldo) {

		double nuevoSaldo = 0.0;
		for (int i = 0; i < listaCuentaAhorros.size(); i++) {
			if (listaCuentaAhorros.get(i).getNumCuenta().equals(numCuenta)) {
				nuevoSaldo = listaCuentaAhorros.get(i).getSaldo() - saldo;
				listaCuentaAhorros.get(i).setSaldo(nuevoSaldo);
				break;
			}
		}
		registraTransaccion(numCuenta, "RETIRAR");
	}

	/**
	 * Método encargado de informar si una cuenta existe dando su numero
	 * correspondiente, en caso tal de que no exista el método retornará falso
	 * 
	 * @param numCuenta
	 * @return true si existe, false si no existe la cuenta
	 */
	public boolean existeCuentaAhorros(String numCuenta) {
		boolean ban = false;
		for (int i = 0; i < listaCuentaAhorros.size(); i++) {
			if (listaCuentaAhorros.get(i).getNumCuenta().equals(numCuenta)) {
				ban = true;
			}
		}
		return ban;
	}




	// *******************************CRUD Y OTROS MÉTODOS DE BOLSILLO***********************************

	/**
	 * Método encargado de crear un bolsillo verificando que la cuenta exista y que
	 * el numero de bolsillo no exista
	 * 
	 * @param cuenta
	 * @throws Exception
	 */
	public void crearBolsillo(Bolsillo nuevoBolsillo, String numCuenta) {
		listaBolsillo.add(nuevoBolsillo);

		for (int i = 0; i < listaCuentaAhorros.size(); i++) {
			if (listaCuentaAhorros.get(i).getNumCuenta().equals(numCuenta)) {

				listaCuentaAhorros.get(i).setBolsillos(nuevoBolsillo);
			}
		}
		registraTransaccion(numCuenta, "ABRIR_BOLSILLO");
		// imprimirDatos();
	}
	
	/**
	 * Método encargado de consultar el saldo de un bosillo consultando por su
	 * número correspondiente, eso sí; el bolsillo debe de existir
	 * 
	 * @param numBolsillo
	 * @return numero de saldo que tiene el bolsillo a consultar
	 * @throws Exception
	 */
	public double consultarSaldoBolsillo(String numBolsillo) {
		double salida = 0.0;
		for (int i = 0; i < listaBolsillo.size(); i++) {

			if (listaBolsillo.get(i).getNumCuenta().equals(numBolsillo)) {
				salida = listaBolsillo.get(i).getSaldo();
			}
		}

		String numCuenta = numBolsillo.substring(0, numBolsillo.length() - 1);
		registraTransaccion(numCuenta, "CONSULTAR_SALDO_BOLSILLO");
		return salida;
	}

	/**
	 * Método encargado de eliminar un bolsillo dado su npumero de cuenta y bolsillo
	 * correspondiente
	 * 
	 * @param numCuenta
	 * @param numBolsillo
	 * @throws Exception
	 */
	public void eliminarBosillo(String numCuenta, String numBolsillo) {

		double saldo = 0.0;
		double nuevoSaldo = 0.0;

		for (int i = 0; i < listaBolsillo.size(); i++) {

			if (listaBolsillo.get(i).getNumCuenta().equals(numBolsillo)) {
				listaBolsillo.remove(i);
			}
		}

		for (int i = 0; i < listaCuentaAhorros.size(); i++) {
			if (listaCuentaAhorros.get(i).getNumCuenta().equals(numCuenta)) {
				saldo = listaCuentaAhorros.get(i).getBolsillos().getSaldo();
				nuevoSaldo = listaCuentaAhorros.get(i).getSaldo() + saldo;
				listaCuentaAhorros.get(i).setSaldo(nuevoSaldo);
				listaCuentaAhorros.get(i).setBolsillos(null);
			}
		}

		registraTransaccion(numCuenta, "CANCELAR_BOLSILLO");
		// imprimirDatos();
	}


	/**
	 * Método encargado de informar si un bolsillo existe dando su numero
	 * correspondiente, en caso tal de que no exista el método retornará falso
	 * 
	 * @param numBolsillo
	 * @return true si existe, false si no existe el bolsillo
	 */
	public boolean existeBolsillo(String numCuenta) {

		boolean centinela = false;
		for (int i = 0; i < listaBolsillo.size(); i++) {
			if (listaBolsillo.get(i).getNumCuenta().equals(numCuenta)) {
				centinela = true;
			}
		}
		return centinela;
	}
	

	/**
	 * Método encargado de consultar si un cliente existe dado su nombre
	 * 
	 * @param nombre
	 * @return true si existe, false si no existe
	 */
	public boolean existeCliente(String cliente) {
		boolean centinela = false;

		for (int i = 0; i < listaCuentaAhorros.size(); i++) {
			if (listaCuentaAhorros.get(i).getCliente().equals(cliente)) {
				centinela = true;
			}
		}
		return centinela;
	}
	
	/**
	 * Método encargado de trasladar saldo de la cuenta a un bolsillo siempre y
	 * cuando el saldo sea suficiente y la cuenta exista
	 * 
	 * @param numCuenta
	 * @param saldo
	 * @throws Exception
	 */
	public void trasladarDineroBolsillo(String numCuenta, double saldo) {

		double nuevoSaldo = 0.0;
		for (int i = 0; i < listaCuentaAhorros.size(); i++) {
			if (listaCuentaAhorros.get(i).getNumCuenta().equals(numCuenta)) {
				nuevoSaldo = listaCuentaAhorros.get(i).getSaldo() - saldo;
				listaCuentaAhorros.get(i).setSaldo(nuevoSaldo);
				break;
			}
		}

		for (int i = 0; i < listaBolsillo.size(); i++) {
			if (listaBolsillo.get(i).getNumCuenta().equals(numCuenta + "b")) {
				nuevoSaldo = listaBolsillo.get(i).getSaldo() + saldo;
				listaBolsillo.get(i).setSaldo(nuevoSaldo);
			}
		}

		registraTransaccion(numCuenta, "TRASLADAR");
	}

	
	/**
	 * Método encargado de ir registrando las acciones a medida que van
	 * transcurriendo teniendo en cuenta el nombre del cliente y el numero de cuenta
	 * e irlas guardando en un contenedor
	 * 
	 * @param numCuenta
	 * @param nombre
	 */
	public void registraTransaccion(String numCuenta, String nombre) {

		String key = getNumTransaccion() + "-" + numCuenta;
		Date fecha = new Date();
		Transaccion t = new Transaccion(nombre, fecha);
		getTransacciones().put(key, t);
		setNumTransaccion(getNumTransaccion() + 1);
	}

	/**
	 * Método encargado de ir imprimiendo a medida que va aconteciendo
	 */
	public void imprimirTransacciones() {

		getTransacciones().forEach(
				(k, v) -> System.out.println("Key: " + k + ": Value: " + v.getNombre() + " - " + v.getFecha()));
	}

	/**
	 * Método encargado de imprimir qué cuentas se encuentran y qué bolsillos están creados
	 * para evidenciar de que se van creando correctamente 
	 */
	public void imprimirDatos() {

		System.out.println("---Cuentas de ahorro---");
		for (CuentaAhorro c : listaCuentaAhorros) {
			System.out.println(c.getNumCuenta() + " - " + c.getCliente() + " - " + c.getSaldo());
		}

		System.out.println("\n---Cuentas de bolsillos---");
		for (Bolsillo b : listaBolsillo) {
			System.out.println(b.getNumCuenta() + " - " + b.getSaldo());
		}
		System.out.println("");
	}

	/**
	 * Método encargado de recibir un archivo para previamente ser leído
	 * 
	 * @param nombre
	 * @return el archivo con sus respectivas acciones
	 * @throws Exception
	 */
	public String leerArchivo(String nombre) {

		return miArchivo.leerArchivo(nombre);
	}
	
	//******************************** METODOS GETS Y SETS DE LOS CONTENEDORES****************+
	public ArrayList<CuentaAhorro> getListaCuentaAhorros() {
		return listaCuentaAhorros;
	}

	public void setListaCuentaAhorros(ArrayList<CuentaAhorro> listaCuentaAhorros) {
		this.listaCuentaAhorros = listaCuentaAhorros;
	}

	public ArrayList<Bolsillo> getListaBolsillo() {
		return listaBolsillo;
	}

	public void setListaBolsillo(ArrayList<Bolsillo> listaBolsillo) {
		this.listaBolsillo = listaBolsillo;
	}

	public int getNumeroCuenta() {
		return numeroCuenta;
	}

	public void setNumeroCuenta(int numeroCuenta) {
		this.numeroCuenta = numeroCuenta;
	}

	public int getNumTransaccion() {
		return numTransaccion;
	}

	public void setNumTransaccion(int numTransaccion) {
		this.numTransaccion = numTransaccion;
	}

	public HashMap<String, Transaccion> getTransacciones() {
		return transacciones;
	}

	public void setTransacciones(HashMap<String, Transaccion> transacciones) {
		this.transacciones = transacciones;
	}

}
