package Listeners;

import java.awt.*;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;

import javax.swing.JFrame;

import GaleriaGestionSesion.Usuario;
import GaleriaModelo.Galeria;
import Interfaz.*;



public class BotonActionListenerArtista implements ActionListener {
	private final int opcion;
	private JFrame frame;
	private Galeria galeria;
	private Usuario usuario;
    
    public BotonActionListenerArtista(int opcion, JFrame frame, Galeria galeria, Usuario usuario ) {
        this.opcion = opcion;
        this.frame=frame;
        this.galeria=galeria;
        this.usuario=usuario;
    }
    
    

    @Override
    public void actionPerformed(ActionEvent e) {
        // Aquí puedes añadir la lógica para cada opción
        switch (opcion) {
            case 1:
            	new PanelDefinirMetodoPago(galeria, usuario, frame);
                break;
            case 2:
            	new PanelPiezaDisponible(galeria, usuario);
              
                break;
            case 3:
            	galeria.comprarPieza( galeria , usuario);            	

          
                break;
            case 4:
            	new PanelSubasta2(frame, galeria, usuario);
               
                break;
            case 5:
           
                break;
            case 6:
          
                break;
            case 7:
              
                break;
            case 8:
            	new PanelAnadirPieza(galeria, usuario, frame);
                break;
            case 9:
            	new PanelHistorial(galeria, usuario);
          
                break;
            case 10:
             
                break;
            case 11:
            	frame.dispose();
                new InterfazSesion(galeria);
               
                break;
            default:
                break;
        }
    }



}