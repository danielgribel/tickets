DROP PROCEDURE IF EXISTS InsereTicket;
DELIMITER //
CREATE PROCEDURE InsereTicket(vTitulo VARCHAR(255), vSistema INT, vComponente INT, vDescricao VARCHAR(255), vStatus VARCHAR(20), vOperador VARCHAR(80), OUT id_ticket INT)
BEGIN
	INSERT INTO Ticket(titulo, sistema, componente, descricao, status, operador)
	VALUES (vTitulo, vSistema, vComponente, vDescricao, vStatus, vOperador);
        SET id_ticket = LAST_INSERT_ID();
END //
DELIMITER ;

DROP PROCEDURE IF EXISTS AtualizaTicket;
DELIMITER //
CREATE PROCEDURE AtualizaTicket(vIdTicket INT, vTitulo VARCHAR(255), vSistema INT, vComponente INT, vDescricao VARCHAR(255), vStatus VARCHAR(20), vOperador VARCHAR(80))
BEGIN
	UPDATE Ticket
	SET titulo = vTitulo,
	sistema = vSistema,
	componente = vComponente,
        descricao = vDescricao,
        status = vStatus,
        operador = vOperador
	WHERE id_ticket = vIdTicket;
END //
DELIMITER ;

DROP PROCEDURE IF EXISTS RemoveTicket;
DELIMITER //
CREATE PROCEDURE RemoveTicket(vIdTicket INT)
BEGIN
	DELETE 
	FROM Ticket
	WHERE id_ticket = vIdTicket;
END //
DELIMITER ;