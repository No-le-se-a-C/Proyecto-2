package GaleriaServiciosDeAdquisicion;

import GaleriaGestionSesion.Usuario;

public class Precio {
	private int precio;
	private Usuario usuario;
	
	public void setPrecio(int precio) {
		this.precio = precio;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public int getPrecio() {
		return precio;
	}
	public Usuario getUsuario() {
		return usuario;
	}
}
