package Controlador;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

import Modelo.Banco;
import Modelo.Bolsillo;
import Modelo.CuentaAhorro;
import Modelo.Transaccion;

/**
 * Clase encargada de conectar la lógica con la interfaz
 * 
 * @author Tatiana Arboleda, Cristhian Ortiz y Diego valencia
 *
 */
public class Controlador {

	private Banco miBanco;

	public Controlador() {
		miBanco = new Banco();
	}

	public int numeroCuentaNueva() {
		return miBanco.getNumeroCuenta();
	}

	public HashMap<String, Transaccion> obtenerTransacciones() {
		return miBanco.getTransacciones();
	}

	// ******************************CRUD Y OTROS MÉTODOS DE CUENTA*************************************

	/**
	 * Método encargado de crear una cuenta de ahorro verificando que la cuenta no
	 * sea repetida y tambien que la cuenta exista
	 * 
	 * @param cuenta
	 * @throws Exception
	 */
	public void crearCuenta(CuentaAhorro cuenta) throws Exception {

		if (miBanco.existeCuentaAhorros(cuenta.getNumCuenta())) {
			throw new Exception("Lo sentimos la cuenta ya existe");
		} else if (miBanco.existeCliente(cuenta.getCliente())) {
			throw new Exception("Lo sentimos, el nombre del cliente ya esta registrado");
		} else {
			miBanco.crearCuenta(cuenta);
		}
	}

	/**
	 * Método encargado de consultar el saldo de una cuenta consultando por su
	 * número correspondiente, eso sí, la cuenta debe de existir
	 * 
	 * @param numCuenta
	 * @return numero de saldo que tiene la cuenta a consultar
	 * @throws Exception
	 */
	public double consultarSaldoCuenta(String numCuenta) throws Exception {

		double salida = 0.0;
		if (miBanco.existeCuentaAhorros(numCuenta)) {
			salida = miBanco.consultarSaldoCuentaSinTransaccion(numCuenta);
		} else {
			throw new Exception("Lo sentimos, la cuenta con número " + numCuenta + " no existe ");
		}

		return salida;
	}

	/**
	 * Método encargado de eliminar una cuenta dado su numero correspondiente, la
	 * cuenta debe de existir y no tener dinero en ella
	 * 
	 * @param numCuenta
	 * @throws Exception
	 */
	public void eliminarCuenta(String numCuenta) throws Exception {

		if (miBanco.existeCuentaAhorros(numCuenta)) {
			if (miBanco.consultarSaldoCuenta(numCuenta) == 0.0) {
				miBanco.eliminarCuenta(numCuenta);
			} else {
				throw new Exception("No se puede eliminar, la cuenta tiene un saldo de: "
						+ miBanco.consultarSaldoCuenta(numCuenta));
			}
		} else {
			throw new Exception("Lo sentimos, la cuenta con número " + numCuenta + " no existe ");
		}
	}

	/**
	 * Método encargado de depositar dinero en una cuenta existente dado su numero
	 * correspondiente y el monto correspondiente
	 * 
	 * @param numCuenta
	 * @param saldo
	 * @throws Exception
	 */
	public void depositarDinero(String numCuenta, double saldo) throws Exception {

		if (miBanco.existeCuentaAhorros(numCuenta)) {
			miBanco.depositarDinero(numCuenta, saldo);
		} else {
			throw new Exception("Lo sentimos, la cuenta con número " + numCuenta + " no existe ");
		}
	}

