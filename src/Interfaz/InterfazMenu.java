package Interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import GaleriaGestionSesion.Usuario;
import GaleriaModelo.Galeria;
import Listeners.BotonActionListenerAdmin;
import Listeners.BotonActionListenerArtista;
import Listeners.BotonActionListenerCajero;
import Listeners.BotonActionListenerComprador;
import Listeners.BotonActionListenerOperador;

public class InterfazMenu extends JFrame{
	
	private Galeria galeria;
	private Usuario usuario;
	// Comprador
	public static String[] comprador = {"comprador",
			"1.Definir Metodo de pago.",
			"2.Ver piezas disponibles",
			"3.Comprar una pieza",
			"4.Participar en una subasta",
			"5.Pedir mas cupo de compra",
			"6.Mirar historia de una pieza",
			"7.Mirar historia de un artista",
			"8.Salir del menu pricipal"
	};

	// Artista
	public static String[] artista = {"artista",
			"1.Definir Metodo de pago.",
			"2.Ver piezas disponibles",
			"3.Comprar una pieza",
			"4.Participar en una subasta",
			"5.Pedir mas cupo de compra",
			"6.Mirar mi pieza",
			"7.Mirar info de pieza antigua",
			"8.Añadir pieza a la galeria",
			"9.Mirar historia de una pieza",
			"10.Mirar historia de un artista",
			"11.Salir del menu pricipal"
	};

	// Admin
	public static String[] admin = {"admin",
			"1.Verificar Ventas",
			"2.Verificar seriedad de las ofertas",
			"3.Validar piezas por aniadir",
			"4.Mirar historia de una pieza",
			"5.Mirar historia de un artista",
			"6.Mirar historia de un comprador",
			"7.Salir del menu pricipal"
	};

	// Operador
	public static String[] operador = {"operador",
			"1.Llevar registro de subastas",
			"2.Mirar historia de una pieza",
			"3.Mirar historia de un artista",
			"4.Salir del menu pricipal"
	};

	// Cajero
	public static String[] cajero = {"cajero",
			"1.Verificar los pagos",
			"2.Mirar historia de una pieza",
			"3.Mirar historia de un artista",
			"4.Salir del menu pricipal"
	};



	public InterfazMenu(Usuario usuario, Galeria galeria) {
		super("Menu pricipal");
		this.galeria=galeria;
	    this.usuario=usuario;
		String[] opcion= DefinirMenu(usuario);
        setSize(900, 750);
        setResizable(false);
        // Centrar el frame en la pantalla
        setLocationRelativeTo(null);
        // Especificar la operación predeterminada al cerrar la ventana
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Etiqueta en la parte superior
        JLabel etiqueta = new JLabel("Bienvenido " + opcion[0], JLabel.CENTER);
        etiqueta.setOpaque(true);
        etiqueta.setBackground(new Color(25, 25, 112));
        etiqueta.setPreferredSize(new Dimension(700, 90));
        etiqueta.setForeground(Color.WHITE);
        etiqueta.setFont(new Font("Arial", Font.BOLD, 40));
        add(etiqueta, BorderLayout.NORTH);

        JPanel panelIzquierda = new JPanel();
        panelIzquierda.setLayout(new GridBagLayout());
        panelIzquierda.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        panelIzquierda.setOpaque(true);
        panelIzquierda.setBackground(new Color(128, 206, 225));
        
        //margenes
        GridBagConstraints gbc = new GridBagConstraints();
        
        gbc.gridx = 0;
	        gbc.gridy = 0;
	        gbc.fill = GridBagConstraints.HORIZONTAL;
        // Crear botones
        for (int i = 1; i < opcion.length; i++) {
            JButton boton = new JButton(opcion[i]);
            boton.setFont(new Font("Arial", Font.PLAIN, 15));
            boton.setPreferredSize(new Dimension(300, 50));

            if (opcion[0].equals("artista")) {
            	
     	        gbc.insets = new Insets(7, 7, 7, 7); // Márgenes
     	        
                boton.addActionListener(new BotonActionListenerArtista(i, this, galeria, usuario));
            } else if (opcion[0].equals("comprador")) {
  
     	        gbc.insets = new Insets(7, 7, 7, 7); // Márgenes
     	       
                boton.addActionListener(new BotonActionListenerComprador(i, this, galeria, usuario));
            } else if (opcion[0].equals("admin")) {
            	
     	        gbc.insets = new Insets(9, 9, 9, 9); // Márgenes
     	       
                boton.addActionListener(new BotonActionListenerAdmin(i, this, galeria, usuario));
            } else if (opcion[0].equals("cajero")) {
            	
     	        gbc.insets = new Insets(20, 20, 20, 20); // Márgenes
     	     
                boton.addActionListener(new BotonActionListenerCajero(i, this, galeria, usuario));
            } else if (opcion[0].equals("operador")) {
         
     	        gbc.insets = new Insets(20, 20, 20, 20); // Márgenes
     	     
                boton.addActionListener(new BotonActionListenerOperador(i, this, galeria, usuario));
            }

         
            boton.setBackground(new Color(25, 25, 112));
            boton.setForeground(Color.WHITE);
            gbc.gridy = i;
            panelIzquierda.add(boton, gbc);
        }
        
        JPanel panel2 = new JPanel();
        panel2.setLayout(new GridLayout(1, 2));
        panel2.add(panelIzquierda);
        
        add(panel2, BorderLayout.CENTER);
        
 
		
	}



	private String[] DefinirMenu(Usuario usuario) {
		
		String[] opcion=null;
		
		if(usuario!=null) {
	        if ("ARTISTA".equals(usuario.getIDENTIFICADOR())) {
	           opcion=artista;
	        } else if ("COMPRADOR".equals(usuario.getIDENTIFICADOR())) {
	        	opcion=comprador;
	        } else if ("ADMINISTRADOR".equals(usuario.getIDENTIFICADOR())) {
	        	opcion=admin;
	        } else if ("OPERADOR".equals(usuario.getIDENTIFICADOR())) {
	        	opcion=operador;
	        } else if ("CAJERO".equals(usuario.getIDENTIFICADOR())) {
	        	opcion=cajero;
	        }
			
		}
		return opcion;
	}
}
