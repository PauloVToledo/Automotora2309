package controller;

import model.Cliente;

public class clienteController {

	public boolean agregarCliente(Cliente cliente) {
		boolean registrarCliente=cliente.registrarCliente();
		return registrarCliente;
	}
}