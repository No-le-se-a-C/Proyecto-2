package GaleriaServiciosDeAdquisicion;

import GaleriaGestionSesion.Usuario;
import GaleriaPieza.Pieza;

public class Compra {
	
	private Pieza pieza;
	private int valorPagado;
	private Usuario usuarioComprador;
	
	
	public Compra(Pieza pieza, int valorPagado, Usuario usuarioComprador) {
		this.pieza=pieza;
		this.valorPagado=valorPagado;
		this.usuarioComprador=usuarioComprador;
		
	}
	
	public boolean comprar() {
		return false;
		
	}

}
