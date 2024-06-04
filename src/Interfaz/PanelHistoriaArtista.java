package Interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
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

import GaleriaGestionSesion.Usuario;
import GaleriaModelo.Galeria;

public class PanelHistoriaArtista extends JFrame {

    private static final long serialVersionUID = 1L;
    private JTextField campoIDArtista;
    private JButton botonBuscarArtista;

    public PanelHistoriaArtista(Galeria galeria, Usuario usuario, JFrame frame) {
        initialize();
    }

    private void initialize() {
        this.setBackground(new Color(240, 240, 240));
        this.setBounds(100, 100, 500, 300);
        this.setTitle("Historia del Artista");
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

        JLabel etiquetaIDArtista = new JLabel("ID del Artista:");
        etiquetaIDArtista.setForeground(Color.BLACK);
        GridBagConstraints gbc_etiquetaIDArtista = new GridBagConstraints();
        gbc_etiquetaIDArtista.insets = new Insets(0, 0, 5, 5);
        gbc_etiquetaIDArtista.gridx = 1;
        gbc_etiquetaIDArtista.gridy = 1;
        panel.add(etiquetaIDArtista, gbc_etiquetaIDArtista);

        campoIDArtista = new JTextField();
        GridBagConstraints gbc_campoIDArtista = new GridBagConstraints();
        gbc_campoIDArtista.insets = new Insets(10, 10, 5, 10);
        gbc_campoIDArtista.gridx = 2;
        gbc_campoIDArtista.gridy = 1;
        gbc_campoIDArtista.fill = GridBagConstraints.HORIZONTAL;
        campoIDArtista.setColumns(10);
        panel.add(campoIDArtista, gbc_campoIDArtista);

        botonBuscarArtista = new JButton("Buscar Artista");
        botonBuscarArtista.setBackground(new Color(25, 25, 112));
        botonBuscarArtista.setForeground(Color.WHITE);
        GridBagConstraints gbc_botonBuscarArtista = new GridBagConstraints();
        gbc_botonBuscarArtista.insets = new Insets(10, 10, 10, 10);
        gbc_botonBuscarArtista.gridx = 2;
        gbc_botonBuscarArtista.gridy = 2;
        gbc_botonBuscarArtista.anchor = GridBagConstraints.CENTER;
        botonBuscarArtista.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buscarArtista();
            }
        });
        panel.add(botonBuscarArtista, gbc_botonBuscarArtista);

        this.setVisible(true);
    }

    private void buscarArtista() {
        String idArtista = campoIDArtista.getText();

        
        if (idArtista.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor, ingresa el ID del artista.", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
           
            boolean artistaEncontrado = true; 
            if (artistaEncontrado) {
                // Mostrar información del artista
                JOptionPane.showMessageDialog(this, "Historia del artista:\nID: " + idArtista + "\nNombre: Ejemplo\nHistoria: Esta es la historia del artista.", "Artista Encontrado", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "No se encontró ningún artista con el ID proporcionado.", "Artista No Encontrado", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}