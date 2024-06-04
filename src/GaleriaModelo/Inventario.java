package GaleriaModelo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

//import com.google.gson.Gson;
import GaleriaEmpleados.Administrador;
import GaleriaGestionSesion.Artista;
import GaleriaGestionSesion.Usuario;
import GaleriaPieza.Escultura;
import GaleriaPieza.EsculturaPersistencia;
import GaleriaPieza.Fotografia;
import GaleriaPieza.FotografiaPersistencia;
import GaleriaPieza.Libro;
import GaleriaPieza.LibroPersistencia;
import GaleriaPieza.Pieza;
import GaleriaPieza.Pintura;
import GaleriaPieza.PinturaPersistencia;
import GaleriaPieza.Video;
import GaleriaPieza.VideoPersistencia;
import GaleriaServiciosDeAdquisicion.Precio;
import GaleriaServiciosDeAdquisicion.Subasta;

public class Inventario {
	
	private ArrayList<Pieza> piezas;
	private ArrayList<Pieza> infoPiezasAntiguas; 
	
	public Inventario() {
		piezas= new ArrayList<Pieza>();
		infoPiezasAntiguas= new ArrayList<Pieza>();
	}
	
	
	public void anadirPiezaInfoAntigua(Pieza pieza) {
		infoPiezasAntiguas.add(pieza);
	}
	
	public void eliminarpiezaVendida(Pieza pieza) {
		piezas.remove(pieza);
		
	}
	public void buscarPieza(String nTitulo, Artista nAutor) {
		
		Pieza piezaEncontrada= null;
		
		for (Pieza pieza : piezas) {
			//se verifica que pieza coincide con el titulo y el usuario del autor
			if(pieza.getTitulo().equalsIgnoreCase(nTitulo) && pieza.getAutor().getUsuario().equalsIgnoreCase(nAutor.getUsuario())) {
				piezaEncontrada=pieza;
			}
			
		}
		//imprime las caracteristicas de la pieza si la encuentra
		if(piezaEncontrada==null) {
			System.out.println("No se encontro la pieza, verifique que lo datos esten bien");
		}else {
			piezaEncontrada.getCaracteristicas();
		}
	
	}
	
	public Pieza buscarPieza(String titulo) {
		Pieza piezaEncontrada= null;

		for (Pieza pieza : piezas) {
			//se verifica que pieza coincide con el titulo 
			if(pieza.getTitulo().equalsIgnoreCase(titulo)) {
				piezaEncontrada=pieza;
			}
		}
		return piezaEncontrada;
	}
	
	// Hace referencia a las piezas que ya se vendieron sale de infoPiezasAntiguas
	public void buscarInfoPiezaAntigua(String nTitulo, Artista nAutor) {
		
		Pieza piezaEncontrada= null;
		
		for (Pieza pieza : infoPiezasAntiguas) {
			//se verifica que pieza coincide con el titulo y el usuario del autor
			if(pieza.getTitulo().equalsIgnoreCase(nTitulo) && pieza.getAutor().getUsuario().equalsIgnoreCase(nAutor.getUsuario())) {
				piezaEncontrada=pieza;
			}
			
		}
		//imprime las caracteristicas de la pieza si la encuentra
		if(piezaEncontrada==null) {
			System.out.println("No se encontro la pieza, verifique que lo datos esten bien");
		}else {
			piezaEncontrada.getCaracteristicasAntiguas();
		}
	}

	public void getPiezasPrecioFijo() {
		boolean hayPiezas=false;
		
		if(piezas.isEmpty()) {
			System.out.println("No hay piezas disponibles por el momento");
		}else {
			for (Pieza pieza : piezas) {
				//buscar piezas que no son subasta
				if (!pieza.isSubasta()) {
				//verificar que hay almenos 1 pieza de precio fijo 	
				hayPiezas=true;
				//imprimir titulo y autor
				System.out.println("Titulo: "+pieza.getTitulo()+"---Autor: "+pieza.getAutor().getUsuario()+ "---precio: "+ pieza.getPrecio().getPrecio());
				}
			}
		}
		//si no hay piezas mencionarlo al usuario
		if (!hayPiezas && !piezas.isEmpty()) {
			System.out.println("No se encontraron piezas para venta");
		}
	}
	
