package Modelo;

import javax.swing.JOptionPane;

/**
 * CLase encargada de mostrar menú y capturar la opción dada
 * 
 * @author Tatiana Arboleda, Diego Valencia y Cristhian Ortiz
 *
 */
public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String menu = "    " + "MI BANCO" + "\n" + "Ingrese la opción que desea ejecutar" + "\n" + "1.Abrir cuenta" + "\n"
				+ "2.Crear bolsillo" + "\n" + "3.Cancelar bolsillo" + "\n" + "4.Cancelar cuenta" + "\n"
				+ "5.Depositar dinero en una cuenta" + "\n" + "6.Retirar dinero" + "\n"
				+ "7.Trasladar dinero a un bolsillo" + "\n" + "8.Consultar saldo" + "\n"
				+ "9.Cargar datos automaticos";

		int res;
		int confir = 0;
		String operacion = "";

		do {
			res = Integer.parseInt(JOptionPane.showInputDialog(menu));

			switch (res) {

			case 1:
				operacion = "ABRIR_CUENTA,";
				operacion += JOptionPane.showInputDialog("Escriba su nombre completo:");
				break;
			case 2:
				operacion = "ABRIR_BOLSILLO,";
				operacion += JOptionPane.showInputDialog("Escriba su número de cuenta de ahorro:");
				break;
			case 3:
				operacion = "CANCELAR_BOLSILLO,";
				operacion += JOptionPane.showInputDialog("Escriba el número de cuenta del bolsillo que desea cancelar");
				break;
			case 4:
				operacion = "CANCELAR_CUENTA,";
				operacion += JOptionPane.showInputDialog("Escriba el número de cuenta de ahorros a cancelar:");
				break;
			case 5:
				operacion = "DEPOSITAR,";
				operacion += JOptionPane.showInputDialog("Escriba su número de cuenta de ahorro:");
				break;
			case 6:
				operacion = "RETIRAR,";
				operacion += JOptionPane.showInputDialog("Escriba su número de cuenta de ahorro:");
				break;
			case 7:
				operacion = "TRASLADAR,";
				operacion += JOptionPane.showInputDialog("Escriba su número de cuenta de ahorro:") + ",";
				operacion += JOptionPane.showInputDialog("Escriba el valor que desea trasladar:");
				break;
			case 8:
				operacion = "CONSULTAR,";
				operacion += JOptionPane.showInputDialog("Escriba su número de la cuenta:");
				break;
			case 9:
				operacion = "CARGA,";
				operacion += JOptionPane.showInputDialog("Escriba la ruta del archivo");
				break;
			default:
				JOptionPane.showMessageDialog(null, "La opción que selecciono no existe");
				break;
			}

			confir = JOptionPane.showConfirmDialog(null, "¿Desea realizar otra operación?");

		} while (confir == 0);

	}

}
