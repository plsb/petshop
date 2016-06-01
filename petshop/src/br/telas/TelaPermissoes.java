/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.telas;

import br.usuario.Usuario;
import br.usuario.UsuarioDAO;
import br.util.UsuarioAtivo;
import java.awt.Component;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;

/**
 *
 * @author Pedro Saraiva
 */
public class TelaPermissoes extends javax.swing.JDialog {

    private static Usuario usuario;

    public static Usuario chamaTela(Usuario usuario) {
        new TelaPermissoes(usuario).setVisible(true);
        return TelaPermissoes.usuario;
    }

    public TelaPermissoes() {
        initComponents();
        setModal(true);
        setLocationRelativeTo(this);
    }

    public TelaPermissoes(Usuario usuario) {
        initComponents();
        setModal(true);
        setLocationRelativeTo(this);
        this.usuario = usuario;
        lblUsuario.setText(usuario.getNome());
        verificaPermissoes();
    }

    public void verificaPermissoes() {
        if (usuario.getPermissao().size() > 0) {
            ArrayList<Component> listaComponentes = new ArrayList<>();
            listaComponentes.addAll(converteArrayListaComponentes(jPanel8.getComponents()));
            listaComponentes.addAll(converteArrayListaComponentes(jPanel7.getComponents()));
            listaComponentes.addAll(converteArrayListaComponentes(jPanel5.getComponents()));
            listaComponentes.addAll(converteArrayListaComponentes(jPanel9.getComponents()));
            listaComponentes.addAll(converteArrayListaComponentes(jPanel6.getComponents()));
            for (Component componente : listaComponentes) {
                JCheckBox ck = null;
                try {
                    ck = (JCheckBox) componente;
                } catch (Exception ex) {

                }
                if (ck != null) {
                    ck.setSelected(usuario.getPermissao().contains(ck.getName()));                    
                }

            }
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
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        CE_PRODUTO = new javax.swing.JCheckBox();
        EXCLUIR_PRODUTO = new javax.swing.JCheckBox();
        jPanel6 = new javax.swing.JPanel();
        CE_VENDEDOR = new javax.swing.JCheckBox();
        EXCLUIR_VENDEDOR = new javax.swing.JCheckBox();
        jPanel7 = new javax.swing.JPanel();
        CE_EMPRESA = new javax.swing.JCheckBox();
        jPanel8 = new javax.swing.JPanel();
        CE_CLIENTE = new javax.swing.JCheckBox();
        EXCLUIR_CLIENTE = new javax.swing.JCheckBox();
        jPanel9 = new javax.swing.JPanel();
        CE_GRUPO_PRODUTOS = new javax.swing.JCheckBox();
        EXCLUIR_GRUPO_PRODUTO = new javax.swing.JCheckBox();
        jCheckBox1 = new javax.swing.JCheckBox();
        jPanel3 = new javax.swing.JPanel();
        lbTexto = new javax.swing.JLabel();
        lblUsuario = new javax.swing.JLabel();
        btSalvar = new javax.swing.JButton();
        btCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("Produto/Serviço"));

        CE_PRODUTO.setText("Cadastrar/Editar ");
        CE_PRODUTO.setName("CE_PRODUTO"); // NOI18N
        CE_PRODUTO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CE_PRODUTOActionPerformed(evt);
            }
        });

        EXCLUIR_PRODUTO.setText("Excluir");
        EXCLUIR_PRODUTO.setName("EXCLUIR_PRODUTO"); // NOI18N

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(CE_PRODUTO)
                    .addComponent(EXCLUIR_PRODUTO))
                .addGap(59, 59, 59))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(CE_PRODUTO)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(EXCLUIR_PRODUTO)
                .addContainerGap())
        );

        jPanel2.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 10, 180, 90));

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder("Vendedor"));

        CE_VENDEDOR.setText("Cadastrar/Editar ");
        CE_VENDEDOR.setName("CE_VENDEDOR"); // NOI18N
        CE_VENDEDOR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CE_VENDEDORActionPerformed(evt);
            }
        });

        EXCLUIR_VENDEDOR.setText("Excluir ");
        EXCLUIR_VENDEDOR.setName("EXCLUIR_VENDEDOR"); // NOI18N

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(CE_VENDEDOR)
                    .addComponent(EXCLUIR_VENDEDOR))
                .addGap(59, 59, 59))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(CE_VENDEDOR)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(EXCLUIR_VENDEDOR)
                .addContainerGap())
        );

        jPanel2.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 110, 180, 90));

        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder("Empresa"));

        CE_EMPRESA.setText("Cadastrar/Editar ");
        CE_EMPRESA.setName("CE_EMPRESA"); // NOI18N
        CE_EMPRESA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CE_EMPRESAActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addComponent(CE_EMPRESA)
                .addGap(59, 59, 59))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addComponent(CE_EMPRESA)
                .addGap(44, 44, 44))
        );

        jPanel2.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 10, 180, 90));

        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder("Cliente"));

        CE_CLIENTE.setText("Cadastrar/Editar ");
        CE_CLIENTE.setName("CE_CLIENTE"); // NOI18N
        CE_CLIENTE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CE_CLIENTEActionPerformed(evt);
            }
        });

        EXCLUIR_CLIENTE.setText("Excluir ");
        EXCLUIR_CLIENTE.setName("EXCLUIR_CLIENTE"); // NOI18N

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(CE_CLIENTE)
                    .addComponent(EXCLUIR_CLIENTE))
                .addGap(59, 59, 59))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addComponent(CE_CLIENTE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(EXCLUIR_CLIENTE)
                .addContainerGap())
        );

        jPanel2.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 180, 90));

        jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder("Grupo de Produtos"));

        CE_GRUPO_PRODUTOS.setText("Cadastrar/Editar ");
        CE_GRUPO_PRODUTOS.setName("CE_GRUPO_PRODUTO"); // NOI18N
        CE_GRUPO_PRODUTOS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CE_GRUPO_PRODUTOSActionPerformed(evt);
            }
        });

        EXCLUIR_GRUPO_PRODUTO.setText("Excluir ");
        EXCLUIR_GRUPO_PRODUTO.setName("EXCLUIR_GRUPO_PRODUTO"); // NOI18N

        jCheckBox1.setText("Relat. de Produtos por Grupo");
        jCheckBox1.setName("REL_PRODU_GRUPO"); // NOI18N
        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(CE_GRUPO_PRODUTOS)
                    .addComponent(EXCLUIR_GRUPO_PRODUTO)
                    .addComponent(jCheckBox1))
                .addGap(59, 59, 59))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addComponent(CE_GRUPO_PRODUTOS)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(EXCLUIR_GRUPO_PRODUTO)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jCheckBox1))
        );

        jPanel2.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 180, 90));

        jTabbedPane1.addTab("Cadastros", jPanel2);

        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jTabbedPane1.addTab("Movimentações", jPanel3);

        jPanel1.add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 610, 290));

        lbTexto.setFont(new java.awt.Font("Verdana", 1, 30)); // NOI18N
        lbTexto.setText("Permissões de Usuário");
        jPanel1.add(lbTexto, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 630, 40));

        lblUsuario.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        lblUsuario.setText("jLabel1");
        jPanel1.add(lblUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, -1, -1));

        btSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/imagens/pataverde.png"))); // NOI18N
        btSalvar.setToolTipText("Salvar");
        btSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSalvarActionPerformed(evt);
            }
        });
        jPanel1.add(btSalvar, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 360, 43, -1));

        btCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/imagens/close.png"))); // NOI18N
        btCancelar.setToolTipText("Sair");
        btCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCancelarActionPerformed(evt);
            }
        });
        jPanel1.add(btCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 360, 43, 41));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 640, 410));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void CE_PRODUTOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CE_PRODUTOActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CE_PRODUTOActionPerformed

    private void CE_VENDEDORActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CE_VENDEDORActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CE_VENDEDORActionPerformed

    private void CE_EMPRESAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CE_EMPRESAActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CE_EMPRESAActionPerformed

    private void CE_CLIENTEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CE_CLIENTEActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CE_CLIENTEActionPerformed

    private void CE_GRUPO_PRODUTOSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CE_GRUPO_PRODUTOSActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CE_GRUPO_PRODUTOSActionPerformed

    private List<Component> converteArrayListaComponentes(Component[] listaComp) {
        List<Component> lista = new ArrayList<>();
        for (Component c : listaComp) {
            lista.add(c);
        }
        return lista;
    }

    private void btSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSalvarActionPerformed
        ArrayList<Component> listaComponentes = new ArrayList<>();
        listaComponentes.addAll(converteArrayListaComponentes(jPanel8.getComponents()));
        listaComponentes.addAll(converteArrayListaComponentes(jPanel7.getComponents()));
        listaComponentes.addAll(converteArrayListaComponentes(jPanel5.getComponents()));
        listaComponentes.addAll(converteArrayListaComponentes(jPanel9.getComponents()));
        listaComponentes.addAll(converteArrayListaComponentes(jPanel6.getComponents()));
        usuario.setPermissao(new HashSet<String>());
        for (Component componente : listaComponentes) {
            JCheckBox ck = null;
            try {
                ck = (JCheckBox) componente;
            } catch (Exception ex) {

            }
            if (ck != null) {
                if (ck.isSelected()) {

                    usuario.getPermissao().add(ck.getName());
                }
            }

        }
        UsuarioDAO dao = new UsuarioDAO();
        dao.update(usuario);
        UsuarioAtivo.setUsuario(usuario);
        dispose();
    }//GEN-LAST:event_btSalvarActionPerformed

    private void btCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelarActionPerformed
        setVisible(false);
    }//GEN-LAST:event_btCancelarActionPerformed

    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox1ActionPerformed

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
            java.util.logging.Logger.getLogger(TelaPermissoes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaPermissoes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaPermissoes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaPermissoes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaPermissoes().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox CE_CLIENTE;
    private javax.swing.JCheckBox CE_EMPRESA;
    private javax.swing.JCheckBox CE_GRUPO_PRODUTOS;
    private javax.swing.JCheckBox CE_PRODUTO;
    private javax.swing.JCheckBox CE_VENDEDOR;
    private javax.swing.JCheckBox EXCLUIR_CLIENTE;
    private javax.swing.JCheckBox EXCLUIR_GRUPO_PRODUTO;
    private javax.swing.JCheckBox EXCLUIR_PRODUTO;
    private javax.swing.JCheckBox EXCLUIR_VENDEDOR;
    private javax.swing.JButton btCancelar;
    private javax.swing.JButton btSalvar;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lbTexto;
    private javax.swing.JLabel lblUsuario;
    // End of variables declaration//GEN-END:variables
}
