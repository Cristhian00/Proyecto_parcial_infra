package EchoTCPServer_2;

import java.net.ServerSocket;
import java.net.Socket;

public class EchoTCPServer {

	public static final int PORT = 1025;
	private ServerSocket listener;
	private Socket serverSideSocket;

	public EchoTCPServer() {

		System.out.println("Echo TCP SERVER is running on port: " + PORT);
		
	}

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
