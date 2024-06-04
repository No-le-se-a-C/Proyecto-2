package Listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import GaleriaGestionSesion.Usuario;
import GaleriaModelo.Galeria;
import Interfaz.InterfazMenu;
import Interfaz.InterfazSesion;
import Interfaz.PanelHistorial;
import Interfaz.PanelSeriedadOferta;
import Interfaz.PanelVerificarVenta;

public class BotonActionListenerAdmin implements ActionListener{
	private final int opcion;
    private JFrame frame;
    private Galeria galeria;
	private Usuario usuario;
    
    public BotonActionListenerAdmin(int opcion, JFrame frame, Galeria galeria, Usuario usuario) {
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
            	new PanelVerificarVenta(frame, galeria, usuario);
            	
                break;
            case 2:
            	new PanelSeriedadOferta(frame, galeria, usuario);
            	
                break;
            case 3:
               
                break;
            case 4:
            	new PanelHistorial(galeria, usuario);
              
                break;
            case 5:
           
                break;
            case 6:
                
                break;
            case 7:
                frame.dispose();
                new InterfazSesion(galeria);
                break;
            default:
                break;
        }
    }
}
