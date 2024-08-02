-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 02-08-2024 a las 05:20:29
-- Versión del servidor: 10.4.32-MariaDB
-- Versión de PHP: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `gimnasiopf`
--
CREATE DATABASE IF NOT EXISTS `gimnasiopf` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `gimnasiopf`;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `asistencia`
--

CREATE TABLE `asistencia` (
  `ID_Asistencia` int(11) NOT NULL,
  `ID_Socio` int(11) NOT NULL,
  `ID_Clase` int(11) NOT NULL,
  `Fecha_Asistencia` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `clase`
--

CREATE TABLE `clase` (
  `ID_Clase` int(11) NOT NULL,
  `ID_Entrenador` int(11) NOT NULL,
  `Horario` time NOT NULL,
  `Nombre` varchar(32) NOT NULL,
  `Capacidad` int(11) NOT NULL,
  `estado` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `clase`
--

INSERT INTO `clase` (`ID_Clase`, `ID_Entrenador`, `Horario`, `Nombre`, `Capacidad`, `estado`) VALUES
(1, 1, '10:00:00', 'Karate', 30, 1),
(2, 2, '19:00:00', 'Calistenia', 20, 1),
(3, 3, '07:00:00', 'Taekwondo', 4, 1),
(4, 2, '18:00:00', 'Calistenia', 20, 0);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `entrenador`
--

CREATE TABLE `entrenador` (
  `ID_Entrenador` int(11) NOT NULL,
  `DNI` int(11) NOT NULL,
  `Nombre` varchar(32) NOT NULL,
  `Apellido` varchar(32) NOT NULL,
  `Especialidad` varchar(64) NOT NULL,
  `estado` tinyint(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `entrenador`
--

INSERT INTO `entrenador` (`ID_Entrenador`, `DNI`, `Nombre`, `Apellido`, `Especialidad`, `estado`) VALUES
(1, 41920110, 'Brayan', 'Lucero', 'Karate', 1),
(2, 45802690, 'Ramiro', 'Romero', 'Calistenia', 1),
(3, 38169587, 'Nicolas', 'Bustamante', 'Taekwondo', 1),
(4, 33445566, 'Pablo', 'Poder', 'Powerlifting', 0);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `membresía`
--

CREATE TABLE `membresía` (
  `ID_Membresía` int(11) NOT NULL,
  `ID_Socio` int(11) NOT NULL,
  `Fecha_Inicio` date NOT NULL,
  `Fecha_Fin` date NOT NULL,
  `estado` tinyint(1) DEFAULT NULL,
  `costo` decimal(10,0) DEFAULT NULL,
  `CantidadPases` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `membresía`
--

INSERT INTO `membresía` (`ID_Membresía`, `ID_Socio`, `Fecha_Inicio`, `Fecha_Fin`, `estado`, `costo`, `CantidadPases`) VALUES
(28, 62, '2024-08-01', '2024-09-01', 0, 10000, 0),
(29, 63, '2024-08-01', '2024-09-01', 0, 15000, 12),
(30, 64, '2024-08-01', '2024-09-01', 1, 25000, 20),
(31, 62, '2024-09-01', '2024-11-01', 1, 15000, 12),
(32, 63, '2024-06-01', '2024-07-01', 0, 10000, 8),
(33, 63, '2024-05-01', '2024-06-01', 1, 10000, 8),
(34, 64, '2024-10-01', '2024-11-01', 1, 10000, 0),
(35, 63, '2023-08-01', '2023-09-01', 1, 10000, 0),
(36, 64, '2022-08-01', '2022-09-01', 0, 10000, 0);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `socio`
--

CREATE TABLE `socio` (
  `ID_Socio` int(11) NOT NULL,
  `DNI` int(10) UNSIGNED NOT NULL,
  `Nombre` varchar(32) NOT NULL,
  `Apellido` varchar(32) NOT NULL,
  `Edad` int(10) UNSIGNED NOT NULL,
  `Correo` varchar(64) NOT NULL,
  `Teléfono` varchar(32) NOT NULL,
  `estado` tinyint(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `socio`
--

INSERT INTO `socio` (`ID_Socio`, `DNI`, `Nombre`, `Apellido`, `Edad`, `Correo`, `Teléfono`, `estado`) VALUES
(62, 12345678, 'Rodrigo', 'Rodriguez', 32, 'patito@gmail.com', '123456', 1),
(63, 12345679, 'Ramiro', 'Ramires', 18, 'rama@gmail.com', '123457', 1),
(64, 12345670, 'Gonzalo', 'González', 25, 'zalo@gmail.com', '123458', 1),
(65, 12345671, 'Martin', 'Martinez', 20, 'martin@gmail.com', '123459', 0);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `asistencia`
--
ALTER TABLE `asistencia`
  ADD PRIMARY KEY (`ID_Asistencia`),
  ADD KEY `id_socio_fk` (`ID_Socio`),
  ADD KEY `id_clase_fk` (`ID_Clase`);

--
-- Indices de la tabla `clase`
--
ALTER TABLE `clase`
  ADD PRIMARY KEY (`ID_Clase`),
  ADD KEY `entrenador_fk` (`ID_Entrenador`);

--
-- Indices de la tabla `entrenador`
--
ALTER TABLE `entrenador`
  ADD PRIMARY KEY (`ID_Entrenador`),
  ADD UNIQUE KEY `dni_unico_entrenador` (`DNI`);

--
-- Indices de la tabla `membresía`
--
ALTER TABLE `membresía`
  ADD PRIMARY KEY (`ID_Membresía`),
  ADD KEY `socio_fk` (`ID_Socio`);

--
-- Indices de la tabla `socio`
--
ALTER TABLE `socio`
  ADD PRIMARY KEY (`ID_Socio`),
  ADD UNIQUE KEY `dni_unico_socio` (`DNI`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `asistencia`
--
ALTER TABLE `asistencia`
  MODIFY `ID_Asistencia` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT de la tabla `clase`
--
ALTER TABLE `clase`
  MODIFY `ID_Clase` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de la tabla `entrenador`
--
ALTER TABLE `entrenador`
  MODIFY `ID_Entrenador` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de la tabla `membresía`
--
ALTER TABLE `membresía`
  MODIFY `ID_Membresía` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=37;

--
-- AUTO_INCREMENT de la tabla `socio`
--
ALTER TABLE `socio`
  MODIFY `ID_Socio` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=66;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `asistencia`
--
ALTER TABLE `asistencia`
  ADD CONSTRAINT `asistencia_fk_clase` FOREIGN KEY (`ID_Clase`) REFERENCES `clase` (`ID_Clase`),
  ADD CONSTRAINT `asistencia_fk_socio` FOREIGN KEY (`ID_Socio`) REFERENCES `socio` (`ID_Socio`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `clase`
--
ALTER TABLE `clase`
  ADD CONSTRAINT `clase_fk_entrenador` FOREIGN KEY (`ID_Entrenador`) REFERENCES `entrenador` (`ID_Entrenador`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `membresía`
--
ALTER TABLE `membresía`
  ADD CONSTRAINT `membresía_fk_socio` FOREIGN KEY (`ID_Socio`) REFERENCES `socio` (`ID_Socio`) ON DELETE NO ACTION ON UPDATE NO ACTION;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
