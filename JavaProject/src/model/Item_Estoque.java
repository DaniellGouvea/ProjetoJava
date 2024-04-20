package model;


public class Item_Estoque {
    
    private int id_Item;
    private String Nome_Item;
    private String Modelo;
    private String Fornecedor;
    private Double Valor;

    public Item_Estoque(int id_Item, String Nome_Item, String Modelo, String Fornecedor, Double Valor) {
        this.id_Item = id_Item;
        this.Nome_Item = Nome_Item;
        this.Modelo = Modelo;
        this.Fornecedor = Fornecedor;
        this.Valor = Valor;
    }

    public Item_Estoque(String Nome_Item, String Modelo, String Fornecedor, Double Valor) {
        this.Nome_Item = Nome_Item;
        this.Modelo = Modelo;
        this.Fornecedor = Fornecedor;
        this.Valor = Valor;
    }

    public int getId_Item() {
        return id_Item;
    }

    public void setId_Item(int id_Item) {
        this.id_Item = id_Item;
    }

    public String getNome_Item() {
        return Nome_Item;
    }

    public void setNome_Item(String Nome_Item) {
        this.Nome_Item = Nome_Item;
    }

    public String getModelo() {
        return Modelo;
    }

    public void setModelo(String Modelo) {
        this.Modelo = Modelo;
    }

    public String getFornecedor() {
        return Fornecedor;
    }

    public void setFornecedor(String Fornecedor) {
        this.Fornecedor = Fornecedor;
    }

    public Double getValor() {
        return Valor;
    }

    public void setValor(Double Valor) {
        this.Valor = Valor;
    }
    
    
    
    
}
