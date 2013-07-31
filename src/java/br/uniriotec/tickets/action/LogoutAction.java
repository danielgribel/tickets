package br.uniriotec.tickets.action;

import com.opensymphony.xwork2.ActionSupport;
import java.util.Map;
import org.apache.struts2.interceptor.SessionAware;

/**
 *
 * @author Daniel Gribel <daniel.gribel@uniriotec.br>
 */
public class LogoutAction extends ActionSupport implements SessionAware {

    private Map<String, Object> session;
    
    @Override
    public void setSession(Map<String, Object> session) {
        this.session = session;
    }
    
    @Override
    public String execute() {
        session.remove("usuario");
        return SUCCESS;
    }
    
}
