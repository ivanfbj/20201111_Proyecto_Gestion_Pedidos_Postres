create database db_apppostres;

CREATE USER 'AppPostres'@'localhost' IDENTIFIED BY 'Postres2021*';
GRANT ALL PRIVILEGES ON db_apppostres.* TO 'AppPostres'@'localhost';
FLUSH PRIVILEGES;

CREATE TABLE `tbclientes` (
  `nIdCliente` bigint NOT NULL AUTO_INCREMENT,
  `sNombreCliente` varchar(100) NOT NULL,
  `sDireccion` varchar(100) NOT NULL,
  `nTelefono` bigint NOT NULL,
  `sSexo` varchar(15) NOT NULL,
  `nEdad` int NOT NULL,
  `dFechaCreacion` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`nIdCliente`),
  UNIQUE KEY `sNombreClienteXnTelefono` (`sNombreCliente`,`nTelefono`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `tbpostres` (
  `nIdPostre` int NOT NULL AUTO_INCREMENT,
  `sNombrePostre` varchar(100) NOT NULL,
  `nCantidadDeCalorias` double NOT NULL,
  `sFechaVencimiento` varchar(20) NOT NULL,
  `nPrecio` double NOT NULL,
  `bEsRefrigerado` tinyint(1) NOT NULL DEFAULT '0',
  `nTemperaturaMantenimiento` double DEFAULT NULL,
  `nTiempoMaximoSinRefrigeracionHoras` double DEFAULT NULL,
  `bEsHojaldrado` tinyint(1) DEFAULT NULL,
  `dFechaCreacion` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`nIdPostre`),
  KEY `sNombrePostre` (`sNombrePostre`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `tbpedidos` (
  `nIdPedido` bigint NOT NULL AUTO_INCREMENT,
  `sCodigoPedido` varchar(45) NOT NULL,
  `dFechaPedido` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `sFechaEntregaPedido` varchar(20) NOT NULL,
  `nIdCliente` bigint NOT NULL,
  `sLugarDeEntrega` varchar(15) NOT NULL,
  `nValorTotal` int NOT NULL,
  PRIMARY KEY (`nIdPedido`),
  KEY `sCodigoPedido` (`sCodigoPedido`) /*!80000 INVISIBLE */,
  CONSTRAINT `FK_cliente` FOREIGN KEY (`nIdPedido`) REFERENCES `tbclientes` (`nIdCliente`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


