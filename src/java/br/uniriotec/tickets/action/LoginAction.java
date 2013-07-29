/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uniriotec.tickets.action;

import br.uniriotec.tickets.dao.FabricaDAO;
import br.uniriotec.tickets.model.Usuario;
import static com.opensymphony.xwork2.Action.ERROR;
import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionSupport;
import java.util.Map;
import org.apache.struts2.interceptor.RequestAware;

/**
 *
 * @author Daniel Gribel <daniel.gribel@uniriotec.br>
 */
public class LoginAction extends ActionSupport implements RequestAware {
    
    private Map<String, Object> request;
    private String email;
    private String senha;
    private String nome;
    
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

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public String login() {
        Usuario usuario = FabricaDAO.getUsuarioDAO().getUsuario(email);
        
        if(email == null || senha == null) {
            addActionError(getText("erro.login"));
        }
        if(usuario == null) {
            addActionError(getText("erro.login"));
        }
        if(usuario != null) {
            if(!senha.equals(usuario.getSenha())) {
                addActionError(getText("erro.login"));
            }
        }
        if(hasErrors()) {
            return ERROR;
        }
        return SUCCESS;
    }

    @Override
    public void setRequest(Map<String, Object> requisicao) {
        this.request = requisicao;
    }
    
}
