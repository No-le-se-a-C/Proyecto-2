package Interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import GaleriaEmpleados.Administrador;
import GaleriaGestionSesion.Usuario;
import GaleriaModelo.Galeria;

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

	public PanelVerificarVenta(JFrame frame, Galeria galeria, Usuario usuario) {
		super();
		this.frame = frame;
		this.galeria = galeria;
		this.usuario = usuario;
		
		setLayout(new BorderLayout());
		setOpaque(true);
		setPreferredSize(new Dimension(500, 660));
		
		si = new JButton();
		
		texto = new JLabel();
		label2 = new JLabel();
		texto.setFont(new Font("arial", Font.BOLD, 15));
		
		texto.setText("Tiene  solicitudes para verificar ventas");
		label2.setText("¿Desea verlos?");
		label2.setSize(10, 10);
		label2.setBackground(Color.cyan);
		label2.setForeground(Color.WHITE);
		label2.setFont( new Font("arial", Font.BOLD, 30));
		
		si.setText("SI");
		no.setText("NO");
		
		si.addActionListener(this);
		no.addActionListener(this);
		
		JPanel buttonFrame = new JPanel();
		buttonFrame.setLayout( new GridLayout(1,2));
		buttonFrame.add(si);
		buttonFrame.add(no);
		
		add(texto, BorderLayout.NORTH);
		add(label2, BorderLayout.CENTER);
		add(buttonFrame, BorderLayout.SOUTH);
		
		mostrar.setText("Mostrar Solicitud");
		mostrar.addActionListener(this);
		dejar.setText("Dejar de ver Solicitud");
		dejar.addActionListener(this);
		
		
		frame.add(this, BorderLayout.EAST);
		revalidate();
		repaint();
	}
	public void cambiar() {
		remove(0);
		remove(0);
		remove(0);
		JPanel buttonsPanel = new JPanel();
		buttonsPanel.setLayout( new GridLayout(2,1) );
		buttonsPanel.add(mostrar);
		buttonsPanel.add(dejar);
		
		add(buttonsPanel, BorderLayout.CENTER);
		revalidate();
		repaint();
		
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if( e.getSource() == si ) {
			cambiar();
			
		}else if( e.getSource().equals(no) ) {
			
		}else if( e.getSource().equals(mostrar) ) {
			Administrador admin=(Administrador)this.galeria.getMapaUsuariosEmpleados().get("Administrador");
			admin.verificarVenta(this.galeria, usuario);
			
		}else if( e.getSource().equals(dejar) ) {
			
		}
		
	}

}
