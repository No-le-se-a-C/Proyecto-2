package GaleriaPieza;

import GaleriaGestionSesion.Artista;
import GaleriaServiciosDeAdquisicion.Precio;

public class Escultura extends Pieza {
	
	private String material;
	private String altura;
	private String ancho;

	public Escultura(String nTitulo, String nAnioCreacion, String nLugarCreacion, Artista nAutor, boolean nConsignacion,
			Precio nPrecio, boolean nSubasta, boolean exhibido, int nPrecioMinimo, String nMaterial, String nAltura, String nAncho) {
		super(nTitulo, nAnioCreacion, nLugarCreacion, nAutor, nConsignacion, nPrecio, nSubasta, exhibido, nPrecioMinimo);
		
		this.altura=nAltura;
		
		this.ancho=nAncho;
		
		this.material=nMaterial;
	}


}
