/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author luizd
 */
public class Itempedido{
    
    private int id;
    private int pedido_id;
    private long id_item;
    private int quantidade ;
    private Double preco;

    public Itempedido(int id, int pedido_id, long id_item, int quantidade, Double preco) {
        this.id = id;
        this.pedido_id = pedido_id;
        this.id_item = id_item;
        this.quantidade = quantidade;
        this.preco = preco;
    }

    public Itempedido(int pedido_id, long id_item, int quantidade, Double preco) {
        this.pedido_id = pedido_id;
        this.id_item = id_item;
        this.quantidade = quantidade;
        this.preco = preco;
    }

    public Itempedido(int id, int pedido_id, long id_item) {
        this.id = id;
        this.pedido_id = pedido_id;
        this.id_item = id_item;
    }
    
    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPedido_id() {
        return pedido_id;
    }

    public void setPedido_id(int pedido_id) {
        this.pedido_id = pedido_id;
    }

    public long getId_item() {
        return id_item;
    }

    public void setId_item(long id_item) {
        this.id_item = id_item;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    
    
}
