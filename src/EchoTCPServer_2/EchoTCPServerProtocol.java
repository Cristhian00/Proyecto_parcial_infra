package EchoTCPServer_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;

import Controlador.Controlador;
import Modelo.Bolsillo;
import Modelo.CuentaAhorro;

public class EchoTCPServerProtocol {

	private static PrintWriter toNetwork;
	private static BufferedReader fromNetwork;
	private static Controlador controlador = new Controlador();

	public static void protocol(Socket socket) throws IOException {

		createStreams(socket);

		String numCuenta = "";
		String numBolsillo = "";
		double valor = 0.0;
		double saldo = 0.0;
		int confir = 0;
		
		String message = "";
		String answer = "";
		String[] transaccion = new String[10];
		String operacion = "";

		do {
			
			message = fromNetwork.readLine();
			System.out.println("[SERVER] from client: " + message);

			transaccion = message.split(",");
			operacion = transaccion[1];
			confir = Integer.parseInt(transaccion[0]);

			switch (operacion) {

			case "ABRIR_CUENTA":
				String usuario = transaccion[2];
				CuentaAhorro cuenta = new CuentaAhorro(usuario);
				cuenta.setNumCuenta(controlador.numeroCuentaNueva() + "");
				try {
					controlador.crearCuenta(cuenta);
					answer = "La cuenta se creo correctamente";
				} catch (Exception e) {
					answer = e.getMessage();
				}
				break;
			case "ABRIR_BOLSILLO":
				numCuenta = transaccion[2];
				Bolsillo bolsillo = new Bolsillo(numCuenta);
				try {
					controlador.crearBolsillo(bolsillo, numCuenta);
					answer = "El bolsillo se creo correctamente";
				} catch (Exception e) {
					answer = e.getMessage();
				}
				break;
			case "CANCELAR_BOLSILLO":
				numBolsillo = transaccion[2];
				numCuenta = numBolsillo.substring(0, numBolsillo.length() - 1);
				try {
					controlador.eliminarBolsillo(numCuenta, numBolsillo);
					answer = "El bolsillo se ha eliminado correctamente";
				} catch (Exception e) {
					answer = e.getMessage();
				}
				break;
			case "CANCELAR_CUENTA":
				numCuenta = transaccion[2];
				try {
					controlador.eliminarCuenta(numCuenta);
					answer = "La cuenta se ha eliminado correctamente";
				} catch (Exception e) {
					answer = e.getMessage();
				}
				break;
			case "DEPOSITAR":
				numCuenta = transaccion[2];
				valor = Double.parseDouble(transaccion[3]);
				try {
					controlador.depositarDinero(numCuenta, valor);
					answer = "El dinero se a depositado correctamente";
				} catch (Exception e) {
					answer = e.getMessage();
				}
				break;
			case "RETIRAR":
				numCuenta = transaccion[2];
				valor = Double.parseDouble(transaccion[3]);
				try {
					controlador.retirarDineroCuenta(numCuenta, valor);
					answer = "El dinero se a retirado correctamente";
				} catch (Exception e) {
					answer = e.getMessage();
				}
				break;
			case "TRASLADAR":
				numCuenta = transaccion[2];
				valor = Double.parseDouble(transaccion[3]);
				try {
					controlador.trasladarDineroBolsillo(numCuenta, valor);
					answer = "El dinero se a trasladado al bolsillo correctamente";
				} catch (Exception e) {
					answer = e.getMessage();
				}
				break;
			case "CONSULTAR":
				numCuenta = transaccion[2];
				try {
					saldo = controlador.consultarSaldo(numCuenta);
					answer = "El saldo de la cuenta " + numCuenta + " es de " + saldo;
				} catch (Exception e) {
					answer = e.getMessage();
				}
				break;
			case "CARGA":
				String nombre = transaccion[2];
				try {
					answer = controlador.leerArchivo(nombre);
				} catch (Exception e) {
					answer = e.getMessage();
				}
				break;
			default:
				answer = "No se pudo recibir la operación a realizar";
				break;
			}
			System.out.println(answer);
			toNetwork.println(answer);
			
			System.out.println("\n\n--------TRANSACCIONES--------");
			controlador.imprimirTransacciones();
			System.out.println("\n\n");
			
		} while (confir == 0);
	}

	/*
	 * public static void cargarDatos(ArrayList<String[]> operaciones) {
	 * 
	 * for(int i = 0; i < operaciones.size(); i++) {
	 * 
	 * } }
	 */

	private static void createStreams(Socket socket) throws IOException {
		toNetwork = new PrintWriter(socket.getOutputStream(), true);
		fromNetwork = new BufferedReader(new InputStreamReader(socket.getInputStream()));
	}

}
