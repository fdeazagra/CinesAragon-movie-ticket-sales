-- phpMyAdmin SQL Dump
-- version 5.1.0
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 07-10-2021 a las 01:53:36
-- Versión del servidor: 10.4.17-MariaDB
-- Versión de PHP: 8.0.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `cines_aragon`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cine`
--

CREATE TABLE `cine` (
  `id` bigint(20) NOT NULL,
  `nombre` varchar(255) COLLATE utf16_spanish2_ci DEFAULT NULL,
  `provincia` varchar(20) COLLATE utf16_spanish2_ci DEFAULT NULL,
  `pases` varchar(255) COLLATE utf16_spanish2_ci DEFAULT NULL,
  `telefono` varchar(255) COLLATE utf16_spanish2_ci DEFAULT NULL,
  `ciudad` varchar(20) COLLATE utf16_spanish2_ci NOT NULL,
  `pelicula_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf16 COLLATE=utf16_spanish2_ci;

--
-- Volcado de datos para la tabla `cine`
--

INSERT INTO `cine` (`id`, `nombre`, `provincia`, `pases`, `telefono`, `ciudad`, `pelicula_id`) VALUES
(1, 'Palafox', 'Zaragoza', '17:00 - 19:00 - 21:00', '976233868', 'Zaragoza', 1),
(2, 'Aragonia', 'Zaragoza', ' 20:00 - 22:00', '876543210', 'Zaragoza', 4),
(3, 'Cervantes', 'Zaragoza', '20:00 - 22:00', '976217510', 'Zaragoza', 3),
(4, 'Gran Casa', 'Zaragoza', '17:00 - 19:00 - 21:00', '976466070', 'Zaragoza', 10),
(5, 'Puerto Venecia', 'Zaragoza', '18:00 - 20:00 - 22:00', '902333231', 'Zaragoza', 5),
(6, 'CineMundo', 'Huesca', '17:00 - 19:00 - 21:00', '974238658', 'Huesca', 6),
(7, 'Victoria', 'Huesca', '20:00 - 22:00', '974999224', 'Monzon', 7),
(8, 'Maravillas', 'Teruel', '21:00 - 23:00', '978607187', 'Teruel', 8),
(9, 'Principal', 'Zaragoza', '20:00 - 22:00', '976881137', 'Calatayud', 9),
(10, 'Palacio Ardid', 'Teruel', '17:00 - 19:00 - 21:00', '976300630', 'Alcaniz', 11),
(11, 'Goya', 'Zaragoza', '21:00 - 23:00', '973610519', 'Mequinenza', 2),
(12, 'Bellas Artes', 'Zaragoza', '17:00 - 21:00', '976644664', 'Tarazona', 12);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `film`
--

