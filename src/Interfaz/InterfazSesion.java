package Interfaz;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import GaleriaGestionSesion.*;

public class InterfazSesion extends JFrame implements ActionListener{
	
	private JButton boton;
	
	
	public InterfazSesion() {
		
		//Cuando vallan a modificar este frame quiten todo esto que solo es para probar lo demas
		
		
		
		
		super("Sesion");		
		setSize(1000,650);
		setResizable(false);
		// Centrar el frame en la pantalla
		setLocationRelativeTo(null);
        // Especificar la operación predeterminada al cerrar la ventana
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        
        setVisible(true);
         
        JLabel label= new JLabel();
        label.setText("Joban aqui haz lo de la sesion");
        label.setFont(new Font("Ravie",Font.BOLD,35));
        
        boton= new JButton();
        boton.setText("Tumben DALGO");
        boton.setFont(new Font("arial",Font.BOLD,35));
        boton.addActionListener(this);
        
        add(label, BorderLayout.NORTH);
        add(boton, BorderLayout.CENTER);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()== boton) {
			Usuario usuario= new Comprador("messi", "0126");
			new InterfazMenu(usuario).setVisible(true);
			dispose();
		}
		
	}
}
