package proyectoAlura.proyectoalura.Eventos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import java.sql.SQLException;
import java.time.LocalDate;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import proyectoAlura.proyectoalura.ModeloFacil.Huesped;
import proyectoAlura.proyectoalura.ModeloFacil.Reserva;
import proyectoAlura.proyectoalura.services.HuespedService;
import proyectoAlura.proyectoalura.services.ReservaService;
import proyectoAlura.proyectoalura.util.ConversionesFecha;
import proyectoAlura.proyectoalura.vistas.PanelReserva;
import proyectoAlura.proyectoalura.vistas.VistaHuespedRegistro;
import proyectoAlura.proyectoalura.vistas.VistaLogin;
import proyectoAlura.proyectoalura.vistas.VistaMenuGeneral;
import proyectoAlura.proyectoalura.vistas.VistaReserva;
import proyectoAlura.proyectoalura.vistas.VistaTablas;

public class EventosBotones implements ActionListener {

	private JFrame ventanaGeneradorEvento;

	public EventosBotones(JFrame ventanaGeneradorEvento) {
		this.ventanaGeneradorEvento = ventanaGeneradorEvento;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton objeto = (JButton) e.getSource();

		if (objeto.getName().equals("actualizaHuesped")) {
			VistaTablas vistaTabla = (VistaTablas) this.getVentanaGeneradorEvento();
			JTable tabla = vistaTabla.getPanelTablaHuesped().getTabla();
			int fila = tabla.getSelectedRow();
			if (fila < 0) {

				JOptionPane.showMessageDialog(null, "Debes seleccionar una fila  de huesped para actualizar");

			}

			else {

				Long id = Long.valueOf(tabla.getValueAt(fila, 0).toString());
				String cedula = tabla.getValueAt(fila, 1).toString();
				String nombre = tabla.getValueAt(fila, 2).toString();
				String apellido = tabla.getValueAt(fila, 3).toString();
				String nacionalidad = tabla.getValueAt(fila, 4).toString();
				String fechaNacimiento = tabla.getValueAt(fila, 5).toString();
				Long idReserva = Long.valueOf(tabla.getValueAt(fila, 6).toString());

				if (!ConversionesFecha.determinarFormatoFechaIngresadoBusqueda(fechaNacimiento))

				{
					JOptionPane.showMessageDialog(null,
							"debes ingresar un formato valido de fecha de Nacimiento yyyy-mm-dd");

				} else {

					LocalDate fechaNaacimientoActualizar = ConversionesFecha
							.conversionStringToLocalDate(fechaNacimiento);

					HuespedService huespedService = new HuespedService();
					Huesped huesped = new Huesped(cedula, nombre, apellido, nacionalidad, fechaNaacimientoActualizar,
							new Reserva(idReserva));
					huesped.setId(id);
					System.out.println(huesped);

					huespedService.actualizar(id, huesped);

					vistaTabla.getPanelTablaReservas().setTabla(this.retornarJtableReserva(1, ""));

					vistaTabla.getPanelTablaReservas().agregarReservaBusqueda();

				}

			}

		}

		else if (objeto.getName().equals("actualizaReserva")) {

			VistaTablas vistaTabla = (VistaTablas) this.getVentanaGeneradorEvento();
			JTable tabla = vistaTabla.getPanelTablaReservas().getTabla();
			int fila = tabla.getSelectedRow();
			if (fila < 0) {

				JOptionPane.showMessageDialog(null, "Debes seleccionar una fila de reserva para actualizar");

			} else {
				Long id = Long.valueOf(tabla.getValueAt(fila, 0).toString());
				//Double valor = Double.valueOf(tabla.getValueAt(fila, 1).toString());// valor
				String fechaEntrada = tabla.getValueAt(fila, 2).toString();// fechaentrada
				String fechaSalida = (String) tabla.getValueAt(fila, 3).toString();// fechasalida
				String formaPago = (String) tabla.getValueAt(fila, 4).toString();// forma de pago
				if (!ConversionesFecha.determinarFormatoFechaIngresadoBusqueda(fechaEntrada)
						|| !ConversionesFecha.determinarFormatoFechaIngresadoBusqueda(fechaSalida))

				{
					JOptionPane.showMessageDialog(null, "debes ingresar un formato valido de fecha yyyy-mm-dd");

				} else {

					LocalDate fechaEntradaActualizar = ConversionesFecha.conversionStringToLocalDate(fechaEntrada);
					LocalDate fechaSalidaActualizar = ConversionesFecha.conversionStringToLocalDate(fechaSalida);
					if (!(fechaEntradaActualizar.compareTo(fechaSalidaActualizar) <= 0)) {
						JOptionPane.showMessageDialog(null,
								"debes ingresar una fecha de entrada menor o igual a fecha salida");
					} else {
						ReservaService reservaService = new ReservaService();
						Reserva reserva = new Reserva(
								Double.valueOf(
										ConversionesFecha.calcularCostoDiasReservados(
												ConversionesFecha.calcularDiasEntreFechasLocalDate(
														fechaEntradaActualizar, fechaSalidaActualizar),
												PanelReserva.getValorDiario())),
								fechaEntradaActualizar, fechaSalidaActualizar, formaPago);
						reserva.setId(id);
						System.out.println(reserva);

						reservaService.actualizar(id, reserva);

						vistaTabla.getPanelTablaReservas().setTabla(this.retornarJtableReserva(1, ""));

						vistaTabla.getPanelTablaReservas().agregarReservaBusqueda();
					}

				}

			}

		}

		else if (objeto.getName().equals("menuPrincipal")) {
			VistaTablas vistaTabla = (VistaTablas) this.getVentanaGeneradorEvento();
			vistaTabla.dispose();
			new VistaMenuGeneral();

		}

		else if (objeto.getName().equals("botonMCrearReserva")) {
			VistaMenuGeneral vistaTablaMenuRecuperada = (VistaMenuGeneral) this.getVentanaGeneradorEvento();
			vistaTablaMenuRecuperada.dispose();
			new VistaReserva();

		} else if (objeto.getName().equals("botonMTodos")) {

			VistaMenuGeneral vistaTablaMenuRecuperada = (VistaMenuGeneral) this.getVentanaGeneradorEvento();
			vistaTablaMenuRecuperada.dispose();
			new VistaTablas();
		} else if (objeto.getName().equals("botonMCerrarSesion")) {

			VistaMenuGeneral vistaTablaMenuRecuperada = (VistaMenuGeneral) this.getVentanaGeneradorEvento();
			vistaTablaMenuRecuperada.dispose();
			try {
				new VistaLogin();
			} catch (IOException e1) {

				e1.printStackTrace();
			}

		} else if (objeto.getName().equals("buscarReserva")) {
			VistaTablas vistaTablaReservaRecuperada = (VistaTablas) this.getVentanaGeneradorEvento();

			String valorCapturadoBusqueda = vistaTablaReservaRecuperada.getPanelTablaReservas().getCajaBusqueda()
					.getText();
			vistaTablaReservaRecuperada.getPanelTablaReservas().removeAll();
			vistaTablaReservaRecuperada.getPanelTablaReservas().repaint();
			vistaTablaReservaRecuperada.getPanelTablaReservas().revalidate();

			if (valorCapturadoBusqueda.trim().equals("")) {

				vistaTablaReservaRecuperada.getPanelTablaReservas().setTabla(this.retornarJtableReserva(1, ""));

				vistaTablaReservaRecuperada.getPanelTablaReservas().agregarReservaBusqueda();

				System.out.println(valorCapturadoBusqueda);

			}

			else if (ConversionesFecha
					.determinarFormatoFechaIngresadoBusqueda(valorCapturadoBusqueda.trim()) == false) {

				vistaTablaReservaRecuperada.getPanelTablaReservas().agregarReservaBusqueda();
				JOptionPane.showMessageDialog(null, "Debes ingresar fecha con patron  yyyy-mm-dd");

			} else if (ConversionesFecha
					.determinarFormatoFechaIngresadoBusqueda(valorCapturadoBusqueda.trim()) == true) {

				vistaTablaReservaRecuperada.getPanelTablaReservas()
						.setTabla(this.retornarJtableReserva(2, valorCapturadoBusqueda.trim()));

				vistaTablaReservaRecuperada.getPanelTablaReservas().agregarReservaBusqueda();

				System.out.println(valorCapturadoBusqueda);

			}

		} else if (objeto.getName().equals("buscarHuesped")) {
			VistaTablas vistaTablaHuespedRecuperada = (VistaTablas) this.getVentanaGeneradorEvento();
			String valorCapturadoBusqueda = vistaTablaHuespedRecuperada.getPanelTablaHuesped().getCajaBusqueda()
					.getText();

			vistaTablaHuespedRecuperada.getPanelTablaHuesped().removeAll();
			vistaTablaHuespedRecuperada.getPanelTablaHuesped().repaint();
			vistaTablaHuespedRecuperada.getPanelTablaHuesped().revalidate();

			if (valorCapturadoBusqueda.trim().equals("")) {

				vistaTablaHuespedRecuperada.getPanelTablaHuesped().setTabla(this.retornarJtableHuesped(1, ""));

				vistaTablaHuespedRecuperada.getPanelTablaHuesped().agregarReservaBusqueda();

				System.out.println(valorCapturadoBusqueda);

			}

			else if (ConversionesFecha
					.determinarFormatoFechaIngresadoBusqueda(valorCapturadoBusqueda.trim()) == false) {

				vistaTablaHuespedRecuperada.getPanelTablaHuesped().agregarHuespedBusqueda();
				JOptionPane.showMessageDialog(null, "Debes ingresar fecha con patron  yyyy-mm-dd");

			} else if (ConversionesFecha
					.determinarFormatoFechaIngresadoBusqueda(valorCapturadoBusqueda.trim()) == true) {

				vistaTablaHuespedRecuperada.getPanelTablaHuesped()
						.setTabla(this.retornarJtableHuesped(2, valorCapturadoBusqueda.trim()));

				vistaTablaHuespedRecuperada.getPanelTablaHuesped().agregarHuespedBusqueda();

			}
		}

		else if (objeto.getName().equals("eliminarReserva")) {
			String valorPrimeraColumna = null;
			try {
				VistaTablas vistaTablaReservaRecuperada = (VistaTablas) this.getVentanaGeneradorEvento();
				int fila = vistaTablaReservaRecuperada.getPanelTablaReservas().getTabla().getSelectedRow();
				valorPrimeraColumna = vistaTablaReservaRecuperada.getPanelTablaReservas().getTabla().getValueAt(fila, 0)
						.toString();
				System.out.println("fila:" + fila + ",  columnavalor:" + valorPrimeraColumna);

				ReservaService reservaService = new ReservaService();

				reservaService.remover(Long.valueOf(valorPrimeraColumna));

				DefaultTableModel m = vistaTablaReservaRecuperada.getPanelTablaReservas().getModeloTabla();
				m.removeRow(fila);
				vistaTablaReservaRecuperada.getPanelTablaReservas().getTabla().setModel(m);
				vistaTablaReservaRecuperada.getPanelTablaReservas().agregarReservaBusqueda();

			} catch (ArrayIndexOutOfBoundsException e1) {

				JOptionPane.showMessageDialog(null, "selecciona correctamente una fila de reserva para eliminar");
			} catch (SQLException e1) {
				JOptionPane.showMessageDialog(null, "Error al eliminar Reserva:"
						+ "necesitas eliminar primero el huesped con id de reserva==" + valorPrimeraColumna);
				System.out.println("Error al eliminar Reserva:" + e1.getMessage());

			}

		} else if (objeto.getName().equals("eliminaHuesped")) {
			try {
				VistaTablas vistaTablaHuespedRecuperada = (VistaTablas) this.getVentanaGeneradorEvento();
				int fila = vistaTablaHuespedRecuperada.getPanelTablaHuesped().getTabla().getSelectedRow();
				String valorPrimeraColumna = vistaTablaHuespedRecuperada.getPanelTablaHuesped().getTabla()
						.getValueAt(fila, 1).toString();
				Long id = (Long) vistaTablaHuespedRecuperada.getPanelTablaHuesped().getTabla().getValueAt(fila, 6);
				System.out.println("fila:" + fila + ",  columnavalor:" + valorPrimeraColumna);

				HuespedService huespedService = new HuespedService();

				huespedService.remover(valorPrimeraColumna, id);

				DefaultTableModel m = vistaTablaHuespedRecuperada.getPanelTablaHuesped().getModeloTabla();
				m.removeRow(fila);
				vistaTablaHuespedRecuperada.getPanelTablaHuesped().getTabla().setModel(m);
				vistaTablaHuespedRecuperada.getPanelTablaHuesped().agregarHuespedBusqueda();

			} catch (ArrayIndexOutOfBoundsException e1) {

				JOptionPane.showMessageDialog(null, "selecciona correctamente una fila de huesped para eliminar");
			} catch (SQLException e1) {
				System.out.println("Error al guardar el registro en bd" + e1.getMessage());

			}

		}

		else if (objeto.getName().equals("botonLogin")) {
			VistaLogin loginVentanaRecuperada = (VistaLogin) this.ventanaGeneradorEvento;
			if (loginVentanaRecuperada.getUsername().getText().equals("foxone")
					&& loginVentanaRecuperada.getPassword().getText().equals("123456")) {
				this.ventanaGeneradorEvento.dispose();
				JOptionPane.showMessageDialog(null, "CREDENCIALES CORRECTAS");
				System.out
						.println("Boton login presionado e ingresó : " + loginVentanaRecuperada.getUsername().getText()
								+ " " + loginVentanaRecuperada.getPassword().getText());
				new VistaMenuGeneral();

			} else {

				JOptionPane.showMessageDialog(null, "CREDENCIALES INCORRECTAS");
			}

		} else if (objeto.getName().equals("botonReserva")) {
			System.out.println("boton reserva ");
			VistaReserva loginVentanaRecuperada = (VistaReserva) this.ventanaGeneradorEvento;
			
			if(Integer.parseInt(loginVentanaRecuperada.getPanelReserva().getTxtValor().getText().toString()) <0) {
				JOptionPane.showMessageDialog(null, "debes seleccionar fecha de entrada menor o igual a fecha de salida");
				
			}
			
			else {

			ReservaService servicioReserva = new ReservaService();

			Reserva reserva = new Reserva(
					Double.valueOf(loginVentanaRecuperada.getPanelReserva().getTxtValor().getText().toString()),
					loginVentanaRecuperada.getPanelReserva().getFechaIniFormateada(),
					loginVentanaRecuperada.getPanelReserva().getFechaFinalFormateada(),
					loginVentanaRecuperada.getPanelReserva().getListaFormaPago().getSelectedValue().toString());
			;
			servicioReserva.crear(reserva);
			loginVentanaRecuperada.dispose();
			JOptionPane.showMessageDialog(null, "Se creó  el registro correctamente en bd ");
			new VistaHuespedRegistro();
			}
		} else if (objeto.getName().equals("botonCrearHuesped")) {
			System.out.println("boton crear Huesped ");
			VistaHuespedRegistro huespedRegistroVentanaRecuperada = (VistaHuespedRegistro) this.ventanaGeneradorEvento;

			HuespedService servicioHuesped = new HuespedService();

			Huesped huesped = new Huesped(
					huespedRegistroVentanaRecuperada.getPanelRegistroHuesped().getTxtId().getText().toString(),
					huespedRegistroVentanaRecuperada.getPanelRegistroHuesped().getTxtNombre().getText().toString(),
					huespedRegistroVentanaRecuperada.getPanelRegistroHuesped().getTxtApellido().getText().toString(),
					huespedRegistroVentanaRecuperada.getPanelRegistroHuesped().getTxtNacionalidad().getText()
							.toString(),
					huespedRegistroVentanaRecuperada.getPanelRegistroHuesped().getFechaNacimiento(),
					new Reserva(Long.valueOf(huespedRegistroVentanaRecuperada.getPanelRegistroHuesped()
							.getTxtIdReserva().getText().toString())));
			if (huesped.getCedula().equals("") || huesped.getNombre().equals("") || huesped.getApellido().equals("")
					|| huesped.getNacionalidad().equals("")) {
				JOptionPane.showMessageDialog(null, "Ingresa todos los campós necesarios ");

			} else {
				System.out.println(huesped);

				servicioHuesped.crear(huesped);
				huespedRegistroVentanaRecuperada.dispose();
				JOptionPane.showMessageDialog(null, "Se creó en bd el huesped asociado a la reserva ");

				new VistaTablas();

			}

		}

	}

