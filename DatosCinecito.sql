use cinecito;
-- Insertar datos en la tabla Usuarios
INSERT INTO `Usuarios` (`username`, `email`, `password`, `nombre`, `apellido`, `rol`) VALUES
('jdoe', 'jdoe@example.com', 'password123', 'John', 'Doe', 'Cliente'),
('asmith', 'asmith@example.com', 'password456', 'Alice', 'Smith', 'Cliente'),
('admin', 'admin@example.com', 'adminpassword', 'Admin', 'User', 'Administrador');

-- Insertar datos en la tabla Peliculas
INSERT INTO `Peliculas` (`titulo`, `duracion`, `clasificacion`, `descripcion`, `fecha_estreno`) VALUES
('Inception', 148, 'PG-13', 'A mind-bending thriller about dream manipulation.', '2010-07-16'),
('The Matrix', 136, 'R', 'A hacker discovers the reality is a simulation controlled by machines.', '1999-03-31'),
('Interstellar', 169, 'PG-13', 'A team of astronauts travel through a wormhole in search of a new home for humanity.', '2014-11-07');

-- Insertar datos en la tabla Salas
INSERT INTO `Salas` (`num_sala`, `capacidad`) VALUES
(1, 100),
(2, 150),
(3, 200);

-- Insertar datos en la tabla Funciones
INSERT INTO `Funciones` (`pelicula_id`, `sala_id`, `fecha_funcion`, `hora_funcion`, `precio`, `asientos_disponibles`) VALUES
(1, 1, '2024-09-15', '18:00:00', 8.50, 100),
(2, 2, '2024-09-15', '20:00:00', 9.00, 150),
(3, 3, '2024-09-16', '19:30:00', 10.00, 200);

-- Insertar datos en la tabla Ventas
INSERT INTO `Ventas` (`usuario_id`, `funcion_id`, `cantidad_boletos`, `total`) VALUES
(1, 1, 2, 17.00),
(2, 2, 3, 27.00),
(1, 3, 1, 10.00);

-- Insertar datos en la tabla Boletos
INSERT INTO `Boletos` (`venta_id`, `asiento_numero`) VALUES
(1, 10),
(1, 11),
(2, 25),
(2, 26),
(2, 27),
(3, 50);
