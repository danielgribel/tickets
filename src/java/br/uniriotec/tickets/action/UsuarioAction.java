package br.uniriotec.tickets.action;

import br.uniriotec.tickets.dao.FabricaDAO;
import br.uniriotec.tickets.model.Usuario;
import static com.opensymphony.xwork2.Action.INPUT;
import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionSupport;
import java.util.Map;
import org.apache.struts2.interceptor.RequestAware;

public class UsuarioAction extends ActionSupport implements RequestAware {

    private Map<String, Object> request;
    private String email;
    private String nome;
    private String sobrenome;
    private String senha;
    private String confirmaSenha;
    private Usuario.Perfil perfil;
    
    public UsuarioAction() {
        
    }
    
    public void setEmail(String email) {
        this.email = email;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public void setConfirmaSenha(String confirmaSenha) {
        this.confirmaSenha = confirmaSenha;
    }

    public void setPerfil(Usuario.Perfil perfil) {
        this.perfil = perfil;
    }
    
    public String salvarUsuario() {
        Usuario usuario = new Usuario(nome, sobrenome, email, senha);
        request.put("usuario", usuario);
        
        if(email.length() == 0) {
            addFieldError("email", getText("erro.email.obrigatorio"));   
        }
        if(nome.length() == 0) {
            addFieldError("nome", getText("erro.nome.obrigatorio"));
        }
        if(sobrenome.length() == 0) {
            addFieldError("sobrenome", getText("erro.sobrenome.obrigatorio"));
        }
        if(senha.length() == 0) {
            addFieldError("senha", getText("erro.senha.obrigatorio"));
        }
        else if(!senha.equals(confirmaSenha)) {
            addFieldError("senha", getText("erro.senha.diferente"));
        }
        if(hasErrors()) {
            return INPUT;
        }
        FabricaDAO.getUsuarioDAO().insere(usuario);
        return SUCCESS;
    }    
    
    @Override
    public void setRequest(Map<String, Object> requisicao) {
        this.request = requisicao;
    }
    
}