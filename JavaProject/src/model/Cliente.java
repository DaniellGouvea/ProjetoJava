package model;


public class Cliente {
    
    private int id_Cliente;
    private String nome_Cliente;
    private String endereço;
    private int cep;
    private int telefone;

    public Cliente(int id_Cliente, String nome_Cliente, String endereço, int cep, int telefone) {
        this.id_Cliente = id_Cliente;
        this.nome_Cliente = nome_Cliente;
        this.endereço = endereço;
        this.cep = cep;
        this.telefone = telefone;
    }

    public Cliente(String nome_Cliente, String endereço, int cep, int telefone) {
        this.nome_Cliente = nome_Cliente;
        this.endereço = endereço;
        this.cep = cep;
        this.telefone = telefone;
    }

    public int getId_Cliente() {
        return id_Cliente;
    }

    public void setId_Cliente(int id_Cliente) {
        this.id_Cliente = id_Cliente;
    }

    public String getNome_Cliente() {
        return nome_Cliente;
    }

    public void setNome_Cliente(String nome_Cliente) {
        this.nome_Cliente = nome_Cliente;
    }

    public String getEndereço() {
        return endereço;
    }

    public void setEndereço(String endereço) {
        this.endereço = endereço;
    }

    public int getCep() {
        return cep;
    }

    public void setCep(int cep) {
        this.cep = cep;
    }

    public int getTelefone() {
        return telefone;
    }

    public void setTelefone(int telefone) {
        this.telefone = telefone;
    }
    
    
    
    
}