package model;

import data.GestorDatos;

import java.util.ArrayList;

public class Vehiculo {
	private String modelo;
	private String marca;
	private String color;
	private int anho;
	private int precio;
	private int kilometraje;

	public Vehiculo(String modelo, String marca, String color, int anho, int precio, int kilometraje) {
		this.modelo = modelo;
		this.marca = marca;
		this.color = color;
		this.anho = anho;
		this.precio = precio;
		this.kilometraje = kilometraje;
	}

	public String getModelo() {
		return this.modelo;
	}

	public String getMarca() {
		return this.marca;
	}

	public String getColor() {
		return this.color;
	}

	public int getAnho() {
		return this.anho;
	}

	public int getPrecio() {
		return this.precio;
	}

	public int getKilometraje() {
		return this.kilometraje;
	}

	public boolean registrarVehiculo() {
		GestorDatos gestorDatos=new GestorDatos("vehiculos.txt");
		boolean results=gestorDatos.agregarVehiculo(this);
		return results;
	}

	public ArrayList<Vehiculo> obtenerVehiculos() {
		GestorDatos gestorDatos=new GestorDatos("vehiculos.txt");
		return new ArrayList<>(gestorDatos.obtenerVehiculos());
	}
}