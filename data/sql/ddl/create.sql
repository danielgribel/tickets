DROP DATABASE IF EXISTS tickets;
CREATE DATABASE tickets;
USE tickets;
CREATE TABLE Usuario
(
    email VARCHAR(80) NOT NULL,
    nome VARCHAR(80) NOT NULL,
    sobrenome VARCHAR(80) NOT NULL,
    senha VARCHAR(20) NOT NULL,
    perfil VARCHAR(20) NOT NULL,
    PRIMARY KEY(email)
);
CREATE TABLE Ticket
(
    id_ticket INT NOT NULL AUTO_INCREMENT,
    titulo VARCHAR(255) NOT NULL,
    sistema INT NOT NULL,
    componente INT NOT NULL,
    descricao VARCHAR(255),
    status VARCHAR(20) NOT NULL,
    operador VARCHAR(80) NOT NULL,
    PRIMARY KEY(id_ticket)
);