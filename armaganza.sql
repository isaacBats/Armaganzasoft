-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Versión del servidor:         5.7.9 - MySQL Community Server (GPL)
-- SO del servidor:              Win64
-- HeidiSQL Versión:             9.3.0.4984
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- Volcando estructura de base de datos para armaganza
CREATE DATABASE IF NOT EXISTS `armaganza` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `armaganza`;


-- Volcando estructura para tabla armaganza.attributes
CREATE TABLE IF NOT EXISTS `attributes` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name_attribute` varchar(45) COLLATE utf8_spanish_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=69 DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

-- Volcando datos para la tabla armaganza.attributes: ~54 rows (aproximadamente)
/*!40000 ALTER TABLE `attributes` DISABLE KEYS */;
INSERT INTO `attributes` (`id`, `name_attribute`) VALUES
	(1, 'viscosidad'),
	(2, 'ph'),
	(3, 'incompatibilidad'),
	(10, 'prueba'),
	(14, 'tipo 2'),
	(15, 'alta viscosidad'),
	(16, 'mega duro'),
	(18, 'pica '),
	(19, 'pica '),
	(20, 'GRANDE'),
	(21, 'RUGOSA'),
	(22, 'RUGOSA'),
	(23, 'mojada'),
	(24, 'redonda'),
	(25, 'LITROS'),
	(28, 'LIQUIDA'),
	(29, 'muy mojada '),
	(30, 'super durote'),
	(33, 'segundo uso'),
	(34, 'sucia'),
	(35, 'jkdshfajk'),
	(36, 'jkdshfajk'),
	(37, 'liquido'),
	(38, 'liquido'),
	(39, ''),
	(40, ''),
	(41, ''),
	(42, ''),
	(43, ''),
	(44, ''),
	(45, ''),
	(46, ''),
	(47, ''),
	(48, ''),
	(49, ''),
	(50, ''),
	(51, 'fdsfgs'),
	(52, 'fdsfgs'),
	(53, 'sucia'),
	(54, ''),
	(55, ''),
	(56, ''),
	(57, ''),
	(58, ''),
	(59, ''),
	(60, ''),
	(61, ''),
	(62, ''),
	(63, ''),
	(64, 'popookpklkn'),
	(65, 'popookpklkn'),
	(66, ''),
	(67, ''),
	(68, '');
/*!40000 ALTER TABLE `attributes` ENABLE KEYS */;


-- Volcando estructura para tabla armaganza.branches
CREATE TABLE IF NOT EXISTS `branches` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(140) COLLATE utf8_spanish_ci NOT NULL,
  `adress` varchar(140) COLLATE utf8_spanish_ci DEFAULT NULL,
  `telephone` varchar(15) COLLATE utf8_spanish_ci NOT NULL,
  `city` varchar(140) COLLATE utf8_spanish_ci DEFAULT NULL,
  `zip_code` varchar(10) COLLATE utf8_spanish_ci NOT NULL,
  `rfc` varchar(25) COLLATE utf8_spanish_ci NOT NULL,
  `email` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `rfc` (`rfc`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

-- Volcando datos para la tabla armaganza.branches: ~5 rows (aproximadamente)
/*!40000 ALTER TABLE `branches` DISABLE KEYS */;
INSERT INTO `branches` (`id`, `name`, `adress`, `telephone`, `city`, `zip_code`, `rfc`, `email`) VALUES
	(1, 'asdfghjklñ', '<azsdfghj', 'zsxdfvgb', 'sdfgh', 'sdfgh', 'sdfgh', '<azsdfghj'),
	(2, 'planta 1', 'vallarta', '49385743985', 'guadalajara', '41232', 'fdgrf342', 'vallarta'),
	(3, 'dfghj', 'sdfg', 'sdfgb', 'sdfg', 'sdafbg', 'sdfg', 'sdfg'),
	(4, 'asdfg', 'dxfcgvhb', 'xvcbvnbmn', 'zcxvcbvnbm', 'xvcbvnmbn,', 'xfcgvhbj', 'dxfcgvhb'),
	(5, 'dfgh', 'dhjj', 'edrtyhuj', 'wertyu', 'ertyu', 'sdfghj', 'dhjj');
/*!40000 ALTER TABLE `branches` ENABLE KEYS */;


-- Volcando estructura para tabla armaganza.buys
CREATE TABLE IF NOT EXISTS `buys` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `provider_id` int(11) NOT NULL,
  `branch_id` int(11) NOT NULL,
  `quantity` float DEFAULT NULL,
  `measurement_unit_id` int(11) DEFAULT NULL,
  `total_price` float NOT NULL,
  `created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `providers_idx` (`provider_id`),
  KEY `branch_idx` (`branch_id`),
  KEY `unit_idx` (`measurement_unit_id`),
  CONSTRAINT `buy_unit` FOREIGN KEY (`measurement_unit_id`) REFERENCES `measurement_units` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `buys_branch` FOREIGN KEY (`branch_id`) REFERENCES `branches` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `buys_providers` FOREIGN KEY (`provider_id`) REFERENCES `providers` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

