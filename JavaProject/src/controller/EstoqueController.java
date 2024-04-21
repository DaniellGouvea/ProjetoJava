package controller;

import dao.ClienteDAO;
import dao.Conexao;
import dao.EstoqueDAO;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.Cliente;
import model.Item_Estoque;
import view.Estoque;


public class EstoqueController {
    
    private Estoque view;

    public EstoqueController(Estoque view) {
        this.view = view;
    }
    
    public void adicionarATabela(JTable tabelaEstoque) throws SQLException{
    
        Connection conexao = new Conexao().getConnection();
        EstoqueDAO estoquedao = new EstoqueDAO(conexao);
        
        ArrayList<Item_Estoque> selectAllParaTabela = estoquedao.selectAll();
        
        DefaultTableModel tableModel =  (DefaultTableModel) view.getTabelaEstoque().getModel();
        
        tableModel.setNumRows(0);
        
        for (Item_Estoque item_estoque : selectAllParaTabela) {
            
            tableModel.addRow(new Object[]{
            
                item_estoque.getId_Item(),
                item_estoque.getNome_Item(),
                item_estoque.getModelo(),
                item_estoque.getFornecedor(),
                item_estoque.getValor()
            }
            );
            
            
        }
    }
    
    
}
