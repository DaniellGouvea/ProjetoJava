package controller;

import dao.ClienteDAO;
import dao.Conexao;
import dao.EstoqueDAO;
import dao.ItempedidoDAO;
import dao.PedidoDAO;
import dao.UsuarioDAO;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.Cliente;
import model.Item_Estoque;
import model.Pedido;
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
        comboBoxClientes.addItem("Selecione o Cliente");
        for (Cliente cliente : selectAllParaComboBox) {
        comboBoxClientes.addItem(formato(cliente.getNome_Cliente(), cliente.getId_Cliente()));
        }
        }
   
   public String formato(String nome, int id){
        String mensagem = String.format("%d| %s", id, nome);
       
        return mensagem;
    }
  
   
   public void adicionarATabela(JTable tableTeste) throws SQLException{
    
        Connection conexao = new Conexao().getConnection();
        EstoqueDAO estoquedao = new EstoqueDAO(conexao);
        
        ArrayList<Item_Estoque> selectAllParaTabela = estoquedao.selectAll();
        
        DefaultTableModel tableModel =  (DefaultTableModel) view.getTabela().getModel();
       
        tableModel.setNumRows(0);
        
        for (Item_Estoque item_estoque : selectAllParaTabela) {
            
            tableModel.addRow(new Object[]{
            
                item_estoque.getNome_Item(),
                item_estoque.getValor(),
                item_estoque.getQtd()
            }
            );
            
            
        }

    
      
}
        
    
    public void adicionarPedidoAoBancoPedido(){
        
        String selectedNome = view.getComboBoxEstoque().getSelectedItem().toString();
        
        int index = selectedNome.indexOf('|');
        int id_nome = 0;        
                if (index != -1) {
                id_nome = Integer.parseInt(selectedNome.substring(0, index));
                    System.out.println("Substring: " + id_nome);
                    
                } else {
                    System.out.println("Caractere não encontrado na string.");
                }
        
        Connection conexao;
        try {
            Cliente cliente = new Cliente(id_nome);
            conexao = new Conexao().getConnection();
            PedidoDAO pedidodao = new PedidoDAO(conexao);
            pedidodao.insert(cliente);
        } catch (SQLException ex) {
            Logger.getLogger(TelaDeMenu.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }

    public void adicionarItemPedidoAoBanco(){
        
        
        Connection conexao;
        try {
            Pedido pedido = new Pedido(2);
            Item_Estoque item_estoque = new Item_Estoque(60, "item1", "modelo1", "fornecedor1", 5, 40);
            conexao = new Conexao().getConnection();
            ItempedidoDAO itempedidodao = new ItempedidoDAO(conexao);
            itempedidodao.insert(item_estoque, pedido);
        } catch (SQLException ex) {
            Logger.getLogger(TelaDeMenu.class.getName()).log(Level.SEVERE, null, ex);
        }
    
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
    

