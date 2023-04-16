package proyectoAlura.proyectoalura.vistas;



import javax.swing.JFrame;
import javax.swing.JTabbedPane;

import proyectoAlura.proyectoalura.Eventos.EventosBotones;



public class VistaTablas extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private  PanelTablas panelTablaReservas;
	private  PanelTablas panelTablaHuesped;

	public VistaTablas()  {
		setSize(500, 500);
		setTitle("Consultas ");
		panelTablaReservas= new PanelTablas(1);
		panelTablaReservas.getBotonBusqueda().addActionListener(new EventosBotones(this));
		panelTablaReservas.getEliminarReg().addActionListener(new EventosBotones(this));
		panelTablaReservas.getActualizarReg().addActionListener(new EventosBotones(this));
		panelTablaReservas.getBotonMenuPrincipal().addActionListener( new EventosBotones(this));
		
		panelTablaHuesped = new PanelTablas(2);
	
		panelTablaHuesped.getBotonBusqueda().addActionListener(new EventosBotones(this));
		panelTablaHuesped.getEliminarReg().addActionListener(new EventosBotones(this));
		panelTablaHuesped.getActualizarReg().addActionListener(new EventosBotones(this));
		panelTablaHuesped.getBotonMenuPrincipal().addActionListener(new EventosBotones(this));
		JTabbedPane pestanas= new JTabbedPane();
	
		pestanas.add("Reservas",panelTablaReservas );
	pestanas.add("Huespedes",panelTablaHuesped );
		
		this.add(pestanas);
		
		
		setResizable(false);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}

	public PanelTablas getPanelTablaReservas() {
		return panelTablaReservas;
	}

	public void setPanelTablaReservas(PanelTablas panelTablaReservas) {
		this.panelTablaReservas = panelTablaReservas;
	}

	public PanelTablas getPanelTablaHuesped() {
		return panelTablaHuesped;
	}

	public void setPanelTablaHuesped(PanelTablas panelTablaHuesped) {
		this.panelTablaHuesped = panelTablaHuesped;
	}


	
	

}
