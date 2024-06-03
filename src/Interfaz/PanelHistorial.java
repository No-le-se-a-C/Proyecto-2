package Interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;

import GaleriaGestionSesion.Usuario;
import GaleriaModelo.Galeria;

public class PanelHistorial extends JDialog {

		private static final long serialVersionUID = 1L;
		private final JPanel contentPanel = new JPanel();
		private static Galeria galeria;
		private static Usuario usuario;

		/**
		 * Launch the application.
		 */
		public static void main(String[] args) {
			try {
				PanelHistorial dialog = new PanelHistorial(galeria, usuario );
				dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				dialog.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		/**
		 * Create the dialog.
		 */
		public  PanelHistorial( Galeria galeria, Usuario usuario) {
			setBounds(100, 100, 450, 300);
			getContentPane().setLayout(new BorderLayout());
			contentPanel.setForeground(Color.WHITE);
			contentPanel.setBackground(new Color(25, 25, 112));
			contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
			getContentPane().add(contentPanel, BorderLayout.CENTER);
			contentPanel.setLayout(new BorderLayout(0, 0));
			{
				JLabel Encabezado = new JLabel("Historial de pieza");
				Encabezado.setForeground(Color.WHITE);
				Encabezado.setFont(new Font("Arial", Font.PLAIN, 11));
				Encabezado.setBackground(new Color(0, 102, 255));
				contentPanel.add(Encabezado, BorderLayout.NORTH);
			}
	
				{
					JTextPane Historial = new JTextPane();
					Historial.setFont(new Font("Arial", Font.PLAIN, 11));
					contentPanel.add(Historial, BorderLayout.CENTER);
				}
			{
				JPanel buttonPane = new JPanel();
				buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
				getContentPane().add(buttonPane, BorderLayout.SOUTH);
				{
					JButton okButton = new JButton("OK");
					okButton.setActionCommand("OK");
					buttonPane.add(okButton);
					getRootPane().setDefaultButton(okButton);
				}
			}
		}

	}
