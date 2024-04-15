
package controller;

import dao.Conexao;
import dao.UsuarioDAO;
import model.Usuario;
import view.MenuTeste;
import view.TelaDeLogin;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class TelaDeLoginController {
    
    private TelaDeLogin view;

    public TelaDeLoginController(TelaDeLogin view) {
        this.view = view;
    }

    public void autenticar() throws SQLException {
        
        String email = view.getInsertEmail().getText();
        String senha = new String (view.getInsertSenha().getPassword());
        
        Usuario usuarioAutenticar = new Usuario(email, senha);
        
           Connection conexao = new Conexao().getConnection();
           UsuarioDAO usuarioDao = new UsuarioDAO(conexao);
           
           
           boolean existe = usuarioDao.existeNoBancoPorEmailESenha(usuarioAutenticar);
           
        
           if(existe){
               
               MenuTeste menu = new MenuTeste();
               menu.setVisible(true);
               
               view.dispose();
               
                }else if(email.equals("Email") || senha.equals("Senha")){

                    JOptionPane.showMessageDialog(null, "Preencha todos os campos para efetuar o login");

                }
                    else{

                        JOptionPane.showMessageDialog(null, "Email ou Senha inválidos");

                        }
           

    }
    
    
    
}
