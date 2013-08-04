/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uniriotec.tickets.dao.sistema;
import br.uniriotec.tickets.model.Sistema;
import java.util.List;

/**
 *
 * @author Pedro
 */
public interface ISistemaDAO {
    public boolean insere(Sistema sistema);
    public boolean atualiza(Sistema sistema);
    public boolean remove(int id);
    public Sistema getSistema(int id);
    public List<Sistema> listarSistemas();
}
