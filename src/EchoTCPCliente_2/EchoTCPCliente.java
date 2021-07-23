package EchoTCPCliente_2;

import java.net.Socket;

public class EchoTCPCliente {

	public static final int PORT = 18862;
	public static final String SERVER = "8.tcp.ngrok.io";

	private Socket clienteSideSocket;

	public EchoTCPCliente() {
		System.out.println("Echo TCP Cliente..");
	}

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
