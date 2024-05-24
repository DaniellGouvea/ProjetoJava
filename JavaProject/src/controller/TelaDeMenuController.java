package controller;

import dao.Conexao;
import dao.EstoqueDAO;
import dao.UsuarioDAO;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.Item_Estoque;
import model.Usuario;
import view.TelaDeMenu;


public class TelaDeMenuController {
    
    private TelaDeMenu view;

    public TelaDeMenuController(TelaDeMenu view) {
        this.view = view;
    }
    
   public void adicionarAoComboBox(JComboBox<String> comboBoxEstoque) throws SQLException{
       
        Connection conexao = new Conexao().getConnection();
        EstoqueDAO estoquedao = new EstoqueDAO(conexao);
        
        ArrayList<Item_Estoque> selectAllParaComboBox = estoquedao.selectAll();
    
        comboBoxEstoque.removeAllItems();

        for (Item_Estoque item_estoque : selectAllParaComboBox) {
            comboBoxEstoque.addItem(formato(item_estoque.getNome_Item(), item_estoque.getModelo()));
        }
        }
   
   public String formato(String Nome_item, String Modelo){
        String mensagem = String.format("%s (%s)", Nome_item, Modelo);
        return mensagem;
    }
   
   
       
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
    

