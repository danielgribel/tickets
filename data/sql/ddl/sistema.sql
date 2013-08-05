DROP PROCEDURE IF EXISTS InsereSistema;
DELIMITER //
CREATE PROCEDURE InsereSistema(vNome VARCHAR(80),OUT id INT)
BEGIN
        INSERT INTO Sistema (nome)
        VALUES (vNome);
        SET id = LAST_INSERT_ID();
END //
DELIMITER ;

DROP PROCEDURE IF EXISTS AtualizaSistema;
DELIMITER //
CREATE PROCEDURE AtualizaSistema(vId INT,vNome VARCHAR(80))
BEGIN
        UPDATE Sistema
        SET nome = vNome
        WHERE id = vId;
END //
DELIMITER ;

DROP PROCEDURE IF EXISTS RemoveSistema;
DELIMITER //
CREATE PROCEDURE RemoveSistema(vId INT)
BEGIN
        DELETE
        FROM Sistema
        WHERE id = vId;
END //
DELIMITER ;