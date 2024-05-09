package GaleriaServiciosDeAdquisicion;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

import GaleriaGestionSesion.Usuario;
import GaleriaModelo.Galeria;
import GaleriaPieza.Pieza;

public class Subasta {
	
	private Pieza pieza;
	private boolean subastaActiva;
	private LocalDate fechaFinal;
	private ArrayList<Precio> registroSubasta;
	
	
	public Subasta(Pieza pieza, LocalDate fechaFinal) {
		this.pieza=pieza;
		this.fechaFinal=fechaFinal;
		this.registroSubasta=new ArrayList<Precio>();
	}
		
	
	public Pieza getPieza() {
		return pieza;
	}

	public LocalDate getFechaFinal() {
		return fechaFinal;
	}
	public void anadirRegistroSubasta(Precio precio) {
		registroSubasta.add(precio);
	}


	public boolean isSubastaActiva() {
		return subastaActiva;
	}


	public ArrayList<Precio> getRegistroSubasta() {
		return registroSubasta;
	}



}
