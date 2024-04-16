package GaleriaPieza;

import GaleriaGestionSesion.Artista;

public class Pieza {

	
	private String titulo;
	private String lugarCreacion;
	private String anioCreacion;
	private Artista autor; // Estan deacuerdo con que el autor sea de tipo Artista?
	private boolean consignacion;
	private int precio;
	private boolean subasta; // Si subasta es Falso es una pieza de precio fijo
	private int estado; // no sé a que se refiere esta atributo
	private boolean exhibido;
	private int precioMinimo; //Es 0 si no es de una subasta	
	public Pieza(String nTitulo, String nAnioCreacion, String nLugarCreacion, String nAutor, String nConsignacion, int nPrecio, boolean nSubasta, boolean exhibido) {
		
	}
	
	
	public String getCaracteristicas() {
		return anioCreacion;
		
	}
	
	public void nuevoPrecio(int monto) {
		
	}
	
}