-- Volcando datos para la tabla armaganza.buys: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `buys` DISABLE KEYS */;
/*!40000 ALTER TABLE `buys` ENABLE KEYS */;


-- Volcando estructura para tabla armaganza.customers
CREATE TABLE IF NOT EXISTS `customers` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `identified` varchar(15) COLLATE utf8_spanish_ci DEFAULT NULL,
  `name` varchar(50) COLLATE utf8_spanish_ci NOT NULL,
  `last_name` varchar(80) COLLATE utf8_spanish_ci NOT NULL,
  `email` varchar(80) COLLATE utf8_spanish_ci NOT NULL,
  `telephone` varchar(15) COLLATE utf8_spanish_ci NOT NULL,
  `movil` varchar(15) COLLATE utf8_spanish_ci NOT NULL,
  `rfc` varchar(25) COLLATE utf8_spanish_ci NOT NULL,
  `adress` varchar(140) COLLATE utf8_spanish_ci DEFAULT NULL,
  `city` varchar(140) COLLATE utf8_spanish_ci DEFAULT NULL,
  `zip_code` varchar(10) COLLATE utf8_spanish_ci NOT NULL,
  `sub_customer` varchar(4) COLLATE utf8_spanish_ci DEFAULT NULL,
  `customer_id` int(11) NOT NULL,
  `update_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `customer_id` (`customer_id`),
  UNIQUE KEY `rfc` (`rfc`),
  UNIQUE KEY `email` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

-- Volcando datos para la tabla armaganza.customers: ~7 rows (aproximadamente)
/*!40000 ALTER TABLE `customers` DISABLE KEYS */;
INSERT INTO `customers` (`id`, `identified`, `name`, `last_name`, `email`, `telephone`, `movil`, `rfc`, `adress`, `city`, `zip_code`, `sub_customer`, `customer_id`, `update_at`, `created_at`) VALUES
	(1, NULL, 'dsgfhj', 'adsgfhgj', 'sfzdgnhmfg', 'xcbmn', 'zxvcbvn', 'zvcxbmv', '<zxnc', 'bxzvnc', 'b<xzvnc', '1', 1, '2016-04-08 15:34:45', '2016-04-08 15:34:45'),
	(6, NULL, 'asdfg', 'asdfg', 'wert', 'ert', 'sdfg', 'dfg', 'asdfs', 'sdfg', 'sdfg', 'F', 134, '2016-04-08 15:43:15', '2016-04-08 15:43:15'),
	(7, NULL, 'Rodrigo ', 'Luna Zarate', 'lunarodrigo66@gmail.com', '57995007', '0445510119360', 'dsfsfgfdshjesaerhtr', 'tlacoquemecatl 10', 'mexico edo de mex', '57139', 'x', 1010, '2016-04-12 15:15:40', '2016-04-12 15:15:40'),
	(8, NULL, 'orlando', 'valle', 'erwin@gmail.com', '3456789', '567890', '3erfghbnm', '45rtghjmk,', 'mexico', '23445', 'si', 105, '2016-04-20 11:59:35', '2016-04-20 11:59:35'),
	(9, NULL, 'Pedro', 'Luna Lopez', 'petermoon@live.com.mx', '54+89456+6', '12569985232', 'asdfghjklñ', 'dsfghjklñ', 'dfghjkl', '1259', 'si', 56, '2016-04-25 14:55:31', '2016-04-25 14:55:31'),
	(12, NULL, 'Erwin', 'Valle', 'fghjklñ', '234567890', '34567890', 'fgbhnmj,k', 'dfghjkl', 'fghjklñ', 'cvbnm,.', 'si', 506, '2016-04-25 16:24:34', '2016-04-25 16:24:34'),
	(14, NULL, 'erwin', 'orlando', '123@gmail.com', '6558554', '556248995', 'dfghjklñ', 'dfghjklñ.', 'dfghjk,l.', '2166', 'si', 2, '2016-04-25 18:52:46', '2016-04-25 18:52:46');
/*!40000 ALTER TABLE `customers` ENABLE KEYS */;


-- Volcando estructura para tabla armaganza.detail_orders
CREATE TABLE IF NOT EXISTS `detail_orders` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `order_id` int(11) NOT NULL,
  `form_id` int(11) NOT NULL,
  `deadline` datetime NOT NULL,
  PRIMARY KEY (`id`),
  KEY `order_idx` (`order_id`),
  KEY `form_idx` (`form_id`),
  CONSTRAINT `order` FOREIGN KEY (`order_id`) REFERENCES `orders` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

-- Volcando datos para la tabla armaganza.detail_orders: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `detail_orders` DISABLE KEYS */;
/*!40000 ALTER TABLE `detail_orders` ENABLE KEYS */;


-- Volcando estructura para tabla armaganza.forms
CREATE TABLE IF NOT EXISTS `forms` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(50) NOT NULL,
  `name` varchar(50) NOT NULL,
  `receta` varchar(50) DEFAULT NULL,
  `operacion` varchar(50) DEFAULT NULL,
  `material_id` varchar(50) DEFAULT NULL,
  `valor` varchar(50) DEFAULT NULL,
  `taraje` varchar(50) DEFAULT NULL,
  `tolerancia` varchar(50) DEFAULT NULL,
  `velocidad` varchar(50) DEFAULT NULL,
  `habilitado` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla armaganza.forms: 13 rows
/*!40000 ALTER TABLE `forms` DISABLE KEYS */;
INSERT INTO `forms` (`id`, `code`, `name`, `receta`, `operacion`, `material_id`, `valor`, `taraje`, `tolerancia`, `velocidad`, `habilitado`) VALUES
	(1, '250', 'no', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	(2, '250', 'si', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	(3, '250', 'si', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	(4, '', 'holas', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	(5, 'prueba', 'prueba', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	(6, '5057', 'si', '1056', '569', 'polvo', '24', '25', '1', '6', 'concreto super fragil'),
	(7, '5057', 'si', '1056', '569', 'polvo', '24', '25', '1', '6', 'concreto super fragil'),
	(8, '35435843', 'concreto plastico', '45678', '456', 'pelos de gato', '45', '44', '1', '6', 'si'),
	(9, 'val5', 'valvula 05', '18', '602', 'arena', '25', '26', '1', '4', 'si'),
	(10, '02', 'formula 2', '5', '200', 'agua', '80', '3', '5', '5', 'si'),
	(11, '02', 'formula 2', '5', '201', 'aditivo 1', '65', '45', '5', '5', 'si'),
	(12, '02', 'formula 2', '5', '201', 'adtivo 3', '5', '6', '4', '6', '5'),
	(13, '02', 'formula 2', '5', '507', 'piedra ', '5', '4', '6', '5', 'si');
/*!40000 ALTER TABLE `forms` ENABLE KEYS */;


-- Volcando estructura para tabla armaganza.machines
CREATE TABLE IF NOT EXISTS `machines` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(55) COLLATE utf8_spanish_ci NOT NULL,
  `code` varchar(10) COLLATE utf8_spanish_ci NOT NULL,
  `value` varchar(50) COLLATE utf8_spanish_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

-- Volcando datos para la tabla armaganza.machines: ~15 rows (aproximadamente)
/*!40000 ALTER TABLE `machines` DISABLE KEYS */;
INSERT INTO `machines` (`id`, `name`, `code`, `value`) VALUES
	(1, 'Valvula Agua 2', 'V002', NULL),
	(2, 'Valvula Aditivo 1', 'V003', NULL),
	(3, 'Valvula Aditivo HP', 'V006', NULL),
	(4, 'Valvula Aditivo nueve', 'V009', NULL),
	(7, 'pesar agua', '603', ''),
	(8, '', '', 'prueba'),
	(9, 'valvula 1', 'val 01', 'tipo'),
	(10, 'valvula 10', 'val 10', 'MQ'),
	(11, 'CILO 1', 'CIL 01', 'MQ'),
	(12, 'agua 5', '1020', 'MQ'),
	(13, 'jknjkln', 'jklfndlf', 'MP'),
	(14, '', '', 'MQ'),
	(15, 'fds', 'asdfsd', 'MQ'),
	(16, 'prueba uso', '', 'MQ'),
	(17, 'asdfg', '1230', 'MQ');
/*!40000 ALTER TABLE `machines` ENABLE KEYS */;


-- Volcando estructura para tabla armaganza.materials
CREATE TABLE IF NOT EXISTS `materials` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(55) COLLATE utf8_spanish_ci NOT NULL,
  `code` varchar(10) COLLATE utf8_spanish_ci NOT NULL,
  `value` varchar(50) COLLATE utf8_spanish_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

-- Volcando datos para la tabla armaganza.materials: ~2 rows (aproximadamente)
/*!40000 ALTER TABLE `materials` DISABLE KEYS */;
INSERT INTO `materials` (`id`, `name`, `code`, `value`) VALUES
	(1, 'asdfg', '1230', 'PT'),
	(2, 'asdfg', '1230', 'MP');
/*!40000 ALTER TABLE `materials` ENABLE KEYS */;


-- Volcando estructura para tabla armaganza.operations
CREATE TABLE IF NOT EXISTS `operations` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(10) COLLATE utf8_spanish_ci DEFAULT NULL,
  `name` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=76 DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

-- Volcando datos para la tabla armaganza.operations: ~36 rows (aproximadamente)
/*!40000 ALTER TABLE `operations` DISABLE KEYS */;
INSERT INTO `operations` (`id`, `code`, `name`) VALUES
	(1, '101', 'Apertura de Valvula'),
	(4, '102', 'Cerrar Valvula'),
	(5, '103', 'Arrancar Transportadora'),
	(16, '603', 'pesar agua'),
	(44, '', ''),
	(45, '', ''),
	(46, '', ''),
	(47, '', ''),
	(48, '', ''),
	(49, '', ''),
	(50, '', ''),
	(51, '', ''),
	(52, '', ''),
	(53, '', ''),
	(54, '', ''),
	(55, '', ''),
	(56, '', ''),
	(57, '', ''),
	(58, '', ''),
	(59, '', ''),
	(60, '', ''),
	(61, '', ''),
	(62, '', ''),
	(63, '', ''),
	(64, '', ''),
	(65, '', ''),
	(66, '', ''),
	(67, '', ''),
	(68, '', ''),
	(69, '', ''),
	(70, '', ''),
	(71, '', ''),
	(72, '', ''),
	(73, '', ''),
	(74, '', ''),
	(75, '', '');
/*!40000 ALTER TABLE `operations` ENABLE KEYS */;


-- Volcando estructura para tabla armaganza.orders
CREATE TABLE IF NOT EXISTS `orders` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `branch_id` int(11) NOT NULL,
  `date_issue` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `quantity` float NOT NULL,
  `measurement_unit_id` int(11) NOT NULL,
  `total_price` float NOT NULL,
  PRIMARY KEY (`id`),
  KEY `branch_idx` (`branch_id`),
  KEY `unit_idx` (`measurement_unit_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

