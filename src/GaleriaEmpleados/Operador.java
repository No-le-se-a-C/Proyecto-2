package GaleriaEmpleados;

import GaleriaGestionSesion.Usuario;

public class Operador extends Usuario {
	private String IDENTIFICADOR="OPERADOR";
	
	public String getIDENTIFICADOR() {
		return IDENTIFICADOR;
	}
	
	public Operador(String usuario, String contraseña) {
		super(usuario, contraseña);
	}
	
	public void llevarResgistroSubasta() {
		
	}

}
