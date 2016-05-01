/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.telas;

import br.cliente.*;
import br.util.Util;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Pedro Saraiva
 */
public class TelaCliente extends javax.swing.JDialog {

    /**
     * Creates new form TelaCliente
     */
    public TelaCliente() {
        initComponents();
        setModal(true);
        setLocationRelativeTo(null);
        setTitle("Adiciona/Edita Cliente");

    }

    private Cliente cliente;
    private ClienteDAO dao = new ClienteDAO();

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
        btDelete = new javax.swing.JButton();
        btCancelar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        tfNome = new javax.swing.JTextField();
        tfEndereco = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        tfTelefone = new javax.swing.JFormattedTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        tfCelular = new javax.swing.JFormattedTextField();
        tfCPF = new javax.swing.JFormattedTextField();
        jLabel5 = new javax.swing.JLabel();
        btSalvar = new javax.swing.JButton();
        btNovo = new javax.swing.JButton();
        btPesquisar1 = new javax.swing.JButton();
        rbMasculino = new javax.swing.JRadioButton();
        rbFeminino = new javax.swing.JRadioButton();
        jLabel26 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        tfCidade = new javax.swing.JTextField();
        cbEstado = new javax.swing.JComboBox();
        jLabel29 = new javax.swing.JLabel();
        tfNomeMae = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        cbAtivo = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setBackground(new java.awt.Color(0, 153, 255));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbTexto.setFont(new java.awt.Font("Verdana", 1, 30)); // NOI18N
        lbTexto.setText("Clientes");
        jPanel4.add(lbTexto, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 210, 40));

        getContentPane().add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 430, 40));

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
        jPanel1.add(btDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 340, 43, 40));

        btCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/imagens/close.png"))); // NOI18N
        btCancelar.setToolTipText("Sair");
        btCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCancelarActionPerformed(evt);
            }
        });
        jPanel1.add(btCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 340, 43, 41));

        jLabel1.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel1.setText("Nome.: *");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, -1));

        tfNome.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jPanel1.add(tfNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 400, -1));

        tfEndereco.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jPanel1.add(tfEndereco, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 400, -1));

        jLabel2.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel2.setText("Telefone.: ");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, -1, -1));

        try {
            tfTelefone.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        tfTelefone.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jPanel1.add(tfTelefone, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, 160, -1));

        jLabel3.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel3.setText("Endereço.: *");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, -1, -1));

        jLabel4.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel4.setText("Celular.: ");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 170, -1, -1));

        try {
            tfCelular.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)#####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        tfCelular.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jPanel1.add(tfCelular, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 190, 160, -1));

        try {
            tfCPF.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        tfCPF.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jPanel1.add(tfCPF, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 240, 160, -1));

        jLabel5.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel5.setText("CPF.: *");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, -1, -1));

        btSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/imagens/pataverde.png"))); // NOI18N
        btSalvar.setToolTipText("Salvar");
        btSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSalvarActionPerformed(evt);
            }
        });
        jPanel1.add(btSalvar, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 340, 43, -1));

        btNovo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/imagens/new.png"))); // NOI18N
        btNovo.setToolTipText("Novor");
        btNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btNovoActionPerformed(evt);
            }
        });
        jPanel1.add(btNovo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 340, 43, -1));

        btPesquisar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/imagens/find.png"))); // NOI18N
        btPesquisar1.setToolTipText("Pesquisar");
        btPesquisar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btPesquisar1ActionPerformed(evt);
            }
        });
        jPanel1.add(btPesquisar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 340, 43, 40));

        rbMasculino.setBackground(new java.awt.Color(255, 255, 255));
        sexo.add(rbMasculino);
        rbMasculino.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        rbMasculino.setText("Masculino");
        jPanel1.add(rbMasculino, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 240, -1, -1));

        rbFeminino.setBackground(new java.awt.Color(255, 255, 255));
        sexo.add(rbFeminino);
        rbFeminino.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        rbFeminino.setText("Feminino");
        jPanel1.add(rbFeminino, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 240, -1, -1));

        jLabel26.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel26.setText("Sexo.:*");
        jPanel1.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 220, -1, 29));

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

        tfNomeMae.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jPanel1.add(tfNomeMae, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 290, 400, -1));

        jLabel7.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel7.setText("Nome da Mãe.: *");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 270, -1, -1));

        cbAtivo.setBackground(new java.awt.Color(255, 255, 255));
        cbAtivo.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        cbAtivo.setText("Ativo?");
        cbAtivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbAtivoActionPerformed(evt);
            }
        });
        jPanel1.add(cbAtivo, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 10, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 430, 400));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btDeleteActionPerformed
        if(JOptionPane.showConfirmDialog(rootPane, "Deseja Excluir o Cliente?", "", JOptionPane.YES_NO_OPTION, 
                JOptionPane.INFORMATION_MESSAGE)==JOptionPane.YES_OPTION){
            dao.remove(cliente);
            limpaCampos();
        }
    }//GEN-LAST:event_btDeleteActionPerformed

    private void btCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelarActionPerformed
        setVisible(false);
    }//GEN-LAST:event_btCancelarActionPerformed

    private void btSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSalvarActionPerformed
        if (cliente == null) {
            cliente = new Cliente();
        }
        if (Util.chkVazio(tfNome.getText(), tfTelefone.getText(), tfCPF.getText(),
                cbEstado.getSelectedItem().toString(), tfCidade.getText(),
                tfNomeMae.getText())) {
            if(!rbMasculino.isSelected() && !rbFeminino.isSelected()){
                JOptionPane.showMessageDialog(null, "Preencha todos os campos com '*'! ");
                return ;
            }           
            
            cliente.setNome(tfNome.getText());
            cliente.setEndereco(tfEndereco.getText());
            cliente.setCelular(tfCelular.getText().replaceAll("\\D*", ""));
            cliente.setTelefone(tfTelefone.getText().replaceAll("\\D*", ""));
            cliente.setSexo((rbFeminino.isSelected()) ? 'F' : 'M');
            cliente.setCidade(tfCidade.getText());
            cliente.setEstado(cbEstado.getSelectedItem().toString());
            cliente.setNomeMae(tfNomeMae.getText());
            cliente.setAtivo(cbAtivo.isSelected());
            if(!Util.CPF(tfCPF.getText().replaceAll("\\D*", ""))){
                JOptionPane.showMessageDialog(rootPane, "CPF Inválido!", "ERROR", JOptionPane.ERROR_MESSAGE);
                return ;
            }
            cliente.setCpf(tfCPF.getText().replaceAll("\\D*", ""));
            
            if(cliente.getId()==null){
                if (dao.checkExists("cpf", cliente.getCpf()).size() > 0) {
                    JOptionPane.showMessageDialog(rootPane, "CPF já informado!", "ERRO", JOptionPane.ERROR_MESSAGE);
                    tfCPF.requestFocus();
                    return;
                }
                
                dao.add(cliente);
                JOptionPane.showMessageDialog(rootPane, "Cliente Cadastrado Com Sucesso!", "INFO", JOptionPane.INFORMATION_MESSAGE);
            } else {
                dao.update(cliente);
                JOptionPane.showMessageDialog(rootPane, "Cliente Editado Com Sucesso!", "INFO",JOptionPane.INFORMATION_MESSAGE);
            }
            limpaCampos();
        } 
    }//GEN-LAST:event_btSalvarActionPerformed

    private void btNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btNovoActionPerformed
        limpaCampos();
        
    }//GEN-LAST:event_btNovoActionPerformed

    private void limpaCampos(){
        cbAtivo.setSelected(false);
        cliente = new Cliente();
        tfCPF.setText("");
        tfCelular.setText("");
        tfEndereco.setText("");
        tfNome.setText("");
        tfTelefone.setText("");
        tfCidade.setText("");
        cbEstado.setSelectedIndex(0);
        btDelete.setEnabled(false);
        rbFeminino.setSelected(false);
        rbMasculino.setSelected(false);
        tfNomeMae.setText("");
    }
    
    private void btPesquisar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btPesquisar1ActionPerformed
        List<Cliente> lista = (!(tfNome.getText().equals("")) ? dao.checkExists("nome",tfNome.getText()) : dao.list());
        ClienteTableModel stm = new ClienteTableModel(lista);
        Object o = TelaPesquisa.exibeTela(stm, "Cliente");
        if (o != null) {
            cliente = new Cliente();
            cliente = dao.checkExists("id",Integer.valueOf(String.valueOf(o))).get(0);
            tfNome.setText(cliente.getNome());
            tfCPF.setText(cliente.getCpf());
            tfCelular.setText(cliente.getCelular());
            tfEndereco.setText(cliente.getEndereco());
            tfTelefone.setText(cliente.getTelefone());
            tfCidade.setText(cliente.getCidade());
            cbEstado.setSelectedItem(cliente.getEstado());
            tfNomeMae.setText(cliente.getNomeMae());
            cbAtivo.setSelected(cliente.isAtivo());
            if (cliente.getSexo() == 'F') {
                rbFeminino.setSelected(true);
            } else if (cliente.getSexo() == 'M') {
                rbMasculino.setSelected(true);
            }
            btDelete.setEnabled(true);
        }
        
    }//GEN-LAST:event_btPesquisar1ActionPerformed

    private void cbAtivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbAtivoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbAtivoActionPerformed

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
            java.util.logging.Logger.getLogger(TelaCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaCliente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btCancelar;
    private javax.swing.JButton btDelete;
    private javax.swing.JButton btNovo;
    private javax.swing.JButton btPesquisar1;
    private javax.swing.JButton btSalvar;
    private javax.swing.JCheckBox cbAtivo;
    private javax.swing.JComboBox cbEstado;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JLabel lbTexto;
    private javax.swing.JRadioButton rbFeminino;
    private javax.swing.JRadioButton rbMasculino;
    private javax.swing.ButtonGroup sexo;
    private javax.swing.JFormattedTextField tfCPF;
    private javax.swing.JFormattedTextField tfCelular;
    private javax.swing.JTextField tfCidade;
    private javax.swing.JTextField tfEndereco;
    private javax.swing.JTextField tfNome;
    private javax.swing.JTextField tfNomeMae;
    private javax.swing.JFormattedTextField tfTelefone;
    // End of variables declaration//GEN-END:variables
}
