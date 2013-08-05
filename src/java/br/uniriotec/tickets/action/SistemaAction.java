package br.uniriotec.tickets.action;

import br.uniriotec.tickets.dao.FabricaDAO;
import br.uniriotec.tickets.model.Sistema;
import static com.opensymphony.xwork2.Action.INPUT;
import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionSupport;
import java.util.Map;
import org.apache.struts2.interceptor.RequestAware;
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author Pedro
 */
public class SistemaAction extends ActionSupport implements RequestAware{
    
    public static final int PAGE_SIZE = 25;
    
    private Map<String,Object> request;
    private String nome;
    private int id;
    private int currentPage;
    
    public SistemaAction(){
        this.id = -1;
        this.currentPage = 0;
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
        sistema.setId(id);
        sistema.setNome(nome);
        request.put("sistema", sistema);
        
        if(nome.length() == 0)
        {
            addFieldError("nome",getText("erro.nome.sistema.obrigatorio"));
        }
        
        if(hasErrors()) {
            return INPUT;
        }
        
        ArrayList<Sistema> l = (ArrayList) FabricaDAO.getSistemaDAO().lista(1, 1);
        Sistema s = new Sistema();
        String aux1,aux2;
        
        if(sistema.getId() <= 0){
            for(Iterator i = l.iterator(); i.hasNext(); )
            {
                s = (Sistema) i.next();
                aux1 = s.getNome();
                aux2 = sistema.getNome();
                
                if(aux1.toLowerCase().trim().equals(aux2.toLowerCase().trim()))
                {
                    addFieldError("nome",getText("erro.nomes.iguais"));
                    return INPUT;
                }
            }
            FabricaDAO.getSistemaDAO().insere(sistema);
        }
        else{
            FabricaDAO.getSistemaDAO().atualiza(sistema);
        }
        return SUCCESS;
    }
    
    public String criarSistema(){
        request.put("sistema", new Sistema());
        return INPUT;
    }
    
    public String editar(){
        request.put("sistema", FabricaDAO.getSistemaDAO().getSistema(id));
        return INPUT;
    }
    
    public String listarSistema(){
        request.put("sistemas", FabricaDAO.getSistemaDAO().lista(currentPage,PAGE_SIZE));
        return SUCCESS;
    }
    
    public String delete(){
        FabricaDAO.getSistemaDAO().remove(id);
        return SUCCESS;
    }
    
    @Override
    public void setRequest(Map<String, Object> requisicao){
        this.request = requisicao;
    }
}
