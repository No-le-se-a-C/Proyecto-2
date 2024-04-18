package GaleriaEmpleados;

import GaleriaGestionSesion.Usuario;
import GaleriaServiciosDeAdquisicion.Compra;

public class Cajero extends Usuario{
	private String IDENTIFICADOR="CAJERO";
	
	public String getIDENTIFICADOR() {
		return IDENTIFICADOR;
	}
	
	public Cajero(String usuario, String contraseña) {
		super(usuario, contraseña);
	}	
	
	public void revisarPago(Compra comprador) {
		
		
	}

}
