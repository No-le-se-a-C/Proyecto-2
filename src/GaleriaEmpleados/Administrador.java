package GaleriaEmpleados;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import GaleriaGestionSesion.Usuario;
import GaleriaModelo.Galeria;
import GaleriaPieza.Pieza;
import GaleriaServiciosDeAdquisicion.Compra;

public class Administrador extends Usuario {
	
	private String IDENTIFICADOR="ADMINISTRADOR";
	private ArrayList<Pieza> piezasPorAnadir;
	private ArrayList<Usuario> peticionesSubasta;
	private HashMap<Usuario, Integer> pedidosCupoCompra;
	
	private ArrayList<Compra> ventasAVerificar;
	
	public String getIDENTIFICADOR() {
		return IDENTIFICADOR;
	}
	
	public void SolicitudAnadirPieza(Pieza pieza) {
		piezasPorAnadir.add(pieza);
		
	}
	
	public ArrayList<Usuario> getPeticionesSubasta(){
		return peticionesSubasta;
	}
	public void aniadirVentasAVerificar(Compra compra) {
		ventasAVerificar.add(compra);
	}
	
	public void aniadirPeticionSubasta(Usuario user) {
		peticionesSubasta.add(user);
	}

	public void aniadirPedidoCupoCompra(Usuario usuario, int cantidad) {
		pedidosCupoCompra.put(usuario, cantidad);
	}
	
	
	public Administrador(String usuario, String contraseña) {
		super(usuario, contraseña);
		piezasPorAnadir= new ArrayList<Pieza>();
	}
	
	public void verificarVenta() {
		
	}
	
	public void verificarSeriedadDeOferta() {
		
	}
	
	public void validarAniadirPieza(Galeria galeria) {
		Scanner scanner= new Scanner(System.in);
		System.out.println("//////////////////////////////////////////");
		System.out.println("Tiene "+ piezasPorAnadir.size()+" solicitudes para añadir piezas");
		System.out.println("");
		boolean seguir=true;
		//se le prgunta al admin si quiere revisar las solicitudes
		
		while (seguir) {
			System.out.println("Desea verlas");
			System.out.println("1. Si");
			System.out.println("2. No");
			int input=scanner.nextInt();
			scanner.nextLine();
			
			if(1==input) {
				int i=0;
				boolean seguir1=true;
				while (seguir1) {
					System.out.println("/////////////////////");
					System.out.println("1. mostrar solicitud");
					System.out.println("2. dejar de ver solicitudes");
					int input1=scanner.nextInt();
					scanner.nextLine();
					if(!piezasPorAnadir.isEmpty()) {
						if (input1==1) {
							Pieza pieza =piezasPorAnadir.get(0);
							System.out.println("Este es el titulo de la pieza: "+pieza.getTitulo());
							System.out.println("Este es el precio Minimo impuesto(si es cero recuerde que es por que no es subasta): "+pieza.getPrecioMinimo());
							System.out.println("Este es el precio: "+ pieza.getPrecio()[0]);
							System.out.println("");
							System.out.println("Teniendo encuenta esta informacion quiere admitir la entrada de esta pieza:");
							System.out.println("1. Si");
							System.out.println("2. No");
							int input3=scanner.nextInt();
							scanner.nextLine();
							
							if (input3==1) {
								piezasPorAnadir.remove(0);
								galeria.getInventario().anadirPiezaVerificada(pieza, galeria);
								System.out.println("La pieza acaba de ser agregada y la solicitud completa");
								System.out.println("Buen trabajo!!!");
							}else if(input3==2) {
								piezasPorAnadir.remove(0);
								System.out.println("La pieza no paso el proceso de verificacion");
							}
							
							i++;
						}else if(input1==2) {
							seguir1=false;
						}else {
							System.out.println("Valor incorrecto");
						}
					}else {
						System.out.println("Ya se acabaron las solicitudes");
						seguir1=false;
					}
				}
				seguir=false;
			}else if(2==input){
				seguir=false;
			}else {
				System.out.println("Valor incorrecto");
			}
		}
		
	}
	
	public Boolean verificarUsuarioSubasta(Pieza usuario) {
		return null;
		
	}

}
