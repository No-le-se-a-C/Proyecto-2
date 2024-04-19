package GaleriaPieza;

import GaleriaGestionSesion.Artista;

public class Pintura extends Pieza{
	
	private int altura;
	private int ancho;
	private String estilo;

	public Pintura(String nTitulo, String nAnioCreacion, String nLugarCreacion, Artista nAutor, boolean nConsignacion,
			int[] nPrecio, boolean nSubasta, boolean exhibido, int nPrecioMinimo) {
		super(nTitulo, nAnioCreacion, nLugarCreacion, nAutor, nConsignacion, nPrecio, nSubasta, exhibido, nPrecioMinimo);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void getCaracteristicas() {
		// TODO Auto-generated method stub
		System.out.println("////////////////////////////////////////");
		System.out.println("");
		System.out.println("");
	}
	
	
}
