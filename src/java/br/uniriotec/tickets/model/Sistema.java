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
    private int id;
    
    public Sistema(){
        
    }
    
    public Sistema(String nome){
        this.nome = nome;
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
