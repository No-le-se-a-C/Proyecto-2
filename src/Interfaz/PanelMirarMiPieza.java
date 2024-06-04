package Interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import GaleriaGestionSesion.Usuario;
import GaleriaModelo.Galeria;

public class PanelMirarMiPieza extends JFrame {

    private static final long serialVersionUID = 1L;
    private JTextField campoIDPieza;
    private JButton botonBuscarPieza;

    public PanelMirarMiPieza(Galeria galeria, Usuario usuario, JFrame frame) {
        initialize();
    }

    private void initialize() {
        this.setBackground(new Color(240, 240, 240));
        this.setBounds(100, 100, 500, 300);
        this.setTitle("Mirar Mi Pieza");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setResizable(false);
        this.setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setBackground(Color.LIGHT_GRAY);
        this.getContentPane().add(panel, BorderLayout.CENTER);
        GridBagLayout gbl_panel = new GridBagLayout();
        gbl_panel.columnWidths = new int[]{0, 0, 0, 0};
        gbl_panel.rowHeights = new int[]{0, 0, 0, 0, 0};
        gbl_panel.columnWeights = new double[]{1.0, 0.0, 0.6, 0.0, 1.0};
        gbl_panel.rowWeights = new double[]{1.0, 0.0, 0.0, 0.0, 1.0};
        panel.setLayout(gbl_panel);

        JLabel etiquetaIDPieza = new JLabel("ID de la Pieza:");
        etiquetaIDPieza.setForeground(Color.BLACK);
        GridBagConstraints gbc_etiquetaIDPieza = new GridBagConstraints();
        gbc_etiquetaIDPieza.insets = new Insets(0, 0, 5, 5);
        gbc_etiquetaIDPieza.gridx = 1;
        gbc_etiquetaIDPieza.gridy = 1;
        panel.add(etiquetaIDPieza, gbc_etiquetaIDPieza);

        campoIDPieza = new JTextField();
        GridBagConstraints gbc_campoIDPieza = new GridBagConstraints();
        gbc_campoIDPieza.insets = new Insets(10, 10, 5, 10);
        gbc_campoIDPieza.gridx = 2;
        gbc_campoIDPieza.gridy = 1;
        gbc_campoIDPieza.fill = GridBagConstraints.HORIZONTAL;
        campoIDPieza.setColumns(10);
        panel.add(campoIDPieza, gbc_campoIDPieza);

        botonBuscarPieza = new JButton("Buscar Pieza");
        botonBuscarPieza.setBackground(new Color(25, 25, 112));
        botonBuscarPieza.setForeground(Color.WHITE);
        GridBagConstraints gbc_botonBuscarPieza = new GridBagConstraints();
        gbc_botonBuscarPieza.insets = new Insets(10, 10, 10, 10);
        gbc_botonBuscarPieza.gridx = 2;
        gbc_botonBuscarPieza.gridy = 2;
        gbc_botonBuscarPieza.anchor = GridBagConstraints.CENTER;
        botonBuscarPieza.addActionListener(e -> buscarPieza());
        panel.add(botonBuscarPieza, gbc_botonBuscarPieza);

        this.setVisible(true);
    }

    private void buscarPieza() {
        String idPieza = campoIDPieza.getText();

       
        if (idPieza.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor, ingresa el ID de la pieza.", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            
            boolean piezaEncontrada = true;
            if (piezaEncontrada) {
                // Mostrar información de la pieza
                JOptionPane.showMessageDialog(this, "Información de la pieza:\nID: " + idPieza + "\nNombre: Ejemplo\nDescripción: Descripción de la pieza", "Pieza Encontrada", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "No se encontró ninguna pieza con el ID proporcionado.", "Pieza No Encontrada", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}