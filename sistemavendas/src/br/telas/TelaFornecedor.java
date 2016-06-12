/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.telas;

import br.cliente.*;
import br.fornecedor.Fornecedor;
import br.fornecedor.FornecedorDAO;
import br.fornecedor.FornecedorTableModel;
import br.util.Ativo;
import br.util.Util;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Pedro Saraiva
 */
public class TelaFornecedor extends javax.swing.JDialog {

    /**
     * Creates new form TelaCliente
     */
    public TelaFornecedor() {
        initComponents();
        setModal(true);
        setLocationRelativeTo(null);
        setTitle("Adiciona/Edita Fornecedor");
        limpaCampos();

    }

    private Fornecedor fornecedor;
    private FornecedorDAO dao = new FornecedorDAO();

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mpRelatorio = new javax.swing.JPopupMenu();
        mmCurvaABC = new javax.swing.JMenuItem();
        jPanel4 = new javax.swing.JPanel();
        lbTexto = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        btDelete = new javax.swing.JButton();
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
        btNovo = new javax.swing.JButton();
        btPesquisar1 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        tfCidade = new javax.swing.JTextField();
        cbEstado = new javax.swing.JComboBox();
        jLabel29 = new javax.swing.JLabel();
        tfNomeFantasia = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        tfCep = new javax.swing.JFormattedTextField();
        jLabel7 = new javax.swing.JLabel();
        tfIE = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        btnImprimir = new javax.swing.JButton();

