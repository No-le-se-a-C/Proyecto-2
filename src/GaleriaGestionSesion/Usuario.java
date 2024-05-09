package GaleriaGestionSesion;

import java.util.ArrayList;
import java.util.List;

import GaleriaPieza.Pieza;

public abstract class Usuario {
	
	private String usuario;
	private String contrasenia;
	private ArrayList<Pieza> listaAdquisiciones; 
	private String metodoPago;
	private int cartera;
	
	public Usuario(String usuario, String contrasenia) {
		this.usuario=usuario;
		this.contrasenia=contrasenia;
		this.listaAdquisiciones=new ArrayList<Pieza>();
	}
	
	
	
	public String getUsuario() {
		return usuario;
	}



	public String getContrasenia() {
		return contrasenia;
	}



	public ArrayList<Pieza>  getListaAdquisiciones() {
		return listaAdquisiciones;
	}



	public String getMetodoPago() {
		return metodoPago;
	}



	public int getCartera() {
		return cartera;
	}



	public void definirMetodoPago( String metodoPago ) {
		this.metodoPago = metodoPago;
	}
	
	public void definirCartera( int cantidad ) {
		this.cartera = cantidad;
	}
	
	public void gastado(int pago) {
		this.cartera=this.cartera-pago;
	}
	
	public void anadirAdquisicion(Pieza pieza ) {
		listaAdquisiciones.add(pieza);
	}
	
	public abstract String getIDENTIFICADOR();
	
	
}
