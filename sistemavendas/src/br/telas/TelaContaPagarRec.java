/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.telas;

import br.caixageral.CaixaGeral;
import br.caixageral.CaixaGeralDAO;
import br.contabancaria.ContaBancaria;
import br.contabancaria.ContaBancariaDAO;
import br.contabancaria.ItemContaBancaria;
import br.contabancaria.ItemContaBancariaDAO;
import br.contaspagar.ContasPagar;
import br.contaspagar.ContasPagarDAO;
import br.contasreceber.ContasReceber;
import br.contasreceber.ContasReceberDAO;
import br.livro.LivroCaixa;
import br.livro.LivroCaixaDAO;
import br.util.Ativo;
import br.util.Util;
import java.awt.event.KeyEvent;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author Pedro Saraiva
 */
public class TelaContaPagarRec extends javax.swing.JDialog {

    private static ContasPagar cr;

    /**
     * Creates new form TelaCliente
     */
    public TelaContaPagarRec(ContasPagar cr) {
        initComponents();
        this.cr = cr;
        setModal(true);
        setTitle("Receber Conta");
        setLocationRelativeTo(null);
        lblCliente.setText(cr.getFornecedor() != null ? cr.getFornecedor().getRazaoSocial() : cr.getDescricao());
        lblDataVencimento.setText(String.valueOf(cr.getDataVencimento()));
        lblValor.setText(String.valueOf(cr.getValor()));
        rbCxGeral.setSelected(true);
        preencheContas();
        tfValor.requestFocus();

    }

    public TelaContaPagarRec() {
        initComponents();

    }

