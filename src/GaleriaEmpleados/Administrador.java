package GaleriaEmpleados;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

import GaleriaGestionSesion.Usuario;
import GaleriaModelo.Galeria;
import GaleriaPieza.Pieza;
import GaleriaServiciosDeAdquisicion.Compra;
import GaleriaServiciosDeAdquisicion.Precio;
import GaleriaServiciosDeAdquisicion.Subasta;

public class Administrador extends Usuario {
	
	private String IDENTIFICADOR="ADMINISTRADOR";
	private ArrayList<Pieza> piezasPorAnadir;
	private ArrayList<Usuario> peticionesSubasta;
	private HashMap<Usuario, Integer> pedidosCupoCompra;
	
	private ArrayList<Compra> ventasAVerificar;
	private ArrayList<Usuario> ventasAVerificarUsuario;
	
	

	public ArrayList<Pieza> getPiezasPorAnadir() {
		return piezasPorAnadir;
	}

	public HashMap<Usuario, Integer> getPedidosCupoCompra() {
		return pedidosCupoCompra;
	}

	public ArrayList<Compra> getVentasAVerificar() {
		return ventasAVerificar;
	}

	public ArrayList<Usuario> getVentasAVerificarUsuario() {
		return ventasAVerificarUsuario;
	}

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
	public void aniadirVentasAVerificar(Usuario usuario) {
		ventasAVerificarUsuario.add(usuario);
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
		
		this.peticionesSubasta=new ArrayList<Usuario>();
		pedidosCupoCompra= new HashMap<Usuario, Integer>() ;
		
		ventasAVerificar= new ArrayList<Compra>();
		ventasAVerificarUsuario= new ArrayList<Usuario>();
	}
	
	public void verificarVenta(Galeria galeria, Usuario usuario) {
		Scanner scanner= new Scanner(System.in);
		System.out.println("//////////////////////////////////////////");
		System.out.println("Tiene "+ ventasAVerificar.size()+" solicitudes para verificar ventas");
		System.out.println("");
		boolean seguir=true;
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
					if(!ventasAVerificar.isEmpty()) {
						if (input1==1) {
							Compra compra =ventasAVerificar.get(0);
							System.out.println("El metodo de pago del usuario es: "+ compra.getUsuarioComprador().getMetodoPago());
							System.out.println("El precio pagado fue: "+ compra.getValorPagado());
							System.out.println("al usuario tiene este dinero en la cartera: "+ compra.getUsuarioComprador().getCartera());
							
							System.out.println("Teniendo encuenta esta informacion quiere admitir la entrada de esta pieza:");
							System.out.println("1. Si");
							System.out.println("2. No");
							int input3=scanner.nextInt();
							scanner.nextLine();
							
							if (input3==1) {
								ventasAVerificar.remove(0);
								galeria.getInventario().anadirPiezaInfoAntigua(compra.getPieza());
								galeria.getInventario().eliminarpiezaVendida(compra.getPieza());
								compra.getUsuarioComprador().anadirAdquisicion(compra.getPieza());
								System.out.println("La venta fue verificada y enviada al usuario");
								System.out.println("Buen trabajo!!!!");
							}else if(input3==2) {
								ventasAVerificar.remove(0);
								System.out.println("La venta no paso el proceso de verificacion");
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
	
	public void verificarSeriedadDeOferta(Galeria galeria) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("//////////////////////////////////////////");
		System.out.println("");
		for( Subasta subasta: galeria.getSubastasProgramadas() ) {
			if(!subasta.getFechaFinal().isBefore(LocalDate.now())) {
				for(Precio precio: subasta.getRegistroSubasta()) {
					System.out.println("Oferta del usuario: " + precio.getUsuario().getUsuario());
					System.out.println("Cantidad ofrecida: " + Integer.toString(precio.getPrecio()));
					System.out.println("");

				}
			}
		}
		
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
							System.out.println("Este es el precio: "+ pieza.getPrecio().getPrecio());
							System.out.println("");
							System.out.println("Teniendo encuenta esta informacion quiere admitir la entrada de esta pieza:");
							System.out.println("1. Si");
							System.out.println("2. No");
							int input3=scanner.nextInt();
							scanner.nextLine();
							
							if (input3==1) {
								piezasPorAnadir.remove(0);
								galeria.getInventario().anadirPiezaVerificada(pieza, galeria);
								pieza.getAutor().aniadirPieza(pieza);
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
	
	/*public Boolean verificarUsuarioSubasta(Usuario usuario , Galeria galeria) {
		
		if (true){
			
			usuario.getUsuario();
		}
			
			{
			
		}
		
		return false;
		
	}
	 */
	public void historiaComprador(Galeria galeria) {
		
		Scanner scanner = new Scanner(System.in);
		int valorDeColeccion = 0;
		Usuario usuarioVisto = null;
		HashMap<String,Usuario> listaUsuarios = galeria.getListaUsuariuos();
		
		System.out.println("/////////////////////////////////////");
		System.out.println("Bienvenido a las Historias de Usuario");
		System.out.println("");
		System.out.println("Escriba el nombre del comprador que quiere verificar: ");
		String nombreUsuario = scanner.nextLine();
		usuarioVisto = listaUsuarios.get(nombreUsuario);
		if (usuarioVisto != null) {
		
			
			System.out.println("");
			
			System.out.println("El comprador " + nombreUsuario + " tiene el siguiente número de piezas " + usuarioVisto.getListaAdquisiciones().size());
			
			
			
			for (Pieza pieza:usuarioVisto.getListaAdquisiciones()) {
						
				System.out.println("////////////////////////////////////////////////");
				System.out.println("El nombre de la pieza  es: " + pieza.getTitulo());
				System.out.println("La fecha en la que fue vendida esta pieza fue: " + pieza.getFechaDeVenta());
				
				valorDeColeccion += pieza.getPrecio().getPrecio();
						
			}
				
			System.out.println("///////////////////////////////");	
			System.out.println("El valor de la coleccion es: " + valorDeColeccion);	
		}else {
			
			System.out.println("El comprador buscado no existe /nVerifique el nombre");
			
		}
	}
		
		
}
	
