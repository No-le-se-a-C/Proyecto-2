package Interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import org.eclipse.wb.swing.FocusTraversalOnArray;

import GaleriaEmpleados.Administrador;
import GaleriaEmpleados.Cajero;
import GaleriaEmpleados.Operador;
import GaleriaGestionSesion.*;
import GaleriaModelo.Galeria;

public class InterfazSesion extends JFrame implements ActionListener {

    private Galeria galeria;
    private static final long serialVersionUID = 1L;

    private JTextField campoUsuario;
    private JPasswordField campoContraseña;
    private JButton botonRegistrarse;
    private JButton botonIniciarSesion;


 
	public InterfazSesion(Galeria galeria) {
		this.galeria = galeria;

		initialize();
		}

		
	private void initialize()  {
		
		this.setBackground(new Color(240, 240, 240));
		this.setBounds(100, 100, 1000, 650);
		this.setTitle("Sesion");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setLocationRelativeTo(null);

		JPanel panel = new JPanel();

        panel.setBackground(Color.BLUE);
        this.getContentPane().add(panel, BorderLayout.CENTER);
        GridBagLayout gbl_panel = new GridBagLayout();
        gbl_panel.columnWidths = new int[]{0, 0, 0, 0, 0};
        gbl_panel.rowHeights = new int[]{0, 0, 0, 0, 0, 0};
        gbl_panel.columnWeights = new double[]{1.0, 0.2, 0.6, 0.2, 1.0};  // Adjusted column weights
        gbl_panel.rowWeights = new double[]{1.0, 0.0, 0.0, 0.0, 0.0, 1.0};
        panel.setLayout(gbl_panel);

        JLabel etiquetaImagen = new JLabel();
        etiquetaImagen.setIcon(new ImageIcon("C:\\Users\\usuario\\eclipse-workspace\\Proyecto_2\\Imagenes\\ImagenDeSesion.jpg"));
        GridBagConstraints gbc_etiquetaImagen = new GridBagConstraints();
        gbc_etiquetaImagen.insets = new Insets(10, 10, 5, 10);
        gbc_etiquetaImagen.gridx = 2;
        gbc_etiquetaImagen.gridy = 0;
        gbc_etiquetaImagen.anchor = GridBagConstraints.CENTER;
        panel.add(etiquetaImagen, gbc_etiquetaImagen);

        JLabel etiquetaUsuario = new JLabel("Usuario");
        etiquetaUsuario.setForeground(Color.WHITE);
        GridBagConstraints gbc_etiquetaUsuario = new GridBagConstraints();
        gbc_etiquetaUsuario.insets = new Insets(0, 0, 5, 5);
        gbc_etiquetaUsuario.gridx = 1;
        gbc_etiquetaUsuario.gridy = 1;
        panel.add(etiquetaUsuario, gbc_etiquetaUsuario);

        campoUsuario = new JTextField();
        GridBagConstraints gbc_campoUsuario = new GridBagConstraints();
        gbc_campoUsuario.insets = new Insets(10, 10, 5, 10);
        gbc_campoUsuario.gridx = 2;  // Centering the text field
        gbc_campoUsuario.gridy = 1;
        gbc_campoUsuario.fill = GridBagConstraints.HORIZONTAL;
        campoUsuario.setColumns(10);
        panel.add(campoUsuario, gbc_campoUsuario);

        JLabel etiquetaContraseña = new JLabel("Contraseña");
        etiquetaContraseña.setForeground(Color.WHITE);
        GridBagConstraints gbc_etiquetaContraseña = new GridBagConstraints();
        gbc_etiquetaContraseña.insets = new Insets(0, 0, 5, 5);
        gbc_etiquetaContraseña.gridx = 1;
        gbc_etiquetaContraseña.gridy = 2;
        panel.add(etiquetaContraseña, gbc_etiquetaContraseña);

        campoContraseña = new JPasswordField();
        GridBagConstraints gbc_campoContraseña = new GridBagConstraints();
        gbc_campoContraseña.insets = new Insets(5, 10, 10, 10);
        gbc_campoContraseña.gridx = 2;  // Centering the text field
        gbc_campoContraseña.gridy = 2;
        gbc_campoContraseña.fill = GridBagConstraints.HORIZONTAL;
        campoContraseña.setColumns(10);
        panel.add(campoContraseña, gbc_campoContraseña);

        botonIniciarSesion = new JButton("Iniciar Sesión");
        botonIniciarSesion.setBackground(new Color(25, 25, 112));
        botonIniciarSesion.setForeground(Color.WHITE);
        GridBagConstraints gbc_botonIniciarSesion = new GridBagConstraints();
        gbc_botonIniciarSesion.insets = new Insets(10, 10, 10, 10);
        gbc_botonIniciarSesion.gridx = 2;  // Centering the button
        gbc_botonIniciarSesion.gridy = 3;
        gbc_botonIniciarSesion.anchor = GridBagConstraints.CENTER;
        botonIniciarSesion.addActionListener(this);  // Añadir ActionListener
        panel.add(botonIniciarSesion, gbc_botonIniciarSesion);

        botonRegistrarse = new JButton("Registrarse");
        botonRegistrarse.setBackground(new Color(25, 25, 112));
        botonRegistrarse.setForeground(Color.WHITE);
        GridBagConstraints gbc_botonRegistrarse = new GridBagConstraints();
        gbc_botonRegistrarse.insets = new Insets(5, 10, 10, 10);
        gbc_botonRegistrarse.gridx = 2;  // Centering the button
        gbc_botonRegistrarse.gridy = 4;
        gbc_botonRegistrarse.anchor = GridBagConstraints.CENTER;
        botonRegistrarse.addActionListener(this);  // Añadir ActionListener
        panel.add(botonRegistrarse, gbc_botonRegistrarse);

        this.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{this.getContentPane(), panel, botonIniciarSesion, campoUsuario, campoContraseña, botonRegistrarse, etiquetaUsuario, etiquetaContraseña}));
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String comando = e.getActionCommand();
        String usuario1 = campoUsuario.getText();
        String contrasenia = new String(campoContraseña.getPassword());
        Usuario usuario = null;

        if (comando.equals("Iniciar Sesión")) {
            if (usuario1.equals("comprador") && contrasenia.equals("comprador")) {
                usuario = new Comprador(usuario1, contrasenia);
            } else if (usuario1.equals("artista") && contrasenia.equals("artista")) {
                usuario = new Artista(usuario1, contrasenia);
            } else if (usuario1.equals("cajero") && contrasenia.equals("cajero")) {
                usuario = new Cajero(usuario1, contrasenia);
            } else if (usuario1.equals("operador") && contrasenia.equals("operador")) {
                usuario = new Operador(usuario1, contrasenia);
            } else if (usuario1.equals("administrador") && contrasenia.equals("administrador")) {
                usuario = new Administrador(usuario1, contrasenia);
            } else {
                JOptionPane.showMessageDialog(this, "Usuario o contraseña incorrectos.", "Error de autenticación", JOptionPane.ERROR_MESSAGE);
                return;
            }
            new InterfazMenu(usuario, galeria).setVisible(true);
            this.dispose();
        } else if (comando.equals("Registrarse")) {
            new InterfazCrearUsuario(galeria).setVisible(true);
            this.dispose();
        }
    }
}