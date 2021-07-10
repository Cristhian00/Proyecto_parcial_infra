package EchoTCPCliente_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class EchoTCPClienteProtocol {
	
	private static final Scanner SCANNER =new Scanner(System.in);
	
	private static PrintWriter toNerwork;
	private static BufferedReader fromNetwork;
	
	public static void protocol(Socket socket) throws Exception {
		createStreams(socket);
		
		System.out.print("Ingrese su nombre: ");
		String fromUser = SCANNER.nextLine();
		
		String mensaje = fromUser ;
		
		toNerwork.println(mensaje);
		
		String fromServer = fromNetwork.readLine();
		System.out.println("[Client] from server:"+ fromServer);
	}
	
	private static void createStreams (Socket socket) throws Exception {
		toNerwork = new PrintWriter(socket.getOutputStream(),true);
		fromNetwork = new BufferedReader(new InputStreamReader(socket.getInputStream()));
	}

}

