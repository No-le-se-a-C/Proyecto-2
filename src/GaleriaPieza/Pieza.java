package GaleriaPieza;

import GaleriaGestionSesion.Artista;

public class Pieza {

	
	private String titulo;
	private String lugarCreacion;
	private String anioCreacion;
	private Artista autor; // Estan deacuerdo con que el autor sea de tipo Artista?
	private boolean consignacion;
	private int precio;
	private boolean subasta;
	private int estado; // no sé a que se refiere esta atributo
	private boolean exhibido;
	
	public Pieza(String nTitulo, String nAnioCreacion, String nLugarCreacion, String nAutor, String nConsignacion, int nPrecio, boolean nSubasta, boolean exhibido) {
		
	}
	
	
	// Que caracteristicas? no tocaria hacer un metodo para gettear cada caracteristica?
	public String getCaracteristicas() {
		return anioCreacion;
		
	}
	
	public void nuevoPrecio(int monto) {
		
	}
	
}
