-- MySQL Script generated by MySQL Workbench
-- jue 08 nov 2018 18:32:21 CST
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema ttb020
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema ttb020
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `ttb020` DEFAULT CHARACTER SET utf8 ;
USE `ttb020` ;

-- -----------------------------------------------------
-- Table `ttb020`.`cat02_perfil`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ttb020`.`cat02_perfil` (
  `id_perfil` INT NOT NULL AUTO_INCREMENT,
  `nb_perfil` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id_perfil`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `ttb020`.`cat01_users`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ttb020`.`cat01_users` (
  `id_user` INT NOT NULL AUTO_INCREMENT,
  `tx_login` VARCHAR(45) NOT NULL,
  `tx_password` VARCHAR(45) NOT NULL,
  `id_perfil` INT NOT NULL,
  PRIMARY KEY (`id_user`),
  INDEX `fk_cat01_users_cat02_perfil_idx` (`id_perfil` ASC),
  CONSTRAINT `fk_cat01_users_cat02_perfil`
    FOREIGN KEY (`id_perfil`)
    REFERENCES `ttb020`.`cat02_perfil` (`id_perfil`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `ttb020`.`ge03_profesor`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ttb020`.`ge03_profesor` (
  `id_profesor` INT NOT NULL AUTO_INCREMENT,
  `nb_profesor` VARCHAR(45) NOT NULL,
  `primer_apellido` VARCHAR(45) NOT NULL,
  `segundo_apellido` VARCHAR(45) NOT NULL,
  `id_user` INT NOT NULL,
  PRIMARY KEY (`id_profesor`),
  INDEX `fk_ge03_profesor_cat01_users1_idx` (`id_user` ASC),
  CONSTRAINT `fk_ge03_profesor_cat01_users1`
    FOREIGN KEY (`id_user`)
    REFERENCES `ttb020`.`cat01_users` (`id_user`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `ttb020`.`ge04_alumno`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ttb020`.`ge04_alumno` (
  `id_alumno` INT NOT NULL AUTO_INCREMENT,
  `nb_alumno` VARCHAR(45) NOT NULL,
  `primer_apellido` VARCHAR(45) NOT NULL,
  `segundo_apellido` VARCHAR(45) NOT NULL,
  `id_user` INT NOT NULL,
  PRIMARY KEY (`id_alumno`),
  INDEX `fk_ge04_alumno_cat01_users1_idx` (`id_user` ASC),
  CONSTRAINT `fk_ge04_alumno_cat01_users1`
    FOREIGN KEY (`id_user`)
    REFERENCES `ttb020`.`cat01_users` (`id_user`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `ttb020`.`ge05_grupo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ttb020`.`ge05_grupo` (
  `id_grupo` INT NOT NULL AUTO_INCREMENT,
  `nb_grupo` VARCHAR(45) NOT NULL,
  `id_profesor` INT NOT NULL,
  PRIMARY KEY (`id_grupo`),
  INDEX `fk_ge05_grupo_ge03_profesor1_idx` (`id_profesor` ASC),
  CONSTRAINT `fk_ge05_grupo_ge03_profesor1`
    FOREIGN KEY (`id_profesor`)
    REFERENCES `ttb020`.`ge03_profesor` (`id_profesor`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `ttb020`.`ge06_alumno_grupo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ttb020`.`ge06_alumno_grupo` (
  `id_grupo` INT NOT NULL,
  `id_alumno` INT NOT NULL,
  PRIMARY KEY (`id_grupo`, `id_alumno`),
  INDEX `fk_ge05_grupo_has_ge04_alumno_ge04_alumno1_idx` (`id_alumno` ASC),
  INDEX `fk_ge05_grupo_has_ge04_alumno_ge05_grupo1_idx` (`id_grupo` ASC),
  CONSTRAINT `fk_ge05_grupo_has_ge04_alumno_ge05_grupo1`
    FOREIGN KEY (`id_grupo`)
    REFERENCES `ttb020`.`ge05_grupo` (`id_grupo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_ge05_grupo_has_ge04_alumno_ge04_alumno1`
    FOREIGN KEY (`id_alumno`)
    REFERENCES `ttb020`.`ge04_alumno` (`id_alumno`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `ttb020`.`ge07_proyecto`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ttb020`.`ge07_proyecto` (
  `id_proyecto` INT NOT NULL AUTO_INCREMENT,
  `nb_proyecto` VARCHAR(45) NOT NULL,
  `id_grupo` INT NOT NULL,
  PRIMARY KEY (`id_proyecto`),
  INDEX `fk_ge07_proyecto_ge05_grupo1_idx` (`id_grupo` ASC),
  CONSTRAINT `fk_ge07_proyecto_ge05_grupo1`
    FOREIGN KEY (`id_grupo`)
    REFERENCES `ttb020`.`ge05_grupo` (`id_grupo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `ttb020`.`ge08_alumno_proyecto`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ttb020`.`ge08_alumno_proyecto` (
  `id_alumno` INT NOT NULL,
  `id_proyecto` INT NOT NULL,
  PRIMARY KEY (`id_alumno`, `id_proyecto`),
  INDEX `fk_ge04_alumno_has_ge07_proyecto_ge07_proyecto1_idx` (`id_proyecto` ASC),
  INDEX `fk_ge04_alumno_has_ge07_proyecto_ge04_alumno1_idx` (`id_alumno` ASC),
  CONSTRAINT `fk_ge04_alumno_has_ge07_proyecto_ge04_alumno1`
    FOREIGN KEY (`id_alumno`)
    REFERENCES `ttb020`.`ge04_alumno` (`id_alumno`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_ge04_alumno_has_ge07_proyecto_ge07_proyecto1`
    FOREIGN KEY (`id_proyecto`)
    REFERENCES `ttb020`.`ge07_proyecto` (`id_proyecto`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `ttb020`.`ge10_tipo_diagrama`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ttb020`.`ge10_tipo_diagrama` (
  `id_tipo_diagrama` INT NOT NULL AUTO_INCREMENT,
  `nb_tipo` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id_tipo_diagrama`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `ttb020`.`ge09_diagrama`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ttb020`.`ge09_diagrama` (
  `id_diagrama` INT NOT NULL AUTO_INCREMENT,
  `nb_diagrama` VARCHAR(45) NOT NULL,
  `id_proyecto` INT NOT NULL,
  `id_tipo_diagrama` INT NOT NULL,
  `estado` INT NOT NULL,
  `data` TEXT NULL,
  PRIMARY KEY (`id_diagrama`),
  INDEX `fk_ge09_diagrama_ge07_proyecto1_idx` (`id_proyecto` ASC),
  INDEX `fk_ge09_diagrama_ge10_tipo_diagrama1_idx` (`id_tipo_diagrama` ASC),
  CONSTRAINT `fk_ge09_diagrama_ge07_proyecto1`
    FOREIGN KEY (`id_proyecto`)
    REFERENCES `ttb020`.`ge07_proyecto` (`id_proyecto`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_ge09_diagrama_ge10_tipo_diagrama1`
    FOREIGN KEY (`id_tipo_diagrama`)
    REFERENCES `ttb020`.`ge10_tipo_diagrama` (`id_tipo_diagrama`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `ttb020`.`ge11_comentario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ttb020`.`ge11_comentario` (
  `id_comentario` INT NOT NULL AUTO_INCREMENT,
  `comentario` VARCHAR(500) NOT NULL,
  `id_diagrama` INT NOT NULL,
  PRIMARY KEY (`id_comentario`),
  INDEX `fk_ge11_comentario_ge09_diagrama1_idx` (`id_diagrama` ASC),
  CONSTRAINT `fk_ge11_comentario_ge09_diagrama1`
    FOREIGN KEY (`id_diagrama`)
    REFERENCES `ttb020`.`ge09_diagrama` (`id_diagrama`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `ttb020`.`ge12_version`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ttb020`.`ge12_version` (
  `id_version` INT NOT NULL AUTO_INCREMENT,
  `data` TEXT NULL,
  `nb_version` DATETIME NOT NULL,
  `id_diagrama` INT NOT NULL,
  `st_version` TINYINT(1) NOT NULL,
  `id_alumno` INT NOT NULL,
  PRIMARY KEY (`id_version`),
  INDEX `fk_ge12_version_ge09_diagrama1_idx` (`id_diagrama` ASC),
  INDEX `fk_ge12_version_ge04_alumno1_idx` (`id_alumno` ASC),
  CONSTRAINT `fk_ge12_version_ge09_diagrama1`
    FOREIGN KEY (`id_diagrama`)
    REFERENCES `ttb020`.`ge09_diagrama` (`id_diagrama`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_ge12_version_ge04_alumno1`
    FOREIGN KEY (`id_alumno`)
    REFERENCES `ttb020`.`ge04_alumno` (`id_alumno`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `ttb020`.`cat02_perfil`
-- -----------------------------------------------------
START TRANSACTION;
USE `ttb020`;
INSERT INTO `ttb020`.`cat02_perfil` (`id_perfil`, `nb_perfil`) VALUES (DEFAULT, 'Profesor');
INSERT INTO `ttb020`.`cat02_perfil` (`id_perfil`, `nb_perfil`) VALUES (DEFAULT, 'Alumno');

COMMIT;


-- -----------------------------------------------------
-- Data for table `ttb020`.`ge10_tipo_diagrama`
-- -----------------------------------------------------
START TRANSACTION;
USE `ttb020`;
INSERT INTO `ttb020`.`ge10_tipo_diagrama` (`id_tipo_diagrama`, `nb_tipo`) VALUES (DEFAULT, 'cu');
INSERT INTO `ttb020`.`ge10_tipo_diagrama` (`id_tipo_diagrama`, `nb_tipo`) VALUES (DEFAULT, 'clases');

COMMIT;

use ttb020;

####drop database ttb020;

select * from cat01_users;
select * from ge03_profesor;
select * from ge04_alumno;
select * from ge05_grupo;
select * from ge06_alumno_grupo;
select * from ge09_diagrama;
