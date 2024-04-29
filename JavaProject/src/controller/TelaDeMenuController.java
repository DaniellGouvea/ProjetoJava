package controller;

import dao.Conexao;
import dao.UsuarioDAO;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.Usuario;
import view.TelaDeMenu;


public class TelaDeMenuController {
    
    private TelaDeMenu view;

    public TelaDeMenuController(TelaDeMenu view) {
        this.view = view;
    }
    
    /*public void adicionarATabela(JTable tabelaUsuario) throws SQLException{
    
        Connection conexao = new Conexao().getConnection();
        UsuarioDAO usuariodao = new UsuarioDAO(conexao);
        
        ArrayList<Usuario> selectAllParaTabela = usuariodao.selectAll();
        
        DefaultTableModel tableModel =  (DefaultTableModel) view.getTabelaUsuario().getModel();
        
        tableModel.setNumRows(0);
        
        for (Usuario usuario : selectAllParaTabela) {
            
            tableModel.addRow(new Object[]{
            
                usuario.getIdUsuario(),
                usuario.getNomeUsuario(),
                usuario.getEmail(),
                usuario.getSenha()
            }
            );
            
            
        }
    }*/
    
    
    
}
