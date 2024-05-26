/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import model.Cliente;
import model.Pedido;

/**
 *
 * @author luizd
 */
public class PedidoDAO {
    
    private final Connection connection;

    public PedidoDAO(Connection connection) {
        this.connection = connection;
    }
    
    public void insert (Cliente cliente) throws SQLException{
        
        String sql = "insert into pedido(cliente_id) values (?)";
        
        PreparedStatement statement = connection.prepareStatement(sql);
        
        statement.setInt(1, cliente.getId_Cliente());
        
        statement.execute();
    }
}
