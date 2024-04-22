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
    
    
    public void SalvarCliente() throws SQLException{
    
        String nome_cliente = view.getInsertNomeCliente().getText();
        String endereco = view.getInsertEndCliente().getText();
        int cep = Integer.parseInt(view.getInsertCepClientes().getText());
        String telefone = view.getInsertTeleCliente().getText();
    
        
        Cliente cliente = new Cliente(nome_cliente, endereco, cep, telefone);
        
        Connection conexao = new Conexao().getConnection();
        ClienteDAO clientedao = new ClienteDAO(conexao);
        
        clientedao.insert(cliente);
        
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
