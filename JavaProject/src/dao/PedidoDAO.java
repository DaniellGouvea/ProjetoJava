/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import model.Cliente;
import model.Item_Estoque;
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
    
    public int pegarPedido() throws SQLException {
        
        String sql = "SELECT * FROM pedido ORDER BY id DESC LIMIT 1;";
        
        PreparedStatement statement = connection.prepareStatement(sql);
        
        //statement.setTimestamp(1, pegaTempo());
        
        statement.execute();
        ResultSet resultSet = statement.getResultSet();
        
        while(resultSet.next()){
            
            int id = resultSet.getInt("id");
            return id;
        }
        
        return 0;
    }
    
    public ArrayList<Pedido> pegarPedidosPorIdCliente(int id_cliente) throws SQLException {
        
        String sql = "SELECT * FROM pedido where cliente_id = ?;";
        
        PreparedStatement statement = connection.prepareStatement(sql);
        
        statement.setInt(1, id_cliente);
        
        
        return pesquisa(statement);
    }
    
    
    

    private ArrayList<Pedido> pesquisa(PreparedStatement statement) throws SQLException {
        
        ArrayList<Pedido> pedidos = new ArrayList<>();
        
        statement.execute();
        ResultSet resultSet = statement.getResultSet();
        
        while(resultSet.next()){
        
            int id_pedido = resultSet.getInt("id");
            int cliente_id = resultSet.getInt("cliente_id");
            
        
            Pedido pedidoNoBanco = new Pedido(id_pedido, cliente_id);
            pedidos.add(pedidoNoBanco);
        }
        
        return pedidos;
    }
    
    public ArrayList<Integer> pegarIdsDosPedidos(int id_cliente) throws SQLException {
        
        ArrayList<Pedido> pedidos = pegarPedidosPorIdCliente(id_cliente);
        ArrayList<Integer> idsPedidos = new ArrayList<>();
        
        for (Pedido pedido : pedidos) {
            idsPedidos.add(pedido.getId()); // Supondo que você tem um método getId() na classe Pedido
        }
        System.out.println(idsPedidos);
        return idsPedidos;
        
    }
    
    
    //Não usado
    public Timestamp pegaTempo(LocalDateTime agora){
    
        
        
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedDateTime = agora.format(formatter);
        Timestamp timestamp = Timestamp.valueOf(formattedDateTime);
        System.out.println(timestamp);
        
        return timestamp;
    }
}
