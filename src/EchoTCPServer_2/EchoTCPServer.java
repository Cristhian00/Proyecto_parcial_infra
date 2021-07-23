package EchoTCPServer_2;

import java.net.ServerSocket;
import java.net.Socket;

/**
 * Clase encargada de crear la escucha y la realización de los procesos que va a
 * recibir mediante un socket
 * 
 * @author Tatiana Arboleda, Cristhian Ortiz y Diego Valencia
 *
 */
public class EchoTCPServer {

	public static final int PORT = 1025;
	private ServerSocket listener;
	private Socket serverSideSocket;

	/**
	 * Método que informa que el servidor está creado y escuchando por un puerto
	 * correspondiente
	 */
	public EchoTCPServer() {

		System.out.println("Echo TCP SERVER is running on port: " + PORT);

	}

	/**
	 * Método encargado de crear la escucha en el puerto dado y aceptar los comandos
	 * que por esté recibe
	 * 
	 * @throws Exception
	 */
	private void init() throws Exception {
		listener = new ServerSocket(PORT);

		while (true) {

			serverSideSocket = listener.accept();
			EchoTCPServerProtocol.protocol(serverSideSocket);

		}

	}

	public static void main(String args[]) throws Exception {

		EchoTCPServer es = new EchoTCPServer();
		es.init();
	}

}
