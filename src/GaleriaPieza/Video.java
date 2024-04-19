package GaleriaPieza;

import GaleriaGestionSesion.Artista;

public class Video extends Pieza{
	
	private int duracion;
	private String formato;
	private String estilo;

	public Video(String nTitulo, String nAnioCreacion, String nLugarCreacion, Artista nAutor, boolean nConsignacion,
			int[] nPrecio, boolean nSubasta, boolean exhibido, int nPrecioMinimo) {
		super(nTitulo, nAnioCreacion, nLugarCreacion, nAutor, nConsignacion, nPrecio, nSubasta, exhibido,nPrecioMinimo);
		// TODO Auto-generated constructor stub
	}


}
