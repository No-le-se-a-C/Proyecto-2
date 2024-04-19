package GaleriaPieza;

import GaleriaGestionSesion.Artista;

public abstract class Pieza {

	
	private String titulo;
	private String lugarCreacion;
	private String anioCreacion;
	private Artista autor; // Estan deacuerdo con que el autor sea de tipo Artista?
	private boolean consignacion;
	private int[] precio;
	private boolean subasta; // Si subasta es Falso es una pieza de precio fijo
	private int estado; // no sé a que se refiere esta atributo
	private boolean exhibido;
	private int precioMinimo;
	
	
	public String getLugarCreacion() {
		return lugarCreacion;
	}


	public String getAnioCreacion() {
		return anioCreacion;
	}


	public Artista getAutor() {
		return autor;
	}


	public boolean isConsignacion() {
		return consignacion;
	}


	public int[] getPrecio() {
		return precio;
	}


	public boolean isSubasta() {
		return subasta;
	}


	public int getEstado() {
		return estado;
	}


	public boolean isExhibido() {
		return exhibido;
	}


	public int getPrecioMinimo() {
		return precioMinimo;
	}
	
	public String getTitulo() {
		return titulo;
	}


	public Pieza(String nTitulo, String nAnioCreacion, String nLugarCreacion, Artista nAutor, boolean nConsignacion, 
			int[] nPrecio, boolean nSubasta, boolean exhibido, int nPrecioMinimo) {
		titulo=nTitulo;
		anioCreacion=nAnioCreacion;
		lugarCreacion=nLugarCreacion;
		autor=nAutor;
		consignacion=nConsignacion;
		precio=nPrecio;
		subasta=nSubasta;
		this.exhibido=exhibido;
		precioMinimo=nPrecioMinimo;
	}
	
	
	public void nuevoPrecio(int monto) {
		
	}
	public abstract void getCaracteristicas();
}
