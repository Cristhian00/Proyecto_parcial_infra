package Modelo;

import java.util.ArrayList;

public class Banco {
	private ArrayList<CuentaAhorro> listaCuentaAhorros;
	private ArrayList<Bolsillo> listaBolsillo;
	private int numeroCuenta;

	public Banco() {
		super();
		this.listaCuentaAhorros = new ArrayList<CuentaAhorro>();
		this.listaBolsillo = new ArrayList<Bolsillo>();
		this.numeroCuenta = 0;
	}

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

	public boolean buscarCliente(String cliente) {
		boolean centinela = false;

		for (int i = 0; i < listaCuentaAhorros.size(); i++) {
			if (listaCuentaAhorros.get(i).getCliente().equals(cliente)) {
				centinela = true;
			}
		}
		return centinela;
	}

	public void crearBolsillo(Bolsillo nuevoBolsillo, String numcuenta) {
		listaBolsillo.add(nuevoBolsillo);

		for (int i = 0; i < listaCuentaAhorros.size(); i++) {
			if (listaCuentaAhorros.get(i).getNumCuenta().equals(numcuenta)) {

				listaCuentaAhorros.get(i).setBolsillos(nuevoBolsillo);
			}
		}
	}

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

	}

	public void depositarDinero(String numCuenta, double saldo) {

		double nuevoSaldo = 0.0;
		for (int i = 0; i < listaCuentaAhorros.size(); i++) {
			if (listaCuentaAhorros.get(i).getNumCuenta().equals(numCuenta)) {
				nuevoSaldo = listaCuentaAhorros.get(i).getSaldo() + saldo;
				listaCuentaAhorros.get(i).setSaldo(nuevoSaldo);
				break;
			}
		}
	}

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
	}

	public double consultarSaldoBolsillo(String numCuenta) {
		double salida = 0.0;
		for (int i = 0; i < listaBolsillo.size(); i++) {

			if (listaBolsillo.get(i).getNumCuenta().equals(numCuenta)) {
				salida = listaBolsillo.get(i).getSaldo();
			}
		}

		return salida;
	}

	public boolean buscarBolsillo(String numCuenta) {
		
		boolean centinela = false;
		for (int i = 0; i < listaBolsillo.size(); i++) {
			if (listaBolsillo.get(i).getNumCuenta().equals(numCuenta)) {
				centinela = true;
			}
		}
		return centinela;
	}

	public void crearCuenta(CuentaAhorro cuenta) {
		listaCuentaAhorros.add(cuenta);
	}

	public void eliminarCuenta(CuentaAhorro cuenta) {
		
		for (int i = 0; i < listaCuentaAhorros.size(); i++) {
			if (listaCuentaAhorros.get(i).getNumCuenta().equals(cuenta.getNumCuenta())) {
				listaCuentaAhorros.remove(i);
				break;
			}
		}
	}

	public double consultarSaldoCuenta(String numCuenta) {
		
		double saldo = 0.0;
		for (int i = 0; i < listaCuentaAhorros.size(); i++) {

			if (listaCuentaAhorros.get(i).getNumCuenta().equals(numCuenta)) {
				saldo = listaCuentaAhorros.get(i).getSaldo();
			}
		}
		return saldo;
	}

	public boolean buscarCuentaAhorros(String numCuenta) {
		boolean ban = false;
		for (int i = 0; i < listaCuentaAhorros.size(); i++) {
			if (listaCuentaAhorros.get(i).getNumCuenta().equals(numCuenta)) {
				ban = true;
			}
		}
		return ban;
	}

	public void retirarDineroCuenta(String numCuenta, double saldo) {

		double nuevoSaldo = 0.0;
		for (int i = 0; i < listaCuentaAhorros.size(); i++) {
			if (listaCuentaAhorros.get(i).getNumCuenta().equals(numCuenta)) {
				nuevoSaldo = listaCuentaAhorros.get(i).getSaldo() - saldo;
				listaCuentaAhorros.get(i).setSaldo(nuevoSaldo);
				break;
			}
		}
	}

}