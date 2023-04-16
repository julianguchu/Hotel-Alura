package proyectoAlura.proyectoalura.DaoFacil;

import java.sql.SQLException;
import java.util.List;

import proyectoAlura.proyectoalura.ModeloFacil.Reserva;





public interface DaoReserva {

	
	Reserva crear(Reserva reserva);
	 void   remover  (Long  idReserva) throws SQLException;
	 void  actualizar(Long idReserva, Reserva reserva);
	 Reserva consultarReservaId(Long idReserva);
	 List<Reserva> listarReservas();
		List<Reserva> listaReservaByFechaEntrada(String fecha);

}
