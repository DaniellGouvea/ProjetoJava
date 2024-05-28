
package dao;

import com.mysql.cj.xdevapi.Result;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Item_Estoque;
import model.Itempedido;
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
    
    public ArrayList<Itempedido> selectAllPorId() throws SQLException{
        
        Connection conexao = new Conexao().getConnection();
        PedidoDAO pedidodao = new PedidoDAO(conexao);
        
        String sql = "select * from itempedido where pedido_id = ?";
        PreparedStatement statement = connection.prepareStatement(sql);

        statement.setInt(1, pedidodao.pegarPedido());
        
    
        ArrayList<Itempedido> itensPedidos = pesquisaItemPedido(statement);
        
        return itensPedidos;
    }
    
    
    public ArrayList<Itempedido> pesquisaItemPedido(PreparedStatement statement) throws SQLException{
    
        ArrayList<Itempedido> itensPedidos = new ArrayList<>();
    
        statement.execute();
        
        ResultSet resultSet = statement.getResultSet();
        
        while(resultSet.next()){
        
            int id = resultSet.getInt("id");
            int pedido_id = resultSet.getInt(("pedido_id"));
            long id_item = resultSet.getLong("id_item");
            
            Itempedido itemDoBanco = new Itempedido(id, pedido_id, id_item);
            itensPedidos.add(itemDoBanco);
 
        }
        return itensPedidos;
    }
    
}
