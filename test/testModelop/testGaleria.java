package testModelop;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.Test;

import GaleriaEmpleados.Administrador;
import GaleriaEmpleados.Cajero;
import GaleriaEmpleados.Operador;
import GaleriaGestionSesion.Comprador;
import GaleriaGestionSesion.Usuario;
import GaleriaModelo.Galeria;
import GaleriaModelo.Inventario;

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
	
	@Test
	void testParticiparSubasta() {
		Usuario usuario=new Comprador("Mesi", "0126");
		
		galeria.participarSubasta(galeria, usuario);
	}

}
