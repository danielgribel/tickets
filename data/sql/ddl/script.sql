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
DROP PROCEDURE IF EXISTS InsereUsuario;
DELIMITER //
CREATE PROCEDURE InsereUsuario(vEmail VARCHAR(80), vNome VARCHAR(80), vSobrenome VARCHAR(80), vSenha VARCHAR(20), vPerfil VARCHAR(20))
BEGIN
	INSERT INTO Usuario (email, nome, sobrenome, senha, perfil)
	VALUES (vEmail, vNome, vSobrenome, vSenha, vPerfil);
END //
DELIMITER ;
