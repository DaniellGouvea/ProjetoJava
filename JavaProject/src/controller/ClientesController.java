package controller;

import dao.ClienteDAO;
import dao.Conexao;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.Cliente;
import view.Clientes;


public class ClientesController {
    
    private Clientes view;

    public ClientesController(Clientes view) {
        this.view = view;
    }
    
    
    
    
    public void adicionarATabela(JTable tabelaClientes) throws SQLException{
    
        Connection conexao = new Conexao().getConnection();
        ClienteDAO clientedao = new ClienteDAO(conexao);
        
        ArrayList<Cliente> selectAllParaTabela = clientedao.selectAll();
        
        DefaultTableModel tableModel =  (DefaultTableModel) view.getTabelaClientes().getModel();
        
        tableModel.setNumRows(0);
        
        for (Cliente cliente : selectAllParaTabela) {
            
            tableModel.addRow(new Object[]{
            
                cliente.getId_Cliente(),
                cliente.getNome_Cliente(),
                cliente.getEndereço(),
                cliente.getCep(),
                cliente.getTelefone()
            }
            );
            
            
        }
    }
    
    
}
