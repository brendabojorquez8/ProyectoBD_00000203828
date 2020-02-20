-- phpMyAdmin SQL Dump
-- version 4.6.6
-- https://www.phpmyadmin.net/
--
-- Servidor: localhost
-- Tiempo de generación: 20-02-2020 a las 05:23:30
-- Versión del servidor: 5.7.17-log
-- Versión de PHP: 5.6.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `clubnautico`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `barcos`
--

CREATE TABLE `barcos` (
  `idbarcos` int(11) NOT NULL,
  `matricula` varchar(10) NOT NULL,
  `nombre` varchar(100) NOT NULL,
  `numamarre` int(11) NOT NULL,
  `cuota` float NOT NULL,
  `idsocios` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `barcos`
--

INSERT INTO `barcos` (`idbarcos`, `matricula`, `nombre`, `numamarre`, `cuota`, `idsocios`) VALUES
(7, 'DTOC001', 'Dumb bish', 4, 15000, 32);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `salidas`
--

CREATE TABLE `salidas` (
  `idsalidas` int(11) NOT NULL,
  `fechahora` datetime NOT NULL,
  `destino` varchar(100) NOT NULL,
  `idbarcos` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `salidas`
--

INSERT INTO `salidas` (`idsalidas`, `fechahora`, `destino`, `idbarcos`) VALUES
(8, '2020-03-17 00:00:00', 'San Carlos', 7);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `socios`
--

CREATE TABLE `socios` (
  `idsocios` int(11) NOT NULL,
  `curp` varchar(18) NOT NULL,
  `nombre` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `socios`
--

INSERT INTO `socios` (`idsocios`, `curp`, `nombre`) VALUES
(28, 'BACH000702HSRRMMA9', 'Humberto Antonio Barrera Camarena'),
(29, 'OILL000207MSLRPZA1', 'Lizbeth Ortiz López'),
(30, 'GOMI000219MSRDCNA3', 'Ingrid Godoy Macías'),
(31, 'CAPK991109MSRLRR03', ' Karla Jazmín Clark Pérez'),
(32, 'TOCD000508MSRRBNA1', ' Daniela Torres Cibrián');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `barcos`
--
ALTER TABLE `barcos`
  ADD PRIMARY KEY (`idbarcos`),
  ADD UNIQUE KEY `numamarre_UNIQUE` (`numamarre`),
  ADD KEY `fk_barcos_socios_idx` (`idsocios`);

--
-- Indices de la tabla `salidas`
--
ALTER TABLE `salidas`
  ADD PRIMARY KEY (`idsalidas`),
  ADD KEY `fk_salidas_barcos_idx` (`idbarcos`);

--
-- Indices de la tabla `socios`
--
ALTER TABLE `socios`
  ADD PRIMARY KEY (`idsocios`),
  ADD UNIQUE KEY `curp_UNIQUE` (`curp`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `barcos`
--
ALTER TABLE `barcos`
  MODIFY `idbarcos` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;
--
-- AUTO_INCREMENT de la tabla `salidas`
--
ALTER TABLE `salidas`
  MODIFY `idsalidas` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;
--
-- AUTO_INCREMENT de la tabla `socios`
--
ALTER TABLE `socios`
  MODIFY `idsocios` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=34;
--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `barcos`
--
ALTER TABLE `barcos`
  ADD CONSTRAINT `fk_barcos_socios` FOREIGN KEY (`idsocios`) REFERENCES `socios` (`idsocios`);

--
-- Filtros para la tabla `salidas`
--
ALTER TABLE `salidas`
  ADD CONSTRAINT `fk_salidas_barcos` FOREIGN KEY (`idbarcos`) REFERENCES `barcos` (`idbarcos`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
