package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.awt.event.ActionEvent;

public class VentanaCliente extends JFrame implements ActionListener {

	private JPanel contentPane;
	private static VentanaCliente frame;

	private static ButtonGroup grupoRadios;
	private static JRadioButton rB1;
	private static JRadioButton rB2;
	private static JRadioButton rB3;
	private static JRadioButton rB4;
	private static JRadioButton rB5;
	private static JRadioButton rB6;
	private static JRadioButton rB7;
	private static JRadioButton rB8;
	private static JRadioButton rB9;
	private static JButton bAceptar;

	// Variables de TCPCliente
	public static final int PORT = 17194;
	public static final String SERVER = "6.tcp.ngrok.io";
	private static Socket clienteSideSocket;

	// Variables de TCPClienteProtocol
	private static PrintWriter toNetwork;
	private static BufferedReader fromNetwork;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new VentanaCliente();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VentanaCliente() throws Exception {

		System.out.println("Echo TCP Cliente..");

		setResizable(false);
		setTitle("Proyecto Banco TCP");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 380, 490);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		grupoRadios = new ButtonGroup();

		JLabel lblNewLabel = new JLabel("MI BANCO");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(10, 21, 344, 16);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("\u00BFQu\u00E9 operaci\u00F3n desea realizar?");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setBounds(10, 60, 251, 22);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("1. Abrir una nueva cuenta de ahorros");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(40, 95, 280, 14);
		contentPane.add(lblNewLabel_2);

		JLabel lblNewLabel_2_1 = new JLabel("2. Abrir un nuevo bolsillo");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2_1.setBounds(40, 130, 280, 14);
		contentPane.add(lblNewLabel_2_1);

		JLabel lblNewLabel_2_2 = new JLabel("3. Cancelar un bolsillo");
		lblNewLabel_2_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2_2.setBounds(40, 165, 280, 14);
		contentPane.add(lblNewLabel_2_2);

		JLabel lblNewLabel_2_3 = new JLabel("4. Cancelar una cuenta de ahorros");
		lblNewLabel_2_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2_3.setBounds(40, 200, 280, 14);
		contentPane.add(lblNewLabel_2_3);

		JLabel lblNewLabel_2_4 = new JLabel("5. Depositar dinero en una cuenta de ahorros");
		lblNewLabel_2_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2_4.setBounds(40, 235, 280, 14);
		contentPane.add(lblNewLabel_2_4);

		JLabel lblNewLabel_2_5 = new JLabel("6. Retirar dinero de una cuenta");
		lblNewLabel_2_5.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2_5.setBounds(40, 270, 280, 14);
		contentPane.add(lblNewLabel_2_5);

		JLabel lblNewLabel_2_6 = new JLabel("7. Trasladar dinero a un bolsillo");
		lblNewLabel_2_6.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2_6.setBounds(40, 305, 280, 14);
		contentPane.add(lblNewLabel_2_6);

		JLabel lblNewLabel_2_7 = new JLabel("8. Consultar saldo");
		lblNewLabel_2_7.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2_7.setBounds(40, 340, 280, 14);
		contentPane.add(lblNewLabel_2_7);

		JLabel lblNewLabel_2_8 = new JLabel("9. Cargar transacciones automaticas");
		lblNewLabel_2_8.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2_8.setBounds(40, 375, 280, 14);
		contentPane.add(lblNewLabel_2_8);

		rB1 = new JRadioButton("");
		rB1.setBounds(15, 92, 25, 23);
		contentPane.add(rB1);

		rB2 = new JRadioButton("");
		rB2.setBounds(15, 127, 25, 23);
		contentPane.add(rB2);

		rB3 = new JRadioButton("");
		rB3.setBounds(15, 162, 25, 23);
		contentPane.add(rB3);

		rB4 = new JRadioButton("");
		rB4.setBounds(15, 197, 25, 23);
		contentPane.add(rB4);

		rB5 = new JRadioButton("");
		rB5.setBounds(15, 232, 25, 23);
		contentPane.add(rB5);

		rB6 = new JRadioButton("");
		rB6.setBounds(15, 267, 25, 23);
		contentPane.add(rB6);

		rB7 = new JRadioButton("");
		rB7.setBounds(15, 302, 25, 23);
		contentPane.add(rB7);

		rB8 = new JRadioButton("");
		rB8.setBounds(15, 337, 25, 23);
		contentPane.add(rB8);

		rB9 = new JRadioButton("");
		rB9.setBounds(15, 372, 25, 23);
		contentPane.add(rB9);

		grupoRadios.add(rB1);
		grupoRadios.add(rB2);
		grupoRadios.add(rB3);
		grupoRadios.add(rB4);
		grupoRadios.add(rB5);
		grupoRadios.add(rB6);
		grupoRadios.add(rB7);
		grupoRadios.add(rB8);
		grupoRadios.add(rB9);

		bAceptar = new JButton("Aceptar");
		bAceptar.setFont(new Font("Tahoma", Font.BOLD, 17));
		bAceptar.setBounds(125, 417, 110, 25);
		contentPane.add(bAceptar);