        mmCurvaABC.setText("Curva ABC");
        mmCurvaABC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mmCurvaABCActionPerformed(evt);
            }
        });
        mpRelatorio.add(mmCurvaABC);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setBackground(new java.awt.Color(0, 153, 255));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbTexto.setFont(new java.awt.Font("Verdana", 1, 30)); // NOI18N
        lbTexto.setText("Fornecedores");
        jPanel4.add(lbTexto, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 260, 40));

        getContentPane().add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 600, 40));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/imagens/delete.png"))); // NOI18N
        btDelete.setToolTipText("Excluir");
        btDelete.setEnabled(false);
        btDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btDeleteActionPerformed(evt);
            }
        });
        jPanel1.add(btDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 240, 43, 40));

        btCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/imagens/close.png"))); // NOI18N
        btCancelar.setToolTipText("Sair");
        btCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCancelarActionPerformed(evt);
            }
        });
        jPanel1.add(btCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 240, 43, 41));

        jLabel1.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel1.setText("Razão Social.: *");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, -1));

        tfRazaoSocial.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jPanel1.add(tfRazaoSocial, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 290, -1));

        tfEndereco.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jPanel1.add(tfEndereco, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 400, -1));

        jLabel2.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel2.setText("Telefone.: ");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 70, -1, -1));

        try {
            tfTelefone.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        tfTelefone.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jPanel1.add(tfTelefone, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 90, 160, -1));

        jLabel3.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel3.setText("Endereço.: *");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, -1, -1));

        try {
            tfCNPJ.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##.###.###/####-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        tfCNPJ.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        tfCNPJ.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                tfCNPJFocusLost(evt);
            }
        });
        jPanel1.add(tfCNPJ, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, 230, -1));

        jLabel5.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel5.setText("CNPJ.: ");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, -1, -1));

        btSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/imagens/pataverde.png"))); // NOI18N
        btSalvar.setToolTipText("Salvar");
        btSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSalvarActionPerformed(evt);
            }
        });
        jPanel1.add(btSalvar, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 240, 43, -1));

        btNovo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/imagens/new.png"))); // NOI18N
        btNovo.setToolTipText("Novor");
        btNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btNovoActionPerformed(evt);
            }
        });
        jPanel1.add(btNovo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 240, 43, -1));

        btPesquisar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/imagens/find.png"))); // NOI18N
        btPesquisar1.setToolTipText("Pesquisar");
        btPesquisar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btPesquisar1ActionPerformed(evt);
            }
        });
        jPanel1.add(btPesquisar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 240, 43, 40));

        jLabel6.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel6.setText("Cidade.: *");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, -1, -1));

        tfCidade.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jPanel1.add(tfCidade, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, 230, -1));

        cbEstado.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        cbEstado.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "--", "AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MT", "MS", "MG", "PA", "PB", "PR", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO" }));
        jPanel1.add(cbEstado, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 140, 160, -1));

        jLabel29.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel29.setText("Estado.:*");
        jPanel1.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 120, -1, -1));

        tfNomeFantasia.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jPanel1.add(tfNomeFantasia, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 40, 260, -1));

        jLabel4.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel4.setText("Nome Fantasia.: *");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 20, -1, -1));

        try {
            tfCep.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#####-###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        tfCep.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        tfCep.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                tfCepFocusLost(evt);
            }
        });
        jPanel1.add(tfCep, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 140, 160, -1));

        jLabel7.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel7.setText("CEP.: *");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 120, -1, -1));

        tfIE.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jPanel1.add(tfIE, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 190, 160, -1));

        jLabel8.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel8.setText("Inscr. Estadual.:");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 170, -1, -1));

        btnImprimir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/imagens/print.png"))); // NOI18N
        btnImprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImprimirActionPerformed(evt);
            }
        });
        jPanel1.add(btnImprimir, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 240, 40, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 600, 290));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btDeleteActionPerformed
        if (Util.verificaPermissao("EXCLUIR_FORNECEDOR", 1)) {
            if (JOptionPane.showConfirmDialog(rootPane, "Deseja Excluir o Fornecedor?", "", JOptionPane.YES_NO_OPTION,
                    JOptionPane.INFORMATION_MESSAGE) == JOptionPane.YES_OPTION) {
                dao.remove(fornecedor);
                limpaCampos();
            }
        }
    }//GEN-LAST:event_btDeleteActionPerformed

    private void btCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelarActionPerformed
        setVisible(false);
    }//GEN-LAST:event_btCancelarActionPerformed

    private void btSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSalvarActionPerformed
        if (Util.verificaPermissao("CE_FORNECEDOR", 1)) {

            if (fornecedor == null) {
                fornecedor = new Fornecedor();
            }
            if (Util.chkVazio(tfRazaoSocial.getText(), tfNomeFantasia.getText(), tfEndereco.getText(), cbEstado.getSelectedItem().toString(), tfCidade.getText(), tfCep.getText())) {

                fornecedor.setCep(tfCep.getText().replaceAll("\\D*", ""));
                fornecedor.setCidade(tfCidade.getText());
                fornecedor.setCnpj(tfCNPJ.getText().replaceAll("\\D*", ""));
                fornecedor.setEndereco(tfEndereco.getText());
                fornecedor.setEstado(cbEstado.getSelectedItem().toString());
                fornecedor.setIe(tfIE.getText());
                fornecedor.setNomeFantasia(tfNomeFantasia.getText());
                fornecedor.setRazaoSocial(tfRazaoSocial.getText());
                fornecedor.setTelefone(tfTelefone.getText());

                if (!fornecedor.getCnpj().equals("")) {
                    if (!Util.CNPJ(tfCNPJ.getText().replaceAll("\\D*", ""))) {
                        JOptionPane.showMessageDialog(rootPane, "CNPJ Inválido!", "ERROR", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                }

                if (fornecedor.getId() == null) {
                    if (!fornecedor.getCnpj().equals("")) {

                        if (dao.checkExists("cnpj", fornecedor.getCnpj()).size() > 0) {
                            JOptionPane.showMessageDialog(rootPane, "CNPJ já informado!", "ERRO", JOptionPane.ERROR_MESSAGE);
                            tfCNPJ.requestFocus();
                            return;
                        }
                    }

                    dao.add(fornecedor);
                    JOptionPane.showMessageDialog(rootPane, "Fornecedor Cadastrado Com Sucesso!", "INFO", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    dao.update(fornecedor);
                    JOptionPane.showMessageDialog(rootPane, "Fornecedor Editado Com Sucesso!", "INFO", JOptionPane.INFORMATION_MESSAGE);
                }
                limpaCampos();
            }
        }
    }//GEN-LAST:event_btSalvarActionPerformed

    private void btNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btNovoActionPerformed
        limpaCampos();

    }//GEN-LAST:event_btNovoActionPerformed

    private void limpaCampos() {

        fornecedor = new Fornecedor();
        tfCNPJ.setText("");
        tfCep.setText("");
        tfEndereco.setText("");
        tfRazaoSocial.setText("");
        tfNomeFantasia.setText("");
        tfTelefone.setText("");
        tfCidade.setText("");
        tfIE.setText("");
        cbEstado.setSelectedIndex(0);
        btDelete.setEnabled(false);
        tfRazaoSocial.requestFocus();
    }

    private void btPesquisar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btPesquisar1ActionPerformed
        List<Fornecedor> lista = (!(tfRazaoSocial.getText().equals("")) ? dao.checkExists("razaoSocial", tfRazaoSocial.getText()) : dao.list());
        FornecedorTableModel stm = new FornecedorTableModel(lista);
        Object o = TelaPesquisa.exibeTela(stm, "Fornecedores");
        if (o != null) {
            fornecedor = new Fornecedor();
            fornecedor = dao.checkExists("id", Integer.valueOf(String.valueOf(o))).get(0);
            tfRazaoSocial.setText(fornecedor.getRazaoSocial());
            tfNomeFantasia.setText(fornecedor.getNomeFantasia());
            tfCNPJ.setText(fornecedor.getCnpj());
            tfCep.setText(fornecedor.getCep());
            tfEndereco.setText(fornecedor.getEndereco());
            tfTelefone.setText(fornecedor.getTelefone());
            tfCidade.setText(fornecedor.getCidade());
            cbEstado.setSelectedItem(fornecedor.getEstado());
            tfIE.setText(fornecedor.getIe());

            btDelete.setEnabled(true);

        }

    }//GEN-LAST:event_btPesquisar1ActionPerformed

    private void tfCNPJFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfCNPJFocusLost
        if (!Util.CNPJ(tfCNPJ.getText().replaceAll("\\D*", ""))) {
            JOptionPane.showMessageDialog(rootPane, "CNPJ Inválido!", "ERROR", JOptionPane.ERROR_MESSAGE);
            tfCNPJ.setText("");
        }
    }//GEN-LAST:event_tfCNPJFocusLost

    private void tfCepFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfCepFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_tfCepFocusLost

    private void btnImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImprimirActionPerformed

        mpRelatorio.show(btnImprimir, btnImprimir.getWidth(), btnImprimir.getHeight());
    }//GEN-LAST:event_btnImprimirActionPerformed

    private void mmCurvaABCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mmCurvaABCActionPerformed
        if(Util.verificaPermissao("REL_CURVA_ABC_FORNECEDOR", 1)){
            HashMap<String, String> map = TelaEscolhaData.chamaTela();
            if (map != null) {
                String dataInicial = "", dataFinal = "";
                try {
                    SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
                    java.sql.Date data = new java.sql.Date(format.parse(map.get("dtIni")).getTime());
                    dataInicial = String.valueOf(data);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                try {
                    SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
                    java.sql.Date data = new java.sql.Date(format.parse(map.get("dtFim")).getTime());
                    dataFinal = String.valueOf(data);
                } catch (ParseException e) {
                    e.printStackTrace();
                }

                HashMap parametros = new HashMap();
                parametros.put("dtInicial", "'" + dataInicial + "'");
                parametros.put("dtFinal", "'" + dataFinal + "'");
                Util.imprimir("relatorios/reportCurvaABCFornecedor.jrxml", parametros);

            } else {
                JOptionPane.showMessageDialog(rootPane, "Não foi possível gerar o relatório!");
            }

        }
    }//GEN-LAST:event_mmCurvaABCActionPerformed

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
            java.util.logging.Logger.getLogger(TelaFornecedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaFornecedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaFornecedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaFornecedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaFornecedor().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btCancelar;
    private javax.swing.JButton btDelete;
    private javax.swing.JButton btNovo;
    private javax.swing.JButton btPesquisar1;
    private javax.swing.JButton btSalvar;
    private javax.swing.JButton btnImprimir;
    private javax.swing.JComboBox cbEstado;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JLabel lbTexto;
    private javax.swing.JMenuItem mmCurvaABC;
    private javax.swing.JPopupMenu mpRelatorio;
    private javax.swing.JFormattedTextField tfCNPJ;
    private javax.swing.JFormattedTextField tfCep;
    private javax.swing.JTextField tfCidade;
    private javax.swing.JTextField tfEndereco;
    private javax.swing.JTextField tfIE;
    private javax.swing.JTextField tfNomeFantasia;
    private javax.swing.JTextField tfRazaoSocial;
    private javax.swing.JFormattedTextField tfTelefone;
    // End of variables declaration//GEN-END:variables
}
