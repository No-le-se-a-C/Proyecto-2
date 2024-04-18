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
	
	public void interfazComprador(Galeria galeria, Usuario usuario) {
		// se inicia centinela para salir de la galeria
		boolean seguir=true;
		System.out.println("bienvenido Comprador");
	}
	
	public void interfazPropietario(Galeria galeria, Usuario usuario) {
		// se inicia centinela para salir de la galeria
		boolean seguir=true;
		System.out.println("bienvenido Artista");
	}
	
	public void interfazAdmin(Galeria galeria, Usuario usuario) {
		// se inicia centinela para salir de la galeria
		boolean seguir=true;
		System.out.println("bienvenido Administrador");
	}
	
	public void interfazCajero(Galeria galeria, Usuario usuario) {
		// se inicia centinela para salir de la galeria
		boolean seguir=true;
		System.out.println("bienvenido Cajero");
	}
	
	public void interfazOperador(Galeria galeria, Usuario usuario) {
		// se inicia centinela para salir de la galeria
		boolean seguir=true;
		System.out.println("bienvenido Operador");
	}
	

}