		bAceptar.addActionListener(this);
	}

	private static void createStreams() throws IOException {
		toNetwork = new PrintWriter(clienteSideSocket.getOutputStream(), true);
		fromNetwork = new BufferedReader(new InputStreamReader(clienteSideSocket.getInputStream()));
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == bAceptar)
			init();
	}

	private static void init() {
		try {
			clienteSideSocket = new Socket(SERVER, PORT);
			validarRadioButtons();
			clienteSideSocket.close();
			System.exit(0);
		} catch (Exception excep) {
			System.out.println(excep.getMessage());
		}
	}

	public static int validarRadioButtons() throws Exception {

		createStreams();

		String numCuenta = "";
		String aux = "";
		String fromUser = "";
		String fromServer = "";
		double valor = 0.0;
		boolean ban = true;
		boolean centinela = false;
		int confir = 0;

		if (rB1.isSelected()) {
			aux = JOptionPane.showInputDialog("Ingrese su nombre y apellido");
			fromUser = "ABRIR_CUENTA," + aux;
		} else if (rB2.isSelected()) {
			numCuenta = JOptionPane.showInputDialog("Ingrese el n�mero de la cuenta de ahorros");
			fromUser = "ABRIR_BOLSILLO," + numCuenta;
		} else if (rB3.isSelected()) {
			numCuenta = JOptionPane.showInputDialog("Ingrese el n�mero del bolsillo a cancelar");
			fromUser = "CANCELAR_BOLSILLO," + numCuenta;
		} else if (rB4.isSelected()) {
			numCuenta = JOptionPane.showInputDialog("Ingrese el n�mero de la cuenta de ahorros a cancelar");
			fromUser = "CANCELAR_CUENTA," + numCuenta;
		} else if (rB5.isSelected()) {
			numCuenta = JOptionPane.showInputDialog("Ingrese el n�mero de la cuenta de ahorros");
			while (ban) {
				try {
					valor = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el valor que desea depositar"));
					ban = false;
					fromUser = "DEPOSITAR," + numCuenta + "," + valor;
				} catch (NumberFormatException e) {
					JOptionPane.showMessageDialog(null, "Debe ingresar solo n�meros");
				}
			}
		} else if (rB6.isSelected()) {
			numCuenta = JOptionPane.showInputDialog("Ingrese el n�mero de la cuenta de ahorros");
			while (ban) {
				try {
					valor = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el valor que desea retirar"));
					ban = false;
					fromUser = "RETIRAR," + numCuenta + "," + valor;
				} catch (NumberFormatException e) {
					JOptionPane.showMessageDialog(null, "Debe ingresar solo n�meros");
				}
			}
		} else if (rB7.isSelected()) {
			numCuenta = JOptionPane.showInputDialog("Ingrese el n�mero de la cuenta de ahorros");
			while (ban) {
				try {
					valor = Double.parseDouble(
							JOptionPane.showInputDialog("Ingrese el valor que desea trasladar al bolsillo"));
					ban = false;
					fromUser = "TRASLADAR," + numCuenta + "," + valor;
				} catch (NumberFormatException e) {
					JOptionPane.showMessageDialog(null, "Debe ingresar solo n�meros");
				}
			}
		} else if (rB8.isSelected()) {
			numCuenta = JOptionPane.showInputDialog("Ingrese el n�mero de la cuenta a consular saldo");
			fromUser = "CONSULTAR," + numCuenta;
		} else if (rB9.isSelected()) {

			aux = JOptionPane.showInputDialog("Escriba el nombre del archivo");
			fromUser = 0 + ",CARGA," + aux;

			toNetwork.println(fromUser);

			fromServer = fromNetwork.readLine();

			String[] lista = fromServer.split("-");
			String oper = "";

			for (int i = 0; i < lista.length; i++) {

				oper = lista[i].split(",")[0];

				switch (oper) {
				case "ABRIR_CUENTA":
					fromUser = lista[i];
					break;
				case "ABRIR_BOLSILLO":
					fromUser = lista[i];
					break;
				case "CANCELAR_BOLSILLO":
					fromUser = lista[i];
					break;
				case "CANCELAR_CUENTA":
					fromUser = lista[i];
					break;
				case "DEPOSITAR":
					fromUser = lista[i];
					break;
				case "RETIRAR":
					fromUser = lista[i];
					break;
				case "TRASLADAR":
					fromUser = lista[i];
					break;
				case "CONSULTAR":
					fromUser = lista[i];
					break;
				default:
					System.out.println("[Client] Ninguna opci�n se seleeciono");
					break;
				}

				toNetwork.println(0 + "," + fromUser);

				fromServer = fromNetwork.readLine();
				System.out.println("[Client] from server: " + fromServer);

			}
			centinela = true;

		} else {
			JOptionPane.showMessageDialog(null, "Debe seleccionar una opci�n", "Error", JOptionPane.ERROR_MESSAGE);
		}

		ban = true;
		if (centinela == false && !fromUser.isEmpty()) {

			confir = JOptionPane.showConfirmDialog(null, "�Desea realizar otra operaci�n?");
			toNetwork.println(confir + "," + fromUser);

			fromServer = fromNetwork.readLine();
			JOptionPane.showMessageDialog(null, fromServer);
			System.out.println("[Client] from server:" + fromServer);
			
		} else if (centinela == true) {
			JOptionPane.showMessageDialog(null, "Se cargaron todos los datos del archivo");
		}

		return confir;
	}
}
