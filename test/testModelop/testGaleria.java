package testModelop;

import static org.junit.jupiter.api.Assertions.*;




import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import GaleriaEmpleados.Administrador;
import GaleriaEmpleados.Cajero;
import GaleriaEmpleados.Operador;
import GaleriaGestionSesion.Comprador;
import GaleriaGestionSesion.Usuario;
import GaleriaModelo.Galeria;
import GaleriaModelo.Inventario;
import GaleriaPieza.Libro;
import GaleriaServiciosDeAdquisicion.Precio;
import GaleriaServiciosDeAdquisicion.Subasta;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;

class testGaleria {
	
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
	//test para ver si sl participar en una subasta el usuario 
	@Test
	void testParticiparSubasta() {
		  // Configurar la entrada simulada del usuario
	    String tituloPieza = "monalisa"; // El título de la pieza en la subasta existente
	    int oferta = 12; // Una oferta válida que supere el precio actual

	    // Simular la entrada del usuario
	    InputStream sysInBackup = System.in; // Copia de seguridad del flujo de entrada estándar
	    ByteArrayInputStream in = new ByteArrayInputStream((1+ System.lineSeparator() + tituloPieza + System.lineSeparator() + oferta+ System.lineSeparator()).getBytes());
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
	    
	    // Se agrega una subasta a la galería
	    Precio precio = new Precio();
	    precio.setPrecio(11);
	    Libro libro = new Libro("monalisa", "2003", "Bogota", null, true, precio, true, false, 0, "Romantico");
	    LocalDate diaFinal = LocalDate.of(2025, 5, 10);
	    Subasta subasta = new Subasta(libro, diaFinal);
	    galeria.aniadirSubasta(subasta);

	    // Se crea un usuario
	    Usuario usuario = new Comprador("Mesi", "0126");

	    // Ejecutar el método participarSubasta
	    galeria.participarSubasta(galeria, usuario);

	    // Verificar que la oferta se agregó correctamente
	    Assertions.assertEquals(oferta, galeria.getSubastasProgramadas().get(0).getPieza().getPrecio().getPrecio(), "Oferta de la subasta no fue actualizada");

	    // Restaurar System.in
	    System.setIn(sysInBackup);
	}
	
	//test para participar en una subasta que no existe
	@Test
	void testParticiparSubastaPiezaNO() {
		  // Configurar la entrada simulada del usuario
	    String tituloPieza = "monalisa"; // El título de la pieza en la subasta existente
	    int oferta = 12; // Una oferta válida que supere el precio actual

	    // Simular la entrada del usuario
	    InputStream sysInBackup = System.in; // Copia de seguridad del flujo de entrada estándar
	    ByteArrayInputStream in = new ByteArrayInputStream((1+ System.lineSeparator() + "" + System.lineSeparator() + 2 + System.lineSeparator()).getBytes());
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
	    
	    // Se agrega una subasta a la galería
	    Precio precio = new Precio();
	    precio.setPrecio(11);
	    Libro libro = new Libro("monalisa", "2003", "Bogota", null, true, precio, true, false, 0, "Romantico");
	    LocalDate diaFinal = LocalDate.of(2025, 5, 10);
	    Subasta subasta = new Subasta(libro, diaFinal);
	    galeria.aniadirSubasta(subasta);

	    // Se crea un usuario
	    Usuario usuario = new Comprador("Mesi", "0126");

	    // Ejecutar el método participarSubasta
	    galeria.participarSubasta(galeria, usuario);

	    // Verificar que la oferta se agregó correctamente
	    Assertions.assertEquals(11, galeria.getSubastasProgramadas().get(0).getPieza().getPrecio().getPrecio(), "Oferta fue actualizada y no debe serlo");

	    // Restaurar System.in
	    System.setIn(sysInBackup);
	}
	
