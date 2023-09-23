package data;
import java.io.*;
import java.nio.Buffer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import model.Cliente;
import model.Vehiculo;

import java.util.ArrayList;

public class GestorDatos {
	private String direccionArchivo;

	public GestorDatos(String direccionArchivo) {
		this.direccionArchivo=direccionArchivo;
	}

	public boolean agregarCliente(String nombre,String rut,String direccion, String correoElectronico,String numeroTelefonico) {
		System.out.println("a");

		boolean lineaVacia=false;
		if(noEsCliente(rut)==false){
			return false;
		}
		try{
			File archivo=new File(this.direccionArchivo);
			FileWriter fileWriter = new FileWriter(archivo, true);
			BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

			if (lineaVacia == false) {
				bufferedWriter.newLine();
			}
			//bufferedWriter.write(cliente.toString());
			bufferedWriter.write(nombre+","+rut+","
					+direccion+","+correoElectronico+","+numeroTelefonico);
			bufferedWriter.close();
			fileWriter.close();
			return true;
		}catch (Exception e){
			System.out.println("Error al ingresar hora de llegada, favor contactar con administrador");
			return false;
		}
	}
	public boolean noEsCliente(String rut) {
		String textoArchivo = "";
		try {
			File archivo = new File(this.direccionArchivo);
			if (!archivo.exists()) {
				archivo.createNewFile();
			}
			// Comprobamos si existe
			FileReader fileReader = new FileReader(archivo);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			//Lee cada linea del archivo hasta que la linea sea nula
			while ((textoArchivo = bufferedReader.readLine()) != null) {
				String[] data = textoArchivo.split(",");
				if (data.length== 5 && rut.equals(data[1])) {
					fileReader.close();
					bufferedReader.close();
					return false;
				}
			}
			//Con eso corroboramos que el cliente no esta registrado por RUT
			fileReader.close();
			bufferedReader.close();
			return true;
		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
		return false;
	}


	public boolean agregarVehiculo(Vehiculo vehiculo) {
		boolean lineaVacia=false;
		try{

			File archivo=new File(this.direccionArchivo);
			FileWriter fileWriter = new FileWriter(archivo, true);
			if (!archivo.exists()) {
				archivo.createNewFile();
			}
			BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

			if (lineaVacia == false) {
				bufferedWriter.newLine();
			}
			//bufferedWriter.write(cliente.toString());
			bufferedWriter.write(vehiculo.getModelo()+","+vehiculo.getMarca()+","
					+vehiculo.getColor()+","+vehiculo.getAnho()+","+vehiculo.getPrecio()+","+vehiculo.getKilometraje());
			bufferedWriter.close();
			fileWriter.close();
			return true;
		}catch (Exception e){
			return false;
		}
	}
	public ArrayList<Vehiculo> obtenerVehiculos(){
		String textoArchivo = "";
		ArrayList<Vehiculo> vehiculosEncontrados=new ArrayList<>();
		try {
			File archivo = new File(this.direccionArchivo);
			if (!archivo.exists()) {
				archivo.createNewFile();
			}
			// Comprobamos si existe
			FileReader fileReader = new FileReader(archivo);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			//Lee cada linea del archivo hasta que la linea sea nula
			while ((textoArchivo = bufferedReader.readLine()) != null) {
				String[] data = textoArchivo.split(",");
				if(data.length>=6){
					vehiculosEncontrados.add(new Vehiculo(data[0],data[1],data[2],Integer.parseInt(data[3]),Integer.parseInt(data[4]),Integer.parseInt(data[5])));

				}
			}
			//Con eso corroboramos que el cliente no esta registrado por RUT
			fileReader.close();
			bufferedReader.close();
			return vehiculosEncontrados;
		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
			return null;
		}
	}
}