	/**
	 * Método encargado de realizar el proceso que es sacar dinero de una cuenta
	 * dado el número y el monto a retirar siempre y cuando la cuenta exista
	 * 
	 * @param numCuenta
	 * @param saldo
	 * @throws Exception
	 */
	public void retirarDineroCuenta(String numCuenta, double saldo) throws Exception {

		if (miBanco.existeCuentaAhorros(numCuenta)) {
			if (miBanco.consultarSaldoCuenta(numCuenta) >= saldo) {
				miBanco.retirarDineroCuenta(numCuenta, saldo);
			} else {
				throw new Exception("Lo sentimos, su saldo es de " + miBanco.consultarSaldoCuenta(numCuenta)
						+ " y es insuficiente");
			}
		} else {
			throw new Exception("Lo sentimos, la cuenta con número " + numCuenta + " no existe ");
		}
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
		if (miBanco.existeCuentaAhorros(numCuenta)) {
			ban = true;
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
	public void crearBolsillo(Bolsillo nuevoBolsillo, String numCuenta) throws Exception {

		if (miBanco.existeCuentaAhorros(numCuenta)) {
			if (miBanco.existeBolsillo(nuevoBolsillo.getNumCuenta())) {
				throw new Exception(
						"Lo sentimos, el bolsillo con número " + nuevoBolsillo.getNumCuenta() + " ya existe");
			} else {
				miBanco.crearBolsillo(nuevoBolsillo, numCuenta);
			}
		} else {
			throw new Exception("Lo sentimos, la cuenta con número " + numCuenta + " no existe ");
		}

	}

	/**
	 * Método encargado de consultar el saldo de un bosillo consultando por su
	 * número correspondiente, eso sí; el bolsillo debe de existir
	 * 
	 * @param numBolsillo
	 * @return numero de saldo que tiene el bolsillo a consultar
	 * @throws Exception
	 */
	public double consultarSaldoBolsillo(String numBolsillo) throws Exception {

		double salida = 0.0;
		if (miBanco.existeBolsillo(numBolsillo)) {
			salida = miBanco.consultarSaldoBolsillo(numBolsillo);
		} else {

			throw new Exception("Lo sentimos, el bolsillo con número " + numBolsillo + " no existe");
		}
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
	public void eliminarBolsillo(String numCuenta, String numBolsillo) throws Exception {

		if (miBanco.existeBolsillo(numBolsillo)) {
			miBanco.eliminarBosillo(numCuenta, numBolsillo);
		} else {
			throw new Exception("Lo sentimos, el bolsillo no existe");
		}
	}

	/**
	 * Método encargado de informar si un bolsillo existe dando su numero
	 * correspondiente, en caso tal de que no exista el método retornará falso
	 * 
	 * @param numBolsillo
	 * @return true si existe, false si no existe el bolsillo
	 */
	public boolean existeBolsillo(String numBolsillo) {

		boolean centinela = false;
		if (miBanco.existeBolsillo(numBolsillo)) {
			centinela = true;
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
	public void trasladarDineroBolsillo(String numCuenta, double saldo) throws Exception {

		if (miBanco.existeCuentaAhorros(numCuenta) && miBanco.existeBolsillo(numCuenta + "b")) {
			if (consultarSaldoCuenta(numCuenta) >= saldo) {
				miBanco.trasladarDineroBolsillo(numCuenta, saldo);
			} else {
				throw new Exception("Lo sentimos, el saldo no es suficiente");
			}

		} else {
			throw new Exception("Lo sentimos, el bolsillo con número " + numCuenta + "b no existe");
		}
	}

	/**
	 * Método encargado de consultar el saldo de un bolsillo consultando por su
	 * número correspondiente, eso sí, el bolsillo debe de existir
	 * 
	 * @param numCuenta
	 * @return numero de saldo que tiene el bolsillo a consultar
	 * @throws Exception
	 */
	public double consultarSaldo(String numCuenta) throws Exception {

		double saldo = 0.0;
		if (numCuenta.substring(numCuenta.length() - 1).equals("b")) {
			if (miBanco.existeBolsillo(numCuenta)) {
				saldo = miBanco.consultarSaldoBolsillo(numCuenta);
			} else {
				throw new Exception("Lo sentimos, el bolsillo con número de cuenta " + numCuenta + " no existe");
			}
		} else if (miBanco.existeCuentaAhorros(numCuenta)) {
			saldo = miBanco.consultarSaldoCuenta(numCuenta);
		} else {
			throw new Exception("Lo sentimos, la cuenta de ahorros con número " + numCuenta + " no existe");
		}

		return saldo;
	}

	/**
	 * Método encargado de recibir un archivo para previamente ser leído
	 * 
	 * @param nombre
	 * @return
	 * @throws Exception
	 */
	public String leerArchivo(String nombre) throws Exception {

		return miBanco.leerArchivo(nombre);

	}

	/**
	 * Método encargado de consultar si un cliente existe dado su nombre
	 * 
	 * @param nombre
	 * @return true si existe, false si no existe
	 */
	public boolean existeCliente(String nombre) {

		boolean centinela = false;
		if (miBanco.existeCliente(nombre)) {
			centinela = true;
		}
		return centinela;
	}

	public void imprimirTransacciones() {
		miBanco.imprimirTransacciones();
	}

}
