/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.telas;

import br.util.Util;
import br.venda.Venda;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author Pedro Saraiva
 */
public class TelaFechaVenda extends javax.swing.JDialog {

    private static Venda venda;

    public static Venda exibeFechamento(Venda venda) {
        TelaFechaVenda.venda = venda;
        new TelaFechaVenda().setVisible(true);
        return TelaFechaVenda.venda;
    }

    /**
     * Creates new form TelaFechaVenda
     */
    public TelaFechaVenda() {
        initComponents();
        setTitle("Fecha Venda");
        setModal(true);
        setTitle("Fechamento de Venda");
        setLocationRelativeTo(null);
        double totalComDesconto = venda.getValorTotal() - venda.getDesconto();
        tfVtSemDesconto.setText(Util.acertarNumero(venda.getValorTotal()));
        tfDesconto.setText(Util.acertarNumero(venda.getDesconto()));
        tfVtComDesconto.setText(String.valueOf(totalComDesconto).replace(".", ","));
        tfVtComDesconto.setEditable(false);
        tfTroco.setEditable(false);
        tfVtSemDesconto.setEnabled(false);
        tfDesconto.setEnabled(Util.verificaPermissao("PERMITIR_ALTERACAO_DESCONTO_VENDA", 0));
        switch (venda.getTipoPagamento()) {
            case "VV":
                tfCartao.setEnabled(false);
                tfPromissoria.setEnabled(false);
                tfDinheiro.setEditable(false);
                tfDinheiro.setText(tfVtComDesconto.getText());
                tfDinheiroRecebido.requestFocus();
                tfDesconto.setEnabled(Util.verificaPermissao("PERMITIR_ALTERACAO_DESCONTO_VENDA", 0));
                break;
            case "VP":
                tfCartao.setEnabled(false);
                tfPromissoria.setText(tfVtComDesconto.getText());
                tfPromissoria.setEditable(false);
                tfDinheiro.requestFocus();
                tfDesconto.setEnabled(false);
                break;
            case "VC":
                tfPromissoria.setEnabled(false);
                tfCartao.setText(tfVtComDesconto.getText());
                tfCartao.setEditable(false);
                tfDinheiro.requestFocus();
                tfDesconto.setEnabled(false);
                break;
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

        jPanel1 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        tfVtComDesconto = new javax.swing.JFormattedTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        tfDinheiro = new javax.swing.JFormattedTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        tfCartao = new javax.swing.JFormattedTextField();
        jLabel9 = new javax.swing.JLabel();
        tfPromissoria = new javax.swing.JFormattedTextField();
        jPanel2 = new javax.swing.JPanel();
        tfDinheiroRecebido = new javax.swing.JFormattedTextField();
        jLabel10 = new javax.swing.JLabel();
        tfTroco = new javax.swing.JFormattedTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        tfVtSemDesconto = new javax.swing.JFormattedTextField();
        jLabel14 = new javax.swing.JLabel();
        tfDesconto = new javax.swing.JFormattedTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setText("Total com Desconto.:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 110, -1, -1));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/imagens/valuetotal.png"))); // NOI18N
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 130, -1, -1));

        tfVtComDesconto.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));
        tfVtComDesconto.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        tfVtComDesconto.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jPanel1.add(tfVtComDesconto, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 130, 170, 30));

        jLabel7.setText("Valor em Dinheiro.:");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 160, -1, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/imagens/money (1).png"))); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 180, -1, -1));

        tfDinheiro.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));
        tfDinheiro.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        tfDinheiro.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        tfDinheiro.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                tfDinheiroFocusLost(evt);
            }
        });
        jPanel1.add(tfDinheiro, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 180, 170, 30));

        jLabel8.setText("Valor em Cartão.:");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 210, -1, -1));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/imagens/wallet.png"))); // NOI18N
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 360, -1, -1));

        tfCartao.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));
        tfCartao.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        tfCartao.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jPanel1.add(tfCartao, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 230, 170, 30));

        jLabel9.setText("Valor em Promissória.:");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 260, -1, -1));

        tfPromissoria.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));
        tfPromissoria.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        tfPromissoria.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jPanel1.add(tfPromissoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 280, 170, 30));

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 298, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 8, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 320, 300, 10));

        tfDinheiroRecebido.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));
        tfDinheiroRecebido.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        tfDinheiroRecebido.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        tfDinheiroRecebido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfDinheiroRecebidoActionPerformed(evt);
            }
        });
        tfDinheiroRecebido.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                tfDinheiroRecebidoFocusLost(evt);
            }
        });
        jPanel1.add(tfDinheiroRecebido, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 360, 170, 30));

        jLabel10.setText("Valor Recebido em Dinheiro.:");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 340, -1, -1));

        tfTroco.setForeground(new java.awt.Color(255, 0, 0));
        tfTroco.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));
        tfTroco.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        tfTroco.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jPanel1.add(tfTroco, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 410, 170, 30));

        jLabel11.setText("Valor Troco.:");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 390, -1, -1));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/imagens/file.png"))); // NOI18N
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 280, -1, -1));

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/imagens/business.png"))); // NOI18N
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 230, -1, -1));

        jButton1.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        jButton1.setText("Finalizar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 450, 210, -1));

        jLabel13.setText("Total.:");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 0, -1, -1));

        tfVtSemDesconto.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));
        tfVtSemDesconto.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        tfVtSemDesconto.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jPanel1.add(tfVtSemDesconto, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 20, 170, 30));

        jLabel14.setText("Desconto.:");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 50, -1, -1));

        tfDesconto.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));
        tfDesconto.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        tfDesconto.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        tfDesconto.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                tfDescontoFocusLost(evt);
            }
        });
        jPanel1.add(tfDesconto, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 70, 170, 30));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 340, 490));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tfDinheiroFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfDinheiroFocusLost
        if (venda.getTipoPagamento().equals("VP") || venda.getTipoPagamento().equals("VC")) {
            if (!tfDinheiro.equals("")) {
                double dinheiro = Double.parseDouble(tfDinheiro.getText().replace(",", "."));
                double valorTotal = Double.parseDouble(tfVtComDesconto.getText().replace(",", "."));
                if (dinheiro > valorTotal) {
                    JOptionPane.showMessageDialog(rootPane, "Valor em Dinheiro Não Pode Superar O Valor Total!");
                    tfDinheiro.requestFocus();
                }
                double diferenca = valorTotal - dinheiro;
                if (venda.getTipoPagamento().equals("VP")) {
                    tfPromissoria.setText(String.valueOf(diferenca).replace(".", ","));
                }
                if (venda.getTipoPagamento().equals("VC")) {
                    tfCartao.setText(String.valueOf(diferenca).replace(".", ","));
                }
            }
        }
    }//GEN-LAST:event_tfDinheiroFocusLost

    private void tfDinheiroRecebidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfDinheiroRecebidoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfDinheiroRecebidoActionPerformed

    private void tfDinheiroRecebidoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfDinheiroRecebidoFocusLost
        // TODO add your handling code here:
        if (!tfDinheiroRecebido.equals("")) {
            double dinheiro = Double.parseDouble(tfDinheiro.getText().replace(",", "."));
            double valorRecebido = Double.parseDouble(tfDinheiroRecebido.getText().replace(",", "."));
            if (dinheiro > valorRecebido) {
                JOptionPane.showMessageDialog(rootPane, "Valor Recebido deve Superar O Valor em Dinheiro!");
                tfDinheiroRecebido.requestFocus();
            }
            double diferenca = valorRecebido - dinheiro;

            tfTroco.setText(String.valueOf(diferenca).replace(".", ","));

        }
    }//GEN-LAST:event_tfDinheiroRecebidoFocusLost

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (JOptionPane.showConfirmDialog(rootPane, "Deseja Finalizar a venda?", "FINALIZAR", JOptionPane.YES_NO_OPTION, 
                JOptionPane.INFORMATION_MESSAGE)==JOptionPane.YES_OPTION) {
            try {
                venda.setVlVista(Double.parseDouble(tfDinheiro.getText().replace(",", ".")));
            } catch (Exception e) {
                venda.setVlVista(0);
            }

            try {
                venda.setVlCartao(Double.parseDouble(tfCartao.getText().replace(",", ".")));
            } catch (Exception e) {
                venda.setVlCartao(0);
            }
            try {
                venda.setVlPromissoria(Double.parseDouble(tfPromissoria.getText().replace(",", ".")));
            } catch (Exception e) {
                venda.setVlPromissoria(0);
            }
            venda.setHora(new Date());
            setVisible(false);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void tfDescontoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfDescontoFocusLost
        if(venda.getTipoPagamento().equals("VV")){
            
            try {
                venda.setDesconto(Double.parseDouble(tfDesconto.getText().replace(",", ".")));
            } catch (Exception e) {
                JOptionPane.showMessageDialog(rootPane, "Erro ao atribuir o desconto!");
            }
            tfVtComDesconto.setText(Util.acertarNumero(venda.getValorTotal()-venda.getDesconto()));
            tfDinheiro.setText(tfVtComDesconto.getText());
            
        }
    }//GEN-LAST:event_tfDescontoFocusLost

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
            java.util.logging.Logger.getLogger(TelaFechaVenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaFechaVenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaFechaVenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaFechaVenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaFechaVenda().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JFormattedTextField tfCartao;
    private javax.swing.JFormattedTextField tfDesconto;
    private javax.swing.JFormattedTextField tfDinheiro;
    private javax.swing.JFormattedTextField tfDinheiroRecebido;
    private javax.swing.JFormattedTextField tfPromissoria;
    private javax.swing.JFormattedTextField tfTroco;
    private javax.swing.JFormattedTextField tfVtComDesconto;
    private javax.swing.JFormattedTextField tfVtSemDesconto;
    // End of variables declaration//GEN-END:variables
}
