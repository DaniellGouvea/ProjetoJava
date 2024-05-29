/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import controller.TelaDeMenuController;
import dao.ClienteDAO;
import dao.Conexao;
import dao.PedidoDAO;
import java.awt.Color;
import java.sql.Timestamp;
import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.Cliente;

/**
 *
 * @author bielg
 */
public class TelaDeMenu extends javax.swing.JFrame {

    private final TelaDeMenuController controller;
    private int selectedId;    
    private LocalDateTime agora;
    /**
     * Creates new form TelaDeClientes
     */
    public TelaDeMenu() {
        initComponents();
        btnAdicionarItem.setBackground(Color.white);
        btnEncerrarPedido.setBackground(Color.white);
        btnInicarPedido.setBackground(Color.white);
        
        ComboBoxEstoque.setBackground(Color.white);
        
        controller = new TelaDeMenuController(this);
        try {
            controller.adicionarAoComboBox(ComboBoxEstoque);
            controller.adicionarATabela(TabelaEstoqueMenu);
        } catch (SQLException ex) {
            Logger.getLogger(TelaDeMenu.class.getName()).log(Level.SEVERE, null, ex);
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

        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        jCheckBoxMenuItem1 = new javax.swing.JCheckBoxMenuItem();
        ComboBoxEstoque = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TabelaEstoqueMenu = new javax.swing.JTable();
        btnAdicionarItem = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        TabelaPedidos = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        btnInicarPedido = new javax.swing.JButton();
        btnEncerrarPedido = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        GerenciarMenu = new javax.swing.JMenu();
        Cliente = new javax.swing.JMenuItem();
        Estoque = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();

        jMenuItem1.setText("jMenuItem1");

        jMenu1.setText("jMenu1");

        jCheckBoxMenuItem1.setSelected(true);
        jCheckBoxMenuItem1.setText("jCheckBoxMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Menu");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setMinimumSize(new java.awt.Dimension(700, 433));
        setPreferredSize(new java.awt.Dimension(680, 520));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ComboBoxEstoque.setToolTipText("");
        ComboBoxEstoque.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboBoxEstoqueActionPerformed(evt);
            }
        });
        getContentPane().add(ComboBoxEstoque, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 10, 176, -1));
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1156, 75, 170, -1));

        TabelaEstoqueMenu.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "id_item", "nome", "modelo", "fornecedor", "valor", "qtd"
            }
        ));
        TabelaEstoqueMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TabelaEstoqueMenuMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TabelaEstoqueMenu);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 110, 497, 101));

        btnAdicionarItem.setText("Adicionar Item");
        btnAdicionarItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdicionarItemActionPerformed(evt);
            }
        });
        getContentPane().add(btnAdicionarItem, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 410, -1, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel2.setText("Tabela Do Estoque");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 60, 223, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel3.setText("Tabela Do Pedido");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 230, 212, 28));

        TabelaPedidos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id_pedido", "id_ItemPedido", "Nome Produto"
            }
        ));
        jScrollPane2.setViewportView(TabelaPedidos);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 270, 497, 101));
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(431, 106, -1, -1));

        btnInicarPedido.setText("Iniciar Pedido");
        btnInicarPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInicarPedidoActionPerformed(evt);
            }
        });
        getContentPane().add(btnInicarPedido, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 10, -1, -1));

        btnEncerrarPedido.setText("Encerrar Pedido");
        btnEncerrarPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEncerrarPedidoActionPerformed(evt);
            }
        });
        getContentPane().add(btnEncerrarPedido, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 410, -1, -1));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/fundo.png"))); // NOI18N
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, -30, 1400, 740));
        jLabel5.getAccessibleContext().setAccessibleName("Menu");

        GerenciarMenu.setText("Gerenciar");
        GerenciarMenu.setToolTipText("");

        Cliente.setText("Cliente");
        Cliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ClienteActionPerformed(evt);
            }
        });
        GerenciarMenu.add(Cliente);

        Estoque.setText("Estoque");
        Estoque.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EstoqueActionPerformed(evt);
            }
        });
        GerenciarMenu.add(Estoque);

        jMenuItem2.setText("Pedidos");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        GerenciarMenu.add(jMenuItem2);

        jMenuBar1.add(GerenciarMenu);

        setJMenuBar(jMenuBar1);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void ClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ClienteActionPerformed
        new Clientes().setVisible(true);
        
        dispose();
    }//GEN-LAST:event_ClienteActionPerformed

    private void EstoqueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EstoqueActionPerformed
        new Estoque().setVisible(true);
        
        dispose();
    }//GEN-LAST:event_EstoqueActionPerformed

    private void ComboBoxEstoqueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboBoxEstoqueActionPerformed
                String selectedNome = getComboBoxEstoque().getSelectedItem().toString();
                
                
    }//GEN-LAST:event_ComboBoxEstoqueActionPerformed

    private void btnAdicionarItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionarItemActionPerformed
        //controller.adicionarPedidoAoBancoPedido();
        
        try {
            controller.adicionarItemPedidoAoBanco(true);
            controller.TesteItensPedidos();
            controller.adicionarATabelaPedidos(TabelaPedidos);
        } catch (SQLException ex) {
            Logger.getLogger(TelaDeMenu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnAdicionarItemActionPerformed

    private void TabelaEstoqueMenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TabelaEstoqueMenuMouseClicked
        //controller.adicionarItemPedidoAoBanco();
    }//GEN-LAST:event_TabelaEstoqueMenuMouseClicked

    private void btnInicarPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInicarPedidoActionPerformed
        controller.adicionarPedidoAoBancoPedido();
        controller.limparTabela(TabelaPedidos);
        //LocalDateTime agora = LocalDateTime.now();
        //controller.TestePegaPedido();
        
    }//GEN-LAST:event_btnInicarPedidoActionPerformed

    private void btnEncerrarPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEncerrarPedidoActionPerformed
        controller.adicionarPedidoAoBancoPedido();
        controller.limparTabela(TabelaPedidos);
        ComboBoxEstoque.setSelectedIndex(0);
        JOptionPane.showMessageDialog(null, "Pedido Finalizado");
    }//GEN-LAST:event_btnEncerrarPedidoActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        new ChecaPedidos().setVisible(true);
        
        dispose();
    }//GEN-LAST:event_jMenuItem2ActionPerformed

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
            java.util.logging.Logger.getLogger(TelaDeMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaDeMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaDeMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaDeMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new TelaDeMenu().setVisible(true);
            }
        });
    }

    public JComboBox<String> getComboBoxEstoque() {
        return ComboBoxEstoque;
    }

    public void setComboBoxEstoque(JComboBox<String> ComboBoxEstoque) {
        this.ComboBoxEstoque = ComboBoxEstoque;
    }

    public JTable getTabela() {
        return TabelaEstoqueMenu;
    }

    public void setTabela(JTable tabela) {
        this.TabelaEstoqueMenu = tabela;
    }

    public JTable getTabelaEstoque1() {
        return TabelaPedidos;
    }

    public void setTabelaEstoque1(JTable TabelaEstoque1) {
        this.TabelaPedidos = TabelaEstoque1;
    }

    public JTable getTabelaEstoqueMenu() {
        return TabelaEstoqueMenu;
    }

    public void setTabelaEstoqueMenu(JTable TabelaEstoqueMenu) {
        this.TabelaEstoqueMenu = TabelaEstoqueMenu;
    }

    public JTable getTabelaPedidos() {
        return TabelaPedidos;
    }

    public void setTabelaPedidos(JTable TabelaPedidos) {
        this.TabelaPedidos = TabelaPedidos;
    }

    
    
    
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem Cliente;
    private javax.swing.JComboBox<String> ComboBoxEstoque;
    private javax.swing.JMenuItem Estoque;
    private javax.swing.JMenu GerenciarMenu;
    private javax.swing.JTable TabelaEstoqueMenu;
    private javax.swing.JTable TabelaPedidos;
    private javax.swing.JButton btnAdicionarItem;
    private javax.swing.JButton btnEncerrarPedido;
    private javax.swing.JButton btnInicarPedido;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
