package GaleriaConsola;

import java.util.Scanner;

import GaleriaEmpleados.Administrador;
import GaleriaEmpleados.Cajero;
import GaleriaEmpleados.Operador;
import GaleriaGestionSesion.Artista;
import GaleriaGestionSesion.Comprador;
import GaleriaGestionSesion.Sesion;
import GaleriaGestionSesion.Usuario;
import GaleriaModelo.Galeria;
import GaleriaPieza.Pieza;
import GaleriaServiciosDeAdquisicion.Compra;

public class Controller {
	
	public void registrase(Galeria galeris) {
		Sesion sesion= new Sesion();
		sesion.registrarse(galeris);
	}
	
	public Usuario iniciarSesion(Galeria galeria) {
		Sesion sesion= new Sesion();
		return sesion.iniciarSesion(galeria);
	}
	
	
	
	public void definirMetodoPago(Galeria galeria, Usuario usuario, String metodo, int cantidad) {
		
		/*esta funcion lo que hace es decirle al usuario que metodo de pago 
		quiere definir esta "EFECTIVO", "TARJETA", "EN LINEA", ademas se le pregunta cuanto 
		quiere tener en la cartera y queda actualizado los atributos de metodo de pago, cartera,
		por ultimo si la cartera esta entre 1 y 100 se le da un maximo de compra al comprador de 3  piezas
		 si es de 100 a 100 se le da 5 maximo de compras y si es mas de 1000 se le da 7 maximo de compras
		*/
		
		
		//Define el maximo de compras segun la cartera
		int maximoCompra = 0;
		if (cantidad >= 1 && cantidad < 100) {
			maximoCompra = 3;
		}else if(cantidad >= 100 && cantidad < 1000) {
			maximoCompra = 5;
		}else if(cantidad >= 1000) {
			maximoCompra = 7;
		}
			
		usuario.definirMetodoPago(metodo);
		usuario.definirCartera(cantidad);
		
		//Asigna el maximo de compras al usuario
		if(usuario.getIDENTIFICADOR().contentEquals("COMPRADOR")){
			( (Comprador)usuario ).definirMaximoCompras(maximoCompra);
			
		}else if(usuario.getIDENTIFICADOR().contentEquals("ARTISTA")) {
			( (Artista)usuario ).definirMaximoCompras(maximoCompra);
		}	
	}
	

	
	public void comprarPieza(Galeria galeria, Usuario usuario) {
		galeria.comprarPieza(galeria, usuario);
	}
	
	public void verPiezasDisponibles(Galeria galeria, Usuario usuario) {
		/*esta pregunta si quiere ver piezas de subasta o de compra 
		 * y segun lo que escoja se imprime los titulos de estas piezas que estan en el inventario.
		 * 
		 * */
		galeria.verPiezasDisponibles(galeria, usuario);
	}
	
	public void mirarMiPieza(Galeria galeria, Usuario usuario) {
		/*se le pide titulo al artista de su pieza y se muestra el 
		 * estado de esta ya que esta esta en el inventario y no se le puede mostrar 
		 * si el artista de la pieza no coincide con el artista que la esta pidiendo
		 * 
		 * */
		Scanner scanner=new Scanner(System.in);
		
		System.out.println("///////////////////////////////////////");
		System.out.println("");
		System.out.println("-Ingrese el titulo de su pieza a buscar:");
		String titulo=scanner.nextLine();
		
		
		galeria.getInventario().buscarPieza(titulo, (Artista) usuario);
	}
	
	public void mirarInfoDePiezaAntigua(Galeria galeria, Usuario usuario) {
		/*se le pide titulo al artista de su pieza y se muestra la info de esta pieza que 
		 * esta en la lista de piezas antiguas y no se le puede mostrar 
		 * si el artista de la pieza no coincide con el artista que la esta pidiendo
		 * 
		 * */
		Scanner scanner=new Scanner(System.in);
		
		System.out.println("///////////////////////////////////////");
		System.out.println("");
		System.out.println("-Ingrese el titulo de la pieza que quiera saber su informacion:");
		String titulo=scanner.nextLine();
		
		
		galeria.getInventario().buscarPieza(titulo, (Artista) usuario);
		
	}
	

	public void pedirCupoDeCompras(Galeria galeria, Usuario usuario) {
		/*Se pregunta cuanto quiere añadir y se le envia una lista de 2 posiciones
		 * (primera pos es usuario, segunda pos el int de cuanto quiere añadir) a 
		 * el admin a la lista de pedidosCupoCompra.
		 * */
		Scanner scanner=new Scanner(System.in);
		
		System.out.println("///////////////////////////////////////");
		System.out.println("");
		System.out.println("-Ingrese la cantidad que desea aniadir:");
	
		int cantidad = scanner.nextInt();
		//Se añade la solicitud de compra al admin
		Administrador admin=(Administrador)(galeria.getMapaUsuariosEmpleados().get("Administrador"));
		admin.aniadirPedidoCupoCompra(usuario, cantidad);
		scanner.close();
	}
	
