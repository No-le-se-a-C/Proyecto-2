package GaleriaModelo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import GaleriaGestionSesion.Usuario;
import GaleriaServiciosDeAdquisicion.Subasta;

public class Galeria {
	
	private ArrayList<Subasta> SubastasProgramadas;
	
	private HashMap<String, Usuario> mapaUsuarios;
	
	private HashMap<String, Usuario> mapaUsuariosEmpleados;
	
	private Inventario inventario;
	
	
	public Galeria(Inventario inventario) {
		this.SubastasProgramadas= new ArrayList<Subasta>();
		this.mapaUsuarios= new HashMap<String, Usuario>();
		this.mapaUsuariosEmpleados= new HashMap<String, Usuario>();
	}
	
	
	
	public Inventario getInventario() {
		return inventario;
	}


	public void participarSubasta() {
		
	}
	

	public HashMap<String, Usuario> getListaUsuariuos() {
		return mapaUsuarios;
	}

	public ArrayList<Subasta> getSubastasProgramadas() {
		return SubastasProgramadas;
	}

	public HashMap<String, Usuario> getMapaUsuariosEmpleados() {
		return mapaUsuariosEmpleados;
	}

	public void comprarPieza() {
		
	}
	
	public void mirarMiPieza() {
		
	}
	
	public void mirarInfoDePiezaAntigua() {
		
	}
	
	public void aniadirUsuario(Usuario usuario) {
		mapaUsuarios.put(usuario.getUsuario(), usuario);
	}
	
	public void aniadirUsuarioEmpleado(Usuario usuario) {
		mapaUsuariosEmpleados.put(usuario.getUsuario(), usuario);
	}
	
	public void aniadirSubasta(Subasta subasta) {
		
	}
	
	

}
