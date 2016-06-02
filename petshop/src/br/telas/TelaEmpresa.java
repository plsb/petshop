/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.telas;

import br.cliente.*;
import br.empresa.Empresa;
import br.empresa.EmpresaDAO;
import br.util.Util;
import javax.swing.JOptionPane;

/**
 *
 * @author Pedro Saraiva
 */
public class TelaEmpresa extends javax.swing.JDialog {

    /**
     * Creates new form TelaCliente
     */
    public TelaEmpresa() {
        initComponents();
        setModal(true);
        setTitle("Adiciona/Edita Empresa");
        setLocationRelativeTo(null);

        if (dao.list().size() > 0) {
            empresa = dao.list().get(0);
            tfRazaoSocial.setText(empresa.getRazaoSocial());
            tfNomeFantasia.setText(empresa.getNomeFantasia());
            tfEndereco.setText(empresa.getEndereco());
            tfCidade.setText(empresa.getCidade());
            tfIE.setText(empresa.getIe());
            tfTelefone.setText(empresa.getTelefone());
            cbEstado.setSelectedItem(empresa.getEstado());
            tfCNPJ.setText(empresa.getCnpj());
        }

    }

    private Empresa empresa;
    private EmpresaDAO dao = new EmpresaDAO();

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        sexo = new javax.swing.ButtonGroup();
        jPanel4 = new javax.swing.JPanel();
        lbTexto = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        btCancelar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        tfRazaoSocial = new javax.swing.JTextField();
        tfEndereco = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        tfTelefone = new javax.swing.JFormattedTextField();
        jLabel3 = new javax.swing.JLabel();
        tfCNPJ = new javax.swing.JFormattedTextField();
        jLabel5 = new javax.swing.JLabel();
        btSalvar = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        tfCidade = new javax.swing.JTextField();
        cbEstado = new javax.swing.JComboBox();
        jLabel29 = new javax.swing.JLabel();
        tfIE = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        tfNomeFantasia = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setBackground(new java.awt.Color(0, 153, 255));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbTexto.setFont(new java.awt.Font("Verdana", 1, 30)); // NOI18N
        lbTexto.setText("Empresa");
        jPanel4.add(lbTexto, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 210, 40));

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
        jPanel1.add(btCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 340, 43, 41));

        jLabel1.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel1.setText("Razão Social.: *");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, -1));

        tfRazaoSocial.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jPanel1.add(tfRazaoSocial, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 400, -1));

        tfEndereco.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jPanel1.add(tfEndereco, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, 400, -1));

        jLabel2.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel2.setText("Telefone.: ");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, -1, -1));

        try {
            tfTelefone.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        tfTelefone.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        tfTelefone.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                tfTelefoneFocusLost(evt);
            }
        });
        jPanel1.add(tfTelefone, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 240, 160, -1));

        jLabel3.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel3.setText("Endereço.: *");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, -1, -1));

        try {
            tfCNPJ.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##.###.###/####-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        tfCNPJ.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jPanel1.add(tfCNPJ, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 290, 160, -1));

        jLabel5.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel5.setText("CNPJ.: *");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 270, -1, -1));

        btSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/imagens/pataverde.png"))); // NOI18N
        btSalvar.setToolTipText("Salvar");
        btSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSalvarActionPerformed(evt);
            }
        });
        jPanel1.add(btSalvar, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 340, 43, -1));

        jLabel6.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel6.setText("Cidade.: *");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, -1, -1));

        tfCidade.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jPanel1.add(tfCidade, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, 230, -1));

        cbEstado.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        cbEstado.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "--", "AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MT", "MS", "MG", "PA", "PB", "PR", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO" }));
        jPanel1.add(cbEstado, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 190, 160, -1));

        jLabel29.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel29.setText("Estado.:*");
        jPanel1.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 170, -1, -1));

        tfIE.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jPanel1.add(tfIE, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 290, 190, -1));

        jLabel7.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel7.setText("Inscrição Estadual.: *");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 270, -1, -1));

        tfNomeFantasia.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jPanel1.add(tfNomeFantasia, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 400, -1));

        jLabel8.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel8.setText("Nome Fantasia.: *");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 430, 400));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelarActionPerformed
        setVisible(false);
    }//GEN-LAST:event_btCancelarActionPerformed

    private void btSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSalvarActionPerformed
        if (Util.verificaPermissao("CE_EMPRESA", 1)) {
            if (empresa == null) {
                empresa = new Empresa();
            }
            if (Util.chkVazio(tfRazaoSocial.getText(), tfNomeFantasia.getText(), tfTelefone.getText(), tfCNPJ.getText(),
                    cbEstado.getSelectedItem().toString(), tfCidade.getText(), tfEndereco.getText(),
                    tfIE.getText())) {

                empresa.setRazaoSocial(tfRazaoSocial.getText());
                empresa.setNomeFantasia(tfNomeFantasia.getText());
                empresa.setEndereco(tfEndereco.getText());
                empresa.setCidade(tfCidade.getText());
                empresa.setEstado(cbEstado.getSelectedItem().toString());
                empresa.setTelefone(tfTelefone.getText().replaceAll("\\D*", ""));
                empresa.setIe(tfIE.getText());
                if (!Util.isCnpjValido(tfCNPJ.getText().replaceAll("\\D*", ""))) {
                    JOptionPane.showMessageDialog(rootPane, "CNPJ Inválido!", "ERROR", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                empresa.setCnpj(tfCNPJ.getText().replaceAll("\\D*", ""));

                if (empresa.getId() == null) {

                    dao.add(empresa);
                    JOptionPane.showMessageDialog(rootPane, "Empresa Cadastrada Com Sucesso!", "INFO", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    dao.update(empresa);
                    JOptionPane.showMessageDialog(rootPane, "Empresa Editada Com Sucesso!", "INFO", JOptionPane.INFORMATION_MESSAGE);
                }
//            limpaCampos();
            }
        }
    }//GEN-LAST:event_btSalvarActionPerformed

    private void tfTelefoneFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfTelefoneFocusLost
        if (!Util.isCnpjValido(tfCNPJ.getText().replaceAll("\\D*", ""))) {
            JOptionPane.showMessageDialog(rootPane, "CNPJ Inválido!", "ERROR", JOptionPane.ERROR_MESSAGE);
            tfCNPJ.setText("");
        }

    }//GEN-LAST:event_tfTelefoneFocusLost

    private void limpaCampos() {
        empresa = new Empresa();
        tfCNPJ.setText("");
        tfEndereco.setText("");
        tfRazaoSocial.setText("");
        tfNomeFantasia.setText("");
        tfTelefone.setText("");
        tfCidade.setText("");
        cbEstado.setSelectedIndex(0);
        tfIE.setText("");
    }

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
            java.util.logging.Logger.getLogger(TelaEmpresa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaEmpresa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaEmpresa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaEmpresa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaEmpresa().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btCancelar;
    private javax.swing.JButton btSalvar;
    private javax.swing.JComboBox cbEstado;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JLabel lbTexto;
    private javax.swing.ButtonGroup sexo;
    private javax.swing.JFormattedTextField tfCNPJ;
    private javax.swing.JTextField tfCidade;
    private javax.swing.JTextField tfEndereco;
    private javax.swing.JTextField tfIE;
    private javax.swing.JTextField tfNomeFantasia;
    private javax.swing.JTextField tfRazaoSocial;
    private javax.swing.JFormattedTextField tfTelefone;
    // End of variables declaration//GEN-END:variables
}
