package br.uniriotec.tickets.action;

import br.uniriotec.tickets.dao.FabricaDAO;
import br.uniriotec.tickets.model.Componente;
import br.uniriotec.tickets.model.Sistema;
import br.uniriotec.tickets.model.Ticket;
import static com.opensymphony.xwork2.Action.INPUT;
import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionSupport;
import java.util.Map;
import org.apache.struts2.interceptor.RequestAware;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author Pedro
 */
public class SistemaAction extends ActionSupport implements RequestAware {
    
    public static final int PAGE_SIZE = 25;
    
    private Map<String,Object> request;
    private String nome;
    private int id;
    private int currentPage;
    
    public SistemaAction() {
        this.id = -1;
        this.currentPage = 0;
    }
    
    public void setNome(String nome) {
        this.nome = nome;        
    }
    
    public String getNome() {
        return nome;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public int getId() {
        return id;
    }
    
    public String salvarSistema() {
        Sistema sistema = new Sistema();
        sistema.setId(id);
        sistema.setNome(nome);
        request.put("sistema", sistema);
        
        if(nome.length() == 0) {
            addFieldError("nome",getText("erro.nome.sistema.obrigatorio"));
        }
        
        if(hasErrors()) {
            return INPUT;
        }
        
        List<Sistema> l = FabricaDAO.getSistemaDAO().listarSistemas();
        Sistema s = new Sistema();
        String aux1,aux2;
        
        if(sistema.getId() <= 0) {
            for(Iterator i = l.iterator(); i.hasNext(); ) {
                s = (Sistema) i.next();
                aux1 = s.getNome();
                aux2 = sistema.getNome();
                
                if(aux1.toLowerCase().trim().equals(aux2.toLowerCase().trim())) {
                    addFieldError("nome",getText("erro.nomes.iguais"));
                    return INPUT;
                }
            }
            FabricaDAO.getSistemaDAO().insere(sistema);
        }
        else {
            FabricaDAO.getSistemaDAO().atualiza(sistema);
        }
        return SUCCESS;
    }
    
    public String criarSistema() {
        request.put("sistema", new Sistema());
        return INPUT;
    }
    
    public String editar() {
        request.put("sistema", FabricaDAO.getSistemaDAO().getSistema(id));
        return INPUT;
    }
    
    public String listarSistemas() {
        request.put("sistemas", FabricaDAO.getSistemaDAO().listarSistemas());
        return SUCCESS;
    }
    
    public String removerSistema() {
        FabricaDAO.getSistemaDAO().remove(id);    
        return SUCCESS;
//        List<Ticket> tickets = FabricaDAO.getTicketDAO().listarTickets();
//        List<Componente> componentes = FabricaDAO.getComponenteDAO().listarComponentes();
//        if(!estaAssociado(tickets, componentes)) {
//            FabricaDAO.getSistemaDAO().remove(id);    
//            return SUCCESS;
//        }
//        else {
//            addActionError("Sistema esta associado a tickets ou componentes");
//            return INPUT;    
//        }
        
    }
    
    @Override
    public void setRequest(Map<String, Object> requisicao) {
        this.request = requisicao;
    }
    
    private boolean estaAssociado(List<Ticket>tickets, List<Componente>componentes) {
        for(Ticket t : tickets) {
            if(t.getSistema()==id) {
                return true;
            }
        }
        for(Componente c : componentes) {
            if(c.getSistema()==id) {
                return true;
            }
        }
        return false;
    }
}
