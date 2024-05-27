package controller;

import dao.ClienteDAO;
import dao.Conexao;
import dao.EstoqueDAO;
import dao.ItempedidoDAO;
import dao.PedidoDAO;
import dao.UsuarioDAO;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.Cliente;
import model.Item_Estoque;
import model.Itempedido;
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
                
                item_estoque.getId_Item(),
                item_estoque.getNome_Item(),
                item_estoque.getModelo(),
                item_estoque.getFornecedor(),
                item_estoque.getValor(),
                item_estoque.getQtd()
            }
            );
            
            
        }

    
      
}
        
   /*public void adicionarATabelaPedidos(JTable TabelaPedidos) throws SQLException{
    
        Connection conexao = new Conexao().getConnection();
        ItempedidoDAO itempedidodao = new ItempedidoDAO(conexao);
        
        ArrayList<Itempedido> selectAllParaTabela = itempedidodao.selectAllPorId();
        
        DefaultTableModel tableModel =  (DefaultTableModel) view.getTabelaPedidos().getModel();
       
        tableModel.setNumRows(0);
        
        for (Itempedido itemPedido : selectAllParaTabela) {
            
            tableModel.addRow(new Object[]{
                
                
                itemPedido.getPedido_id(),
                itemPedido.getId(),
                itemPedido.getId_item()
                    
            }
            );
            
            
        }

    
      
} */
   
   /*public void adicionarATabelaPedidos(JTable TabelaPedidos) throws SQLException {
    Connection conexao = new Conexao().getConnection();
    ItempedidoDAO itempedidodao = new ItempedidoDAO(conexao);

    ArrayList<Itempedido> selectAllParaTabela = itempedidodao.selectAllPorId();
    
    // Suponha que você tenha uma lista de NovoObjeto
    EstoqueDAO estoquedao = new EstoqueDAO(conexao);
    ArrayList<Item_Estoque> selectAllEstoque= estoquedao.selectAll();

    DefaultTableModel tableModel = (DefaultTableModel) TabelaPedidos.getModel();
    
    // Adiciona nova coluna ao modelo da tabela, se ainda não existir
    if (tableModel.getColumnCount() < 4) {
        tableModel.addColumn("Novo Item");
    }

    tableModel.setNumRows(0);
    
    for (int i = 0; i < selectAllParaTabela.size(); i++) {
        Itempedido itemPedido = selectAllParaTabela.get(i);
        Item_Estoque item_estoque = selectAllEstoque.get(i); // Assumindo que existe uma correspondência 1:1
        
        tableModel.addRow(new Object[]{
            itemPedido.getPedido_id(),
            itemPedido.getId(),
            itemPedido.getId_item(),
            item_estoque.getNome_Item() // Adiciona o novo item à linha
        });
    }
}*/
    
    public void adicionarATabelaPedidos(JTable TabelaPedidos) throws SQLException {
    Connection conexao = new Conexao().getConnection();
    ItempedidoDAO itempedidodao = new ItempedidoDAO(conexao);

    ArrayList<Itempedido> selectAllParaTabela = itempedidodao.selectAllPorId();
    
    EstoqueDAO estoquedao = new EstoqueDAO(conexao);
    ArrayList<Item_Estoque> selectAllEstoque = estoquedao.selectAll();

    // Cria um mapa para facilitar a busca de Item_Estoque por id_item
    Map<Integer, Item_Estoque> estoqueMap = new HashMap<>();
    for (Item_Estoque itemEstoque : selectAllEstoque) {
        estoqueMap.put(itemEstoque.getId_Item(), itemEstoque);
    }

    DefaultTableModel tableModel = (DefaultTableModel) TabelaPedidos.getModel();
    
    

    tableModel.setNumRows(0);

    for (Itempedido itemPedido : selectAllParaTabela) {
        Item_Estoque item_estoque = estoqueMap.get((int)itemPedido.getId_item());
        
        String nomeItem = item_estoque != null ? item_estoque.getNome_Item() : "Item não encontrado";

        tableModel.addRow(new Object[]{
            itemPedido.getPedido_id(),
            itemPedido.getId(),
            //itemPedido.getId_item(),
            nomeItem
        });
    }
}

   
    public void adicionarPedidoAoBancoPedido(){
        
        Connection conexao;
        try {
            Cliente cliente = new Cliente(pegaId());
            conexao = new Conexao().getConnection();
            PedidoDAO pedidodao = new PedidoDAO(conexao);
            pedidodao.insert(cliente);
        } catch (SQLException ex) {
            Logger.getLogger(TelaDeMenu.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }

    public void adicionarItemPedidoAoBanco(){
        //Seleciona o id do item e o preço
        DefaultTableModel model = (DefaultTableModel) view.getTabelaEstoqueMenu().getModel();
        int selectedRowIndex = view.getTabelaEstoqueMenu().getSelectedRow();
        //Pega os valores da tabela
        int selectedId = (int) model.getValueAt(selectedRowIndex, 0);
        Double selectedPreco = (Double) model.getValueAt(selectedRowIndex, 4);
        String selectedNome = model.getValueAt(selectedRowIndex, 1).toString();
        String selectedModelo = model.getValueAt(selectedRowIndex, 2).toString();
        String selectedFornecedor = model.getValueAt(selectedRowIndex, 3).toString();
        System.out.println(selectedId);
        System.out.println(selectedPreco);
        
        
        
        Connection conexao;
        try {
            conexao = new Conexao().getConnection();
            
            PedidoDAO pedidodao = new PedidoDAO(conexao);
            
            
            Pedido pedido = new Pedido(pedidodao.pegarPedido());
            Item_Estoque item_estoque = new Item_Estoque(selectedId, selectedNome, selectedModelo, selectedFornecedor, selectedPreco, 2);
            
            ItempedidoDAO itempedidodao = new ItempedidoDAO(conexao);
            itempedidodao.insert(item_estoque, pedido);
        } catch (SQLException ex) {
            Logger.getLogger(TelaDeMenu.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    
    public int pegaId(){
    
    String selectedNome = view.getComboBoxEstoque().getSelectedItem().toString();
        
        int index = selectedNome.indexOf('|');
        int id_nome = 0;        
        if (index != -1) {
            id_nome = Integer.parseInt(selectedNome.substring(0, index));
                System.out.println("Substring: " + id_nome);
                } else {
                    System.out.println("Caractere não encontrado na string.");
                }
    
        return id_nome;
    
    }
    
       
     

    public void TesteItensPedidos(){
        Connection conexao;
        try {
            conexao = new Conexao().getConnection();
            ItempedidoDAO itempedidao = new ItempedidoDAO(conexao);
            itempedidao.selectAllPorId();
        } catch (SQLException ex) {
            Logger.getLogger(TelaDeMenuController.class.getName()).log(Level.SEVERE, null, ex);
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
    

}