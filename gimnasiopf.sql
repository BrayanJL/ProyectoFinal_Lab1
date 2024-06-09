-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jun 09, 2024 at 12:24 AM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `gimnasiopf`
--
CREATE DATABASE IF NOT EXISTS `gimnasiopf` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `gimnasiopf`;

-- --------------------------------------------------------

--
-- Table structure for table `asistencia`
--

CREATE TABLE `asistencia` (
  `ID_Asistencia` int(11) NOT NULL,
  `ID_Socio` int(11) NOT NULL,
  `ID_Clase` int(11) NOT NULL,
  `Fecha_Asistencia` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `clase`
--

CREATE TABLE `clase` (
  `ID_Clase` int(11) NOT NULL,
  `ID_Entrenador` int(11) NOT NULL,
  `Horario` time NOT NULL,
  `Nombre` varchar(32) NOT NULL,
  `Capacidad` int(11) NOT NULL,
  `estado` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `entrenador`
--

CREATE TABLE `entrenador` (
  `ID_Entrenador` int(11) NOT NULL,
  `DNI` int(11) NOT NULL,
  `Nombre` varchar(32) NOT NULL,
  `Apellido` varchar(32) NOT NULL,
  `Especialidad` varchar(64) NOT NULL,
  `Disponibilidad` varchar(32) NOT NULL,
  `estado` tinyint(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `membresía`
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
-- Dumping data for table `membresía`
--

INSERT INTO `membresía` (`ID_Membresía`, `ID_Socio`, `Fecha_Inicio`, `Fecha_Fin`, `estado`, `costo`, `CantidadPases`) VALUES
(24, 58, '2024-03-23', '2024-04-23', 1, 2400, 0),
(25, 59, '2024-06-13', '2024-07-13', 1, 2500, 0),
(26, 61, '2024-04-10', '2024-05-10', 1, 1800, 0);

-- --------------------------------------------------------

--
-- Table structure for table `socio`
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
-- Dumping data for table `socio`
--

INSERT INTO `socio` (`ID_Socio`, `DNI`, `Nombre`, `Apellido`, `Edad`, `Correo`, `Teléfono`, `estado`) VALUES
(58, 42375484, 'Jose', 'Ramirez', 24, 'JoseRamirez@Gmail.com', '2664734954', 1),
(59, 38888888, 'Hermione', 'Pepinez', 33, 'Herma@hotmail.com', '2664664433', 1),
(60, 40999888, 'Richard', 'Pepinez', 54, 'Ricky@hotmail.com', '2664768798', 0),
(61, 38777888, 'Robert', 'Nixon', 54, 'Robxon@hotmail.com', '2664866998', 1);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `asistencia`
--
ALTER TABLE `asistencia`
  ADD PRIMARY KEY (`ID_Asistencia`),
  ADD KEY `id_socio_fk` (`ID_Socio`),
  ADD KEY `id_clase_fk` (`ID_Clase`);

--
-- Indexes for table `clase`
--
ALTER TABLE `clase`
  ADD PRIMARY KEY (`ID_Clase`),
  ADD KEY `entrenador_fk` (`ID_Entrenador`);

--
-- Indexes for table `entrenador`
--
ALTER TABLE `entrenador`
  ADD PRIMARY KEY (`ID_Entrenador`),
  ADD UNIQUE KEY `dni_unico_entrenador` (`DNI`);

--
-- Indexes for table `membresía`
--
ALTER TABLE `membresía`
  ADD PRIMARY KEY (`ID_Membresía`),
  ADD KEY `socio_fk` (`ID_Socio`);

--
-- Indexes for table `socio`
--
ALTER TABLE `socio`
  ADD PRIMARY KEY (`ID_Socio`),
  ADD UNIQUE KEY `dni_unico_socio` (`DNI`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `asistencia`
--
ALTER TABLE `asistencia`
  MODIFY `ID_Asistencia` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `clase`
--
ALTER TABLE `clase`
  MODIFY `ID_Clase` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `entrenador`
--
ALTER TABLE `entrenador`
  MODIFY `ID_Entrenador` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `membresía`
--
ALTER TABLE `membresía`
  MODIFY `ID_Membresía` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=28;

--
-- AUTO_INCREMENT for table `socio`
--
ALTER TABLE `socio`
  MODIFY `ID_Socio` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=62;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `asistencia`
--
ALTER TABLE `asistencia`
  ADD CONSTRAINT `asistencia_fk_clase` FOREIGN KEY (`ID_Clase`) REFERENCES `clase` (`ID_Clase`),
  ADD CONSTRAINT `asistencia_fk_socio` FOREIGN KEY (`ID_Socio`) REFERENCES `socio` (`ID_Socio`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `clase`
--
ALTER TABLE `clase`
  ADD CONSTRAINT `clase_fk_entrenador` FOREIGN KEY (`ID_Entrenador`) REFERENCES `entrenador` (`ID_Entrenador`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `membresía`
--
ALTER TABLE `membresía`
  ADD CONSTRAINT `membresía_fk_socio` FOREIGN KEY (`ID_Socio`) REFERENCES `socio` (`ID_Socio`) ON DELETE NO ACTION ON UPDATE NO ACTION;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
