package GaleriaModelo;

import java.time.LocalDate;
import java.time.chrono.ChronoLocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import GaleriaEmpleados.Administrador;
import GaleriaGestionSesion.Artista;
import GaleriaGestionSesion.Usuario;
import GaleriaPieza.Pieza;
import GaleriaServiciosDeAdquisicion.Compra;
import GaleriaServiciosDeAdquisicion.Precio;
import GaleriaServiciosDeAdquisicion.Subasta;

public class Galeria {
	
	private ArrayList<Subasta> SubastasProgramadas;
	
	private HashMap<String, Usuario> mapaUsuarios;
	
	private HashMap<String, Usuario> mapaUsuariosEmpleados;
	
	private Inventario inventario;
	

	public Galeria(Inventario inventario) {
		this.SubastasProgramadas= new ArrayList<Subasta>();
		this.mapaUsuarios= new HashMap<String, Usuario>();
		this.mapaUsuariosEmpleados= new HashMap<String, Usuario>();
		this.inventario=inventario;

	}
	
	
	
	


	public Inventario getInventario() {
		return inventario;
	}


	public void participarSubasta(Galeria galeria , Usuario usuario) {
		Subasta subastaEncontrada=null;
		Scanner scanner=new Scanner(System.in);
		System.out.println("/////////////////////////////////////////");
		System.out.println("Bienvenido al sistema de subastas!!");
		System.out.println("");
		boolean seguir=true;
		while (seguir) {
			System.out.println("1. buscar Subasta");
			System.out.println("2. salir ");
			int input=scanner.nextInt();
			scanner.nextLine();
			
			if(input==1) {
				System.out.println("Ingrese el titulo de la pieza");
				String titulo=scanner.nextLine();
				
				for (Subasta subasta : galeria.getSubastasProgramadas()) {
					// se busca la subasta por el titulo de la pieza 
					if(subasta.getPieza().getTitulo().equals(titulo)) {
						subastaEncontrada=subasta;
					}
				}
				//no se encontro la pieza 
				if (subastaEncontrada==null) {
					System.out.println("No se ha encontrador la pieza");
				}else if(subastaEncontrada.getFechaFinal().isBefore(LocalDate.now())){
					System.out.println("Esta subasta de la pieza "+ titulo + "  ya finalizo");
					seguir=false;
				}else {
					seguir=false;
				}
			}else if(input==2) {
				seguir=false;
			}else {
				System.out.println("valor incorrecto");
			}
		}
		
		if (subastaEncontrada!=null ) {
			boolean seguir2=true;
			while (seguir2) {
				System.out.println("///////////////////////////////////////////////////////////");
				System.out.println("el precio de la pieza esta en: "+ subastaEncontrada.getPieza().getPrecio().getPrecio());
				System.out.println("Ingrese su oferta:");
				int oferta= scanner.nextInt();
				scanner.nextLine();
				if((int)subastaEncontrada.getPieza().getPrecio().getPrecio()<oferta) {
					subastaEncontrada.getPieza().nuevoPrecio(oferta, usuario);
					Precio precio=new Precio();
					precio.setPrecio(oferta);
					precio.setUsuario(usuario);
					subastaEncontrada.anadirRegistroSubasta(precio);
					System.out.println("ahora eres la oferta mas alta");
					System.out.println("si quieres saber si ganaste la oferta revisa tus adqusisiones al finalizar la subasta");
					seguir2=false;
				}else {
					System.out.println("el monto es incorrecto");
				}
			}
			
		}
	}
	public void verPiezasDisponibles(Galeria galeria, Usuario usuario) {
		/*esta pregunta si quiere ver piezas de subasta o de compra 
		 * y segun lo que escoja se imprime los titulos de estas piezas que estan en el inventario.
		 * 
		 * */
		Scanner scanner= new Scanner(System.in);
		//centinela
		boolean seguir=true;
		
		while (seguir) {
			System.out.println("///////////////////////////////////////");
			System.out.println("");
			System.out.println("1. Ver piezas en subasta");
			System.out.println("2. Ver piezas en venta");
			System.out.println("3. Salir");
			System.out.println("");
			System.out.println("Selecione la actividad que desea realizar (1/2/3)");
			int input=scanner.nextInt();
			scanner.nextLine();
			
			if (input==1) {
				//inprime el titulo de todas las piezas de subasta
				galeria.getInventario().getinfoPiezasSubasta();
				seguir=false; 
			}else if(input==2) {
				//inprime el titulo de todas las piezas de precio fijo
				galeria.getInventario().getPiezasPrecioFijo();
				seguir=false; 
			}else if(input==3) {
				seguir=false; 
			}else {
				System.out.println("Valor incorrecto ingresado");
			}
		}
		
		
	}
	

