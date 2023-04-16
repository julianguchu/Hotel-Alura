package proyectoAlura.proyectoalura.vistas;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;


import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

import javax.swing.JPanel;









public class PanelMenuGeneral extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;



	private JLabel labelTitulo;
	

	
	private JButton botonCrearReserva;
	private JButton botonListarTodos;
	private JButton botonCerrarSesion;
	
	

	public PanelMenuGeneral() {

		organizarPanel();

	}

	public void organizarPanel() {

		this.setSize(400, 400);
		this.setLayout(null);

		labelTitulo = new JLabel("Bienvenido al Hotel Alura");
		labelTitulo.setFont(new Font("Verdana", Font.PLAIN, 18));
		labelTitulo.setBounds(150, 30, 300, 50);
		

		

		botonCrearReserva = new JButton("Crear Reserva");
		botonCrearReserva.setName("botonMCrearReserva");
		botonCrearReserva.setBounds(110, 200, 300, 30);
		
		botonListarTodos = new JButton("Listar Reservas Y Huespedes");
		botonListarTodos.setName("botonMTodos");
		botonListarTodos.setBounds(110, 300, 300, 30);
	
		botonCerrarSesion = new JButton("Cerrar Sesión");
		botonCerrarSesion.setName("botonMCerrarSesion");
		botonCerrarSesion.setBounds(110, 400, 300, 30);
	
		
		

		this.add(labelTitulo);
	
		this.add(botonCrearReserva);

		this.add(botonListarTodos);

		this.add(botonCerrarSesion);

	}

	public JLabel getLabelTitulo() {
		return labelTitulo;
	}

	public void setLabelTitulo(JLabel labelTitulo) {
		this.labelTitulo = labelTitulo;
	}

	

	public JButton getBotonCrearReserva() {
		return botonCrearReserva;
	}

	public void setBotonCrearReserva(JButton botonCrearReserva) {
		this.botonCrearReserva = botonCrearReserva;
	}

	public JButton getBotonListarTodos() {
		return botonListarTodos;
	}

	public void setBotonListarTodos(JButton botonListarTodos) {
		this.botonListarTodos = botonListarTodos;
	}

	public JButton getBotonCerrarSesion() {
		return botonCerrarSesion;
	}

	public void setBotonCerrarSesion(JButton botonCerrarSesion) {
		this.botonCerrarSesion = botonCerrarSesion;
	}
	
	@Override
	public void paint(Graphics g) {
		Image imagen = new ImageIcon(getClass().getResource("/reserva.jpg")).getImage();
		g.drawImage(imagen, 0, 0, 500, 500, this);

		setOpaque(false);
		super.paint(g);
	}


}