CREATE TABLE `film` (
  `id` bigint(20) NOT NULL,
  `titulo` varchar(255) COLLATE utf16_spanish2_ci DEFAULT NULL,
  `ficha` varchar(255) COLLATE utf16_spanish2_ci DEFAULT NULL,
  `genero` varchar(255) COLLATE utf16_spanish2_ci DEFAULT NULL,
  `trailer` varchar(255) COLLATE utf16_spanish2_ci DEFAULT NULL,
  `url_imagen` varchar(255) COLLATE utf16_spanish2_ci DEFAULT NULL,
  `cine_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf16 COLLATE=utf16_spanish2_ci;

--
-- Volcado de datos para la tabla `film`
--

INSERT INTO `film` (`id`, `titulo`, `ficha`, `genero`, `trailer`, `url_imagen`, `cine_id`) VALUES
(1, 'Relatos Salvajes', 'Direccion: Damian Szifron\r\nReparto: Ricardo Darin, Dario Grandinetti, Leonardo Sbaraglia, ', 'Drama', 'https://vimeo.com/267807362', 'relatos_salvajes', 1),
(2, 'Apocalypse Now', 'Direccion: Francis Ford Coppola\r\nReparto: Martin Sheen, Marlon Brando, Robert Duvall', 'Belico', 'https://vimeo.com/78837402', 'apocalypse_now', 11),
(3, 'Sin Perdon', 'Direccion: Clint Eastwood\r\nReparto: Clint Eastwood, Gene Hackman, Morgan Freeman', 'Western', 'https://vimeo.com/31998306', 'sin_perdon', 3),
(4, 'Los Carmenes', 'Concierto: Fiestas del Pilar 2014\r\nComponentes: Fernando Frisa, Nacho Estevez, Fernando Azagra, Roberto Montanes, Carlos Marin ', 'Musical', 'https://www.youtube.com/watch?v=dFZhX94rT1Q', 'los_carmenes', 2),
(5, 'Los Santos Inocentes', 'Direccion: Mario Camus\r\nReparto: Alfredo Landa, Francisco Rabal, Juan Diego', 'Drama', 'https://vimeo.com/52321505', 'santos_inocentes', 5),
(6, 'Reservoir Dogs', 'Direccion: Quentin Tarantino\r\nReparto: Tim Roth, Harvey Keitel, Steve Buscemi', 'Thriller', 'https://vimeo.com/311770413', 'reservoir_dogs', 6),
(7, 'El Club de la Lucha', 'Direccion: David Fincher\r\nReparto:Edward Norton, Brad Pitt, Helena Bonham Carter', 'Drama', 'https://vimeo.com/80933695', 'club_lucha', 7),
(8, 'Blade Runner', 'Direccion: Ridley Scott\r\nReparto: Harrison Ford, Rutger Hauer, Daryl Hannah', 'Ciencia Ficcion', 'https://vimeo.com/3152204', 'blade_runner', 8),
(9, 'El Secreto de sus Ojos', 'Direccion: Juan Jose Campanella\r\nReparto: Ricardo Darin, Soledad Villamil, Pablo Rago', 'Thriller', 'https://vimeo.com/6713135', 'secreto_ojos', 9),
(10, 'La Chaqueta Metalica', 'Direccion: Stanley Kubrick\r\nReparto: Matthew Modine, Vincent D\'Onofrio, R. Lee Ermey', 'Belico', 'https://vimeo.com/37714100', 'chaqueta_metalica', 4),
(11, 'Valor de Ley', 'Direccion: Joel Coen y Ethan Coen\r\nReparto: Jeff Bridges, Hailee Steinfeld, Matt Damon', 'Western', 'https://www.youtube.com/watch?v=bT6al71VRp0', 'valor_ley', 10),
(12, 'Wall-E', 'Direccion: Andrew Stanton\r\nReparto: Ben Burtt, Elissa Knight, Jeff Garlin', 'Ciencia Ficcion', 'https://www.youtube.com/watch?v=4rDD3SccHxQ', 'wall_e', 12);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ticket`
--

CREATE TABLE `ticket` (
  `id` bigint(20) NOT NULL,
  `fecha` datetime DEFAULT NULL,
  `cine_id` bigint(20) DEFAULT NULL,
  `pelicula_id` bigint(20) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf16 COLLATE=utf16_spanish2_ci;

--
-- Volcado de datos para la tabla `ticket`
--

INSERT INTO `ticket` (`id`, `fecha`, `cine_id`, `pelicula_id`, `user_id`) VALUES
(1, '2021-09-23 14:11:11', 6, 10, 1),
(2, '2021-09-13 10:45:30', 2, 1, 3),
(3, '2021-10-01 18:10:30', 9, 8, 3),
(4, '2021-08-27 15:25:22', 7, 3, 2),
(5, '2021-08-25 16:36:07', 3, 11, 1),
(6, '2021-09-08 13:56:48', 4, 9, 2),
(7, '2021-09-19 11:18:39', 9, 4, 3),
(8, '2021-09-21 19:19:17', 5, 2, 3),
(9, '2021-08-19 17:10:16', 11, 12, 1),
(10, '2021-08-31 14:40:48', 12, 6, 2),
(11, '2021-10-01 13:21:21', 1, 10, 2),
(12, '2021-09-27 22:21:57', 10, 11, 3),
(13, '2021-09-15 15:23:27', 9, 4, 1),
(14, '2021-10-03 21:24:18', 3, 5, 1),
(15, '2021-10-05 11:34:51', 6, 7, 2);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `user`
--

CREATE TABLE `user` (
  `id` bigint(20) NOT NULL,
  `nombre` varchar(255) COLLATE utf16_spanish2_ci DEFAULT NULL,
  `email` varchar(255) COLLATE utf16_spanish2_ci DEFAULT NULL,
  `pass` varchar(255) COLLATE utf16_spanish2_ci DEFAULT NULL,
  `ticket_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf16 COLLATE=utf16_spanish2_ci;

--
-- Volcado de datos para la tabla `user`
--

INSERT INTO `user` (`id`, `nombre`, `email`, `pass`, `ticket_id`) VALUES
(1, 'Fernando Alcantara', 'fer@mail.com', 'admin', NULL),
(2, 'Santiago Brizuela', 'santi@mail.com', '1234', NULL),
(3, 'Raul Gasset', 'raul@mail.com', '1111', NULL);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `cine`
--
ALTER TABLE `cine`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKjf70binf2vbcahfn3nt8bdknc` (`pelicula_id`);

--
-- Indices de la tabla `film`
--
ALTER TABLE `film`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKfpcdtth7jra2hf77cfuk91tip` (`cine_id`);

--
-- Indices de la tabla `ticket`
--
ALTER TABLE `ticket`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK4q8pn5h9jji7ntw93fds1igln` (`cine_id`),
  ADD KEY `FKjsj1y2dyktago9ahd8jqullc2` (`pelicula_id`),
  ADD KEY `FKdvt57mcco3ogsosi97odw563o` (`user_id`);

--
-- Indices de la tabla `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`),
  ADD KEY `ticket_id` (`ticket_id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `cine`
--
ALTER TABLE `cine`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- AUTO_INCREMENT de la tabla `film`
--
ALTER TABLE `film`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;

--
-- AUTO_INCREMENT de la tabla `ticket`
--
ALTER TABLE `ticket`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;

--
-- AUTO_INCREMENT de la tabla `user`
--
ALTER TABLE `user`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `cine`
--
ALTER TABLE `cine`
  ADD CONSTRAINT `FKj2t6ed73c04smh2blxynl86kw` FOREIGN KEY (`ciudad_id`) REFERENCES `ciudad` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `FKjf70binf2vbcahfn3nt8bdknc` FOREIGN KEY (`pelicula_id`) REFERENCES `film` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `film`
--
ALTER TABLE `film`
  ADD CONSTRAINT `FKfpcdtth7jra2hf77cfuk91tip` FOREIGN KEY (`cine_id`) REFERENCES `cine` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `ticket`
--
ALTER TABLE `ticket`
  ADD CONSTRAINT `FK4q8pn5h9jji7ntw93fds1igln` FOREIGN KEY (`cine_id`) REFERENCES `cine` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `FKdvt57mcco3ogsosi97odw563o` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `FKjsj1y2dyktago9ahd8jqullc2` FOREIGN KEY (`pelicula_id`) REFERENCES `film` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `user`
--
ALTER TABLE `user`
  ADD CONSTRAINT `FKgknq73pyrhagjhr7rupahfg2l` FOREIGN KEY (`ciudad_id`) REFERENCES `ciudad` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `user_ibfk_1` FOREIGN KEY (`ticket_id`) REFERENCES `ticket` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
