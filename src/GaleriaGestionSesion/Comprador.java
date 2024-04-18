package GaleriaGestionSesion;

import java.util.ArrayList;

import GaleriaPieza.Pieza;

public class Comprador extends Usuario {
	
	private String IDENTIFICADOR = "COMPRADOR";
	private int maxCompras;
	private ArrayList<Pieza> compras; 

	public String getIDENTIFICADOR() {
		return IDENTIFICADOR;
	}

	public int getMaxCompras() {
		return maxCompras;
	}

	public ArrayList<Pieza> getCompras() {
		return compras;
	}

	public Comprador(String usuario, String contrasenia) {
		super(usuario, contrasenia);
		// TODO Auto-generated constructor stub
	}

}
