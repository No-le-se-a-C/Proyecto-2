package GaleriaPieza;

import GaleriaGestionSesion.Artista;

public class Escultura extends Pieza {
	
	private String material;
	private int altura;
	private int ancho;

	public Escultura(String nTitulo, String nAnioCreacion, String nLugarCreacion, Artista nAutor, boolean nConsignacion,
			int[] nPrecio, boolean nSubasta, boolean exhibido, int nPrecioMinimo, String nMaterial, int nAltura, int nAncho) {
		super(nTitulo, nAnioCreacion, nLugarCreacion, nAutor, nConsignacion, nPrecio, nSubasta, exhibido, nPrecioMinimo);
		
		this.altura=nAltura;
		
		this.ancho=nAncho;
		
		this.material=nMaterial;
	}

	@Override
	public void getCaracteristicas() {
		// TODO Auto-generated method stub
		
	}

}
