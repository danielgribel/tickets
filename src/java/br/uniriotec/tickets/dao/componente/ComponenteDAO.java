package br.uniriotec.tickets.dao.componente;

import br.uniriotec.tickets.dao.SuporteDAO;
import br.uniriotec.tickets.model.Componente;
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
public class ComponenteDAO implements IComponenteDAO {

    private Componente carrega(ResultSet rs) throws SQLException {
        Componente componente = new Componente();
        componente.setIdComponente(rs.getInt("id_componente"));
        componente.setNome(rs.getString("nome"));
        componente.setSistema(rs.getInt("sistema"));
        componente.setOperador(rs.getString("operador"));
        return componente;
    }
    
    @Override
    public boolean insere(Componente componente) {
        Connection c = SuporteDAO.getConnection();
        if(c == null) {
            return false;
        }
        try {
            CallableStatement cs = c.prepareCall("{call InsereComponente(?, ?, ?, ?)}");
            cs.setString(1, componente.getNome());
            cs.setInt(2, componente.getSistema());
            cs.setString(3, componente.getOperador());
            cs.registerOutParameter(4, Types.INTEGER);
            cs.execute();
            
            int id = cs.getInt(4);
            componente.setIdComponente(id);
                        
            c.close();
            return true;
        } catch(SQLException e) {
            SuporteDAO.log(e.getMessage());
            return false;
        }
    }

    @Override
    public boolean atualiza(Componente componente) {
        Connection c = SuporteDAO.getConnection();
        if (c == null) {
            return false;
        }
        try {
            CallableStatement cs = c.prepareCall("{call AtualizaComponente(?, ?, ?, ?)}");
            cs.setInt(1, componente.getIdComponente());
            cs.setString(2, componente.getNome());
            cs.setInt(3, componente.getSistema());
            cs.setString(4, componente.getOperador());
            cs.execute();
            c.close();
            return true;
        } catch(SQLException e) {
            SuporteDAO.log(e.getMessage());
            return false;
        }
    }

    @Override
    public boolean remove(int idComponente) {
        return false;
    }

    @Override
    public Componente getComponente(int idComponente) {
        Connection c = SuporteDAO.getConnection();
        if(c == null) {
            return null;
        }
        Componente componente = null;
        try {
            PreparedStatement ps = c.prepareStatement("SELECT * FROM Componente WHERE id_componente= ?");
            ps.setInt(1, idComponente);
            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                componente = carrega(rs);
            }
            c.close();
        } catch(SQLException e) {
            SuporteDAO.log(e.getMessage());
        }
        return componente;
    }
    
    @Override
    public List<Componente> listarComponentes() {
        Connection c = SuporteDAO.getConnection();
        if(c == null) {
            return null;
        }
        List<Componente> componentes = new ArrayList<Componente>();
        try {
            PreparedStatement ps = c.prepareStatement("SELECT * FROM Componente");
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                componentes.add(carrega(rs));
            }
            c.close();
        }
        catch(SQLException e){
            SuporteDAO.log(e.getMessage());
        }
        
        return componentes;
    }
    
}
