package Modelo;

import java.util.Date;

public class Transaccion {
	private String nombre;
	private Date fecha;

	public Transaccion(String nombre, Date fecha) {
		super();
		this.nombre = nombre;
		this.fecha = fecha;
	}

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
