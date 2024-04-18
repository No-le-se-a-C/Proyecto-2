package GaleriaConsola;

import GaleriaGestionSesion.Sesion;
import GaleriaGestionSesion.Usuario;
import GaleriaModelo.Galeria;
import GaleriaPieza.Pieza;
import GaleriaServiciosDeAdquisicion.Compra;

public class Controller {
	
	public void registrase(Galeria galeris) {
		Sesion sesion= new Sesion();
		sesion.registrarse(galeris);
	}
	
	public Usuario iniciarSesion(Galeria galeria) {
		Sesion sesion= new Sesion();
		return sesion.iniciarSesion(galeria);
	}
	
	public void definirMetodoPago() {
		
	}
	
	public void participarSubasta() {
		
	}
	
	public void comprarPieza() {
		
	}
	
	public void verPiezasDisponibles() {
		
	}
	
	public void mirarMiPieza() {
		
	}
	
	public void mirarInfoDePiezaAntigua() {
		
		
	}
	
	public void aniadirPieza(String nTitulo, int nAnioCreacion, int nPrecio, int nSubasta) {
		
	}
	
	public void pedirCupoDeCompras() {
		
	}
	
	public void verificarVenta() {
		
	}
	
	public void verificarSeriedadDeOferta() {
		
	}
	
	public Boolean verificarUsuarioSubasta(Pieza usuario) {
		return null;
		
	}
	
	public void revisarPago(Compra comprador) {
		
	}
	
	public void llevarRegistroSubasta() {
		
	}
	

}