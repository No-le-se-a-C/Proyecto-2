package GaleriaPieza;

import GaleriaGestionSesion.Artista;
import GaleriaServiciosDeAdquisicion.Precio;

public class Fotografia extends Pieza {
	
	private String filtro;
	private String cantidadPixeles;
	private String calidad;

	public Fotografia(String nTitulo, String nAnioCreacion, String nLugarCreacion, Artista nAutor, boolean nConsignacion,
			Precio nPrecio, boolean nSubasta, boolean exhibido, int nPrecioMinimo,String filtro,  String cantidadPixeles,String calidad) {
		super(nTitulo, nAnioCreacion, nLugarCreacion, nAutor, nConsignacion, nPrecio, nSubasta, exhibido, nPrecioMinimo);
		// TODO Auto-generated constructor stub
		this.calidad=calidad;
		this.cantidadPixeles=cantidadPixeles;
		this.filtro=filtro;
	}

	public String getFiltro() {
		return filtro;
	}

	public void setFiltro(String filtro) {
		this.filtro = filtro;
	}

	public String getCantidadPixeles() {
		return cantidadPixeles;
	}

	public void setCantidadPixeles(String cantidadPixeles) {
		this.cantidadPixeles = cantidadPixeles;
	}

	public String getCalidad() {
		return calidad;
	}

	public void setCalidad(String calidad) {
		this.calidad = calidad;
	}


	

}
