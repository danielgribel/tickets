/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uniriotec.tickets.dao.usuario;

import br.uniriotec.tickets.model.Usuario;

/**
 *
 * @author Daniel Gribel <daniel.gribel@uniriotec.br>
 */
public interface IUsuarioDAO {
    public Usuario getUsuario(String email);
    public boolean insere(Usuario usuario);
    public boolean atualiza(Usuario usuario);
    public boolean remove(String email);
}
