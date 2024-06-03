package GaleriaConsola;

import java.util.InputMismatchException;
import java.util.Scanner;

import GaleriaGestionSesion.Usuario;
import GaleriaModelo.Galeria;

public class Vista {
	
	
	
	public void interfaz(Galeria galeria) {
		Controller controlador = new Controller();
        Scanner scanner = new Scanner(System.in);
        boolean sesionIniciada = true;
        Usuario usuario = null;

        System.out.println("///////////////////////////////////////////////////////////");
        System.out.println("//////////////////////////Galeria//////////////////////////");
        System.out.println("///////////////////////////////////////////////////////////");
        System.out.println("");
        System.out.println("Antes de entrar debe registrase o iniciar sesión (indique el numero de la actividad deseada)");

        while (sesionIniciada) {
            System.out.println("");
            System.out.println("1. Registrarse");
            System.out.println("2. Iniciar sesión");

            int input = 0;
            try {
                input = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Por favor, ingresa un número válido.");
                continue; // Volver al principio del bucle
            }

            switch (input) {
                case 1:
                    controlador.registrase(galeria);
                    break;
                case 2:
                    usuario = controlador.iniciarSesion(galeria);
                    sesionIniciada = false;
                    break;
                default:
                    System.out.println("Por favor, ingresa una opción válida (1 o 2).");
            }
        }
		//segun que tipo de usuario se le muestra diversas funciones y diferentes interfaces 
		if(usuario!=null) {
	        if ("ARTISTA".equals(usuario.getIDENTIFICADOR())) {
	            interfazPropietario(galeria, usuario);
	        } else if ("COMPRADOR".equals(usuario.getIDENTIFICADOR())) {
	            interfazComprador(galeria, usuario);
	        } else if ("ADMINISTRADOR".equals(usuario.getIDENTIFICADOR())) {
	            interfazAdmin(galeria, usuario);
	        } else if ("OPERADOR".equals(usuario.getIDENTIFICADOR())) {
	            interfazOperador(galeria, usuario);
	        } else if ("CAJERO".equals(usuario.getIDENTIFICADOR())) {
	            interfazCajero(galeria, usuario);
	        }
			scanner.close();
		}
		
		
		
	}
	
	public void interfazComprador(Galeria galeria, Usuario usuario) {
		Controller controler=new Controller();
		
		Scanner scanner = new Scanner(System.in);
		// se inicia centinela para salir de la galeria
		boolean seguir=true;
		
		System.out.println("bienvenido Comprador");
		
		while(seguir) {
			System.out.println("//////////////////////////////////////7");
			System.out.println("Que desea realizar");
			System.out.println("");
			System.out.println("1.Definir Metodo de pago.");
			System.out.println("2.Ver piezas disponibles");
			System.out.println("3.Comprar una pieza");
			System.out.println("4.Participar en una subasta");
			System.out.println("5.Pedir mas cupo de compra");
			System.out.println("6.Mirar historia de una pieza");
			System.out.println("7.Mirar historia de un artista");
			System.out.println("8.Salir al menu pricipal");
			int input= scanner.nextInt();
			scanner.nextLine();
			
			if (1==input) {
	
			}else if (2==input) {
				controler.verPiezasDisponibles(galeria, usuario);
			}else if (3==input) {
				controler.comprarPieza(galeria, usuario);
			}else if (4==input) {
				
			}else if (5==input) {
				controler.pedirCupoDeCompras(galeria, usuario);
			}else if(6==input) {
				controler.verHistoriaPieza(galeria, usuario);
			}else if(7==input) {
				controler.mirarHistoriaArtista(galeria, usuario);
			}else if (8==input) {
				interfaz(galeria);
			}else {
				System.out.println("Valor incorrecto");
			}
		}
		scanner.close();
	}
	
	public void interfazPropietario(Galeria galeria, Usuario usuario) {
		// se inicia centinela para salir de la galeria
		boolean seguir=true;
		System.out.println("bienvenido Artista");
		Controller controler=new Controller();
		
		Scanner scanner = new Scanner(System.in);

		while(seguir) {
			System.out.println("//////////////////////////////////////7");
			System.out.println("Que desea realizar");
			System.out.println("");
			System.out.println("1.Definir Metodo de pago.");
			System.out.println("2.Ver piezas disponibles");
			System.out.println("3.Comprar una pieza");
			System.out.println("4.Participar en una subasta");
			System.out.println("5.Pedir mas cupo de compra");
			System.out.println("6.Mirar mi pieza ");
			System.out.println("7.Mirar info de pieza antigua");
			System.out.println("8.Añadir pieza a la galeria");
			System.out.println("9.Mirar historia de una pieza");
			System.out.println("10.Mirar historia de un artista");
			System.out.println("11.Salir al menu pricipal");
			int input= scanner.nextInt();
			scanner.nextLine();
			
			if (1==input) {
			
			}else if (2==input) {
				controler.verPiezasDisponibles(galeria, usuario);
			}else if (3==input) {
				controler.comprarPieza(galeria, usuario);
			}else if (4==input) {
				
			}else if (5==input) {
				controler.pedirCupoDeCompras(galeria, usuario);
			}else if(6==input) {
				controler.mirarMiPieza(galeria, usuario);
			}else if(7==input) {
				controler.mirarInfoDePiezaAntigua(galeria, usuario);
			}else if(8==input) {
				
			}else if(9==input) {
				controler.verHistoriaPieza(galeria, usuario);
			}else if(10==input){
				controler.mirarHistoriaArtista(galeria, usuario);
			}else if (11==input) {
				interfaz(galeria);
			}	
			else {
				System.out.println("Valor incorrecto");
			}
		}
		scanner.close();
	}
	
