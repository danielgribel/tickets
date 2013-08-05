package br.uniriotec.tickets.action;

import br.uniriotec.tickets.dao.FabricaDAO;
import br.uniriotec.tickets.model.Componente;
import br.uniriotec.tickets.model.Usuario;
import br.uniriotec.tickets.model.Usuario.Perfil;
import static com.opensymphony.xwork2.Action.INPUT;
import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionSupport;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.apache.struts2.interceptor.RequestAware;

/**
 *
 * @author Daniel Gribel <daniel.gribel@uniriotec.br>
 */
public class PerfilAction extends ActionSupport implements RequestAware {

    private Map<String, Object> request;
    private String email;
    private String nome;
    private String sobrenome;
    private String perfil;
    
    private List<String> listaPerfis;
    
    public PerfilAction() {
        listaPerfis = new ArrayList<String>();
        for(Perfil p : Perfil.values()) {
            listaPerfis.add(p.toString());
        }
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPerfil() {
        return perfil;
    }

    public void setPerfil(String perfil) {
        this.perfil = perfil;
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
    
    public List<String> getListaPerfis() {
        return listaPerfis;
    }

    public void setListaPerfis(List<String> listaPerfis) {
        this.listaPerfis = listaPerfis;
    }
    
    @Override
    public void setRequest(Map<String, Object> request) {
        this.request = request;
    }
    
    public String salvarPerfil() {
        Usuario usuario = FabricaDAO.getUsuarioDAO().getUsuario(email);
        if(usuario != null) {
            usuario.setPerfil(Perfil.valueOf(perfil));
            FabricaDAO.getUsuarioDAO().atualiza(usuario);
            return SUCCESS;
        }
        else {
            return INPUT;   
        }
    }
    
    public String alterarPerfil() {
        request.put("usuario", FabricaDAO.getUsuarioDAO().getUsuario(email));
        return INPUT;
    }
    
}
