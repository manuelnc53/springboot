CREATE DATABASE  IF NOT EXISTS `springboot`;
USE `springboot`;


DROP TABLE IF EXISTS `usuarios`;
CREATE TABLE `usuarios` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `apellido` varchar(255) DEFAULT NULL,
  `dni` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `estado` enum('ACTIVO','INACTIVO') DEFAULT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  `sexo` varchar(255) DEFAULT NULL,
  `telefono` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

DROP TABLE IF EXISTS `billeteras`;
CREATE TABLE `billeteras` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `estado` enum('ACTIVO','INACTIVO') DEFAULT NULL,
  `id_usuario` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKbm2ije7xmv6lmb5f4r92oaiyq` (`id_usuario`),
  CONSTRAINT `FKbm2ije7xmv6lmb5f4r92oaiyq` FOREIGN KEY (`id_usuario`) REFERENCES `usuarios` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;




DROP TABLE IF EXISTS `divisas`;
CREATE TABLE `divisas` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `estado` enum('ACTIVO','INACTIVO') DEFAULT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  `valor` float DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;



DROP TABLE IF EXISTS `billeteradivisa`;
CREATE TABLE `billeteradivisa` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `id_billetera` bigint DEFAULT NULL,
  `id_divisa` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK2xhkpwtwhl7epfq11ct821sl7` (`id_billetera`),
  KEY `FKcu29ginrh626woi3493q4b208` (`id_divisa`),
  CONSTRAINT `FK2xhkpwtwhl7epfq11ct821sl7` FOREIGN KEY (`id_billetera`) REFERENCES `billeteras` (`id`),
  CONSTRAINT `FKcu29ginrh626woi3493q4b208` FOREIGN KEY (`id_divisa`) REFERENCES `divisas` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=41 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;




DROP TABLE IF EXISTS `operaciones`;
CREATE TABLE `operaciones` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `cantidad_destino` int DEFAULT NULL,
  `cantidad_origen` int DEFAULT NULL,
  `fecha` datetime(6) DEFAULT NULL,
  `tipo` enum('INTERCAMBIO','DEPOSITO') DEFAULT NULL,
  `id_billetera_destino` bigint DEFAULT NULL,
  `id_billetera_origen` bigint DEFAULT NULL,
  `id_divisa_destino` bigint DEFAULT NULL,
  `id_divisa_origen` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKo4h1daj138042ale7h7l51gc8` (`id_billetera_destino`),
  KEY `FKt33jxp359mo1q2mtraup9wmam` (`id_billetera_origen`),
  KEY `FK8264ju7cntkdfi7ufgw32thq7` (`id_divisa_destino`),
  KEY `FKhxlhs83177xtq6mvvvqhgqivs` (`id_divisa_origen`),
  CONSTRAINT `FK8264ju7cntkdfi7ufgw32thq7` FOREIGN KEY (`id_divisa_destino`) REFERENCES `divisas` (`id`),
  CONSTRAINT `FKhxlhs83177xtq6mvvvqhgqivs` FOREIGN KEY (`id_divisa_origen`) REFERENCES `divisas` (`id`),
  CONSTRAINT `FKo4h1daj138042ale7h7l51gc8` FOREIGN KEY (`id_billetera_destino`) REFERENCES `billeteras` (`id`),
  CONSTRAINT `FKt33jxp359mo1q2mtraup9wmam` FOREIGN KEY (`id_billetera_origen`) REFERENCES `billeteras` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;










