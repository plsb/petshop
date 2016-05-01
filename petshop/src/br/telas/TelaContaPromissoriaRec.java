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
import br.grupo_produto.GrupoProduto;
import br.grupo_produto.GrupoProdutoDAO;
import br.grupo_produto.GrupoTableModel;
import br.livro.LivroCaixa;
import br.livro.LivroCaixaDAO;
import br.util.HibernateUtil;
import br.util.Util;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
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
public class TelaContaPromissoriaRec extends javax.swing.JDialog {

    private static ContasReceber cr;

    public static void chamaTela(ContasReceber cr) {
        TelaContaPromissoriaRec.cr = cr;
        new TelaContaPromissoriaRec().setVisible(true);
    }

    /**
     * Creates new form TelaCliente
     */
    public TelaContaPromissoriaRec() {
        initComponents();
        setModal(true);
        setTitle("Recebe Conta");
        setLocationRelativeTo(null);
        lblCliente.setText(cr.getCliente().getNome());
        lblDataVencimento.setText(String.valueOf(cr.getDataVencimento()));
        lblValor.setText(String.valueOf(cr.getValor()));

    }

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

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setBackground(new java.awt.Color(0, 153, 255));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbTexto.setFont(new java.awt.Font("Verdana", 1, 30)); // NOI18N
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
        jPanel1.add(btCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 220, 43, 41));

        jLabel2.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel2.setText("Valor Recebido.: *");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, -1, -1));

        tfValor.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));
        tfValor.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jPanel1.add(tfValor, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, 180, -1));

        btSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/imagens/pataverde.png"))); // NOI18N
        btSalvar.setToolTipText("Salvar");
        btSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSalvarActionPerformed(evt);
            }
        });
        jPanel1.add(btSalvar, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 220, 43, -1));

        lblCliente.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        lblCliente.setText("Cliente.: *");
        jPanel1.add(lblCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, -1, -1));

        lblDataVencimento.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        lblDataVencimento.setText("Data Vencimento.: *");
        jPanel1.add(lblDataVencimento, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, -1, -1));

        jLabel5.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel5.setText("Cliente.: ");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        jLabel6.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel6.setText("Data Vencimento.: ");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, -1, -1));

        lblValor.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        lblValor.setText("Data Vencimento.: *");
        jPanel1.add(lblValor, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, -1, -1));

        jLabel7.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel7.setText("Valor.:");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 430, 280));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelarActionPerformed
        setVisible(false);
    }//GEN-LAST:event_btCancelarActionPerformed

    private void btSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSalvarActionPerformed
        if (!tfValor.getText().equals("")) {
            if (JOptionPane.showConfirmDialog(rootPane, "Deseja Receber Essa Conta?", "Receber", JOptionPane.YES_NO_OPTION)
                    == JOptionPane.YES_OPTION) {
                double valoraReceber = Double.parseDouble(tfValor.getText().replace(",", "."));
                cr.setDataPagamento(new Date());
                cr.setPaga(true);
                cr.setValorPago(valoraReceber);

                ContasReceberDAO cDAO = new ContasReceberDAO();
                cDAO.update(cr);
                
                LivroCaixa lc = new LivroCaixa();
                lc.setData(new Date());
                lc.setDescricao("CONTA À RECEBER Nº"+cr.getNrConta()+", CLIENTE: "+cr.getCliente().getNome());
                lc.setValorEntrada(valoraReceber);
                lc.setContaReceber(cr);
                LivroCaixaDAO lcDAO = new LivroCaixaDAO();
                lcDAO.add(lc);
                
                if (valoraReceber < cr.getValor()) {
                    if (JOptionPane.showConfirmDialog(rootPane, "Valor à Receber Menor que Valor da Conta"
                            + "\nDeseja Criar uma nova Conta com o Restante do Valor?", "Receber", JOptionPane.YES_NO_OPTION)
                            == JOptionPane.YES_OPTION) {
                        ContasReceber cr2 = new ContasReceber();
                        cr2.setCliente(cr.getCliente());
                        cr2.setDataVencimento(cr.getDataVencimento());
                        cr2.setNrConta("R"+cr.getNrConta());
                        cr2.setNrParcela(cr.getNrParcela());
                        cr2.setValor(cr.getValor()-valoraReceber);
                        cr2.setVenda(cr.getVenda());
                        cr2.setPaga(false);
                        cDAO.add(cr2);
                    }
                }
                setVisible(false);
            }
            
        } else {
            JOptionPane.showMessageDialog(rootPane, "Informe o Valor à receber!");
        }
    }//GEN-LAST:event_btSalvarActionPerformed

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
            java.util.logging.Logger.getLogger(TelaContaPromissoriaRec.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaContaPromissoriaRec.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaContaPromissoriaRec.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaContaPromissoriaRec.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
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
                new TelaContaPromissoriaRec().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btCancelar;
    private javax.swing.JButton btSalvar;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JLabel lbTexto;
    private javax.swing.JLabel lblCliente;
    private javax.swing.JLabel lblDataVencimento;
    private javax.swing.JLabel lblValor;
    private javax.swing.JFormattedTextField tfValor;
    // End of variables declaration//GEN-END:variables
}
