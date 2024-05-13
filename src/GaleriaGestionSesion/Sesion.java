package GaleriaGestionSesion;

import java.util.InputMismatchException;
import java.util.Scanner;

import GaleriaModelo.Galeria;

public class Sesion {
	
	/* 
	 * Param Galeria galeria
	 * return void
	 
 	Esta funcion pregunta al usuario que cuenta quiere tener si una 
 	de artista o comprador ya que cada una tiene diferentes funcionalidades 
 	y verifica si el nombre de usuario que brinda el usuario ya existe o no
 	si no existe le pregunta la contraseña y crea el usuario y se añade el 
 	usuario al mapa de usuarios de la galeria
	*/
	public void registrarse(Galeria galeria) {
		Scanner scanner = new Scanner(System.in);

		// se inicia centinela para registro
		boolean seguir = true;

		//empieza el proceso de registro
		while (seguir) {
		    System.out.println("///////////////////////////////////////////////////////////////////////////");
		    System.out.println("Bienvenido al sistema de registro de sesión.");
		    System.out.println("¿Eres comprador o artista?");
		    System.out.println("1. Comprador");
		    System.out.println("2. Artista");
		    System.out.println("3. Salir del registro");
		    System.out.print("Por favor selecciona una opción (1/2/3): ");

		    int opcion = 0;
		    // Verificar si hay un entero disponible
		    if (scanner.hasNextInt()) {
		        opcion = scanner.nextInt();
		        scanner.nextLine(); 
		    } else {
		        System.out.println("Por favor ingresa un número entero válido.");
		        scanner.nextLine(); // Limpiar el buffer de entrada
		        continue; // Volver al principio del bucle
		    }

		    if (opcion == 1) {
		        //registro para compradores
		        System.out.println("¡Bienvenido comprador!");
		        //se pregunta qué nombre de usuario quiere el usuario
		        System.out.println("Por favor introduce tu nombre de usuario: ");
		        String nombreUsuario = scanner.nextLine();
		        // se revisa si el usuario ya existe
		        if (galeria.getListaUsuariuos().containsKey(nombreUsuario)) {
		            System.out.println("El usuario ya existe. Por favor inicia sesión con tu contraseña.");
		        } else {
		            System.out.println("Por favor crea una nueva contraseña: ");
		            String nuevaContraseña = scanner.nextLine();

		            Comprador usuarioComprador = new Comprador(nombreUsuario, nuevaContraseña);
		            // se añade un usuario Comprador a la lista de usuarios
		            galeria.aniadirUsuario(usuarioComprador);
		            System.out.println("Registro exitoso. Ahora puedes iniciar sesión con tu nuevo nombre de usuario y contraseña.");

		            //se acaba el registro
		            seguir = false;
		        }
		    } else if (opcion == 2) {
		        //registro para artistas
		        System.out.println("¡Bienvenido artista!");
		        //se pregunta qué nombre de usuario quiere el usuario
		        System.out.println("Por favor introduce tu nombre de usuario: ");
		        String nombreUsuario = scanner.nextLine();
		        // se revisa si el usuario ya existe
		        if (galeria.getListaUsuariuos().containsKey(nombreUsuario)) {
		            System.out.println("El usuario ya existe. Por favor inicia sesión con tu contraseña.");
		        } else {
		            System.out.println("Por favor crea una nueva contraseña: ");
		            String nuevaContraseña = scanner.nextLine();

		            Artista usuarioArtista = new Artista(nombreUsuario, nuevaContraseña);
		            // se añade un usuario artista a la lista de usuarios
		            galeria.aniadirUsuario(usuarioArtista);
		            System.out.println("Registro exitoso. Ahora puedes iniciar sesión con tu nuevo nombre de usuario y contraseña.");

		            //se acaba el registro
		            seguir = false;
		        }
		    } else if (opcion == 3) {
		        seguir = false;
		    } else {
		        System.out.println("Opción inválida. Por favor selecciona 1 para comprador o 2 para artista.");
		    }
		}

	}
	
