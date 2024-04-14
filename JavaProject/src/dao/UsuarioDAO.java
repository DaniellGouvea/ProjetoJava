
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

            
            String sql = "insert into usuario(nome_usuario,email,senha) values ('"+usuario.getNomeUsuario()+"', '"+usuario.getEmail()+"', '"+usuario.getSenha()+"')";
            
            PreparedStatement statement = connection.prepareStatement(sql);
            
            statement.execute();
            
    }

    public boolean existeNoBancoPorUsuarioESenha(Usuario usuario) throws SQLException {
        
        String sql = "select * from usuario where email = '"+usuario.getEmail()+"' and senha = '"+usuario.getSenha()+"'";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.execute();
        
        ResultSet resultSet = statement.getResultSet();
        
        
        return resultSet.next();
    }
    
    
    
}
