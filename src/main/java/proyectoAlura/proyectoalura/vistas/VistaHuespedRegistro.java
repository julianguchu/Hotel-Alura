package proyectoAlura.proyectoalura.vistas;



import javax.swing.JFrame;

import proyectoAlura.proyectoalura.Eventos.EventosBotones;

public class VistaHuespedRegistro extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private  PanelHuespedRegistro panelRegistroHuesped;

	public VistaHuespedRegistro()  {
		setSize(500, 500);
		setTitle("Registro Huesped");
		panelRegistroHuesped= new PanelHuespedRegistro();
		panelRegistroHuesped.getBotonCrearHuesped().addActionListener(new EventosBotones(this));
		add(panelRegistroHuesped);
		setResizable(false);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}

	public PanelHuespedRegistro getPanelRegistroHuesped() {
		return panelRegistroHuesped;
	}

	public void setPanelRegistroHuesped(PanelHuespedRegistro panelRegistroHuesped) {
		this.panelRegistroHuesped = panelRegistroHuesped;
	}


	

}
