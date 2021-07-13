package EchoTCPServer_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import Controlador.Controlador;
import Modelo.Bolsillo;
import Modelo.CuentaAhorro;

public class EchoTCPServerProtocol{

	private static PrintWriter toNetwork;
	private static BufferedReader fromNetwork;
	private static Controlador controlador = new Controlador();

	public static void protocol(Socket socket) throws IOException {
		
		createStreams(socket);
		String message = fromNetwork.readLine();
		System.out.println("[SERVER] from client: " + message);
		String answer = "";

		String[] transaccion = message.split(",");
		String operacion = transaccion[0];

		String numCuenta = "";
		String numBolsillo = "";
		double valor = 0.0;
		double saldo = 0.0;

		switch (operacion) {
		case "ABRIR_CUENTA":
			String usuario = transaccion[1];
			CuentaAhorro cuenta = new CuentaAhorro(usuario);
			cuenta.setNumCuenta(controlador.numeroCuentaNueva() + "");
			try {
				controlador.crearCuenta(cuenta);
				answer = "La cuenta se creo correctamente";
			} catch (Exception e) {
				e.printStackTrace();
				answer = e.getMessage();
			}
			break;
		case "ABRIR_BOLSILLO":
			numCuenta = transaccion[1];
			Bolsillo bolsillo = new Bolsillo(numCuenta);
			try {
				controlador.crearBolsillo(bolsillo, numCuenta);
				answer = "El bolsillo se creo correctamente";
			} catch (Exception e) {
				e.printStackTrace();
				answer = e.getMessage();
			}
			break;
		case "CANCELAR_BOLSILLO":
			numBolsillo = transaccion[1];
			numCuenta = numBolsillo.substring(0, numBolsillo.length() - 1);
			try {
				controlador.eliminarBolsillo(numCuenta, numBolsillo);
				answer = "El bolsillo se ha eliminado correctamente";
			} catch (Exception e) {
				e.printStackTrace();
				answer = e.getMessage();
			}
			break;
		case "CANCELAR_CUENTA":
			numCuenta = transaccion[1];
			try {
				controlador.eliminarCuenta(numCuenta);
				answer = "La cuenta se ha eliminado correctamente";
			} catch (Exception e) {
				e.printStackTrace();
				answer = e.getMessage();
			}
			break;
		case "DEPOSITAR":
			numCuenta = transaccion[1];
			valor = Double.parseDouble(transaccion[2]);
			try {
				controlador.depositarDinero(numCuenta, valor);
				answer = "El dinero se a depositado correctamente";
			} catch (Exception e) {
				e.printStackTrace();
				answer = e.getMessage();
			}
			break;
		case "RETIRAR":
			numCuenta = transaccion[1];
			valor = Double.parseDouble(transaccion[2]);
			try {
				controlador.retirarDineroCuenta(numCuenta, valor);
				answer = "El dinero se a retirado correctamente";
			} catch (Exception e) {
				e.printStackTrace();
				answer = e.getMessage();
			}
			break;
		case "TRASLADAR":
			numCuenta = transaccion[1];
			valor = Double.parseDouble(transaccion[2]);
			try {
				controlador.trasladarDineroBolsillo(numCuenta, valor);
				answer = "El dinero se a trasladado al bolsillo correctamente";
			} catch (Exception e) {
				e.printStackTrace();
				answer = e.getMessage();
			}
			break;
		case "CONSULTAR":
			numCuenta = transaccion[1];
			try {
				saldo = controlador.consultarSaldo(numCuenta);
				answer = "El saldo de la cuenta " + numCuenta + " es de " + saldo;
			} catch (Exception e) {
				e.printStackTrace();
				answer = e.getMessage();
			}
			break;
		case "CARGA":
		default:
			break;
		}

		toNetwork.println(answer);
	}

	private static void createStreams(Socket socket) throws IOException {
		toNetwork = new PrintWriter(socket.getOutputStream(), true);
		fromNetwork = new BufferedReader(new InputStreamReader(socket.getInputStream()));
	}

}
