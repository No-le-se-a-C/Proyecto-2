package Interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import GaleriaGestionSesion.Usuario;
import GaleriaModelo.Galeria;
import GaleriaServiciosDeAdquisicion.Precio;
import GaleriaServiciosDeAdquisicion.Subasta;

public class PanelSubasta extends JPanel implements ActionListener{
	
	private JTextField textField1;
	private JTextField textField2;
	private JButton submitButton;
	private JButton infoButton;
	private Galeria galeria;
	private Usuario usuario;
	private JFrame frame;
	    
	public PanelSubasta(JFrame frame, Galeria galeria, Usuario usuario) {
		super();
		
		this.galeria=galeria;
		this.usuario=usuario;
		this.frame=frame;
		
		buscarSubasta();
		
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(submitButton)) {
			String nombrePieza = textField1.getText();
			try {
				// Obtener el texto del JTextField
				String texto = textField2.getText();

				// Convertir el texto a un entero
				int oferta = Integer.parseInt(texto);
				Subasta subastaEncontrada=galeria.participarSubasta(galeria, usuario, nombrePieza);

				if (subastaEncontrada!=null) {
					if( !subastaEncontrada.getFechaFinal().isBefore(LocalDate.now())) {


						if((int)subastaEncontrada.getPieza().getPrecio().getPrecio()<oferta) {
							subastaEncontrada.getPieza().nuevoPrecio(oferta, usuario);
							Precio precio=new Precio();
							precio.setPrecio(oferta);
							precio.setUsuario(usuario);
							subastaEncontrada.anadirRegistroSubasta(precio);
							JOptionPane.showMessageDialog(frame,"ahora eres la oferta mas alta");
							JOptionPane.showMessageDialog(frame, "si quieres saber si ganaste la oferta revisa tus adqusisiones al finalizar la subasta");

						}else {
							JOptionPane.showMessageDialog(frame, "La oferta es menor a "+ subastaEncontrada.getPieza().getPrecio().getPrecio());


						}
					}
				}else {
					JOptionPane.showMessageDialog(frame, "No existe esa pieza");
				}

			} catch (NumberFormatException ex) {
				// Manejar la excepción si el texto no puede ser convertido a int
				JOptionPane.showMessageDialog(frame, "Por favor ingrese un número válido", "Error", JOptionPane.ERROR_MESSAGE);
			}
		}else if (e.getSource().equals(infoButton)) {
			String nombrePieza = textField1.getText();
			Subasta subastaEncontrada=galeria.participarSubasta(galeria, usuario, nombrePieza);
			
			if (subastaEncontrada==null) {
				JOptionPane.showMessageDialog(frame, "No existe esa pieza");
			}else {
				JOptionPane.showMessageDialog(frame, "Precio Actual de la subasta "+ subastaEncontrada.getPieza().getPrecio().getPrecio(), "info", JOptionPane.INFORMATION_MESSAGE);
				JOptionPane.showMessageDialog(frame, "Fecha en que acaba la subasta "+ subastaEncontrada.getFechaFinal(), "info", JOptionPane.INFORMATION_MESSAGE);
			}
		}

	}
	
	public void buscarSubasta() {
		setLayout(new BorderLayout());
		setOpaque(true);
		setBackground(Color.BLACK);
		setPreferredSize(new Dimension(500, 660));
		
		setLayout(new BorderLayout());
		
		textField1=new JTextField();
		
		textField2=new JTextField();
		
		submitButton= new JButton("Seguir");
		submitButton.setBackground(new Color(25, 25, 112));
		submitButton.setForeground(Color.WHITE);
		submitButton.setFont(new Font("arial", Font.BOLD, 30));
		
		infoButton= new JButton("Revisar info de la subasta");
		infoButton.setBackground(new Color(25, 25, 112));
		infoButton.setForeground(Color.WHITE);
		infoButton.setFont(new Font("arial", Font.BOLD, 30));

 
        
        JPanel panelText= new JPanel();
        JPanel panelText1= new JPanel();
        JPanel panelText2= new JPanel();
        JPanel panelText3= new JPanel();
     
        panelText1.setLayout(new GridLayout(2,1));
        panelText2.setLayout(new GridLayout(2,1));
        panelText3.setLayout(new GridLayout(1,2));
        panelText.setLayout(new GridLayout(3,1));
        
        JLabel LabelPieza= new JLabel("Nombre de la pieza:");
        LabelPieza.setFont(new Font("arial", Font.BOLD, 15));
        JLabel LabelOferta= new JLabel("Oferta (Debe ser entero):");
        LabelPieza.setFont(new Font("arial", Font.BOLD, 15));
        

        panelText1.add(LabelPieza);
        panelText1.add(textField1);
        panelText2.add(LabelOferta);
        panelText2.add(textField2);
        panelText3.add(submitButton);
        panelText3.add(infoButton);
        
        panelText.add(panelText1);
        panelText.add(panelText2);
        panelText.add(panelText3);

        // Añadir el panel intermedio al panel principal en la posición CENTER
        add(panelText, BorderLayout.CENTER);

 
		
  
  
        // Añadir ActionListener al botón
        
        
        submitButton.addActionListener(this);
        infoButton.addActionListener(this);
		
		frame.add(this, BorderLayout.EAST);
		
		revalidate();
		repaint();
		
		
		
		
		
	}
	
	
}