-- Volcando datos para la tabla armaganza.orders: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `orders` DISABLE KEYS */;
/*!40000 ALTER TABLE `orders` ENABLE KEYS */;


-- Volcando estructura para tabla armaganza.partitions
CREATE TABLE IF NOT EXISTS `partitions` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `detail_order_id` int(11) NOT NULL,
  `value` varchar(45) COLLATE utf8_spanish_ci NOT NULL,
  PRIMARY KEY (`id`),
  KEY `detail:order_partitions_idx` (`detail_order_id`),
  CONSTRAINT `detail:order_partitions` FOREIGN KEY (`detail_order_id`) REFERENCES `detail_orders` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

-- Volcando datos para la tabla armaganza.partitions: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `partitions` DISABLE KEYS */;
/*!40000 ALTER TABLE `partitions` ENABLE KEYS */;


-- Volcando estructura para tabla armaganza.providers
CREATE TABLE IF NOT EXISTS `providers` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `contact_name` varchar(140) COLLATE utf8_spanish_ci NOT NULL,
  `company` varchar(140) COLLATE utf8_spanish_ci NOT NULL,
  `email` varchar(80) COLLATE utf8_spanish_ci NOT NULL,
  `telephone` varchar(15) COLLATE utf8_spanish_ci NOT NULL,
  `fax` varchar(15) COLLATE utf8_spanish_ci NOT NULL,
  `movil_1` varchar(15) COLLATE utf8_spanish_ci NOT NULL,
  `notes` varchar(250) COLLATE utf8_spanish_ci NOT NULL,
  `active` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `email` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

