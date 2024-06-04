package Interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import GaleriaEmpleados.Administrador;
import GaleriaEmpleados.Cajero;
import GaleriaEmpleados.Operador;
import GaleriaGestionSesion.Usuario;
import GaleriaModelo.Galeria;
import GaleriaServiciosDeAdquisicion.Precio;
import GaleriaServiciosDeAdquisicion.Subasta;

public class PanelSeriedadOferta extends JPanel implements ActionListener{
	JLabel label1;
	
	JFrame frame;
	Galeria galeria;
	Usuario usuario;
	
	Administrador admin;
	Cajero cajero;
	
	ArrayList<Subasta> subastas;

	public PanelSeriedadOferta(JFrame frame, Galeria galeria, Usuario usuario) {
		super();
		this.frame = frame;
		this.galeria = galeria;
		this.usuario = usuario;
		
		admin=(Administrador)galeria.getMapaUsuariosEmpleados().get("Administrador");
		cajero = (Cajero)galeria.getMapaUsuariosEmpleados().get("Cajero");
		subastas = galeria.getSubastasProgramadas();
		
		label1 = new JLabel();
		
		setLayout(new BorderLayout());
		setOpaque(true);
		setPreferredSize(new Dimension(500, 660));
		setVisible(true);
		
		label1.setText("Title");
		label1.setFont(new Font("arial", Font.BOLD, 20));
		label1.setHorizontalAlignment(SwingConstants.CENTER);
		label1.setPreferredSize( new Dimension(500, 100) );
		label1.setOpaque(true);
		label1.setBackground(new Color(25, 25, 112));
		label1.setForeground(Color.white);
		
		
		add(label1);
		
		operacion();
		
		frame.add(this, BorderLayout.EAST);
		revalidate();
		repaint();
	}
	
	public void operacion() {
		Scanner scanner= new Scanner(System.in);

		boolean seguir=true;
		System.out.println("Bienvenido al registro de subastas");
		int i=0;
		
		if (!subastas.isEmpty()) {
			label1.setText("Por el momento hay "+subastas.size() +" subastas"   );
			/*
			while(seguir) {
				
				System.out.println("Desea ver sus registros de la siguiente subasta");
				System.out.println("1.Si");
				System.out.println("2.No");
				int input= scanner.nextInt();
				scanner.nextLine();
				
				if(input==1 && i <subastas.size()) {
					ArrayList<Precio> registro=subastas.get(i).getRegistroSubasta();
					System.out.println("Subasta de "+ subastas.get(i).getPieza().getTitulo());
					System.out.println("asi a trascurrido la subasta");
					System.out.println("");
					for (Precio precio : registro) {
						System.out.println("Oferta: "+precio.getPrecio()+"--Usuario: "+((Usuario) precio.getUsuario()).getUsuario());				
					}
					i++;
				}else if(input==2) {
					seguir=false;
				}else {
					System.out.println("Valor Incorrecto");
				}
			}*/
		}else {
			label1.setText("No hay Subastas por el momento");
		}
		// Guardamos el registro de subastas en archivos Json
		//Gson gson = new Gson();
	    //String jsonAdministrador = gson.toJson(subastas);
		
		revalidate();
		repaint();
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
