package br.uniriotec.tickets.model;

/**
 *
 * @author Daniel Gribel <daniel.gribel@uniriotec.br>
 */
public class Componente {
    private int idComponente;
    private String nome;
    private int sistema;
    private String operador;

    public Componente() {
    
    }

    public Componente(int idComponente, String nome, int sistema, String operador) {
        this.idComponente = idComponente;
        this.nome = nome;
        this.sistema = sistema;
        this.operador = operador;
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
    
}
