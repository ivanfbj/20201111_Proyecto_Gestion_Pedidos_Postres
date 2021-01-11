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
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `tbpostres` (
  `nIdPostre` bigint NOT NULL AUTO_INCREMENT,
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
  UNIQUE KEY `sNombrePostre_UNIQUE` (`sNombrePostre`),
  KEY `sNombrePostre` (`sNombrePostre`)
) ENGINE=InnoDB AUTO_INCREMENT=49 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

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
  KEY `FK_nIdCliente_idx` (`nIdCliente`),
  CONSTRAINT `FK_nIdCliente` FOREIGN KEY (`nIdCliente`) REFERENCES `tbclientes` (`nIdCliente`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `tbpostresxpedido` (
  `nIdPostresXPedido` bigint NOT NULL AUTO_INCREMENT,
  `nIdPedido` bigint NOT NULL,
  `nIdPostre` bigint NOT NULL,
  PRIMARY KEY (`nIdPostresXPedido`),
  KEY `FK_nIdPedido_idx` (`nIdPedido`) /*!80000 INVISIBLE */,
  KEY `FK_nIdPostre` (`nIdPostre`),
  CONSTRAINT `FK_nIdPedido` FOREIGN KEY (`nIdPedido`) REFERENCES `tbpedidos` (`nIdPedido`),
  CONSTRAINT `FK_nIdPostre` FOREIGN KEY (`nIdPostre`) REFERENCES `tbpostres` (`nIdPostre`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
