/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.telas;

import br.cliente.Cliente;
import br.cliente.ClienteDAO;
import br.contasreceber.ContasReceber;
import br.contasreceber.ContasReceberDAO;
import br.contasreceber.ContasReceberTableModel;
import br.util.FormataTamanhoColunasJTable;
import br.util.Util;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Pedro Saraiva
 */
public class TelaContaPromissoria extends javax.swing.JDialog {

    public static void chamaTela(Cliente c) {
        TelaContaPromissoria.cliente = c;
        new TelaContaPromissoria().setVisible(true);
    }
    private static Cliente cliente = null;

    /**
     * Creates new form TelaContaPromissoria
     */
    public TelaContaPromissoria() {
        initComponents();
        setTitle("Contas à Receber");
        setModal(true);
        setLocationRelativeTo(null);
        preencheCliente();
        preencheTabela(new ArrayList<ContasReceber>());
        rbContasAbert.setSelected(true);
        if (cliente != null) {
            cbCliente.setSelectedItem(cliente);
            cbCliente.setEnabled(false);
            rbContasAbert.setEnabled(false);
            rbContasPagas.setEnabled(false);
            btPesquisarActionPerformed(null);
        }

    }

    public void preencheCliente() {
        ClienteDAO cDAO = new ClienteDAO();
        List<Cliente> cList = cDAO.list();
        Collections.sort(cList);
        for (Cliente c : cList) {
            cbCliente.addItem(c);
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

        btContas = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        cbCliente = new javax.swing.JComboBox();
        btPesquisar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbContas = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lblVencer1 = new javax.swing.JLabel();
        btReceber = new javax.swing.JButton();
        rbContasAbert = new javax.swing.JRadioButton();
        rbContasPagas = new javax.swing.JRadioButton();
        btEdit = new javax.swing.JButton();
        btNovo3 = new javax.swing.JButton();
        btRemover = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        cbCliente.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        cbCliente.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "--" }));
        cbCliente.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                cbClienteFocusLost(evt);
            }
        });
        jPanel1.add(cbCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 20, 386, -1));

        btPesquisar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/imagens/find.png"))); // NOI18N
        btPesquisar.setToolTipText("Pesquisar");
        btPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btPesquisarActionPerformed(evt);
            }
        });
        jPanel1.add(btPesquisar, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 10, 40, -1));

        tbContas.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        tbContas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tbContas);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 660, 190));

        jLabel2.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel2.setText("Cliente.: *");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, -1));

        jLabel4.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel4.setText("Valor Débito.: ");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 290, -1, -1));

        lblVencer1.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        lblVencer1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblVencer1.setText("0,00");
        jPanel1.add(lblVencer1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 290, 80, -1));

        btReceber.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/imagens/valuetotal.png"))); // NOI18N
        btReceber.setToolTipText("Receber Conta");
        btReceber.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btReceberActionPerformed(evt);
            }
        });
        jPanel1.add(btReceber, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 290, 43, -1));

        btContas.add(rbContasAbert);
        rbContasAbert.setText("Contas em Aberto");
        rbContasAbert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbContasAbertActionPerformed(evt);
            }
        });
        jPanel1.add(rbContasAbert, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 50, -1, -1));

        btContas.add(rbContasPagas);
        rbContasPagas.setText("Contas Pagas");
        rbContasPagas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbContasPagasActionPerformed(evt);
            }
        });
        jPanel1.add(rbContasPagas, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 50, -1, -1));

        btEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/imagens/pen.png"))); // NOI18N
        btEdit.setToolTipText("Editar Conta");
        btEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEditActionPerformed(evt);
            }
        });
        jPanel1.add(btEdit, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 290, 43, -1));

        btNovo3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/imagens/new.png"))); // NOI18N
        btNovo3.setToolTipText("Nova Conta");
        btNovo3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btNovo3ActionPerformed(evt);
            }
        });
        jPanel1.add(btNovo3, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 290, 43, -1));

        btRemover.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/imagens/delete.png"))); // NOI18N
        btRemover.setToolTipText("Excluir Conta");
        btRemover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btRemoverActionPerformed(evt);
            }
        });
        jPanel1.add(btRemover, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 290, 43, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 680, 360));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cbClienteFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cbClienteFocusLost

    }//GEN-LAST:event_cbClienteFocusLost

    private void preencheTabela(List<ContasReceber> contas) {
        Collections.sort(contas);
        ContasReceberTableModel crtm = new ContasReceberTableModel(contas);
        tbContas.setModel(crtm);
        FormataTamanhoColunasJTable.packColumns(tbContas, 1);
        tbContas.setAutoCreateRowSorter(true);
        double valorDebito = 0, valorPago = 0;
        for (ContasReceber conta : contas) {
            valorDebito += conta.getValor();
            valorPago += conta.getValorPago();
        }
        if (rbContasAbert.isSelected()) {
            jLabel4.setText("Valor Débito.: ");
            lblVencer1.setText(Util.acertarNumero(valorDebito));
        } else {
            jLabel4.setText("Valor Pago.: ");
            lblVencer1.setText(Util.acertarNumero(valorPago));

        }
        btReceber.setEnabled(rbContasAbert.isSelected());
        btEdit.setEnabled(rbContasAbert.isSelected());
        btRemover.setEnabled(rbContasAbert.isSelected());
        if (contas.size() == 0) {
            btReceber.setEnabled(false);
            btEdit.setEnabled(false);
            btRemover.setEnabled(false);
        }
        tbContas.setAutoCreateRowSorter(true);
    }

    private void btPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btPesquisarActionPerformed
        if (cbCliente.getSelectedIndex() != 0) {
            ContasReceberDAO crDAO = new ContasReceberDAO();
            preencheTabela(crDAO.listaContasCliente((Cliente) cbCliente.getSelectedItem(), rbContasPagas.isSelected()));

        } else {
            JOptionPane.showMessageDialog(rootPane, "Informe o Cliente!");
        }
    }//GEN-LAST:event_btPesquisarActionPerformed

    private void btReceberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btReceberActionPerformed
        if (Util.verificaPermissao("RECEBER_CONTA_RECEBER", 1)) {
            int row = tbContas.getSelectedRow();
            Object o;
            if (row > -1) { //então tem ítem selecionado
                o = tbContas.getValueAt(row, 0);
                ContasReceberDAO crDAO = new ContasReceberDAO();
                String s = String.valueOf(o);
                ContasReceber cr = crDAO.checkExists("id", Integer.valueOf(s)).get(0);
                if (!cr.isPaga()) {
                    TelaContaPromissoriaRec.chamaTela(cr);
                    btPesquisarActionPerformed(evt);
                } else {
                    JOptionPane.showMessageDialog(rootPane, "Conta Recebida!");
                }

            } else {
                JOptionPane.showMessageDialog(rootPane, "Selecione o Ítem!",
                        "ERRO", JOptionPane.ERROR_MESSAGE);
            }

        }
    }//GEN-LAST:event_btReceberActionPerformed

    private void rbContasPagasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbContasPagasActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_rbContasPagasActionPerformed

    private void btEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEditActionPerformed
        if (Util.verificaPermissao("EDITAR_CONTA_RECEBER", 1)) {
            int row = tbContas.getSelectedRow();
            Object o;
            if (row > -1) { //então tem ítem selecionado
                o = tbContas.getValueAt(row, 0);
                ContasReceberDAO crDAO = new ContasReceberDAO();
                String s = String.valueOf(o);
                ContasReceber cr = crDAO.checkExists("id", Integer.valueOf(s)).get(0);
                if (!cr.isPaga()) {
                    TelaContaPromissoriaCad.chamaEdita(cr);
                    btPesquisarActionPerformed(evt);
                } else {
                    JOptionPane.showMessageDialog(rootPane, "Conta Recebida!");
                }
            } else {
                JOptionPane.showMessageDialog(rootPane, "Selecione o Ítem!",
                        "ERRO", JOptionPane.ERROR_MESSAGE);
            }

        }
    }//GEN-LAST:event_btEditActionPerformed

    private void btNovo3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btNovo3ActionPerformed
        if (Util.verificaPermissao("ADICIONA_CONTA_RECEBER", 1)) {
            TelaContaPromissoriaCad tcpc = new TelaContaPromissoriaCad();
            tcpc.setVisible(true);
            btPesquisarActionPerformed(evt);
        }
    }//GEN-LAST:event_btNovo3ActionPerformed

    private void rbContasAbertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbContasAbertActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_rbContasAbertActionPerformed

    private void btRemoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btRemoverActionPerformed
        if (Util.verificaPermissao("EXCLUIR_CONTA_RECEBER", 1)) {
            int row = tbContas.getSelectedRow();
            Object o;
            if (row > -1) { //então tem ítem selecionado
                o = tbContas.getValueAt(row, 0);
                ContasReceberDAO crDAO = new ContasReceberDAO();
                String s = String.valueOf(o);
                ContasReceber cr = crDAO.checkExists("id", Integer.valueOf(s)).get(0);
                if (!cr.isPaga()) {
                    if (JOptionPane.showConfirmDialog(rootPane, "Deseja Excluir a conta selecionada?", "EXCLUIR",
                            JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                        crDAO.remove(cr);
                        btPesquisarActionPerformed(evt);
                    }
                } else {
                    JOptionPane.showMessageDialog(rootPane, "Conta Recebida!");
                }
            } else {
                JOptionPane.showMessageDialog(rootPane, "Selecione o Ítem!",
                        "ERRO", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_btRemoverActionPerformed

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
            java.util.logging.Logger.getLogger(TelaContaPromissoria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaContaPromissoria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaContaPromissoria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaContaPromissoria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaContaPromissoria().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup btContas;
    private javax.swing.JButton btEdit;
    private javax.swing.JButton btNovo3;
    private javax.swing.JButton btPesquisar;
    private javax.swing.JButton btReceber;
    private javax.swing.JButton btRemover;
    private javax.swing.JComboBox cbCliente;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblVencer1;
    private javax.swing.JRadioButton rbContasAbert;
    private javax.swing.JRadioButton rbContasPagas;
    private javax.swing.JTable tbContas;
    // End of variables declaration//GEN-END:variables
}
