package br.uniriotec.tickets.action;

import br.uniriotec.tickets.dao.FabricaDAO;
import br.uniriotec.tickets.model.Ticket;
import br.uniriotec.tickets.model.Usuario;
import static com.opensymphony.xwork2.Action.INPUT;
import static com.opensymphony.xwork2.Action.NONE;
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
public class TicketAction extends ActionSupport implements RequestAware {

    private Map<String, Object> request;
    private int idTicket;
    private String titulo;
    private String sistema;
    private String componente;
    private String descricao;
    private String operador;
    
    private List<String> listaSistemas;
    private List<String> listaComponentes;
    private List<String> listaOperadores;
    
    public TicketAction() {
        
        this.idTicket = -1;
        
        listaSistemas = new ArrayList<String>();
        listaSistemas.add("Google Docs");
        listaSistemas.add("Word");
        listaSistemas.add("Libre Office");
        
        listaComponentes = new ArrayList<String>();
        listaComponentes.add("Front-end");
        listaComponentes.add("Back-end");
        listaComponentes.add("Projeto");
        listaComponentes.add("Analise");
        
        listaOperadores = new ArrayList<String>();
        listaOperadores = FabricaDAO.getUsuarioDAO().listarEmailsPorPerfil(Usuario.Perfil.OPERADOR);
    }

    public int getIdTicket() {
        return idTicket;
    }

    public void setIdTicket(int idTicket) {
        this.idTicket = idTicket;
    }
    
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getSistema() {
        return sistema;
    }

    public void setSistema(String sistema) {
        this.sistema = sistema;
    }

    public String getComponente() {
        return componente;
    }

    public void setComponente(String componente) {
        this.componente = componente;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getOperador() {
        return operador;
    }

    public void setOperador(String operador) {
        this.operador = operador;
    }
    
    public String salvarTicket() {
        Ticket ticket = new Ticket();
        ticket.setIdTicket(idTicket);
        ticket.setTitulo(titulo);
        ticket.setSistema(1);
        ticket.setComponente(1);
        ticket.setDescricao(descricao);
        ticket.setOperador(operador);
        ticket.setStatus(Ticket.Status.NOVO);
        request.put("ticket", ticket);

        if(titulo.length() == 0) {
            addFieldError("titulo", getText("erro.titulo.obrigatorio"));
        }
        if(sistema.equals("-1")) {
            addFieldError("sistema", getText("erro.sistema.obrigatorio"));
        }
        if(componente.equals("-1")) {
            addFieldError("componente", getText("erro.componente.obrigatorio"));
        }
        if(operador.equals("-1")) {
            addFieldError("operador", getText("erro.operador.obrigatorio"));
        }
        if(hasErrors()) {
            return INPUT;
        }
        if(ticket.getIdTicket() <= 0) {
            FabricaDAO.getTicketDAO().insere(ticket);
        }
        else {
            FabricaDAO.getTicketDAO().atualiza(ticket);
        }
        return SUCCESS;
    }    
    
    @Override
    public void setRequest(Map<String, Object> requisicao) {
        this.request = requisicao;
    }
    
    public List<String> getListaSistemas() {
        return listaSistemas;
    }

    public void setListaSistemas(List<String> listaSistemas) {
        this.listaSistemas = listaSistemas;
    }

    public List<String> getListaComponentes() {
        return listaComponentes;
    }

    public void setListaComponentes(List<String> listaComponentes) {
        this.listaComponentes = listaComponentes;
    }

    public List<String> getListaOperadores() {
        return listaOperadores;
    }

    public void setListaOperadores(List<String> listaOperadores) {
        this.listaOperadores = listaOperadores;
    }
    
//    public String getDefaultSistema() {
//        return "";
//    }
//    
//    public String getDefaultComponente() {
//        return "";
//    }
//    
//    public String getDefaultOperador() {
//        return "";
//    }
    
    public String display() {
        return NONE;
    }

    @Override
    public String execute() throws Exception {
        return SUCCESS;
    }
    
    public String listarTickets() {
        request.put("tickets", FabricaDAO.getTicketDAO().listarTickets());
        return SUCCESS;
    }
    
    public String criarTicket() {
        request.put("ticket", new Ticket());
        return INPUT;
    }
    
    public String editarTicket() {
        request.put("ticket", FabricaDAO.getTicketDAO().getTicket(idTicket));
        return INPUT;
    }
    
}