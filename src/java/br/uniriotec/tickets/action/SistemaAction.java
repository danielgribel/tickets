package br.uniriotec.tickets.action;

import br.uniriotec.tickets.dao.FabricaDAO;
import br.uniriotec.tickets.model.Sistema;
import static com.opensymphony.xwork2.Action.INPUT;
import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionSupport;
import java.util.Map;
import org.apache.struts2.interceptor.RequestAware;

/**
 *
 * @author Pedro
 */
public class SistemaAction extends ActionSupport implements RequestAware{
    
    private Map<String,Object> request;
    private String nome;
    private int id;
    
    public SistemaAction(){
        this.id = -1;
    }
    
    public void setNome(String nome){
        this.nome = nome;        
    }
    
    public String getNome(){
        return nome;
    }
    
    public void setId(int id){
        this.id = id;
    }
    
    public int getId(){
        return id;
    }
    
    public String salvarSistema(){
        Sistema sistema = new Sistema();
        sistema.setNome(nome);
        sistema.setId(id);
        request.put("sistema", sistema);
        
        if(nome.length() == 0)
        {
            addFieldError("nome",getText("erro.nome.sistema.obrigatorio"));
        }
        
        if(hasErrors()) {
            return INPUT;
        }
        
        FabricaDAO.getSistemaDAO().insere(sistema);
        return SUCCESS;
    }
    
    @Override
    public void setRequest(Map<String, Object> requisicao){
        this.request = requisicao;
    }
}
