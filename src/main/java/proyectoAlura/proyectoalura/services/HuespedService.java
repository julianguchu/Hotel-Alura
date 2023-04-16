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
import proyectoAlura.proyectoalura.DaoFacil.DaoHuesped;
import proyectoAlura.proyectoalura.ModeloFacil.Huesped;
import proyectoAlura.proyectoalura.ModeloFacil.Reserva;

public class HuespedService implements DaoHuesped {

	private Long idCreadoHuesped;

	private Connection conector = Conexion.getConexion().getConector();

	public Huesped crear(Huesped huesped) {//probado
		Huesped huespedGuardada = null;
		String insertSqlSentencia = "INSERT INTO HUESPED ( cedula, nombre, apellido, nacionalidad, fechaNacimiento, reservaid) "
				+ "VALUES  (?,?,?,?, ?,?) ";

		try (PreparedStatement prepareStatement = conector.prepareStatement(insertSqlSentencia,
				PreparedStatement.RETURN_GENERATED_KEYS)) {

			prepareStatement.setString(1, huesped.getCedula());
			prepareStatement.setString(2, huesped.getNombre());
			prepareStatement.setString(3, huesped.getApellido());
			prepareStatement.setString(4, huesped.getNacionalidad());
			prepareStatement.setDate(5, Date.valueOf(huesped.getFechaNacimiento()));
			prepareStatement.setLong(6, huesped.getIdReserva().getId());
			 prepareStatement.executeUpdate();
		
			try (ResultSet rs = prepareStatement.getGeneratedKeys()) {
				while (rs.next()) {

					System.out.println(rs.getLong(1));
					idCreadoHuesped = rs.getLong(1);
					huespedGuardada = new Huesped();
					huespedGuardada.setId(idCreadoHuesped);
					huespedGuardada.setCedula(huesped.getCedula());
					huespedGuardada.setNombre(huesped.getNombre());
					huespedGuardada.setApellido(huesped.getApellido());
					huespedGuardada.setNacionalidad(huesped.getNacionalidad());
					huespedGuardada.setFechaNacimiento(huesped.getFechaNacimiento());
					huespedGuardada.setIdReserva(huesped.getIdReserva());
				}
				conector.close();
				
			}
		
			
			

		} catch (SQLException e ) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "ya existe la cedula, no se puede guardar");
		}

		return huespedGuardada;
	}
	
	
	
	@Override
	public void remover(String  cedulaHuesped, Long id ) throws SQLException { 
		
		String deleteSqlsentencia = "DELETE  FROM HUESPED " + "WHERE  cedula= ?"+ "AND  reservaid=?" ;

		try (PreparedStatement prepareStatement = conector.prepareStatement(deleteSqlsentencia)) {
	
			prepareStatement.setString(1, cedulaHuesped);
			prepareStatement.setLong(2, id);
			prepareStatement.executeUpdate();
			JOptionPane.showMessageDialog(null, " Se eliminó el Huesped " +cedulaHuesped);
			conector.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw  new SQLException(e.getMessage());
		}
	
			
		

	}

	@Override
	public void actualizar(	Long  id, Huesped huesped) { 
	
		String actualizarSqlsentencia = "UPDATE  HUESPED " + "SET cedula =? ," + "nombre=? , " + "apellido=? , "
				+ "nacionalidad=? , "+  "fechaNacimiento=? " + "WHERE  id=?";

		try (PreparedStatement prepareStatement = conector.prepareStatement(actualizarSqlsentencia)) {

			prepareStatement.setString(1,huesped.getCedula());
			prepareStatement.setString(2, huesped.getNombre());
			prepareStatement.setString(3, huesped.getApellido());
			prepareStatement.setString(4, (huesped.getNacionalidad()));
			prepareStatement.setDate(5, Date.valueOf(huesped.getFechaNacimiento()));
			prepareStatement.setLong(6, id);
			
			prepareStatement.executeUpdate();
			JOptionPane.showMessageDialog(null, " se  actualizó  el Huesped  exitosamente");
			conector.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("error al  actualizar el recurso" + " " + e.getMessage());
		}
		
			
		

	}

	@Override
	public List<Huesped> listarHuesped() {  //probado
		List<Huesped> listaHuesped = new ArrayList<Huesped>();
		String selectTotalSqlsentencia = "SELECT  * FROM   HUESPED ";

		try (PreparedStatement prepareStatement = conector.prepareStatement(selectTotalSqlsentencia)) {

			try (ResultSet rs = prepareStatement.executeQuery()) {

				while (rs.next()) {

					Huesped huespedEncontrada = new Huesped();
					Reserva reservaid = new Reserva();
					huespedEncontrada.setIdReserva(reservaid);
					huespedEncontrada.setId(rs.getLong("id"));
					huespedEncontrada.setCedula(rs.getString("cedula"));
					huespedEncontrada.setNombre(rs.getString("nombre"));
					huespedEncontrada.setApellido(rs.getString("apellido"));
					huespedEncontrada.setNacionalidad(rs.getString("nacionalidad"));
					huespedEncontrada.getIdReserva().setId(rs.getLong("reservaid"));
					huespedEncontrada.setFechaNacimiento(rs.getDate("fechaNacimiento").toLocalDate());
					
					listaHuesped.add(huespedEncontrada);

				}
				
			}
			conector.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("error al  buscar los recursos");
		}
		

		return listaHuesped;
	}

	@Override
	public Huesped consultarHuespedId(String cedulaHuesped) { 
		Huesped huespedEncontrada = null;
		String selectByCedulaSqlsentencia = "SELECT  * FROM   HUESPED " + "WHERE  cedula=?";

		try (PreparedStatement prepareStatement = conector.prepareStatement(selectByCedulaSqlsentencia)) {

			prepareStatement.setString(1, (cedulaHuesped));
			try (ResultSet rs = prepareStatement.executeQuery()) {

				while (rs.next()) {

					huespedEncontrada = new Huesped();
					Reserva reservaid= new Reserva();
			
					huespedEncontrada.setIdReserva(reservaid);
					huespedEncontrada.setId(rs.getLong("id"));
					huespedEncontrada.setCedula(rs.getString("cedula"));
					huespedEncontrada.setNombre(rs.getString("nombre"));
					huespedEncontrada.setApellido(rs.getString("apellido"));
					huespedEncontrada.setNacionalidad(rs.getString("nacionalidad"));
					huespedEncontrada.getIdReserva().setId(rs.getLong("reservaid"));
					huespedEncontrada.setFechaNacimiento(rs.getDate("fechaNacimiento").toLocalDate());

				}
				if (huespedEncontrada == null) {

					JOptionPane.showMessageDialog(null, "elemento no existente en bd");

				}

			}
			conector.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("error al  buscar el recurso");
		}
		

		return huespedEncontrada;
	}



	@Override
	public void removerPorReservaId(Long id) throws SQLException {
		
			
			String deleteSqlsentencia = "DELETE  FROM HUESPED " + "WHERE  reservaid= ?";

			try (PreparedStatement prepareStatement = conector.prepareStatement(deleteSqlsentencia)) {
		
				prepareStatement.setInt(1, Integer.parseInt((id).toString()));
				prepareStatement.executeUpdate();
				JOptionPane.showMessageDialog(null, " Se  el Huesped " + Integer.parseInt((id).toString()));
				conector.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				throw  new SQLException(e.getMessage());
			}
		
				
			

		
		
	}

