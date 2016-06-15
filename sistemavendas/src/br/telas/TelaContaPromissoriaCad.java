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
import br.util.HibernateUtil;
import br.util.Util;
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
public class TelaContaPromissoriaCad extends javax.swing.JDialog {

    public static void chamaEdita(ContasReceber cr) {
        TelaContaPromissoriaCad.cr = cr;
        new TelaContaPromissoriaCad().setVisible(true);
    }

    /**
     * Creates new form TelaCliente
     */
    public TelaContaPromissoriaCad() {
        initComponents();
        setModal(true);
        setTitle("Adiciona/Edita Conta à Receber");
        setLocationRelativeTo(null);
        preencheCliente();
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
        if (cr != null) {
            cbCliente.setSelectedItem(cr.getCliente());
            cbCliente.setEnabled(false);
            Date dt = cr.getDataVencimento();
            SimpleDateFormat dfdtData;
            dfdtData = new SimpleDateFormat("dd/MM/yyyy");
            tfDataVencimento.setText(dfdtData.format(dt));

            dt = cr.getDataCadastro();
            dfdtData = new SimpleDateFormat("dd/MM/yyyy");
            tfDataCompra.setText(dfdtData.format(dt));
            tfNrConta.setText(cr.getNrConta());
            tfNrConta.setEnabled(false);
            tfNrParcela.setText(String.valueOf(cr.getNrParcela()));
            tfNrParcela.setEnabled(false);
            tfValor.setText(String.valueOf(cr.getValor()).replace(".", ","));
        }
    }

    private static ContasReceber cr = null;
    private ContasReceberDAO dao = new ContasReceberDAO();

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
        jLabel3 = new javax.swing.JLabel();
        cbCliente = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        tfDataVencimento = new javax.swing.JFormattedTextField();
        jLabel5 = new javax.swing.JLabel();
        tfNrParcela = new javax.swing.JFormattedTextField();
        jLabel6 = new javax.swing.JLabel();
        tfDataCompra = new javax.swing.JFormattedTextField();
        jLabel7 = new javax.swing.JLabel();
        tfNrConta = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setBackground(new java.awt.Color(0, 153, 255));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbTexto.setFont(new java.awt.Font("Bitstream Vera Sans Mono", 1, 30)); // NOI18N
        lbTexto.setText("Conta à Receber");
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

