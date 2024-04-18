package GaleriaModelo;

import java.util.ArrayList;

import GaleriaGestionSesion.Artista;
import GaleriaPieza.Pieza;

public class Inventario {
	
	private ArrayList<Pieza> piezas;
	private ArrayList<Pieza> infoPiezasAntiguas; 
	
	public Inventario() {
		piezas= new ArrayList<Pieza>();
		infoPiezasAntiguas= new ArrayList<Pieza>();
	}
	
	public Pieza buscarPieza(String nTitulo, Artista nAutor) {
		return null;
		
	}
	
	// Hace referencia a las piezas que ya se vendieron sale de infoPiezasAntiguas
	public void buscarInfoPiezaAntigua(String nTitulo, Artista nAutor) {
		
	}
	
	//Sale de pieza
	public String getPiezasPrecioFijo() {
		return null;
		
	}
	
	public String getinfoPiezasSubasta() {
		return null;
		
	}


	
	public ArrayList<Pieza> getPiezas() {
		return piezas;
	}

	public ArrayList<Pieza> getInfoPiezasAntiguas() {
		return infoPiezasAntiguas;
	}

	public void aniadirPieza(Pieza pieza) {
		
	}
	
	public void eliminarPieza(String nTitulo, Artista autor) {
		
	}
	
}
