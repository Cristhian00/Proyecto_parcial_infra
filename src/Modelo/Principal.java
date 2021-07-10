package Modelo;

import javax.swing.JOptionPane;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String menu = "    "+"MI BANCO" +"\n"+"1. Crear usuario"+"\n"
							+"2.Abrir cuenta"+"\n"+"3.Crear bolsillo"+"\n"+"4.Cancelar bolsillo"
							+"\n"+"5.Cancelar cuenta"+"\n"+"6.Depositar dinero en una cuenta"+"\n"+
							"7.Retirar dinero"+"\n"+"8.Trasladar dinero a un bolsillo"+"\n"+"9.Consultar saldo"
							+"\n"+"10.Cargar datos automaticos";
		
		
		int res ;
		int confir=0;
		String operacion ="";
		
		do {
			res = Integer.parseInt(JOptionPane.showInputDialog(menu));
			
		switch (res) {
		
		case 1: 
			operacion = "CREAR_USUARIO,";
			operacion += JOptionPane.showInputDialog("Escriba su nombre completo:")+",";
			operacion += JOptionPane.showInputDialog("Escriba su contraseña:");
			break;
		case 2:
			operacion = "ABRIR_CUENTA,";
			operacion += JOptionPane.showInputDialog("Escriba su nombre completo:");
			break;
		case 3:
			operacion = "ABRIR_BOLSILLO,";
			operacion += JOptionPane.showInputDialog("Escriba su número de cuenta de ahorro:");
			break;
		case 4:
			operacion = "CANCELAR_BOLSILLO,";
			operacion += JOptionPane.showInputDialog("Escriba el número de cuenta del bolsillo que desea cancelar");
			break;
		case 5:
			operacion = "CANCELAR_CUENTA,";
			operacion += JOptionPane.showInputDialog("Escriba el número de cuenta de ahorros a cancelar:");
			break;
		case 6:
			operacion = "DEPOSITAR,";
			operacion += JOptionPane.showInputDialog("Escriba su número de cuenta de ahorro:");
			break;
		case 7:
			operacion = "RETIRAR,";
			operacion += JOptionPane.showInputDialog("Escriba su número de cuenta de ahorro:");
			break;
		case 8:
			operacion = "TRASLADAR,";
			operacion += JOptionPane.showInputDialog("Escriba su número de cuenta de ahorro:")+",";
			operacion += JOptionPane.showInputDialog("Escriba el valor que desea trasladar:");
			break;
		case 9:
			operacion = "CONSULTAR,";
			operacion += JOptionPane.showInputDialog("Escriba su número de la cuenta:");
			break;
		case 10:
			operacion = "CARGA,";
			operacion += JOptionPane.showInputDialog("Escriba nombre archivo");
			break;
		
		default:break;
		}
		
		confir= JOptionPane.showConfirmDialog(null, "Desea realizar otra operación:");
			
		} while (confir == 0);
		
	}

}
