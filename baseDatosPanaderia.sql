#Panaderia
create database if not exists panaderia;

use panaderia;


create table if not exists funcionario (
id_funcionario int primary key auto_increment,
usuario_funcionario varchar(50) not null,
contrasena_funcionario varchar(50) not null

)engine = INNODB;


create table if not exists producto(
id_producto int primary key auto_increment,
nombre_producto varchar(50) not null,
precio_producto int not null

)engine = INNODB;

create table if not exists compra(
id_compra int primary key auto_increment,
fecha_compra varchar(50) not null,
hora_compra varchar(50) not null,
productos_compra int not null,
total_compra int not null

)engine = INNODB;

insert into funcionario(usuario_funcionario,contrasena_funcionario)
values("panadero","amopan");

insert into producto(nombre_producto,precio_producto)
values	("Bagguette",750),
		("Dona",600),
        ("Queque chocolate",1500);



select * from compra;
select * from producto;
select * from funcionario;

