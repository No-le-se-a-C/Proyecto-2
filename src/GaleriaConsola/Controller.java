package GaleriaConsola;

import java.util.Scanner;

import GaleriaEmpleados.Administrador;
import GaleriaEmpleados.Cajero;
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
	
	
	
	public void definirMetodoPago(Galeria galeria, Usuario usuario) {
		
		/*esta funcion lo que hace es decirle al usuario que metodo de pago 
		quiere definir esta "EFECTIVO", "TARJETA", "EN LINEA", ademas se le pregunta cuanto 
		quiere tener en la cartera y queda actualizado los atributos de metodo de pago, cartera,
		por ultimo si la cartera esta entre 1 y 100 se le da un maximo de compra al comprador de 3  piezas
		 si es de 100 a 100 se le da 5 maximo de compras y si es mas de 1000 se le da 7 maximo de compras
		*/
		Scanner scanner=new Scanner(System.in);
		
		System.out.println("///////////////////////////////////////");
		System.out.println("");
		System.out.println("-Ingrese el metodo de pago que desea definir:");
		String metodo = scanner.nextLine();
		System.out.println("-Ingrese cuanto desea añadir a su cartera: ");
		int cantidad = scanner.nextInt();
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
		if(usuario.getIDENTIFICADOR().contentEquals("COMPRADOR")){
			( (Comprador)usuario ).definirMaximoCompras(maximoCompra);
			
		}else if(usuario.getIDENTIFICADOR().contentEquals("ARTISTA")) {
			( (Artista)usuario ).definirMaximoCompras(maximoCompra);;
		}	
		scanner.close();
	}
	
	public void participarSubasta(Galeria galeria, Usuario usuario) {
		/* Primero se debe ver si el usuario fue admitido para participar en subastas si no fue admitido entonces se 
		 * manda una peticion al admin para que lo admita, esto se hace añadiendo el usuario a una lista del 
		 * admin que se llamara peticionesSubasta
		 * 
		 * la idea es que el usuario pase el titulo de la pieza en la que quiere participar en subasta, 
		despues busca la pieza en la lista de subasta de la galeria y que pueda ofrecer un precio y 
		si este valor no es mayor al precio, no lo admita ( el precio es  una lista de 2 posiciones 
		donde la posicion 1 es el precio dado por el usuario y la segunda posicion sea el usuario.),si supera el 
		precio se actualiza el precio de la subasta (cada precio que den los usuarios se manda a una lista de la 
		subasta que es registroSubasta ),
		en la clase de subasta van a haber mas atributos como "fechaFinal" que va ayudar a saber cuando 
		acaba la subasta y apenas acabe se va a ver el precio mayor y el usuario y se añade la pieza de la 
		subasta al usuario. 
		*/
		if( ((Comprador)usuario).getAdmitido() || ((Artista)usuario).getAdmitido() ) {
			galeria.participarSubasta();
		}else {
			((Administrador)usuario).aniadirPeticionSubasta(usuario);
			System.out.println("-Usted no fue admitido para participar en una subasta, se le mando una peticion al administrador.");
		}
	}
	
	public void comprarPieza(Galeria galeria, Usuario usuario) {
		
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
	
	public void aniadirPieza(Usuario usuario,Galeria galeria) {
		/*Esto lo hacen los artistas mandan la pieza que quieren añadir
		 * sea foto, escultura, etc, apenas diligencien la pieza que quieran añadir 
		 * se le manda la pieza al admin a la lista de piezasPorAnadir y si el usuario 
		 * quiere saber si ya se añadio debe buscarla en la funcion mirarMiPieza
		 * 
		 * */
		
		galeria.getInventario().aniadirPieza(galeria, usuario);
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
		((Administrador)usuario).aniadirPedidoCupoCompra(usuario, cantidad);
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
		Scanner scanner=new Scanner(System.in);
		System.out.println("///////////////////////////////////////");
		System.out.println("");
		System.out.println("-En este momento usted tiene "+ Integer.toString( ((Cajero)usuario).getPagosPendientes().size())+ " verificaciones pendientes.");
		System.out.println("Desea revisarlas(SI/NO): ");
		String respuesta = scanner.nextLine();
		if (respuesta.toUpperCase().contentEquals("SI")) {
			((Administrador)usuario).verificarSeriedadDeOferta();	
		}
		scanner.close();
	}
	
	public Boolean verificarUsuarioSubasta(Pieza usuario) {
		/*se le muestra al empleado la cantidad de verificaciones que tiene que revisar 
		 * que esto es la cantidad de elementos de la lista de peticionesSubasta, y se pregunta si quiere 
		 * revisarlas, si dice que si se le muestra 1, (la forma en que la verifique es mostrando datos y 
		 * preguntando si quiere admitir), si admite se cambia el boolean del usuario de admitido.
		 * */
		return null;
		
	}
	
	public void revisarPago(Galeria galeria, Usuario usuario) {
		/*e le muestra al empleado la cantidad de verificaciones que tiene que revisar 
		 * que esto es la cantidad de elementos de la lista de pagos , y se pregunta si quiere 
		 * revisarlas, si dice que si se le muestra 1, (la forma en que la verifique es mostrando datos y 
		 * preguntando si quiere admitir), si admite se manda la lista a la lista de ventasAVerificar del admin
		 * */
		Scanner scanner=new Scanner(System.in);
		System.out.println("///////////////////////////////////////");
		System.out.println("");
		System.out.println("-En este momento usted tiene "+ Integer.toString( ((Cajero)usuario).getPagosPendientes().size())+ " verificaciones pendientes.");
		System.out.println("Desea revisarlas(SI/NO): ");
		String respuesta = scanner.nextLine();
		if (respuesta.toUpperCase().contentEquals("SI")) {
			for (Usuario userPago: ((Cajero)usuario).getPagosPendientes()) {
				boolean valor = ((Cajero)usuario).revisarPago(userPago);
				if( valor ) {
					((Administrador)usuario).aniadirVentasAVerificar(userPago);
				}
		scanner.close();		
			}
		}
	}
	
	public void llevarRegistroSubasta() {
		/*se le muestra al operador la lista de subastas que acabaron y se le pregunta si quiere revisarlas
		 * , si dice que si se entra a una subasta, y se imprime primero el nombre de la pieza de l subasta y siguiente 
		 * se imprimen los elementos de la lista registroSubasta 
		 * */
	}
	
	public void validarPiezasPorAniadir(Galeria galeria, Usuario usuario) {
		/*se le muestra al empleado la cantidad de verificaciones que tiene que revisar 
		 * que esto es la cantidad de elementos de la lista de piezasPorAnadir, y se pregunta si quiere 
		 * revisarlas, si dice que si se le muestra 1, (la forma en que la verifique es mostrando datos y 
		 * preguntando si quiere admitir), si admite se pasa la pieza al inventario 
		 * */
		
		Administrador admin= (Administrador) usuario;
		admin.validarAniadirPieza(galeria);
	}
	

}