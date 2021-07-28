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
import javax.swing.JTextField;
import java.awt.Color;

public class VentanaCliente extends JFrame implements ActionListener {

	private JPanel contentPane;
	private static VentanaCliente frame;

	private static JLabel lbTitulo;
	private static JLabel lbSub1;
	private static JLabel lbOper1;
	private static JLabel lbOper2;
	private static JLabel lbOper3;
	private static JLabel lbOper4;
	private static JLabel lbOper5;
	private static JLabel lbOper6;
	private static JLabel lbOper7;
	private static JLabel lbOper8;
	private static JLabel lbOper9;
	private static JLabel lbTran1;
	private static JLabel lbTran2;

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
	private static JButton bTransaccion;
	private static JButton bLimpiar;
	private static JButton bAtras;

	// Variables de TCPCliente
	public static final int PORT = 1025;
	public static final String SERVER = "localhost";
	private static Socket clienteSideSocket;

	// Variables de TCPClienteProtocol
	private static PrintWriter toNetwork;
	private static BufferedReader fromNetwork;
	private static JTextField tF1;
	private static JTextField tF2;

	/**
	 * Launch the application.
	 */
	/*
	 * public static void main(String[] args) { EventQueue.invokeLater(new
	 * Runnable() { public void run() { try { frame = new VentanaCliente();
	 * frame.setVisible(true); } catch (Exception e) { e.printStackTrace(); } } });
	 * }
	 */

	/**
	 * Create the frame.
	 */
	public VentanaCliente() throws Exception {

		System.out.println("Echo TCP Cliente...");

		setResizable(false);
		setTitle("Proyecto Banco TCP");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 100, 380, 490);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		grupoRadios = new ButtonGroup();

		lbTitulo = new JLabel("MI BANCO");
		lbTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lbTitulo.setFont(new Font("Tahoma", Font.BOLD, 20));
		lbTitulo.setBounds(10, 20, 344, 16);
		contentPane.add(lbTitulo);

		lbSub1 = new JLabel("\u00BFQu\u00E9 operaci\u00F3n desea realizar?");
		lbSub1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lbSub1.setBounds(10, 60, 251, 22);
		contentPane.add(lbSub1);

		lbOper1 = new JLabel("1. Abrir una nueva cuenta de ahorros");
		lbOper1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbOper1.setBounds(40, 95, 280, 14);
		contentPane.add(lbOper1);

		lbOper2 = new JLabel("2. Abrir un nuevo bolsillo");
		lbOper2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbOper2.setBounds(40, 130, 280, 14);
		contentPane.add(lbOper2);

		lbOper3 = new JLabel("3. Cancelar un bolsillo");
		lbOper3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbOper3.setBounds(40, 165, 280, 14);
		contentPane.add(lbOper3);

		lbOper4 = new JLabel("4. Cancelar una cuenta de ahorros");
		lbOper4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbOper4.setBounds(40, 200, 280, 14);
		contentPane.add(lbOper4);

		lbOper5 = new JLabel("5. Depositar dinero en una cuenta de ahorros");
		lbOper5.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbOper5.setBounds(40, 235, 280, 14);
		contentPane.add(lbOper5);

		lbOper6 = new JLabel("6. Retirar dinero de una cuenta");
		lbOper6.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbOper6.setBounds(40, 270, 280, 14);
		contentPane.add(lbOper6);

		lbOper7 = new JLabel("7. Trasladar dinero a un bolsillo");
		lbOper7.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbOper7.setBounds(40, 305, 280, 14);
		contentPane.add(lbOper7);

		lbOper8 = new JLabel("8. Consultar saldo");
		lbOper8.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbOper8.setBounds(40, 340, 280, 14);
		contentPane.add(lbOper8);

		lbOper9 = new JLabel("9. Cargar transacciones automaticas");
		lbOper9.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbOper9.setBounds(40, 375, 280, 14);
		contentPane.add(lbOper9);

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
		bAceptar.setForeground(Color.BLUE);
		bAceptar.setFont(new Font("Tahoma", Font.BOLD, 17));
		bAceptar.setBounds(125, 417, 110, 25);
		contentPane.add(bAceptar);
		bAceptar.addActionListener(this);

