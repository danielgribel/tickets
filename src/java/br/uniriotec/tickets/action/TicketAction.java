package br.uniriotec.tickets.action;

import br.uniriotec.tickets.dao.FabricaDAO;
import br.uniriotec.tickets.model.Componente;
import br.uniriotec.tickets.model.Sistema;
import br.uniriotec.tickets.model.Ticket;
import br.uniriotec.tickets.model.Ticket.Status;
import br.uniriotec.tickets.model.Usuario;
import br.uniriotec.tickets.model.Usuario.Perfil;
import static com.opensymphony.xwork2.Action.INPUT;
import static com.opensymphony.xwork2.Action.NONE;
import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionSupport;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;

/**
 *
 * @author Daniel Gribel <daniel.gribel@uniriotec.br>
 */
public class TicketAction extends ActionSupport implements RequestAware, SessionAware {

    private Map<String, Object> request;
    private Map<String, Object> session;
    private int idTicket;
    private String titulo;
    private int sistema;
    private int componente;
    private String descricao;
    private String operador;
    private String status;
    
    private List<Sistema> listaSistemas;
    private List<Componente> listaComponentes;
    private List<Usuario> listaOperadores;
    private List<String> listaStatus;
    
    public TicketAction() {
        this.idTicket = -1;

        listaSistemas = new ArrayList<Sistema>();
        listaSistemas = FabricaDAO.getSistemaDAO().listarSistemas();

        listaComponentes = new ArrayList<Componente>();
        listaComponentes = FabricaDAO.getComponenteDAO().listarComponentes();
        
        listaOperadores = new ArrayList<Usuario>();
        listaOperadores = FabricaDAO.getUsuarioDAO().listarUsuariosPorPerfil(Usuario.Perfil.OPERADOR);
        
        listaStatus = new ArrayList<String>();
        for(Status s : Status.values()) {
            listaStatus.add(s.toString());
        }
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

    public int getSistema() {
        return sistema;
    }

    public void setSistema(int sistema) {
        this.sistema = sistema;
    }

    public int getComponente() {
        return componente;
    }

    public void setComponente(int componente) {
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    public String salvarTicket() {
        Ticket ticket = new Ticket();
        ticket.setIdTicket(idTicket);
        ticket.setTitulo(titulo);
        ticket.setSistema(sistema);
        ticket.setComponente(componente);
        ticket.setDescricao(descricao);
        ticket.setOperador(operador);
        ticket.setStatus(Ticket.Status.ABERTO);
        request.put("ticket", ticket);

        Componente componenteSelecionado = FabricaDAO.getComponenteDAO().getComponente(componente);
        
        if(titulo.length() == 0) {
            addFieldError("titulo", getText("erro.titulo.obrigatorio"));
        }
        if(sistema <= 0) {
            addFieldError("sistema", getText("erro.sistema.obrigatorio"));
        }
        if(componente <= 0) {
            addFieldError("componente", getText("erro.componente.obrigatorio"));
        }
        else if(componenteSelecionado.getSistema() != sistema) {
            addFieldError("componente", getText("erro.componente.sistemaIncorreto"));
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
    
    public String salvarStatus() {
        Ticket ticket = new Ticket();
        ticket.setIdTicket(idTicket);
        ticket.setTitulo(titulo);
        ticket.setSistema(sistema);
        ticket.setComponente(componente);
        ticket.setDescricao(descricao);
        ticket.setOperador(operador);
        ticket.setStatus(Status.valueOf(status));
        request.put("ticket", ticket);
        
        FabricaDAO.getTicketDAO().atualiza(ticket);
        
        return SUCCESS;
    }
    
    @Override
    public void setRequest(Map<String, Object> requisicao) {
        this.request = requisicao;
    }
    
    public List<Sistema> getListaSistemas() {
        return listaSistemas;
    }

    public void setListaSistemas(List<Sistema> listaSistemas) {
        this.listaSistemas = listaSistemas;
    }

    public List<Componente> getListaComponentes() {
        return listaComponentes;
    }

    public void setListaComponentes(List<Componente> listaComponentes) {
        this.listaComponentes = listaComponentes;
    }

    public List<Usuario> getListaOperadores() {
        return listaOperadores;
    }

    public void setListaOperadores(List<Usuario> listaOperadores) {
        this.listaOperadores = listaOperadores;
    }

    public List<String> getListaStatus() {
        return listaStatus;
    }

    public void setListaStatus(List<String> listaStatus) {
        this.listaStatus = listaStatus;
    }
    
    
//    public String getDefaultOperador() {
//        String emailOperador = ((Ticket)request.get("ticket")).getOperador();
//        return emailOperador;
//    }
    
    public String display() {
        return NONE;
    }

    @Override
    public String execute() throws Exception {
        return SUCCESS;
    }
    
    public String listarTickets() {
        Usuario usuario = (Usuario)session.get("usuario");
        if(usuario.getPerfil() == Perfil.FINAL) {
            request.put("tickets", FabricaDAO.getTicketDAO().listarTickets());    
        }
        else if(usuario.getPerfil() == Perfil.OPERADOR) {
            request.put("tickets", FabricaDAO.getTicketDAO().listarTicketsDoUsuario(usuario.getEmail()));
        }
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

    @Override
    public void setSession(Map<String, Object> session) {
        this.session = session;
    }
    
}