/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uniriotec.tickets.dao.sistema;

import br.uniriotec.tickets.dao.SuporteDAO;
import br.uniriotec.tickets.model.Sistema;
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
 * @author Pedro
 */
public class SistemaDAO implements ISistemaDAO{
    
    private Sistema carrega(ResultSet rs)throws SQLException {
        Sistema sistema = new Sistema();
        sistema.setId(rs.getInt("id"));
        sistema.setNome(rs.getString("nome"));
        return sistema;
    }
    
    @Override
    public Sistema getSistema(int id) {
        Connection c = SuporteDAO.getConnection();
        if(c == null)
        {
            return null;
        }
        
        Sistema sistema = null;
        try{
            PreparedStatement ps = c.prepareStatement("SELECT * FROM Sistema WHERE id = ?");
            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs.next())
            {
                sistema = carrega(rs);
            }
            c.close();
        }
        catch(SQLException e){
            SuporteDAO.log(e.getMessage());
        }
        
        return sistema;
    }
    
    @Override
    public List<Sistema> listarSistemas() {
        Connection c = SuporteDAO.getConnection();
        if(c == null) {
            return null;
        }
        List<Sistema> sistemas = new ArrayList<Sistema>();
        try {
            PreparedStatement ps = c.prepareStatement("SELECT * FROM Sistema");
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                sistemas.add(carrega(rs));
            }
            c.close();
        }
        catch(SQLException e){
            SuporteDAO.log(e.getMessage());
        }
        
        return sistemas;
    }
    
    @Override
    public boolean insere(Sistema sistema){
        Connection c = SuporteDAO.getConnection();
        if(c == null)
        {
            return false;
        }
        
        try{
            CallableStatement cs = c.prepareCall("{call InsereSistema(?,?)}");
            cs.setString(1, sistema.getNome());
            cs.registerOutParameter(2, Types.INTEGER);
            cs.execute();
            
            int id = cs.getInt(2);
            sistema.setId(id);
            
            c.close();
            return true;
        }
        catch(SQLException e){
            SuporteDAO.log(e.getMessage());
            
            return false;
        }
    }
    
    @Override
    public boolean atualiza(Sistema sistema){
        Connection c = SuporteDAO.getConnection();
        if(c == null)
        {
            return false;
        }
        try {
            CallableStatement cs = c.prepareCall("{call AtualizaSistema(?,?)}");
            cs.setInt(1, sistema.getId());
            cs.setString(2, sistema.getNome());
            cs.execute();
            c.close();
            return true;
        }
        catch(SQLException e){
            SuporteDAO.log(e.getMessage());
            return false;
        }
    }
    
    @Override
    public List<Sistema> lista(int pagina, int tamanho){
        Connection c = SuporteDAO.getConnection();
        
        if(c == null){
            return null;
        }
        
        List<Sistema> lista = new ArrayList<Sistema>();
        
        try{
            PreparedStatement ps = c.prepareStatement("SELECT * FROM Sistema");//ORDER BY nome LIMIT ? OFFSET ?");
            //ps.setInt(1, 1);
            //ps.setInt(2, 25);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                lista.add(carrega(rs));
            }
            c.close();
        }catch(SQLException e){
            SuporteDAO.log(e.getMessage());
        }
     
        return lista;
    }
    
    @Override
    public boolean remove(int id){
        Connection c = SuporteDAO.getConnection();
        
        if(c == null){
            return false;
        }
        
        try{
            CallableStatement cs = c.prepareCall("{call RemoveSistema(?)}");
            cs.setInt(1,id);
            cs.execute();
            c.close();
            return true;
        }catch(SQLException e){
            SuporteDAO.log(e.getMessage());
            return false;
        }
    }
    
}
