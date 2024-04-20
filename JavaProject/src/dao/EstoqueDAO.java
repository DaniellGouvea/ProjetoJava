package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Item_Estoque;



public class EstoqueDAO {
    
    private final Connection connection;

    public EstoqueDAO(Connection connection) {
        this.connection = connection;
    }
    
    public void insert(Item_Estoque item_estoque) throws SQLException{

            
            String sql = "insert into item_estoque(nome_item, nome_modelo, nome_fornecedor, valor) values (?, ?, ?, ?)";
            
            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setString(1, "Lisa"/*cliente.getNomeUsuario()*/);
            statement.setString(2, "Tanga"/*cliente.getEmail()*/);
            statement.setString(3, "Joãozinho da loja"/*cliente.getSenha()*/);
            statement.setDouble(4, 5.60);
            
            statement.execute();
            
    }
    
    public void update(Item_Estoque item_estoque) throws SQLException{
    
        String sql = "update item_estoque set nome_item = ?, nome_modelo = ?, nome_fornecedor = ?, valor = ? where id_item = ?";
            
        PreparedStatement statement = connection.prepareStatement(sql);

        statement.setString(1, item_estoque.getNome_Item());
        statement.setString(2, item_estoque.getModelo());
        statement.setString(3, item_estoque.getFornecedor());
        statement.setDouble(4, item_estoque.getValor());
        statement.setInt(5, item_estoque.getId_Item());

        statement.execute();
    
    
    }
    
    public void insertOrUpdate(Item_Estoque item_estoque) throws SQLException{
    
        if(item_estoque.getId_Item()>0){
            
            update(item_estoque);
            
        }else{
            
            insert(item_estoque);
        
        }
    
    }
    
    public void delete(Item_Estoque item_estoque) throws SQLException{
    
        String sql = "delete from item_estoque where id_item = ?";
            
        PreparedStatement statement = connection.prepareStatement(sql);

        statement.setInt(1, item_estoque.getId_Item());

        statement.execute();
     
    }
    
    public ArrayList<Item_Estoque> selectAll() throws SQLException{
    
        String sql = "select * from item_estoque";
            
        PreparedStatement statement = connection.prepareStatement(sql);
    
        return pesquisa(statement);
        
    }

    private ArrayList<Item_Estoque> pesquisa(PreparedStatement statement) throws SQLException {
        ArrayList<Item_Estoque> clientes = new ArrayList<>();
        
        statement.execute();
        ResultSet resultSet = statement.getResultSet();
        
        while(resultSet.next()){
        
            int id_item = resultSet.getInt("id_item");
            String nome_item = resultSet.getString("nome_item");
            String nome_modelo = resultSet.getString("nome_modelo");
            String nome_fornecedor = resultSet.getString("nome_fornecedor");
            Double valor = resultSet.getDouble("valor");
        
            Item_Estoque itemDoBanco = new Item_Estoque(id_item, nome_item, nome_modelo, nome_fornecedor, valor);
            clientes.add(itemDoBanco);
            
        }
        
        
        return clientes;
    }
    
    public Item_Estoque selectPorId(Item_Estoque item_estoque) throws SQLException{
    
        String sql = "select * from item_estoque where id = ?";  
        PreparedStatement statement = connection.prepareStatement(sql);
        
        statement.setInt(1, item_estoque.getId_Item());
        
        
        statement.execute();

        
        return pesquisa(statement).get(0);
    }
    
}
