DROP PROCEDURE IF EXISTS InsereComponente;
DELIMITER //
CREATE PROCEDURE InsereComponente(vNome VARCHAR(80), vSistema INT, vOperador VARCHAR(80), OUT id_componente INT)
BEGIN
        INSERT INTO Componente(nome, sistema, operador)
        VALUES (vNome, vSistema, vOperador);
        SET id_componente = LAST_INSERT_ID();
END //
DELIMITER ;

DROP PROCEDURE IF EXISTS AtualizaComponente;
DELIMITER //
CREATE PROCEDURE AtualizaComponente(vIdComponente INT, vNome VARCHAR(80), vSistema INT, vOperador VARCHAR(80))
BEGIN
        UPDATE Componente
        SET nome = vNome,
        sistema = vSistema,
        operador = vOperador
        WHERE id_componente = vIdComponente;
END //
DELIMITER ;

DROP PROCEDURE IF EXISTS RemoveComponente;
DELIMITER //
CREATE PROCEDURE RemoveComponente(vIdComponente INT)
BEGIN
        DELETE
        FROM Componente
        WHERE id_componente = vIdComponente;
END //
DELIMITER ;