	public HashMap<String, Usuario> getListaUsuariuos() {
		return mapaUsuarios;
	}

	public ArrayList<Subasta> getSubastasProgramadas() {
		return SubastasProgramadas;
	}

	public HashMap<String, Usuario> getMapaUsuariosEmpleados() {
		return mapaUsuariosEmpleados;
	}

	public void comprarPieza(Galeria galeria , Usuario usuario) {
		Compra compra=null;
		Pieza piezaEncontrada= null;
		Scanner scanner=new Scanner(System.in);
		System.out.println("/////////////////////////////////////////");
		System.out.println("Bienvenido al sistema de Compras!!");
		System.out.println("");
		boolean seguir=true;
		while (seguir) {
			System.out.println("1. buscar pieza");
			System.out.println("2. salir ");
			int input=scanner.nextInt();
			scanner.nextLine();
			if(input==1) {
				System.out.println("Ingrese el titulo de la pieza");
				String titulo=scanner.nextLine();
				piezaEncontrada=inventario.buscarPieza(titulo);
				seguir=false;
			}else if(input==2) {
				seguir=false;
			}else {
				System.out.println("Valor incorrecto");
			}
		}
		
		if (piezaEncontrada!=null) {
			boolean seguir1=true;
			int precio=(int)piezaEncontrada.getPrecio().getPrecio();
			while(seguir1) {
				System.out.println("/////////////////////////////////////");
				System.out.println("el precio de esta pieza es de: "+precio);
				System.out.println("");
				System.out.println("Desea comprarla");
				System.out.println("1. Si");
				System.out.println("2. No");
				int input3=scanner.nextInt();
				scanner.nextLine();
				if(input3==1) {
					if(precio>usuario.getCartera()) {
						System.out.println("No cuenta con suficientes recursos en su cartera");
					}else {
						usuario.gastado(precio);
						compra=new Compra(piezaEncontrada, precio, usuario);
						piezaEncontrada.setFechaDeVenta(LocalDate.now());
						Administrador admin=(Administrador) galeria.getMapaUsuariosEmpleados().get("Administrador");
						admin.aniadirVentasAVerificar(compra);
						System.out.println("La compra fue mandada a verificar, a mas tardar 1 dia revise si fue aprobado");
						seguir1=false;
					}
				}else if(input3==2) {
					seguir1=false;
					
				}
			}
		}else {
			System.out.println("Pieza no encontrada");
		}
	}
	
	public void verHistoriaPieza(Galeria galeria, Usuario usuario) {
		Scanner scanner= new Scanner(System.in);
		System.out.println("");
		System.out.println("'Historia de pieza'");
		System.out.println("");
		boolean hecho = false;
		while(!hecho) {
			System.out.println("¿Cual tipo de pieza desea buscar?: ");
			System.out.println("1.Pieza en venta");
			System.out.println("2.Pieza ya vendida");
			
			int respuesta = scanner.nextInt();
			scanner.nextLine();
			// Buscar pieza en venta
			if(respuesta==1) {
				System.out.println("Ingrese el nombre de la pieza: ");
				String nombrePieza = scanner.nextLine();
				
				System.out.println("Ingrese el nombre del artista: ");
				String nombreArtista = scanner.nextLine();
				
				if (mapaUsuarios.containsKey(nombreArtista) && mapaUsuarios.get(nombreArtista) instanceof Artista ) {
					Artista artista =(Artista)mapaUsuarios.get(nombreArtista);
					inventario.buscarPieza(nombrePieza, artista);
				}	
				else {
					System.out.println("El artista no fue encontrado");
				}
				
				hecho = true;
				
			//Buscar pieza antigua	
			}else if(respuesta==2) {
				System.out.println("Ingrese el nombre de la pieza: ");
				String nombrePieza = scanner.nextLine();
				
				System.out.println("Ingrese el nombre del artista: ");
				String nombreArtista = scanner.nextLine();
				
				if (mapaUsuarios.containsKey(nombreArtista) && mapaUsuarios.get(nombreArtista) instanceof Artista ) {
					Artista artista =(Artista)mapaUsuarios.get(nombreArtista);
					inventario.buscarInfoPiezaAntigua(nombrePieza, artista);
				}	
				else {
					System.out.println("El artista no fue encontrado");
				}
				
				hecho = true;
			}else {
				System.out.println("Seleccione una opcion correcta");
			}
		}
	}
	
