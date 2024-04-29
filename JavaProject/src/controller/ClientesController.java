package controller;

import dao.ClienteDAO;
import dao.Conexao;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import javax.swing.JOptionPane;
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
        int cep;
        String telefone = view.getInsertTeleCliente().getText();
        Double cpf;
        
        String CepString = view.getInsertCepClientes().getText();
        String CpfString = view.getInsertCPFCliente().getText();
        
        try {
            //Verifica se os campos estão preenchidos
            if (nome_cliente.equals("Nome Completo") || endereco.equals("Endereço") || CepString.equals("CEP") || telefone.equals("Telefone")) {
                JOptionPane.showMessageDialog(null, "Preencha todos os campos!");
            } else {
                    // Verifica se CEP e telefone são numéricos
                    if (telefone.matches("[0-9]+")) {
                        //Verifica o tamanho das entradas de CEP e Telefone
                        if(telefone.length() >11 || telefone.length() < 11 ||CepString.length() > 8 ||CepString.length() < 8){
                        
                            JOptionPane.showMessageDialog(null, """
                                                                Telefone deve conter 11 digitos!
                                                                Cep deve conter 8 digitos!""");
                            
                        }//Finalmente executa do envio
                        else{
                            cep = Integer.parseInt(view.getInsertCepClientes().getText());
                            
                            
                           if(CpfString.equals("CPF")){
                               
                                cpf = null;
                              
                           }else {
                               
                                cpf = Double.valueOf(view.getInsertCPFCliente().getText());
                           
                           }
                            Cliente cliente = new Cliente(nome_cliente, endereco, cep, telefone, cpf);
                               
                            Connection conexao = new Conexao().getConnection();
                            ClienteDAO clientedao = new ClienteDAO(conexao);
                            if(cliente.getCpf() == null){
                                clientedao.insert(cliente);
                            }else if(cliente.getCpf() != null){
                                if(CpfString.length() < 11 || CpfString.length() > 11){
                                    JOptionPane.showMessageDialog(null, "Cpf deve conter 11 digitos");
                                
                                }else{
                                
                                                                    
                                    clientedao.insertComCpf(cliente);
                                
                                }

                            }
                            
                        }   
                    } else {
                        JOptionPane.showMessageDialog(null, "Os valores dos campos CEP e Telefone devem ser numéricos");
                    }
            }
        } catch (HeadlessException | NumberFormatException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Houve um erro ao inserir o cliente: " + e.getMessage());
        }

        
        
        
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
                cliente.getTelefone(),
                valorCpf(cliente.getCpf())
                
            }
            );
            
            
        }
    }
    
    private String valorCpf(double valor){
        
        
            String valorFormatado = new DecimalFormat("#").format(valor);
            
            if(valorFormatado.equals("0")){
            
                valorFormatado = "Não Informado";
            
            }
            
        
            return valorFormatado;
    
    }
}
