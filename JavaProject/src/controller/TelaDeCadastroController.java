
package controller;

import dao.Conexao;
import dao.UsuarioDAO;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Usuario;
import view.TelaDeCadastro;
import javax.swing.JOptionPane;
import view.TelaDeLogin;

public class TelaDeCadastroController {
    
    private TelaDeCadastro view;

    public TelaDeCadastroController(TelaDeCadastro view) {
        this.view = view;
    }
    
    public void salvaUsuario(){
        
        String nome_usuario  = view.getInsertNomeC().getText();
        String email = view.getInsertEmailC().getText();
        String senha = new String (view.getInsertSenhaC().getPassword());
        String confirmarSenha = new String (view.getInsertConfSenhaC().getPassword());
        
        Usuario usuario = new Usuario(nome_usuario, email, senha);
        
        
        
        if(nome_usuario.equals("Nome Completo") || email.equals("Email")|| senha.equals("Senha")){
        
            JOptionPane.showMessageDialog(null, "Preencha todos os campos");
        
        }
        else {
            
                    
            if(!confirmarSenha.equals(senha)){

                JOptionPane.showMessageDialog(null, "Repita mesma senha no campo 'Confirmar Senha'");

                }else if(senha.length()<8 || confirmarSenha.length() < 8){
                        
                JOptionPane.showMessageDialog(null, "Sua senha tem que ter pelo menos 8 caracteres");
                } 
                    else{
                            try {
                                Connection conexao = new Conexao().getConnection();
                                UsuarioDAO usuariodao = new UsuarioDAO(conexao);
                                usuariodao.insert(usuario);

                            } catch (SQLException ex) {
                                Logger.getLogger(TelaDeCadastro.class.getName()).log(Level.SEVERE, null, ex);
                            }

                            JOptionPane.showMessageDialog(null, "Usuario Cadastrado com Sucesso!");
                            //Abri a Tela de Login
                            TelaDeLogin tela1 = new TelaDeLogin();
                            tela1.setVisible(true);
                            view.dispose();

        }}
    }
    
    
}
