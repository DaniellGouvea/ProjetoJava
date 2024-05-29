
package controller;

import dao.ClienteDAO;
import dao.Conexao;
import dao.EstoqueDAO;
import dao.ItempedidoDAO;
import dao.PedidoDAO;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.Cliente;
import model.Item_Estoque;
import model.Itempedido;
import view.ChecaPedidos;


public class ChecaPedidosController {
    
    private ChecaPedidos view;

    public ChecaPedidosController(ChecaPedidos view) {
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
    
   
    public int pegaId(){

    String selectedNome = view.getJcomboClientes().getSelectedItem().toString();

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
    
    public void ChamaPedidos() throws SQLException{
        Connection conexao = new Conexao().getConnection();
        PedidoDAO pedidodao = new PedidoDAO(conexao);
        ItempedidoDAO itempedidodao = new ItempedidoDAO(conexao);
        itempedidodao.selectAllPorIds(pedidodao.pegarIdsDosPedidos(pegaId()));

    }
    
    public void adicionarATabela(JTable tablePedidosCliente) throws SQLException{
    
        Connection conexao = new Conexao().getConnection();
        ItempedidoDAO itempedidodao = new ItempedidoDAO(conexao);
        PedidoDAO pedidodao = new PedidoDAO(conexao);
        EstoqueDAO estoquedao = new EstoqueDAO(conexao);
        
        ArrayList<Itempedido> selectAllParaTabela = itempedidodao.selectAllPorIds(pedidodao.pegarIdsDosPedidos(pegaId()));
        
        ArrayList<Item_Estoque> selectAllEstoque = estoquedao.selectAll();
        
        Map<Integer, Item_Estoque> estoqueMap = new HashMap<>();
        for (Item_Estoque itemEstoque : selectAllEstoque) {
            estoqueMap.put(itemEstoque.getId_Item(), itemEstoque);
        }
        
        DefaultTableModel tableModel =  (DefaultTableModel) view.getTabelaPedidos().getModel();
       
        tableModel.setNumRows(0);
        
        for (Itempedido itempedido : selectAllParaTabela) {
            Item_Estoque item_estoque = estoqueMap.get((int)itempedido.getId_item());
        
            String nomeItem = item_estoque != null ? item_estoque.getNome_Item() : "Item não encontrado"; 
            
            tableModel.addRow(new Object[]{
                
                itempedido.getPedido_id(),
                itempedido.getId_item(),
                nomeItem,
                itempedido.getPreco()
            }
            );
            
            
        }

    
      
}
}
