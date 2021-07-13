package EchoTCPCliente_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

import javax.swing.JOptionPane;

// DIEGO Y CRISTHIAN SE AMAN MUCHO 
//Malditos tengo celos 
public class EchoTCPClienteProtocol {

	private static final Scanner SCANNER = new Scanner(System.in);

	private static PrintWriter toNerwork;
	private static BufferedReader fromNetwork;

	public static void protocol(Socket socket) throws Exception {
		createStreams(socket);

		String menu = "    " + "MI BANCO" + "\n" + "Ingrese la opción que desea ejecutar" + "\n" + "1.Abrir cuenta"
				+ "\n" + "2.Crear bolsillo" + "\n" + "3.Cancelar bolsillo" + "\n" + "4.Cancelar cuenta" + "\n"
				+ "5.Depositar dinero en una cuenta" + "\n" + "6.Retirar dinero" + "\n"
				+ "7.Trasladar dinero a un bolsillo" + "\n" + "8.Consultar saldo" + "\n" + "9.Cargar datos automaticos";

		int res;
		int confir = 0;
		String operacion = "";
		String fromUser = "";

		do {
			res = Integer.parseInt(JOptionPane.showInputDialog(menu));

			switch (res) {

			case 1:
				fromUser = JOptionPane.showInputDialog("Escriba su nombre completo:");
				operacion = "ABRIR_CUENTA," + fromUser;
				break;
			case 2:
				fromUser = JOptionPane.showInputDialog("Escriba su número de cuenta de ahorro:");
				operacion = "ABRIR_BOLSILLO," + fromUser;
				break;
			case 3:
				fromUser = JOptionPane.showInputDialog("Escriba el número de cuenta del bolsillo que desea cancelar");
				operacion = "CANCELAR_BOLSILLO," + fromUser;
				break;
			case 4:
				fromUser = JOptionPane.showInputDialog("Escriba el número de cuenta de ahorros a cancelar:");
				operacion = "CANCELAR_CUENTA," + fromUser;
				break;
			case 5:
				fromUser = JOptionPane.showInputDialog("Escriba su número de cuenta de ahorro:") + ",";
				fromUser += JOptionPane.showInputDialog("Escriba el valor que desea depositar:");
				operacion = "DEPOSITAR," + fromUser;
				break;
			case 6:
				fromUser = JOptionPane.showInputDialog("Escriba su número de cuenta de ahorro:") + ",";
				fromUser += JOptionPane.showInputDialog("Escriba el valor que desea retirar:");
				operacion = "RETIRAR," + fromUser;
				break;
			case 7:
				fromUser = JOptionPane.showInputDialog("Escriba su número de cuenta de ahorro:") + ",";
				fromUser += JOptionPane.showInputDialog("Escriba el valor que desea trasladar:");
				operacion = "TRASLADAR," + fromUser;
				break;
			case 8:
				fromUser = JOptionPane.showInputDialog("Escriba su número de la cuenta:");
				operacion = "CONSULTAR," + fromUser;
				break;
			case 9:
				fromUser = JOptionPane.showInputDialog("Escriba nombre archivo");
				operacion = "CARGA,";
				break;
			default:
				JOptionPane.showMessageDialog(null, "La opción que selecciono no existe");
				break;
			}

			toNerwork.println(operacion);

			String fromServer = fromNetwork.readLine();
			JOptionPane.showMessageDialog(null, fromServer);
			System.out.println("[Client] from server:" + fromServer);

			confir = JOptionPane.showConfirmDialog(null, "¿Desea realizar otra operación?");

		} while (confir == 0);

	}

	private static void createStreams(Socket socket) throws Exception {
		toNerwork = new PrintWriter(socket.getOutputStream(), true);
		fromNetwork = new BufferedReader(new InputStreamReader(socket.getInputStream()));
	}

}
