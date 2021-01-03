create database db_apppostres;

CREATE USER 'AppPostres'@'localhost' IDENTIFIED BY 'Postres2021*';
GRANT ALL PRIVILEGES ON db_apppostres.* TO 'AppPostres'@'localhost';
FLUSH PRIVILEGES;

CREATE TABLE `tbcliente` (
  `nId` bigint NOT NULL AUTO_INCREMENT,
  `sNombreCliente` varchar(100) NOT NULL,
  `sDireccion` varchar(100) NOT NULL,
  `nTelefono` bigint NOT NULL,
  `sSexo` varchar(15) NOT NULL,
  `nEdad` int NOT NULL,
  PRIMARY KEY (`nId`),
  UNIQUE KEY `sNombreClienteXnTelefono` (`sNombreCliente`,`nTelefono`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci