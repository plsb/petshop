/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.telas;

import br.cliente.*;
import br.contabancaria.ContaBancaria;
import br.contabancaria.ContaBancariaDAO;
import br.contabancaria.ContaBancariaTableModel;
import br.fornecedor.Fornecedor;
import br.fornecedor.FornecedorDAO;
import br.fornecedor.FornecedorTableModel;
import br.util.Ativo;
import br.util.Util;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Pedro Saraiva
 */
public class TelaContaBancaria extends javax.swing.JDialog {

    /**
     * Creates new form TelaCliente
     */
    public TelaContaBancaria() {
        initComponents();
        setModal(true);
        setLocationRelativeTo(null);
        setTitle("Adiciona/Edita Conta Bancária");
        limpaCampos();

    }

    private ContaBancaria conta;
    private ContaBancariaDAO dao = new ContaBancariaDAO();

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel4 = new javax.swing.JPanel();
        lbTexto = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        btDelete = new javax.swing.JButton();
        btCancelar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        tfDescricao = new javax.swing.JTextField();
        tfNumero = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        btSalvar = new javax.swing.JButton();
        btNovo = new javax.swing.JButton();
        btPesquisar1 = new javax.swing.JButton();
        cbTipo = new javax.swing.JComboBox();
        jLabel29 = new javax.swing.JLabel();
        tfAgencia = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        cbBanco = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setBackground(new java.awt.Color(0, 153, 255));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbTexto.setFont(new java.awt.Font("Verdana", 1, 30)); // NOI18N
        lbTexto.setText("Conta Bancária");
        jPanel4.add(lbTexto, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 260, 40));

        getContentPane().add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 320, 40));

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
        jPanel1.add(btDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 240, 43, 40));

        btCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/imagens/close.png"))); // NOI18N
        btCancelar.setToolTipText("Sair");
        btCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCancelarActionPerformed(evt);
            }
        });
        jPanel1.add(btCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 240, 43, 41));

        jLabel1.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel1.setText("Descrição.: *");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, -1));

        tfDescricao.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jPanel1.add(tfDescricao, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 290, -1));

        tfNumero.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jPanel1.add(tfNumero, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 120, -1));

        jLabel3.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel3.setText("Número.: *");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, -1, -1));

        btSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/imagens/pataverde.png"))); // NOI18N
        btSalvar.setToolTipText("Salvar");
        btSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSalvarActionPerformed(evt);
            }
        });
        jPanel1.add(btSalvar, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 240, 43, -1));

        btNovo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/imagens/new.png"))); // NOI18N
        btNovo.setToolTipText("Novor");
        btNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btNovoActionPerformed(evt);
            }
        });
        jPanel1.add(btNovo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 240, 43, -1));

        btPesquisar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/imagens/find.png"))); // NOI18N
        btPesquisar1.setToolTipText("Pesquisar");
        btPesquisar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btPesquisar1ActionPerformed(evt);
            }
        });
        jPanel1.add(btPesquisar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 240, 43, 40));

        cbTipo.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        cbTipo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "--", "Corrente", "Poupança" }));
        jPanel1.add(cbTipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, 290, -1));

        jLabel29.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel29.setText("Tipo.: *");
        jPanel1.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, -1, -1));

        tfAgencia.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jPanel1.add(tfAgencia, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 90, 160, -1));

        jLabel4.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel4.setText("Agência.: *");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 70, -1, -1));

        jLabel30.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel30.setText("Banco.: *");
        jPanel1.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, -1, -1));

        cbBanco.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        cbBanco.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "--", "Brasil", "Bradesco", "CAIXA", "Santander" }));
        jPanel1.add(cbBanco, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, 290, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 320, 290));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btDeleteActionPerformed
        if (Util.verificaPermissao("CE_CONTA_BANCARIA", 1)) {
            if (JOptionPane.showConfirmDialog(rootPane, "Deseja Excluir a Conta Bancária?", "", JOptionPane.YES_NO_OPTION,
                    JOptionPane.INFORMATION_MESSAGE) == JOptionPane.YES_OPTION) {
                dao.remove(conta);
                limpaCampos();
            }
        }
    }//GEN-LAST:event_btDeleteActionPerformed

    private void btCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelarActionPerformed
        setVisible(false);
    }//GEN-LAST:event_btCancelarActionPerformed

    private void btSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSalvarActionPerformed
        if (Util.verificaPermissao("CE_FORNECEDOR", 1)) {

            if (conta == null) {
                conta = new ContaBancaria();
            }
            if (Util.chkVazio(tfDescricao.getText(), tfAgencia.getText(), tfNumero.getText(), 
                    cbTipo.getSelectedItem().toString(), cbBanco.getSelectedItem().toString())) {

                conta.setNumero(tfNumero.getText());
                conta.setTipo(cbTipo.getSelectedItem().toString());
                conta.setAgencia(tfAgencia.getText());
                conta.setDescricao(tfDescricao.getText());
                conta.setBanco(cbBanco.getSelectedItem().toString());


                if (conta.getId() == null) {
                    
                    dao.add(conta);
                    JOptionPane.showMessageDialog(rootPane, "Conta Cadastrada Com Sucesso!", "INFO", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    dao.update(conta);
                    JOptionPane.showMessageDialog(rootPane, "Conta Editada Com Sucesso!", "INFO", JOptionPane.INFORMATION_MESSAGE);
                }
                limpaCampos();
            }
        }
    }//GEN-LAST:event_btSalvarActionPerformed

    private void btNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btNovoActionPerformed
        limpaCampos();

    }//GEN-LAST:event_btNovoActionPerformed

    private void limpaCampos() {

        conta = new ContaBancaria();
        tfNumero.setText("");
        tfDescricao.setText("");
        tfAgencia.setText("");
        cbTipo.setSelectedIndex(0);
        cbBanco.setSelectedIndex(0);
        btDelete.setEnabled(false);
        tfDescricao.requestFocus();
    }

    private void btPesquisar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btPesquisar1ActionPerformed
        List<ContaBancaria> lista = (!(tfDescricao.getText().equals("")) ? dao.checkExists("descricao", tfDescricao.getText()) : dao.list());
        ContaBancariaTableModel stm = new ContaBancariaTableModel(lista);
        Object o = TelaPesquisa.exibeTela(stm, "Fornecedores");
        if (o != null) {
            conta = new ContaBancaria();
            conta = dao.checkExists("id", Integer.valueOf(String.valueOf(o))).get(0);
            tfDescricao.setText(conta.getDescricao());
            tfAgencia.setText(conta.getAgencia());
            tfNumero.setText(conta.getNumero());
            cbTipo.setSelectedItem(conta.getTipo());
            cbBanco.setSelectedItem(conta.getBanco());

            btDelete.setEnabled(true);

        }

    }//GEN-LAST:event_btPesquisar1ActionPerformed

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
            java.util.logging.Logger.getLogger(TelaContaBancaria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaContaBancaria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaContaBancaria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaContaBancaria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaContaBancaria().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btCancelar;
    private javax.swing.JButton btDelete;
    private javax.swing.JButton btNovo;
    private javax.swing.JButton btPesquisar1;
    private javax.swing.JButton btSalvar;
    private javax.swing.JComboBox cbBanco;
    private javax.swing.JComboBox cbTipo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JLabel lbTexto;
    private javax.swing.JTextField tfAgencia;
    private javax.swing.JTextField tfDescricao;
    private javax.swing.JTextField tfNumero;
    // End of variables declaration//GEN-END:variables
}