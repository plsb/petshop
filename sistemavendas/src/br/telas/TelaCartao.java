/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.telas;

import br.cartao.CartaoCredito;
import br.cartao.CartaoCreditoDAO;
import br.cliente.Cliente;
import br.cliente.ClienteDAO;
import br.util.Util;
import br.venda.Venda;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Pedro Saraiva
 */
public class TelaCartao extends javax.swing.JDialog {

    /**
     * Creates new form TelaFechaVendaCartao
     */
    public TelaCartao() {
        initComponents();
        setModal(true);
        setLocationRelativeTo(null);
        preencheCliente();
        SimpleDateFormat dfdtData;
        dfdtData = new SimpleDateFormat("dd/MM/yyyy");
        tfData.setText(dfdtData.format(new Date()));
    }

    private Venda venda;

    public TelaCartao(Venda v) {
        initComponents();
        setModal(true);
        setLocationRelativeTo(null);
        tfData.setText(Util.acertarNumero(v.getVlCartao()));
        tfData.setEnabled(false);
        venda = v;
        preencheCliente();
        cbCliente.setSelectedItem(v.getCliente());
        cbCliente.setEnabled(false);
        tfValor.setText(String.valueOf(v.getVlCartao()));
        
        SimpleDateFormat dfdtData;
        dfdtData = new SimpleDateFormat("dd/MM/yyyy");
        tfData.setText(dfdtData.format(new Date()));
        tfData.setEnabled(false);
        btSair.setEnabled(false);
        tfValor.setEnabled(false);
    }

