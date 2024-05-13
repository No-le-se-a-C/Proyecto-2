package testEmpleados;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import GaleriaEmpleados.Administrador;

import GaleriaGestionSesion.Artista;
import GaleriaGestionSesion.Comprador;
import GaleriaGestionSesion.Usuario;
import GaleriaModelo.Galeria;
import GaleriaModelo.Inventario;
import GaleriaPieza.Libro;
import GaleriaServiciosDeAdquisicion.Compra;
import GaleriaServiciosDeAdquisicion.Precio;

public class testAdministrador {

	@Test
	void verificarVenta() {
		Inventario inventario= new Inventario();
		//se inicia la galeria
		Galeria galeria= new Galeria(inventario);
		
		Usuario usuario = new Comprador("Mesi", "0126");
		usuario.definirCartera(5);
		Precio precio = new Precio();
	    precio.setPrecio(11);
		Libro libro = new Libro("monalisa", "2003", "Bogota", null, true, precio, true, false, 0, "Romantico");
		
		//definir compra
		Compra compra=new Compra(libro, 4, usuario);
		
		// Simular la entrada del usuario
	    InputStream sysInBackup = System.in; // Copia de seguridad del flujo de entrada estándar
	    ByteArrayInputStream in = new ByteArrayInputStream((1+ System.lineSeparator() + 1 + System.lineSeparator() + 1 + System.lineSeparator()+ 2 + System.lineSeparator()).getBytes());
	    System.setIn(in); // Redirigir System.in al ByteArrayInputStream


	     
	    
		//se le introducen los 3 empleados de cada dominacion con su usuario
		
		Usuario administrador= new Administrador("Administrador", "123");
		galeria.aniadirUsuarioEmpleado(administrador);
		((Administrador)administrador).aniadirVentasAVerificar(compra);
		
		((Administrador)administrador).verificarVenta(galeria, usuario);
		
		Assertions.assertEquals(libro.getTitulo(), usuario.getListaAdquisiciones().get(0).getTitulo(), "La venta verificada no mando la pieza al usuario comprador");
	}
	
	
	//añadir pieza para compras 
	@Test
	void validarAniadirPiezaParaCompra() {
		Inventario inventario= new Inventario();
		//se inicia la galeria
		Galeria galeria= new Galeria(inventario);
		Usuario artista=new Artista("ronaldo", "0126"); 
	
		Precio precio = new Precio();
	    precio.setPrecio(11);
		Libro libro = new Libro("monalisa", "2003", "Bogota", (Artista)artista, true, precio, false, false, 0, "Romantico");
		
		
		// Simular la entrada del usuario
	    InputStream sysInBackup = System.in; // Copia de seguridad del flujo de entrada estándar
	    ByteArrayInputStream in = new ByteArrayInputStream((1+ System.lineSeparator() + 1 + System.lineSeparator() + 1 + System.lineSeparator()+ 2 + System.lineSeparator()).getBytes());
	    System.setIn(in); // Redirigir System.in al ByteArrayInputStream
	    
	    Usuario administrador= new Administrador("Administrador", "123");
		galeria.aniadirUsuarioEmpleado(administrador);
		
		((Administrador)administrador).SolicitudAnadirPieza(libro);
		
		((Administrador)administrador).validarAniadirPieza(galeria);
		
	
		Assertions.assertEquals(libro.getTitulo(),  galeria.getInventario().getPiezas().get(0).getTitulo(), "pieza verifica y no fue mandada al inventario");
		

	}
	
	@Test
	void historiaComprador() {
		Inventario inventario= new Inventario();
		//se inicia la galeria
		Galeria galeria= new Galeria(inventario);
		Usuario artista=new Artista("ronaldo", "0126"); 
	
		Precio precio = new Precio();
	    precio.setPrecio(11);
		Libro libro = new Libro("monalisa", "2003", "Bogota", (Artista)artista, true, precio, false, false, 0, "Romantico");
		
		
		// Simular la entrada del usuario
	    InputStream sysInBackup = System.in; // Copia de seguridad del flujo de entrada estándar
	    ByteArrayInputStream in = new ByteArrayInputStream(("ronaldo"+ System.lineSeparator()).getBytes());
	    System.setIn(in); // Redirigir System.in al ByteArrayInputStream
	    
	    
	    Usuario administrador= new Administrador("Administrador", "123");
		galeria.aniadirUsuarioEmpleado(administrador);
		
	
	    
	    artista.anadirAdquisicion(libro);
	    
	    galeria.aniadirUsuario(artista);
	    
	    ((Administrador)administrador).historiaComprador(galeria);
	    
	    
	}
	
	@Test
	void historiaCompradorNoExiste() {
		Inventario inventario= new Inventario();
		//se inicia la galeria
		Galeria galeria= new Galeria(inventario);
		Usuario artista=new Artista("ronaldo", "0126"); 
	
		Precio precio = new Precio();
	    precio.setPrecio(11);
		Libro libro = new Libro("monalisa", "2003", "Bogota", (Artista)artista, true, precio, false, false, 0, "Romantico");
		
		
		// Simular la entrada del usuario
	    InputStream sysInBackup = System.in; // Copia de seguridad del flujo de entrada estándar
	    ByteArrayInputStream in = new ByteArrayInputStream(("nadie"+ System.lineSeparator()).getBytes());
	    System.setIn(in); // Redirigir System.in al ByteArrayInputStream
	    
	    
	    Usuario administrador= new Administrador("Administrador", "123");
		galeria.aniadirUsuarioEmpleado(administrador);
		
	
	    
	    artista.anadirAdquisicion(libro);
	    
	    galeria.aniadirUsuario(artista);
	    
	    ((Administrador)administrador).historiaComprador(galeria);
	    
	}
}
