package GaleriaEmpleados;

import GaleriaGestionSesion.Usuario;
import GaleriaPieza.Pieza;

public class Administrador extends Usuario {
	
	private String IDENTIFICADOR="ADMINISTRADOR";
	
	public String getIDENTIFICADOR() {
		return IDENTIFICADOR;
	}

	public Administrador(String usuario, String contraseña) {
		super(usuario, contraseña);
	}
	
	public void verificarVenta() {
		
	}
	
	public void verificarSeriedadDeOferta() {
		
	}
	
	public void validarAniadirPieza(String nTitulo, int nAnioCreacion, int nPrecio, int nSubasta) {
		
	}
	
	public Boolean verificarUsuarioSubasta(Pieza usuario) {
		return null;
		
	}

}
