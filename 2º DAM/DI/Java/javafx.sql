-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 27-02-2020 a las 18:38:27
-- Versión del servidor: 10.1.38-MariaDB
-- Versión de PHP: 7.3.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `javafx`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `entrenadores`
--

CREATE TABLE `entrenadores` (
  `idEntrenador` int(20) NOT NULL,
  `nombreEntrenador` varchar(30) COLLATE utf8_spanish_ci NOT NULL,
  `dniEntrenador` varchar(10) COLLATE utf8_spanish_ci NOT NULL,
  `idEquipo` int(10) NOT NULL,
  `passwordEntrenador` varchar(20) COLLATE utf8_spanish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `entrenadores`
--

INSERT INTO `entrenadores` (`idEntrenador`, `nombreEntrenador`, `dniEntrenador`, `idEquipo`, `passwordEntrenador`) VALUES
(18, 'Sergio', '48512369D', 1, 'admin'),
(19, 'Leganes', '78986545V', 4, 'leganes'),
(20, 'Guti', '5456498E', 0, 'guti'),
(21, 'Juli', '7853212D', 5, 'juli'),
(22, 'Mario Muñoz', '78896554Ñ', 7, 'mario'),
(23, 'Sergio2', '7898365F', 1, 'admin');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `equipos`
--

CREATE TABLE `equipos` (
  `idEquipo` int(10) NOT NULL,
  `nombreEquipo` varchar(30) COLLATE utf8_spanish_ci NOT NULL,
  `ciudadEquipo` varchar(30) COLLATE utf8_spanish_ci NOT NULL,
  `imagenEquipo` varchar(50) COLLATE utf8_spanish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `equipos`
--

INSERT INTO `equipos` (`idEquipo`, `nombreEquipo`, `ciudadEquipo`, `imagenEquipo`) VALUES
(0, 'Amoros', 'Carabanchel Alto', 'amoros.png'),
(1, 'Arroyomolinos', 'Arroyomolinos', 'arroyomolinos.png'),
(2, 'Atlético de Pinto', 'Pinto', 'atleticoDePinto.png'),
(3, 'Getafe', 'Getafe', 'getafe.png'),
(4, 'Leganes', 'Leganes', 'leganes.png'),
(5, 'Móstoles', 'Mostoles', 'mostoles.png'),
(6, 'Pozuelo de Alarcón', 'Pozuelo de Alarcón', 'pozueloDeAlarcon.png'),
(7, 'Villanueva del Pardillo', 'Villanueva del Pardillo', 'villanuevaDelPardillo.png');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ids`
--

CREATE TABLE `ids` (
  `idEntrenador` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `ids`
--

INSERT INTO `ids` (`idEntrenador`) VALUES
(18),
(19),
(20),
(21),
(22),
(23);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `jugadores`
--

CREATE TABLE `jugadores` (
  `idJugador` int(11) NOT NULL,
  `dniJugador` varchar(30) COLLATE utf8_spanish_ci NOT NULL,
  `nombreJugador` varchar(30) COLLATE utf8_spanish_ci NOT NULL,
  `posicion` varchar(30) COLLATE utf8_spanish_ci NOT NULL,
  `idEntrenador` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `jugadores`
--

INSERT INTO `jugadores` (`idJugador`, `dniJugador`, `nombreJugador`, `posicion`, `idEntrenador`) VALUES
(33, '0', 'Sergio Garcia', 'Defensa', 18),
(34, '1', 'Sergio Hidalgo', 'Mediocentro', 18),
(35, '2', 'Miguel', 'Portero', 18),
(37, '5', 'Ruben', 'Defensa', 18),
(38, '6', 'Victor Martin', 'Defensa', 18),
(39, '7', 'Daniel Herrera', 'Mediocentro', 18),
(40, '8', 'Mario', 'Mediocentro', 18),
(41, '9', 'Adrian Palomero', 'Mediocentro', 18),
(42, '10', 'Pablo Barranco', 'Delantero', 18),
(43, '11', 'Manu', 'Delantero', 18);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `entrenadores`
--
ALTER TABLE `entrenadores`
  ADD PRIMARY KEY (`idEntrenador`),
  ADD KEY `idEntrenador` (`idEntrenador`),
  ADD KEY `idEquipo` (`idEquipo`);

--
-- Indices de la tabla `equipos`
--
ALTER TABLE `equipos`
  ADD PRIMARY KEY (`idEquipo`),
  ADD KEY `idEquipo` (`idEquipo`);

--
-- Indices de la tabla `ids`
--
ALTER TABLE `ids`
  ADD PRIMARY KEY (`idEntrenador`);

--
-- Indices de la tabla `jugadores`
--
ALTER TABLE `jugadores`
  ADD PRIMARY KEY (`idJugador`),
  ADD KEY `idEntrenador` (`idEntrenador`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `ids`
--
ALTER TABLE `ids`
  MODIFY `idEntrenador` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=24;

--
-- AUTO_INCREMENT de la tabla `jugadores`
--
ALTER TABLE `jugadores`
  MODIFY `idJugador` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=44;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `entrenadores`
--
ALTER TABLE `entrenadores`
  ADD CONSTRAINT `entrenadores_ibfk_1` FOREIGN KEY (`idEquipo`) REFERENCES `equipos` (`idEquipo`);

--
-- Filtros para la tabla `jugadores`
--
ALTER TABLE `jugadores`
  ADD CONSTRAINT `jugadores_ibfk_1` FOREIGN KEY (`idEntrenador`) REFERENCES `entrenadores` (`idEntrenador`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
