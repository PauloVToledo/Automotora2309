package model;

import data.GestorDatos;

public class Cliente {
	private String nombre;
	private String rut;
	private String direccion;
	private String correoElectronico;
	private String numeroTelefonico;

	public Cliente(String nombre, String rut, String direccion, String correoElectronico, String numeroTelefonico) {
		this.nombre = nombre;
		this.rut = rut;
		this.direccion = direccion;
		this.correoElectronico = correoElectronico;
		this.numeroTelefonico = numeroTelefonico;
	}

	public String getNombre() {
		return this.nombre;
	}

	public String getRut() {
		return this.rut;
	}

	public String getDireccion() {
		return this.direccion;
	}

	public String getCorreoElectronico() {
		return this.correoElectronico;
	}

	public String getNumeroTelefonico() {
		return this.numeroTelefonico;
	}

	public boolean registrarCliente() {
		GestorDatos gestorDatos=new GestorDatos("clientes.txt");
		boolean results=gestorDatos.agregarCliente(this.nombre,this.rut,this.direccion,this.correoElectronico,this.numeroTelefonico);
		return results;
	}
}