/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uniriotec.tickets.dao;

import br.uniriotec.tickets.dao.ticket.ITicketDAO;
import br.uniriotec.tickets.dao.ticket.TicketDAO;
import br.uniriotec.tickets.dao.usuario.IUsuarioDAO;
import br.uniriotec.tickets.dao.usuario.UsuarioDAO;

/**
 *
 * @author Daniel Gribel <daniel.gribel@uniriotec.br>
 */
public class FabricaDAO {
    
    private static IUsuarioDAO usuarioDAO;
    private static ITicketDAO ticketDAO;
    
    public static IUsuarioDAO getUsuarioDAO() {
        if (usuarioDAO == null) {
            usuarioDAO = new UsuarioDAO();   
        }
        return usuarioDAO;
    }
    
    public static ITicketDAO getTicketDAO() {
        if (ticketDAO == null) {
            ticketDAO = new TicketDAO();   
        }
        return ticketDAO;
    }
    
    public static void setUsuarioDAO(IUsuarioDAO usuarioDAO) {
        FabricaDAO.usuarioDAO = usuarioDAO;
    }
    
    public static void setTicketDAO(ITicketDAO ticketDAO) {
        FabricaDAO.ticketDAO = ticketDAO;
    }
    
}
