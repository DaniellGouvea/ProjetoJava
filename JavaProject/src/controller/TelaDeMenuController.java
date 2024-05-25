package controller;

import dao.ClienteDAO;
import dao.Conexao;
import dao.EstoqueDAO;
import dao.UsuarioDAO;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.Cliente;
import model.Item_Estoque;
import model.Usuario;
import view.TelaDeMenu;


public class TelaDeMenuController {
    
    private TelaDeMenu view;

    public TelaDeMenuController(TelaDeMenu view) {
        this.view = view;
    }
    
   public void adicionarAoComboBox(JComboBox<String> comboBoxClientes) throws SQLException{
       
        Connection conexao = new Conexao().getConnection();
        ClienteDAO clientedao = new ClienteDAO(conexao);
        
        ArrayList<Cliente> selectAllParaComboBox = clientedao.selectAll();
    
        comboBoxClientes.removeAllItems();

        for (Cliente cliente : selectAllParaComboBox) {
            comboBoxClientes.addItem(formato(cliente.getNome_Cliente()));
        }
        }
   
   public String formato(String nome){
        String mensagem = String.format("%s", nome);
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
    

