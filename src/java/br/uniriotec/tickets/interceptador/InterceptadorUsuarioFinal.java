package br.uniriotec.tickets.interceptador;

import br.uniriotec.tickets.model.Usuario;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.interceptor.Interceptor;
import java.util.Map;

/**
 *
 * @author Daniel Gribel <daniel.gribel@uniriotec.br>
 */
public class InterceptadorUsuarioFinal implements Interceptor {

    @Override
    public void destroy() {
        
    }

    @Override
    public void init() {
        
    }

    @Override
    public String intercept(ActionInvocation actionInvocation) throws Exception {
        Map<String, Object> session = actionInvocation.getInvocationContext().getSession();
        Usuario usuario = (Usuario) session.get("usuario");
        if(usuario.getPerfil() != Usuario.Perfil.FINAL) {
            return ActionSupport.NONE;
        }
        return actionInvocation.invoke();
    }
}
