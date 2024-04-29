package controller;

import dao.Conexao;
import dao.EstoqueDAO;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.Item_Estoque;
import view.Estoque;


public class EstoqueController {
    
    private Estoque view;

    public EstoqueController(Estoque view) {
        this.view = view;
    }
    
    public void SalvarCliente() throws SQLException{
        
        String nome_item = view.getInsertNomeProduto().getText();
        String nome_modelo = view.getInsertModeloProduto().getText();
        String nome_fornecedor = view.getInsertFornecedorProduto().getText();
        
        
        try {
            
            double valor = Double.parseDouble(view.getInsertPrecoProduto().getText());
            int qtd = Integer.parseInt(view.getInsertQtdProduto().getText());

            String valorString = view.getInsertPrecoProduto().getText();
            String qtdString = view.getInsertQtdProduto().getText();
            //Verifica se os campos estão preenchidos
            if(nome_item.equals("Nome") || nome_modelo.equals("Modelo") || nome_fornecedor.equals("Fornecedor") || valorString.equals("Preço") || qtdString.equals("Quantidade"))
            {
            
                JOptionPane.showMessageDialog(null, "Preencha todos os campos");
            
            }else{
            
                Item_Estoque item_estoque = new Item_Estoque(nome_item, nome_modelo, nome_fornecedor, valor, qtd);
                Connection conexao = new Conexao().getConnection();
                EstoqueDAO estoquedao = new EstoqueDAO(conexao);
                estoquedao.insert(item_estoque);
            
            }
                
                       
        }//Captura o erro de input nos campos valor e quantidade
        catch (HeadlessException | NumberFormatException | SQLException e) {
            
            JOptionPane.showMessageDialog(null, "Houve um erro ao inserir o o item no Estoque: " + e.getMessage());
            
        }
        
            
        
        
        
        
        
        
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
                item_estoque.getValor(),
                item_estoque.getQtd()
            }
            );
            
            
        }
    }
    
    
}
