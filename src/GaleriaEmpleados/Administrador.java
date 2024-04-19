package GaleriaEmpleados;

import java.util.ArrayList;

import GaleriaGestionSesion.Usuario;
import GaleriaPieza.Pieza;

public class Administrador extends Usuario {
	
	private String IDENTIFICADOR="ADMINISTRADOR";
	private ArrayList<Pieza> piezasPorAnadir;
	
	public String getIDENTIFICADOR() {
		return IDENTIFICADOR;
	}
	
	public void SolicitudAnadirPieza(Pieza pieza) {
		piezasPorAnadir.add(pieza);
		
	}

	public Administrador(String usuario, String contraseña) {
		super(usuario, contraseña);
		piezasPorAnadir= new ArrayList<Pieza>();
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
