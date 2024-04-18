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
	
	public void definirMetodoPago(Galeria galeria, Usuario usuario) {
		
	}
	
	public void participarSubasta(Galeria galeria, Usuario usuario) {
		
	}
	
	public void comprarPieza(Galeria galeria, Usuario usuario) {
		
	}
	
	public void verPiezasDisponibles(Galeria galeria, Usuario usuario) {
		
	}
	
	public void mirarMiPieza(Galeria galeria, Usuario usuario) {
		
	}
	
	public void mirarInfoDePiezaAntigua(Galeria galeria, Usuario usuario) {
		
		
	}
	
	public void aniadirPieza() {
		
	}
	
	public void pedirCupoDeCompras(Galeria galeria, Usuario usuario) {
		
	}
	
	public void verificarVenta(Galeria galeria, Usuario usuario) {
		
	}
	
	public void verificarSeriedadDeOferta(Galeria galeria, Usuario usuario) {
		
	}
	
	public Boolean verificarUsuarioSubasta(Pieza usuario) {
		return null;
		
	}
	
	public void revisarPago(Compra comprador) {
		
	}
	
	public void llevarRegistroSubasta() {
		
	}
	
	public void validarPiezasPorAniadir(Galeria galeria, Usuario usuario) {
		
	}
	

}