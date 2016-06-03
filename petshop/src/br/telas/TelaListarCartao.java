/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.telas;

import br.cartao.CartaoCredito;
import br.cartao.CartaoCreditoDAO;
import br.cartao.CartaoTableModel;
import br.contasreceber.ContasReceber;
import br.contasreceber.ContasReceberDAO;
import br.livro.LivroCaixa;
import br.livro.LivroCaixaDAO;
import br.orcamento.Orcamento;
import br.orcamento.OrcamentoCellRenderer;
import br.orcamento.OrcamentoDAO;
import br.orcamento.OrcamentoTableModel;
import br.util.FormataTamanhoColunasJTable;
import br.util.Util;
import br.venda.Venda;
import br.venda.VendaCellRenderer;
import br.venda.VendaDAO;
import br.venda.VendaTableModel;
import java.awt.event.KeyEvent;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Pedro Saraiva
 */
public class TelaListarCartao extends javax.swing.JDialog {

    
    /**
     * Creates new form TelaListarVendas
     */
    public TelaListarCartao() {
        initComponents();
        setModal(true);
        setLocationRelativeTo(null);
        SimpleDateFormat dfdtData;
        dfdtData = new SimpleDateFormat("dd/MM/yyyy");
        tfDataInicio.setText(dfdtData.format(new Date()));
        tfDataFim.setText(dfdtData.format(new Date()));
        btPesquisarActionPerformed(null);
        setTitle("Listar Cartões Crédito/Débito");
    }

    CartaoCreditoDAO dao = new CartaoCreditoDAO();

    private void preencheTabela(List<CartaoCredito> lista) {
        CartaoTableModel vtm = new CartaoTableModel(lista);
        tb.setModel(vtm);
        FormataTamanhoColunasJTable.packColumns(tb, 1);
        tb.setAutoCreateRowSorter(true);
        
        double valor =0;
        for (CartaoCredito lista1 : lista) {
            valor+=lista1.getValor();
        }
        
        lblValor.setText(Util.acertarNumero(valor));
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
        jScrollPane1 = new javax.swing.JScrollPane();
        tb = new javax.swing.JTable();
        tfDataInicio = new javax.swing.JFormattedTextField();
        btPesquisar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        tfDataFim = new javax.swing.JFormattedTextField();
        jLabel4 = new javax.swing.JLabel();
        btExcluir = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        lblValor = new javax.swing.JLabel();
        btSair = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tb.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
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
        tb.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tbKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(tb);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 740, 250));

        try {
            tfDataInicio.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        tfDataInicio.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jPanel1.add(tfDataInicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 150, -1));

        btPesquisar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/imagens/find.png"))); // NOI18N
        btPesquisar.setToolTipText("Pesquisar");
        btPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btPesquisarActionPerformed(evt);
            }
        });
        jPanel1.add(btPesquisar, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 20, 40, -1));

        jLabel3.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel3.setText("Data Fim");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 10, -1, -1));

        try {
            tfDataFim.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        tfDataFim.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jPanel1.add(tfDataFim, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 30, 150, -1));

        jLabel4.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel4.setText("Data Inicio");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        btExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/imagens/delete.png"))); // NOI18N
        btExcluir.setToolTipText("Excluir");
        btExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btExcluirActionPerformed(evt);
            }
        });
        jPanel1.add(btExcluir, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 350, 70, 50));

        jLabel5.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel5.setText("Valor Total.: ");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 360, -1, -1));

        lblValor.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        lblValor.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblValor.setText("0,00");
        jPanel1.add(lblValor, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 360, 80, -1));

        btSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/imagens/cancel2.png"))); // NOI18N
        btSair.setToolTipText("Sair");
        btSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSairActionPerformed(evt);
            }
        });
        jPanel1.add(btSair, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 350, 70, 50));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 760, 410));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btPesquisarActionPerformed
        if (!tfDataInicio.getText().equals("  /  /    ") && !tfDataFim.getText().equals("  /  /    ")) {
            java.util.Date dataIni = null, dataFim = null;
            try {
                DateFormat fmt = new SimpleDateFormat("dd/MM/yyyy");
                dataIni = new java.util.Date(fmt.parse(tfDataInicio.getText()).getTime());
            } catch (ParseException ex) {
                System.out.println(ex.getMessage());
            }
            try {
                DateFormat fmt = new SimpleDateFormat("dd/MM/yyyy");
                dataFim = new java.util.Date(fmt.parse(tfDataFim.getText()).getTime());
            } catch (ParseException ex) {
                System.out.println(ex.getMessage());
            }
            if (dataIni == null && dataFim == null) {
                preencheTabela(new ArrayList<CartaoCredito>());
            } else {
                List<CartaoCredito> listaCartoes = dao.listCartaoEntreDatas(dataIni, dataFim);
                preencheTabela(listaCartoes);

            }

        } else {
            JOptionPane.showMessageDialog(rootPane, "Informe a Data Inicio e Fim!");
        }
    }//GEN-LAST:event_btPesquisarActionPerformed


    private void tbKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tbKeyPressed
    
    }//GEN-LAST:event_tbKeyPressed

    private void btExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btExcluirActionPerformed
        int i = tb.getSelectedRow();
        if(i>=0){
            CartaoTableModel ctm = (CartaoTableModel) tb.getModel();
            CartaoCredito c = ctm.getValueAt(i);
            if(JOptionPane.showConfirmDialog(rootPane, "Deseja Excluir?", "Excluir", JOptionPane.YES_NO_OPTION)
                    ==JOptionPane.YES_OPTION){
                CartaoCreditoDAO ccDAO = new CartaoCreditoDAO();
                ccDAO.remove(c);
                btPesquisarActionPerformed(null);
            }
                    
        } else {
            JOptionPane.showMessageDialog(rootPane, "Selecione o ítem!");
        }
    }//GEN-LAST:event_btExcluirActionPerformed

    private void btSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSairActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btSairActionPerformed

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
            java.util.logging.Logger.getLogger(TelaListarCartao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaListarCartao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaListarCartao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaListarCartao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaListarCartao().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btExcluir;
    private javax.swing.JButton btPesquisar;
    private javax.swing.JButton btSair;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblValor;
    private javax.swing.JTable tb;
    private javax.swing.JFormattedTextField tfDataFim;
    private javax.swing.JFormattedTextField tfDataInicio;
    // End of variables declaration//GEN-END:variables
}
