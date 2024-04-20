package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Cliente;



public class ClienteDAO {
    
    private final Connection connection;

    public ClienteDAO(Connection connection) {
        this.connection = connection;
    }
    
    public void insert(Cliente cliente) throws SQLException{

            
            String sql = "insert into cliente(nome, endereço, cep, telefone) values (?, ?, ?, ?)";
            
            PreparedStatement statement = connection.prepareStatement(sql);

//            statement.setString(1, "Gilberto"/*cliente.getNomeUsuario()*/);
//            statement.setString(2, "Rua dondoca"/*cliente.getEmail()*/);
//            statement.setInt(3, 90324752/*cliente.getSenha()*/);
//            statement.setInt(4, 219546677);
            
            statement.execute();
            
    }
    
    public void update(Cliente cliente) throws SQLException{
    
        String sql = "update cliente set nome = ?, endereço = ?, cep = ?, telefone = ? where id_cliente = ?";
            
            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setString(1, cliente.getNome_Cliente());
            statement.setString(2, cliente.getEndereço());
            statement.setInt(3, cliente.getCep());
            statement.setInt(4, cliente.getTelefone());
            statement.setInt(5, cliente.getId_Cliente());
            
            statement.execute();
    
    }
    
    public void insertOrUpdate(Cliente cliente) throws SQLException{
    
        if(cliente.getId_Cliente()>0){
            
            update(cliente);
            
        }else{
            
            insert(cliente);
        
        }
    
    
    
    }
    
    public void delete(Cliente cliente) throws SQLException{
    
        String sql = "delete from cliente where id_cliente = ?";
            
        PreparedStatement statement = connection.prepareStatement(sql);

        statement.setInt(1, cliente.getId_Cliente());

        statement.execute();
        
    
    
    }
    
    public ArrayList<Cliente> selectAll() throws SQLException{
    
        String sql = "select * from cliente";
            
        PreparedStatement statement = connection.prepareStatement(sql);
    
        return pesquisa(statement);
        
    }

    private ArrayList<Cliente> pesquisa(PreparedStatement statement) throws SQLException {
        ArrayList<Cliente> clientes = new ArrayList<>();
        
        
        statement.execute();
        ResultSet resultSet = statement.getResultSet();
        
        while(resultSet.next()){
        
            int id_cliente = resultSet.getInt("id_cliente");
            String nome = resultSet.getString("nome");
            String endereço = resultSet.getString("endereço");
            int cep = resultSet.getInt("cep");
            int telefone = resultSet.getInt("telefone");
        
            Cliente clienteDoBanco = new Cliente(id_cliente, nome, endereço, cep, telefone);
            clientes.add(clienteDoBanco);
            
        }
        
        
        return clientes;
    }
}
