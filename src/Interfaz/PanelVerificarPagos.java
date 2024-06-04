package Interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import GaleriaEmpleados.Administrador;
import GaleriaEmpleados.Cajero;
import GaleriaGestionSesion.Usuario;
import GaleriaModelo.Galeria;

public class PanelVerificarPagos extends JPanel{
	JFrame frame;
	Galeria galeria;
	Usuario usuario;
	Administrador admin;
	Cajero cajero;
	
	JLabel label1 = new JLabel();
	public PanelVerificarPagos(JFrame frame, Galeria galeria, Usuario usuario) {
		super();
		this.frame = frame;
		this.galeria = galeria;
		this.usuario = usuario;
		admin=(Administrador)galeria.getMapaUsuariosEmpleados().get("Administrador");
		cajero = (Cajero)galeria.getMapaUsuariosEmpleados().get("Cajero");
		inicializar();
	}
	
	public void inicializar() {
		frame.dispose();
		this.frame = new InterfazMenu(usuario, galeria);
		
		setLayout(new BorderLayout());
		setOpaque(true);
		setPreferredSize(new Dimension(500, 660));
		setVisible(true);
		
		label1.setText("-En este momento usted tiene "+ Integer.toString( cajero.getPagosPendientes().size())+ " verificaciones pendientes.");
		label1.setHorizontalAlignment(SwingConstants.CENTER);
		label1.setPreferredSize( new Dimension(500, 100) );
		label1.setOpaque(true);
		label1.setBackground(new Color(25, 25, 112));
		label1.setForeground(Color.white);
		label1.setFont(new Font("arial", Font.BOLD, 15));
		add(label1, BorderLayout.CENTER);
		
		
		frame.setVisible(true);
		frame.getContentPane().add(this, BorderLayout.EAST);
		frame.add(this, BorderLayout.EAST);
		frame.revalidate();
		frame.repaint();
		
		
	}
}
