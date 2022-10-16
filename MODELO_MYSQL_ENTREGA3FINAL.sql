CREATE DATABASE  `agencia` ;
USE `agencia`;
CREATE TABLE `cliente` (
  `id_cliente` int NOT NULL,
  `nome_cliente` varchar(30) NOT NULL,
  `cpf_cliente` int NOT NULL,
  `email_cliente` varchar(30) NOT NULL,
  `senha_cliente` varchar(7) NOT NULL,
  PRIMARY KEY (`id_cliente`)
) ;

CREATE TABLE `compra` (
  `id_compra` int NOT NULL,
  `id_cliente` int NOT NULL,
  `id_pacote` int NOT NULL,
  `data_compra` date NOT NULL,
  PRIMARY KEY (`id_compra`),
  KEY `id_pacote_idx` (`id_pacote`),
  KEY `id_cliente_idx` (`id_cliente`),
  CONSTRAINT `id_cliente` FOREIGN KEY (`id_cliente`) REFERENCES `cliente` (`id_cliente`),
  CONSTRAINT `id_pacote` FOREIGN KEY (`id_pacote`) REFERENCES `pacote` (`id_pacote`)
) ;

CREATE TABLE `pacote` (
  `nome_pacote` varchar(30) NOT NULL,
  `valor_pacote` decimal(10,0) NOT NULL,
  `id_pacote` int NOT NULL,
  PRIMARY KEY (`id_pacote`)
) ;
