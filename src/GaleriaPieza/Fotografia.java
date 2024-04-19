package GaleriaPieza;

import GaleriaGestionSesion.Artista;

public class Fotografia extends Pieza {
	
	private String filtro;
	private int cantidadPixeles;
	private String calidad;

	public Fotografia(String nTitulo, String nAnioCreacion, String nLugarCreacion, Artista nAutor, boolean nConsignacion,
			int[] nPrecio, boolean nSubasta, boolean exhibido, int nPrecioMinimo) {
		super(nTitulo, nAnioCreacion, nLugarCreacion, nAutor, nConsignacion, nPrecio, nSubasta, exhibido, nPrecioMinimo);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void getCaracteristicas() {
		// TODO Auto-generated method stub
		
	}
	

}
