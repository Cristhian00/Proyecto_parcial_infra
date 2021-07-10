package Controlador;

import Modelo.Banco;
import Modelo.Bolsillo;
import Modelo.Cliente;
import Modelo.CuentaAhorro;

public class Controlador {
	
	private Banco miBanco;
	
	public  void crearCliente (Cliente nuevoCliente )throws Exception{	
		
		if(miBanco.buscarCliente(nuevoCliente.getNombre()))
		{
			throw new Exception("Lo sentimos el cliente ya existe ");
		}else {
			
			miBanco.crearCliente(nuevoCliente);
		}
		
		
	}

	public void eliminarCliente(String nombre) throws Exception{
		
		if(miBanco.buscarCliente(nombre))
		{
			miBanco.eliminarCliente(nombre);
			
		}else {
			
		
			throw new Exception("Lo sentimos el cliente no existe ");
		}
		
	}

	public boolean buscarCliente (String nombre) {
		boolean centinela = false;
		if(miBanco.buscarCliente(nombre)) {
			
			centinela = true;
		}
		
		return centinela;
	}

	public void crearBolsillo (Bolsillo nuevoBolsillo,String numCuenta) throws Exception {
		if(miBanco.buscarBolsillo(nuevoBolsillo.getNumCuenta()))
		{
			throw new Exception("Lo sentimos el bolsillo ya existe ");
		}else {
			
			miBanco.crearBolsillo(nuevoBolsillo,numCuenta);
		}
	}
	

	public void eliminarBosillo(String numCuenta,String numBolsillo) throws Exception {
		
		if(miBanco.buscarBolsillo(numBolsillo))
		{
			miBanco.eliminarBosillo(numCuenta, numBolsillo);
			
		}else {
			
		
			throw new Exception("Lo sentimos el bolsillo no existe ");
		}
	}
	
	
	public void depositarDinero(String numCuenta, double saldo) throws Exception{

		if(miBanco.buscarCuentaAhorros(numCuenta)) {
			miBanco.depositarDinero(numCuenta, saldo);
		}else {
			throw new Exception("Lo sentimos la cuenta no existe ");
		}
	}

	public void trasladarDineroBolsillo(String numCuenta, double saldo) throws Exception{
		
		if(miBanco.buscarCuentaAhorros(numCuenta) &&  miBanco.buscarBolsillo(numCuenta+"b")) {
			miBanco.trasladarDineroBolsillo(numCuenta, saldo);
		}else {
			throw new Exception("Lo sentimos el bolsillo no existe ");
		}
		
	}

	public double consultarSaldoBolsillo(String numCuenta) throws Exception {
		double salida=0.0;
		if(miBanco.buscarBolsillo(numCuenta)) {
			salida = miBanco.consultarSaldoBolsillo(numCuenta);
		}else {
			
			throw new Exception("Lo sentimos el bolsillo no existe ");
		}
			return salida;
	}




	public boolean buscarBolsillo(String numCuenta) {
		boolean centinela= false;
		
		if(miBanco.buscarBolsillo(numCuenta)) {
			
			centinela=true;
		}
		
		return centinela;
	}




	public void crearCuenta(CuentaAhorro cuenta,Cliente cliente) throws Exception{
		if(miBanco.buscarCuentaAhorros(cuenta.getNumCuenta())&& miBanco.buscarCliente(cliente.getNombre())){
			throw new Exception("Lo sentimos la cuenta ya existe ");
		}else {
			
			miBanco.crearCuenta(cuenta, cliente.getNombre());
		}
	}

	public void eliminarCuenta(CuentaAhorro cuenta,Cliente cliente) throws Exception{
		if(miBanco.buscarCuentaAhorros(cuenta.getNumCuenta())) {
			if(miBanco.consultarSaldoCuenta(cuenta.getNumCuenta())== 0.0) {
				miBanco.eliminarCuenta(cuenta, cliente.getNombre());
			}else {
				
				throw new Exception("No se puede eliminar, la cuenta tiene saldo de: "+ miBanco.consultarSaldoCuenta(cuenta.getNumCuenta()));
			}
		}else {
			
			throw new Exception("Lo sentimos la cuenta no existe ");
		}
	}

	public double consultarSaldoCuenta(String numCuenta) throws Exception {
		double salida=0.0;
		if(miBanco.buscarCuentaAhorros(numCuenta)) {
			salida = miBanco.consultarSaldoCuenta(numCuenta);
		}else {
			throw new Exception("Lo sentimos la cuenta no existe ");
		}
		
			return salida;
	}

	public boolean buscarCuentaAhorros(String numCuenta){
		boolean ban = false;
		if(miBanco.buscarCuentaAhorros(numCuenta)) {
			ban=true;
		}
		return ban;
	}
	
	public void retirarDineroCuenta(String numCuenta, double saldo) throws Exception{

		if(miBanco.buscarCuentaAhorros(numCuenta) ) {
			if(miBanco.consultarSaldoCuenta(numCuenta)>= saldo) {
				
				miBanco.retirarDineroCuenta(numCuenta, saldo);
			}else {
				throw new Exception("Lo sentimos saldo insuficiente ");
			}
			
		}else {
			throw new Exception("Lo sentimos la cuenta no existe ");
		}
	}



}
