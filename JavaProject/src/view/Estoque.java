/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import controller.EstoqueController;
import java.awt.Color;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import model.Item_Estoque;

/**
 *
 * @author bielg
 */
public class Estoque extends javax.swing.JFrame {

    private final EstoqueController controller;
    private int selectedId;
    /**
     * Creates new form TelaDeEstoque
     */
    public Estoque() {
        initComponents();
        getContentPane().setBackground(new java.awt.Color(161, 183, 198));
        btnAdicionar.setBackground(Color.white);
        btnAlterar.setBackground(Color.white);
        btnExcluir.setBackground(Color.white);
        
        controller = new EstoqueController(this);
        
        try {
            controller.adicionarATabela(TabelaEstoque);
        } catch (SQLException ex) {
            Logger.getLogger(Estoque.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        InsertNomeProduto = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        InsertPrecoProduto = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        InsertQtdProduto = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        InsertModeloProduto = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        btnAdicionar = new javax.swing.JButton();
        btnAlterar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        TabelaEstoque = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        InsertFornecedorProduto = new javax.swing.JTextField();
        VoltarTela = new javax.swing.JLabel();
        mostraId = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Estoque");

        jLabel1.setFont(new java.awt.Font("Arial Black", 1, 24)); // NOI18N
        jLabel1.setText("CADASTRO DE ESTOQUE");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Nome:");

        InsertNomeProduto.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        InsertNomeProduto.setForeground(new java.awt.Color(153, 153, 153));
        InsertNomeProduto.setText("Nome");
        InsertNomeProduto.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                InsertNomeProdutoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                InsertNomeProdutoFocusLost(evt);
            }
        });
        InsertNomeProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InsertNomeProdutoActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("Preço:");

