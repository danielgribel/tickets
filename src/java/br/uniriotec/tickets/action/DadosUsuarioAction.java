/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
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
public class DadosUsuarioAction extends ActionSupport implements SessionAware {
    
    private Map<String, Object> session;
    private String email;
    private String nome;
    private String sobrenome;

    public DadosUsuarioAction() {
    
    }
    
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }
    
    @Override
    public String execute() {
        Usuario usuario = FabricaDAO.getUsuarioDAO().getUsuario(email);
        if(usuario != null) {
            if(nome.length() == 0) {
                addFieldError("nome", getText("erro.nome.obrigatorio"));
            }
            if(sobrenome.length() == 0) {
                addFieldError("sobrenome", getText("erro.sobrenome.obrigatorio"));
            }
            if(hasErrors()) {
                return INPUT;
            }
            usuario.setNome(nome);
            usuario.setSobrenome(sobrenome);
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
