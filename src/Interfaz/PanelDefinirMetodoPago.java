package Interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import GaleriaConsola.Controller;
import GaleriaGestionSesion.Usuario;
import GaleriaModelo.Galeria;

public class PanelDefinirMetodoPago extends JPanel implements ActionListener {
	
	private Galeria galeria;
	private Usuario usuario;
	private JFrame frame;
	
	private JTextField textFieldmetodo;
	private JTextField textFieldcantidad;
	private JButton botonSubir;
	
	
	public PanelDefinirMetodoPago(Galeria galeria, Usuario usuario, JFrame frame) {
		super();

		this.galeria=galeria;
		this.usuario=usuario;
		this.frame=frame;
		
		iniciar();
	}


	private void iniciar() {
		frame.dispose();
		this.frame = new InterfazMenu(usuario, galeria);
		frame.setVisible(true);

		setOpaque(true);
		setBackground(Color.white);
		setPreferredSize(new Dimension(500, 660));
		setLayout(new GridBagLayout());
		
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.HORIZONTAL; 
		gbc.insets = new Insets(7, 7,7, 7);
		gbc.anchor = GridBagConstraints.CENTER;
		gbc.weightx = 1.0;

		// Primera fila: Label
        gbc.gridx = 0;
        gbc.gridy = 0;
        JLabel titleLabel = new JLabel("Añadir libro");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 30)); // Ajusta el tamaño y estilo de la fuente
        titleLabel.setForeground(Color.BLACK);
        add(titleLabel, gbc);
        
        
		// Segunda fila: Label y TextField
		gbc.gridy++;
		gbc.gridx = 0;
		JLabel label1 = new JLabel("Metodo de pago:");
		label1.setForeground(Color.BLACK);
		label1.setOpaque(true);
		label1.setBackground(new Color(128, 206, 225));
		add(label1, gbc);

		gbc.gridx = 1;
		textFieldmetodo = new JTextField();
		textFieldmetodo.setMaximumSize(new Dimension(Integer.MAX_VALUE, 50));
		add(textFieldmetodo, gbc);

		// Tercera fila: Label y TextField
		gbc.gridy++;
		gbc.gridx = 0;
		JLabel label2 = new JLabel("Cantidad que desea subir:");
		label2.setForeground(Color.BLACK);
		label2.setOpaque(true);
		label2.setBackground(new Color(128, 206, 225));
		add(label2, gbc);
		
		gbc.gridx = 1;
		textFieldcantidad = new JTextField();
		textFieldcantidad.setMaximumSize(new Dimension(Integer.MAX_VALUE, 50));
		add(textFieldcantidad, gbc);

		//boton
		gbc.gridy++;
		gbc.gridx = 0;
		botonSubir=new JButton("Subir");
		botonSubir.setOpaque(true);
		botonSubir.setBackground(new Color(25, 25, 112));
		botonSubir.setForeground(Color.WHITE);
		botonSubir.setPreferredSize(new Dimension(80, 50));
		botonSubir.addActionListener(this);
		add(botonSubir, gbc);
		
		
		
		
		
		frame.getContentPane().add(this, BorderLayout.EAST);

		frame.revalidate();
		frame.repaint();
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==botonSubir) {
			String metodo= textFieldmetodo.getText();
			String cantidad=(textFieldcantidad.getText());
			  try {
		            int cantidad1 = Integer.parseInt(cantidad);
		            Controller controler=new Controller();
		            controler.definirMetodoPago(galeria, usuario, metodo, cantidad1);
		            JOptionPane.showMessageDialog(frame, "Ya fue definido el metodo de pago");
		        } catch (NumberFormatException z) {
		        	JOptionPane.showMessageDialog(frame, "Error: Por favor, ingrese un valor entero válido.", "Error", JOptionPane.ERROR_MESSAGE);
		        }
			
		}
		
	}
}
