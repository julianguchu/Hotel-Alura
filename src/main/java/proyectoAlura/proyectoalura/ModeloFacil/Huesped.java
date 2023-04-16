package proyectoAlura.proyectoalura.ModeloFacil;

import java.time.LocalDate;

public class Huesped {
	private  Long id ;
private  String cedula ;
private  String nombre;
private  String apellido;
private String nacionalidad;
private  LocalDate fechaNacimiento;
private  Reserva  idReserva;




public  Huesped() {}






public Huesped(String cedula, String nombre, String apellido, String nacionalidad, LocalDate fechaNacimiento,
		Reserva idReserva) {
	this.cedula = cedula;
	this.nombre = nombre;
	this.apellido = apellido;
	this.nacionalidad = nacionalidad;
	this.fechaNacimiento = fechaNacimiento;
	this.idReserva = idReserva;
}













public String getNombre() {
	return nombre;
}




public void setNombre(String nombre) {
	this.nombre = nombre;
}




public String getApellido() {
	return apellido;
}




public void setApellido(String apellido) {
	this.apellido = apellido;
}




public String getNacionalidad() {
	return nacionalidad;
}




public void setNacionalidad(String nacionalidad) {
	this.nacionalidad = nacionalidad;
}




public LocalDate getFechaNacimiento() {
	return fechaNacimiento;
}




public void setFechaNacimiento(LocalDate fechaNacimiento) {
	this.fechaNacimiento = fechaNacimiento;
}




public Reserva getIdReserva() {
	return idReserva;
}




public void setIdReserva(Reserva idReserva) {
	this.idReserva = idReserva;
}




public Long getId() {
	return id;
}




public void setId(Long id) {
	this.id = id;
}




public String getCedula() {
	return cedula;
}




public void setCedula(String cedula) {
	this.cedula = cedula;
}




@Override
public String toString() {
	return "Huesped [id=" + id + ", cedula=" + cedula + ", nombre=" + nombre + ", apellido=" + apellido
			+ ", nacionalidad=" + nacionalidad + ", fechaNacimiento=" + fechaNacimiento + ", idReserva=" + idReserva
			+ "]";
}






}
