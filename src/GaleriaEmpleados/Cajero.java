package GaleriaEmpleados;

import java.util.ArrayList;
import java.util.Scanner;

import GaleriaGestionSesion.Usuario;
import GaleriaPieza.Pieza;
import GaleriaServiciosDeAdquisicion.Compra;

public class Cajero extends Usuario{
	private String IDENTIFICADOR="CAJERO";
	private ArrayList<Usuario> pagosPendientes = new ArrayList<Usuario>();
	
	public String getIDENTIFICADOR() {
		return IDENTIFICADOR;
	}
	public ArrayList<Usuario> getPagosPendientes(){
		return pagosPendientes;
	}
	
	public Cajero(String usuario, String contraseña) {
		super(usuario, contraseña);
	}	
	
	public boolean revisarPago(Usuario userPago) {
		//Retorna un valor booleano si una solicitud de pago de un usuario de entrada fue admitida
		Scanner scanner=new Scanner(System.in);
		
		//Muestra informacion del comprador al cajero
		System.out.println("Nombre de usuario: "+userPago.getUsuario());
		System.out.println("Lista de adquisiciones: ");
		for (Pieza adquisicion: userPago.getListaAdquisiciones()) {
			System.out.println("- " + adquisicion.getTitulo());
		}
		System.out.println("Metodo de pago: "+ userPago.getMetodoPago());
		System.out.println("Cartera: "+userPago.getCartera());
		
		System.out.println("\nDesea admitir la compra de este usuario?(SI/NO): ");
		String respuesta = scanner.nextLine();
		if (respuesta.equalsIgnoreCase("si")) {
			return true;
		}
		return false;
	}
}
