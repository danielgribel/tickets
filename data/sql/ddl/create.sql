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

