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

public class PanelPedirCupoCompra extends JFrame implements ActionListener {

    private static final long serialVersionUID = 1L;
    private JTextField campoNombre;
    private JTextField campoMonto;
    private JButton botonEnviarSolicitud;

    public PanelPedirCupoCompra(JFrame frame, Galeria galeria, Usuario usuario) {
        initialize();
    }

    private void initialize() {
        this.setBackground(new Color(240, 240, 240));
        this.setBounds(100, 100, 500, 300);
        this.setTitle("Pedir Cupo de Compra");
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

        JLabel etiquetaNombre = new JLabel("Nombre:");
        etiquetaNombre.setForeground(Color.BLACK);
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

        JLabel etiquetaMonto = new JLabel("Monto:");
        etiquetaMonto.setForeground(Color.BLACK);
        GridBagConstraints gbc_etiquetaMonto = new GridBagConstraints();
        gbc_etiquetaMonto.insets = new Insets(0, 0, 5, 5);
        gbc_etiquetaMonto.gridx = 1;
        gbc_etiquetaMonto.gridy = 2;
        panel.add(etiquetaMonto, gbc_etiquetaMonto);

        campoMonto = new JTextField();
        GridBagConstraints gbc_campoMonto = new GridBagConstraints();
        gbc_campoMonto.insets = new Insets(5, 10, 10, 10);
        gbc_campoMonto.gridx = 2;
        gbc_campoMonto.gridy = 2;
        gbc_campoMonto.fill = GridBagConstraints.HORIZONTAL;
        campoMonto.setColumns(10);
        panel.add(campoMonto, gbc_campoMonto);

        botonEnviarSolicitud = new JButton("Enviar Solicitud");
        botonEnviarSolicitud.setBackground(new Color(25, 25, 112));
        botonEnviarSolicitud.setForeground(Color.WHITE);
        GridBagConstraints gbc_botonEnviarSolicitud = new GridBagConstraints();
        gbc_botonEnviarSolicitud.insets = new Insets(10, 10, 10, 10);
        gbc_botonEnviarSolicitud.gridx = 2;
        gbc_botonEnviarSolicitud.gridy = 3;
        gbc_botonEnviarSolicitud.anchor = GridBagConstraints.CENTER;
        botonEnviarSolicitud.addActionListener(this);
        panel.add(botonEnviarSolicitud, gbc_botonEnviarSolicitud);

        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == botonEnviarSolicitud) {
            String nombre = campoNombre.getText();
            String monto = campoMonto.getText();

           
            if (nombre.isEmpty() || monto.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Por favor, completa todos los campos.", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                try {
                    double montoSolicitado = Double.parseDouble(monto);
                    
                    JOptionPane.showMessageDialog(this, "Solicitud enviada con éxito", "Solicitud Exitosa", JOptionPane.INFORMATION_MESSAGE);
                    
                    this.dispose();
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(this, "Por favor, ingresa un monto válido.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }

   
}