        InsertPrecoProduto.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        InsertPrecoProduto.setForeground(new java.awt.Color(153, 153, 153));
        InsertPrecoProduto.setText("Preço");
        InsertPrecoProduto.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                InsertPrecoProdutoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                InsertPrecoProdutoFocusLost(evt);
            }
        });
        InsertPrecoProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InsertPrecoProdutoActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setText("Quantidade:");

        InsertQtdProduto.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        InsertQtdProduto.setForeground(new java.awt.Color(153, 153, 153));
        InsertQtdProduto.setText("Quantidade");
        InsertQtdProduto.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                InsertQtdProdutoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                InsertQtdProdutoFocusLost(evt);
            }
        });
        InsertQtdProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InsertQtdProdutoActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setText("Modelo:");

        InsertModeloProduto.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        InsertModeloProduto.setForeground(new java.awt.Color(153, 153, 153));
        InsertModeloProduto.setText("Modelo");
        InsertModeloProduto.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                InsertModeloProdutoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                InsertModeloProdutoFocusLost(evt);
            }
        });
        InsertModeloProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InsertModeloProdutoActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Arial Black", 1, 20)); // NOI18N
        jLabel2.setText("TABELA DE ESTOQUE");

        btnAdicionar.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 12)); // NOI18N
        btnAdicionar.setText("Adicionar");
        btnAdicionar.setAlignmentY(0.0F);
        btnAdicionar.setBorder(null);
        btnAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdicionarActionPerformed(evt);
            }
        });

        btnAlterar.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 12)); // NOI18N
        btnAlterar.setText("Alterar");
        btnAlterar.setAlignmentY(0.0F);
        btnAlterar.setBorder(null);
        btnAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterarActionPerformed(evt);
            }
        });

        btnExcluir.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 12)); // NOI18N
        btnExcluir.setText("Excluir");
        btnExcluir.setAlignmentY(0.0F);
        btnExcluir.setBorder(null);
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        TabelaEstoque.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Id_item", "Nome", "Modelo", "Fornecedor", "Valor", "Qtd"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TabelaEstoque.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TabelaEstoqueMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(TabelaEstoque);

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setText("Fornecedor:");

        InsertFornecedorProduto.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        InsertFornecedorProduto.setForeground(new java.awt.Color(153, 153, 153));
        InsertFornecedorProduto.setText("Fornecedor");
        InsertFornecedorProduto.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                InsertFornecedorProdutoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                InsertFornecedorProdutoFocusLost(evt);
            }
        });
        InsertFornecedorProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InsertFornecedorProdutoActionPerformed(evt);
            }
        });

        VoltarTela.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/left-arrow-alt-regular-48.png"))); // NOI18N
        VoltarTela.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                VoltarTelaMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(94, 94, 94)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(InsertNomeProduto)
                            .addComponent(InsertQtdProduto)
                            .addComponent(InsertModeloProduto)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8)
                            .addComponent(InsertFornecedorProduto)
                            .addComponent(InsertPrecoProduto)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(VoltarTela, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 63, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(btnAdicionar, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 805, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(89, 89, 89))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(mostraId, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(165, 165, 165))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(32, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(mostraId, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAdicionar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(34, 34, 34))
            .addGroup(layout.createSequentialGroup()
                .addComponent(VoltarTela, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(jLabel3)
                .addGap(4, 4, 4)
                .addComponent(InsertNomeProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addGap(5, 5, 5)
                .addComponent(InsertModeloProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8)
                .addGap(5, 5, 5)
                .addComponent(InsertFornecedorProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(InsertPrecoProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addGap(5, 5, 5)
                .addComponent(InsertQtdProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getAccessibleContext().setAccessibleName("Estoque");

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void InsertNomeProdutoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_InsertNomeProdutoFocusGained

        if(InsertNomeProduto.getText().equals("Nome")){

            InsertNomeProduto.setText("");
            InsertNomeProduto.setForeground(new Color(0, 0, 0));

        }
    }//GEN-LAST:event_InsertNomeProdutoFocusGained

    private void InsertNomeProdutoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_InsertNomeProdutoFocusLost

        if(InsertNomeProduto.getText().equals("")){

            InsertNomeProduto.setText("Nome");
            InsertNomeProduto.setForeground(new Color(153, 153, 153));

        }
    }//GEN-LAST:event_InsertNomeProdutoFocusLost

    private void InsertNomeProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InsertNomeProdutoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_InsertNomeProdutoActionPerformed

    private void InsertPrecoProdutoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_InsertPrecoProdutoFocusGained

        if(InsertPrecoProduto.getText().equals("Preço")){

            InsertPrecoProduto.setText("");
            InsertPrecoProduto.setForeground(new Color(0, 0, 0));

        }
    }//GEN-LAST:event_InsertPrecoProdutoFocusGained

    private void InsertPrecoProdutoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_InsertPrecoProdutoFocusLost

        if(InsertPrecoProduto.getText().equals("")){

            InsertPrecoProduto.setText("Preço");
            InsertPrecoProduto.setForeground(new Color(153, 153, 153));

        }
    }//GEN-LAST:event_InsertPrecoProdutoFocusLost

    private void InsertPrecoProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InsertPrecoProdutoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_InsertPrecoProdutoActionPerformed

    private void InsertQtdProdutoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_InsertQtdProdutoFocusGained
        if(InsertQtdProduto.getText().equals("Quantidade")){

            InsertQtdProduto.setText("");
            InsertQtdProduto.setForeground(new Color(0, 0, 0));

        }
    }//GEN-LAST:event_InsertQtdProdutoFocusGained

    private void InsertQtdProdutoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_InsertQtdProdutoFocusLost
        if(InsertQtdProduto.getText().equals("")){

            InsertQtdProduto.setText("Quantidade");
            InsertQtdProduto.setForeground(new Color(153, 153, 153));

        }
    }//GEN-LAST:event_InsertQtdProdutoFocusLost

    private void InsertQtdProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InsertQtdProdutoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_InsertQtdProdutoActionPerformed

    private void InsertModeloProdutoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_InsertModeloProdutoFocusGained
        if(InsertModeloProduto.getText().equals("Modelo")){

            InsertModeloProduto.setText("");
            InsertModeloProduto.setForeground(new Color(0, 0, 0));

        }
    }//GEN-LAST:event_InsertModeloProdutoFocusGained

    private void InsertModeloProdutoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_InsertModeloProdutoFocusLost
        if(InsertModeloProduto.getText().equals("")){

            InsertModeloProduto.setText("Modelo");
            InsertModeloProduto.setForeground(new Color(153, 153, 153));

        }
    }//GEN-LAST:event_InsertModeloProdutoFocusLost

    private void InsertModeloProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InsertModeloProdutoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_InsertModeloProdutoActionPerformed

    private void btnAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionarActionPerformed
        
        try {
            controller.SalvarEstoque();
            controller.adicionarATabela(TabelaEstoque);
        } catch (SQLException ex) {
            Logger.getLogger(Estoque.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_btnAdicionarActionPerformed

    private void btnAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarActionPerformed
        DefaultTableModel model = (DefaultTableModel) TabelaEstoque.getModel();
        int selectedRowIndex = TabelaEstoque.getSelectedRow();

        if (selectedRowIndex != -1) { // Verifica se uma linha está selecionada
            int id = (int) model.getValueAt(selectedRowIndex, 0);
            String nome = InsertNomeProduto.getText();
            String modelo = InsertModeloProduto.getText();
            String fornecedor = InsertFornecedorProduto.getText();
            double valor = Double.parseDouble(InsertPrecoProduto.getText());
            int qtd = Integer.parseInt(InsertQtdProduto.getText());

            Item_Estoque item_estoque = new Item_Estoque(id, nome, modelo, fornecedor, valor, qtd);

            try {
                controller.updateDoEstoque(item_estoque);
                controller.adicionarATabela(TabelaEstoque);
            } catch (SQLException ex) {
                Logger.getLogger(Estoque.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Selecione uma linha para editar.");
        }
        
    }//GEN-LAST:event_btnAlterarActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        try {
            controller.excluirDoEstoque(selectedId);
            controller.adicionarATabela(TabelaEstoque);
        } catch (SQLException ex) {
            Logger.getLogger(Estoque.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void InsertFornecedorProdutoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_InsertFornecedorProdutoFocusGained
        if(InsertFornecedorProduto.getText().equals("Fornecedor")){

            InsertFornecedorProduto.setText("");
            InsertFornecedorProduto.setForeground(new Color(0, 0, 0));

        }
    }//GEN-LAST:event_InsertFornecedorProdutoFocusGained

    private void InsertFornecedorProdutoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_InsertFornecedorProdutoFocusLost
        if(InsertFornecedorProduto.getText().equals("")){

            InsertFornecedorProduto.setText("Fornecedor");
            InsertFornecedorProduto.setForeground(new Color(153, 153, 153));

        }
    }//GEN-LAST:event_InsertFornecedorProdutoFocusLost

    private void InsertFornecedorProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InsertFornecedorProdutoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_InsertFornecedorProdutoActionPerformed

    private void VoltarTelaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_VoltarTelaMouseClicked

        new TelaDeMenu().setVisible(true);

        dispose();
        
    }//GEN-LAST:event_VoltarTelaMouseClicked

    private void TabelaEstoqueMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TabelaEstoqueMouseClicked
       
        DefaultTableModel model = (DefaultTableModel)TabelaEstoque.getModel();
        int selectedRowIndex = TabelaEstoque.getSelectedRow();
        
        selectedId = (int) model.getValueAt(selectedRowIndex, 0);
        
        InsertNomeProduto.setText(model.getValueAt(selectedRowIndex, 1).toString());
        InsertModeloProduto.setText(model.getValueAt(selectedRowIndex, 2).toString());
        InsertFornecedorProduto.setText(model.getValueAt(selectedRowIndex, 3).toString());
        InsertPrecoProduto.setText(model.getValueAt(selectedRowIndex, 4).toString());
        InsertQtdProduto.setText(model.getValueAt(selectedRowIndex, 5).toString());
         
        mostraId.setText("Id Selecionado: " + selectedId);
        
    }//GEN-LAST:event_TabelaEstoqueMouseClicked

    public JTable getTabelaEstoque() {
        return TabelaEstoque;
    }

    public void setTabelaEstoque(JTable TabelaEstoque) {
        this.TabelaEstoque = TabelaEstoque;
    }

    public JTextField getInsertFornecedorProduto() {
        return InsertFornecedorProduto;
    }

    public void setInsertFornecedorProduto(JTextField InsertFornecedorProduto) {
        this.InsertFornecedorProduto = InsertFornecedorProduto;
    }

    public JTextField getInsertModeloProduto() {
        return InsertModeloProduto;
    }

    public void setInsertModeloProduto(JTextField InsertModeloProduto) {
        this.InsertModeloProduto = InsertModeloProduto;
    }

    public JTextField getInsertNomeProduto() {
        return InsertNomeProduto;
    }

    public void setInsertNomeProduto(JTextField InsertNomeProduto) {
        this.InsertNomeProduto = InsertNomeProduto;
    }

    public JTextField getInsertPrecoProduto() {
        return InsertPrecoProduto;
    }

    public void setInsertPrecoProduto(JTextField InsertPrecoProduto) {
        this.InsertPrecoProduto = InsertPrecoProduto;
    }

    public JTextField getInsertQtdProduto() {
        return InsertQtdProduto;
    }

    public void setInsertQtdProduto(JTextField InsertQtdProduto) {
        this.InsertQtdProduto = InsertQtdProduto;
    }
    
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Estoque.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Estoque.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Estoque.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Estoque.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Estoque().setVisible(true);
            }
        });
    }

    private void initComponents1() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField InsertFornecedorProduto;
    private javax.swing.JTextField InsertModeloProduto;
    private javax.swing.JTextField InsertNomeProduto;
    private javax.swing.JTextField InsertPrecoProduto;
    private javax.swing.JTextField InsertQtdProduto;
    private javax.swing.JTable TabelaEstoque;
    private javax.swing.JLabel VoltarTela;
    private javax.swing.JButton btnAdicionar;
    private javax.swing.JButton btnAlterar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JLabel mostraId;
    // End of variables declaration//GEN-END:variables
}
