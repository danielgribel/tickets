package br.uniriotec.tickets.action;

import br.uniriotec.tickets.dao.FabricaDAO;
import br.uniriotec.tickets.model.Usuario;
import static com.opensymphony.xwork2.Action.INPUT;
import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionSupport;
import java.util.Map;
import org.apache.struts2.interceptor.SessionAware;

/**
 *
 * @author Daniel Gribel <daniel.gribel@uniriotec.br>
 */
public class SenhaUsuarioAction extends ActionSupport implements SessionAware {
    
    private Map<String, Object> session;
    private String email;
    private String senhaAtual;
    private String novaSenha;
    private String confirmaSenha;

    public SenhaUsuarioAction() {
    
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenhaAtual() {
        return senhaAtual;
    }

    public void setSenhaAtual(String senhaAtual) {
        this.senhaAtual = senhaAtual;
    }

    public String getNovaSenha() {
        return novaSenha;
    }

    public void setNovaSenha(String novaSenha) {
        this.novaSenha = novaSenha;
    }

    public String getConfirmaSenha() {
        return confirmaSenha;
    }

    public void setConfirmaSenha(String confirmaSenha) {
        this.confirmaSenha = confirmaSenha;
    }
    
    @Override
    public String execute() {
        Usuario usuario = FabricaDAO.getUsuarioDAO().getUsuario(email);
        if(usuario != null) {
            if(senhaAtual.length() == 0) {
                addFieldError("senhaAtual", getText("erro.senha.obrigatorio"));
            }
            else if(!senhaAtual.equals(usuario.getSenha())) {
                addFieldError("senhaAtual", getText("erro.senha.incorreta"));
            }
            if(novaSenha.length() == 0) {
                addFieldError("novaSenha", getText("erro.senha.obrigatorio"));
            }
            else if(!novaSenha.equals(confirmaSenha)) {
                addFieldError("novaSenha", getText("erro.senha.diferente"));
            }
            if(confirmaSenha.length() == 0) {
                addFieldError("confirmaSenha", getText("erro.senha.obrigatorio"));
            }
            if(hasErrors()) {
                return INPUT;
            }
            usuario.setSenha(novaSenha);
            FabricaDAO.getUsuarioDAO().atualiza(usuario);
            session.put("usuario", usuario);
            return SUCCESS;
        }
        else {
            return INPUT;
        }
    }

    @Override
    public void setSession(Map<String, Object> session) {
        this.session = session;
    }
}
