package EchoTCPServer_2;

import java.net.ServerSocket;
import java.net.Socket;

/**
 * Clase encargada de crear la escucha y la realizaci�n de los procesos que va a
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
	 * M�todo que informa que el servidor est� creado y escuchando por un puerto
	 * correspondiente
	 */
	public EchoTCPServer() {

		System.out.println("Echo TCP SERVER is running on port: " + PORT);

	}

	/**
	 * M�todo encargado de crear la escucha en el puerto dado y aceptar los comandos
	 * que por est� recibe
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
