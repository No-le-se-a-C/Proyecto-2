package GaleriaModelo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import GaleriaGestionSesion.Usuario;
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


	public void participarSubasta() {
		
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

	public void comprarPieza() {
		
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
		
	}
	
	

}
