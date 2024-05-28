-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: localhost:3307
-- Tiempo de generación: 28-05-2024 a las 07:55:56
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
-- Base de datos: `biblioteca`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tb_libro`
--

CREATE TABLE `tb_libro` (
  `isbn` int(11) NOT NULL COMMENT 'Código ISBN de registro',
  `nombre` varchar(100) NOT NULL COMMENT 'Nombre del libro',
  `autor` varchar(100) NOT NULL COMMENT 'Autor del libro',
  `editorial` varchar(50) NOT NULL COMMENT 'Nombre de la editorial del libro',
  `anio` int(11) NOT NULL COMMENT 'Año de publicación del libro'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `tb_libro`
--

INSERT INTO `tb_libro` (`isbn`, `nombre`, `autor`, `editorial`, `anio`) VALUES
(978958612, 'Aprender PHP, MySQL y JavaScript', 'Robin Nixon', 'Marcombo', 2019),
(978958778, 'Desarrollo de aplicaciones Web con Jakarta EE', 'Cesar Francisco Castillo', 'Marcombo', 2022),
(978958850, 'Creación de un portal con PHP y MySQL', 'Jacobo Pavón Puertas', 'Alfaomega', 2011),
(978958851, 'Nuevo Libro 1', 'Autor 1', 'Editorial 1', 2023),
(978958852, 'Nuevo Libro 2', 'Autor 2', 'Editorial 2', 2024),
(978958853, 'Nuevo Libro 3', 'Autor 3', 'Editorial 3', 2025),
(978958854, 'Nuevo Libro 4', 'Autor 4', 'Editorial 4', 2026),
(978958855, 'Nuevo Libro 5', 'Autor 5', 'Editorial 5', 2027),
(978958856, 'Nuevo Libro 6', 'Autor 6', 'Editorial 6', 2028),
(978958857, 'Nuevo Libro 7', 'Autor 7', 'Editorial 7', 2029),
(978958858, 'Nuevo Libro 8', 'Autor 8', 'Editorial 8', 2030),
(978958859, 'Nuevo Libro 9', 'Autor 9', 'Editorial 9', 2031),
(978958860, 'Nuevo Libro 10', 'Autor 10', 'Editorial 10', 2032);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tb_usuario`
--

CREATE TABLE `tb_usuario` (
  `id` int(11) NOT NULL COMMENT 'ID del usuario',
  `nombre` varchar(100) NOT NULL COMMENT 'Nombre del usuario',
  `correo` varchar(100) NOT NULL COMMENT 'Correo electrónico del usuario',
  `contrasena` varchar(255) NOT NULL COMMENT 'Contraseña del usuario'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `tb_usuario`
--

INSERT INTO `tb_usuario` (`id`, `nombre`, `correo`, `contrasena`) VALUES
(4, 'Ana Fernandez', 'anafernandez@gmail.com', '123'),
(5, 'Luis Rodriguez', 'luisrodriguez@gmail.com', '123'),
(6, 'Elena Lopez', 'elenalopez@gmail.com', '123'),
(7, 'Javier Sanchez', 'javiersanchez@gmail.com', '123'),
(8, 'Sara Ramirez', 'sararamirez@gmail.com', '123'),
(9, 'Pablo Gonzalez', 'pablogonzalez@gmail.com', '123'),
(10, 'Laura Torres', 'lauratorres@gmail.com', '123');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `tb_libro`
--
ALTER TABLE `tb_libro`
  ADD PRIMARY KEY (`isbn`);

--
-- Indices de la tabla `tb_usuario`
--
ALTER TABLE `tb_usuario`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `correo` (`correo`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `tb_usuario`
--
ALTER TABLE `tb_usuario`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID del usuario', AUTO_INCREMENT=11;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
