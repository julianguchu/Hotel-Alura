package proyectoAlura.proyectoalura.vistas;

import java.awt.Graphics;
import java.awt.Image;
import java.time.LocalDate;

import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

import javax.swing.JPanel;

import javax.swing.JTextField;

import com.toedter.calendar.JDateChooser;

import proyectoAlura.proyectoalura.services.ReservaService;
import proyectoAlura.proyectoalura.util.ConversionesFecha;

public class PanelHuespedRegistro extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel labelId;
	private JLabel labelNombre;
	private JLabel labelApellido;
	private JLabel labelNacionalidad;
	private JLabel labelFechaNacimiento;
	private JLabel labelIdReserva;

	private JTextField txtId;
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtNacionalidad;
	private JDateChooser txtFechaNacimiento;
	private JTextField txtIdReserva;
	private JButton botonCrearHuesped;
	private LocalDate fechaNacimiento;

	public PanelHuespedRegistro() {

		organizarPanel();

	}

	public void organizarPanel() {

		this.setSize(400, 400);
		this.setLayout(null);

		labelId = new JLabel("Cedula :");
		labelId.setBounds(100, 50, 100, 20);

		txtId = new JTextField();
		txtId.setBounds(260, 50, 140, 20);

		labelNombre = new JLabel("Nombre :");
		labelNombre.setBounds(100, 100, 100, 20);

		txtNombre = new JTextField();
		txtNombre.setBounds(260, 100, 140, 20);

		labelApellido = new JLabel("Apellido :");
		labelApellido.setBounds(100, 150, 100, 20);

		txtApellido = new JTextField();
		txtApellido.setBounds(260, 150, 140, 20);

		labelNacionalidad = new JLabel("Nacionalidad :");
		labelNacionalidad.setBounds(100, 200, 100, 20);

		txtNacionalidad = new JTextField();
		txtNacionalidad.setBounds(260, 200, 140, 20);

		labelFechaNacimiento = new JLabel("Fecha Nacimiento :");
		labelFechaNacimiento.setBounds(100, 250, 250, 20);

		txtFechaNacimiento = new JDateChooser();
		txtFechaNacimiento.setBounds(260, 250, 130, 20);
		txtFechaNacimiento.setDate(new Date());

		labelIdReserva = new JLabel("Id Reserva :");
		labelIdReserva.setBounds(100, 300, 100, 30);

		txtIdReserva = new JTextField();
		txtIdReserva.setBounds(260, 300, 130, 20);

		botonCrearHuesped = new JButton("Crear Huesped");
		botonCrearHuesped.setName("botonCrearHuesped");
		botonCrearHuesped.setBounds(110, 350, 300, 30);
		this.txtIdReserva.setEditable(false);
		this.txtIdReserva.setText(ReservaService.getIdCreado().toString());
		fechaNacimiento = ConversionesFecha
				.conversionStringToLocalDate(ConversionesFecha.conversionDateToString(txtFechaNacimiento.getDate()));
		System.out.println("fecha nacimiento antes de entrar al evento  " + fechaNacimiento);

		txtFechaNacimiento.addPropertyChangeListener(evt -> {

			JDateChooser nacimiento = (JDateChooser) evt.getSource();
			Date data = nacimiento.getDate();

			this.setFechaNacimiento(
					ConversionesFecha.conversionStringToLocalDate(ConversionesFecha.conversionDateToString(data)));

			System.out.println("fecha nacimiento " + fechaNacimiento);

		});

		this.add(labelId);
		this.add(txtId);
		this.add(labelNombre);
		this.add(txtNombre);
		this.add(labelApellido);
		this.add(txtApellido);
		this.add(labelNacionalidad);
		this.add(txtNacionalidad);
		this.add(labelFechaNacimiento);
		this.add(txtFechaNacimiento);
		this.add(labelIdReserva);
		this.add(txtIdReserva);

		this.add(botonCrearHuesped);

	}

	public JLabel getLabelId() {
		return labelId;
	}

	public void setLabelId(JLabel labelId) {
		this.labelId = labelId;
	}

	public JLabel getLabelNombre() {
		return labelNombre;
	}

	public void setLabelNombre(JLabel labelNombre) {
		this.labelNombre = labelNombre;
	}

	public JLabel getLabelApellido() {
		return labelApellido;
	}

	public void setLabelApellido(JLabel labelApellido) {
		this.labelApellido = labelApellido;
	}

	public JLabel getLabelNacionalidad() {
		return labelNacionalidad;
	}

	public void setLabelNacionalidad(JLabel labelNacionalidad) {
		this.labelNacionalidad = labelNacionalidad;
	}

	public JLabel getLabelFechaNacimiento() {
		return labelFechaNacimiento;
	}

	public void setLabelFechaNacimiento(JLabel labelFechaNacimiento) {
		this.labelFechaNacimiento = labelFechaNacimiento;
	}

	public JLabel getLabelIdReserva() {
		return labelIdReserva;
	}

	public void setLabelIdReserva(JLabel labelIdReserva) {
		this.labelIdReserva = labelIdReserva;
	}

	public JTextField getTxtId() {
		return txtId;
	}

	public void setTxtId(JTextField txtId) {
		this.txtId = txtId;
	}

	public JTextField getTxtNombre() {
		return txtNombre;
	}

	public void setTxtNombre(JTextField txtNombre) {
		this.txtNombre = txtNombre;
	}

	public JTextField getTxtApellido() {
		return txtApellido;
	}

	public void setTxtApellido(JTextField txtApellido) {
		this.txtApellido = txtApellido;
	}

	public JTextField getTxtNacionalidad() {
		return txtNacionalidad;
	}

	public void setTxtNacionalidad(JTextField txtNacionalidad) {
		this.txtNacionalidad = txtNacionalidad;
	}

	public JDateChooser getTxtFechaNacimiento() {
		return txtFechaNacimiento;
	}

	public void setTxtFechaNacimiento(JDateChooser txtFechaNacimiento) {
		this.txtFechaNacimiento = txtFechaNacimiento;
	}

	public JTextField getTxtIdReserva() {
		return txtIdReserva;
	}

	public void setTxtIdReserva(JTextField txtIdReserva) {
		this.txtIdReserva = txtIdReserva;
	}

	public JButton getBotonCrearHuesped() {
		return botonCrearHuesped;
	}

	public void setBotonCrearHuesped(JButton botonCrearHuesped) {
		this.botonCrearHuesped = botonCrearHuesped;
	}

	@Override
	public void paint(Graphics g) {
		Image imagen = new ImageIcon(getClass().getResource("/reserva.jpg")).getImage();
		g.drawImage(imagen, 0, 0, 500, 500, this);

		setOpaque(false);
		super.paint(g);
	}

	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

}
