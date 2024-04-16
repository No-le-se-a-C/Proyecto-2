package GaleriaModelo;

import GaleriaGestionSesion.Artista;
import GaleriaPieza.Pieza;

public class Inventario {
	
	private Pieza[] piezas; // Cambiar a Array list
	private String infoPiezasAntiguas; // Cambiar a Array list
	
	public Inventario() {
		
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
		return infoPiezasAntiguas;
		
	}

	public void getPiezas() {
		
	}

	//Creo que deberia haber un atributo el cual gettear.
	public void getInformacionPiezasAntiguas() {
		
	}
	
	public void aniadirPieza(Pieza pieza) {
		
	}
	
	public void eliminarPieza(String nTitulo, Artista autor) {
		
	}
	
}
