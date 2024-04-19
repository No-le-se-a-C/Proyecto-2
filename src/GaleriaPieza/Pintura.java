package GaleriaPieza;

import GaleriaGestionSesion.Artista;

public class Pintura extends Pieza{
	
	private String altura;
	private String ancho;
	private String estilo;

	public Pintura(String nTitulo, String nAnioCreacion, String nLugarCreacion, Artista nAutor, boolean nConsignacion,
			Object[] nPrecio, boolean nSubasta, boolean exhibido, int nPrecioMinimo, String altura, String ancho, String estilo) {
		super(nTitulo, nAnioCreacion, nLugarCreacion, nAutor, nConsignacion, nPrecio, nSubasta, exhibido, nPrecioMinimo);
		// TODO Auto-generated constructor stub
		this.altura=altura;
		this.ancho=ancho;
		this.estilo=estilo;
	}


	
}