	public void getinfoPiezasSubasta() {
		boolean hayPiezas=false;
		
		if(piezas.isEmpty()) {
			System.out.println("No hay piezas disponibles por el momento");
		}else {
			for (Pieza pieza : piezas) {
				//buscar piezas que son subasta
				if (pieza.isSubasta()) {
					//verificar que hay almenos 1 pieza de precio fijo 	
					hayPiezas=true;
					//imprimir titulo y autor
					System.out.println("Titulo: "+pieza.getTitulo()+"---Autor: "+pieza.getAutor().getUsuario()
							+"---precio actual: "+ pieza.getPrecio().getPrecio() );
				}
			}
		}
		//si no hay piezas mencionarlo al usuario
		if (!hayPiezas && !piezas.isEmpty()) {
			System.out.println("No se encontraron piezas para subasta");
		}
		
	}


	
	public ArrayList<Pieza> getPiezas() {
		return piezas;
	}

	public ArrayList<Pieza> getInfoPiezasAntiguas() {
		return infoPiezasAntiguas;
	}

	public void aniadirPieza(Galeria galeria, Usuario usuario, String[] ValoresPieza, boolean subasta) {
		Pieza pieza=null;

		Random random = new Random();
		
		String tipoPieza= ValoresPieza[0];
		Precio precio= new Precio();
		int precioMinimo=0;
		
		String titulo=ValoresPieza[1];
		String anioCreacion=ValoresPieza[2];
		String lugarCreacion=ValoresPieza[3];
		
		precioMinimo+=Integer.parseInt(ValoresPieza[7]);
		 
		precio.setPrecio(Integer.parseInt(ValoresPieza[8]));

		if (tipoPieza=="escultura") {
			
	
			String ancho=ValoresPieza[4];
		
			String alto=ValoresPieza[5];
		
			String material=ValoresPieza[6];
			
			
			pieza=new Escultura(titulo, anioCreacion, lugarCreacion, 
					(Artista) usuario, true, precio, subasta, 
					random.nextBoolean(), precioMinimo, material, alto, ancho);
		

	
		}else if(tipoPieza=="fotografia") {
			
			String filtro=ValoresPieza[4];
			
			String cantidadPixeles=ValoresPieza[5];
			
			String calidad=ValoresPieza[6];
			
			
			pieza=new Fotografia(titulo, anioCreacion, lugarCreacion, 
					(Artista) usuario, true, precio, subasta, 
					random.nextBoolean(), precioMinimo, filtro, cantidadPixeles, calidad);
		
			
		}else if(tipoPieza=="libro") {
			
			String genero=ValoresPieza[4];
			pieza= new Libro(titulo, anioCreacion, lugarCreacion, 
					(Artista) usuario, true, precio, subasta, 
					random.nextBoolean(), precioMinimo, genero);
			
			
		}else if(tipoPieza=="pintura") {
			
			String alto=ValoresPieza[4];
		
			String ancho=ValoresPieza[5];
			
			String estilo=ValoresPieza[6];
			
		
			pieza=new Pintura(titulo, anioCreacion, lugarCreacion, 
					(Artista) usuario, true, precio, subasta, 
					random.nextBoolean(), precioMinimo, alto, ancho, estilo);
		
		}else if(tipoPieza=="video") {

			String duracion=ValoresPieza[4];
			
			String formato=ValoresPieza[5];
			
			String estilo=ValoresPieza[6];
			
	
			pieza= new Video(titulo, anioCreacion, lugarCreacion, 
					(Artista) usuario, true, precio, subasta, 
					random.nextBoolean(), precioMinimo, duracion, formato, estilo);
			

		}
		
		
		Administrador admin=(Administrador) galeria.getMapaUsuariosEmpleados().get("Administrador");
		
		admin.SolicitudAnadirPieza(pieza);
	}
	

	public void anadirPiezaVerificada(Pieza pieza, Galeria galeria, int mes, int dia) {
		
		LocalDate fechaFin=null;

		fechaFin= LocalDate.of(2024, mes, dia);

		Subasta subasta= new Subasta(pieza, fechaFin);
		galeria.aniadirSubasta(subasta);

	}
	
}
