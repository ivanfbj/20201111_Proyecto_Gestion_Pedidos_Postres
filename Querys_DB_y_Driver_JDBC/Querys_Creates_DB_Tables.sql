create database db_apppostres;

CREATE USER 'AppPostres'@'localhost' IDENTIFIED BY 'Postres2021*';
GRANT ALL PRIVILEGES ON db_apppostres.* TO 'AppPostres'@'localhost';
FLUSH PRIVILEGES;

CREATE TABLE `tbcliente` (
    `nId` BIGINT NOT NULL AUTO_INCREMENT,
    `sNombreCliente` VARCHAR(100) NOT NULL,
    `sDireccion` VARCHAR(100) NOT NULL,
    `nTelefono` BIGINT NOT NULL,
    `sSexo` VARCHAR(15) NOT NULL,
    `nEdad` INT NOT NULL,
    PRIMARY KEY (`nId`)
)  ENGINE=INNODB AUTO_INCREMENT=13 DEFAULT CHARSET=UTF8MB4 COLLATE = UTF8MB4_0900_AI_CI