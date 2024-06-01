package Listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import Interfaz.InterfazMenu;
import Interfaz.InterfazSesion;

public class BotonActionListenerAdmin implements ActionListener{
	private final int opcion;
    private JFrame frame;
    
    public BotonActionListenerAdmin(int opcion, JFrame frame) {
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
              
                break;
            case 5:
           
                break;
            case 6:
                
                break;
            case 7:
               
                break;
            case 8:
                frame.dispose();
                new InterfazSesion();
                break;
            default:
                break;
        }
    }
}
