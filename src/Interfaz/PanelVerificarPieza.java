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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.lang.reflect.Array;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListModel;
import javax.swing.ListSelectionModel;

import GaleriaGestionSesion.Usuario;
import GaleriaModelo.Galeria;
import GaleriaPieza.Pieza;
import GaleriaEmpleados.Administrador;

public class PanelVerificarPieza extends JPanel {
	
	private Galeria galeria;
	private Usuario usuario;
	private JFrame frame;
	private ArrayList<Pieza> solicitudes;
    private DefaultListModel<Pieza> listModel;
	
	public PanelVerificarPieza(Galeria galeria, Usuario usuario, JFrame frame) {
		super();
        this.galeria = galeria;
        this.usuario = usuario;
        this.frame=frame;
        
        Administrador admin=(Administrador) galeria.getMapaUsuariosEmpleados().get("Administrador");
        ArrayList<Pieza> solicitudes= admin.getPiezasPorAnadir();
        this.solicitudes=solicitudes;
        iniciar();
        
	}
	
	private void iniciar() {

        frame.dispose();
        this.frame = new InterfazMenu(usuario, galeria);

        setOpaque(true);
        setBackground(Color.white);
        setPreferredSize(new Dimension(500, 660));
        setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 0.5;
        gbc.weighty = 0.5;

        JLabel label = new JLabel("Piezas Por Añadir:");
        label.setForeground(Color.black);
        label.setOpaque(true);
        label.setBackground(new Color(128, 206, 225));
        label.setFont(new Font("Arial", Font.BOLD, 35));
        add(label, gbc);

        // Crear el modelo de la lista y agregar los elementos
        listModel = new DefaultListModel<>();
        for (Pieza pieza : solicitudes) {
            listModel.addElement(pieza);
        }

        // Crear el JList
        JList<Pieza> jList = new JList<>(listModel);
        jList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        jList.setOpaque(true);
        jList.setBackground(new Color(25, 25, 112));
        jList.setForeground(Color.WHITE);

        // Agregar el MouseListener
        jList.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                JList<?> list = (JList<?>) evt.getSource();
                if (evt.getClickCount() == 1) { // Un clic para abrir JOptionPane
                    int index = list.locationToIndex(evt.getPoint());
                    Pieza selectedObject = (Pieza) list.getModel().getElementAt(index);
                    
                    // Crear un JOptionPane con botones personalizados
                    int response = JOptionPane.showOptionDialog(frame,
                            "Pieza: " + selectedObject.getTitulo()+"\n"
                            + "Precio: "+ selectedObject.getPrecio().getPrecio()+"\n"+
                            "Año creacion: "+ selectedObject.getAnioCreacion()+"\n"+
                            "Desea admitir esta Pieza?:",
                            "Confirmación",
                            JOptionPane.YES_NO_OPTION,
                            JOptionPane.QUESTION_MESSAGE,
                            null, new String[]{"Sí", "No"}, null);

                    // Definir las acciones para cada botón
                    if (response == JOptionPane.YES_OPTION) {
                        // Acción para el botón "Sí": eliminar el elemento
                        listModel.remove(index);
                        solicitudes.remove(selectedObject);
                        anadirPieza(selectedObject);
                    }else if(response== JOptionPane.NO_OPTION) {
                    	listModel.remove(index);
                        solicitudes.remove(selectedObject);
                        anadirPieza(selectedObject);
                    }
                }
            }

			private void anadirPieza(Pieza pieza) {
				int dia=30;
				int mes=12;
				// Creamos los JTextFields
		        JTextField textField1 = new JTextField(10);
		        JTextField textField2 = new JTextField(10);

		        // Creamos un JPanel para contener los JTextFields
		        JPanel panel = new JPanel();
		        panel.add(new JLabel("Defina que dia acabara la subasta de esta pieza:"));
		        panel.add(Box.createHorizontalStrut(15));
		        panel.add(new JLabel("Dia:"));
		        panel.add(textField1);
		        panel.add(Box.createHorizontalStrut(15)); // Espaciado entre los componentes
		        panel.add(new JLabel("Mes:"));
		        panel.add(textField2);

		        // Mostramos el JOptionPane con el JPanel personalizado
		        int result = JOptionPane.showConfirmDialog(null, panel, "Ingrese Texto", JOptionPane.OK_CANCEL_OPTION);
		        
		        // Si se hace clic en OK, recuperamos el texto de los JTextFields
		        if (result == JOptionPane.OK_OPTION) {
		            dia =Integer.parseInt( textField1.getText());
		            mes = Integer.parseInt(textField2.getText());
		            
		        }
		        
				((Administrador)usuario).validarAniadirPieza(galeria, mes, dia, pieza);
				JOptionPane.showMessageDialog(frame, "La pieza ha sido añadida");
			}
        });

        // Agregar el JList a un JScrollPane
        gbc.gridy++;
        gbc.gridx = 0;
        JScrollPane scrollPane = new JScrollPane(jList);
        add(scrollPane, gbc);

        frame.getContentPane().add(this, BorderLayout.EAST);

        frame.revalidate();
        frame.repaint();
        frame.setVisible(true);
	}

}
