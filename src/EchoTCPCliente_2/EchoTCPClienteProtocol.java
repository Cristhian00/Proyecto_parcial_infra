package EchoTCPCliente_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class EchoTCPClienteProtocol {

	private static final Scanner SCANNER = new Scanner(System.in);

	private static PrintWriter toNetwork;
	private static BufferedReader fromNetwork;

	public static void protocol(Socket socket) throws Exception {

		createStreams(socket);

		String menu = "    " + "MI BANCO" + "\n" + "Ingrese la opción que desea realizar" + "\n" + "1.Abrir cuenta"
				+ "\n" + "2.Crear bolsillo" + "\n" + "3.Cancelar bolsillo" + "\n" + "4.Cancelar cuenta" + "\n"
				+ "5.Depositar dinero en una cuenta" + "\n" + "6.Retirar dinero" + "\n"
				+ "7.Trasladar dinero a un bolsillo" + "\n" + "8.Consultar saldo" + "\n" + "9.Cargar datos automaticos";

		int res = -1;
		int confir = 0;
		String operacion = "";
		String fromUser = "";
		String fromServer = "";
		boolean ban = false;

		do {

			try {
				res = Integer.parseInt(JOptionPane.showInputDialog(menu));
				System.out.println("Perro hp -- " + res);
			} catch(NumberFormatException e) {
				
			}

			if (res == -1) {
				JOptionPane.showMessageDialog(null, "La opción que selecciono no existe");
			} else {
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
					fromUser = JOptionPane
							.showInputDialog("Escriba el número de cuenta del bolsillo que desea cancelar");
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

					fromUser = JOptionPane.showInputDialog("Escriba el nombre del archivo");
					operacion = 0 + ",CARGA," + fromUser;

					toNetwork.println(operacion);

					fromServer = fromNetwork.readLine();

					String[] lista = fromServer.split("-");
					String oper = "";

					for (int i = 0; i < lista.length; i++) {

						oper = lista[i].split(",")[0];
						System.out.println("LIne = " + lista[i] + " --- Oper = " + oper);

						switch (oper) {
						case "ABRIR_CUENTA":
							operacion = lista[i];
							break;
						case "ABRIR_BOLSILLO":
							operacion = lista[i];
							break;
						case "CANCELAR_BOLSILLO":
							operacion = lista[i];
							break;
						case "CANCELAR_CUENTA":
							operacion = lista[i];
							break;
						case "DEPOSITAR":
							operacion = lista[i];
							break;
						case "RETIRAR":
							operacion = lista[i];
							break;
						case "TRASLADAR":
							operacion = lista[i];
							break;
						case "CONSULTAR":
							operacion = lista[i];
							break;
						default:
							System.out.println("Ninguna opción se selecciono");
							break;
						}

						toNetwork.println(0 + "," + operacion);

						fromServer = fromNetwork.readLine();
						System.out.println("[Client] from server: " + fromServer);

					}
					ban = true;
					break;
				default:
					JOptionPane.showMessageDialog(null, "La opción que selecciono no existe");
					break;
				}

				if (ban == false) {
					confir = JOptionPane.showConfirmDialog(null, "¿Desea realizar otra operación?");
					toNetwork.println(confir + "," + operacion);

					fromServer = fromNetwork.readLine();
					JOptionPane.showMessageDialog(null, fromServer);
					System.out.println("[Client] from server:" + fromServer);
				} else {
					JOptionPane.showMessageDialog(null, "Se cargaron todos los datos del archivo");
					ban = false;
				}
			}

		} while (confir == 0);

	}

	private static void createStreams(Socket socket) throws Exception {
		toNetwork = new PrintWriter(socket.getOutputStream(), true);
		fromNetwork = new BufferedReader(new InputStreamReader(socket.getInputStream()));
	}

}