		tF1 = new JTextField();
		tF1.setBounds(210, 63, 154, 20);
		contentPane.add(tF1);
		tF1.setColumns(10);
		tF1.setVisible(false);

		tF2 = new JTextField();
		tF2.setBounds(210, 93, 154, 20);
		contentPane.add(tF2);
		tF2.setColumns(10);
		tF2.setVisible(false);

		bTransaccion = new JButton("Aceptar");
		bTransaccion.setFont(new Font("Tahoma", Font.BOLD, 17));
		bTransaccion.setBounds(25, 131, 101, 23);
		contentPane.add(bTransaccion);
		bTransaccion.setVisible(false);
		bTransaccion.addActionListener(this);

		bLimpiar = new JButton("Limpiar");
		bLimpiar.setForeground(Color.GRAY);
		bLimpiar.setFont(new Font("Tahoma", Font.BOLD, 17));
		bLimpiar.setBounds(140, 131, 110, 23);
		contentPane.add(bLimpiar);
		bLimpiar.setVisible(false);
		bLimpiar.addActionListener(this);

		bAtras = new JButton("Atr\u00E1s");
		bAtras.setForeground(Color.RED);
		bAtras.setFont(new Font("Tahoma", Font.BOLD, 14));
		bAtras.setBounds(265, 131, 75, 23);
		contentPane.add(bAtras);
		bAtras.setVisible(false);
		bAtras.addActionListener(this);

		lbTran1 = new JLabel("Ingrese nombre completo");
		lbTran1.setBounds(15, 66, 185, 14);
		contentPane.add(lbTran1);
		lbTran1.setVisible(false);