	public JFrame getVentanaGeneradorEvento() {
		return ventanaGeneradorEvento;
	}

	public void setVentanaGeneradorEvento(JFrame ventanaGeneradorEvento) {
		this.ventanaGeneradorEvento = ventanaGeneradorEvento;
	}

	public JTable retornarJtableReserva(int opcion, String opcionConsulta) {
		String[] columnasReserva = new String[] { "Id", "Valor", "Fecha Entrada", "Fecha Salida", "Forma Pago" };
		DefaultTableModel modelo = new DefaultTableModel();

		modelo.setColumnIdentifiers(columnasReserva);
		ReservaService reservaService = new ReservaService();
		if (opcion == 1 && opcionConsulta.equals("")) {

			for (Reserva r : reservaService.listarReservas()) {
				System.out.println(
						r.getId() + "" + r.getValor() + r.getFechaEntrada() + r.getFechaSalida() + r.getFormaPago());

				modelo.addRow(new Object[] { r.getId(), r.getValor(), r.getFechaEntrada(), r.getFechaSalida(),
						r.getFormaPago() });

			}

		} else if (opcion == 2) {
			for (Reserva r : reservaService.listaReservaByFechaEntrada(opcionConsulta.trim())) {
				System.out.println(
						r.getId() + "" + r.getValor() + r.getFechaEntrada() + r.getFechaSalida() + r.getFormaPago());

				modelo.addRow(new Object[] { r.getId(), r.getValor(), r.getFechaEntrada(), r.getFechaSalida(),
						r.getFormaPago() });

			}

		}

		JTable tabla = new JTable() {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public boolean isCellEditable(int row, int column) {
				return (column != 0 && column != 1);
			};
		};
		tabla.setModel(modelo);
		tabla.getColumnModel().getColumn(0).setPreferredWidth(50);

		return tabla;
	}

