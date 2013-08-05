package br.uniriotec.tickets.dao.ticket;

import br.uniriotec.tickets.dao.SuporteDAO;
import br.uniriotec.tickets.model.Ticket;
import br.uniriotec.tickets.model.Ticket.Status;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Daniel Gribel <daniel.gribel@uniriotec.br>
 */
public class TicketDAO implements ITicketDAO {

    private Ticket carrega(ResultSet rs) throws SQLException {
        Ticket ticket = new Ticket();
        ticket.setIdTicket(rs.getInt("id_ticket"));
        ticket.setTitulo(rs.getString("titulo"));
        //Sistema sistema = FabricaDAO.getSistemaDAO().getSistema(rs.getInt("sistema"));
        ticket.setSistema(rs.getInt("sistema"));
        ticket.setComponente(rs.getInt("componente"));
        ticket.setDescricao(rs.getString("descricao"));
        //Usuario operador = FabricaDAO.getUsuarioDAO().getUsuario(rs.getString("operador"));
        ticket.setOperador(rs.getString("operador"));
        ticket.setStatus(Status.valueOf(rs.getString("status")));
        return ticket;
    }
    
    @Override
    public Ticket getTicket(int idTicket) {
        Connection c = SuporteDAO.getConnection();
        if(c == null) {
            return null;
        }
        Ticket ticket = null;
        try {
            PreparedStatement ps = c.prepareStatement("SELECT * FROM Ticket WHERE id_ticket = ?");
            ps.setInt(1, idTicket);
            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                ticket = carrega(rs);
            }
            c.close();
        } catch(SQLException e) {
            SuporteDAO.log(e.getMessage());
        }
        return ticket;
    }

    @Override
    public boolean insere(Ticket ticket) {
        Connection c = SuporteDAO.getConnection();
        if(c == null) {
            return false;
        }
        try {
            CallableStatement cs = c.prepareCall("{call InsereTicket(?, ?, ?, ?, ?, ?, ?)}");
            cs.setString(1, ticket.getTitulo());
            cs.setInt(2, ticket.getSistema());
            cs.setInt(3, ticket.getComponente());
            cs.setString(4, ticket.getDescricao());
            cs.setString(5, ticket.getStatus().toString());
            cs.setString(6, ticket.getOperador());
            cs.registerOutParameter(7, Types.INTEGER);
            cs.execute();
            
            int id = cs.getInt(7);
            ticket.setIdTicket(id);
                        
            c.close();
            return true;
        } catch(SQLException e) {
            SuporteDAO.log(e.getMessage());
            return false;
        }
    }

    @Override
    public boolean atualiza(Ticket ticket) {
        Connection c = SuporteDAO.getConnection();
        if (c == null) {
            return false;
        }
        try {
            CallableStatement cs = c.prepareCall("{call AtualizaTicket(?, ?, ?, ?, ?, ?, ?)}");
            cs.setInt(1, ticket.getIdTicket());
            cs.setString(2, ticket.getTitulo());
            cs.setInt(3, ticket.getSistema());
            cs.setInt(4, ticket.getComponente());
            cs.setString(5, ticket.getDescricao());
            cs.setString(6, ticket.getStatus().toString());
            cs.setString(7, ticket.getOperador());
            cs.execute();
            c.close();
            return true;
        } catch(SQLException e) {
            SuporteDAO.log(e.getMessage());
            return false;
        }
    }
    
    @Override
    public List<Ticket> listarTickets() {
        Connection c = SuporteDAO.getConnection();
        if(c == null) {
            return null;
        }
        List<Ticket> tickets = new ArrayList<Ticket>();
        try {
            PreparedStatement ps = c.prepareStatement("SELECT * FROM Ticket");
            //ps.setString(1, perfil.toString());
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                tickets.add(carrega(rs));
            }
            c.close();
        } catch(SQLException e) {
            SuporteDAO.log(e.getMessage());
        }
        return tickets;
    }

    @Override
    public List<Ticket> listarTicketsDoUsuario(String email) {
        Connection c = SuporteDAO.getConnection();
        if(c == null) {
            return null;
        }
        List<Ticket> tickets = new ArrayList<Ticket>();
        try {
            PreparedStatement ps = c.prepareStatement("SELECT * FROM Ticket WHERE operador = ?");
            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                tickets.add(carrega(rs));
            }
            c.close();
        } catch(SQLException e) {
            SuporteDAO.log(e.getMessage());
        }
        return tickets;
    }
    
    @Override
    public boolean remove(int idTicket) {
        return false;
    }
    
}
