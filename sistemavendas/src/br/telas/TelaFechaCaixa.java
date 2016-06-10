/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.telas;

import br.caixageral.CaixaGeral;
import br.caixageral.CaixaGeralDAO;
import br.livro.Caixa;
import br.livro.CaixaDAO;
import br.livro.LivroCaixaDAO;
import br.util.Ativo;
import br.util.Util;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import javax.swing.JOptionPane;

/**
 *
 * @author Pedro Saraiva
 */
public class TelaFechaCaixa extends javax.swing.JDialog {

    private Caixa caixaAnterior;

    /**
     * Creates new form TelaAbrirCaixa
     */
    public TelaFechaCaixa() {
        initComponents();
        lblUsuario2.setText(Ativo.getUsuario().getNome());
        SimpleDateFormat dfdtData;
        dfdtData = new SimpleDateFormat("dd/MM/yyyy");
        lblData.setText(dfdtData.format(new Date()));
        setModal(true);
        setLocationRelativeTo(null);
        setTitle("Fechar Caixa");

        CaixaDAO dao = new CaixaDAO();
        lblCodigo.setText("Nº Caixa: " + Ativo.getCaixa().getNrCaixa());
        caixaAnterior = dao.listCaixaAnterior(Ativo.getCaixa());
        if (caixaAnterior != null) {
            tfCaixaAnterior.setText(String.valueOf(caixaAnterior.getValorFicaCaixa()));
        } else {
            tfCaixaAnterior.setText("0");
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
        tfValorRetirada = new javax.swing.JFormattedTextField();
        lblData = new javax.swing.JLabel();
        lblSaldo = new javax.swing.JLabel();
        lblCodigo = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        btConfirmar = new javax.swing.JButton();
        lblUsuario2 = new javax.swing.JLabel();
        tfValorAtual = new javax.swing.JFormattedTextField();
        jLabel4 = new javax.swing.JLabel();
        lbl = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        tfCaixaAnterior = new javax.swing.JFormattedTextField();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tfValorRetirada.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));
        tfValorRetirada.setToolTipText("Digite aqui o valor que será retirado do caixa");
        tfValorRetirada.setFont(new java.awt.Font("Bitstream Vera Sans Mono", 0, 12)); // NOI18N
        tfValorRetirada.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                tfValorRetiradaFocusLost(evt);
            }
        });
        tfValorRetirada.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tfValorRetiradaKeyPressed(evt);
            }
        });
        jPanel1.add(tfValorRetirada, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, 150, -1));

        lblData.setFont(new java.awt.Font("Bitstream Vera Sans Mono", 0, 12)); // NOI18N
        lblData.setText("Data");
        jPanel1.add(lblData, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 290, -1));

        lblSaldo.setFont(new java.awt.Font("Bitstream Vera Sans Mono", 0, 12)); // NOI18N
        lblSaldo.setText("Saldo: 0,00");
        jPanel1.add(lblSaldo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 200, -1, -1));

        lblCodigo.setFont(new java.awt.Font("Bitstream Vera Sans Mono", 1, 12)); // NOI18N
        lblCodigo.setText("Código");
        jPanel1.add(lblCodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 260, -1));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/imagens/cancel2.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 210, 50, 40));

        btConfirmar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/imagens/ok.png"))); // NOI18N
        btConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btConfirmarActionPerformed(evt);
            }
        });
        jPanel1.add(btConfirmar, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 210, 50, 40));

        lblUsuario2.setFont(new java.awt.Font("Bitstream Vera Sans Mono", 0, 12)); // NOI18N
        lblUsuario2.setText("Usuario");
        jPanel1.add(lblUsuario2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 260, -1));

        tfValorAtual.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));
        tfValorAtual.setToolTipText("Digite aqui o valor que fica no caixa");
        tfValorAtual.setFont(new java.awt.Font("Bitstream Vera Sans Mono", 0, 12)); // NOI18N
        tfValorAtual.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                tfValorAtualFocusLost(evt);
            }
        });
        tfValorAtual.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tfValorAtualKeyPressed(evt);
            }
        });
        jPanel1.add(tfValorAtual, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 170, 150, -1));

        jLabel4.setFont(new java.awt.Font("Bitstream Vera Sans Mono", 0, 12)); // NOI18N
        jLabel4.setText("Valor Gaveta.: (*)");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 150, -1, -1));

        lbl.setFont(new java.awt.Font("Bitstream Vera Sans Mono", 1, 14)); // NOI18N
        lbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl.setText("FECHAR CAIXA");
        jPanel1.add(lbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 320, -1));

        jLabel5.setFont(new java.awt.Font("Bitstream Vera Sans Mono", 0, 12)); // NOI18N
        jLabel5.setText("Caixa Anterior:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, -1, -1));

        tfCaixaAnterior.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));
        tfCaixaAnterior.setToolTipText("Digite aqui o valor que será retirado do caixa");
        tfCaixaAnterior.setEnabled(false);
        tfCaixaAnterior.setFont(new java.awt.Font("Bitstream Vera Sans Mono", 0, 12)); // NOI18N
        tfCaixaAnterior.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tfCaixaAnteriorKeyPressed(evt);
            }
        });
        jPanel1.add(tfCaixaAnterior, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 150, -1));

        jLabel6.setFont(new java.awt.Font("Bitstream Vera Sans Mono", 0, 12)); // NOI18N
        jLabel6.setText("Valor Retirada.: (*)");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 340, 270));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void calculaSaldo() {
        double valorRetirada = 0, valorAtual = 0;
        try {
            valorRetirada = Double.parseDouble(tfValorRetirada.getText().replaceAll(",", "."));
        } catch (Exception e) {
            valorRetirada = 0;
        }
        try {
            valorAtual = Double.parseDouble(tfValorAtual.getText().replaceAll(",", "."));
        } catch (Exception e) {
            valorAtual = 0;
        }

        double saldo = 0;
        LivroCaixaDAO lDAO = new LivroCaixaDAO();
        double s2 = lDAO.valorSaldoCaixa(Ativo.getCaixa());
        if (caixaAnterior != null) {
            saldo = ((valorAtual + valorRetirada) - caixaAnterior.getValorFicaCaixa()) - s2;
        } else {
            saldo = (valorAtual + valorRetirada) - s2;
        }

        saldo = Double.parseDouble(Util.acertarNumero(saldo).replaceFirst(",", "."));
        if (saldo == 0) {
            lblSaldo.setForeground(Color.BLUE);
        } else {
            lblSaldo.setForeground(Color.RED);
        }
        lblSaldo.setText("Saldo: " + Util.acertarNumero(saldo));

    }

    private void btConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btConfirmarActionPerformed
        if (Util.chkVazio(tfValorRetirada.getText(), tfValorAtual.getText())) {
            double valorRetirada = 0, valorAtual = 0;
            try {
                valorRetirada = Double.parseDouble(tfValorRetirada.getText().replaceAll(",", "."));
            } catch (Exception e) {
                JOptionPane.showMessageDialog(rootPane, "ERRO no valor de retirada!");
                return;
            }
            try {
                valorAtual = Double.parseDouble(tfValorAtual.getText().replaceAll(",", "."));
            } catch (Exception e) {
                JOptionPane.showMessageDialog(rootPane, "ERRO no valor atual!");
                return;
            }
            if (valorAtual < 0 || valorRetirada < 0) {
                JOptionPane.showMessageDialog(rootPane, "O Valores não podem ser negativos!");
                tfValorRetirada.requestFocus();
                return;
            }

            Caixa c = Ativo.getCaixa();
            CaixaDAO cDAO = new CaixaDAO();

            c.setAberto(false);
            c.setDataFechou(new Date());
            c.setHoraFechou(new Date());
            c.setRetirada(valorRetirada);
            c.setValorFicaCaixa(valorAtual);

            if (JOptionPane.showConfirmDialog(rootPane, "Deseja Fechar o Caixa Nº "
                    + c.getNrCaixa(), "", JOptionPane.YES_NO_OPTION) == JOptionPane.NO_OPTION) {
                return;
            }

            cDAO.update(c);
            //adiciona retirada no caixa geral
            CaixaGeralDAO cgDAO = new CaixaGeralDAO();
            CaixaGeral cg = new CaixaGeral();
            cg.setData(new Date());
            cg.setDescricao("RETIRADA DO CAIXA Nº " + c.getNrCaixa() + " de " + c.getUser().getNome());
            cg.setValorEntrada(valorRetirada);
            cg.setValorSaida(0);

            cgDAO.add(cg);
            dispose();
            
            HashMap parametros = new HashMap();
            parametros.put("sql", Ativo.getCaixa().getId());
            Util.imprimir("relatorios/reportLivroCaixa.jrxml", parametros);

            //como foi fechado, o caixa ativo será null
            Ativo.setCaixa(null);

        }
    }//GEN-LAST:event_btConfirmarActionPerformed

    private void tfValorRetiradaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfValorRetiradaKeyPressed
        calculaSaldo();
    }//GEN-LAST:event_tfValorRetiradaKeyPressed

    private void tfValorAtualKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfValorAtualKeyPressed
        calculaSaldo();
    }//GEN-LAST:event_tfValorAtualKeyPressed

    private void tfCaixaAnteriorKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfCaixaAnteriorKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfCaixaAnteriorKeyPressed

    private void tfValorAtualFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfValorAtualFocusLost
        calculaSaldo();
    }//GEN-LAST:event_tfValorAtualFocusLost

    private void tfValorRetiradaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfValorRetiradaFocusLost
        calculaSaldo();
    }//GEN-LAST:event_tfValorRetiradaFocusLost

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
            java.util.logging.Logger.getLogger(TelaFechaCaixa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaFechaCaixa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaFechaCaixa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaFechaCaixa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaFechaCaixa().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btConfirmar;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lbl;
    private javax.swing.JLabel lblCodigo;
    private javax.swing.JLabel lblData;
    private javax.swing.JLabel lblSaldo;
    private javax.swing.JLabel lblUsuario2;
    private javax.swing.JFormattedTextField tfCaixaAnterior;
    private javax.swing.JFormattedTextField tfValorAtual;
    private javax.swing.JFormattedTextField tfValorRetirada;
    // End of variables declaration//GEN-END:variables
}
