package GaleriaGestionSesion;

import java.util.List;

public abstract class Usuario {
	
	private String usuario;
	private String contrasenia;
	private List listaAdquisiciones[]; // No estoy seguro de si esta es la lista que necesitamos
	private String metodoPago;
	private int cartera;
	
	public Usuario(String nombre, String contrasenia) {
		
	}
	
	public void definirMetodoPago() {
		
	}

}
