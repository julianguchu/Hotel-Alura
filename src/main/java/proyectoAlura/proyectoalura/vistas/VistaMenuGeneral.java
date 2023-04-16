package proyectoAlura.proyectoalura.vistas;



import javax.swing.JFrame;

import proyectoAlura.proyectoalura.Eventos.EventosBotones;

public class VistaMenuGeneral extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private  PanelMenuGeneral panelMenu;

	public VistaMenuGeneral()  {
		setSize(500, 500);
		setTitle("Menu Principal");
		panelMenu= new PanelMenuGeneral();
		panelMenu.getBotonCrearReserva().addActionListener(new EventosBotones(this));
		panelMenu.getBotonListarTodos().addActionListener(new EventosBotones(this));
		panelMenu.getBotonCerrarSesion().addActionListener(new EventosBotones(this));
		add(panelMenu);
		setResizable(false);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}

	public PanelMenuGeneral getPanelMenu() {
		return panelMenu;
	}

	public void setPanelMenu(PanelMenuGeneral panelMenu) {
		this.panelMenu = panelMenu;
	}

	



}
