/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uniriotec.tickets.interceptador;

import br.uniriotec.tickets.model.Usuario;
import br.uniriotec.tickets.model.Usuario.Perfil;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.interceptor.Interceptor;
import java.util.Map;

/**
 *
 * @author Daniel Gribel <daniel.gribel@uniriotec.br>
 */
public class InterceptadorPerfil implements Interceptor {

    @Override
    public void destroy() {
        
    }

    @Override
    public void init() {
        
    }

    @Override
    public String intercept(ActionInvocation actionInvocation) throws Exception {
        System.out.println("chamou default");
        Map<String, Object> session = actionInvocation.getInvocationContext().getSession();
        Usuario usuario = (Usuario) session.get("usuario");
        if(usuario.getPerfil() != Perfil.ADMIN) {
            return ActionSupport.NONE;
        }
        return actionInvocation.invoke();
    }
    
    public String perfilInterceptor2(ActionInvocation actionInvocation) throws Exception {
        System.out.println("chamou 2");
        Map<String, Object> session = actionInvocation.getInvocationContext().getSession();
        Usuario usuario = (Usuario) session.get("usuario");
        if(usuario.getPerfil() != Perfil.ADMIN) {
            return ActionSupport.NONE;
        }
        return actionInvocation.invoke();
    }
    
}
