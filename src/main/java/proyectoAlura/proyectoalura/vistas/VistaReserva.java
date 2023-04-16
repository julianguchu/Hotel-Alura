package proyectoAlura.proyectoalura.vistas;



import javax.swing.JFrame;

import proyectoAlura.proyectoalura.Eventos.EventosBotones;

public class VistaReserva extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private  PanelReserva panelReserva;

	public VistaReserva()  {
		setSize(500, 500);
		setTitle("Registro Reserva");
		panelReserva= new PanelReserva();
		panelReserva.getBotonCrearReserva().addActionListener(new EventosBotones(this));
		add(panelReserva);
		setResizable(false);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}

	public PanelReserva getPanelReserva() {
		return panelReserva;
	}

	public void setPanelReserva(PanelReserva panelReserva) {
		this.panelReserva = panelReserva;
	}
	
	

}
