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

import GaleriaGestionSesion.Usuario;
import GaleriaModelo.Galeria;

public class PanelAnadirPieza extends JPanel implements ActionListener{
	
	private Galeria galeria;
	private Usuario usuario;
	private JFrame frame;
	private JButton button1;
	private JButton button2;
	private JButton button3;
	private JButton button4;
	private JButton button5;
	private String tipoPieza;
	
	private JButton botonSubasta, botonVenta;
	
	private JTextField textFieldNombre, textFieldAnioCreacion, textFieldLugarCreacion, textFieldPrecio, textFieldPrecioMinimo; 
	//textfields de escultura
	private JTextField textFieldAltura, textFieldAncho, textFieldMaterial;
	//textfields de video
	private JTextField textFieldDuracion, textFieldFormato;
	//textfields de libro
	private JTextField textFieldGenero;
	//textfields de pintura
	private JTextField textFieldEstilo;
	//textfields de fotografia
	private JTextField textFieldFiltro, textFieldPixeles, textFieldCalidad;

	public PanelAnadirPieza(Galeria galeria, Usuario usuario, JFrame frame) {
        super();
        this.galeria = galeria;
        this.usuario = usuario;
        this.frame=frame;
        
        iniciar();
        
       
		
	}
	
	public void iniciar() {
		frame.dispose();
		this.frame = new InterfazMenu(usuario, galeria);
		frame.setVisible(true);

		setOpaque(true);
		setBackground(Color.white);
		setPreferredSize(new Dimension(500, 660));
		setLayout(new GridBagLayout());

		GridBagConstraints gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.NONE;
		gbc.insets = new Insets(20, 20, 20, 20);
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.anchor = GridBagConstraints.CENTER;

		// Crear y añadir el JLabel
		JLabel label = new JLabel("Que Tipo de pieza desea añadir");
		label.setForeground(Color.black);
		label.setFont(new Font("Arial", Font.BOLD, 20));
		add(label, gbc);

		// Crear los botones manualmente y añadir ActionListeners
		gbc.gridy++;
		button1 = new JButton("Escultura");
		button1.addActionListener(this);
		button1.setPreferredSize(new Dimension(150, 50));
		button1.setBackground(new Color(25, 25, 112));
		button1.setForeground(Color.WHITE);
		add(button1, gbc);

		gbc.gridy++;
		button2 = new JButton("Fotografía");
		button2.addActionListener(this);
		button2.setPreferredSize(new Dimension(150, 50));
		button2.setBackground(new Color(25, 25, 112));
		button2.setForeground(Color.WHITE);
		add(button2, gbc);

		gbc.gridy++;
		button3 = new JButton("Video");
		button3.addActionListener(this);
		button3.setPreferredSize(new Dimension(150, 50));
		button3.setBackground(new Color(25, 25, 112));
		button3.setForeground(Color.WHITE);
		add(button3, gbc);

		gbc.gridy++;
		button4 = new JButton("Libro");
		button4.addActionListener(this);
		button4.setPreferredSize(new Dimension(150, 50));
		button4.setBackground(new Color(25, 25, 112));
		button4.setForeground(Color.WHITE);
		add(button4, gbc);

		gbc.gridy++;
		button5 = new JButton("Pintura");
		button5.addActionListener(this);
		button5.setPreferredSize(new Dimension(150, 50));
		button5.setBackground(new Color(25, 25, 112));
		button5.setForeground(Color.WHITE);
		add(button5, gbc);

		frame.getContentPane().add(this, BorderLayout.EAST);

		frame.revalidate();
		frame.repaint();
			
	} 

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()== button1) {
			anadirEscultura();
		}else if(e.getSource()== button2) {
			anadirFotografia();
		}else if(e.getSource()== button3) {
			anadirVideo();
		}else if(e.getSource()== button4) {
			anadirLibro();
		}else if(e.getSource()== button5) {
			anadirPintura();
		}else if(e.getSource()==botonSubasta) {
			mandarPieza(true);
		}else if(e.getSource()==botonVenta) {
			mandarPieza(false);
		}
		
	}

	private void mandarPieza(boolean subasta) {
		String[] ValoresPieza=new String[10];
		ValoresPieza[0]=tipoPieza;
		
		String titulo=textFieldNombre.getText();
		ValoresPieza[1]=titulo;
		
		String AnioCreacion= textFieldAnioCreacion.getText();
		ValoresPieza[2]=AnioCreacion;
		
		String lugarCreacion= textFieldLugarCreacion.getText();
		ValoresPieza[3]=lugarCreacion;
		
		ValoresPieza[8]=textFieldPrecio.getText();
		
		if(tipoPieza.equals("libro")) {
			ValoresPieza[4]=textFieldGenero.getText();
		}else if(tipoPieza.equals("escultura")) {
			ValoresPieza[4]=textFieldAncho.getText();
			ValoresPieza[5]= textFieldAltura.getText();
			ValoresPieza[6]=textFieldMaterial.getText();
		}else if(tipoPieza.equals("video")) {
			ValoresPieza[4]=textFieldDuracion.getText();
			ValoresPieza[5]=textFieldFormato.getText();
			ValoresPieza[6]=textFieldEstilo.getText();
		}else if(tipoPieza.equals("fotografia")) {
			ValoresPieza[4]=textFieldFiltro.getText();
			ValoresPieza[5]= textFieldPixeles.getText();
			ValoresPieza[6]=textFieldCalidad.getText();
		}else if(tipoPieza.equals("pintura")) {
			ValoresPieza[4]=textFieldAltura.getText();
			ValoresPieza[5]=textFieldAncho.getText();
			ValoresPieza[6]=textFieldEstilo.getText();
		}
		if(subasta) {
			ValoresPieza[7]=textFieldPrecioMinimo.getText();
		}else {
			ValoresPieza[7]="0";
		}
		
		galeria.getInventario().aniadirPieza(galeria, usuario, ValoresPieza, subasta);
		
		JOptionPane.showMessageDialog(frame, "La pieza se mando a verificar");
		JOptionPane.showMessageDialog(frame, "Si quiere ver si ya fue añadida revise en la funcion mirar mi pieza");
	}

	private void anadirLibro() {
		removeAll();
		frame.dispose();
        this.frame = new InterfazMenu(usuario, galeria);
        frame.setVisible(true);
        this.tipoPieza="libro";
		setOpaque(true);
		setBackground(Color.WHITE);
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
		JLabel label1 = new JLabel("Nombre de la pieza:");
		label1.setForeground(Color.BLACK);
		label1.setOpaque(true);
		label1.setBackground(new Color(128, 206, 225));
		add(label1, gbc);

		gbc.gridx = 1;
		textFieldNombre = new JTextField();
		textFieldNombre.setMaximumSize(new Dimension(Integer.MAX_VALUE, 50));
		add(textFieldNombre, gbc);

		// Tercera fila: Label y TextField
		gbc.gridy++;
		gbc.gridx = 0;
		JLabel label2 = new JLabel("Año de creación:");
		label2.setForeground(Color.BLACK);
		label2.setOpaque(true);
		label2.setBackground(new Color(128, 206, 225));
		add(label2, gbc);

		gbc.gridx = 1;
		textFieldAnioCreacion = new JTextField();
		textFieldAnioCreacion.setMaximumSize(new Dimension(Integer.MAX_VALUE, 50));
		add(textFieldAnioCreacion, gbc);

		// Cuarta fila: Label y TextField
		gbc.gridy++;
		gbc.gridx = 0;
		JLabel label3 = new JLabel("Lugar en donde se creó:");
		label3.setForeground(Color.BLACK);
		label3.setOpaque(true);
		label3.setBackground(new Color(128, 206, 225));
		add(label3, gbc);

		gbc.gridx = 1;
		textFieldLugarCreacion = new JTextField();
		textFieldLugarCreacion.setMaximumSize(new Dimension(Integer.MAX_VALUE, 50));
		add(textFieldLugarCreacion, gbc);

		// Quinta fila: Label y TextField
		gbc.gridy++;
		gbc.gridx = 0;
		JLabel label4 = new JLabel("Genero del Libro:");
		label4.setForeground(Color.BLACK);
		label4.setOpaque(true);
		label4.setBackground(new Color(128, 206, 225));
		add(label4, gbc);

		gbc.gridx = 1;
		textFieldGenero = new JTextField();
		textFieldGenero.setMaximumSize(new Dimension(Integer.MAX_VALUE, 50));
		add(textFieldGenero, gbc);
		
		//Sexta Textfile precio
		gbc.gridy++;
		gbc.gridx = 0;
		JLabel label7 = new JLabel("Precio (con el que empieza la subasta o de venta):");
		label7.setForeground(Color.BLACK);
		label7.setOpaque(true);
		label7.setBackground(new Color(128, 206, 225));
		add(label7, gbc);

		gbc.gridx = 1;
		textFieldPrecio = new JTextField();
		textFieldPrecio.setMaximumSize(new Dimension(Integer.MAX_VALUE, 50));
		add(textFieldPrecio, gbc);
	
		//Septima Textfile precioMinimo
		gbc.gridy++;
		gbc.gridx = 0;
		JLabel label8 = new JLabel("PrecioMinimo(no lo diligencie si va para venta):");
		label8.setForeground(Color.BLACK);
		label8.setOpaque(true);
		label8.setBackground(new Color(128, 206, 225));
		add(label8, gbc);

		gbc.gridx = 1;
		textFieldPrecioMinimo = new JTextField();
		textFieldPrecioMinimo.setMaximumSize(new Dimension(Integer.MAX_VALUE, 50));
		add(textFieldPrecioMinimo, gbc);

		
		//botones 
		gbc.gridy++;
		gbc.gridx = 0;
		JLabel labelBotones=new JLabel("Como desea venderla:");
		labelBotones.setFont(new Font("Arial", Font.BOLD, 20)); // Ajusta el tamaño y estilo de la fuente
		labelBotones.setForeground(Color.BLACK);
        add(labelBotones, gbc);
		
		
		gbc.gridy++;
		gbc.gridx = 0;
		botonSubasta = new JButton("Subasta");
		botonSubasta.setOpaque(true);
		botonSubasta.setBackground(new Color(25, 25, 112));
		botonSubasta.setForeground(Color.WHITE);
		botonSubasta.setPreferredSize(new Dimension(80, 50));
		botonSubasta.addActionListener(this);
		add(botonSubasta, gbc);
		
		
		gbc.gridy++;
		gbc.gridx = 0;
		botonVenta= new JButton("Venta");
		botonVenta.setOpaque(true);
		botonVenta.setBackground(new Color(25, 25, 112));
		botonVenta.setForeground(Color.WHITE);
		botonVenta.setPreferredSize(new Dimension(80, 50));
		botonVenta.addActionListener(this);
		add(botonVenta, gbc); 

		frame.add(this, BorderLayout.EAST);
		frame.setVisible(true);

		revalidate();
		repaint();


	}

	private void anadirEscultura() {
		removeAll();
		frame.dispose();
        this.frame = new InterfazMenu(usuario, galeria);
        this.tipoPieza="escultura";
        frame.setVisible(true);
		setOpaque(true);
		setBackground(Color.WHITE);
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
        JLabel titleLabel = new JLabel("Añadir Escultura");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 30)); // Ajusta el tamaño y estilo de la fuente
        titleLabel.setForeground(Color.BLACK);
        add(titleLabel, gbc);
        
        
		// Segunda fila: Label y TextField
		gbc.gridy++;
		gbc.gridx = 0;
		JLabel label1 = new JLabel("Nombre de la pieza:");
		label1.setForeground(Color.BLACK);
		label1.setOpaque(true);
		label1.setBackground(new Color(128, 206, 225));
		add(label1, gbc);

		gbc.gridx = 1;
		textFieldNombre = new JTextField();
		textFieldNombre.setMaximumSize(new Dimension(Integer.MAX_VALUE, 50));
		add(textFieldNombre, gbc);

		// Tercera fila: Label y TextField
		gbc.gridy++;
		gbc.gridx = 0;
		JLabel label2 = new JLabel("Año de creación:");
		label2.setForeground(Color.BLACK);
		label2.setOpaque(true);
		label2.setBackground(new Color(128, 206, 225));
		add(label2, gbc);

		gbc.gridx = 1;
		textFieldAnioCreacion = new JTextField();
		textFieldAnioCreacion.setMaximumSize(new Dimension(Integer.MAX_VALUE, 50));
		add(textFieldAnioCreacion, gbc);

		// Cuarta fila: Label y TextField
		gbc.gridy++;
		gbc.gridx = 0;
		JLabel label3 = new JLabel("Lugar en donde se creó:");
		label3.setForeground(Color.BLACK);
		label3.setOpaque(true);
		label3.setBackground(new Color(128, 206, 225));
		add(label3, gbc);

		gbc.gridx = 1;
		textFieldLugarCreacion = new JTextField();
		textFieldLugarCreacion.setMaximumSize(new Dimension(Integer.MAX_VALUE, 50));
		add(textFieldLugarCreacion, gbc);

		// Quinta fila: Label y TextField
		gbc.gridy++;
		gbc.gridx = 0;
		JLabel label4 = new JLabel("Altura:");
		label4.setForeground(Color.BLACK);
		label4.setOpaque(true);
		label4.setBackground(new Color(128, 206, 225));
		add(label4, gbc);

		gbc.gridx = 1;
		textFieldAltura = new JTextField();
		textFieldAltura.setMaximumSize(new Dimension(Integer.MAX_VALUE, 50));
		add(textFieldAltura, gbc);
		
		// Sexta fila: Label y TextField
		gbc.gridy++;
		gbc.gridx = 0;
		JLabel label5 = new JLabel("Ancho:");
		label5.setForeground(Color.BLACK);
		label5.setOpaque(true);
		label5.setBackground(new Color(128, 206, 225));
		add(label5, gbc);

		gbc.gridx = 1;
		textFieldAncho = new JTextField();
		textFieldAncho.setMaximumSize(new Dimension(Integer.MAX_VALUE, 50));
		add(textFieldAncho, gbc);

		// Septima fila: Label y TextField
		gbc.gridy++;
		gbc.gridx = 0;
		JLabel label6 = new JLabel("Material:");
		label6.setForeground(Color.BLACK);
		label6.setOpaque(true);
		label6.setBackground(new Color(128, 206, 225));
		add(label6, gbc);

		gbc.gridx = 1;
		textFieldMaterial = new JTextField();
		textFieldMaterial.setMaximumSize(new Dimension(Integer.MAX_VALUE, 50));
		add(textFieldMaterial, gbc);

		//Sexta Textfile precio
		gbc.gridy++;
		gbc.gridx = 0;
		JLabel label7 = new JLabel("Precio (con el que empieza la subasta o de venta):");
		label7.setForeground(Color.BLACK);
		label7.setOpaque(true);
		label7.setBackground(new Color(128, 206, 225));
		add(label7, gbc);

		gbc.gridx = 1;
		textFieldPrecio = new JTextField();
		textFieldPrecio.setMaximumSize(new Dimension(Integer.MAX_VALUE, 50));
		add(textFieldPrecio, gbc);
	
		//Septima Textfile precioMinimo
		gbc.gridy++;
		gbc.gridx = 0;
		JLabel label8 = new JLabel("PrecioMinimo(no lo diligencie si va para venta):");
		label8.setForeground(Color.BLACK);
		label8.setOpaque(true);
		label8.setBackground(new Color(128, 206, 225));
		add(label8, gbc);

		gbc.gridx = 1;
		textFieldPrecioMinimo = new JTextField();
		textFieldPrecioMinimo.setMaximumSize(new Dimension(Integer.MAX_VALUE, 50));
		add(textFieldPrecioMinimo, gbc);

		
		//botones 
		gbc.gridy++;
		gbc.gridx = 0;
		JLabel labelBotones=new JLabel("Como desea venderla:");
		labelBotones.setFont(new Font("Arial", Font.BOLD, 20)); // Ajusta el tamaño y estilo de la fuente
		labelBotones.setForeground(Color.BLACK);
        add(labelBotones, gbc);
		
		
		gbc.gridy++;
		gbc.gridx = 0;
		botonSubasta = new JButton("Subasta");
		botonSubasta.setOpaque(true);
		botonSubasta.setBackground(new Color(25, 25, 112));
		botonSubasta.setForeground(Color.WHITE);
		botonSubasta.setPreferredSize(new Dimension(80, 50));
		botonSubasta.addActionListener(this);
		add(botonSubasta, gbc);
		
		
		gbc.gridy++;
		gbc.gridx = 0;
		botonVenta= new JButton("Venta");
		botonVenta.setOpaque(true);
		botonVenta.setBackground(new Color(25, 25, 112));
		botonVenta.setForeground(Color.WHITE);
		botonVenta.setPreferredSize(new Dimension(80, 50));
		botonVenta.addActionListener(this);
		add(botonVenta, gbc); 

		frame.add(this, BorderLayout.EAST);
		frame.setVisible(true);

		revalidate();
		repaint();
		
	}


	private void anadirVideo() {
		removeAll();
		this.tipoPieza="video";
		frame.dispose();
        this.frame = new InterfazMenu(usuario, galeria);
        frame.setVisible(true);
		setOpaque(true);
		setBackground(Color.WHITE);
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
        JLabel titleLabel = new JLabel("Añadir video");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 30)); // Ajusta el tamaño y estilo de la fuente
        titleLabel.setForeground(Color.BLACK);
        add(titleLabel, gbc);
        
        
		// Segunda fila: Label y TextField
		gbc.gridy++;
		gbc.gridx = 0;
		JLabel label1 = new JLabel("Nombre de la pieza:");
		label1.setForeground(Color.BLACK);
		label1.setOpaque(true);
		label1.setBackground(new Color(128, 206, 225));
		add(label1, gbc);

		gbc.gridx = 1;
		textFieldNombre = new JTextField();
		textFieldNombre.setMaximumSize(new Dimension(Integer.MAX_VALUE, 50));
		add(textFieldNombre, gbc);

		// Tercera fila: Label y TextField
		gbc.gridy++;
		gbc.gridx = 0;
		JLabel label2 = new JLabel("Año de creación:");
		label2.setForeground(Color.BLACK);
		label2.setOpaque(true);
		label2.setBackground(new Color(128, 206, 225));
		add(label2, gbc);

		gbc.gridx = 1;
		textFieldAnioCreacion = new JTextField();
		textFieldAnioCreacion.setMaximumSize(new Dimension(Integer.MAX_VALUE, 50));
		add(textFieldAnioCreacion, gbc);

		// Cuarta fila: Label y TextField
		gbc.gridy++;
		gbc.gridx = 0;
		JLabel label3 = new JLabel("Lugar en donde se creó:");
		label3.setForeground(Color.BLACK);
		label3.setOpaque(true);
		label3.setBackground(new Color(128, 206, 225));
		add(label3, gbc);

		gbc.gridx = 1;
		textFieldLugarCreacion = new JTextField();
		textFieldLugarCreacion.setMaximumSize(new Dimension(Integer.MAX_VALUE, 50));
		add(textFieldLugarCreacion, gbc);

		// Quinta fila: Label y TextField
		gbc.gridy++;
		gbc.gridx = 0;
		JLabel label4 = new JLabel("Duracion:");
		label4.setForeground(Color.BLACK);
		label4.setOpaque(true);
		label4.setBackground(new Color(128, 206, 225));
		add(label4, gbc);

		gbc.gridx = 1;
		textFieldDuracion = new JTextField();
		textFieldDuracion.setMaximumSize(new Dimension(Integer.MAX_VALUE, 50));
		add(textFieldDuracion, gbc);
		
		//Sexta fila
		gbc.gridy++;
		gbc.gridx = 0;
		JLabel label5 = new JLabel("Formato:");
		label5.setForeground(Color.BLACK);
		label5.setOpaque(true);
		label5.setBackground(new Color(128, 206, 225));
		add(label5, gbc);

		gbc.gridx = 1;
		textFieldFormato= new JTextField();
		textFieldFormato.setMaximumSize(new Dimension(Integer.MAX_VALUE, 50));
		add(textFieldFormato, gbc);
		
		//Septima Fila
		gbc.gridy++;
		gbc.gridx = 0;
		JLabel label6 = new JLabel("Estilo:");
		label6.setForeground(Color.BLACK);
		label6.setOpaque(true);
		label6.setBackground(new Color(128, 206, 225));
		add(label6, gbc);

		gbc.gridx = 1;
		textFieldEstilo= new JTextField();
		textFieldEstilo.setMaximumSize(new Dimension(Integer.MAX_VALUE, 50));
		add(textFieldEstilo, gbc);

		//Sexta Textfile precio
		gbc.gridy++;
		gbc.gridx = 0;
		JLabel label7 = new JLabel("Precio (con el que empieza la subasta o de venta):");
		label7.setForeground(Color.BLACK);
		label7.setOpaque(true);
		label7.setBackground(new Color(128, 206, 225));
		add(label7, gbc);

		gbc.gridx = 1;
		textFieldPrecio = new JTextField();
		textFieldPrecio.setMaximumSize(new Dimension(Integer.MAX_VALUE, 50));
		add(textFieldPrecio, gbc);

		//Septima Textfile precioMinimo
		gbc.gridy++;
		gbc.gridx = 0;
		JLabel label8 = new JLabel("PrecioMinimo(no lo diligencie si va para venta):");
		label8.setForeground(Color.BLACK);
		label8.setOpaque(true);
		label8.setBackground(new Color(128, 206, 225));
		add(label8, gbc);

		gbc.gridx = 1;
		textFieldPrecioMinimo = new JTextField();
		textFieldPrecioMinimo.setMaximumSize(new Dimension(Integer.MAX_VALUE, 50));
		add(textFieldPrecioMinimo, gbc);
		//botones 
		gbc.gridy++;
		gbc.gridx = 0;
		JLabel labelBotones=new JLabel("Como desea venderla:");
		labelBotones.setFont(new Font("Arial", Font.BOLD, 20)); // Ajusta el tamaño y estilo de la fuente
		labelBotones.setForeground(Color.BLACK);
        add(labelBotones, gbc);
		
		
		gbc.gridy++;
		gbc.gridx = 0;
		botonSubasta = new JButton("Subasta");
		botonSubasta.setOpaque(true);
		botonSubasta.setBackground(new Color(25, 25, 112));
		botonSubasta.setForeground(Color.WHITE);
		botonSubasta.setPreferredSize(new Dimension(80, 50));
		botonSubasta.addActionListener(this);
		add(botonSubasta, gbc);
		
		
		gbc.gridy++;
		gbc.gridx = 0;
		botonVenta= new JButton("Venta");
		botonVenta.setOpaque(true);
		botonVenta.setBackground(new Color(25, 25, 112));
		botonVenta.setForeground(Color.WHITE);
		botonVenta.setPreferredSize(new Dimension(80, 50));
		botonVenta.addActionListener(this);
		add(botonVenta, gbc); 

		frame.add(this, BorderLayout.EAST);
		frame.setVisible(true);

		revalidate();
		repaint();
		
	}

	private void anadirFotografia() {
		removeAll();
		frame.dispose();
		this.tipoPieza="fotografia";
        this.frame = new InterfazMenu(usuario, galeria);
        frame.setVisible(true);
		setOpaque(true);
		setBackground(Color.WHITE);
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
        JLabel titleLabel = new JLabel("Añadir fotografia");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 30)); // Ajusta el tamaño y estilo de la fuente
        titleLabel.setForeground(Color.BLACK);
        add(titleLabel, gbc);
        
        
		// Segunda fila: Label y TextField
		gbc.gridy++;
		gbc.gridx = 0;
		JLabel label1 = new JLabel("Nombre de la pieza:");
		label1.setForeground(Color.BLACK);
		label1.setOpaque(true);
		label1.setBackground(new Color(128, 206, 225));
		add(label1, gbc);

		gbc.gridx = 1;
		textFieldNombre = new JTextField();
		textFieldNombre.setMaximumSize(new Dimension(Integer.MAX_VALUE, 50));
		add(textFieldNombre, gbc);

		// Tercera fila: Label y TextField
		gbc.gridy++;
		gbc.gridx = 0;
		JLabel label2 = new JLabel("Año de creación:");
		label2.setForeground(Color.BLACK);
		label2.setOpaque(true);
		label2.setBackground(new Color(128, 206, 225));
		add(label2, gbc);

		gbc.gridx = 1;
		textFieldAnioCreacion = new JTextField();
		textFieldAnioCreacion.setMaximumSize(new Dimension(Integer.MAX_VALUE, 50));
		add(textFieldAnioCreacion, gbc);

		// Cuarta fila: Label y TextField
		gbc.gridy++;
		gbc.gridx = 0;
		JLabel label3 = new JLabel("Lugar en donde se creó:");
		label3.setForeground(Color.BLACK);
		label3.setOpaque(true);
		label3.setBackground(new Color(128, 206, 225));
		add(label3, gbc);

		gbc.gridx = 1;
		textFieldLugarCreacion = new JTextField();
		textFieldLugarCreacion.setMaximumSize(new Dimension(Integer.MAX_VALUE, 50));
		add(textFieldLugarCreacion, gbc);

		// Quinta fila: Label y TextField
		gbc.gridy++;
		gbc.gridx = 0;
		JLabel label4 = new JLabel("Filtro:");
		label4.setForeground(Color.BLACK);
		label4.setOpaque(true);
		label4.setBackground(new Color(128, 206, 225));
		add(label4, gbc);

		gbc.gridx = 1;
		textFieldFiltro = new JTextField();
		textFieldFiltro.setMaximumSize(new Dimension(Integer.MAX_VALUE, 50));
		add(textFieldFiltro, gbc);
		
		// Sexta fila: Label y TextField
		gbc.gridy++;
		gbc.gridx = 0;
		JLabel label5 = new JLabel("Pixeles:");
		label5.setForeground(Color.BLACK);
		label5.setOpaque(true);
		label5.setBackground(new Color(128, 206, 225));
		add(label5, gbc);

		gbc.gridx = 1;
		textFieldPixeles = new JTextField();
		textFieldPixeles.setMaximumSize(new Dimension(Integer.MAX_VALUE, 50));
		add(textFieldPixeles, gbc);

		// Septima fila: Label y TextField
		gbc.gridy++;
		gbc.gridx = 0;
		JLabel label6 = new JLabel("Calidad:");
		label6.setForeground(Color.BLACK);
		label6.setOpaque(true);
		label6.setBackground(new Color(128, 206, 225));
		add(label6, gbc);

		gbc.gridx = 1;
		textFieldCalidad = new JTextField();
		textFieldCalidad.setMaximumSize(new Dimension(Integer.MAX_VALUE, 50));
		add(textFieldCalidad, gbc);

		//Sexta Textfile precio
		gbc.gridy++;
		gbc.gridx = 0;
		JLabel label7 = new JLabel("Precio (con el que empieza la subasta o de venta):");
		label7.setForeground(Color.BLACK);
		label7.setOpaque(true);
		label7.setBackground(new Color(128, 206, 225));
		add(label7, gbc);

		gbc.gridx = 1;
		textFieldPrecio = new JTextField();
		textFieldPrecio.setMaximumSize(new Dimension(Integer.MAX_VALUE, 50));
		add(textFieldPrecio, gbc);

		//Septima Textfile precioMinimo
		gbc.gridy++;
		gbc.gridx = 0;
		JLabel label8 = new JLabel("PrecioMinimo(no lo diligencie si va para venta):");
		label8.setForeground(Color.BLACK);
		label8.setOpaque(true);
		label8.setBackground(new Color(128, 206, 225));
		add(label8, gbc);

		gbc.gridx = 1;
		textFieldPrecioMinimo = new JTextField();
		textFieldPrecioMinimo.setMaximumSize(new Dimension(Integer.MAX_VALUE, 50));
		add(textFieldPrecioMinimo, gbc);

		//botones 
		gbc.gridy++;
		gbc.gridx = 0;
		JLabel labelBotones=new JLabel("Como desea venderla:");
		labelBotones.setFont(new Font("Arial", Font.BOLD, 20)); // Ajusta el tamaño y estilo de la fuente
		labelBotones.setForeground(Color.BLACK);
        add(labelBotones, gbc);
		
		
		gbc.gridy++;
		gbc.gridx = 0;
		botonSubasta = new JButton("Subasta");
		botonSubasta.setOpaque(true);
		botonSubasta.setBackground(new Color(25, 25, 112));
		botonSubasta.setForeground(Color.WHITE);
		botonSubasta.setPreferredSize(new Dimension(80, 50));
		botonSubasta.addActionListener(this);
		add(botonSubasta, gbc);
		
		
		gbc.gridy++;
		gbc.gridx = 0;
		botonVenta= new JButton("Venta");
		botonVenta.setOpaque(true);
		botonVenta.setBackground(new Color(25, 25, 112));
		botonVenta.setForeground(Color.WHITE);
		botonVenta.setPreferredSize(new Dimension(80, 50));
		botonVenta.addActionListener(this);
		add(botonVenta, gbc); 

		frame.add(this, BorderLayout.EAST);
		frame.setVisible(true);

		revalidate();
		repaint();
		
	}

	private void anadirPintura() {
		removeAll();
		this.tipoPieza="pintura";
		frame.dispose();
        this.frame = new InterfazMenu(usuario, galeria);
        frame.setVisible(true);
		setOpaque(true);
		setBackground(Color.WHITE);
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
        JLabel titleLabel = new JLabel("Añadir pintura");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 30)); // Ajusta el tamaño y estilo de la fuente
        titleLabel.setForeground(Color.BLACK);
        add(titleLabel, gbc);
        
        
		// Segunda fila: Label y TextField
		gbc.gridy++;
		gbc.gridx = 0;
		JLabel label1 = new JLabel("Nombre de la pieza:");
		label1.setForeground(Color.BLACK);
		label1.setOpaque(true);
		label1.setBackground(new Color(128, 206, 225));
		add(label1, gbc);

		gbc.gridx = 1;
		textFieldNombre = new JTextField();
		textFieldNombre.setMaximumSize(new Dimension(Integer.MAX_VALUE, 50));
		add(textFieldNombre, gbc);

		// Tercera fila: Label y TextField
		gbc.gridy++;
		gbc.gridx = 0;
		JLabel label2 = new JLabel("Año de creación:");
		label2.setForeground(Color.BLACK);
		label2.setOpaque(true);
		label2.setBackground(new Color(128, 206, 225));
		add(label2, gbc);

		gbc.gridx = 1;
		textFieldAnioCreacion = new JTextField();
		textFieldAnioCreacion.setMaximumSize(new Dimension(Integer.MAX_VALUE, 50));
		add(textFieldAnioCreacion, gbc);

		// Cuarta fila: Label y TextField
		gbc.gridy++;
		gbc.gridx = 0;
		JLabel label3 = new JLabel("Lugar en donde se creó:");
		label3.setForeground(Color.BLACK);
		label3.setOpaque(true);
		label3.setBackground(new Color(128, 206, 225));
		add(label3, gbc);

		gbc.gridx = 1;
		textFieldLugarCreacion = new JTextField();
		textFieldLugarCreacion.setMaximumSize(new Dimension(Integer.MAX_VALUE, 50));
		add(textFieldLugarCreacion, gbc);

		// Quinta fila: Label y TextField
		gbc.gridy++;
		gbc.gridx = 0;
		JLabel label4 = new JLabel("Altura:");
		label4.setForeground(Color.BLACK);
		label4.setOpaque(true);
		label4.setBackground(new Color(128, 206, 225));
		add(label4, gbc);

		gbc.gridx = 1;
		textFieldAltura = new JTextField();
		textFieldAltura.setMaximumSize(new Dimension(Integer.MAX_VALUE, 50));
		add(textFieldAltura, gbc);

		// Sexta fila: Label y TextField
		gbc.gridy++;
		gbc.gridx = 0;
		JLabel label5 = new JLabel("Ancho:");
		label5.setForeground(Color.BLACK);
		label5.setOpaque(true);
		label5.setBackground(new Color(128, 206, 225));
		add(label5, gbc);

		gbc.gridx = 1;
		textFieldAncho = new JTextField();
		textFieldAncho.setMaximumSize(new Dimension(Integer.MAX_VALUE, 50));
		add(textFieldAncho, gbc);

		// Septima fila: Label y TextField
		gbc.gridy++;
		gbc.gridx = 0;
		JLabel label6 = new JLabel("Estilo:");
		label6.setForeground(Color.BLACK);
		label6.setOpaque(true);
		label6.setBackground(new Color(128, 206, 225));
		add(label6, gbc);

		gbc.gridx = 1;
		textFieldEstilo = new JTextField();
		textFieldEstilo.setMaximumSize(new Dimension(Integer.MAX_VALUE, 50));
		add(textFieldEstilo, gbc);

		//Sexta Textfile precio
		gbc.gridy++;
		gbc.gridx = 0;
		JLabel label7 = new JLabel("Precio (con el que empieza la subasta o de venta):");
		label7.setForeground(Color.BLACK);
		label7.setOpaque(true);
		label7.setBackground(new Color(128, 206, 225));
		add(label7, gbc);

		gbc.gridx = 1;
		textFieldPrecio = new JTextField();
		textFieldPrecio.setMaximumSize(new Dimension(Integer.MAX_VALUE, 50));
		add(textFieldPrecio, gbc);

		//Septima Textfile precioMinimo
		gbc.gridy++;
		gbc.gridx = 0;
		JLabel label8 = new JLabel("PrecioMinimo(no lo diligencie si va para venta):");
		label8.setForeground(Color.BLACK);
		label8.setOpaque(true);
		label8.setBackground(new Color(128, 206, 225));
		add(label8, gbc);

		gbc.gridx = 1;
		textFieldPrecioMinimo = new JTextField();
		textFieldPrecioMinimo.setMaximumSize(new Dimension(Integer.MAX_VALUE, 50));
		add(textFieldPrecioMinimo, gbc);

		//botones 
		gbc.gridy++;
		gbc.gridx = 0;
		JLabel labelBotones=new JLabel("Como desea venderla:");
		labelBotones.setFont(new Font("Arial", Font.BOLD, 20)); // Ajusta el tamaño y estilo de la fuente
		labelBotones.setForeground(Color.BLACK);
        add(labelBotones, gbc);
		
		
		gbc.gridy++;
		gbc.gridx = 0;
		botonSubasta = new JButton("Subasta");
		botonSubasta.setOpaque(true);
		botonSubasta.setBackground(new Color(25, 25, 112));
		botonSubasta.setForeground(Color.WHITE);
		botonSubasta.setPreferredSize(new Dimension(80, 50));
		botonSubasta.addActionListener(this);
		add(botonSubasta, gbc);
		
		
		gbc.gridy++;
		gbc.gridx = 0;
		botonVenta= new JButton("Venta");
		botonVenta.setOpaque(true);
		botonVenta.setBackground(new Color(25, 25, 112));
		botonVenta.setForeground(Color.WHITE);
		botonVenta.setPreferredSize(new Dimension(80, 50));
		botonVenta.addActionListener(this);
		add(botonVenta, gbc); 

		frame.add(this, BorderLayout.EAST);
		frame.setVisible(true);

		revalidate();
		repaint();
		
	}
}
