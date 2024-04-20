package GaleriaModelo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import GaleriaGestionSesion.Usuario;
import GaleriaPieza.Pieza;
import GaleriaServiciosDeAdquisicion.Compra;
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
				System.out.println("el precio de la pieza esta en: "+ subastaEncontrada.getPieza().getPrecio()[0]);
				System.out.println("Ingrese el su oferta:");
				int oferta= scanner.nextInt();
				scanner.nextLine();
				if((int)subastaEncontrada.getPieza().getPrecio()[0]<oferta) {
					subastaEncontrada.getPieza().nuevoPrecio(oferta, usuario);
					Object[] precio=new Object[2];
					subastaEncontrada.anadirRegistroSubasta(precio);
					System.out.println("ahora eres la oferta mas alta");
					System.out.println("si quieres saber si ganaste la oferta revisa tus adqusisiones al finalizar la subasta");
					seguir=false;
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
				
			}else if(input==2) {
				seguir=false;
			}else {
				System.out.println("Valor incorrecto");
			}
		}
		
		if (piezaEncontrada!=null) {
			boolean seguir1=true;
			int precio=(int)piezaEncontrada.getPrecio()[0];
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
	
	public void mirarMiPieza() {
		
	}
	
	public void mirarInfoDePiezaAntigua() {
		
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
