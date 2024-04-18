package GaleriaGestionSesion;

import java.util.ArrayList;

import GaleriaPieza.Pieza;

public class Artista extends Usuario {
	
	private String IDENTIFICADOR = "ARTISTA";
	private ArrayList<Pieza> listaPiezas;
	
	
	public String getIDENTIFICADOR() {
		return IDENTIFICADOR;
	}

	public ArrayList<Pieza> getListaPiezas() {
		return listaPiezas;
	}

	public Artista(String usuario, String contrasenia) {
		super(usuario, contrasenia);
		// TODO Auto-generated constructor stub
	}

	public void subirPieza(String nTitulo, int nAnioCreacion, int nPrecio, int nSubasta) {
		
	}

}
