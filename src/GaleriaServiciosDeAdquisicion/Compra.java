package GaleriaServiciosDeAdquisicion;

import java.time.LocalDate;

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


	public Pieza getPieza() {
		return pieza;
	}


	public int getValorPagado() {
		return valorPagado;
	}


	public Usuario getUsuarioComprador() {
		return usuarioComprador;
	}
	
	

}
