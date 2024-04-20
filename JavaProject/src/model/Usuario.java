
package model;


public class Usuario {
    
    private int idUsuario;
    private String nomeUsuario;
    private String email;
    private String senha;

    //Usuarios para cadastro
    public Usuario(int idUsuario, String nomeUsuario, String email, String senha) {
        this.idUsuario = idUsuario;
        this.email = email;
        this.senha = senha;
        this.nomeUsuario = nomeUsuario;
    }

    public Usuario(String nomeUsuario, String email, String senha) {
        this.email = email;
        this.senha = senha;
        this.nomeUsuario = nomeUsuario;
    }

    public Usuario(int idUsuario, String nomeUsuario, String email) {
        this.idUsuario = idUsuario;
        this.nomeUsuario = nomeUsuario;
        this.email = email;
    }
    
    
    
    
    //Usuario para Login
    public Usuario(String email, String senha) {
        this.email = email;
        this.senha = senha;
    }


    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
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

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }
    
    
    
    
    
    
    
    
}
