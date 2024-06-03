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
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import org.eclipse.wb.swing.FocusTraversalOnArray;

import GaleriaGestionSesion.Artista;
import GaleriaGestionSesion.Comprador;
import GaleriaGestionSesion.Usuario;
import GaleriaModelo.Galeria;

public class InterfazCrearUsuario extends JFrame implements ActionListener {

    private static final long serialVersionUID = 1L;
    private JTextField campoNombre;
    private JPasswordField campoContraseña;
    private JButton botonRegistrarse;
    private JComboBox<String> tipoUsuario;
    private Galeria galeria;

    public InterfazCrearUsuario(Galeria galeria) {
        this.galeria = galeria;
        initialize();
    }

    private void initialize() {
        this.setBackground(new Color(240, 240, 240));
        this.setBounds(100, 100, 1000, 700);
        this.setTitle("Crear Usuario");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setBackground(Color.BLUE);
        this.getContentPane().add(panel, BorderLayout.CENTER);
        GridBagLayout gbl_panel = new GridBagLayout();
        gbl_panel.columnWidths = new int[]{0, 0, 0, 0, 0};
        gbl_panel.rowHeights = new int[]{0, 0, 0, 0, 0, 0};
        gbl_panel.columnWeights = new double[]{1.0, 0.2, 0.6, 0.2, 1.0};
        gbl_panel.rowWeights = new double[]{1.0, 0.0, 0.0, 0.0, 0.0, 1.0};
        panel.setLayout(gbl_panel);

        JLabel etiquetaImagen = new JLabel();
        etiquetaImagen.setIcon(new ImageIcon("C:\\\\Users\\\\usuario\\\\eclipse-workspace\\\\Proyecto_2\\\\Imagenes\\\\Registro.png"));
        GridBagConstraints gbc_etiquetaImagen = new GridBagConstraints();
        gbc_etiquetaImagen.insets = new Insets(10, 10, 5, 10);
        gbc_etiquetaImagen.gridx = 2;
        gbc_etiquetaImagen.gridy = 0;
        gbc_etiquetaImagen.anchor = GridBagConstraints.CENTER;
        panel.add(etiquetaImagen, gbc_etiquetaImagen);

        JLabel etiquetaNombre = new JLabel("Nombre:");
        etiquetaNombre.setForeground(Color.WHITE);
        GridBagConstraints gbc_etiquetaNombre = new GridBagConstraints();
        gbc_etiquetaNombre.insets = new Insets(0, 0, 5, 5);
        gbc_etiquetaNombre.gridx = 1;
        gbc_etiquetaNombre.gridy = 1;
        panel.add(etiquetaNombre, gbc_etiquetaNombre);

        campoNombre = new JTextField();
        GridBagConstraints gbc_campoNombre = new GridBagConstraints();
        gbc_campoNombre.insets = new Insets(10, 10, 5, 10);
        gbc_campoNombre.gridx = 2;
        gbc_campoNombre.gridy = 1;
        gbc_campoNombre.fill = GridBagConstraints.HORIZONTAL;
        campoNombre.setColumns(10);
        panel.add(campoNombre, gbc_campoNombre);

        JLabel etiquetaContraseña = new JLabel("Contraseña:");
        etiquetaContraseña.setForeground(Color.WHITE);
        GridBagConstraints gbc_etiquetaContraseña = new GridBagConstraints();
        gbc_etiquetaContraseña.insets = new Insets(0, 0, 5, 5);
        gbc_etiquetaContraseña.gridx = 1;
        gbc_etiquetaContraseña.gridy = 2;
        panel.add(etiquetaContraseña, gbc_etiquetaContraseña);

        campoContraseña = new JPasswordField();
        GridBagConstraints gbc_campoContraseña = new GridBagConstraints();
        gbc_campoContraseña.insets = new Insets(5, 10, 10, 10);
        gbc_campoContraseña.gridx = 2;
        gbc_campoContraseña.gridy = 2;
        gbc_campoContraseña.fill = GridBagConstraints.HORIZONTAL;
        campoContraseña.setColumns(10);
        panel.add(campoContraseña, gbc_campoContraseña);

        String[] tipos = {"Comprador", "Artista"};
        tipoUsuario = new JComboBox<>(tipos);
        GridBagConstraints gbc_tipoUsuario = new GridBagConstraints();
        gbc_tipoUsuario.insets = new Insets(10, 10, 5, 10);
        gbc_tipoUsuario.gridx = 2;
        gbc_tipoUsuario.gridy = 3;
        gbc_tipoUsuario.fill = GridBagConstraints.HORIZONTAL;
        panel.add(tipoUsuario, gbc_tipoUsuario);

        botonRegistrarse = new JButton("Registrarse");
        botonRegistrarse.setBackground(new Color(25, 25, 112));
        botonRegistrarse.setForeground(Color.WHITE);
        GridBagConstraints gbc_botonRegistrarse = new GridBagConstraints();
        gbc_botonRegistrarse.insets = new Insets(10, 10, 10, 10);
        gbc_botonRegistrarse.gridx = 2;
        gbc_botonRegistrarse.gridy = 4;
        gbc_botonRegistrarse.anchor = GridBagConstraints.CENTER;
        botonRegistrarse.addActionListener(this);
        panel.add(botonRegistrarse, gbc_botonRegistrarse);

        this.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{this.getContentPane(), panel, campoNombre, campoContraseña, botonRegistrarse, etiquetaNombre, etiquetaContraseña}));
        this.setVisible(true);
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == botonRegistrarse) {
            String nombre = campoNombre.getText();
            String contraseña = new String(campoContraseña.getPassword());
            String tipo = (String) tipoUsuario.getSelectedItem();

            // Verificar el tipo de usuario seleccionado
            if (tipo.equals("Comprador")) {
                galeria.aniadirUsuario(new Comprador(nombre, contraseña));
            } else if (tipo.equals("Artista")) {
                galeria.aniadirUsuario(new Artista(nombre, contraseña));
            } else {
                // Manejar un caso inesperado (opcional)
                System.out.println("Tipo de usuario no reconocido.");
                return;
            }

            JOptionPane.showMessageDialog(this, "Usuario registrado con éxito", "Registro Exitoso", JOptionPane.INFORMATION_MESSAGE);
            new InterfazSesion(galeria).setVisible(true);
            this.dispose();
        }
    }
}