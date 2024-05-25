package controller;

import dao.ClienteDAO;
import dao.Conexao;
import java.awt.Color;
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
        Double cpf = null;
        
        String CepString = view.getInsertCepClientes().getText();
        String CpfString = view.getInsertCPFCliente().getText();
        
        try {
            if (nome_cliente.equals("Nome Completo") || endereco.equals("Endereço") || CepString.equals("CEP") || telefone.equals("Telefone")) {
                JOptionPane.showMessageDialog(null, "Preencha todos os campos!");
            } else {
                if (telefone.matches("[0-9]+")) {
                    if (telefone.length() != 11 || CepString.length() != 8) {
                        JOptionPane.showMessageDialog(null, "Telefone deve conter 11 digitos!\nCep deve conter 8 digitos!");
                    } else {
                        cep = Integer.parseInt(CepString);
                        
                        if (!CpfString.equals("CPF")) {
                            cpf = Double.valueOf(CpfString);
                        }
                        Cliente cliente = new Cliente(nome_cliente, endereco, cep, telefone, cpf);
                        
                        Connection conexao = new Conexao().getConnection();
                        ClienteDAO clientedao = new ClienteDAO(conexao);
                        if (clientedao.clienteExiste(cliente)) {
                            JOptionPane.showMessageDialog(null, "Esse Cliente já está cadastrado. Se deseja alterar clique no botão Alterar");
                        } else {
                            if (cpf == null) {
                                clientedao.insert(cliente);
                                limparCampo();
                            } else {
                                if (CpfString.length() == 11) {
                                    clientedao.insertComCpf(cliente);
                                    limparCampo();
                                } else {
                                    JOptionPane.showMessageDialog(null, "Cpf deve conter 11 digitos");
                                }
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
    
    public void adicionarATabela(JTable tabelaClientes) throws SQLException {
        Connection conexao = new Conexao().getConnection();
        ClienteDAO clientedao = new ClienteDAO(conexao);
        
        ArrayList<Cliente> selectAllParaTabela = clientedao.selectAll();
        
        DefaultTableModel tableModel = (DefaultTableModel) view.getTabelaClientes().getModel();
        
        tableModel.setNumRows(0);
        
        for (Cliente cliente : selectAllParaTabela) {
            tableModel.addRow(new Object[]{
                cliente.getId_Cliente(),
                cliente.getNome_Cliente(),
                cliente.getEndereço(),
                cliente.getCep(),
                cliente.getTelefone(),
                valorCpf(cliente.getCpf())
            });
        }
    }
    
    private String valorCpf(Double valor) {
        if (valor == null) {
            return "Não Informado";
        }
        
        String valorFormatado = new DecimalFormat("#").format(valor);
        return valorFormatado;
    }
    
    public void updateCliente(Cliente cliente) throws SQLException {
        Connection conexao = new Conexao().getConnection();
        ClienteDAO clientedao = new ClienteDAO(conexao);
        clientedao.update(cliente);
        limparCampo();
    }
    
    public void excluirCliente(int id_Cliente) throws SQLException {
        Cliente cliente = new Cliente(id_Cliente);
        Connection conexao = new Conexao().getConnection();
        ClienteDAO clientedao = new ClienteDAO(conexao);
        clientedao.delete(cliente);
        limparCampo();
    }
    public void limparCampo(){
        
        view.getInsertNomeCliente().setText("Nome Completo");
        view.getInsertNomeCliente().setForeground(new Color(153, 153, 153));
        
        view.getInsertEndCliente().setText("Endereço");
        view.getInsertEndCliente().setForeground(new Color(153, 153, 153));
        
        view.getInsertCepClientes().setText("CEP");
        view.getInsertCepClientes().setForeground(new Color(153, 153, 153));
        
        view.getInsertTeleCliente().setText("Telefone");
        view.getInsertTeleCliente().setForeground(new Color(153, 153, 153));
        
        view.getInsertCPFCliente().setText("CPF");
        view.getInsertCPFCliente().setForeground(new Color(153, 153, 153));
    }
}
