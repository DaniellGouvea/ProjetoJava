
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
