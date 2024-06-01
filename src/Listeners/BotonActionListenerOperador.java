package Listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import Interfaz.InterfazSesion;

public class BotonActionListenerOperador implements ActionListener{
	private final int opcion;
	private JFrame frame;
    
    public BotonActionListenerOperador(int opcion, JFrame frame) {
        this.opcion = opcion;
        this.frame=frame;
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
                new InterfazSesion();
                break;
            default:
                break;
        }
    }
}