	public void verificarVenta(Galeria galeria, Usuario usuario) {
		/*se le muestra al empleado la cantidad de verificaciones que tiene que revisar 
		 * que esto es la cantidad de elementos de la lista ventasAVerificar y se pregunta si quiere 
		 * revisarlas, si dice que si se le muestra 1, (la forma en que la verifique es mostrando datos y 
		 * preguntando si quiere admitir), si admite entonces se añade la pieza a el usuario y 
		 * a la lista de piezas antiguas y se borra del la lista de piezas de la galeria. 
		 * 
		 * */
		Administrador admin=(Administrador)galeria.getMapaUsuariosEmpleados().get("Administrador");
		admin.verificarVenta(galeria, usuario);
	}
	
	public void verificarSeriedadDeOferta(Galeria galeria, Usuario usuario) {
		/*
		 * Este verifica el precio de cada subasta que este sucediendo si este
		 * y se pregunta si quiere 
		 * revisarlas, si dice que si se le muestra 1, (la forma en que la verifique es mostrando datos y 
		 * preguntando si quiere admitir), si admite entonces se deja el precio actual si no lo admite se quita ese 
		 * precio y se pone uno nuevo, el  nuevo es un atributo que va a tener subasta que es un precio 
		 * que al igual que los precios normales sera una lista de 2 posiciones, 
		 * este precio sera en el que la subasta empezo
		 * */
		Administrador admin=(Administrador)galeria.getMapaUsuariosEmpleados().get("Administrador");
		Operador operador = (Operador)galeria.getMapaUsuariosEmpleados().get("Operador");
		System.out.println("///////////////////////////////////////");
		System.out.println("");
		//System.out.println("-En este momento usted tiene "+ Integer.toString( galeria.getSubastasProgramadas().size())+ " subastas pendientes.");
		//System.out.println("Desea revisarlas(SI/NO): ");
		//String respuesta = scanner.nextLine();
		operador.llevarResgistroSubasta(galeria, usuario);
		//admin.verificarSeriedadDeOferta( galeria );	
	}
	
	public void revisarPago(Galeria galeria, Usuario usuario) {
		/*e le muestra al empleado la cantidad de verificaciones que tiene que revisar 
		 * que esto es la cantidad de elementos de la lista de pagos , y se pregunta si quiere 
		 * revisarlas, si dice que si se le muestra 1, (la forma en que la verifique es mostrando datos y 
		 * preguntando si quiere admitir), si admite se manda la lista a la lista de ventasAVerificar del admin
		 * */
		Scanner scanner=new Scanner(System.in);
		Administrador admin=(Administrador)galeria.getMapaUsuariosEmpleados().get("Administrador");
		Cajero cajero = (Cajero)galeria.getMapaUsuariosEmpleados().get("Cajero");
		System.out.println("///////////////////////////////////////");
		System.out.println("");
		System.out.println("-En este momento usted tiene "+ Integer.toString( cajero.getPagosPendientes().size())+ " verificaciones pendientes.");
		System.out.println("Desea revisarlas(SI/NO): ");
		String respuesta = scanner.nextLine();
		
		if (respuesta.equalsIgnoreCase("si")) {
		//Se recorren todos los pagos pendientes	
			for (Usuario userPago: cajero.getPagosPendientes()) {
				boolean valor = cajero.revisarPago(userPago);
				if( valor ) {
					admin.aniadirVentasAVerificar(userPago);
					System.out.println("Se envio la venta al administrador");
				}	
			}
		}
	}
	
	public void llevarRegistroSubasta(Galeria galeria, Usuario usuario) {
		/*se le muestra al operador la lista de subastas  y se le pregunta si quiere revisarlas
		 * , si dice que si se entra a una subasta, y se imprime primero el nombre de la pieza de l subasta y siguiente 
		 * se imprimen los elementos de la lista registroSubasta 
		 * */
		Operador ope=(Operador) usuario;
		ope.llevarResgistroSubasta(galeria, usuario);
	}
	

	
	public void verHistoriaPieza(Galeria galeria, Usuario usuario) {
		galeria.verHistoriaPieza(galeria, usuario);
	}
	
	public void mirarHistoriaArtista(Galeria galeria, Usuario usuario) {
		galeria.mirarHistoriaArtista(galeria, usuario);
	}

	public void historiaComprador(Galeria galeria ,Usuario usuario) {
		
		((Administrador) usuario).historiaComprador(galeria);
		
	}

}