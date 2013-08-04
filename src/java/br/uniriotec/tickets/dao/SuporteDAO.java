/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uniriotec.tickets.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Daniel Gribel <daniel.gribel@uniriotec.br>
 */
public class SuporteDAO {
    
    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/tickets", "root", "");
            conexao.setCatalog("tickets");
            return conexao;
        } catch(SQLException e) {
            System.err.println("Nao foi possivel estabelecer uma conexao com o banco de dados - erro de SQL");
            System.err.println(e.getMessage());
            return null;
        } catch(ClassNotFoundException e) {
            System.err.println("Nao foi possivel estabelecer uma conexao com o banco de dados - Driver nao encontrado");
            System.err.println(e.getMessage());
            return null;
        } catch(InstantiationException e) {
            System.err.println("Nao foi possivel estabelecer uma conexao com o banco de dados - erro de instanciacao do driver");
            System.err.println(e.getMessage());
            return null;
        } catch(IllegalAccessException e) {
            System.err.println("Nao foi possivel estabelecer uma conexao com o banco de dados - acesso ilegal no driver");
            System.err.println(e.getMessage());
            return null;
        }
    }
    
    //log
    public static void log(String mensagem) {
        System.out.println(mensagem);
    }
}
