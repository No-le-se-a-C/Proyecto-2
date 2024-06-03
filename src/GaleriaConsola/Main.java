package GaleriaConsola;

import GaleriaModelo.Galeria;
import GaleriaModelo.Inventario;
import GaleriaPieza.Libro;
import GaleriaServiciosDeAdquisicion.Precio;
import GaleriaServiciosDeAdquisicion.Subasta;
import Interfaz.Interfaz;

import java.time.LocalDate;

import GaleriaEmpleados.Administrador;
import GaleriaEmpleados.Cajero;
import GaleriaEmpleados.Operador;
import GaleriaGestionSesion.Artista;
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
		
		Usuario usuario= new Artista("messi","");
		Precio precio=new Precio();
		precio.setPrecio(10);
		precio.setUsuario(null);

		Libro libro= new Libro("messi", null, null, 
				(Artista) usuario, true, precio, true, 
				true, 10, null);
		
		
		LocalDate date= LocalDate.of(2025, 6, 2);
		
		Subasta subasta= new Subasta(libro, date );
       
		galeria.aniadirSubasta(subasta);
		
		/*Vista vista= new Vista();
		vista.interfaz(galeria);*/
		
		Interfaz interfaz= new Interfaz(galeria);
	}

}
