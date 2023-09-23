package controller;

import model.Vehiculo;
import view.vehiculosEncontradosView;

import java.util.ArrayList;

public class vehiculoController {

	public boolean agregarVehiculo(Vehiculo vehiculo) {
		boolean results=vehiculo.registrarVehiculo();
		return results;
	}

	public boolean buscarVehiculos(String marca, String modelo) {
		if(!marca.isEmpty() && !marca.isEmpty()){
			Vehiculo vehiculo=new Vehiculo(marca,modelo,null,0,0,0);
			ArrayList<Vehiculo> vehiculosRegistrados=new ArrayList<>(vehiculo.obtenerVehiculos());
			ArrayList<Vehiculo> vehiculos=new ArrayList<>();
			for(Vehiculo vehiculo1:vehiculosRegistrados){
				if(vehiculo1.getMarca().equals(marca)||vehiculo1.getModelo().equals(modelo)){
					vehiculos.add(vehiculo1);
				}
			}
			new vehiculosEncontradosView(vehiculos);
			return true;
		}
		return false;
	}
}