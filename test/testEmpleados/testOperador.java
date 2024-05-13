package testEmpleados;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import GaleriaEmpleados.Administrador;
import GaleriaEmpleados.Cajero;
import GaleriaEmpleados.Operador;
import GaleriaGestionSesion.Usuario;
import GaleriaModelo.Galeria;
import GaleriaModelo.Inventario;
import GaleriaPieza.Libro;
import GaleriaServiciosDeAdquisicion.Precio;
import GaleriaServiciosDeAdquisicion.Subasta;

public class testOperador {
	
	//revisa si se puede ver el resistro de una subasta
	@Test
	void testLlevarRegistroSubasta() {
		// Crear la galería y realizar otras configuraciones
	    Inventario inventario = new Inventario();
	    Galeria galeria = new Galeria(inventario);
	    
	    InputStream sysInBackup = System.in; // Copia de seguridad del flujo de entrada estándar
	    ByteArrayInputStream in = new ByteArrayInputStream((1+ System.lineSeparator()+ 2 + System.lineSeparator()).getBytes());
	    System.setIn(in); // Redirigir System.in al ByteArrayInputStream


	    // Se introducen los 3 empleados de cada dominación con su usuario
	    Usuario administrador = new Administrador("Administrador", "123");
	    Usuario operador = new Operador("Operador", "123");
	    Usuario cajero = new Cajero("Cajero", "123");
	    galeria.aniadirUsuarioEmpleado(cajero);
	    galeria.aniadirUsuarioEmpleado(administrador);
	    galeria.aniadirUsuarioEmpleado(operador);
	    
	    LocalDate diaFinal = LocalDate.of(2025, 5, 10);
	    Precio precio = new Precio();
	    precio.setPrecio(11);
	    Libro libro = new Libro("monalisa", "2003", "Bogota", null, true, precio, true, false, 0, "Romantico");
	    Subasta subasta=new Subasta(libro, diaFinal);
	    
	    galeria.aniadirSubasta(subasta);
	    
	    ((Operador)operador).llevarResgistroSubasta(galeria, cajero);
	    
	}
	//revisa cuando hay mas de una subasta en la lista
	@Test
	void testLlevarRegistroSubastas() {
		// Crear la galería y realizar otras configuraciones
	    Inventario inventario = new Inventario();
	    Galeria galeria = new Galeria(inventario);
	    
	    InputStream sysInBackup = System.in; // Copia de seguridad del flujo de entrada estándar
	    ByteArrayInputStream in = new ByteArrayInputStream((1+ System.lineSeparator()+ 1 + System.lineSeparator()+ 2 + System.lineSeparator()).getBytes());
	    System.setIn(in); // Redirigir System.in al ByteArrayInputStream


	    // Se introducen los 3 empleados de cada dominación con su usuario
	    Usuario administrador = new Administrador("Administrador", "123");
	    Usuario operador = new Operador("Operador", "123");
	    Usuario cajero = new Cajero("Cajero", "123");
	    galeria.aniadirUsuarioEmpleado(cajero);
	    galeria.aniadirUsuarioEmpleado(administrador);
	    galeria.aniadirUsuarioEmpleado(operador);
	    
	    LocalDate diaFinal = LocalDate.of(2025, 5, 10);
	    Precio precio = new Precio();
	    precio.setPrecio(11);
	    Libro libro = new Libro("monalisa", "2003", "Bogota", null, true, precio, true, false, 0, "Romantico");
	    Libro libro1 = new Libro("It", "2003", "Soacha", null, true, precio, true, false, 0, "Terror");
	    Subasta subasta=new Subasta(libro, diaFinal);
	    Subasta subasta1=new Subasta(libro1, diaFinal);
	    
	    galeria.aniadirSubasta(subasta1);
	    galeria.aniadirSubasta(subasta);
	    
	    ((Operador)operador).llevarResgistroSubasta(galeria, cajero);
	    
	}
}
