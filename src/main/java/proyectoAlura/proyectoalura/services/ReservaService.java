package proyectoAlura.proyectoalura.services;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import proyectoAlura.proyectoalura.Conexion.Conexion;
import proyectoAlura.proyectoalura.DaoFacil.DaoReserva;
import proyectoAlura.proyectoalura.ModeloFacil.Reserva;

public class ReservaService implements DaoReserva {
	private Connection conector = Conexion.getConexion().getConector();

	private static Long idCreado = 0L;

	public Reserva crear(Reserva reserva) { // funciona probado
		Reserva reservaGuardada = null;
		String insertSqlSentencia = "INSERT INTO RESERVA ( valor, formPago, fechaEntrada, fechaSalida) "
				+ "VALUES  (?,?,?,?) ";

		try (PreparedStatement prepareStatement = conector.prepareStatement(insertSqlSentencia,
				PreparedStatement.RETURN_GENERATED_KEYS)) {

			prepareStatement.setDouble(1, reserva.getValor());
			prepareStatement.setString(2, reserva.getFormaPago());
			prepareStatement.setDate(3, Date.valueOf(reserva.getFechaEntrada()));
			prepareStatement.setDate(4, Date.valueOf(reserva.getFechaSalida()));
			prepareStatement.executeUpdate();
			try (ResultSet rs = prepareStatement.getGeneratedKeys()) {
				while (rs.next()) {

					System.out.println(rs.getInt(1));
					idCreado = Long.valueOf(rs.getInt(1));
					reservaGuardada = new Reserva();
					reservaGuardada.setId(idCreado);
					reservaGuardada.setValor(reserva.getValor());
					reservaGuardada.setFormaPago(reserva.getFormaPago());
					reservaGuardada.setFechaEntrada(reserva.getFechaEntrada());
					reservaGuardada.setFechaSalida(reserva.getFechaSalida());
				}
				conector.close();

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Error al  insertar el recurso" + " " + e.getMessage());
		}

		return reservaGuardada;
	}

	@Override
	public void remover(Long idReserva) throws SQLException { // funciona probado

		String deleteSqlsentencia = "DELETE  FROM RESERVA " + "WHERE  idReserva= ?";

		try (PreparedStatement prepareStatement = conector.prepareStatement(deleteSqlsentencia)) {

			prepareStatement.setInt(1, Integer.parseInt((idReserva).toString()));

			prepareStatement.executeUpdate();

			JOptionPane.showMessageDialog(null, "Se eliminó   la reserva " + Integer.parseInt((idReserva).toString()));
			conector.close();
		} catch (SQLException e) {

			throw new SQLException(e.getMessage());
		}

	}

	@Override
	public void actualizar(Long idReserva, Reserva reserva) { // probado

		String deleteSqlsentencia = "UPDATE  RESERVA " + "SET valor =? ," + "formPago=? , " + "fechaEntrada=? , "
				+ "fechaSalida= ?" + "WHERE  idReserva=?";

		try (PreparedStatement prepareStatement = conector.prepareStatement(deleteSqlsentencia)) {

			prepareStatement.setDouble(1, reserva.getValor());
			prepareStatement.setString(2, reserva.getFormaPago());
			prepareStatement.setDate(3, Date.valueOf(reserva.getFechaEntrada()));
			prepareStatement.setDate(4, Date.valueOf(reserva.getFechaSalida()));
			prepareStatement.setInt(5, Integer.parseInt(idReserva.toString()));
			prepareStatement.executeUpdate();
			JOptionPane.showMessageDialog(null, " se  actualizó  exitosamente");
			conector.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("error al  actualizar el recurso" + " " + e.getMessage());
		}

	}

	@Override
	public List<Reserva> listarReservas() { // probado
		List<Reserva> listaReserva = new ArrayList<Reserva>();

		String selectTotalSqlsentencia = "SELECT  * FROM   RESERVA ";

		try (PreparedStatement prepareStatement = conector.prepareStatement(selectTotalSqlsentencia)) {

			try (ResultSet rs = prepareStatement.executeQuery()) {

				while (rs.next()) {

					Reserva reservaEncontrada = new Reserva();
					reservaEncontrada.setValor(rs.getDouble("valor"));
					reservaEncontrada.setId(rs.getLong("idReserva"));
					reservaEncontrada.setFormaPago(rs.getString("formPago"));
					reservaEncontrada.setFechaEntrada(rs.getDate("fechaEntrada").toLocalDate());
					reservaEncontrada.setFechaSalida(rs.getDate("fechaSalida").toLocalDate());
					listaReserva.add(reservaEncontrada);

				}

			}
			conector.close();// borrar esta
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("error al  buscar los recursos" + e.getMessage());
		}

		return listaReserva;
	}

	@Override
	public Reserva consultarReservaId(Long idReserva) { // probado
		Reserva reservaEncontrada = null;
		String selectByIdSqlsentencia = "SELECT  * FROM   RESERVA " + "WHERE  idReserva=?";

		try (PreparedStatement prepareStatement = conector.prepareStatement(selectByIdSqlsentencia)) {

			prepareStatement.setInt(1, Integer.parseInt(idReserva.toString()));
			try (ResultSet rs = prepareStatement.executeQuery()) {

				while (rs.next()) {

					reservaEncontrada = new Reserva();
					reservaEncontrada.setValor(rs.getDouble("valor"));
					reservaEncontrada.setId(rs.getLong("idReserva"));
					reservaEncontrada.setFormaPago(rs.getString("formPago"));
					reservaEncontrada.setFechaEntrada(rs.getDate("fechaEntrada").toLocalDate());
					reservaEncontrada.setFechaSalida(rs.getDate("fechaSalida").toLocalDate());

				}
				if (reservaEncontrada == null) {

					JOptionPane.showMessageDialog(null, "elemento no existente en bd");

				}
			}
			conector.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("error al  buscar el recurso");
		}

		return reservaEncontrada;
	}

	public static Long getIdCreado() {
		return idCreado;
	}

	@Override
	public List<Reserva> listaReservaByFechaEntrada(String fecha) {

		Reserva reservaEncontrada = null;
		String selectByFechaSqlsentencia = "SELECT  * FROM   RESERVA " + "WHERE  fechaEntrada=?";
		List<Reserva> listaReservas = new ArrayList<>();

		try (PreparedStatement prepareStatement = conector.prepareStatement(selectByFechaSqlsentencia)) {

			prepareStatement.setDate(1, Date.valueOf(fecha)); // formato ingresado en el filtro debe ser con yyyy-mm-dd
			try (ResultSet rs = prepareStatement.executeQuery()) {

				while (rs.next()) {

					reservaEncontrada = new Reserva();
					reservaEncontrada.setValor(rs.getDouble("valor"));
					reservaEncontrada.setId(rs.getLong("idReserva"));
					reservaEncontrada.setFormaPago(rs.getString("formPago"));
					reservaEncontrada.setFechaEntrada(rs.getDate("fechaEntrada").toLocalDate());
					reservaEncontrada.setFechaSalida(rs.getDate("fechaSalida").toLocalDate());
					listaReservas.add(reservaEncontrada);
				}

			}
			conector.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("error al  buscar el recurso");
		}

		return listaReservas;
	}

}
