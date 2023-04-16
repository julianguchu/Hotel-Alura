package proyectoAlura.proyectoalura.ModeloFacil;

import java.time.LocalDate;

public class Reserva {
	private Long id;
	private  Double  valor;
	private LocalDate fechaEntrada;
	private LocalDate fechaSalida;
	private String formaPago;
	
	
	
	public Reserva() {

	}



	public Reserva(Double valor, LocalDate fechaEntrada, LocalDate fechaSalida, String formaPago) {
	
		this.valor = valor;
		this.fechaEntrada = fechaEntrada;
		this.fechaSalida = fechaSalida;
		this.formaPago = formaPago;
	}



	public Reserva(Long id ) {
		this.id=id;
	}



	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public Double getValor() {
		return valor;
	}



	public void setValor(Double valor) {
		this.valor = valor;
	}



	public LocalDate getFechaEntrada() {
		return fechaEntrada;
	}



	public void setFechaEntrada(LocalDate fechaEntrada) {
		this.fechaEntrada = fechaEntrada;
	}



	public LocalDate getFechaSalida() {
		return fechaSalida;
	}



	public void setFechaSalida(LocalDate fechaSalida) {
		this.fechaSalida = fechaSalida;
	}



	public String getFormaPago() {
		return formaPago;
	}



	public void setFormaPago(String formaPago) {
		this.formaPago = formaPago;
	}



	@Override
	public String toString() {
		return "Reserva [id=" + id + ", valor=" + valor + ", fechaEntrada=" + fechaEntrada + ", fechaSalida="
				+ fechaSalida + ", formaPago=" + formaPago + "]";
	}
	

	
	
	
}
