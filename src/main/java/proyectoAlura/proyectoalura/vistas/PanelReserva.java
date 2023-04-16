package proyectoAlura.proyectoalura.vistas;

import java.awt.Graphics;
import java.awt.Image;
import java.time.LocalDate;

import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;

import javax.swing.JScrollPane;
import javax.swing.JTextField;


import com.toedter.calendar.JDateChooser;


import proyectoAlura.proyectoalura.util.ConversionesFecha;

public class PanelReserva extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel labelFechaEntrada;
	private JLabel labelFechaSalida;
	private JLabel labelFormaPago;
	private JLabel labelValor;

	private JTextField txtValor;
	private JList<String> listaFormaPago;
	private JDateChooser fechaEntrada;
	private JDateChooser fechaSalida;
	private JButton botonCrearReserva;


	static Integer valorDiario = 1000;
	private Integer diasTotales;
	private String entrada;
	private String salida;
	private LocalDate fechaIniFormateada;
	private  LocalDate fechaFinalFormateada ;

	public PanelReserva() {

		organizarPanel();

	}

	public void organizarPanel() {

		this.setSize(400, 400);
		this.setLayout(null);

		labelFechaEntrada = new JLabel("Fecha Inicio:");
		labelFechaEntrada.setBounds(100, 100, 100, 30);
		

		fechaEntrada = new JDateChooser();
		fechaEntrada.setBounds(260, 100, 140, 30);
		fechaEntrada.setDate(new Date());
		fechaEntrada.setMinSelectableDate(new Date());

		labelFechaSalida = new JLabel("Fecha Fin:");
		labelFechaSalida.setBounds(100, 150, 100, 30);

		fechaSalida = new JDateChooser();
		fechaSalida.setDate(new Date());
		fechaSalida.setMinSelectableDate(new Date());
		fechaSalida.setBounds(260, 150, 140, 30);

		labelFormaPago = new JLabel("Forma de Pago:");
		labelFormaPago.setBounds(100, 200, 100, 30);

		listaFormaPago = new JList<String>(new String[] { "Efectivo", "Tarjeta", "Cheque" });
		JScrollPane barrraLista = new JScrollPane(listaFormaPago);
		listaFormaPago.setSelectedIndex(0);
		barrraLista.setBounds(260, 200, 100, 60);

		labelValor = new JLabel("Valor a Pagar:");
		labelValor.setBounds(100, 280, 100, 30);

		txtValor = new JTextField();
		txtValor.setBounds(260, 290, 130, 20);

		botonCrearReserva = new JButton("Crear Reserva");
		botonCrearReserva.setName("botonReserva");
		botonCrearReserva.setBounds(110, 350, 300, 30);
		this.txtValor.setEditable(false);
		
		this.setEntrada( ConversionesFecha.conversionDateToString(fechaEntrada.getDate()) );
		
		this.setSalida(ConversionesFecha.conversionDateToString(fechaSalida.getDate()) );
		fechaEntrada.addPropertyChangeListener(evt -> {

			JDateChooser inicio = (JDateChooser) evt.getSource();
			Date data = inicio.getDate();
			 
			this.setEntrada(ConversionesFecha.conversionDateToString(data) );
			
			fechaIniFormateada = LocalDate.parse(this.getEntrada());
			fechaFinalFormateada =  ConversionesFecha.conversionStringToLocalDate(this.getSalida()) ;
			
			this.setDiasTotales(ConversionesFecha.calcularDiasEntreFechasLocalDate(fechaIniFormateada, fechaFinalFormateada));
			System.out.println(this.getDiasTotales());
			this.getTxtValor().setText(String.valueOf(  ConversionesFecha.calcularCostoDiasReservados(this.getDiasTotales() , PanelReserva.valorDiario)));

		

			
			
		});

		fechaSalida.addPropertyChangeListener(evt -> {

			JDateChooser fin = (JDateChooser) evt.getSource();
			
			Date dataFin = fin.getDate();
			this.setSalida(ConversionesFecha.conversionDateToString(dataFin));
			
			

			fechaIniFormateada = LocalDate.parse(this.getEntrada());
			fechaFinalFormateada =  ConversionesFecha.conversionStringToLocalDate(ConversionesFecha.conversionDateToString(dataFin)) ;
			
			this.setDiasTotales(ConversionesFecha.calcularDiasEntreFechasLocalDate(fechaIniFormateada, fechaFinalFormateada));
			System.out.println(this.getDiasTotales());
			this.getTxtValor().setText(String.valueOf(ConversionesFecha.calcularCostoDiasReservados(this.getDiasTotales(),  PanelReserva.valorDiario) ));

		});
		
		// fechaSalida=null;
		// botonCrearReserva.addActionListener( new EventosBotones(this));
		this.add(labelFechaEntrada);
		this.add(fechaEntrada);
		this.add(labelFechaSalida);
		this.add(fechaSalida);
		this.add(labelFormaPago);
		this.add(barrraLista);
		this.add(labelValor);
		this.add(txtValor);
		this.add(botonCrearReserva);

	}

	public JLabel getLabelFechaEntrada() {
		return labelFechaEntrada;
	}

	public void setLabelFechaEntrada(JLabel labelFechaEntrada) {
		this.labelFechaEntrada = labelFechaEntrada;
	}

	public JLabel getLabelFechaSalida() {
		return labelFechaSalida;
	}

	public void setLabelFechaSalida(JLabel labelFechaSalida) {
		this.labelFechaSalida = labelFechaSalida;
	}

	public JLabel getLabelFormaPago() {
		return labelFormaPago;
	}

	public void setLabelFormaPago(JLabel labelFormaPago) {
		this.labelFormaPago = labelFormaPago;
	}

	public JLabel getLabelValor() {
		return labelValor;
	}

	public void setLabelValor(JLabel labelValor) {
		this.labelValor = labelValor;
	}

	public JTextField getTxtValor() {
		return txtValor;
	}

	public void setTxtValor(JTextField txtValor) {
		this.txtValor = txtValor;
	}

	public JList<String> getListaFormaPago() {
		return listaFormaPago;
	}

	public void setListaFormaPago(JList<String> listaFormaPago) {
		this.listaFormaPago = listaFormaPago;
	}

	public JDateChooser getFechaEntrada() {
		return fechaEntrada;
	}

	public void setFechaEntrada(JDateChooser fechaEntrada) {
		this.fechaEntrada = fechaEntrada;
	}

	public JDateChooser getFechaSalida() {
		return fechaSalida;
	}

	public void setFechaSalida(JDateChooser fechaSalida) {
		this.fechaSalida = fechaSalida;
	}

	public JButton getBotonCrearReserva() {
		return botonCrearReserva;
	}

	public void setBotonCrearReserva(JButton botonCrearReserva) {
		this.botonCrearReserva = botonCrearReserva;
	}

	@Override
	public void paint(Graphics g) {
		Image imagen = new ImageIcon(getClass().getResource("/reserva.jpg")).getImage();
		g.drawImage(imagen, 0, 0, 500, 500, this);

		setOpaque(false);
		super.paint(g);
	}

	public String getEntrada() {
		return entrada;
	}

	public void setEntrada(String entrada) {
		this.entrada = entrada;
	}

	public Integer getDiasTotales() {
		return diasTotales;
	}

	public void setDiasTotales(Integer diasTotales) {
		this.diasTotales = diasTotales;
	}

	public LocalDate getFechaIniFormateada() {
		return fechaIniFormateada;
	}

	public void setFechaIniFormateada(LocalDate fechaIniFormateada) {
		this.fechaIniFormateada = fechaIniFormateada;
	}

	public LocalDate getFechaFinalFormateada() {
		return fechaFinalFormateada;
	}

	public void setFechaFinalFormateada(LocalDate fechaFinalFormateada) {
		this.fechaFinalFormateada = fechaFinalFormateada;
	}

	public String getSalida() {
		return salida;
	}

	public void setSalida(String salida) {
		this.salida = salida;
	}

	public static Integer getValorDiario() {
		return valorDiario;
	}

	public static void setValorDiario(Integer valorDiario) {
		PanelReserva.valorDiario = valorDiario;
	}

}
