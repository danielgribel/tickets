package br.uniriotec.tickets.action;

import br.uniriotec.tickets.dao.FabricaDAO;
import br.uniriotec.tickets.model.Componente;
import br.uniriotec.tickets.model.Sistema;
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
public class ComponenteAction extends ActionSupport implements RequestAware {
    
    private Map<String, Object> request;
    private int idComponente;
    private String nome;
    private int sistema;
    private String operador;
    
    private List<Sistema> listaSistemas;
    private List<Usuario> listaOperadores;

    @Override
    public void setRequest(Map<String, Object> request) {
        this.request = request;
    }

    public ComponenteAction() {
        this.idComponente = -1;
        listaSistemas = new ArrayList<Sistema>();
        listaSistemas = FabricaDAO.getSistemaDAO().listarSistemas();
        listaOperadores = new ArrayList<Usuario>();
        listaOperadores = FabricaDAO.getUsuarioDAO().listarUsuariosPorPerfil(Usuario.Perfil.OPERADOR);
    }

    public int getIdComponente() {
        return idComponente;
    }

    public void setIdComponente(int idComponente) {
        this.idComponente = idComponente;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getSistema() {
        return sistema;
    }

    public void setSistema(int sistema) {
        this.sistema = sistema;
    }

    public String getOperador() {
        return operador;
    }

    public void setOperador(String operador) {
        this.operador = operador;
    }

    public List<Sistema> getListaSistemas() {
        return listaSistemas;
    }

    public void setListaSistemas(List<Sistema> listaSistemas) {
        this.listaSistemas = listaSistemas;
    }

    public List<Usuario> getListaOperadores() {
        return listaOperadores;
    }

    public void setListaOperadores(List<Usuario> listaOperadores) {
        this.listaOperadores = listaOperadores;
    }
    
    public String salvarComponente() {
        Componente componente = new Componente();
        componente.setIdComponente(idComponente);
        componente.setNome(nome);
        componente.setSistema(sistema);
        componente.setOperador(operador);
        request.put("componente", componente);

        if(nome.length() == 0) {
            addFieldError("nome", getText("erro.nome.obrigatorio"));
        }
        if(sistema <= 0) {
            addFieldError("sistema", getText("erro.sistema.obrigatorio"));
        }
        if(operador.equals("-1")) {
            addFieldError("operador", getText("erro.operador.obrigatorio"));
        }
        if(hasErrors()) {
            return INPUT;
        }
        if(componente.getIdComponente() <= 0) {
            FabricaDAO.getComponenteDAO().insere(componente);
        }
        else {
            FabricaDAO.getComponenteDAO().atualiza(componente);
        }
        return SUCCESS;
    }
    
    public String criarComponente() {
        request.put("componente", new Componente());
        return INPUT;
    }
    
    public String editarComponente() {
        request.put("componente", FabricaDAO.getComponenteDAO().getComponente(idComponente));
        return INPUT;
    }
    
    public String display() {
        return NONE;
    }

    @Override
    public String execute() throws Exception {
        return SUCCESS;
    }
    
    public String listarComponentes() {
        request.put("componentes", FabricaDAO.getComponenteDAO().listarComponentes());
        return SUCCESS;
    }
    
}
