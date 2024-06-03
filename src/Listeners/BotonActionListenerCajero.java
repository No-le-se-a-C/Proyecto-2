package Listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import GaleriaGestionSesion.Usuario;
import GaleriaModelo.Galeria;
import Interfaz.InterfazSesion;

public class BotonActionListenerCajero implements ActionListener {
	private final int opcion;
	private JFrame frame;
	private Galeria galeria;
	private Usuario usuario;
    
    public BotonActionListenerCajero(int opcion, JFrame frame, Galeria galeria, Usuario usuario) {
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
                break;
            case 2:
               
                break;
            case 3:

                break;
            case 4:
            	frame.dispose();
                new InterfazSesion(galeria);
                break;
            default:
                break;
        }
    }
}
