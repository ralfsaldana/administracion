/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  rsaldana
 * Created: 17/07/2017
 */

CREATE DATABASE `administracion` /*!40100 DEFAULT CHARACTER SET utf8 */;

CREATE TABLE `administracion`.`propietario` (
  `idPropietario` INT NOT NULL AUTO_INCREMENT,
  `nombres` VARCHAR(45) NULL,
  `apellidoPaterno` VARCHAR(45) NULL,
  `apellidoMaterno` VARCHAR(45) NULL,
  `correo` VARCHAR(45) NULL,
  `telefono` VARCHAR(45) NULL,
  `usuario` VARCHAR(45) NULL,
  `password` VARCHAR(45) NULL,
  PRIMARY KEY (`idPropietario`));

CREATE TABLE `administracion`.`propiedad` (
  `idPropiedad` INT NOT NULL AUTO_INCREMENT,
  `descripcion` VARCHAR(45) NULL,
  `area` VARCHAR(45) NULL,
  PRIMARY KEY (`idPropiedad`));


CREATE TABLE `administracion`.`propietario_propiedad` (
  `idPropietario` INT NOT NULL,
  `irPropiedad` INT NOT NULL,
  PRIMARY KEY (`idPropietario`, `irPropiedad`));


CREATE TABLE `administracion`.`ingresos` (
  `idIngreso` int(11) NOT NULL AUTO_INCREMENT,
  `idTipoIngreso` int(11) DEFAULT NULL,
  `monto` decimal(20,2) DEFAULT NULL,
  `fechaPago` datetime DEFAULT NULL,
  `voucher` longblob,
  `nroOperacion` varchar(45) DEFAULT NULL,
  `nroCuenta` varchar(100) DEFAULT NULL,
  `idPropietario` int(11) DEFAULT NULL,
  `mes` int(2) DEFAULT NULL,
  `anio` int(4) DEFAULT NULL,
  `nombreArchivoVoucher` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`idIngreso`)) ;

