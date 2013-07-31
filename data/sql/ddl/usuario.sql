DROP PROCEDURE IF EXISTS InsereUsuario;
DELIMITER //
CREATE PROCEDURE InsereUsuario(vEmail VARCHAR(80), vNome VARCHAR(80), vSobrenome VARCHAR(80), vSenha VARCHAR(20), vPerfil VARCHAR(20))
BEGIN
	INSERT INTO Usuario (email, nome, sobrenome, senha, perfil)
	VALUES (vEmail, vNome, vSobrenome, vSenha, vPerfil);
END //
DELIMITER ;
DROP PROCEDURE IF EXISTS AtualizaUsuario;
DELIMITER //
CREATE PROCEDURE AtualizaUsuario(vEmail VARCHAR(80), vNome VARCHAR(80), vSobrenome VARCHAR(80), vSenha VARCHAR(20), vPerfil VARCHAR(20))
BEGIN
	UPDATE Usuario
	SET email = vEmail,
	nome = vNome,
	sobrenome = vSobrenome,
        senha = vSenha,
        perfil = vPerfil
	WHERE email = vEmail;
END //
DELIMITER ;

DROP PROCEDURE IF EXISTS RemoveUsuario;
DELIMITER //
CREATE PROCEDURE RemoveUsuario(vEmail VARCHAR(80))
BEGIN
	DELETE 
	FROM Usuario
	WHERE email = vEmail;
END //
DELIMITER ;