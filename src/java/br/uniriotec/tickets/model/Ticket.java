package br.uniriotec.tickets.model;

/**
 *
 * @author Daniel Gribel <daniel.gribel@uniriotec.br>
 */
public class Ticket {
    private int idTicket;
    private String titulo;
    private int sistema;
    private int componente;
    private String descricao;
    private String operador;
    private Status status;
    
    public enum Status {
        NOVO,
        RESOLVIDO,
        INVALIDADO,
        REABERTO,
        FECHADO
    }

    public Ticket() {
    
    }

    public Ticket(int idTicket, String titulo, int sistema, int componente, String descricao, String operador) {
        this.idTicket = idTicket;
        this.titulo = titulo;
        this.sistema = sistema;
        this.componente = componente;
        this.descricao = descricao;
        this.operador = operador;
        this.status = Status.NOVO;
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

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
    
}
