package Interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import GaleriaGestionSesion.Usuario;
import GaleriaModelo.Galeria;

public class Interfaz extends JFrame implements ActionListener{

	
	private JButton botonCerrar;
	
	private JButton botonPasar;
	
	private Galeria galeria;

	
	public Interfaz(Galeria galeria) {
		super("Bienvenido");
		this.galeria=galeria;
		setSize(1000,650);
		setResizable(false);
		// Centrar el frame en la pantalla
		setLocationRelativeTo(null);
        // Especificar la operación predeterminada al cerrar la ventana
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        
        //label de bienvenida
        JLabel labelBienvenida = new JLabel("Bienvenido", SwingConstants.CENTER);
        labelBienvenida.setOpaque(true); // Permitir que el JLabel tenga un color de fondo
        labelBienvenida.setBackground(new Color(25, 25, 112));
        labelBienvenida.setForeground(Color.WHITE); // Establecer color del texto para que sea visible
        labelBienvenida.setPreferredSize(new Dimension(1000, 190)); // Establecer el tamaño preferido
        labelBienvenida.setFont(new Font("arial", Font.BOLD, 40));
        add(labelBienvenida, BorderLayout.NORTH);
        
        //Panel de botones 
        JPanel panel= new JPanel();
        panel.setSize(1000, 460);
        panel.setLayout(new GridLayout(2,1));
        panel.setOpaque(true);
        panel.setBackground(Color.BLUE);
        
        //margenes
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
	    gbc.gridy = 0;
	    gbc.fill = GridBagConstraints.HORIZONTAL;
	    gbc.insets = new Insets(20, 20, 20, 20); // Márgenes
        
        JPanel panel1= new JPanel();
        panel1.setBackground(new Color(245, 245, 245));
        botonPasar= new JButton("Entrar");
        botonPasar.setFont(new Font("Arial", Font.BOLD, 25));
        botonPasar.setBackground(new Color(25, 25, 112));
        botonPasar.setForeground(Color.WHITE);
        botonPasar.setPreferredSize(new Dimension(200, 100));
        botonPasar.addActionListener(this); 
        panel1.add(botonPasar, gbc);
        panel.add(panel1);
        
        JPanel panel2= new JPanel();
        panel2.setBackground(new Color(245, 245, 245));
        botonCerrar= new JButton("Cerrar");
        botonCerrar.setFont(new Font("Arial", Font.BOLD, 25));
        botonCerrar.setBackground(new Color(25, 25, 112));
        botonCerrar.setForeground(Color.WHITE);
        botonCerrar.setPreferredSize(new Dimension(200, 100));
        botonCerrar.addActionListener(this); 
        panel2.add(botonCerrar, gbc);
        panel.add(panel2);
        
        add(panel);
        
		setVisible(true);
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource().equals(botonPasar)) {
			new InterfazSesion(galeria);
			dispose();
		}else if(e.getSource()== botonCerrar) {
			dispose();
		}
		
	}
}
