package br.uniriotec.tickets.action;

import com.opensymphony.xwork2.ActionSupport;

/**
 * <code>Set welcome message.</code>
 */
public class UsuarioAction extends ActionSupport {

    public String execute() throws Exception {
        setMessage(getText(MESSAGE));
        return SUCCESS;
    }

    /**
     * Provide default valuie for Message property.
     */
    public static final String MESSAGE = "";

    /**
     * Field for Message property.
     */
    private String message;

    /**
     * Return Message property.
     *
     * @return Message property
     */
    public String getMessage() {
        return message;
    }

    /**
     * Set Message property.
     *
     * @param message Text to display on HelloWorld page.
     */
    public void setMessage(String message) {
        this.message = message;
    }
}