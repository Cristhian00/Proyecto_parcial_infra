package Controlador;

import Modelo.Banco;
import Modelo.Bolsillo;
import Modelo.CuentaAhorro;

public class Controlador {

	private Banco miBanco;

	public Controlador() {
		miBanco = new Banco();
	}

	public int numeroCuentaNueva() {
		return miBanco.getNumeroCuenta();
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
			throw new Exception("Lo sentimos la cuenta no existe ");
		}
	}

	public void depositarDinero(String numCuenta, double saldo) throws Exception {

		if (miBanco.existeCuentaAhorros(numCuenta)) {
			miBanco.depositarDinero(numCuenta, saldo);
		} else {
			throw new Exception("Lo sentimos, la cuenta no existe");
		}
	}

	public void retirarDineroCuenta(String numCuenta, double saldo) throws Exception {

		if (miBanco.existeCuentaAhorros(numCuenta)) {
			if (miBanco.consultarSaldoCuenta(numCuenta) >= saldo) {

				miBanco.retirarDineroCuenta(numCuenta, saldo);
			} else {
				throw new Exception("Lo sentimos saldo insuficiente ");
			}

		} else {
			throw new Exception("Lo sentimos la cuenta no existe ");
		}
	}

	public void trasladarDineroBolsillo(String numCuenta, double saldo) throws Exception {

		if (miBanco.existeCuentaAhorros(numCuenta) && miBanco.existeBolsillo(numCuenta + "b")) {
			miBanco.trasladarDineroBolsillo(numCuenta, saldo);
		} else {
			throw new Exception("Lo sentimos, el bolsillo no existe");
		}
	}

	public double consultarSaldoCuenta(String numCuenta) throws Exception {
		double salida = 0.0;
		if (miBanco.existeCuentaAhorros(numCuenta)) {
			salida = miBanco.consultarSaldoCuenta(numCuenta);
		} else {
			throw new Exception("Lo sentimos la cuenta no existe ");
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
		if (miBanco.existeBolsillo(nuevoBolsillo.getNumCuenta())) {
			throw new Exception("Lo sentimos, el bolsillo ya existe");
		} else {

			miBanco.crearBolsillo(nuevoBolsillo, numCuenta);
		}
	}

	public void eliminarBolsillo(String numCuenta, String numBolsillo) throws Exception {

		if (miBanco.existeBolsillo(numBolsillo)) {
			miBanco.eliminarBosillo(numCuenta, numBolsillo);
		} else {
			throw new Exception("Lo sentimos, el bolsillo no existe");
		}
	}

	public double consultarSaldoBolsillo(String numCuenta) throws Exception {
		double salida = 0.0;
		if (miBanco.existeBolsillo(numCuenta)) {
			salida = miBanco.consultarSaldoBolsillo(numCuenta);
		} else {

			throw new Exception("Lo sentimos, el bolsillo no existe");
		}
		return salida;
	}

	public boolean existeBolsillo(String numCuenta) {
		boolean centinela = false;
		if (miBanco.existeBolsillo(numCuenta)) {
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
				throw new Exception("El bolsillo con número de cuenta " + numCuenta + " no existe");
			}
		} else if (miBanco.existeCuentaAhorros(numCuenta)) {
			saldo = miBanco.consultarSaldoCuenta(numCuenta);
		} else {
			throw new Exception("La cuenta de ahorros con número " + numCuenta + " no existe");
		}

		return saldo;
	}

}
