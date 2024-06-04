package Interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import GaleriaEmpleados.Administrador;
import GaleriaGestionSesion.Usuario;
import GaleriaModelo.Galeria;
import GaleriaServiciosDeAdquisicion.Compra;

public class PanelVerificarVenta extends JPanel implements ActionListener{
	JLabel texto;
	JLabel label2;
	JButton si; 
	JButton no = new JButton();
	
	JButton mostrar = new JButton();
	JButton dejar = new JButton();
	
	JFrame frame;
	Galeria galeria;
	Usuario usuario;
	
	Administrador admin;
	
	JButton siP;
	JButton noP;

	public PanelVerificarVenta(JFrame frame, Galeria galeria, Usuario usuario) {
		super();
		this.frame = frame;
		this.galeria = galeria;
		this.usuario = usuario;
		admin=(Administrador)galeria.getMapaUsuariosEmpleados().get("Administrador");
		inicializar();
	}
	
	public void inicializar() {
		frame.dispose();
		this.frame = new InterfazMenu(usuario, galeria);
		
		setLayout(new BorderLayout());
		setOpaque(true);
		setPreferredSize(new Dimension(500, 660));
		setVisible(true);
		
		si = new JButton();
		
		texto = new JLabel();
		label2 = new JLabel();
		texto.setFont(new Font("arial", Font.BOLD, 20));
		texto.setText("Tiene " + admin.getVentasAVerificar().size()+  " solicitudes para verificar ventas");
		texto.setHorizontalAlignment(SwingConstants.CENTER);
		texto.setPreferredSize( new Dimension(500, 100) );
		texto.setOpaque(true);
		texto.setBackground(new Color(25, 25, 112));
		texto.setForeground(Color.white);
		
		label2.setText("¿Desea verlas?");
		label2.setHorizontalAlignment(SwingConstants.CENTER);
		label2.setFont( new Font("arial", Font.BOLD, 30));
		
		si.setPreferredSize( new Dimension(185,200) );
		no.setPreferredSize( new Dimension(205,200) );
		
		si.setText("SI");
		no.setText("NO");
		
		si.setFont( new Font("arial", Font.BOLD, 25));
		no.setFont( new Font("arial", Font.BOLD, 25));
		
		si.addActionListener(this);
		no.addActionListener(this);
		
		siP = new JButton();
		siP.setText("SI");
		
		noP = new JButton();
		noP.setText("NO");
		
		JPanel buttonFrame = new JPanel();
		buttonFrame.setLayout( new GridLayout(1,2));
		buttonFrame.add(si);
		buttonFrame.add(no);
		
		add(texto, BorderLayout.NORTH);
		add(label2, BorderLayout.CENTER);
		add(si, BorderLayout.SOUTH);
		
		mostrar.setText("Mostrar Solicitud");
		mostrar.addActionListener(this);
		mostrar.setFont( new Font("arial", Font.BOLD, 20));
		
		dejar.setText("Dejar de ver Solicitud");
		dejar.addActionListener(this);
		dejar.setFont( new Font("arial", Font.BOLD, 20));
		
		frame.setVisible(true);
		frame.getContentPane().add(this, BorderLayout.EAST);
		frame.add(this, BorderLayout.EAST);
		frame.revalidate();
		frame.repaint();
		
	}
	
	public void verificarVenta() {
		
		JLabel label1 = new JLabel();
		JLabel label2 = new JLabel();
		JLabel label3 = new JLabel();
		JLabel labelPregunta = new JLabel();
		JLabel botones = new JLabel();
		botones.setLayout( new GridLayout(1,2) );
	
		int i=0;
		boolean seguir1=true;
		while (seguir1) {
			if(!admin.getVentasAVerificar().isEmpty()) {
				try{
					remove(0);
					remove(0);
					Compra compra =admin.getVentasAVerificar().get(0);
					label1.setText("El metodo de pago del usuario es: "+ compra.getUsuarioComprador().getMetodoPago());
					label2.setText("El precio pagado fue: "+ compra.getValorPagado());
					label3.setText("al usuario tiene este dinero en la cartera: "+ compra.getUsuarioComprador().getCartera());
					
					labelPregunta.setText("Teniendo encuenta esta informacion quiere admitir la entrada de esta pieza:");
					
					
					JPanel panel = new JPanel();
					panel.setLayout( new GridLayout(4,1) );
					panel.add(label1);
					panel.add(label2);
					panel.add(label3);
					panel.add(labelPregunta);
					
					add(panel, BorderLayout.CENTER);
					add(botones, BorderLayout.SOUTH);
					
					revalidate();
					repaint();
					
					i++;
				}catch(Exception e){
					seguir1=false;
				}
				
			}else {
				JOptionPane.showMessageDialog(frame, "Ya se acabaron las solicitudes");
				seguir1=false;
			}
		}
			
		revalidate();
		repaint();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if( e.getSource().equals(si) ) {
			cambiar();
			
		}else if( e.getSource().equals(no) ) {
			frame.remove(this);
			revalidate();
			repaint();
			
		}else if( e.getSource().equals(mostrar) ) {
			verificarVenta();
			
		}else if( e.getSource().equals(dejar) ) {
			pintarPrimer();
			
		}else if( e.getSource().equals(siP)) {
			Compra compra =admin.getVentasAVerificar().get(0);
			admin.getVentasAVerificar().remove(0);
			galeria.getInventario().anadirPiezaInfoAntigua(compra.getPieza());
			galeria.getInventario().eliminarpiezaVendida(compra.getPieza());
			compra.getUsuarioComprador().anadirAdquisicion(compra.getPieza());
			JOptionPane.showMessageDialog(frame, "La venta fue verificada y enviada al usuario");
			
		}else if(e.getSource().equals(noP)) {
			admin.getVentasAVerificar().remove(0);
			JOptionPane.showMessageDialog(frame, "La venta no paso el proceso de verificacion");
		}
		
	}
	
	public void cambiar() {
		remove(0);
		remove(0);
		remove(0);
		JPanel buttonsPanel = new JPanel();
		buttonsPanel.setLayout( new GridLayout(2,1) );
		buttonsPanel.add(mostrar);
		buttonsPanel.add(dejar);
		
		buttonsPanel.setPreferredSize( new Dimension(500, 300));
		add(texto,BorderLayout.NORTH);
		add(buttonsPanel, BorderLayout.CENTER);
		revalidate();
		repaint();
		
	}
	
	public void pintarPrimer() {
		remove(0);
		remove(0);
		
		JPanel buttonFrame = new JPanel();
		buttonFrame.setLayout( new GridLayout(1,2));
		buttonFrame.add(si);
		buttonFrame.add(no);
		
		add(texto, BorderLayout.NORTH);
		add(label2, BorderLayout.CENTER);
		add(si, BorderLayout.SOUTH);
		
		revalidate();
		repaint();
	}

}
