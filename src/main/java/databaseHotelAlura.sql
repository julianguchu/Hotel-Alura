create database baseAluraSencilla;

create  table huesped (id  varchar(10)  not null primary key ,  nombre varchar(12) , apellido varchar(12),
 nacionalidad varchar(12), fechaNacimiento date , 
 reservaid int );
create  table  reserva (idReserva  int not null primary key, valor  decimal(12,2), formPago varchar(12),
 fechaEntrada date , 
	fechaSalida date);
    alter table reserva modify column idReserva int NOT NULL AUTO_INCREMENT;
    alter table huesped  add constraint  fk_reserva foreign key (reservaid) references reserva(idReserva);


alter table huesped  modify column  id  int not null auto_increment;
use  baseAluraSencilla;


	