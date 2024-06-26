package view;


import controller.TelaDeLoginController;
import java.sql.Connection;
import dao.Conexao;
import view.TelaDeCadastro;
import java.awt.Color;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
//
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author luizd
 */
public class TelaDeLogin extends javax.swing.JFrame {

    private final TelaDeLoginController controller;

    /**
     * Creates new form TelaDeLogin
     */
    public TelaDeLogin() {
        initComponents();
        getContentPane().setBackground(new java.awt.Color(161, 183, 198));//(204, 204, 255)
        Logar.setBackground(Color.white);
        Cadastrar.setBackground(Color.white);
        controller = new TelaDeLoginController(this);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Login = new javax.swing.JLabel();
        InsertEmail = new javax.swing.JTextField();
        InsertSenha = new javax.swing.JPasswordField();
        SeuEmail = new javax.swing.JLabel();
        SuaSenha = new javax.swing.JLabel();
        Logar = new javax.swing.JButton();
        Footer = new javax.swing.JPanel();
        Cadastrar = new javax.swing.JButton();
        SemConta = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Login");
        setAutoRequestFocus(false);
        setBackground(new java.awt.Color(255, 255, 102));
        setIconImages(null);
        setMaximizedBounds(new java.awt.Rectangle(100, 100, 0, 0));
        setSize(new java.awt.Dimension(0, 0));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Login.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        Login.setText("Login");
        getContentPane().add(Login, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 30, 100, -1));

        InsertEmail.setForeground(new java.awt.Color(153, 153, 153));
        InsertEmail.setText("Email");
        InsertEmail.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                InsertEmailFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                InsertEmailFocusLost(evt);
            }
        });
        InsertEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InsertEmailActionPerformed(evt);
            }
        });
        getContentPane().add(InsertEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 120, 300, -1));

        InsertSenha.setForeground(new java.awt.Color(153, 153, 153));
        InsertSenha.setText("Senha");
        InsertSenha.setDragEnabled(true);
        InsertSenha.setEchoChar('\u0000');
        InsertSenha.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                InsertSenhaFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                InsertSenhaFocusLost(evt);
            }
        });
        InsertSenha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InsertSenhaActionPerformed(evt);
            }
        });
        getContentPane().add(InsertSenha, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 170, 300, -1));

        SeuEmail.setText("Seu Email");
        getContentPane().add(SeuEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 100, -1, -1));

        SuaSenha.setText("Sua Senha");
        SuaSenha.setToolTipText("");
        getContentPane().add(SuaSenha, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 150, -1, -1));

        Logar.setText("Logar");
        Logar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LogarActionPerformed(evt);
            }
        });
        getContentPane().add(Logar, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 210, 300, 30));

        Footer.setBackground(new java.awt.Color(170, 195, 209));

        Cadastrar.setText("Cadastrar");
        Cadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CadastrarActionPerformed(evt);
            }
        });

        SemConta.setText("Ainda não tem conta?");
        SemConta.setToolTipText("");

        javax.swing.GroupLayout FooterLayout = new javax.swing.GroupLayout(Footer);
        Footer.setLayout(FooterLayout);
        FooterLayout.setHorizontalGroup(
            FooterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, FooterLayout.createSequentialGroup()
                .addContainerGap(185, Short.MAX_VALUE)
                .addComponent(SemConta, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Cadastrar)
                .addGap(17, 17, 17))
        );
        FooterLayout.setVerticalGroup(
            FooterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, FooterLayout.createSequentialGroup()
                .addContainerGap(21, Short.MAX_VALUE)
                .addGroup(FooterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Cadastrar)
                    .addComponent(SemConta))
                .addGap(26, 26, 26))
        );

        getContentPane().add(Footer, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 260, 420, 70));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void InsertEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InsertEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_InsertEmailActionPerformed

    private void LogarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LogarActionPerformed
        try {
            controller.autenticar();
        } catch (SQLException ex) {
            Logger.getLogger(TelaDeLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_LogarActionPerformed

    private void CadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CadastrarActionPerformed
        new TelaDeCadastro().setVisible(true);
        dispose();
    }//GEN-LAST:event_CadastrarActionPerformed

    private void InsertEmailFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_InsertEmailFocusGained
        
        if(InsertEmail.getText().equals("Email")){
        
            InsertEmail.setText("");
            InsertEmail.setForeground(new Color(0, 0, 0));
        
        }
    }//GEN-LAST:event_InsertEmailFocusGained

    private void InsertEmailFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_InsertEmailFocusLost
        
        if(InsertEmail.getText().equals("")){
        
            InsertEmail.setText("Email");
            InsertEmail.setForeground(new Color(153, 153, 153));
        
        }
        
    }//GEN-LAST:event_InsertEmailFocusLost

    private void InsertSenhaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_InsertSenhaFocusGained
        
        if(new String (InsertSenha.getPassword()).equals("Senha")){
        
            InsertSenha.setText(null);
            InsertSenha.requestFocus();
            
            InsertSenha.setEchoChar('*');
            
            InsertSenha.setForeground(new Color(0, 0, 0));
        
        }
        
    }//GEN-LAST:event_InsertSenhaFocusGained

    private void InsertSenhaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_InsertSenhaFocusLost
        
        if(new String (InsertSenha.getPassword()).equals("")){
        
            InsertSenha.setText("Senha");
            InsertSenha.setForeground(new Color(0, 0, 0));
            
        }
        if(new String(InsertSenha.getPassword()).equals("Senha")){
        
            InsertSenha.setEchoChar('\u0000');
            InsertSenha.setForeground(new Color(153, 153, 153));
            
        }
        
    }//GEN-LAST:event_InsertSenhaFocusLost

    private void InsertSenhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InsertSenhaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_InsertSenhaActionPerformed

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
            java.util.logging.Logger.getLogger(TelaDeLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaDeLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaDeLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaDeLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaDeLogin().setVisible(true);
            }
        });
    }

    public JTextField getInsertEmail() {
        return InsertEmail;
    }

    public void setInsertEmail(JTextField InsertEmail) {
        this.InsertEmail = InsertEmail;
    }

    public JPasswordField getInsertSenha() {
        return InsertSenha;
    }

    public void setInsertSenha(JPasswordField InsertSenha) {
        this.InsertSenha = InsertSenha;
    }

    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Cadastrar;
    private javax.swing.JPanel Footer;
    private javax.swing.JTextField InsertEmail;
    private javax.swing.JPasswordField InsertSenha;
    private javax.swing.JButton Logar;
    private javax.swing.JLabel Login;
    private javax.swing.JLabel SemConta;
    private javax.swing.JLabel SeuEmail;
    private javax.swing.JLabel SuaSenha;
    // End of variables declaration//GEN-END:variables

}
