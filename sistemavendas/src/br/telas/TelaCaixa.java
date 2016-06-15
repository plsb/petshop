/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.telas;

import br.caixageral.CaixaGeral;
import br.caixageral.CaixaGeralDAO;
import br.empresa.EmpresaDAO;
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
        
        EmpresaDAO eDAO = new EmpresaDAO();
        
        if(eDAO.list().size()==0){
            JOptionPane.showMessageDialog(rootPane, "Cadastre a Empresa!");
        }

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
        jButton1 = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();

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

        jPanel4.setBackground(new java.awt.Color(0, 153, 255));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbTexto.setFont(new java.awt.Font("Bitstream Vera Sans Mono", 1, 30)); // NOI18N
        lbTexto.setText("Caixa");
        jPanel4.add(lbTexto, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 460, 40));

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

        jLabel1.setFont(new java.awt.Font("Bitstream Vera Sans Mono", 0, 12)); // NOI18N
        jLabel1.setText("Saldo.:");

        tfSaldo.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));
        tfSaldo.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        tfSaldo.setEnabled(false);
        tfSaldo.setFont(new java.awt.Font("Bitstream Vera Sans Mono", 0, 12)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Bitstream Vera Sans Mono", 0, 12)); // NOI18N
        jLabel2.setText("Data.:");

        jLabel3.setFont(new java.awt.Font("Bitstream Vera Sans Mono", 0, 12)); // NOI18N
        jLabel3.setText("Entradas.:");

        jLabel4.setFont(new java.awt.Font("Bitstream Vera Sans Mono", 0, 12)); // NOI18N
        jLabel4.setText("Saídas.:");

        try {
            tfData1.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        tfData1.setEnabled(false);
        tfData1.setFont(new java.awt.Font("Bitstream Vera Sans Mono", 0, 12)); // NOI18N

        tfEntradas1.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));
        tfEntradas1.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        tfEntradas1.setEnabled(false);
        tfEntradas1.setFont(new java.awt.Font("Bitstream Vera Sans Mono", 0, 12)); // NOI18N

        tfSaidas.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));
        tfSaidas.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        tfSaidas.setEnabled(false);
        tfSaidas.setFont(new java.awt.Font("Bitstream Vera Sans Mono", 0, 12)); // NOI18N

        btPesquisar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/imagens/find.png"))); // NOI18N
        btPesquisar.setToolTipText("Pesquisar Data");
        btPesquisar.setEnabled(false);
        btPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btPesquisarActionPerformed(evt);
            }
        });

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/imagens/interface (5).png"))); // NOI18N
        jButton2.setToolTipText("Adicionar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/imagens/delete_gr.png"))); // NOI18N
        jButton1.setToolTipText("Excluir");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 590, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(40, 40, 40)
                                .addComponent(tfData1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel2))
                        .addGap(10, 10, 10)
                        .addComponent(btPesquisar))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 570, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(266, 266, 266)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel1))
                        .addGap(10, 10, 10)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfEntradas1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfSaidas, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfSaldo, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tfData1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(btPesquisar))
                .addGap(7, 7, 7)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(15, 15, 15)
                        .addComponent(jLabel4)
                        .addGap(15, 15, 15)
                        .addComponent(jLabel1))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(tfEntradas1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(9, 9, 9)
                        .addComponent(tfSaidas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(9, 9, 9)
                        .addComponent(tfSaldo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 590, 440));

        jMenu1.setText("Opções");
        jMenu1.setFont(new java.awt.Font("Bitstream Vera Sans Mono", 0, 12)); // NOI18N

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F5, 0));
        jMenuItem1.setFont(new java.awt.Font("Bitstream Vera Sans Mono", 0, 12)); // NOI18N
        jMenuItem1.setText("Abrir Caixa");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F6, 0));
        jMenuItem2.setFont(new java.awt.Font("Bitstream Vera Sans Mono", 0, 12)); // NOI18N
        jMenuItem2.setText("Fechar Caixa");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuItem3.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F7, 0));
        jMenuItem3.setFont(new java.awt.Font("Bitstream Vera Sans Mono", 0, 12)); // NOI18N
        jMenuItem3.setText("Sangria");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem3);

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
        if (Util.verificaPermissao("FECHA_CAIXA", 1)) {
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

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        if (Ativo.getCaixa() != null) {
            if (Util.verificaPermissao("REALIZAR_SANGRIA", 1)) {
                double valor = 0;
                try {
                    valor = Double.parseDouble(JOptionPane.showInputDialog("Valor Sangria: ").replaceFirst(",", "."));
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(rootPane, "Formato do valor Incorreto!");
                    return;
                }
                if (valor == 0) {
                    JOptionPane.showMessageDialog(rootPane, "Valor não pode ser 0!");
                    return;
                }
                LivroCaixaDAO lcDAO = new LivroCaixaDAO();
                double saldoCaixa = lcDAO.valorSaldoCaixa(Ativo.getCaixa());
                if (saldoCaixa > valor) {
                    //adiciona sangria como saída no caixa local
                    LivroCaixa lc = new LivroCaixa();
                    lc.setCaixa(Ativo.getCaixa());
                    lc.setData(new Date());
                    lc.setDescricao("SANGRIA");
                    lc.setValorSaida(valor);
                    lc.setValorEntrada(0);

                    lcDAO.add(lc);
                    btPesquisarActionPerformed(evt);

                    //adiciona sangria como entrada no caixa geral
                    CaixaGeral cg = new CaixaGeral();
                    CaixaGeralDAO cgDAO = new CaixaGeralDAO();
                    cg.setData(new Date());
                    cg.setDescricao("SANGRIA DO CAIXA " + Ativo.getCaixa().getNrCaixa() + " de "
                            + Ativo.getUsuario().getNome());
                    cg.setValorEntrada(valor);
                    cg.setValorSaida(0);
                    cgDAO.add(cg);

                } else {
                    JOptionPane.showMessageDialog(rootPane, "Valor da Sangria deve ser superior ao valor do Caixa!");
                    return;
                }
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Caixa Fechado!");
        }
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (Util.verificaPermissao("EXCLUIR_CAIXA", 1)) {
            
            int i = tb.getSelectedRow();
            if (i > 0) {

                if (JOptionPane.showConfirmDialog(rootPane, "Deseja excluir o Ítem Selecionado?",
                        "", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                    LivroCaixaTableModel cgtm = (LivroCaixaTableModel) tb.getModel();
                    LivroCaixa cg = cgtm.getValueAt(i);
                    LivroCaixaDAO dao = new LivroCaixaDAO();
                    dao.remove(cg);
                    btPesquisarActionPerformed(null);

                }

            } else {
                JOptionPane.showMessageDialog(rootPane, "Selecione uma Linha!");
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

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
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
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