        jLabel2.setFont(new java.awt.Font("Bitstream Vera Sans Mono", 0, 12)); // NOI18N
        jLabel2.setText("Valor.: *");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, -1, -1));

        tfValor.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));
        tfValor.setFont(new java.awt.Font("Bitstream Vera Sans Mono", 0, 12)); // NOI18N
        tfValor.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                tfValorFocusLost(evt);
            }
        });
        jPanel1.add(tfValor, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, 180, -1));

        btSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/imagens/pataverde.png"))); // NOI18N
        btSalvar.setToolTipText("Salvar");
        btSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSalvarActionPerformed(evt);
            }
        });
        jPanel1.add(btSalvar, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 220, 43, -1));

        jLabel3.setFont(new java.awt.Font("Bitstream Vera Sans Mono", 0, 12)); // NOI18N
        jLabel3.setText("Cliente.: *");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        cbCliente.setFont(new java.awt.Font("Bitstream Vera Sans Mono", 0, 12)); // NOI18N
        cbCliente.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "--" }));
        cbCliente.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                cbClienteFocusLost(evt);
            }
        });
        jPanel1.add(cbCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 340, -1));

        jLabel4.setFont(new java.awt.Font("Bitstream Vera Sans Mono", 0, 12)); // NOI18N
        jLabel4.setText("Data Vencimento.: *");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 60, -1, -1));

        try {
            tfDataVencimento.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        tfDataVencimento.setFont(new java.awt.Font("Bitstream Vera Sans Mono", 0, 12)); // NOI18N
        tfDataVencimento.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                tfDataVencimentoFocusLost(evt);
            }
        });
        jPanel1.add(tfDataVencimento, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 80, 180, -1));

        jLabel5.setFont(new java.awt.Font("Bitstream Vera Sans Mono", 0, 12)); // NOI18N
        jLabel5.setText("Nr Parcela.: *");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 110, -1, -1));

        tfNrParcela.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));
        tfNrParcela.setFont(new java.awt.Font("Bitstream Vera Sans Mono", 0, 12)); // NOI18N
        jPanel1.add(tfNrParcela, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 130, 180, -1));

        jLabel6.setFont(new java.awt.Font("Bitstream Vera Sans Mono", 0, 12)); // NOI18N
        jLabel6.setText("Nr Conta.: *");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, -1, -1));

        try {
            tfDataCompra.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        tfDataCompra.setFont(new java.awt.Font("Bitstream Vera Sans Mono", 0, 12)); // NOI18N
        tfDataCompra.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                tfDataCompraFocusLost(evt);
            }
        });
        jPanel1.add(tfDataCompra, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 180, -1));

        jLabel7.setFont(new java.awt.Font("Bitstream Vera Sans Mono", 0, 12)); // NOI18N
        jLabel7.setText("Data Compra.: *");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, -1, -1));

        tfNrConta.setFont(new java.awt.Font("Bitstream Vera Sans Mono", 0, 12)); // NOI18N
        jPanel1.add(tfNrConta, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 180, 20));

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/imagens/add (1).png"))); // NOI18N
        jButton2.setToolTipText("Cadastrar Gruppo de Produtos");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 30, 30, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 430, 270));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelarActionPerformed
        limpaCampos();
    }//GEN-LAST:event_btCancelarActionPerformed

    private void btSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSalvarActionPerformed
        if (cr == null) {
            cr = new ContasReceber();
        }
        if (Util.chkVazio(cbCliente.getSelectedItem().toString(), tfValor.getText(),
                tfDataVencimento.getText(), tfDataCompra.getText(), tfNrParcela.getText(), tfNrConta.getText())) {
            cr.setCliente((Cliente) cbCliente.getSelectedItem());
            cr.setValor(Double.parseDouble(tfValor.getText().replace(",", ".")));
            cr.setPaga(false);
            cr.setNrParcela(Integer.parseInt(tfNrParcela.getText()));
            cr.setNrConta(tfNrConta.getText());

            String dataString = tfDataVencimento.getText();
            try {
                DateFormat fmt = new SimpleDateFormat("dd/MM/yyyy");
                java.util.Date data;
                data = new java.util.Date(fmt.parse(dataString).getTime());
                cr.setDataVencimento(data);
            } catch (ParseException ex) {
                System.out.println(ex.getMessage());
            }

            dataString = tfDataCompra.getText();
            try {
                DateFormat fmt = new SimpleDateFormat("dd/MM/yyyy");
                java.util.Date data;
                data = new java.util.Date(fmt.parse(dataString).getTime());
                cr.setDataCadastro(data);
            } catch (ParseException ex) {
                System.out.println(ex.getMessage());
            }

            if (cr.getId() == null) {
                if (dao.add(cr)) {
                    JOptionPane.showMessageDialog(rootPane, "Conta à Receber Cadastrado Com Sucesso!", "INFO", JOptionPane.INFORMATION_MESSAGE);
                }
            } else {
                if (dao.update(cr)) {
                    JOptionPane.showMessageDialog(rootPane, "Conta à Receber Editado Com Sucesso!", "INFO", JOptionPane.INFORMATION_MESSAGE);
                }
            }
            limpaCampos();
        }
    }//GEN-LAST:event_btSalvarActionPerformed

    private void limpaCampos() {
        cr = null;
        setVisible(false);

    }

    private void cbClienteFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cbClienteFocusLost

    }//GEN-LAST:event_cbClienteFocusLost

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        limpaCampos();
    }//GEN-LAST:event_formWindowClosing

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        limpaCampos();
    }//GEN-LAST:event_formWindowClosed

    private void tfValorFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfValorFocusLost
        if (Util.verificaValor(tfValor.getText(), 0) == null) {
            tfValor.setText("");
        }
    }//GEN-LAST:event_tfValorFocusLost

    private void tfDataCompraFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfDataCompraFocusLost
        if (Util.verificaData(tfDataCompra.getText()) == null) {
            JOptionPane.showMessageDialog(rootPane, "Data inválida!");
            tfDataCompra.setText("");
        }
    }//GEN-LAST:event_tfDataCompraFocusLost

    private void tfDataVencimentoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfDataVencimentoFocusLost
        if (Util.verificaData(tfDataVencimento.getText()) == null) {
            JOptionPane.showMessageDialog(rootPane, "Data inválida!");
            tfDataVencimento.setText("");
        }
    }//GEN-LAST:event_tfDataVencimentoFocusLost

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if (Util.verificaPermissao("CE_CLIENTE", 1)) {
            TelaCliente tc = new TelaCliente();
            tc.setVisible(true);
            preencheCliente();
        }
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(TelaContaPromissoriaCad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaContaPromissoriaCad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaContaPromissoriaCad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaContaPromissoriaCad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaContaPromissoriaCad().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btCancelar;
    private javax.swing.JButton btSalvar;
    private javax.swing.JComboBox cbCliente;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JLabel lbTexto;
    private javax.swing.JFormattedTextField tfDataCompra;
    private javax.swing.JFormattedTextField tfDataVencimento;
    private javax.swing.JTextField tfNrConta;
    private javax.swing.JFormattedTextField tfNrParcela;
    private javax.swing.JFormattedTextField tfValor;
    // End of variables declaration//GEN-END:variables
}