	public void interfazAdmin(Galeria galeria, Usuario usuario) {
		// se inicia centinela para salir de la galeria
		boolean seguir=true;
		System.out.println("bienvenido Administrador");
		Scanner scanner = new Scanner(System.in);
		Controller controler=new Controller();
		
		while(seguir) {
			System.out.println("//////////////////////////////////////7");
			System.out.println("Que desea realizar");
			System.out.println("");
			System.out.println("1.Verificar Ventas");
			System.out.println("2.Verificar seriedad de las ofertas");
			System.out.println("3.Validar piezas por aniadir");
			System.out.println("4.Verificar usuario para las subastas");
			System.out.println("5.Mirar historia de una pieza");
			System.out.println("6.Mirar historia de un artista");
			System.out.println("7.Mirar historia de un comprador");
			System.out.println("8.Salir al menu pricipal");
			int input= scanner.nextInt();
			scanner.nextLine();
			
			if (1==input) {
				controler.verificarVenta(galeria, usuario);
			}else if (2==input) {
				controler.verificarSeriedadDeOferta(galeria, usuario);
			}else if (3==input) {
				
			}else if (4==input) {
				//controler.verificarUsuarioSubasta(null);
			}else if(5==input) {
				controler.verHistoriaPieza(galeria, usuario);
			}else if(6==input) {
				controler.mirarHistoriaArtista(galeria, usuario);
			}else if(7==input) {
				controler.historiaComprador(galeria, usuario);
			}else if (8==input) {
				interfaz(galeria);
			}else {
				System.out.println("Valor incorrecto");
			}
		}
		scanner.close();
	}
	
	public void interfazCajero(Galeria galeria, Usuario usuario) {
		// se inicia centinela para salir de la galeria
		boolean seguir=true;
		System.out.println("bienvenido Cajero");
		Scanner scanner = new Scanner(System.in);
		Controller controler=new Controller();
		
		while(seguir) {
			System.out.println("//////////////////////////////////////7");
			System.out.println("Que desea realizar");
			System.out.println("");
			System.out.println("1.Verificar los pagos");
			System.out.println("2.Mirar historia de una pieza");
			System.out.println("3.Mirar historia de un artista");
			System.out.println("4.Salir al menu pricipal");
			
			int input= scanner.nextInt();
			scanner.nextLine();
			
			if (1==input) {
				controler.revisarPago(galeria, usuario);
			}else if(2==input) {
				controler.verHistoriaPieza(galeria, usuario);
			}else if(3==input){
				controler.mirarHistoriaArtista(galeria, usuario);
			}else if (4==input) {
				interfaz(galeria);
			}else {
				System.out.println("Valor incorrecto");
			}
		}
		scanner.close();
	}
	
	public void interfazOperador(Galeria galeria, Usuario usuario) {
		// se inicia centinela para salir de la galeria
		boolean seguir=true;
		System.out.println("bienvenido Operador");
		Scanner scanner = new Scanner(System.in);
		Controller controler=new Controller();
		
		while(seguir) {
			System.out.println("//////////////////////////////////////7");
			System.out.println("Que desea realizar");
			System.out.println("");
			System.out.println("1.Llevar registro de subastas");
			System.out.println("2.Mirar historia de una pieza");
			System.out.println("3.Mirar historia de un artista");
			System.out.println("4.Salir al menu pricipal");
			int input= scanner.nextInt();
			scanner.nextLine();
			
			if (1==input) {
				controler.llevarRegistroSubasta(galeria, usuario);
			}else if(2==input) {
				controler.verHistoriaPieza(galeria, usuario);
			}else if(3==input) { 
				controler.mirarHistoriaArtista(galeria, usuario);
			}else if (4==input) {
				interfaz(galeria);
			}else {
				System.out.println("Valor incorrecto");
			}
		}
		scanner.close();
	}
	

}
