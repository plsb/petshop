/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.telas;

import br.cliente.*;
import br.usuario.Usuario;
import br.usuario.UsuarioDAO;
import br.usuario.UsuarioTableModel;
import br.util.Util;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Pedro Saraiva
 */
public class TelaUsuario extends javax.swing.JDialog {

    /**
     * Creates new form TelaCliente
     */
    public TelaUsuario() {
        initComponents();
        setModal(true);
        setLocationRelativeTo(null);
        setTitle("Adiciona/Edita Usuário");
        ckAtivo.setSelected(true);
        limpaCampos();

    }

    private Usuario usuario;
    private UsuarioDAO dao = new UsuarioDAO();

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        sexo = new javax.swing.ButtonGroup();
        jPanel4 = new javax.swing.JPanel();
        lbTexto = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        btDelete = new javax.swing.JButton();
        btCancelar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        tfNome = new javax.swing.JTextField();
        tfLogin = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        btSalvar = new javax.swing.JButton();
        btNovo = new javax.swing.JButton();
        btPesquisar1 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        ckAdministrador = new javax.swing.JCheckBox();
        tfConfirmarSenha = new javax.swing.JPasswordField();
        tfSenha = new javax.swing.JPasswordField();
        ckAtivo = new javax.swing.JCheckBox();
        lblPermissoes = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setBackground(new java.awt.Color(0, 153, 255));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbTexto.setFont(new java.awt.Font("Verdana", 1, 30)); // NOI18N
        lbTexto.setText("Usuário");
        jPanel4.add(lbTexto, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 210, 40));

        getContentPane().add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 430, 40));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/imagens/delete.png"))); // NOI18N
        btDelete.setToolTipText("Excluir");
        btDelete.setEnabled(false);
        btDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btDeleteActionPerformed(evt);
            }
        });
        jPanel1.add(btDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 220, 43, 40));

        btCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/imagens/close.png"))); // NOI18N
        btCancelar.setToolTipText("Sair");
        btCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCancelarActionPerformed(evt);
            }
        });
        jPanel1.add(btCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 220, 43, 41));

        jLabel1.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel1.setText("Nome.: *");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, -1));

        tfNome.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jPanel1.add(tfNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 400, -1));

        tfLogin.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jPanel1.add(tfLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 400, -1));

        jLabel3.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel3.setText("Login.: *");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, -1, -1));

        btSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/imagens/pataverde.png"))); // NOI18N
        btSalvar.setToolTipText("Salvar");
        btSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSalvarActionPerformed(evt);
            }
        });
        jPanel1.add(btSalvar, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 220, 43, -1));

        btNovo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/imagens/new.png"))); // NOI18N
        btNovo.setToolTipText("Novor");
        btNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btNovoActionPerformed(evt);
            }
        });
        jPanel1.add(btNovo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, 43, -1));

        btPesquisar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/imagens/find.png"))); // NOI18N
        btPesquisar1.setToolTipText("Pesquisar");
        btPesquisar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btPesquisar1ActionPerformed(evt);
            }
        });
        jPanel1.add(btPesquisar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 220, 43, 40));

        jLabel6.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel6.setText("Senha.: *");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, -1, -1));

        jLabel7.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel7.setText("Confirmar Senha.: *");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, -1, -1));

        ckAdministrador.setBackground(new java.awt.Color(255, 255, 255));
        ckAdministrador.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        ckAdministrador.setText("Administrador?");
        ckAdministrador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ckAdministradorActionPerformed(evt);
            }
        });
        jPanel1.add(ckAdministrador, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 140, -1, -1));

        tfConfirmarSenha.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jPanel1.add(tfConfirmarSenha, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, 230, -1));

        tfSenha.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jPanel1.add(tfSenha, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, 230, -1));

        ckAtivo.setBackground(new java.awt.Color(255, 255, 255));
        ckAtivo.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        ckAtivo.setText("Ativo");
        ckAtivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ckAtivoActionPerformed(evt);
            }
        });
        jPanel1.add(ckAtivo, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 10, -1, -1));

        lblPermissoes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/imagens/reporting.png"))); // NOI18N
        lblPermissoes.setText("Permissões");
        lblPermissoes.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblPermissoes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblPermissoesMouseClicked(evt);
            }
        });
        jPanel1.add(lblPermissoes, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 180, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 430, 270));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btDeleteActionPerformed
        if(JOptionPane.showConfirmDialog(rootPane, "Deseja Excluir o Usuário?", "", JOptionPane.YES_NO_OPTION, 
                JOptionPane.INFORMATION_MESSAGE)==JOptionPane.YES_OPTION){
            dao.remove(usuario);
            limpaCampos();
        }
    }//GEN-LAST:event_btDeleteActionPerformed

    private void btCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelarActionPerformed
        setVisible(false);
    }//GEN-LAST:event_btCancelarActionPerformed

    private void btSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSalvarActionPerformed
        if (usuario == null) {
            usuario = new Usuario();
        }
        if (Util.chkVazio(tfNome.getText(), tfLogin.getText(), tfConfirmarSenha.getText(),
                tfConfirmarSenha.getText())) {
            if(!tfConfirmarSenha.getText().equals(tfConfirmarSenha.getText())){
                JOptionPane.showMessageDialog(null, "Senha confirmada incorretamente! ");
                tfConfirmarSenha.requestFocus();
                return ;
            }           
            
            usuario.setAdministrador(ckAdministrador.isSelected());
            usuario.setLogin(tfLogin.getText());
            usuario.setNome(tfNome.getText());
            usuario.setSenha(tfConfirmarSenha.getText());
            usuario.setAtivo(ckAtivo.isSelected());
            
            if(usuario.getId()==null){
                if (dao.checkExists("login", tfLogin.getText()).size() > 0) {
                    JOptionPane.showMessageDialog(rootPane, "Login já informado!", "ERRO", JOptionPane.ERROR_MESSAGE);
                    tfLogin.requestFocus();
                    return;
                }
                
                dao.add(usuario);
                JOptionPane.showMessageDialog(rootPane, "Usuário Cadastrado Com Sucesso!", "INFO", JOptionPane.INFORMATION_MESSAGE);
            } else {
                dao.update(usuario);
                JOptionPane.showMessageDialog(rootPane, "Usuário Editado Com Sucesso!", "INFO",JOptionPane.INFORMATION_MESSAGE);
            }
            limpaCampos();
        } 
    }//GEN-LAST:event_btSalvarActionPerformed

    private void btNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btNovoActionPerformed
        limpaCampos();
        
    }//GEN-LAST:event_btNovoActionPerformed

    private void limpaCampos(){
        ckAdministrador.setSelected(false);
        usuario = new Usuario();
        tfConfirmarSenha.setText("");
        tfLogin.setText("");
        tfNome.setText("");
        tfSenha.setText("");
        tfConfirmarSenha.setText("");
        ckAtivo.setSelected(true);
        btDelete.setEnabled(false);
        lblPermissoes.setVisible(false);
        tfNome.requestFocus();
        
    }
    
    private void btPesquisar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btPesquisar1ActionPerformed
        List<Usuario> lista = (!(tfNome.getText().equals("")) ? dao.checkExists("nome",tfNome.getText()) : dao.list());
        UsuarioTableModel stm = new UsuarioTableModel(lista);
        Object o = TelaPesquisa.exibeTela(stm, "Usuário");
        if (o != null) {
            usuario = new Usuario();
            usuario = dao.checkExists("id",Integer.valueOf(String.valueOf(o))).get(0);
            tfNome.setText(usuario.getNome());
            tfLogin.setText(usuario.getLogin());
            ckAdministrador.setSelected(usuario.isAdministrador());
            ckAtivo.setSelected(usuario.isAtivo());
            
            btDelete.setEnabled(true);
            lblPermissoes.setVisible(true);
            
        }
        
    }//GEN-LAST:event_btPesquisar1ActionPerformed

    private void ckAdministradorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ckAdministradorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ckAdministradorActionPerformed

    private void ckAtivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ckAtivoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ckAtivoActionPerformed

    private void lblPermissoesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblPermissoesMouseClicked
        usuario = TelaPermissoes.chamaTela(usuario);
    }//GEN-LAST:event_lblPermissoesMouseClicked

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
            java.util.logging.Logger.getLogger(TelaUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaUsuario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btCancelar;
    private javax.swing.JButton btDelete;
    private javax.swing.JButton btNovo;
    private javax.swing.JButton btPesquisar1;
    private javax.swing.JButton btSalvar;
    private javax.swing.JCheckBox ckAdministrador;
    private javax.swing.JCheckBox ckAtivo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JLabel lbTexto;
    private javax.swing.JLabel lblPermissoes;
    private javax.swing.ButtonGroup sexo;
    private javax.swing.JPasswordField tfConfirmarSenha;
    private javax.swing.JTextField tfLogin;
    private javax.swing.JTextField tfNome;
    private javax.swing.JPasswordField tfSenha;
    // End of variables declaration//GEN-END:variables
}