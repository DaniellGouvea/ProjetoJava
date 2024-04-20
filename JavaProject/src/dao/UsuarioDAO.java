
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Usuario;
import view.TelaDeLogin;


public class UsuarioDAO {
    
    private final Connection connection;

    public UsuarioDAO(Connection connection) {
        this.connection = connection;
    }
    
    public void insert(Usuario usuario) throws SQLException{

            
            String sql = "insert into usuario(nome_usuario,email,senha) values (?, ?, ?)";
            
            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setString(1, usuario.getNomeUsuario());
            statement.setString(2, usuario.getEmail());
            statement.setString(3, usuario.getSenha());
            
            statement.execute();
            
    }

    public void update(Usuario usuario) throws SQLException{
    
        String sql = "update usuario set nome_usuario = ?, email = ?, senha = ? where id_usuario = ?";
            
            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setString(1, usuario.getNomeUsuario());
            statement.setString(2, usuario.getEmail());
            statement.setString(3, usuario.getSenha());
            statement.setInt(4, usuario.getIdUsuario());
            
            statement.execute();
    
    }
    
    public void insertOrUpdate(Usuario usuario) throws SQLException{
    
        if(usuario.getIdUsuario()>0){
            
            update(usuario);
            
        }else{
            
            insert(usuario);
        
        }
    
    
    
    }
    
    public void delete(Usuario usuario) throws SQLException{
    
        String sql = "delete from usuario where id_usuario = ?";
            
        PreparedStatement statement = connection.prepareStatement(sql);

        statement.setInt(1, usuario.getIdUsuario());

        statement.execute();
        
    
    
    }
    
    public ArrayList<Usuario> selectAll() throws SQLException{
    
        String sql = "select * from usuario";
            
        PreparedStatement statement = connection.prepareStatement(sql);
    
        return pesquisa(statement);
        
    }

    private ArrayList<Usuario> pesquisa(PreparedStatement statement) throws SQLException {
        ArrayList<Usuario> usuarios = new ArrayList<>();
        
        
        statement.execute();
        ResultSet resultSet = statement.getResultSet();
        
        while(resultSet.next()){
        
            int id_usuario = resultSet.getInt("id_usuario");
            String nome_usuario = resultSet.getString("nome_usuario");
            String email = resultSet.getString("email");
        
            Usuario usuarioDoBanco = new Usuario(id_usuario, nome_usuario, email);
            usuarios.add(usuarioDoBanco);
            
        }
        
        
        return usuarios;
    }
    
    public Usuario selectPorId(Usuario usuario) throws SQLException{
    
        String sql = "select * from usuario where id = ?";  
        PreparedStatement statement = connection.prepareStatement(sql);
        
        statement.setInt(1, usuario.getIdUsuario());
        
        
        statement.execute();

        
        return pesquisa(statement).get(0);
    }
    
    
    
    public boolean existeNoBancoPorEmailESenha(Usuario usuario) throws SQLException {
        
        String sql = "select * from usuario where email = ? and senha = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        
        statement.setString(1, usuario.getEmail());
        statement.setString(2, usuario.getSenha());
        
        
        statement.execute();
        
        ResultSet resultSet = statement.getResultSet();
        
        
        return resultSet.next();
    }
    
    public boolean existeNoBancoPorEmail(Usuario usuario) throws SQLException {
        
        String sql = "select * from usuario where email = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        
        statement.setString(1, usuario.getEmail());
        
        statement.execute();
        
        ResultSet resultSet = statement.getResultSet();
        
        
        return resultSet.next();
    }
    
       
}
