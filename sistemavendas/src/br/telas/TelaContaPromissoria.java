/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.telas;

import br.cliente.Cliente;
import br.cliente.ClienteDAO;
import br.contasreceber.ContaReceberCellRenderer;
import br.contasreceber.ContasReceber;
import br.contasreceber.ContasReceberDAO;
import br.contasreceber.ContasReceberTableModel;
import br.util.FormataTamanhoColunasJTable;
import br.util.Util;
import java.awt.event.KeyEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
    
    public TelaContaPromissoria() {
        initComponents();
        setTitle("Contas à Receber");
        setModal(true);
        setLocationRelativeTo(null);
        preencheCliente();
        preencheTabela(new ArrayList<ContasReceber>());
        rbContasAbert.setSelected(true);
        SimpleDateFormat dfdtData;
        dfdtData = new SimpleDateFormat("dd/MM/yyyy");
        tfDataInicio.setText(dfdtData.format(new Date()));
        tfDataFim.setText(dfdtData.format(new Date()));
        if (cliente != null) {
            cbCliente.setSelectedItem(cliente);
            cbCliente.setEnabled(false);
            rbContasAbert.setEnabled(false);
            rbContasPagas.setEnabled(false);
            btPesquisarActionPerformed(null);
            
            ContasReceberDAO dao = new ContasReceberDAO();
            List<ContasReceber> lista = dao.checkExists("cliente", cliente);
            if (lista.size() > 0) {
                tfDataInicio.setText(dfdtData.format(lista.get(lista.size()-1).getDataVencimento()));
            }
        }
        
        btPesquisarActionPerformed(null);
        
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
        jScrollPane1 = new javax.swing.JScrollPane();
        tbContas = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        lblVencer1 = new javax.swing.JLabel();
        btReceber = new javax.swing.JButton();
        btEdit = new javax.swing.JButton();
        btNovo3 = new javax.swing.JButton();
        btRemover = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        rbContasPagas = new javax.swing.JRadioButton();
        rbContasAbert = new javax.swing.JRadioButton();
        btPesquisar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        cbCliente = new javax.swing.JComboBox();
        tfDataInicio = new javax.swing.JFormattedTextField();
        tfDataFim = new javax.swing.JFormattedTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tbContas.setFont(new java.awt.Font("Bitstream Vera Sans Mono", 0, 12)); // NOI18N
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
        tbContas.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tbContasKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(tbContas);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 660, 210));

        jLabel4.setFont(new java.awt.Font("Bitstream Vera Sans Mono", 0, 12)); // NOI18N
        jLabel4.setText("Valor Débito.: ");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 320, -1, -1));

        lblVencer1.setFont(new java.awt.Font("Bitstream Vera Sans Mono", 0, 12)); // NOI18N
        lblVencer1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblVencer1.setText("0,00");
        jPanel1.add(lblVencer1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 320, 80, -1));

        btReceber.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/imagens/valuetotal.png"))); // NOI18N
        btReceber.setToolTipText("Receber Conta");
        btReceber.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btReceberActionPerformed(evt);
            }
        });
        jPanel1.add(btReceber, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 330, 43, -1));

        btEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/imagens/pen.png"))); // NOI18N
        btEdit.setToolTipText("Editar Conta");
        btEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEditActionPerformed(evt);
            }
        });
        jPanel1.add(btEdit, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 330, 43, -1));

        btNovo3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/imagens/new.png"))); // NOI18N
        btNovo3.setToolTipText("Nova Conta");
        btNovo3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btNovo3ActionPerformed(evt);
            }
        });
        jPanel1.add(btNovo3, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 330, 43, -1));

        btRemover.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/imagens/delete.png"))); // NOI18N
        btRemover.setToolTipText("Excluir Conta");
        btRemover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btRemoverActionPerformed(evt);
            }
        });
        jPanel1.add(btRemover, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 330, 43, -1));

        jPanel3.setBackground(new java.awt.Color(255, 0, 0));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 18, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 18, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 350, 20, 20));

        jLabel1.setFont(new java.awt.Font("Bitstream Vera Sans Mono", 0, 12)); // NOI18N
        jLabel1.setText("Contas em Atraso");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 350, -1, 20));

        jLabel3.setFont(new java.awt.Font("Bitstream Vera Sans Mono", 0, 12)); // NOI18N
        jLabel3.setText("Contas à Vencer");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 350, -1, 20));

        jPanel4.setBackground(new java.awt.Color(0, 51, 204));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 18, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 18, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 350, 20, 20));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/imagens/close.png"))); // NOI18N
        jButton1.setToolTipText("Sair");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 330, 40, 40));

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btContas.add(rbContasPagas);
        rbContasPagas.setFont(new java.awt.Font("Bitstream Vera Sans Mono", 0, 11)); // NOI18N
        rbContasPagas.setText("Contas Pagas");
        rbContasPagas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbContasPagasActionPerformed(evt);
            }
        });
        jPanel2.add(rbContasPagas, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 40, -1, -1));

        btContas.add(rbContasAbert);
        rbContasAbert.setFont(new java.awt.Font("Bitstream Vera Sans Mono", 0, 11)); // NOI18N
        rbContasAbert.setText("Contas em Aberto");
        rbContasAbert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbContasAbertActionPerformed(evt);
            }
        });
        jPanel2.add(rbContasAbert, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 10, -1, -1));

        btPesquisar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/imagens/find.png"))); // NOI18N
        btPesquisar.setToolTipText("Pesquisar");
        btPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btPesquisarActionPerformed(evt);
            }
        });
        jPanel2.add(btPesquisar, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 40, 40, -1));

        jLabel2.setFont(new java.awt.Font("Bitstream Vera Sans Mono", 0, 12)); // NOI18N
        jLabel2.setText("Cliente.: ");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        cbCliente.setFont(new java.awt.Font("Bitstream Vera Sans Mono", 0, 12)); // NOI18N
        cbCliente.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "--" }));
        cbCliente.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                cbClienteFocusLost(evt);
            }
        });
        jPanel2.add(cbCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 10, 340, -1));

        try {
            tfDataInicio.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        tfDataInicio.setFont(new java.awt.Font("Bitstream Vera Sans Mono", 0, 12)); // NOI18N
        jPanel2.add(tfDataInicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 40, 110, -1));

        try {
            tfDataFim.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        tfDataFim.setFont(new java.awt.Font("Bitstream Vera Sans Mono", 0, 12)); // NOI18N
        jPanel2.add(tfDataFim, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 40, 110, -1));

        jLabel5.setFont(new java.awt.Font("Bitstream Vera Sans Mono", 0, 12)); // NOI18N
        jLabel5.setText("Venc. Fim:");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 40, -1, -1));

        jLabel6.setFont(new java.awt.Font("Bitstream Vera Sans Mono", 0, 12)); // NOI18N
        jLabel6.setText("Venc. Inicio:");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, -1, -1));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 660, 80));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 680, 380));

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
        tbContas.setDefaultRenderer(Object.class,
                new ContaReceberCellRenderer());
        
    }

    private void btPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btPesquisarActionPerformed
        if (!tfDataInicio.getText().equals("  /  /    ")
                && !tfDataFim.getText().equals("  /  /    ")) {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            sdf.setLenient(false);
            String dataString = tfDataInicio.getText();
            Date iniDate = null, endDate = null;
            
            try {
                Date data = sdf.parse(dataString);
                iniDate = data;
                // se passou pra cá, é porque a data é válida
            } catch (ParseException e) {
                // se cair aqui, a data é inválida
                JOptionPane.showMessageDialog(rootPane, "Data Inicial Incorreta!");
                return;
            }
            
            dataString = tfDataFim.getText();
            try {
                Date data = sdf.parse(dataString);
                endDate = data;
                // se passou pra cá, é porque a data é válida
            } catch (ParseException e) {
                // se cair aqui, a data é inválida
                JOptionPane.showMessageDialog(rootPane, "Data Fim Incorreta!");
                return;
            }
            
            ContasReceberDAO crDAO = new ContasReceberDAO();
            preencheTabela(crDAO.listaContasCliente(
                    cbCliente.getSelectedIndex() == 0 ? null : (Cliente) cbCliente.getSelectedItem(),
                    rbContasPagas.isSelected(), iniDate, endDate));
            
        } else {
            JOptionPane.showMessageDialog(rootPane, "Informe as Datas!");
        }
    }//GEN-LAST:event_btPesquisarActionPerformed

    private void btReceberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btReceberActionPerformed
        if (Util.verificaPermissao("RECEBER_CONTA_RECEBER", 1)) {
            if (!Util.verificaCaixaAberto()) {
                JOptionPane.showMessageDialog(rootPane, "Caixa Fechado!");
                return;
            }
            
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

    private void tbContasKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tbContasKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            btReceberActionPerformed(null);
        }
    }//GEN-LAST:event_tbContasKeyPressed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        dispose();
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
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblVencer1;
    private javax.swing.JRadioButton rbContasAbert;
    private javax.swing.JRadioButton rbContasPagas;
    private javax.swing.JTable tbContas;
    private javax.swing.JFormattedTextField tfDataFim;
    private javax.swing.JFormattedTextField tfDataInicio;
    // End of variables declaration//GEN-END:variables

}
