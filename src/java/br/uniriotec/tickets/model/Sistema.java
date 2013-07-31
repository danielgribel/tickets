/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uniriotec.tickets.model;

import java.util.ArrayList;

/**
 *
 * @author Pedro
 */
public class Sistema {
    private String nome;
    private ArrayList<Usuario> componentes;
    
    public Sistema(){
        
    }
    
    public Sistema(String nome, ArrayList c){
        this.nome = nome;
        componentes = new ArrayList();
        componentes = c;
    }
    
    public String getNome(){
        return nome;
    }
    
    public void setNome(String nome){
        this.nome = nome;
    }
    
    public ArrayList<Usuario> getComponentes(){
        return componentes;
    }
    
    public void setComponentes(ArrayList c){
        componentes = c;
    }
    
}
