package EchoTCPServer_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import Controlador.Controlador;
import Modelo.CuentaAhorro;

public class EchoTCPServerProtocol {

	private static PrintWriter toNetwork;
	private static BufferedReader fromNetwork;
	static Controlador controlador = new Controlador();

	public static void protocol(Socket socket) throws IOException {
		createStreams(socket);

		String message = fromNetwork.readLine();
		System.out.println("mensaje cliente -> " + message);
		String answer = "";

		String[] transaccion = message.split(",");
		String operacion = transaccion[0];

		switch (operacion) {
		case "ABRIR_CUENTA":
			String usuario = transaccion[1];
			CuentaAhorro cuenta = new CuentaAhorro(usuario);
			cuenta.setNumCuenta(controlador.numeroCuentaNueva() + "");
			System.out.println(cuenta.getNumCuenta());
			try {
				controlador.crearCuenta(cuenta);
				answer = "La cuenta se creo correctamente";
			} catch (Exception e) {
				e.printStackTrace();
				answer = e.toString();
			}
			break;
		case "ABRIR_BOLSILLO":
			break;
		case "CANCELAR_BOLSILLO":
			break;
		case "CANCELAR_CUENTA":
			break;
		case "DEPOSITAR":
			break;
		case "RETIRAR":
			break;
		case "TRASLADAR":
			break;
		case "CONSULTAR":
			break;
		case "CARGA":
		default:
			break;
		}

		System.out.println("[Server] from client:" + message);

		toNetwork.println(answer);
	}

	private static void createStreams(Socket socket) throws IOException {
		toNetwork = new PrintWriter(socket.getOutputStream(), true);
		fromNetwork = new BufferedReader(new InputStreamReader(socket.getInputStream()));
	}

}
