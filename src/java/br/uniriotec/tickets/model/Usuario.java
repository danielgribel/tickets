package br.uniriotec.tickets.model;

/**
 *
 * @author Daniel Gribel <daniel.gribel@uniriotec.br>
 */
public class Usuario {
    private String nome;
    private String sobrenome;
    private String email;
    private String senha;
    private Perfil perfil;

    public enum Perfil {
        ADMIN,
        FINAL,
        OPERADOR
    }

    public Usuario() {
    
    }
    
    public Usuario(String nome, String sobrenome, String email, String senha) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.email = email;
        this.senha = senha;
        this.perfil = Perfil.FINAL;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    public Perfil getPerfil() {
        return perfil;
    }

    public void setPerfil(Perfil perfil) {
        this.perfil = perfil;
    }
}