	/*
	 * Param Galeria galeria
	 * return usuario------> que coincide con el usuario y contraseña dados por el usuario
	 
	  esta funcion se llama despues de haber hecho el registro y lo que hace es 
	  preguntar el usuario y contraseña  y si coinciden con alguno del mapa de usuarios 
	  retorna la instancia de usuario de este mapa el cual seria el valor 
	*/
	
	public Usuario iniciarSesion(Galeria galeria) {
		//este es el usuario a retornar que se actualizara despues 
		Usuario usuario=null;
		//se inicia el scanner para inputs
		Scanner scanner = new Scanner(System.in);
				
		// se inicia centinela para inicio de sesion 
		boolean seguir=true;

		while(seguir) {
			System.out.println("Bienvenido al sistema de inicio de sesión.");
			System.out.println("¿Desea iniciar sesión como Empleado o Usuario?");
	        System.out.println("1. Empleado");
	        System.out.println("2. Usuario");
	        System.out.println("3. salir");
	        System.out.print("Por favor selecciona una opción (1/2/3): ");

	        int opcion = scanner.nextInt();
	        scanner.nextLine(); // Limpiar el buffer de entrada

	        if (opcion == 1) {
	            // Iniciar sesión como Empleado
	            System.out.println("Has seleccionado iniciar sesión como Empleado.");
	            System.out.println("Usuario:");
				String nombreUsuario = scanner.nextLine();
				System.out.println("contraseña:");
				String contrasenia = scanner.nextLine();
				//se verifica si existe el usuario en la lista de usuarios
				if (galeria.getMapaUsuariosEmpleados().containsKey(nombreUsuario)) {
					//se verifica contraseña
					if (galeria.getMapaUsuariosEmpleados().get(nombreUsuario).getContrasenia().equals(contrasenia)) {
						//se encontro el usuario que coincide con usuario y contraseña
						usuario=galeria.getMapaUsuariosEmpleados().get(nombreUsuario);
						System.out.println("ha iniciado sesión exitosamente");
						seguir=false;
					}else {
						System.out.println("Contraseña incorrecta");
					}
				}else {
					//si no existe el usuario entonces se le da la opcion de registrarlo
					System.out.println("Este usuario no existe");
					System.out.println("");
					System.out.println("Desea hacer el registro (el registro de usuario no empleado) (SI/NO)");
					String rta = scanner.nextLine();
					if (rta.equalsIgnoreCase("si")) {
						registrarse(galeria);
					}
				}
	        } else if (opcion == 2) {
	            // Iniciar sesión como Usuario
	            System.out.println("Has seleccionado iniciar sesión como Usuario.");
	            System.out.println("Usuario:");
				String nombreUsuario = scanner.nextLine();
				System.out.println("contraseña:");
				String contrasenia = scanner.nextLine();
				//se verifica si existe el usuario en la lista de usuarios
				if (galeria.getListaUsuariuos().containsKey(nombreUsuario)) {
					//se verifica contraseña
					if (galeria.getListaUsuariuos().get(nombreUsuario).getContrasenia().equals(contrasenia)) {
						//se encontro el usuario que coincide con usuario y contraseña
						usuario=galeria.getListaUsuariuos().get(nombreUsuario);
						System.out.println("ha iniciado sesión exitosamente");
						seguir=false;
					}else {
						System.out.println("Contraseña incorrecta");
					}
				}else {
					//si no existe el usuario entonces se le da la opcion de registrarlo
					System.out.println("Este usuario no existe");
					System.out.println("");
					System.out.println("Desea hacer el registro (SI/NO)");
					String rta = scanner.nextLine();
					if (rta.toLowerCase()=="si") {
						registrarse(galeria);
					}
				}
	        }else if(opcion==3){
	        	seguir=false;
	        	
	        }else {
	            System.out.println("Opción inválida. Por favor selecciona 1 para Empleado o 2 para Usuario.");
	        }
	        
			
		}
		return usuario; 
	}

}