    public void preencheCliente() {
        cbCliente.removeAllItems();
        cbCliente.addItem("--");
        ClienteDAO cDAO = new ClienteDAO();
        List<Cliente> lista = cDAO.checkExists("ativo", true);
        Collections.sort(lista);
        for (Cliente c : lista) {
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        btSair = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        rbDebito = new javax.swing.JRadioButton();
        rbCredito = new javax.swing.JRadioButton();
        jLabel1 = new javax.swing.JLabel();
        cbQtParcelas = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        tfData = new javax.swing.JFormattedTextField();
        jLabel3 = new javax.swing.JLabel();
        cbBandeira1 = new javax.swing.JComboBox();
        lblValorQtd = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        cbCliente = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        tfValor = new javax.swing.JFormattedTextField();
        btSalvar = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        lbTexto = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setForeground(new java.awt.Color(240, 240, 240));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/imagens/cancel2.png"))); // NOI18N
        btSair.setToolTipText("Salvar");
        btSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSairActionPerformed(evt);
            }
        });
        jPanel1.add(btSair, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 180, 43, -1));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Cartão de"));
        jPanel2.setFont(new java.awt.Font("Bitstream Vera Sans Mono", 0, 11)); // NOI18N

        rbDebito.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(rbDebito);
        rbDebito.setFont(new java.awt.Font("Bitstream Vera Sans Mono", 0, 12)); // NOI18N
        rbDebito.setText("Débito");
        rbDebito.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbDebitoActionPerformed(evt);
            }
        });
        rbDebito.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                rbDebitoFocusLost(evt);
            }
        });

        rbCredito.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(rbCredito);
        rbCredito.setFont(new java.awt.Font("Bitstream Vera Sans Mono", 0, 12)); // NOI18N
        rbCredito.setText("Crédito");
        rbCredito.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbCreditoActionPerformed(evt);
            }
        });
        rbCredito.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                rbCreditoFocusLost(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(rbDebito)
                .addGap(18, 18, 18)
                .addComponent(rbCredito)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbDebito)
                    .addComponent(rbCredito))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 170, 60));

        jLabel1.setFont(new java.awt.Font("Bitstream Vera Sans Mono", 0, 12)); // NOI18N
        jLabel1.setText("Qtd Parcelas:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, -1, -1));

        cbQtParcelas.setFont(new java.awt.Font("Bitstream Vera Sans Mono", 0, 12)); // NOI18N
        cbQtParcelas.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "--", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10" }));
        cbQtParcelas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cbQtParcelasMouseClicked(evt);
            }
        });
        cbQtParcelas.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbQtParcelasItemStateChanged(evt);
            }
        });
        cbQtParcelas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbQtParcelasActionPerformed(evt);
            }
        });
        cbQtParcelas.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                cbQtParcelasFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                cbQtParcelasFocusLost(evt);
            }
        });
        cbQtParcelas.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cbQtParcelasKeyPressed(evt);
            }
        });
        jPanel1.add(cbQtParcelas, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, 160, -1));

        jLabel2.setFont(new java.awt.Font("Bitstream Vera Sans Mono", 0, 12)); // NOI18N
        jLabel2.setText("Bandeira: *");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 130, -1, -1));

        try {
            tfData.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        tfData.setFont(new java.awt.Font("Bitstream Vera Sans Mono", 0, 12)); // NOI18N
        jPanel1.add(tfData, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 30, 130, -1));

        jLabel3.setFont(new java.awt.Font("Bitstream Vera Sans Mono", 0, 12)); // NOI18N
        jLabel3.setText("Valor:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 70, -1, -1));

        cbBandeira1.setFont(new java.awt.Font("Bitstream Vera Sans Mono", 0, 12)); // NOI18N
        cbBandeira1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "--", "ELO", "Hiper", "Master", "Visa" }));
        cbBandeira1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbBandeira1ActionPerformed(evt);
            }
        });
        jPanel1.add(cbBandeira1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 150, 230, -1));

        lblValorQtd.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jPanel1.add(lblValorQtd, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, 160, 20));

        jLabel4.setFont(new java.awt.Font("Bitstream Vera Sans Mono", 0, 12)); // NOI18N
        jLabel4.setText("Data:*");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 10, -1, -1));

        cbCliente.setFont(new java.awt.Font("Bitstream Vera Sans Mono", 0, 12)); // NOI18N
        cbCliente.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "--", "ELO", "Hiper", "Master", "Visa" }));
        cbCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbClienteActionPerformed(evt);
            }
        });
        jPanel1.add(cbCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 280, -1));

        jLabel5.setFont(new java.awt.Font("Bitstream Vera Sans Mono", 0, 12)); // NOI18N
        jLabel5.setText("Cliente: *");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        tfValor.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));
        tfValor.setFont(new java.awt.Font("Bitstream Vera Sans Mono", 0, 12)); // NOI18N
        tfValor.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                tfValorFocusLost(evt);
            }
        });
        jPanel1.add(tfValor, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 90, 130, -1));

        btSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/imagens/pataverde.png"))); // NOI18N
        btSalvar.setToolTipText("Salvar");
        btSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSalvarActionPerformed(evt);
            }
        });
        jPanel1.add(btSalvar, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 180, 43, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 440, 230));

        jPanel4.setBackground(new java.awt.Color(0, 153, 255));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbTexto.setFont(new java.awt.Font("Bitstream Vera Sans Mono", 1, 30)); // NOI18N
        lbTexto.setText("Cartão Crédito/Débito");
        jPanel4.add(lbTexto, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 390, 40));

        getContentPane().add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 440, 40));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSairActionPerformed
        dispose();

    }//GEN-LAST:event_btSairActionPerformed

    private void cbQtParcelasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbQtParcelasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbQtParcelasActionPerformed

    private void cbBandeira1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbBandeira1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbBandeira1ActionPerformed

    private void rbDebitoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbDebitoActionPerformed
        // TODO add your handling code here:
        if (rbDebito.isSelected()) {
            cbQtParcelas.setEnabled(false);
            cbQtParcelas.setSelectedIndex(0);
        }
    }//GEN-LAST:event_rbDebitoActionPerformed

    private void rbDebitoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_rbDebitoFocusLost

    }//GEN-LAST:event_rbDebitoFocusLost

    private void rbCreditoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_rbCreditoFocusLost
        // TODO add your handling code here:

    }//GEN-LAST:event_rbCreditoFocusLost

    private void cbQtParcelasFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cbQtParcelasFocusLost

    }//GEN-LAST:event_cbQtParcelasFocusLost

    private void cbQtParcelasKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cbQtParcelasKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbQtParcelasKeyPressed

    private void cbQtParcelasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbQtParcelasMouseClicked

    }//GEN-LAST:event_cbQtParcelasMouseClicked

    private void cbQtParcelasItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbQtParcelasItemStateChanged
        if (tfValor.getText().isEmpty()) {
            tfValor.requestFocus();
        } else if (cbQtParcelas.getSelectedIndex() > 0) {
            int qtd = Integer.parseInt(cbQtParcelas.getSelectedItem().toString());
            double valor = Double.parseDouble(tfValor.getText().replaceFirst(",", "."));
            lblValorQtd.setText(cbQtParcelas.getSelectedItem().toString()
                    + "x de " + Util.acertarNumero(valor / qtd));
        } else {
            lblValorQtd.setText("");
        }
    }//GEN-LAST:event_cbQtParcelasItemStateChanged

    private void rbCreditoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbCreditoActionPerformed
        if (rbCredito.isSelected()) {
            cbQtParcelas.setEnabled(true);
            cbQtParcelas.setSelectedIndex(1);
        }
    }//GEN-LAST:event_rbCreditoActionPerformed

    private void cbClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbClienteActionPerformed

    private void btSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSalvarActionPerformed
        if (cbBandeira1.getSelectedIndex() == 0 || cbCliente.getSelectedIndex() == 0
                || tfValor.getText().isEmpty() || tfData.getText().equals("  /  /    ")) {
            JOptionPane.showMessageDialog(rootPane, "Informe os Camppos Obrigatórios (*)!");
            return;
        }
        if (rbCredito.isSelected() && cbQtParcelas.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(rootPane, "Informe a Quantidade de Parcelas!");
            return;
        }
        CartaoCredito cc = new CartaoCredito();
        CartaoCreditoDAO ccDAO = new CartaoCreditoDAO();
        cc.setCliente((Cliente) cbCliente.getSelectedItem());
        cc.setDebito(rbDebito.isSelected());
        if (cbQtParcelas.getSelectedIndex() != 0) {
            cc.setQtdParcelas(cbQtParcelas.getSelectedIndex());
        } else {
            cc.setQtdParcelas(0);
        }
        cc.setValor(Double.parseDouble(tfValor.getText().replaceFirst(",", ".")));
        try {
            DateFormat fmt = new SimpleDateFormat("dd/MM/yyyy");
            java.util.Date data;
            data = new java.util.Date(fmt.parse(tfData.getText()).getTime());
            cc.setData(data);
        } catch (ParseException ex) {
            System.out.println(ex.getMessage());
        }
        if(venda!=null){
            cc.setVenda(venda);
        }
            
        cc.setBandeira(cbBandeira1.getSelectedItem().toString());
        ccDAO.add(cc);
        dispose();

    }//GEN-LAST:event_btSalvarActionPerformed

    private void cbQtParcelasFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cbQtParcelasFocusGained

    }//GEN-LAST:event_cbQtParcelasFocusGained

    private void tfValorFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfValorFocusLost
        cbQtParcelasItemStateChanged(null);
    }//GEN-LAST:event_tfValorFocusLost

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
            java.util.logging.Logger.getLogger(TelaCartao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaCartao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaCartao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaCartao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaCartao().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btSair;
    private javax.swing.JButton btSalvar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox cbBandeira1;
    private javax.swing.JComboBox cbCliente;
    private javax.swing.JComboBox cbQtParcelas;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JLabel lbTexto;
    private javax.swing.JLabel lblValorQtd;
    private javax.swing.JRadioButton rbCredito;
    private javax.swing.JRadioButton rbDebito;
    private javax.swing.JFormattedTextField tfData;
    private javax.swing.JFormattedTextField tfValor;
    // End of variables declaration//GEN-END:variables
}