@Override
	public List<Huesped> listaHuespedByFechaNacimiento(String fecha) {
	Huesped huespedEncontrada = null;
	String selectByFechaSqlsentencia = "SELECT  * FROM   HUESPED " + "WHERE  fechaNacimiento=?";
	List<Huesped> listaHuesped= new ArrayList<>();

	try (PreparedStatement prepareStatement = conector.prepareStatement(selectByFechaSqlsentencia)) {
		
		prepareStatement.setDate(1, Date.valueOf(fecha)); //formato ingresado en el filtro debe ser con yyyy-mm-dd
		try (ResultSet rs = prepareStatement.executeQuery()) {

			while (rs.next()) {

				huespedEncontrada  = new Huesped();
				Reserva reservaid= new Reserva();
				
				huespedEncontrada.setIdReserva(reservaid);
				huespedEncontrada.setId(rs.getLong("id"));
				huespedEncontrada.setCedula(rs.getString("cedula"));
				huespedEncontrada.setNombre(rs.getString("nombre"));
				huespedEncontrada.setApellido(rs.getString("apellido"));
				huespedEncontrada.setNacionalidad(rs.getString("nacionalidad"));
				huespedEncontrada.getIdReserva().setId(rs.getLong("reservaid"));
				huespedEncontrada.setFechaNacimiento(rs.getDate("fechaNacimiento").toLocalDate());
				listaHuesped.add(huespedEncontrada);

			}
			
		}
		conector.close();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		System.out.println("error al  buscar la lista ");
	} 
	
	return listaHuesped;
	}

}