-- Volcando datos para la tabla armaganza.providers: ~3 rows (aproximadamente)
/*!40000 ALTER TABLE `providers` DISABLE KEYS */;
INSERT INTO `providers` (`id`, `contact_name`, `company`, `email`, `telephone`, `fax`, `movil_1`, `notes`, `active`) VALUES
	(1, 'sad', 'sad', 'asd', 'asd', 'ads', 'sad', 'sad', 1),
	(2, 'sad', 'sda', 'sda', 'sad', 'sad', 'sad', 'sad', 1),
	(3, 'rodrigo', 'siz', 'lunarodrigo.siz@gmail.com', '+4+612+78+', '6876415637', '567489431', 'nota pruba', 1);
/*!40000 ALTER TABLE `providers` ENABLE KEYS */;


-- Volcando estructura para tabla armaganza.receta
CREATE TABLE IF NOT EXISTS `receta` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(50) NOT NULL,
  `name` varchar(50) NOT NULL,
  `arena` varchar(50) DEFAULT NULL,
  `agua` varchar(50) DEFAULT NULL,
  `grava` varchar(50) DEFAULT NULL,
  `cemento` varchar(50) DEFAULT NULL,
  `aditivo` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla armaganza.receta: 6 rows
/*!40000 ALTER TABLE `receta` DISABLE KEYS */;
INSERT INTO `receta` (`id`, `code`, `name`, `arena`, `agua`, `grava`, `cemento`, `aditivo`) VALUES
	(1, '12', 'receta expres', NULL, NULL, NULL, NULL, NULL),
	(2, '12', 'receta expres', NULL, NULL, NULL, NULL, NULL),
	(3, '12', 'receta expres', NULL, NULL, NULL, NULL, NULL),
	(4, '', '', '25', '25', NULL, NULL, NULL),
	(5, '156', 'receta expres', '20', '25', '15', '10', '20'),
	(6, '56', 'concreto ultra plus', '20', '20', '20', '20', '20');
