package Controlador;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

import Modelo.Banco;
import Modelo.Bolsillo;
import Modelo.CuentaAhorro;
import Modelo.Transaccion;

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

	public void crearCuenta(CuentaAhorro cuenta) throws Exception {

		if (miBanco.existeCuentaAhorros(cuenta.getNumCuenta())) {
			throw new Exception("Lo sentimos la cuenta ya existe");
		} else if (miBanco.existeCliente(cuenta.getCliente())) {
			throw new Exception("Lo sentimos, el nombre del cliente ya esta registrado");
		} else {
			miBanco.crearCuenta(cuenta);
		}
	}

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

	public void depositarDinero(String numCuenta, double saldo) throws Exception {

		if (miBanco.existeCuentaAhorros(numCuenta)) {
			miBanco.depositarDinero(numCuenta, saldo);
		} else {
			throw new Exception("Lo sentimos, la cuenta con número " + numCuenta + " no existe ");
		}
	}

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

	public void trasladarDineroBolsillo(String numCuenta, double saldo) throws Exception {

		if (miBanco.existeCuentaAhorros(numCuenta) && miBanco.existeBolsillo(numCuenta + "b")) {
			if(consultarSaldoCuenta(numCuenta) >= saldo) {
				miBanco.trasladarDineroBolsillo(numCuenta, saldo);
			} else {
				throw new Exception("Lo sentimos, el saldo no es suficiente");
			}
			
		} else {
			throw new Exception("Lo sentimos, el bolsillo con número " + numCuenta + "b no existe");
		}
	}

	public double consultarSaldoCuenta(String numCuenta) throws Exception {

		double salida = 0.0;
		if (miBanco.existeCuentaAhorros(numCuenta)) {
			salida = miBanco.consultarSaldoCuentaSinTransaccion(numCuenta);
		} else {
			throw new Exception("Lo sentimos, la cuenta con número " + numCuenta + " no existe ");
		}

		return salida;
	}

	public boolean existeCuentaAhorros(String numCuenta) {

		boolean ban = false;
		if (miBanco.existeCuentaAhorros(numCuenta)) {
			ban = true;
		}
		return ban;
	}

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

	public void eliminarBolsillo(String numCuenta, String numBolsillo) throws Exception {

		if (miBanco.existeBolsillo(numBolsillo)) {
			miBanco.eliminarBosillo(numCuenta, numBolsillo);
		} else {
			throw new Exception("Lo sentimos, el bolsillo no existe");
		}
	}

	public double consultarSaldoBolsillo(String numBolsillo) throws Exception {

		double salida = 0.0;
		if (miBanco.existeBolsillo(numBolsillo)) {
			salida = miBanco.consultarSaldoBolsillo(numBolsillo);
		} else {

			throw new Exception("Lo sentimos, el bolsillo con número " + numBolsillo + " no existe");
		}
		return salida;
	}

	public boolean existeBolsillo(String numBolsillo) {

		boolean centinela = false;
		if (miBanco.existeBolsillo(numBolsillo)) {
			centinela = true;
		}
		return centinela;
	}

	public boolean existeCliente(String nombre) {

		boolean centinela = false;
		if (miBanco.existeCliente(nombre)) {
			centinela = true;
		}
		return centinela;
	}

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

	public String leerArchivo(String nombre) throws Exception {

		return miBanco.leerArchivo(nombre);

	}
	
	public void imprimirTransacciones() {
		miBanco.imprimirTransacciones();
	}

}
