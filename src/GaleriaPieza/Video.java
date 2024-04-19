package GaleriaPieza;

import GaleriaGestionSesion.Artista;

public class Video extends Pieza{
	
	private String duracion;
	private String formato;
	private String estilo;

	public Video(String nTitulo, String nAnioCreacion, String nLugarCreacion, Artista nAutor, boolean nConsignacion,
			Object[] nPrecio, boolean nSubasta, boolean exhibido, int nPrecioMinimo, String duracion,String formato,String estilo) {
		super(nTitulo, nAnioCreacion, nLugarCreacion, nAutor, nConsignacion, nPrecio, nSubasta, exhibido,nPrecioMinimo);
		// TODO Auto-generated constructor stub
		this.duracion=duracion;
		this.estilo=estilo;
		this.formato=formato;
	}


}
