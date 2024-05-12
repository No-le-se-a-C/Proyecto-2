package testModelop;

import static org.junit.jupiter.api.Assertions.*;


import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import GaleriaEmpleados.Administrador;
import GaleriaEmpleados.Cajero;
import GaleriaEmpleados.Operador;
import GaleriaGestionSesion.Artista;
import GaleriaGestionSesion.Comprador;
import GaleriaGestionSesion.Usuario;
import GaleriaModelo.Galeria;
import GaleriaModelo.Inventario;
import GaleriaPieza.Libro;
import GaleriaServiciosDeAdquisicion.Precio;
import GaleriaServiciosDeAdquisicion.Subasta;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
public class testInventario {
private Galeria galeria;
	
	
	@BeforeEach
	void before() {
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
	}
	
	@Test
	// se añade una pieza para venta
	void testAnadirPiezaParaVenta() {
		String tituloPieza = "monalisa"; // El título de la pieza en la subasta existente
	    int oferta = 12; // Una oferta válida que supere el precio actual

	    // Simular la entrada del usuario
	    InputStream sysInBackup = System.in; // Copia de seguridad del flujo de entrada estándar
	    ByteArrayInputStream in = new ByteArrayInputStream((tituloPieza+ System.lineSeparator() + "2003" + System.lineSeparator() 
	    													+ "Bogota" + System.lineSeparator()+ 1 + System.lineSeparator()
	    													+ 10 + System.lineSeparator()+ 3 + System.lineSeparator()
	    													+ "Romantico" + System.lineSeparator()).getBytes());
	    System.setIn(in); // Redirigir System.in al ByteArrayInputStream

	    // Crear la galería y realizar otras configuraciones
	    Inventario inventario = new Inventario();
	    Galeria galeria = new Galeria(inventario);

	    // Se introducen los 3 empleados de cada dominación con su usuario
	    Usuario administrador = new Administrador("Administrador", "123");
	    Usuario operador = new Operador("Operador", "123");
	    Usuario cajero = new Cajero("Cajero", "123");
	    galeria.aniadirUsuarioEmpleado(cajero);
	    galeria.aniadirUsuarioEmpleado(administrador);
	    galeria.aniadirUsuarioEmpleado(operador);

	    // Se crea un usuario
	    Usuario usuario = new Artista("Mesi", "0126");
	    //definir libro que se espera
	    Precio precio = new Precio();
	    precio.setPrecio(10);
	    Libro libro = new Libro("monalisa", "2003", "Bogota", (Artista)usuario, true, precio, false, false, 0, "Romantico");
	    
	    // Ejecutar el método participarSubasta
	    galeria.getInventario().aniadirPieza(galeria, usuario);;

	    // Verificar que la oferta se agregó correctamente
	    Assertions.assertEquals(libro.getTitulo(), ((Administrador)administrador).getPiezasPorAnadir().get(0).getTitulo() , "No se mando la Pieza correctamente");

	    // Restaurar System.in
	    System.setIn(sysInBackup);
	}
	
	@Test
	// se añade una pieza para subasta
	void testAnadirPiezaParaSubasta() {
		String tituloPieza = "monalisa"; // El título de la pieza en la subasta existente
	    int oferta = 12; // Una oferta válida que supere el precio actual

	    // Simular la entrada del usuario
	    InputStream sysInBackup = System.in; // Copia de seguridad del flujo de entrada estándar
	    ByteArrayInputStream in = new ByteArrayInputStream((tituloPieza+ System.lineSeparator() + "2003" + System.lineSeparator() 
	    													+ "Bogota" + System.lineSeparator()+ 2 + System.lineSeparator()
	    													+ 10 + System.lineSeparator() + 12 + System.lineSeparator() + 3 + System.lineSeparator()
	    													+ "Romantico" + System.lineSeparator()).getBytes());
	    System.setIn(in); // Redirigir System.in al ByteArrayInputStream

	    // Crear la galería y realizar otras configuraciones
	    Inventario inventario = new Inventario();
	    Galeria galeria = new Galeria(inventario);

	    // Se introducen los 3 empleados de cada dominación con su usuario
	    Usuario administrador = new Administrador("Administrador", "123");
	    Usuario operador = new Operador("Operador", "123");
	    Usuario cajero = new Cajero("Cajero", "123");
	    galeria.aniadirUsuarioEmpleado(cajero);
	    galeria.aniadirUsuarioEmpleado(administrador);
	    galeria.aniadirUsuarioEmpleado(operador);

	    // Se crea un usuario
	    Usuario usuario = new Artista("Mesi", "0126");
	    //definir libro que se espera
	    Precio precio = new Precio();
	    precio.setPrecio(10);
	    Libro libro = new Libro("monalisa", "2003", "Bogota", (Artista)usuario, true, precio, true, false, 0, "Romantico");
	    
	    // Ejecutar el método participarSubasta
	    galeria.getInventario().aniadirPieza(galeria, usuario);;

	    // Verificar que la oferta se agregó correctamente
	    Assertions.assertEquals(libro.getTitulo(), ((Administrador)administrador).getPiezasPorAnadir().get(0).getTitulo() , "No se mando la Pieza correctamente");
	    Assertions.assertEquals(libro.isSubasta(), ((Administrador)administrador).getPiezasPorAnadir().get(0).isSubasta() , "la pieza fue mandada pero no es subasta y debe serlo");

	    // Restaurar System.in
	    System.setIn(sysInBackup);
	}
	
}