	public JTable retornarJtableHuesped(int opcion, String opcionConsulta) {
		String[] columnasHuesped = new String[] { "Id", "Cédula", "Nombre", "Apellido", "Nacionalidad",
				"Fecha Nacimiento", "IdReserva" };
		DefaultTableModel modelo = new DefaultTableModel();

		modelo.setColumnIdentifiers(columnasHuesped);

		HuespedService huespedService = new HuespedService();
		if (opcion == 1 && opcionConsulta.equals("")) {
			for (Huesped h : huespedService.listarHuesped()) {
				System.out.println(h.getId() + h.getCedula() + h.getNombre() + h.getApellido() + h.getNacionalidad()
						+ h.getFechaNacimiento() + h.getIdReserva().getId());

				modelo.addRow(new Object[] { h.getId(), h.getCedula(), h.getNombre(), h.getApellido(),
						h.getNacionalidad(), h.getFechaNacimiento(), h.getIdReserva().getId() });

			}

		} else if (opcion == 2) {
			for (Huesped h : huespedService.listaHuespedByFechaNacimiento(opcionConsulta)) {

				modelo.addRow(new Object[] { h.getId(), h.getCedula(), h.getNombre(), h.getApellido(),
						h.getNacionalidad(), h.getFechaNacimiento(), h.getIdReserva().getId() });

			}

		}

		JTable tabla = new JTable() {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public boolean isCellEditable(int row, int column) {
				return (column != 0 && column != 6);
			};
		};
		tabla.setModel(modelo);
		tabla.getColumnModel().getColumn(0).setPreferredWidth(20);

		return tabla;
	}
}
