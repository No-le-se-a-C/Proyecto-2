package testGestionDeSesion;
import static org.junit.Assert.assertTrue;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import GaleriaEmpleados.Administrador;
import GaleriaEmpleados.Cajero;
import GaleriaEmpleados.Operador;
import GaleriaGestionSesion.Comprador;
import GaleriaGestionSesion.Sesion;
import GaleriaGestionSesion.Usuario;
import GaleriaModelo.Galeria;
import GaleriaModelo.Inventario;
import GaleriaPieza.Libro;
import GaleriaServiciosDeAdquisicion.Precio;
import GaleriaServiciosDeAdquisicion.Subasta;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
public class testSesion {
	
	// registro de un comprador
	@Test
	void testRegistrarseComprador() {
		Comprador comprador=new Comprador("messi", "0126");
		  // Simular la entrada del usuario
	    InputStream sysInBackup = System.in; // Copia de seguridad del flujo de entrada estándar
	    ByteArrayInputStream in = new ByteArrayInputStream((1+ System.lineSeparator() + "messi" + System.lineSeparator() + "0126" + System.lineSeparator()).getBytes());
	    System.setIn(in); // Redirigir System.in al ByteArrayInputStream

	    // Crear la galería y realizar otras configuraciones
	    Inventario inventario = new Inventario();
	    Galeria galeria = new Galeria(inventario);
 
	    
	    Sesion sesion= new Sesion();
	    
	    sesion.registrarse(galeria);
	    
	    assertTrue("no se añadio el usuario.",
                galeria.getListaUsuariuos().containsKey("messi"));
	}

	//registro de un artista
	@Test
	void testRegistrarseArtista() {
		Comprador comprador=new Comprador("messi", "0126");
		  // Simular la entrada del usuario
	    InputStream sysInBackup = System.in; // Copia de seguridad del flujo de entrada estándar
	    ByteArrayInputStream in = new ByteArrayInputStream((2+ System.lineSeparator() + "messi" + System.lineSeparator() + "0126" + System.lineSeparator()).getBytes());
	    System.setIn(in); // Redirigir System.in al ByteArrayInputStream
	
	    // Crear la galería y realizar otras configuraciones
	    Inventario inventario = new Inventario();
	    Galeria galeria = new Galeria(inventario);
	
	    
	    Sesion sesion= new Sesion();
	    
	    sesion.registrarse(galeria);
	    
	    assertTrue("no se añadio el usuario.",
	            galeria.getListaUsuariuos().containsKey("messi"));
	}
	
	//se revisa si al querer iniciar sesion con un usuario existente permite iniciar otra sesion
	@Test
	void testRegistrarseUsuarioExitente() {
		Comprador comprador=new Comprador("messi", "0126");
		  // Simular la entrada del usuario
	    InputStream sysInBackup = System.in; // Copia de seguridad del flujo de entrada estándar
	    ByteArrayInputStream in = new ByteArrayInputStream((1+ System.lineSeparator() + "messi" + System.lineSeparator() + 1 + System.lineSeparator()+ "Ronaldo" + System.lineSeparator()+ "0126" + System.lineSeparator()).getBytes());
	    System.setIn(in); // Redirigir System.in al ByteArrayInputStream

	    // Crear la galería y realizar otras configuraciones
	    Inventario inventario = new Inventario();
	    Galeria galeria = new Galeria(inventario);
	    galeria.aniadirUsuario(comprador);
	    
	    Sesion sesion= new Sesion();
	    
	    sesion.registrarse(galeria);
	    
	    assertTrue("El usuario existente no dejo iniciar sesión",
                galeria.getListaUsuariuos().containsKey("Ronaldo"));
	}
	//se revisa si se puede iniciar sesion de un usuario ya registrado
	@Test
	void testIniciarSesionUsuario(){
		
		  // Simular la entrada del usuario
	    InputStream sysInBackup = System.in; // Copia de seguridad del flujo de entrada estándar
	    ByteArrayInputStream in = new ByteArrayInputStream((1+ System.lineSeparator() + "Administrador" + System.lineSeparator() + "123" + System.lineSeparator()).getBytes());
	    System.setIn(in); // Redirigir System.in al ByteArrayInputStream

	    // Crear la galería y realizar otras configuraciones
	    Inventario inventario = new Inventario();
	    Galeria galeria = new Galeria(inventario);
	    //se añade administrador
	    Usuario administrador= new Administrador("Administrador", "123");
		
	    galeria.aniadirUsuarioEmpleado(administrador);
	    
	    Sesion sesion= new Sesion();
	    
	    sesion.iniciarSesion(galeria);
	}
	//se reevisa que suced al ingresar con una contraseña incorrecta
	@Test
	void testIniciarSesionUsuarioContraseña(){
		Comprador comprador=new Comprador("messi", "0126");
		  // Simular la entrada del usuario
	    InputStream sysInBackup = System.in; // Copia de seguridad del flujo de entrada estándar
	    ByteArrayInputStream in = new ByteArrayInputStream((2+ System.lineSeparator() + "messi" + System.lineSeparator() + "123" + System.lineSeparator()+
	    													2 + System.lineSeparator()+ "messi" + System.lineSeparator()+ "0126" + System.lineSeparator()).getBytes());
	    System.setIn(in); // Redirigir System.in al ByteArrayInputStream

	    // Crear la galería y realizar otras configuraciones
	    Inventario inventario = new Inventario();
	    Galeria galeria = new Galeria(inventario);
	
	    //se añade usuario
	    galeria.aniadirUsuario(comprador);
	   
	    Sesion sesion= new Sesion();
	    
	    sesion.iniciarSesion(galeria);
	}
	
	//se revisa que sucede al querer ingresar con un usuario no existente
	@Test
	void testIniciarSesionUsuarioNoExistente(){

		  // Simular la entrada del usuario
	    InputStream sysInBackup = System.in; // Copia de seguridad del flujo de entrada estándar
	    ByteArrayInputStream in = new ByteArrayInputStream((2+ System.lineSeparator() + "messi" 
	    													+ System.lineSeparator() + "123" + System.lineSeparator()+ "no" + System.lineSeparator()+ 3 + System.lineSeparator()).getBytes());
	    System.setIn(in); // Redirigir System.in al ByteArrayInputStream

	    // Crear la galería y realizar otras configuraciones
	    Inventario inventario = new Inventario();
	    Galeria galeria = new Galeria(inventario);
	
	   
	    Sesion sesion= new Sesion();
	    
	    sesion.iniciarSesion(galeria);
	   
	}
}
