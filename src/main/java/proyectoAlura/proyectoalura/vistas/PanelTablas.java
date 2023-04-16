package proyectoAlura.proyectoalura.vistas;


import java.awt.Panel;

import javax.swing.JButton;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;


import proyectoAlura.proyectoalura.ModeloFacil.Huesped;
import proyectoAlura.proyectoalura.ModeloFacil.Reserva;
import proyectoAlura.proyectoalura.services.HuespedService;
import proyectoAlura.proyectoalura.services.ReservaService;

public class PanelTablas extends Panel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ReservaService reservaService;
	private HuespedService huespedService;
	private JTable tabla ;
	private JButton eliminarReg;
	private JButton actualizarReg;
	private DefaultTableModel modeloTabla = new DefaultTableModel();
	private JTextField cajaBusqueda;
	private JButton botonBusqueda;
	private JScrollPane panelScroll = new JScrollPane();
	private  JButton botonMenuPrincipal;

	public PanelTablas(int tipoPanel) {

		reservaService = new ReservaService();

		if (tipoPanel == 1) {

			cargarTablaReserva();

			panelScroll.setViewportView(tabla);

			cajaBusqueda = new JTextField();
			cajaBusqueda.setBounds(250, 20, 100, 25);

			botonBusqueda = new JButton("Buscar");
			botonBusqueda.setName("buscarReserva");
			botonBusqueda.setBounds(370, 20, 100, 25);
			
			botonMenuPrincipal= new JButton("Ir Menu Principal");
			botonMenuPrincipal.setName("menuPrincipal");
		

			eliminarReg = new JButton("Eliminar");
			eliminarReg.setName("eliminarReserva");

			actualizarReg = new JButton("Actualizar");
			actualizarReg.setName("actualizaReserva");
			this.setSize(500, 500);
			this.setLayout(null);

			panelScroll.setBounds(20, 60, 450, 320);
			botonMenuPrincipal.setBounds(320,400,130,40);
			eliminarReg.setBounds(30, 400, 130, 40);
			actualizarReg.setBounds(170, 400, 130, 40);
			this.add(cajaBusqueda);
			this.add(botonBusqueda);
			this.add(botonMenuPrincipal);
			this.add(panelScroll);
			this.add(eliminarReg);
			this.add(actualizarReg);
		} else {

			cargarTablaHuesped();

			panelScroll.setViewportView(tabla);

			cajaBusqueda = new JTextField();
			cajaBusqueda.setBounds(250, 20, 100, 25);

			botonBusqueda = new JButton("Buscar");
			botonBusqueda.setName("buscarHuesped");
			botonBusqueda.setBounds(370, 20, 100, 25);

			eliminarReg = new JButton("Eliminar");
			eliminarReg.setName("eliminarReserva");
			
			botonMenuPrincipal= new JButton("Ir Menu Principal");
			botonMenuPrincipal.setName("menuPrincipal");
		

			eliminarReg = new JButton("Eliminar H");
			eliminarReg.setName("eliminaHuesped");
			actualizarReg = new JButton("Actualizar H");
			actualizarReg.setName("actualizaHuesped");
			this.setSize(500, 500);
			this.setLayout(null);
			
			
			panelScroll.setBounds(20, 60, 450, 320);
			botonMenuPrincipal.setBounds(320,400,130,40);
			eliminarReg.setBounds(30, 400, 130, 40);
			actualizarReg.setBounds(170, 400, 130, 40);
			this.add(botonBusqueda);
			this.add(cajaBusqueda);
			this.add(panelScroll);
			this.add(eliminarReg);
			this.add(actualizarReg);
			this.add(botonMenuPrincipal);

		}

	}

	public void cargarTablaReserva() {
		 tabla = new JTable() {
		    /**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
		    public boolean isCellEditable(int row, int column) {                
		        return    (column!=0 && column!=1 );         
		    };
		};
		modeloTabla = new DefaultTableModel();
		String[] columnasReserva = new String[] { "Id", "Valor", "Fecha Entrada", "Fecha Salida", "Forma Pago" };

		modeloTabla.setColumnIdentifiers(columnasReserva);
		

		for (Reserva r : reservaService.listarReservas()) {
			System.out.println(
					r.getId() + "" + r.getValor() + r.getFechaEntrada() + r.getFechaSalida() + r.getFormaPago());

			modeloTabla.addRow(new Object[] { r.getId(), r.getValor(), r.getFechaEntrada(), r.getFechaSalida(),
					r.getFormaPago() });

		}
		tabla.setModel(modeloTabla);
		tabla.getColumnModel().getColumn(0).setPreferredWidth(50);

	}

	public void cargarTablaHuesped() {
		 tabla = new JTable() {
			    /**
			 * 
			 */
			private static final long serialVersionUID = 1L;

				@Override
			    public boolean isCellEditable(int row, int column) {                
			        return (column!=0 && column!=6);               
			    };
			};
		modeloTabla = new DefaultTableModel();
		String[] columnasHuesped = new String[] { "id", "Cedula", "Nombre", "Apellido", "Nacionalidad",
				"FechaNacimiento", "NoReserva" };
		modeloTabla.setColumnIdentifiers(columnasHuesped);
		huespedService = new HuespedService();
		for (Huesped huesped : huespedService.listarHuesped()) {

			modeloTabla.addRow(
					new Object[] { huesped.getId(), huesped.getCedula(), huesped.getNombre(), huesped.getApellido(),
							huesped.getNacionalidad(), huesped.getFechaNacimiento(), huesped.getIdReserva().getId() });

		}
		tabla.setModel(modeloTabla);
		tabla.getColumnModel().getColumn(0).setPreferredWidth(20);

	}

	public JTable getTabla() {
		return tabla;
	}

	public void setTabla(JTable tabla) {
		this.tabla = tabla;
	}

	public JButton getEliminarReg() {
		return eliminarReg;
	}

	public void setEliminarReg(JButton eliminarReg) {
		this.eliminarReg = eliminarReg;
	}

	public JButton getActualizarReg() {
		return actualizarReg;
	}

	public void setActualizarReg(JButton actualizarReg) {
		this.actualizarReg = actualizarReg;
	}

	public ReservaService getReservaService() {
		return reservaService;
	}

	public void setReservaService(ReservaService reservaService) {
		this.reservaService = reservaService;
	}

	public HuespedService getHuespedService() {
		return huespedService;
	}

	public void setHuespedService(HuespedService huespedService) {
		this.huespedService = huespedService;
	}

	public DefaultTableModel getModeloTabla() {
		return modeloTabla;
	}

	public void setModeloTabla(DefaultTableModel modeloTabla) {
		this.modeloTabla = modeloTabla;
	}

	public JTextField getCajaBusqueda() {
		return cajaBusqueda;
	}

	public void setCajaBusqueda(JTextField cajaBusqueda) {
		this.cajaBusqueda = cajaBusqueda;
	}

	public JButton getBotonBusqueda() {
		return botonBusqueda;
	}

	public void setBotonBusqueda(JButton botonBusqueda) {
		this.botonBusqueda = botonBusqueda;
	}

	public void agregarReservaBusqueda() {

		panelScroll.setViewportView(this.getTabla());

		panelScroll.setBounds(20, 60, 450, 320);
		botonMenuPrincipal.setBounds(320,400,130,40);
		eliminarReg.setBounds(30, 400, 130, 40);
		actualizarReg.setBounds(170, 400, 130, 40);
		this.add(botonBusqueda);
		this.add(cajaBusqueda);
		this.add(panelScroll);
		this.add(eliminarReg);
		this.add(actualizarReg);
		this.add(botonMenuPrincipal);

	}

	public void agregarHuespedBusqueda() {

		panelScroll.setViewportView(this.getTabla());

		panelScroll.setBounds(20, 60, 450, 320);
		botonMenuPrincipal.setBounds(320,400,130,40);
		eliminarReg.setBounds(30, 400, 130, 40);
		actualizarReg.setBounds(170, 400, 130, 40);
		this.add(botonBusqueda);
		this.add(cajaBusqueda);
		this.add(panelScroll);
		this.add(eliminarReg);
		this.add(actualizarReg);
		this.add(botonMenuPrincipal);

	}

	public JButton getBotonMenuPrincipal() {
		return botonMenuPrincipal;
	}

	public void setBotonMenuPrincipal(JButton botonMenuPrincipal) {
		this.botonMenuPrincipal = botonMenuPrincipal;
	}

	
	
}
