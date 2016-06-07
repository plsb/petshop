/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.telas;

import br.livro.LivroCaixa;
import br.livro.LivroCaixaDAO;
import br.livro.LivroCaixaTableModel;
import br.util.Ativo;
import br.util.FormataTamanhoColunasJTable;
import br.util.HibernateUtil;
import br.util.Util;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Pedro Saraiva
 */
public class TelaCaixa extends javax.swing.JDialog {

    /**
     * Creates new form TelaCaixa
     */
    public TelaCaixa() {
        initComponents();
        setModal(true);
        setLocationRelativeTo(null);

        preencheTabela(new Date());
        setTitle("Caixa");

    }

    public void preencheTabela(Date data) {
        SimpleDateFormat dfdtData;
        dfdtData = new SimpleDateFormat("dd/MM/yyyy");
        tfData1.setText(dfdtData.format(data));

        LivroCaixaDAO lcDAO = new LivroCaixaDAO();
        List<LivroCaixa> lista = lcDAO.listCaixaPorUsuario(data);
        LivroCaixaTableModel lctm = new LivroCaixaTableModel(lista);
        tb.setModel(lctm);
        FormataTamanhoColunasJTable.packColumns(tb, 1);
        double entrada = 0, saida = 0;
        for (LivroCaixa listalc : lista) {
            entrada += listalc.getValorEntrada();
            saida += listalc.getValorSaida();
        }
        double saldo = entrada - saida;
        tfEntradas1.setText(String.format("%.2f", entrada));
        tfSaidas.setText(String.format("%.2f", saida));
        tfSaldo.setText(String.format("%.2f", saldo));

        if (Util.verificaCaixaAberto()) {
            lbTexto.setText("Caixa " + Ativo.getCaixa().getNrCaixa() + " Aberto");
        } else {
            lbTexto.setText("Caixa Fechado");
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
        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        lbTexto = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tb = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        tfSaldo = new javax.swing.JFormattedTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        tfData1 = new javax.swing.JFormattedTextField();
        tfEntradas1 = new javax.swing.JFormattedTextField();
        tfSaidas = new javax.swing.JFormattedTextField();
        btPesquisar = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setBackground(new java.awt.Color(0, 153, 255));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbTexto.setFont(new java.awt.Font("Bitstream Vera Sans Mono", 1, 30)); // NOI18N
        lbTexto.setText("Caixa");
        jPanel4.add(lbTexto, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 460, 40));

        jPanel2.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 590, 40));

        jScrollPane1.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N

        tb.setFont(new java.awt.Font("Bitstream Vera Sans Mono", 0, 11)); // NOI18N
        tb.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tb);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 570, 230));

        jLabel1.setFont(new java.awt.Font("Bitstream Vera Sans Mono", 0, 12)); // NOI18N
        jLabel1.setText("Saldo.:");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 390, -1, -1));

        tfSaldo.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));
        tfSaldo.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        tfSaldo.setEnabled(false);
        tfSaldo.setFont(new java.awt.Font("Bitstream Vera Sans Mono", 0, 12)); // NOI18N
        jPanel2.add(tfSaldo, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 390, 110, -1));

        jLabel2.setFont(new java.awt.Font("Bitstream Vera Sans Mono", 0, 12)); // NOI18N
        jLabel2.setText("Data.:");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, -1, -1));

        jLabel3.setFont(new java.awt.Font("Bitstream Vera Sans Mono", 0, 12)); // NOI18N
        jLabel3.setText("Entradas.:");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 330, -1, -1));

        jLabel4.setFont(new java.awt.Font("Bitstream Vera Sans Mono", 0, 12)); // NOI18N
        jLabel4.setText("Saídas.:");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 360, -1, -1));

        try {
            tfData1.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        tfData1.setEnabled(false);
        tfData1.setFont(new java.awt.Font("Bitstream Vera Sans Mono", 0, 12)); // NOI18N
        jPanel2.add(tfData1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 50, 150, -1));

        tfEntradas1.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));
        tfEntradas1.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        tfEntradas1.setEnabled(false);
        tfEntradas1.setFont(new java.awt.Font("Bitstream Vera Sans Mono", 0, 12)); // NOI18N
        jPanel2.add(tfEntradas1, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 330, 110, -1));

        tfSaidas.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));
        tfSaidas.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        tfSaidas.setEnabled(false);
        tfSaidas.setFont(new java.awt.Font("Bitstream Vera Sans Mono", 0, 12)); // NOI18N
        jPanel2.add(tfSaidas, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 360, 110, -1));

        btPesquisar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/imagens/find.png"))); // NOI18N
        btPesquisar.setToolTipText("Pesquisar Data");
        btPesquisar.setEnabled(false);
        btPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btPesquisarActionPerformed(evt);
            }
        });
        jPanel2.add(btPesquisar, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 50, -1, -1));

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/imagens/interface (5).png"))); // NOI18N
        jButton2.setToolTipText("Adicionar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 340, 70, -1));

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/imagens/printlarge.png"))); // NOI18N
        jButton3.setToolTipText("Imprimir");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 340, 70, -1));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 590, 440));

        jMenu1.setText("Opções");
        jMenu1.setFont(new java.awt.Font("Bitstream Vera Sans Mono", 0, 12)); // NOI18N

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F2, 0));
        jMenuItem1.setFont(new java.awt.Font("Bitstream Vera Sans Mono", 0, 12)); // NOI18N
        jMenuItem1.setText("Abrir Caixa");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F3, 0));
        jMenuItem2.setFont(new java.awt.Font("Bitstream Vera Sans Mono", 0, 12)); // NOI18N
        jMenuItem2.setText("Fechar Caixa");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btPesquisarActionPerformed
        // TODO add your handling code here:
        if (tfData1.equals("  /  /    ")) {
            JOptionPane.showMessageDialog(rootPane, "Informe a Data!");

        } else {
            tfData1.requestFocus();
            String dataString = tfData1.getText();
            try {
                DateFormat fmt = new SimpleDateFormat("dd/MM/yyyy");
                java.util.Date data;
                data = new java.util.Date(fmt.parse(dataString).getTime());
                preencheTabela(data);
            } catch (ParseException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }//GEN-LAST:event_btPesquisarActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        if (Util.verificaPermissao("ADICIONA_CAIXA", 1)) {

            if (!Util.verificaCaixaAberto()) {
                JOptionPane.showMessageDialog(rootPane, "Caixa Fechado!");
                return;
            }

            TelaAdicionaCaixa tac = new TelaAdicionaCaixa();
            tac.setVisible(true);
            preencheTabela(new Date());
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        if (Util.verificaPermissao("IMPRIMIR_CAIXA", 1)) {
            if (tfData1.getText().equals("  /  /    ")) {
                JOptionPane.showMessageDialog(rootPane, "Informe a data!");
                tfData1.requestFocus();
                return;
            }
            JasperReport pathjrxml;
            HashMap parametros = new HashMap();

            String sql = "";

            String dataInicial = "";
            try {
                SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
                java.sql.Date data = new java.sql.Date(format.parse(tfData1.getText()).getTime());
                dataInicial = String.valueOf(data);
            } catch (ParseException e) {
                e.printStackTrace();
            }

            sql = "'" + dataInicial + "'";

            try {
                parametros.put("sql", sql);
            } catch (Exception e) {
            }

            String caminho = Util.retornaCaminhoApp();
//        String caminho = "";

            Connection connection = HibernateUtil.getSessionFactory().openStatelessSession().connection();
            try {
                JDialog viewer = new JDialog(new javax.swing.JFrame(), "Visualização do Relatório", true);
                viewer.setSize(1200, 600);
                viewer.setLocationRelativeTo(null);
                viewer.setModal(true);
                File file = new File(caminho + "relatorios/reportLivroCaixa.jrxml");
                FileInputStream is = new FileInputStream(file);
                pathjrxml = JasperCompileManager.compileReport(is);
                JasperPrint printReport = JasperFillManager.fillReport(pathjrxml, parametros,
                        connection);
                JasperViewer jv = new JasperViewer(printReport, false);
                viewer.getContentPane().add(jv.getContentPane());
                viewer.setVisible(true);
                //JasperExportManager.exportReportToPdfFile(printReport, "src/relatorios/RelAcervo.pdf");

                //jv.setVisible(true);
            } catch (JRException ex) {
                JOptionPane.showMessageDialog(rootPane, ex.getMessage());
            } catch (FileNotFoundException ex) {
                JOptionPane.showMessageDialog(rootPane, ex.getMessage());
            }
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        if (Util.verificaPermissao("ADICIONA_CAIXA", 1)) {
            if (Util.verificaCaixaAberto()) {
                JOptionPane.showMessageDialog(rootPane, "Caixa está Aberto!");
            } else {
                TelaAbrirCaixa tac = new TelaAbrirCaixa();
                tac.setVisible(true);
                if (Util.verificaCaixaAberto()) {
                    lbTexto.setText("Caixa " + Ativo.getCaixa().getNrCaixa() + " Aberto");

                } else {
                    lbTexto.setText("Caixa Fechado");
                }

            }
        }
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        if (Util.verificaPermissao("ADICIONA_CAIXA", 1)) {
            if (!Util.verificaCaixaAberto()) {
                JOptionPane.showMessageDialog(rootPane, "Caixa está Fechado!");
            } else {
                TelaFechaCaixa tfc = new TelaFechaCaixa();
                tfc.setVisible(true);
                
                if (Util.verificaCaixaAberto()) {
                    lbTexto.setText("Caixa " + Ativo.getCaixa().getNrCaixa() + " Aberto");

                } else {
                    lbTexto.setText("Caixa Fechado");
                }
                btPesquisarActionPerformed(evt);
            }
        }
    }//GEN-LAST:event_jMenuItem2ActionPerformed

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
            java.util.logging.Logger.getLogger(TelaCaixa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaCaixa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaCaixa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaCaixa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaCaixa().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btPesquisar;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbTexto;
    private javax.swing.JTable tb;
    private javax.swing.JFormattedTextField tfData1;
    private javax.swing.JFormattedTextField tfEntradas1;
    private javax.swing.JFormattedTextField tfSaidas;
    private javax.swing.JFormattedTextField tfSaldo;
    // End of variables declaration//GEN-END:variables
}
