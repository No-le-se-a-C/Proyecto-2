package Interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JButton;
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
	
	JButton si;

	public PanelSeriedadOferta(JFrame frame, Galeria galeria, Usuario usuario) {
		super();
		this.frame = frame;
		this.galeria = galeria;
		this.usuario = usuario;
		
		admin=(Administrador)galeria.getMapaUsuariosEmpleados().get("Administrador");
		cajero = (Cajero)galeria.getMapaUsuariosEmpleados().get("Cajero");
		subastas = galeria.getSubastasProgramadas();
		
		label1 = new JLabel();
		
		si = new JButton();
		si.setText("SI");
		si.addActionListener(this);
		si.setPreferredSize( new Dimension(70,40) );
		operacion();
	}
	
	public void operacion() {
		frame.dispose();
		this.frame = new InterfazMenu(usuario, galeria);
		
		setLayout(new BorderLayout());
		setOpaque(true);
		setPreferredSize(new Dimension(500, 660));
		setVisible(true);
		
		JLabel pregunta = new JLabel();
		
		label1.setText("Title");
		label1.setFont(new Font("arial", Font.BOLD, 20));
		label1.setHorizontalAlignment(SwingConstants.CENTER);
		label1.setPreferredSize( new Dimension(500, 100) );
		label1.setOpaque(true);
		label1.setBackground(new Color(25, 25, 112));
		label1.setForeground(Color.white);
		add(label1, BorderLayout.CENTER);
		
		if (!subastas.isEmpty()) {
			label1.setText("Por el momento hay "+subastas.size() +" subasta(s)"   );
				
				pregunta.setText("Desea ver sus registros de la siguiente subasta?");
				
				JPanel labelSouth = new JPanel();
				labelSouth.setLayout( new BorderLayout() );
				
				labelSouth.add(pregunta,BorderLayout.CENTER);
				labelSouth.add(si, BorderLayout.EAST);
				add(labelSouth, BorderLayout.SOUTH);
				
			//}
		}else {
			label1.setText("No hay Subastas por el momento");
		}
		// Guardamos el registro de subastas en archivos Json
		//Gson gson = new Gson();
	    //String jsonAdministrador = gson.toJson(subastas);
		
		
		frame.getContentPane().add(this, BorderLayout.EAST);
		frame.add(this, BorderLayout.EAST);
		frame.revalidate();
		frame.repaint();
		frame.setVisible(true);
		
	}
	
	public void respuestaPregunta() {
		remove(0);
		remove(0);
		int i = 0;
		
		JPanel panelCentro = new JPanel();
		JLabel tituloSubasta = new JLabel();
		JLabel message1 = new JLabel();
		
		panelCentro.setLayout( new GridLayout(4,1) );
		panelCentro.add(tituloSubasta);
		panelCentro.add(message1);
		
		if( i <subastas.size()) {
			ArrayList<Precio> registro= subastas.get(i).getRegistroSubasta();
			tituloSubasta.setText("Subasta de "+ subastas.get(i).getPieza().getTitulo());
			message1.setText("asi a trascurrido la subasta");
			System.out.println("size de registro "+ registro.size());
			for (Precio precio : registro) {
				System.out.println("Oferta: "+precio.getPrecio()+"--Usuario: "+((Usuario) precio.getUsuario()).getUsuario());
				JLabel cadaElemento = new JLabel();
				cadaElemento.setText("Oferta: "+precio.getPrecio()+"--Usuario: "+((Usuario) precio.getUsuario()).getUsuario());
				panelCentro.add( cadaElemento);				
			}
			i++;
		}/*else if(input==2) {
			seguir=false;
		}*/else {
			System.out.println("Valor Incorrecto");
		}
		add(label1, BorderLayout.NORTH);
		add(panelCentro, BorderLayout.CENTER);
		
		revalidate();
		repaint();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(si)) {
			respuestaPregunta();
		}
		
	}

}
