package br.uniriotec.tickets.model;

/**
 *
 * @author Pedro
 */
public class Sistema {
    private String nome;
    private int id;
    
    public Sistema(){
        
    }
    
    public Sistema(String nome, int id){
        this.nome = nome;
        this.id = id;
    }
    
    public String getNome(){
        return nome;
    }
    
    public void setNome(String nome){
        this.nome = nome;
    }
    
    public int getId(){
        return id;
    }
    
    public void setId(int id){
        this.id = id;
    }
    
}
