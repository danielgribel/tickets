package br.uniriotec.tickets.action;

import br.uniriotec.tickets.dao.FabricaDAO;
import br.uniriotec.tickets.model.Usuario;
import static com.opensymphony.xwork2.Action.ERROR;
import static com.opensymphony.xwork2.Action.INPUT;
import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionSupport;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import org.apache.struts2.interceptor.SessionAware;

/**
 *
 * @author Daniel Gribel <daniel.gribel@uniriotec.br>
 */
public class LoginAction extends ActionSupport implements SessionAware {
    
    private Map<String, Object> session;
    private String email;
    private String senha;
//    private String nome;
//    
    public LoginAction() {
        
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

//    public String getNome() {
//        return nome;
//    }
//
//    public void setNome(String nome) {
//        this.nome = nome;
//    }
//    
//    public String login() {
//        Usuario usuario = FabricaDAO.getUsuarioDAO().getUsuario(email);
//        
//        if(email == null || senha == null) {
//            addActionError(getText("erro.login"));
//        }
//        if(usuario == null) {
//            addActionError(getText("erro.login"));
//        }
//        if(usuario != null) {
//            if(!senha.equals(usuario.getSenha())) {
//                addActionError(getText("erro.login"));
//            }
//        }
//        if(hasErrors()) {
//            return ERROR;
//        }
//        return SUCCESS;
//    }
    
    public boolean isLoginValido(Usuario u) {
        Usuario usuario = FabricaDAO.getUsuarioDAO().getUsuario(u.getEmail());
        if(usuario == null) {
            return false;
        }
        else if(u.getSenha().equals(usuario.getSenha())) {
            u.setNome(usuario.getNome());
            u.setSobrenome(usuario.getSobrenome());
            u.setPerfil(usuario.getPerfil());
            return true;
        }
        return false;
    }
    
    @Override
    public String execute() {
        clearFieldErrors();
        Usuario usuario = (Usuario)session.get("usuario");
        if(usuario != null) {
            return SUCCESS;
        }
        else {
            Usuario u = new Usuario();
            u.setEmail(email);
            u.setSenha(senha);
            if(isLoginValido(u)) {
                session.put("usuario", u);
                Timestamp ts = new Timestamp(System.currentTimeMillis());
                String s = new SimpleDateFormat("dd/MM/yyyy kk:mm").format(ts);
                session.put("ultimoLogin", s);
                return SUCCESS;
            }
            else {
                addActionError(getText("erro.login"));
            }
            return INPUT;
        }
    }
    
    @Override
    public void setSession(Map<String, Object> session) {
        this.session = session;
    }
    
}
