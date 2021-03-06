/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.telas;

import br.contaspagar.GrupoContasPagar;
import br.contaspagar.GrupoContasPagarDAO;
import br.contaspagar.GrupoContasPagarTableModel;
import br.grupo_produto.GrupoProduto;
import br.grupo_produto.GrupoProdutoDAO;
import br.grupo_produto.GrupoTableModel;
import br.util.HibernateUtil;
import br.util.Util;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
public class TelaGrupoContasPagar extends javax.swing.JDialog {

    /**
     * Creates new form TelaCliente
     */
    public TelaGrupoContasPagar() {
        initComponents();
        setModal(true);
        setTitle("Adiciona/Edita Plano de Contas");
        setLocationRelativeTo(null);
        limpaCampos();
    }

    private GrupoContasPagar gr;
    private GrupoContasPagarDAO dao = new GrupoContasPagarDAO();

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
        btSalvar = new javax.swing.JButton();
        btNovo = new javax.swing.JButton();
        btPesquisar1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setBackground(new java.awt.Color(0, 153, 255));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbTexto.setFont(new java.awt.Font("Verdana", 1, 30)); // NOI18N
        lbTexto.setText("Plano de Contas");
        jPanel4.add(lbTexto, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 350, 40));

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
        jPanel1.add(btDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 130, 43, 40));

        btCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/imagens/close.png"))); // NOI18N
        btCancelar.setToolTipText("Sair");
        btCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCancelarActionPerformed(evt);
            }
        });
        jPanel1.add(btCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 130, 43, 41));

        jLabel1.setFont(new java.awt.Font("Bitstream Vera Sans Mono", 0, 12)); // NOI18N
        jLabel1.setText("Descrição.: *");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, -1, -1));

        tfNome.setFont(new java.awt.Font("Bitstream Vera Sans Mono", 0, 12)); // NOI18N
        jPanel1.add(tfNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 400, -1));

        btSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/imagens/pataverde.png"))); // NOI18N
        btSalvar.setToolTipText("Salvar");
        btSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSalvarActionPerformed(evt);
            }
        });
        jPanel1.add(btSalvar, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 130, 43, -1));

        btNovo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/imagens/new.png"))); // NOI18N
        btNovo.setToolTipText("Novo");
        btNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btNovoActionPerformed(evt);
            }
        });
        jPanel1.add(btNovo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, 43, -1));

        btPesquisar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/imagens/find.png"))); // NOI18N
        btPesquisar1.setToolTipText("Pesquisar");
        btPesquisar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btPesquisar1ActionPerformed(evt);
            }
        });
        jPanel1.add(btPesquisar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 130, 43, 40));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 430, 190));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btDeleteActionPerformed
        if (JOptionPane.showConfirmDialog(rootPane, "Deseja Excluir o Grupo de Contas à Pagar?", "", JOptionPane.YES_NO_OPTION,
                JOptionPane.INFORMATION_MESSAGE) == JOptionPane.YES_OPTION) {
            dao.remove(gr);
            limpaCampos();
        }

    }//GEN-LAST:event_btDeleteActionPerformed

    private void btCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelarActionPerformed
        setVisible(false);
    }//GEN-LAST:event_btCancelarActionPerformed

    private void btSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSalvarActionPerformed

        if (gr == null) {
            gr = new GrupoContasPagar();
        }
        if (Util.chkVazio(tfNome.getText())) {

            gr.setDescricao(tfNome.getText());
            if (gr.getId() == null) {
                dao.add(gr);
                JOptionPane.showMessageDialog(rootPane, "Grupo Cadastrado Com Sucesso!", "INFO", JOptionPane.INFORMATION_MESSAGE);
            } else {
                dao.update(gr);
                JOptionPane.showMessageDialog(rootPane, "Grupo Editado Com Sucesso!", "INFO", JOptionPane.INFORMATION_MESSAGE);
            }
            limpaCampos();
        }

    }//GEN-LAST:event_btSalvarActionPerformed

    private void btNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btNovoActionPerformed
        limpaCampos();

    }//GEN-LAST:event_btNovoActionPerformed

    private void limpaCampos() {
        gr = new GrupoContasPagar();
        tfNome.setText("");
        btDelete.setEnabled(false);

        tfNome.requestFocus();
    }

    private void btPesquisar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btPesquisar1ActionPerformed
        List<GrupoContasPagar> lista = (!(tfNome.getText().equals("")) ? dao.checkExists("descricao", tfNome.getText()) : dao.list());
        GrupoContasPagarTableModel stm = new GrupoContasPagarTableModel(lista);
        Object o = TelaPesquisa.exibeTela(stm, "Grupo de Produtos");
        if (o != null) {
            gr = new GrupoContasPagar();
            gr = dao.checkExists("id", Integer.valueOf(String.valueOf(o))).get(0);
            tfNome.setText(gr.getDescricao());
            btDelete.setEnabled(true);
        }

    }//GEN-LAST:event_btPesquisar1ActionPerformed

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
            java.util.logging.Logger.getLogger(TelaGrupoContasPagar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaGrupoContasPagar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaGrupoContasPagar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaGrupoContasPagar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaGrupoContasPagar().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btCancelar;
    private javax.swing.JButton btDelete;
    private javax.swing.JButton btNovo;
    private javax.swing.JButton btPesquisar1;
    private javax.swing.JButton btSalvar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JLabel lbTexto;
    private javax.swing.ButtonGroup sexo;
    private javax.swing.JTextField tfNome;
    // End of variables declaration//GEN-END:variables
}
