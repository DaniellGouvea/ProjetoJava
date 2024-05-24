package model;


public class Cliente {
    
    private int id_Cliente;
    private String nome_Cliente;
    private String endereço;
    private int cep;
    private String telefone;
    private Double cpf;

    public Cliente(int id_Cliente, String nome_Cliente, String endereço, int cep, String telefone, Double cpf) {
        this.id_Cliente = id_Cliente;
        this.nome_Cliente = nome_Cliente;
        this.endereço = endereço;
        this.cep = cep;
        this.telefone = telefone;
        this.cpf = cpf;
    }
    public Cliente(int id_Cliente, String nome_Cliente, String endereço, int cep, String telefone) {
        this.id_Cliente = id_Cliente;
        this.nome_Cliente = nome_Cliente;
        this.endereço = endereço;
        this.cep = cep;
        this.telefone = telefone;
    }
    public Cliente(String nome_Cliente, String endereço, int cep, String telefone, Double cpf) {
        this.nome_Cliente = nome_Cliente;
        this.endereço = endereço;
        this.cep = cep;
        this.telefone = telefone;
        this.cpf = cpf;
    }
    public Cliente(String nome_Cliente, String endereço, int cep, String telefone) {
        this.nome_Cliente = nome_Cliente;
        this.endereço = endereço;
        this.cep = cep;
        this.telefone = telefone;
    }

    public Cliente(int id_Cliente) {
        this.id_Cliente = id_Cliente;
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

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Double getCpf() {
        return cpf;
    }

    public void setCpf(Double cpf) {
        this.cpf = cpf;
    }
    
    
    
    
}
