package GaleriaPieza;

import java.util.TreeSet;

import GaleriaGestionSesion.Artista;

public abstract class Pieza {

	
	private String titulo;
	private String lugarCreacion;
	private String anioCreacion;
	private Artista autor; // Estan deacuerdo con que el autor sea de tipo Artista?
	private boolean consignacion;
	private Object[] precio;
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


	public Object[] getPrecio() {
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
			Object[] nPrecio, boolean nSubasta, boolean exhibido, int nPrecioMinimo) {
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
	
	public void getCaracteristicas() {
		System.out.println("////////////////////////////////////////");
		System.out.println("");
		System.out.println("Estado de "+ titulo);
		System.out.println("");
		if(consignacion) {
			System.out.println("--Estado de consignacion: la Galeria todavia la tiene. ");
		}else {
			System.out.println("--Estado de consignacion: la Galeria ya se le acabo el periodo de tiempo");
		}
		System.out.println("--Precio actual: "+ precio[0]);
		
		
		if(exhibido) {
			System.out.println("La pieza se encuentra exhibida");
		}else {
			System.out.println("La pieza se encuentra en bodega");
		}
	}
	
	public void getCaracteristicasAntiguas() {
		System.out.println("////////////////////////////////////////");
		System.out.println("");
		System.out.println("Estado de "+ titulo);
		System.out.println("");
		
		System.out.println("--Estado de consignacion: Se acabo devido a la venta de esta ");
		
		
		System.out.println("--Precio final: "+ precio[0]);
		
		
		System.out.println("--la Pieza ya fue entregada al comprador");
	}
	
}