		lbTran2 = new JLabel("New label");
		lbTran2.setBounds(15, 97, 185, 14);
		contentPane.add(lbTran2);
		lbTran2.setVisible(false);

	}

	private static void createStreams() throws IOException {
		toNetwork = new PrintWriter(clienteSideSocket.getOutputStream(), true);
		fromNetwork = new BufferedReader(new InputStreamReader(clienteSideSocket.getInputStream()));
	}

	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == bAceptar) {
			if (verificarSeleccion()) {
				esconderMenuInicial();
				mostrarMenuTransaccion();
			} else {
				JOptionPane.showMessageDialog(null, "Debe seleccionar una opción", "Error", JOptionPane.ERROR_MESSAGE);
			}
		} else if (e.getSource() == bTransaccion) {
			init();
			mostrarMenuInicial();
			esconderMenuTransaccion();
			limpiarCampos();
			grupoRadios.clearSelection();
		} else if (e.getSource() == bLimpiar) {
			limpiarCampos();
		} else if (e.getSource() == bAtras) {
			esconderMenuTransaccion();
			mostrarMenuInicial();
			grupoRadios.clearSelection();
			limpiarCampos();
		}

	}

	private static void init() {
		try {
			clienteSideSocket = new Socket(SERVER, PORT);
			createStreams();
			validarRadioButtons();
			clienteSideSocket.close();
		} catch (Exception excep) {
			System.out.println(excep.getMessage());
		}
	}

	public static void validarRadioButtons() throws Exception {

		String numCuenta = "";
		String aux = "";
		String fromUser = "";
		String fromServer = "";
		String valor = "";
		boolean centinela = false;
		int confir = 1;

		if (rB1.isSelected()) {
			if (tF1.getText().isEmpty()) {
				JOptionPane.showMessageDialog(null, "Debe ingresar su nombre", "Error", JOptionPane.ERROR_MESSAGE);
			} else {
				aux = tF1.getText();
				fromUser = "ABRIR_CUENTA," + aux;
			}
		} else if (rB2.isSelected()) {
			if (tF1.getText().isEmpty()) {
				JOptionPane.showMessageDialog(null, "Debe ingresar su número de cuenta", "Error",
						JOptionPane.ERROR_MESSAGE);
			} else {
				numCuenta = tF1.getText();
				fromUser = "ABRIR_BOLSILLO," + numCuenta;
			}
		} else if (rB3.isSelected()) {
			if (tF1.getText().isEmpty()) {
				JOptionPane.showMessageDialog(null, "Debe ingresar su número de cuenta", "Error",
						JOptionPane.ERROR_MESSAGE);
			} else {
				numCuenta = tF1.getText();
				fromUser = "CANCELAR_BOLSILLO," + numCuenta;
			}
		} else if (rB4.isSelected()) {
			if (tF1.getText().isEmpty()) {
				JOptionPane.showMessageDialog(null, "Debe ingresar su número de cuenta", "Error",
						JOptionPane.ERROR_MESSAGE);
			} else {
				numCuenta = tF1.getText();
				fromUser = "CANCELAR_CUENTA," + numCuenta;
			}
		} else if (rB5.isSelected()) {
			if (tF1.getText().isEmpty() || tF2.getText().isEmpty()) {
				JOptionPane.showMessageDialog(null, "Debe ingresar los datos solicitados", "Error",
						JOptionPane.ERROR_MESSAGE);
			} else {
				numCuenta = tF1.getText();
				valor = tF2.getText();
				fromUser = "DEPOSITAR," + numCuenta + "," + valor;
			}
		} else if (rB6.isSelected()) {
			if (tF1.getText().isEmpty() || tF2.getText().isEmpty()) {
				JOptionPane.showMessageDialog(null, "Debe ingresar los datos solicitados", "Error",
						JOptionPane.ERROR_MESSAGE);
			} else {
				numCuenta = tF1.getText();
				valor = tF2.getText();
				fromUser = "RETIRAR," + numCuenta + "," + valor;
			}
		} else if (rB7.isSelected()) {
			if (tF1.getText().isEmpty() || tF2.getText().isEmpty()) {
				JOptionPane.showMessageDialog(null, "Debe ingresar los datos solicitados", "Error",
						JOptionPane.ERROR_MESSAGE);
			} else {
				numCuenta = tF1.getText();
				valor = tF2.getText();
				fromUser = "TRASLADAR," + numCuenta + "," + valor;
			}
		} else if (rB8.isSelected()) {
			if (tF1.getText().isEmpty()) {
				JOptionPane.showMessageDialog(null, "Debe ingresar su número de cuenta", "Error",
						JOptionPane.ERROR_MESSAGE);
			} else {
				numCuenta = tF1.getText();
				fromUser = "CONSULTAR," + numCuenta;
			}
		} else if (rB9.isSelected()) {
			if (tF1.getText().isEmpty()) {
				JOptionPane.showMessageDialog(null, "Debe ingresar el nombre del archivo a cargar", "Error",
						JOptionPane.ERROR_MESSAGE);
			} else {
				aux = tF1.getText();
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
						System.out.println("[Client] Ninguna opción se seleeciono");
						break;
					}

					if (i == lista.length - 1) {
						toNetwork.println(confir + "," + fromUser);

					} else {
						toNetwork.println(0 + "," + fromUser);
					}

					fromServer = fromNetwork.readLine();
					System.out.println("[Client] from server: " + fromServer);
				}
				centinela = true;
			}
		} else {
			JOptionPane.showMessageDialog(null, "Debe seleccionar una opción", "Error", JOptionPane.ERROR_MESSAGE);
		}

		if (centinela == false && !fromUser.isEmpty()) {

			toNetwork.println(confir + "," + fromUser);

			fromServer = fromNetwork.readLine();
			JOptionPane.showMessageDialog(null, fromServer);
			System.out.println("[Client] from server:" + fromServer);

		} else if (centinela == true) {
			JOptionPane.showMessageDialog(null, "Se cargaron todos los datos del archivo");
			centinela = false;
		}
	}

	public void esconderMenuInicial() {

		setBounds(500, 100, 390, 220);

		lbSub1.setVisible(false);
		lbOper1.setVisible(false);
		lbOper2.setVisible(false);
		lbOper3.setVisible(false);
		lbOper4.setVisible(false);
		lbOper5.setVisible(false);
		lbOper6.setVisible(false);
		lbOper7.setVisible(false);
		lbOper8.setVisible(false);
		lbOper9.setVisible(false);

		rB1.setVisible(false);
		rB2.setVisible(false);
		rB3.setVisible(false);
		rB4.setVisible(false);
		rB5.setVisible(false);
		rB6.setVisible(false);
		rB7.setVisible(false);
		rB8.setVisible(false);
		rB9.setVisible(false);

		bAceptar.setVisible(false);
	}

	public void mostrarMenuInicial() {

		setBounds(500, 100, 380, 490);

		lbTitulo.setText("MI BANCO");

		lbSub1.setVisible(true);
		lbOper1.setVisible(true);
		lbOper2.setVisible(true);
		lbOper3.setVisible(true);
		lbOper4.setVisible(true);
		lbOper5.setVisible(true);
		lbOper6.setVisible(true);
		lbOper7.setVisible(true);
		lbOper8.setVisible(true);
		lbOper9.setVisible(true);

		rB1.setVisible(true);
		rB2.setVisible(true);
		rB3.setVisible(true);
		rB4.setVisible(true);
		rB5.setVisible(true);
		rB6.setVisible(true);
		rB7.setVisible(true);
		rB8.setVisible(true);
		rB9.setVisible(true);

		bAceptar.setVisible(true);
	}

	public void esconderMenuTransaccion() {

		lbTran1.setVisible(false);
		lbTran2.setVisible(false);

		tF1.setVisible(false);
		tF2.setVisible(false);

		bTransaccion.setVisible(false);
		bLimpiar.setVisible(false);
		bAtras.setVisible(false);
	}

	public void mostrarMenuTransaccion() {

		lbTran1.setVisible(true);

		tF1.setVisible(true);

		bTransaccion.setVisible(true);
		bLimpiar.setVisible(true);
		bAtras.setVisible(true);
	}

	public void limpiarCampos() {
		tF1.setText("");
		tF2.setText("");
	}

	public boolean verificarSeleccion() {

		boolean ban = false;

		if (rB1.isSelected()) {
			lbTitulo.setText("MI BANCO - " + "ABRIR CUENTA");
			lbTran1.setText("Ingrese su nombre completo");
			ban = true;
		} else if (rB2.isSelected()) {
			lbTitulo.setText("MI BANCO - " + "ABRIR BOLSILLO");
			lbTran1.setText("Ingrese su número de cuenta");
			ban = true;
		} else if (rB3.isSelected()) {
			lbTitulo.setText("MI BANCO - " + "CANCELAR BOLSILLO");
			lbTran1.setText("Ingrese su número de bolsillo");
			ban = true;
		} else if (rB4.isSelected()) {
			lbTitulo.setText("MI BANCO - " + "CANCELAR CUENTA");
			lbTran1.setText("Ingrese su número de cuenta");
			ban = true;
		} else if (rB5.isSelected()) {
			lbTitulo.setText("MI BANCO - " + "DEPOSITAR");
			lbTran2.setVisible(true);
			tF2.setVisible(true);
			lbTran1.setText("Ingrese su número de cuenta");
			lbTran2.setText("Ingrese el valor a depositar");
			ban = true;
		} else if (rB6.isSelected()) {
			lbTitulo.setText("MI BANCO - " + "RETIRAR");
			lbTran2.setVisible(true);
			tF2.setVisible(true);
			lbTran1.setText("Ingrese su número de cuenta");
			lbTran2.setText("Ingrese el valor a retirar");
			ban = true;
		} else if (rB7.isSelected()) {
			lbTitulo.setText("MI BANCO - " + "TRASLADAR");
			lbTran2.setVisible(true);
			tF2.setVisible(true);
			lbTran1.setText("Ingrese su número de cuenta");
			lbTran2.setText("Ingrese el valor a trasladar");
			ban = true;
		} else if (rB8.isSelected()) {
			lbTitulo.setText("MI BANCO - " + "CONSULTAR");
			lbTran1.setText("Ingrese su número de cuenta");
			ban = true;
		} else if (rB9.isSelected()) {
			lbTitulo.setText("MI BANCO - " + "CARGA");
			lbTran1.setText("Escriba el nombre del archivo");
			ban = true;
		}
		return ban;
	}
}
