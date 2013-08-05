/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uniriotec.tickets.dao.componente;

import br.uniriotec.tickets.model.Componente;
import java.util.List;

/**
 *
 * @author Daniel Gribel <daniel.gribel@uniriotec.br>
 */
public interface IComponenteDAO {
    public boolean insere(Componente componente);
    public boolean atualiza(Componente componente);
    public boolean remove(int idComponente);
    public Componente getComponente(int idComponente);
    public List<Componente> listarComponentes();
}
