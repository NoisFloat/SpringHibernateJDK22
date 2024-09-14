CREATE DATABASE Cinecito;
USE Cinecito;
CREATE TABLE `Usuarios` (
	`usuario_id` INTEGER NOT NULL AUTO_INCREMENT UNIQUE,
	`username` VARCHAR(255) NOT NULL UNIQUE,
	`email` VARCHAR(255) NOT NULL UNIQUE,
	`password` VARCHAR(255) NOT NULL,
	`nombre` VARCHAR(255) NOT NULL,
	`apellido` VARCHAR(255) NOT NULL,
	`rol` VARCHAR(255) NOT NULL,
	PRIMARY KEY(`usuario_id`)
);


CREATE TABLE `Peliculas` (
	`pelicula_id` INTEGER NOT NULL AUTO_INCREMENT UNIQUE,
	`titulo` VARCHAR(255) NOT NULL,
	`duracion` INTEGER NOT NULL,
	`clasificacion` VARCHAR(10),
	`descripcion` TEXT(65535),
	`fecha_estreno` DATE,
	PRIMARY KEY(`pelicula_id`)
);


CREATE TABLE `Salas` (
	`sala_id` INTEGER NOT NULL AUTO_INCREMENT UNIQUE,
	`num_sala` INTEGER NOT NULL,
	`capacidad` INTEGER NOT NULL,
	PRIMARY KEY(`sala_id`)
);


CREATE TABLE `Funciones` (
	`funcion_id` INTEGER NOT NULL AUTO_INCREMENT UNIQUE,
	`pelicula_id` INTEGER,
	`sala_id` INTEGER,
	`fecha_funcion` DATE NOT NULL,
	`hora_funcion` TIME NOT NULL,
	`precio` DECIMAL(10,2) NOT NULL,
	`asientos_disponibles` INTEGER NOT NULL,
	PRIMARY KEY(`funcion_id`)
);


CREATE TABLE `Ventas` (
	`venta_id` INTEGER NOT NULL AUTO_INCREMENT UNIQUE,
	`usuario_id` INTEGER,
	`funcion_id` INTEGER,
	`cantidad_boletos` INTEGER NOT NULL,
	`total` DECIMAL(10,2) NOT NULL,
	PRIMARY KEY(`venta_id`)
);


CREATE TABLE `Boletos` (
	`boleto_id` INTEGER NOT NULL AUTO_INCREMENT UNIQUE,
	`venta_id` INTEGER,
	`asiento_numero` INTEGER NOT NULL,
	PRIMARY KEY(`boleto_id`)
);


ALTER TABLE `Funciones`
ADD FOREIGN KEY(`pelicula_id`) REFERENCES `Peliculas`(`pelicula_id`)
ON UPDATE NO ACTION ON DELETE NO ACTION;
ALTER TABLE `Funciones`
ADD FOREIGN KEY(`sala_id`) REFERENCES `Salas`(`sala_id`)
ON UPDATE NO ACTION ON DELETE NO ACTION;
ALTER TABLE `Ventas`
ADD FOREIGN KEY(`usuario_id`) REFERENCES `Usuarios`(`usuario_id`)
ON UPDATE NO ACTION ON DELETE NO ACTION;
ALTER TABLE `Ventas`
ADD FOREIGN KEY(`funcion_id`) REFERENCES `Funciones`(`funcion_id`)
ON UPDATE NO ACTION ON DELETE NO ACTION;
ALTER TABLE `Boletos`
ADD FOREIGN KEY(`venta_id`) REFERENCES `Ventas`(`venta_id`)
ON UPDATE NO ACTION ON DELETE NO ACTION;