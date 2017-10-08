-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema logisticadb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema logisticadb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `logisticadb` DEFAULT CHARACTER SET utf8 ;
USE `logisticadb` ;

-- -----------------------------------------------------
-- Table `logisticadb`.`entrega`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `logisticadb`.`entrega` (
  `id` BIGINT(20) UNSIGNED NOT NULL AUTO_INCREMENT,
  `numeroPedido` BIGINT(20) UNSIGNED NOT NULL,
  `idCliente` BIGINT(20) UNSIGNED NOT NULL,
  `nomeRecebedor` VARCHAR(50) NULL DEFAULT NULL,
  `cpfRecebedor` VARCHAR(14) NULL DEFAULT NULL,
  `dataRecebimento` DATETIME NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC),
  UNIQUE INDEX `numeroPedido_UNIQUE` (`numeroPedido` ASC))
ENGINE = InnoDB
AUTO_INCREMENT = 3
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `logisticadb`.`usuario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `logisticadb`.`usuario` (
  `id` BIGINT(20) UNSIGNED NOT NULL AUTO_INCREMENT,
  `usuario` VARCHAR(50) NOT NULL,
  `senha` VARCHAR(12) NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC))
ENGINE = InnoDB
AUTO_INCREMENT = 3
DEFAULT CHARACTER SET = utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
