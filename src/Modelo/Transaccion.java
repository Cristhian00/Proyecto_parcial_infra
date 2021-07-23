package Modelo;

import java.util.Date;

/**
 * Clase de tipo Transacción encargada de guardar el nombre de la transacción
 * realizada y la fecha
 * 
 * @author Tatiana Arboleda, Cristhian Ortiz y Diego Valencia
 *
 */
public class Transaccion {
	private String nombre;
	private Date fecha;

	public Transaccion(String nombre, Date fecha) {
		super();
		this.nombre = nombre;
		this.fecha = fecha;
	}
	
	//**************************************GETS AND SETS****************************************
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

}
