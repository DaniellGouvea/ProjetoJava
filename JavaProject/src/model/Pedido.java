/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Date;

/**
 *
 * @author luizd
 */
public class Pedido {
    
    private int id;
    private int cliente_id;
    

    public Pedido(int id, int cliente_id) {
        this.id = id;
        this.cliente_id = cliente_id;
        
    }

    public Pedido(int id) {
        this.id = id;
    }
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCliente_id() {
        return cliente_id;
    }

    public void setCliente_id(int cliente_id) {
        this.cliente_id = cliente_id;
    }

    
    
    
}
