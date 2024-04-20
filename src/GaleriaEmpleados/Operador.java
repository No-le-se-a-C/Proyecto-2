package GaleriaEmpleados;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import GaleriaGestionSesion.Usuario;
import GaleriaModelo.Galeria;
import com.google.gson.Gson;
import GaleriaServiciosDeAdquisicion.Subasta;

public class Operador extends Usuario {
	private String IDENTIFICADOR="OPERADOR";
	
	public String getIDENTIFICADOR() {
		return IDENTIFICADOR;
	}
	
	public Operador(String usuario, String contraseña) {
		super(usuario, contraseña);
	}
	
	public void llevarResgistroSubasta(Galeria galeria, Usuario usuario) {
		Scanner scanner= new Scanner(System.in);
		ArrayList<Subasta> subastas=galeria.getSubastasProgramadas();
		boolean seguir=true;
		System.out.println("Bienvenido al registro de subastas");
		int i=0;
		
		if (!subastas.isEmpty()) {
			System.out.println("");
			System.out.println("Por el momento hay "+subastas.size() +" de subastas"   );
			while(seguir) {
				
				System.out.println("Desea ver sus registros de la siguiente subasta");
				System.out.println("1.Si");
				System.out.println("2.No");
				int input= scanner.nextInt();
				scanner.nextLine();
				
				if(input==1 && i <subastas.size()) {
					ArrayList<Object[]> registro=subastas.get(i).getRegistroSubasta();
					System.out.println("Subasta de "+ subastas.get(i).getPieza().getTitulo());
					System.out.println("asi a trascurrido la subasta");
					System.out.println("");
					for (Object[] precio : registro) {
						System.out.println("Oferta: "+precio[0]+"--Usuario: "+((Usuario) precio[1]).getUsuario());				
					}
					i++;
				}else if(input==2) {
					seguir=false;
				}else {
					System.out.println("Valor Incorrecto");
				}
			}
		}else {
			System.out.println("No hay Subastas por el momento");
		}
		
		
		
		
		// Guardamos el registro de subastas en archivos Json
		Gson gson = new Gson();
	    String jsonAdministrador = gson.toJson(subastas);
		
	
	}

}
