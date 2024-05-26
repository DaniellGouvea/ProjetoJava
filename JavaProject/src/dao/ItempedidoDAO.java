
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import model.Item_Estoque;
import model.Pedido;



public class ItempedidoDAO {
    
    private final Connection connection;

    public ItempedidoDAO(Connection connection) {
        this.connection = connection;
    }
    
    public void insert (Item_Estoque item_estoque, Pedido pedido) throws SQLException{
        
        String sql = "insert into itempedido(pedido_id, id_item, preco, quantidade) values (?, ?, ?, ?)";
        
        PreparedStatement statement = connection.prepareStatement(sql);
        
        statement.setInt(1, pedido.getId());
        statement.setInt(2, item_estoque.getId_Item());
        statement.setDouble(3, item_estoque.getValor());
        statement.setInt(4, item_estoque.getQtd());    
        statement.execute();
        
    }
    
    
}
