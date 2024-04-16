package GaleriaGestionSesion;

import GaleriaPieza.Pieza;

public class Artista extends Usuario {
	
	private String IDENTIFICADOR = "ARTISTA";
	private Pieza[] listaPiezas;
	
	
	public Artista(String nombre, String contrasenia) {
		super(nombre, contrasenia);
		// TODO Auto-generated constructor stub
	}

	public void subirPieza(String nTitulo, int nAnioCreacion, int nPrecio, int nSubasta) {
		
	}

}
