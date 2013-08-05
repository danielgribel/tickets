package br.uniriotec.tickets.dao.usuario;

import br.uniriotec.tickets.dao.SuporteDAO;
import br.uniriotec.tickets.model.Usuario;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Daniel Gribel <daniel.gribel@uniriotec.br>
 */
public class UsuarioDAO implements IUsuarioDAO {
    
    private Usuario carrega(ResultSet rs) throws SQLException {
        Usuario usuario = new Usuario();
        usuario.setEmail(rs.getString("email")); 
        usuario.setNome(rs.getString("nome"));
        usuario.setSobrenome(rs.getString("sobrenome"));
        usuario.setSenha(rs.getString("senha"));
        usuario.setPerfil(Usuario.Perfil.valueOf(rs.getString("perfil")));
        return usuario;
    }
    
    @Override
    public Usuario getUsuario(String email) {
        Connection c = SuporteDAO.getConnection();
        if(c == null) {
            return null;
        }
        Usuario usuario = null;
        try {
            PreparedStatement ps = c.prepareStatement("SELECT * FROM Usuario WHERE email = ?");
            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                usuario = carrega(rs);
            }
            c.close();
        } catch(SQLException e) {
            SuporteDAO.log(e.getMessage());
        }
        return usuario;
    }
    
    @Override
    public List<Usuario> listarUsuariosPorPerfil(Usuario.Perfil perfil) {
        Connection c = SuporteDAO.getConnection();
        if(c == null) {
            return null;
        }
        List<Usuario> emails = new ArrayList<Usuario>();
        try {
            PreparedStatement ps = c.prepareStatement("SELECT * FROM Usuario WHERE perfil = ?");
            ps.setString(1, perfil.toString());
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                emails.add(carrega(rs));
            }
            c.close();
        } catch(SQLException e) {
            SuporteDAO.log(e.getMessage());
        }
        return emails;
    }
    
    @Override
    public boolean insere(Usuario usuario) {
        Connection c = SuporteDAO.getConnection();
        if(c == null) {
            return false;
        }
        try {
            CallableStatement cs = c.prepareCall("{call InsereUsuario(?, ?, ?, ?, ?)}");
            cs.setString(1, usuario.getEmail());
            cs.setString(2, usuario.getNome());
            cs.setString(3, usuario.getSobrenome());
            cs.setString(4, usuario.getSenha());
            cs.setString(5, usuario.getPerfil().toString());
            cs.execute();
            c.close();
            return true;
        } catch(SQLException e) {
            SuporteDAO.log(e.getMessage());
            return false;
        }
    }
    
    @Override
    public boolean atualiza(Usuario usuario) {
        Connection c = SuporteDAO.getConnection();
        if (c == null) {
            return false;
        }
        try {
            CallableStatement cs = c.prepareCall("{call AtualizaUsuario(?, ?, ?, ?, ?)}");
            cs.setString(1, usuario.getEmail());
            cs.setString(2, usuario.getNome());
            cs.setString(3, usuario.getSobrenome());
            cs.setString(4, usuario.getSenha());
            cs.setString(5, usuario.getPerfil().toString());
            cs.execute();
            c.close();
            return true;
        } catch(SQLException e) {
            SuporteDAO.log(e.getMessage());
            return false;
        }
    }
    
    @Override
    public boolean remove(String email) {
        return false;
    }
    
}
