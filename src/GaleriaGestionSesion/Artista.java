package GaleriaGestionSesion;

import java.util.ArrayList;

import GaleriaPieza.Pieza;

public class Artista extends Usuario {
	
	private String IDENTIFICADOR = "ARTISTA";
	private ArrayList<Pieza> listaPiezas;
	private int maxCompras;
	private ArrayList<Pieza> compras; 
	private boolean admitido;

	
	public int getMaxCompras() {
		return maxCompras;
	}

	public ArrayList<Pieza> getCompras() {
		return compras;
	}

	public String getIDENTIFICADOR() {
		return IDENTIFICADOR;
	}

	public ArrayList<Pieza> getListaPiezas() {
		return listaPiezas;
	}
	
	public boolean getAdmitido() {
		return admitido;
	}
	
	public void definirMaximoCompras( int maximo ) {
		this.maxCompras = maximo;
		
	}

	public Artista(String usuario, String contrasenia) {
		super(usuario, contrasenia);
		// TODO Auto-generated constructor stub
	}

	public void subirPieza(String nTitulo, int nAnioCreacion, int nPrecio, int nSubasta) {
		
	}
	

}
