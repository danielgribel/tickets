package br.uniriotec.tickets.dao.ticket;

import br.uniriotec.tickets.model.Ticket;
import java.util.List;


/**
 *
 * @author Daniel Gribel <daniel.gribel@uniriotec.br>
 */
public interface ITicketDAO {
    public boolean insere(Ticket ticket);
    public boolean atualiza(Ticket ticket);
    public boolean remove(int idTicket);
    public Ticket getTicket(int idTicket);
    public List<Ticket> listarTickets();
}