	//test para participar en una subasta que ya acabo
	@Test
	void testParticiparSubastaTerminada() {
		// Configurar la entrada simulada del usuario
		String tituloPieza = "monalisa"; // El título de la pieza en la subasta existente
		int oferta = 12; // Una oferta válida que supere el precio actual

		// Simular la entrada del usuario
		InputStream sysInBackup = System.in; // Copia de seguridad del flujo de entrada estándar
		ByteArrayInputStream in = new ByteArrayInputStream((1+ System.lineSeparator() + "monalisa" + System.lineSeparator() + 2 + System.lineSeparator()).getBytes());
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

		// Se agrega una subasta a la galería
		Precio precio = new Precio();
		precio.setPrecio(11);
		Libro libro = new Libro("monalisa", "2003", "Bogota", null, true, precio, true, false, 0, "Romantico");
		LocalDate diaFinal = LocalDate.of(2024, 4, 10);
		Subasta subasta = new Subasta(libro, diaFinal);
		galeria.aniadirSubasta(subasta);

		// Se crea un usuario
		Usuario usuario = new Comprador("Mesi", "0126");

		// Ejecutar el método participarSubasta
		galeria.participarSubasta(galeria, usuario);

		// Verificar que la oferta se agregó correctamente
		Assertions.assertEquals(11, galeria.getSubastasProgramadas().get(0).getPieza().getPrecio().getPrecio(), "Oferta fue actualizada y no debe serlo");

		// Restaurar System.in
		System.setIn(sysInBackup);
	}
	
	@Test
	// mirar si lacompra se manda a verificacion de ventas
	void testcomprarPieza() {
		String tituloPieza = "monalisa"; // El título de la pieza en la subasta existente
		

		// Simular la entrada del usuario
		InputStream sysInBackup = System.in; // Copia de seguridad del flujo de entrada estándar
		ByteArrayInputStream in = new ByteArrayInputStream((1+ System.lineSeparator() + tituloPieza + System.lineSeparator() + 1 + System.lineSeparator()).getBytes());
		System.setIn(in); // Redirigir System.in al ByteArrayInputStream
		
		
		
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
		//usuario Comprador
		Usuario usuario = new Comprador("Mesi", "0126");
		usuario.definirCartera(30);
		
		Precio precio = new Precio();
	    precio.setPrecio(11);
	    Libro libro = new Libro("monalisa", "2003", "Bogota", null, false, precio, false, false, 0, "Romantico");
	    galeria.getInventario().anadirPiezaVerificada(libro, galeria);
		galeria.comprarPieza(galeria, usuario);
		
		Assertions.assertEquals(libro, ((Administrador) administrador).getVentasAVerificar().get(0).getPieza(), "No se Hizo la compra o no fue mandada la solicitud");
	}
	
	@Test
	// comprar pieza inexsistente
	void testcomprarPiezaNO() {
		String tituloPieza = "monalisa"; // El título de la pieza en la subasta existente
		

		// Simular la entrada del usuario
		InputStream sysInBackup = System.in; // Copia de seguridad del flujo de entrada estándar
		ByteArrayInputStream in = new ByteArrayInputStream((1+ System.lineSeparator() + "" + System.lineSeparator() + 1 + System.lineSeparator()).getBytes());
		System.setIn(in); // Redirigir System.in al ByteArrayInputStream
		
		
		
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
		//usuario Comprador
		Usuario usuario = new Comprador("Mesi", "0126");
		usuario.definirCartera(30);
		
		Precio precio = new Precio();
	    precio.setPrecio(11);
	    Libro libro = new Libro("monalisa", "2003", "Bogota", null, false, precio, false, false, 0, "Romantico");
	    galeria.getInventario().anadirPiezaVerificada(libro, galeria);
		galeria.comprarPieza(galeria, usuario);
		
		Assertions.assertEquals(true, ((Administrador) administrador).getVentasAVerificar().isEmpty(), "se hizo una compra de algo inexistente");
	}
	
	@Test
	// comprar pieza si poder pagarla por los recursos del usuario
	void testcomprarPiezaSnRecusrsos() {
		String tituloPieza = "monalisa"; // El título de la pieza en la subasta existente
		

		// Simular la entrada del usuario
		InputStream sysInBackup = System.in; // Copia de seguridad del flujo de entrada estándar
		ByteArrayInputStream in = new ByteArrayInputStream((1+ System.lineSeparator() + "" + System.lineSeparator() + 1 + System.lineSeparator()).getBytes());
		System.setIn(in); // Redirigir System.in al ByteArrayInputStream
		
		
		
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
		//usuario Comprador
		Usuario usuario = new Comprador("Mesi", "0126");
		usuario.definirCartera(5);
		
		Precio precio = new Precio();
	    precio.setPrecio(11);
	    Libro libro = new Libro("monalisa", "2003", "Bogota", null, false, precio, false, false, 0, "Romantico");
	    galeria.getInventario().anadirPiezaVerificada(libro, galeria);
		galeria.comprarPieza(galeria, usuario);
		
		Assertions.assertEquals(true, ((Administrador) administrador).getVentasAVerificar().isEmpty(), "se vendio la pieza a un usuario sin tener los suficientes recursos");
	}

}
