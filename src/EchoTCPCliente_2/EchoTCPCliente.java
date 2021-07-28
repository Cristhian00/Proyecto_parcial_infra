package EchoTCPCliente_2;

import java.net.Socket;
/**
 * Clase encargada de crear la comunicaci�n del cliente dado un puerto destino 
 * por el cual se va a comunicar con el servidor. Y su respectivo main para
 * darle inicio a la comunicaci�n entre este y el servidor.
 * 
 * @author Tatiana Arboleda, Cristhian Ortiz y Diego Valencia
 *
 */
public class EchoTCPCliente {

	public static final int PORT = 1025;
	public static final String SERVER = "localhost";

	private Socket clienteSideSocket;

	public EchoTCPCliente() {
		System.out.println("Echo TCP Cliente..");
	}

	/**
	 * M�todo encargado de iniciar la comunicaci�n del cliente con el 
	 * servidor dando inicio a su respectivo socket y cuando esta comunicaci�n termina
	 * se cierra.
	 * 
	 * @throws Exception
	 */
	public void init() throws Exception {

		while (true) {
			clienteSideSocket = new Socket(SERVER, PORT);
			EchoTCPClienteProtocol.protocol(clienteSideSocket);
			clienteSideSocket.close();
		}
	}

	public static void main(String[] args) throws Exception {

		EchoTCPCliente ec = new EchoTCPCliente();
		ec.init();
	}

}
