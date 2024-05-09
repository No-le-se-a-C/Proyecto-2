package GaleriaConsola;

import GaleriaModelo.Galeria;
import GaleriaModelo.Inventario;

import GaleriaEmpleados.Administrador;
import GaleriaEmpleados.Cajero;
import GaleriaEmpleados.Operador;
import GaleriaGestionSesion.Usuario;
//import com.google.gson.Gson;

public class Main {
	
	public static void main(String[] args) {
		
		Inventario inventario= new Inventario();
		//se inicia la galeria
		Galeria galeria= new Galeria(inventario);
		
		//se le introducen los 3 empleados de cada dominacion con su usuario
		
		Usuario administrador= new Administrador("Administrador", "123");
		
		Usuario operador= new Operador("Operador", "123");
		
		Usuario cajero= new Cajero("Cajero", "123");
		
		galeria.aniadirUsuarioEmpleado(cajero);
		galeria.aniadirUsuarioEmpleado(administrador);
		galeria.aniadirUsuarioEmpleado(operador);
		
		
		// Guardamos los empleados en archivos Json
		//Gson gson = new Gson();
	   //String jsonAdministrador = gson.toJson(administrador);
	    //String jsonCajero = gson.toJson(cajero);
	   // String jsonOperador = gson.toJson(operador);
       
		
		Vista vista= new Vista();
		vista.interfaz(galeria);
		
	}

}
