package Modelo;

import vista.VentanaCliente;

public class MainVentana {

	public static void main(String[] args) {
		try {
			VentanaCliente ventana = new VentanaCliente();
			ventana.setVisible(true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
