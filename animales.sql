create database apAnimales;

/* Creacion de bases de datos */
create table animales(
id int primary key auto_increment not null,
nombre varchar(20) not null,
nombreCientifico varchar(50),
habitad varchar(20),
especie varchar (50) not null,
peso int (3),
dieta varchar(20),
peligroExtincion tinyInt(1) not null
);
drop table animales;

/* Mostrar todos los animnales */
select * from animales;

/*  */

/* Crear animales */
insert into animales (nombre, nombreCientifico, habitad, especie,peso,dieta, peligroExtincion) 
values ("Lobo Mexicano","Canis lupus baileyi","bosque", "C. lupus", "45kg","Carnivoro",1);

/* Actualizar datos */