/*!40000 ALTER TABLE `receta` ENABLE KEYS */;


-- Volcando estructura para tabla armaganza.users
CREATE TABLE IF NOT EXISTS `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `num_employee` varchar(45) COLLATE utf8_spanish_ci NOT NULL,
  `name` varchar(50) COLLATE utf8_spanish_ci NOT NULL,
  `last_name` varchar(80) COLLATE utf8_spanish_ci DEFAULT NULL,
  `email` varchar(80) COLLATE utf8_spanish_ci NOT NULL,
  `password` varchar(40) COLLATE utf8_spanish_ci NOT NULL,
  `usuario` varchar(40) COLLATE utf8_spanish_ci NOT NULL,
  `position` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `roll` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `active` varchar(50) COLLATE utf8_spanish_ci DEFAULT NULL,
  `update_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `usuario` (`usuario`),
  UNIQUE KEY `password` (`password`),
  UNIQUE KEY `email` (`email`),
  UNIQUE KEY `num_employee` (`num_employee`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

-- Volcando datos para la tabla armaganza.users: ~2 rows (aproximadamente)
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` (`id`, `num_employee`, `name`, `last_name`, `email`, `password`, `usuario`, `position`, `roll`, `active`, `update_at`, `created_at`) VALUES
	(1, '000', 'armaganza', 'soft', 'ijhshndiud', 'soft', 'armaganza', NULL, NULL, NULL, '2016-03-29 19:05:35', '2016-03-29 19:05:35'),
	(11, '6565', 'Rodrigo', 'Luna ', 'likjlkj', '301092', 'cocolito', 'jkhkh', 'hjhlk', 'jlikjñl', '2016-04-20 19:16:30', '2016-04-20 19:16:30');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
