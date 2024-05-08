package GaleriaModelo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
//import com.google.gson.Gson;
import GaleriaEmpleados.Administrador;
import GaleriaGestionSesion.Artista;
import GaleriaGestionSesion.Usuario;
import GaleriaPieza.Escultura;
import GaleriaPieza.Fotografia;
import GaleriaPieza.Libro;
import GaleriaPieza.Pieza;
import GaleriaPieza.Pintura;
import GaleriaPieza.Video;
import GaleriaServiciosDeAdquisicion.Subasta;

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
				System.out.println("Titulo: "+pieza.getTitulo()+"---Autor: "+pieza.getAutor().getUsuario()+ "---precio: "+ pieza.getPrecio()[0]);
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
							+"---precio actual: "+ pieza.getPrecio()[0] );
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
		Pieza pieza=null;
		Scanner scanner=new Scanner(System.in);
		Random random = new Random();
		
		System.out.println("//////////////////////////////////////////////");
		System.out.println("Añadir pieza");
		System.out.println("");
		System.out.println("Como se llama su pieza:");
		String titulo=scanner.nextLine();
		System.out.println("En que año fue creada:");
		String anioCreacion=scanner.nextLine();
		System.out.println("En que lugar fue creada:");
		String lugarCreacion=scanner.nextLine();
		
		boolean seguir=true;
		boolean subasta=false;
		Object[] precio= new Object[2];
		int precioMinimo=0;
		
		while(seguir) {
			System.out.println("Quiere que sea vendida(1) o subastada(2) (responda 1 o 2):");
			int input= scanner.nextInt();
			scanner.nextLine();
			if (input==1) {
				subasta=false;
				System.out.println("en cuanto quiere vender su pieza:");
				int input2=scanner.nextInt();
				scanner.nextLine();
				precio[0]=input2;
				precio[1]=null;
				seguir=false;
			}else if(input==2) {
				subasta=true;
				System.out.println("en cuanto quiere que empiece el precio de su pieza:");
				int input2=scanner.nextInt();
				scanner.nextLine();
				precio[0]=input2;
				precio[1]=null;
				System.out.println("cual quiere que sea el valor minimo para que se entregue:");
				precioMinimo=scanner.nextInt();
				scanner.nextLine();
				seguir=false;
			}else {
				System.out.println("Valor incorrecto");
				System.out.println("");
			} 
		}
		
		// preguntar que tipo de pieza quiere añadir para terminar es constructor de cada una
		boolean seguir1=true;
		
		while(seguir1) {
			System.out.println("que tipo de pieza es" );
			System.out.println("1. Escultura");
			System.out.println("2. fotografia");
			System.out.println("3. libro");
			System.out.println("4. pintura");
			System.out.println("5. video");
			System.out.println("Responda un numero del 1 al 5:");
			int input3 =scanner.nextInt();
			scanner.nextLine();
			if (input3==1) {
				System.out.println("que ancho tiene:");
				String ancho=scanner.nextLine();
				System.out.println("que alto tiene:");
				String alto=scanner.nextLine();
				System.out.println("que material tiene:");
				String material=scanner.nextLine();
				pieza=new Escultura(titulo, anioCreacion, lugarCreacion, 
						(Artista) usuario, true, precio, subasta, 
						random.nextBoolean(), precioMinimo, material, alto, ancho);
				seguir1=false;
			}else if(input3==2) {
				System.out.println("que filtro tiene:");
				String filtro=scanner.nextLine();
				System.out.println("que cantidad de pixeles tiene:");
				String cantidadPixeles=scanner.nextLine();
				System.out.println("que calidad tiene:");
				String calidad=scanner.nextLine();
				pieza=new Fotografia(titulo, anioCreacion, lugarCreacion, 
						(Artista) usuario, true, precio, subasta, 
						random.nextBoolean(), precioMinimo, filtro, cantidadPixeles, calidad);
				seguir1=false;
			}else if(input3==3) {
				System.out.println("que genero es:");
				String genero=scanner.nextLine();
				pieza= new Libro(titulo, anioCreacion, lugarCreacion, 
						(Artista) usuario, true, precio, subasta, 
						random.nextBoolean(), precioMinimo, genero);
				seguir1=false;
			}else if(input3==4) {
				System.out.println("que altura tiene:");
				String alto=scanner.nextLine();
				System.out.println("que ancho tiene:");
				String ancho=scanner.nextLine();
				System.out.println("que estilo tiene:");
				String estilo=scanner.nextLine();
				pieza=new Pintura(titulo, anioCreacion, lugarCreacion, 
						(Artista) usuario, true, precio, subasta, 
						random.nextBoolean(), precioMinimo, alto, ancho, estilo);
				seguir1=false;
			}else if(input3==5) {
				System.out.println("que duracion tiene:");
				String duracion=scanner.nextLine();
				System.out.println("que formato tiene:");
				String formato=scanner.nextLine();
				System.out.println("que estilo tiene:");
				String estilo=scanner.nextLine();
				pieza= new Video(titulo, anioCreacion, lugarCreacion, 
						(Artista) usuario, true, precio, subasta, 
						random.nextBoolean(), precioMinimo, duracion, formato, estilo);
				seguir1=false;
			}else {
				System.out.println("Valor incorrecto elija un numero de 1 al 5");
			} 
		}
		Administrador admin=(Administrador) galeria.getMapaUsuariosEmpleados().get("Administrador");
		
		admin.SolicitudAnadirPieza(pieza);
		System.out.println("La pieza fue diligenciada y se mando la solicitud para añadirla");
		System.out.println("si quiere revisar si fue añadida valla a la funcion 'mirar mi pieza' ");
		
		
		
		// Guardamos las piezas en archivos Json
		//Gson gson = new Gson();
	    //String jsonAdministrador = gson.toJson(pieza);
		
	
	}
	
	public void eliminarPieza(String nTitulo, Artista autor) {
		
	}
	public void anadirPiezaVerificada(Pieza pieza, Galeria galeria) {
		Scanner scanner= new Scanner(System.in);
		piezas.add(pieza);
		LocalDate fechaFin=null;
		if (pieza.isSubasta()) {
			System.out.println("/////////////////////////////");
			System.out.println("Ya que la pieza debe ser dada en subasta que fecha quiere que acabe esta");
			System.out.println("");
			boolean seguir=true;
			while (seguir) {
				System.out.println("----mes(1>=x<=12):");
				int mes=scanner.nextInt();
				scanner.nextLine();
				System.out.println("----dia(0>x<32):");
				int dia=scanner.nextInt();
				scanner.nextLine();
				
				if(13>mes && mes>0 && 0<dia && dia<32) {
					seguir=false;
					fechaFin= LocalDate.of(2024, mes, dia);
				}else {
					System.out.println();
				}

			}
			
			Subasta subasta= new Subasta(pieza, fechaFin);
			galeria.aniadirSubasta(subasta);

		}
	}
}