	public void mirarHistoriaArtista(Galeria galeria,Usuario usuario) {
		Scanner scanner= new Scanner(System.in);
		
		
		System.out.println("");
		System.out.println("'Historia de artista'");
		System.out.println("");
		System.out.println("Escriba el nombre del artista:");
		String nombreArtista=scanner.nextLine();
		
		if (mapaUsuarios.containsKey(nombreArtista) && mapaUsuarios.get(nombreArtista) instanceof Artista ) {
			Artista artistaEcontrado =(Artista)mapaUsuarios.get(nombreArtista);
			ArrayList<Pieza> piezasDeArtista= artistaEcontrado.getListaPiezas();
			System.out.println("Estas son las piezas que ha realizado "+ nombreArtista);
			System.out.println("");
			
			
			for (Pieza pieza : piezasDeArtista) {
				
				System.out.println("////////////////");
				System.out.println("Nombre: "+ pieza.getTitulo());
				System.out.println("Fecha de creacion: "+ pieza.getLugarCreacion());
				
				//mirar si es una pieza en siubasta o en compra
				if (pieza.isSubasta()) {
					Subasta subastaDePieza=null;
					//buscar la subasta de la pieza
					for (Subasta subasta : SubastasProgramadas) {
						if (pieza.equals(subasta.getPieza())) {
							subastaDePieza=subasta;
						}
					}
					//revisamos si la subasta ya acabo o no 
					if(subastaDePieza.getFechaFinal().isBefore(LocalDate.now())) {
						System.out.println("La pieza sigue en Subasta y acaba en: "+ subastaDePieza.getFechaFinal());
						System.out.println("El precio actual de la pieza es: "+ subastaDePieza.getPieza().getPrecio().getPrecio());
					}else {
						System.out.println("La pieza ya fue vendida en Subasta el dia: "+ subastaDePieza.getFechaFinal());
						System.out.println("El precio al cual la pieza fue subastada es: "+ subastaDePieza.getPieza().getPrecio().getPrecio());
					}
				}else {
					Pieza piezaEncontrada=null;
					//mirar si ya fue vendida o esta en venta
					for (Pieza pieza2 : galeria.getInventario().getInfoPiezasAntiguas()) {
						if (pieza.equals(pieza2)) {
							piezaEncontrada=pieza2;
						}
					}
					
					if(piezaEncontrada==null) {
						System.out.println("Esta pieza no ha sido vendida se encuentra en venta");
					}else {
						System.out.println("La pieza fue vendida el dia: "+ pieza.getFechaDeVenta());
						System.out.println("El precio al cual fue vendido fue: "+ pieza.getPrecio().getPrecio());
					}
				}
			}
		}else {
			System.out.println("El artista que busca no esta registrado en esta galeria");
		}
		 
	}
	
	public void aniadirUsuario(Usuario usuario) {
		mapaUsuarios.put(usuario.getUsuario(), usuario);
	}
	
	public void aniadirUsuarioEmpleado(Usuario usuario) {
		mapaUsuariosEmpleados.put(usuario.getUsuario(), usuario);
	}
	
	public void aniadirSubasta(Subasta subasta) {
		SubastasProgramadas.add(subasta);
	}
	
	

}
