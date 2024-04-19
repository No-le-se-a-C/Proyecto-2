package GaleriaModelo;

import java.util.ArrayList;
import java.util.Scanner;

import GaleriaGestionSesion.Artista;
import GaleriaGestionSesion.Usuario;
import GaleriaPieza.Pieza;

public class Inventario {
	
	private ArrayList<Pieza> piezas;
	private ArrayList<Pieza> infoPiezasAntiguas; 
	
	public Inventario() {
		piezas= new ArrayList<Pieza>();
		infoPiezasAntiguas= new ArrayList<Pieza>();
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
				System.out.println("Titulo: "+pieza.getTitulo()+"---Autor: "+pieza.getAutor().getUsuario());
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
				//buscar piezas que no son subasta
				if (pieza.isSubasta()) {
					//verificar que hay almenos 1 pieza de precio fijo 	
					hayPiezas=true;
					//imprimir titulo y autor
					System.out.println("Titulo: "+pieza.getTitulo()+"---Autor: "+pieza.getAutor().getUsuario());
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

	public void aniadirPieza(Galeria galeria, Usuario usuario) {
		/*String nTitulo, String nAnioCreacion, String nLugarCreacion, Artista nAutor, boolean nConsignacion, 
			int[] nPrecio, boolean nSubasta, boolean exhibido, int nPrecioMinimo
		 * */
		Scanner scanner=new Scanner(System.in);
		
		System.out.println("//////////////////////////////////////////////");
		System.out.println("Añadir pieza");
		System.out.println("");
		System.out.println("Como se llama su pieza:");
		String titulo=scanner.nextLine();
		System.out.println("En que año fue creada:");
		String anioCreacion=scanner.nextLine();
		System.out.println("En que lugar fue creada:");
		String lugarCreacion=scanner.nextLine();
		System.out.println("Quiere que sea vendida o subastada");
		
	}
	
	public void eliminarPieza(String nTitulo, Artista autor) {
		
	}
	
}