    public void preencheContas() {
        cbContaBancaria.removeAllItems();
        cbContaBancaria.addItem("--");
        ContaBancariaDAO cbDAO = new ContaBancariaDAO();
        for (ContaBancaria col : cbDAO.list()) {
            cbContaBancaria.addItem(col);
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel4 = new javax.swing.JPanel();
        lbTexto = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        btCancelar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        tfValor = new javax.swing.JFormattedTextField();
        btSalvar = new javax.swing.JButton();
        lblCliente = new javax.swing.JLabel();
        lblDataVencimento = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        lblValor = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        rbContaBancaria = new javax.swing.JRadioButton();
        rbCxGeral = new javax.swing.JRadioButton();
        cbContaBancaria = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setBackground(new java.awt.Color(0, 153, 255));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbTexto.setFont(new java.awt.Font("Bitstream Vera Sans Mono", 1, 30)); // NOI18N
        lbTexto.setText("Receber Conta");
        jPanel4.add(lbTexto, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 350, 40));

        getContentPane().add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 430, 40));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/imagens/close.png"))); // NOI18N
        btCancelar.setToolTipText("Sair");
        btCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCancelarActionPerformed(evt);
            }
        });
        jPanel1.add(btCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 310, 43, 41));

        jLabel2.setFont(new java.awt.Font("Bitstream Vera Sans Mono", 0, 12)); // NOI18N
        jLabel2.setText("Valor Pago.: *");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 250, -1, -1));

        tfValor.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));
        tfValor.setFont(new java.awt.Font("Bitstream Vera Sans Mono", 0, 12)); // NOI18N
        tfValor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfValorActionPerformed(evt);
            }
        });
        tfValor.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                tfValorFocusLost(evt);
            }
        });
        tfValor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tfValorKeyPressed(evt);
            }
        });
        jPanel1.add(tfValor, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 270, 180, -1));

        btSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/imagens/pataverde.png"))); // NOI18N
        btSalvar.setToolTipText("Salvar");
        btSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSalvarActionPerformed(evt);
            }
        });
        jPanel1.add(btSalvar, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 310, 43, -1));

        lblCliente.setFont(new java.awt.Font("Bitstream Vera Sans Mono", 0, 12)); // NOI18N
        lblCliente.setText("Cliente.: *");
        jPanel1.add(lblCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, -1, -1));

        lblDataVencimento.setFont(new java.awt.Font("Bitstream Vera Sans Mono", 0, 12)); // NOI18N
        lblDataVencimento.setText("Data Vencimento.: *");
        jPanel1.add(lblDataVencimento, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, -1, -1));

        jLabel5.setFont(new java.awt.Font("Bitstream Vera Sans Mono", 0, 12)); // NOI18N
        jLabel5.setText("Descrição.:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, -1, -1));

        jLabel6.setFont(new java.awt.Font("Bitstream Vera Sans Mono", 0, 12)); // NOI18N
        jLabel6.setText("Data Vencimento.: ");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, -1, -1));

        lblValor.setFont(new java.awt.Font("Bitstream Vera Sans Mono", 0, 12)); // NOI18N
        lblValor.setText("Data Vencimento.: *");
        jPanel1.add(lblValor, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, -1, -1));

        jLabel7.setFont(new java.awt.Font("Bitstream Vera Sans Mono", 0, 12)); // NOI18N
        jLabel7.setText("Valor.:");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, -1, -1));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Pagar Com"));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        rbContaBancaria.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(rbContaBancaria);
        rbContaBancaria.setText("Conta Bancária");
        rbContaBancaria.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                rbContaBancariaItemStateChanged(evt);
            }
        });
        rbContaBancaria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbContaBancariaActionPerformed(evt);
            }
        });
        jPanel2.add(rbContaBancaria, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 20, -1, -1));

        rbCxGeral.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(rbCxGeral);
        rbCxGeral.setText("Caixa Geral");
        rbCxGeral.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                rbCxGeralItemStateChanged(evt);
            }
        });
        rbCxGeral.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbCxGeralActionPerformed(evt);
            }
        });
        jPanel2.add(rbCxGeral, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, -1));

        cbContaBancaria.setFont(new java.awt.Font("Bitstream Vera Sans Mono", 0, 11)); // NOI18N
        cbContaBancaria.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "--" }));
        cbContaBancaria.setEnabled(false);
        jPanel2.add(cbContaBancaria, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 50, 270, -1));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 400, 80));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 430, 370));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelarActionPerformed
        setVisible(false);
    }//GEN-LAST:event_btCancelarActionPerformed

    private void btSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSalvarActionPerformed
        if (!tfValor.getText().equals("")) {
            if (JOptionPane.showConfirmDialog(rootPane, "Deseja Pagar Essa Conta?", "Paar", JOptionPane.YES_NO_OPTION)
                    == JOptionPane.YES_OPTION) {

                if (rbContaBancaria.isSelected()) {
                    if (cbContaBancaria.getSelectedIndex() == 0) {
                        JOptionPane.showMessageDialog(rootPane, "Informe a Conta Bancária!");
                        return;
                    }
                }

                double valoraReceber = Double.parseDouble(tfValor.getText().replace(",", "."));
                cr.setDataPagamento(new Date());
                cr.setPaga(true);
                cr.setValorPago(valoraReceber);

                ContasPagarDAO cDAO = new ContasPagarDAO();
                cDAO.update(cr);

                if (rbCxGeral.isSelected()) {
                    CaixaGeral cg = new CaixaGeral();
                    cg.setContaPagar(cr);
                    cg.setData(new Date());
                    String descricao = cr.getFornecedor() != null ? cr.getFornecedor().getRazaoSocial()
                            : cr.getDescricao();
                    cg.setDescricao("CONTA PAGA de " + descricao
                            + " Nº" + cr.getNrConta());
                    cg.setValorSaida(valoraReceber);
                    cg.setValorEntrada(0);

                    CaixaGeralDAO cgDAO = new CaixaGeralDAO();
                    cgDAO.add(cg);
                } else {
                    ItemContaBancaria icb = new ItemContaBancaria();
                    icb.setContaBancaria((ContaBancaria) cbContaBancaria.getSelectedItem());
                    icb.setContaPagar(cr);
                    icb.setData(new Date());
                    String descricao = cr.getFornecedor() != null ? cr.getFornecedor().getRazaoSocial()
                            : cr.getDescricao();
                    icb.setDescricao("CONTA PAGA de " + descricao
                            + " Nº" + cr.getNrConta());
                    icb.setEntrada(0);
                    icb.setSaida(valoraReceber);
                    ItemContaBancariaDAO icbDAO = new ItemContaBancariaDAO();
                    icbDAO.add(icb);

                }

                if (valoraReceber < cr.getValor()) {
                    if (JOptionPane.showConfirmDialog(rootPane, "Valor Pago Menor que Valor da Conta"
                            + "\nDeseja Criar uma nova Conta com o Restante do Valor?", "Pagar", JOptionPane.YES_NO_OPTION)
                            == JOptionPane.YES_OPTION) {
                        ContasPagar cr2 = new ContasPagar();
                        if (cr.getFornecedor() != null) {
                            cr2.setFornecedor(cr.getFornecedor());
                        }
                        cr2.setDescricao(cr.getDescricao());
                        cr2.setDataVencimento(cr.getDataVencimento());
                        cr2.setNrConta("P" + cr.getNrConta());
                        cr2.setNrParcela(cr.getNrParcela());
                        cr2.setValor(cr.getValor() - valoraReceber);
                        cr2.setPaga(false);
                        cDAO.add(cr2);

                    }
                }
                dispose();
            }

        } else {
            JOptionPane.showMessageDialog(rootPane, "Informe o Valor à receber!");
        }
    }//GEN-LAST:event_btSalvarActionPerformed

    private void tfValorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfValorActionPerformed

    }//GEN-LAST:event_tfValorActionPerformed

    private void tfValorKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfValorKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            btSalvarActionPerformed(null);
        }
    }//GEN-LAST:event_tfValorKeyPressed

    private void tfValorFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfValorFocusLost
        if (Util.verificaValor(tfValor.getText(), 0) == null && !tfValor.getText().equals("")) {
            tfValor.setText("");
        }
    }//GEN-LAST:event_tfValorFocusLost

    private void rbContaBancariaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbContaBancariaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rbContaBancariaActionPerformed

    private void rbCxGeralActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbCxGeralActionPerformed

    }//GEN-LAST:event_rbCxGeralActionPerformed

    private void rbCxGeralItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_rbCxGeralItemStateChanged
        if (rbCxGeral.isSelected()) {
            cbContaBancaria.setEnabled(false);
        } else {
            cbContaBancaria.setEnabled(true);
        }
    }//GEN-LAST:event_rbCxGeralItemStateChanged

    private void rbContaBancariaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_rbContaBancariaItemStateChanged
        if (rbCxGeral.isSelected()) {
            cbContaBancaria.setEnabled(false);
        } else {
            cbContaBancaria.setEnabled(true);
        }
    }//GEN-LAST:event_rbContaBancariaItemStateChanged

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
            java.util.logging.Logger.getLogger(TelaContaPagarRec.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaContaPagarRec.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaContaPagarRec.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaContaPagarRec.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaContaPagarRec().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btCancelar;
    private javax.swing.JButton btSalvar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox cbContaBancaria;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JLabel lbTexto;
    private javax.swing.JLabel lblCliente;
    private javax.swing.JLabel lblDataVencimento;
    private javax.swing.JLabel lblValor;
    private javax.swing.JRadioButton rbContaBancaria;
    private javax.swing.JRadioButton rbCxGeral;
    private javax.swing.JFormattedTextField tfValor;
    // End of variables declaration//GEN-END:variables
}