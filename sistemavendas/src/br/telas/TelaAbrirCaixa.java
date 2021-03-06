/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.telas;

import br.livro.Caixa;
import br.livro.CaixaDAO;
import br.util.Ativo;
import br.util.Util;
import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author Pedro Saraiva
 */
public class TelaAbrirCaixa extends javax.swing.JDialog {

    /**
     * Creates new form TelaAbrirCaixa
     */
    public TelaAbrirCaixa() {
        initComponents();
        lblUsuario.setText(Ativo.getUsuario().getNome());
        SimpleDateFormat dfdtData;
        dfdtData = new SimpleDateFormat("dd/MM/yyyy");
        lblData.setText(dfdtData.format(new Date()));
        setModal(true);
        setLocationRelativeTo(null);
        setTitle("Abrir Caixa");

        CaixaDAO dao = new CaixaDAO();

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
        lblData = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        btConfirmar = new javax.swing.JButton();
        lbl = new javax.swing.JLabel();
        lblUsuario = new javax.swing.JLabel();
        cbNrCaixa = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblData.setFont(new java.awt.Font("Bitstream Vera Sans Mono", 0, 12)); // NOI18N
        lblData.setText("Data");
        jPanel1.add(lblData, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 290, -1));

        jLabel3.setFont(new java.awt.Font("Bitstream Vera Sans Mono", 0, 12)); // NOI18N
        jLabel3.setText("Nº Caixa: *");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, -1, -1));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/imagens/cancel2.png"))); // NOI18N
        jButton1.setToolTipText("Sair");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 140, 50, 40));

        btConfirmar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/imagens/ok.png"))); // NOI18N
        btConfirmar.setToolTipText("Abrir Caixa");
        btConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btConfirmarActionPerformed(evt);
            }
        });
        jPanel1.add(btConfirmar, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 140, 50, 40));

        lbl.setFont(new java.awt.Font("Bitstream Vera Sans Mono", 1, 14)); // NOI18N
        lbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl.setText("ABRE CAIXA");
        jPanel1.add(lbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 320, -1));

        lblUsuario.setFont(new java.awt.Font("Bitstream Vera Sans Mono", 0, 12)); // NOI18N
        lblUsuario.setText("Usuario");
        jPanel1.add(lblUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 260, -1));

        cbNrCaixa.setFont(new java.awt.Font("Bitstream Vera Sans Mono", 0, 11)); // NOI18N
        cbNrCaixa.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "--", "001", "002", "003", "004", "005", "006", "007", "008", "009", "010" }));
        jPanel1.add(cbNrCaixa, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 180, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 340, 190));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btConfirmarActionPerformed
        if (Util.chkVazio(cbNrCaixa.getSelectedItem().toString())) {
            /*double valor = 0;
             try {
             valor = Double.parseDouble(tfValorInicial.getText().replaceAll(",", "."));
             } catch (Exception e) {
             JOptionPane.showMessageDialog(rootPane, "ERRO no valor!");
             return;
             }
             if (valor <= 0) {
             JOptionPane.showMessageDialog(rootPane, "O Valor Inicial deve ser Maior que 0!");
             tfValorInicial.requestFocus();
             return;
             }*/

            
            CaixaDAO cDAO = new CaixaDAO();
            String numeroC = (String) cbNrCaixa.getSelectedItem();
            if (cDAO.listCaixaAberto(numeroC).size() > 0) {
                Caixa caixa = cDAO.listCaixaAberto(numeroC).get(0);
                JOptionPane.showMessageDialog(rootPane, "Caixa de Nº "
                        + numeroC + ",\nfoi aberto pelo usuário: "
                        + caixa.getUser().getNome()
                        + "\ne ainda não foi encerrado!");
                return;
            }

            //adiciona primeiro caixa
            if (cDAO.checkExists("nrCaixa", numeroC).size() == 0) {
                double vlInicial = 0;
                do {
                    try {
                        vlInicial = Double.
                                parseDouble(JOptionPane.showInputDialog("Primeira Abertura do Caixa "
                                                + numeroC + ", Informe um valor Inicial: ").replaceFirst(",","."));
                    } catch (Exception e) {
                        vlInicial = -1;
                    }

                } while (vlInicial == -1);
                Caixa cInicial = new Caixa();
                cInicial.setAberto(false);
                cInicial.setDataAbriu(new Date());
                cInicial.setDataFechou(new Date());
                cInicial.setHoraAbriu(new Date());
                cInicial.setHoraFechou(new Date());
                cInicial.setNrCaixa(numeroC);
                cInicial.setRetirada(-1);
                cInicial.setUser(Ativo.getUsuario());
                cInicial.setValorFicaCaixa(vlInicial);

                cDAO.add(cInicial);

            }

            Caixa c = new Caixa();
            c.setAberto(true);
            c.setDataAbriu(new Date());
            c.setHoraAbriu(new Date());
            c.setUser(Ativo.getUsuario());
            c.setNrCaixa(numeroC);

            cDAO.add(c);
            dispose();

            Ativo.setCaixa(c);

        }
    }//GEN-LAST:event_btConfirmarActionPerformed

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
            java.util.logging.Logger.getLogger(TelaAbrirCaixa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaAbrirCaixa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaAbrirCaixa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaAbrirCaixa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaAbrirCaixa().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btConfirmar;
    private javax.swing.JComboBox cbNrCaixa;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lbl;
    private javax.swing.JLabel lblData;
    private javax.swing.JLabel lblUsuario;
    // End of variables declaration//GEN-END:variables
}
