package proyectoAlura.proyectoalura.DaoFacil;

import java.sql.SQLException;
import java.util.List;

import proyectoAlura.proyectoalura.ModeloFacil.Huesped;


public interface  DaoHuesped{
	
	Huesped crear(Huesped   huesped);

	 void  actualizar(Long  id, Huesped huesped);
	 Huesped consultarHuespedId(String id);
	 List<Huesped> listarHuesped();
	void removerPorReservaId(Long id ) throws SQLException;
	void remover(String cedulaHuesped, Long id) throws SQLException;
	List<Huesped> listaHuespedByFechaNacimiento(String fecha);


}
