/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.telas;

import br.util.Ativo;
import br.util.Util;
import com.lowagie.text.Chunk;
import com.lowagie.text.Image;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.BarcodeEAN;
import com.lowagie.text.pdf.PdfContentByte;
import com.lowagie.text.pdf.PdfWriter;
import java.io.FileOutputStream;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author Pedro Saraiva
 */
public class TelaPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form TelaPrincipal
     */
    public TelaPrincipal() {
        TelaLogin tl = new TelaLogin();
        tl.setVisible(true);
        initComponents();
        setLocationRelativeTo(null);
        setTitle("Tela Principal - Usuário: " + Ativo.getUsuario().getNome());
        String enderecoDoJar = Util.retornaCaminhoApp() + "logo.jpg";
        try {
            ImageIcon logo = new ImageIcon(enderecoDoJar);
//            ImageIcon logo = new ImageIcon("logo.jpg");
            lblImage.setIcon(logo);
            lblImage.setIcon(Util.redimensionar(lblImage, 790, 439));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "Não Foi Possível Encontrar a Logo!");
        }
        permissoes();

    }

    public void permissoes() {
        mmUsuario.setVisible(Ativo.getUsuario().isAdministrador());
        mmCliente.setVisible(Util.verificaPermissao("V_CLIENTE", 0));
        mmEmpresa.setVisible(Util.verificaPermissao("V_EMPRESA", 0));
        mmProduto.setVisible(Util.verificaPermissao("V_PRODUTO", 0));
        mmGrupoProduto.setVisible(Util.verificaPermissao("V_GRUPO_PRODUTO", 0));
        mmVendedor.setVisible(Util.verificaPermissao("V_VENDEDOR", 0));
        mmCaixa.setVisible(Util.verificaPermissao("V_CAIXA", 0));
        mmContaReceber.setVisible(Util.verificaPermissao("V_CONTA_RECEBER", 0));
        mmVenda.setVisible(Util.verificaPermissao("V_VENDA", 0));
        mmListarVendas.setVisible(Util.verificaPermissao("LISTAR_VENDAS", 0));
        mmOrcamento.setVisible(Util.verificaPermissao("INSERIR_ORCAMENTO", 0));
        mmCartao.setVisible(Util.verificaPermissao("V_CARTAO", 0));
        mmFornecedor.setVisible(Util.verificaPermissao("V_FORNECEDOR", 0));
        mmContaBancaria.setVisible(Util.verificaPermissao("V_CONTA_BANCARIA", 0));
        mmMovimentContaBancaria.setVisible(Util.verificaPermissao("MOV_CONTA_BANCARIA", 0));
        mmCaixaGeral.setVisible(Util.verificaPermissao("CAIXA_GERAL", 0));
        mmListarCaixas.setVisible(Util.verificaPermissao("LISTAR_CAIXAS", 0));
        mmListarCaixas.setVisible(Util.verificaPermissao("CONTAS_PAGAR", 0));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblImage = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        mCadastro = new javax.swing.JMenu();
        mmCliente = new javax.swing.JMenuItem();
        mmContaBancaria = new javax.swing.JMenuItem();
        mmEmpresa = new javax.swing.JMenuItem();
        mmFornecedor = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        mmProduto = new javax.swing.JMenuItem();
        mmGrupoProduto = new javax.swing.JMenuItem();
        mmUsuario = new javax.swing.JMenuItem();
        mmVendedor = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        mmCaixa = new javax.swing.JMenuItem();
        mmCartao = new javax.swing.JMenuItem();
        mmContaReceber = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        mmVenda = new javax.swing.JMenuItem();
        mmListarVendas = new javax.swing.JMenuItem();
        mmOrcamento = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        mmCaixaGeral = new javax.swing.JMenuItem();
        mmContasPagar = new javax.swing.JMenuItem();
        mmListarCaixas = new javax.swing.JMenuItem();
        mmMovimentContaBancaria = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(lblImage, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 790, 470));

        mCadastro.setMnemonic('c');
        mCadastro.setText("Cadastro");
        mCadastro.setFont(new java.awt.Font("Bitstream Vera Sans Mono", 0, 12)); // NOI18N

        mmCliente.setFont(new java.awt.Font("Bitstream Vera Sans Mono", 0, 12)); // NOI18N
        mmCliente.setMnemonic('c');
        mmCliente.setText("Cliente");
        mmCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mmClienteActionPerformed(evt);
            }
        });
        mCadastro.add(mmCliente);

        mmContaBancaria.setFont(new java.awt.Font("Bitstream Vera Sans Mono", 0, 12)); // NOI18N
        mmContaBancaria.setMnemonic('o');
        mmContaBancaria.setText("Conta Bancária");
        mmContaBancaria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mmContaBancariaActionPerformed(evt);
            }
        });
        mCadastro.add(mmContaBancaria);

        mmEmpresa.setFont(new java.awt.Font("Bitstream Vera Sans Mono", 0, 12)); // NOI18N
        mmEmpresa.setMnemonic('e');
        mmEmpresa.setText("Empresa");
        mmEmpresa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mmEmpresaActionPerformed(evt);
            }
        });
        mCadastro.add(mmEmpresa);

        mmFornecedor.setFont(new java.awt.Font("Bitstream Vera Sans Mono", 0, 12)); // NOI18N
        mmFornecedor.setMnemonic('f');
        mmFornecedor.setText("Fornecedor");
        mmFornecedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mmFornecedorActionPerformed(evt);
            }
        });
        mCadastro.add(mmFornecedor);

        jMenu2.setMnemonic('p');
        jMenu2.setText("Produto/Serviço");
        jMenu2.setFont(new java.awt.Font("Bitstream Vera Sans Mono", 0, 12)); // NOI18N

        mmProduto.setFont(new java.awt.Font("Bitstream Vera Sans Mono", 0, 12)); // NOI18N
        mmProduto.setMnemonic('c');
        mmProduto.setText("Cadastro");
        mmProduto.setToolTipText("a");
        mmProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mmProdutoActionPerformed(evt);
            }
        });
        jMenu2.add(mmProduto);

        mmGrupoProduto.setFont(new java.awt.Font("Bitstream Vera Sans Mono", 0, 12)); // NOI18N
        mmGrupoProduto.setMnemonic('g');
        mmGrupoProduto.setText("Grupo de Produtos");
        mmGrupoProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mmGrupoProdutoActionPerformed(evt);
            }
        });
        jMenu2.add(mmGrupoProduto);

        mCadastro.add(jMenu2);

        mmUsuario.setFont(new java.awt.Font("Bitstream Vera Sans Mono", 0, 12)); // NOI18N
        mmUsuario.setMnemonic('u');
        mmUsuario.setText("Usuário");
        mmUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mmUsuarioActionPerformed(evt);
            }
        });
        mCadastro.add(mmUsuario);

        mmVendedor.setFont(new java.awt.Font("Bitstream Vera Sans Mono", 0, 12)); // NOI18N
        mmVendedor.setMnemonic('v');
        mmVendedor.setText("Vendedor");
        mmVendedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mmVendedorActionPerformed(evt);
            }
        });
        mCadastro.add(mmVendedor);

        jMenuBar1.add(mCadastro);

        jMenu3.setMnemonic('m');
        jMenu3.setText("Movimentação");
        jMenu3.setFont(new java.awt.Font("Bitstream Vera Sans Mono", 0, 12)); // NOI18N

        mmCaixa.setFont(new java.awt.Font("Bitstream Vera Sans Mono", 0, 12)); // NOI18N
        mmCaixa.setMnemonic('c');
        mmCaixa.setText("Caixa");
        mmCaixa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mmCaixaActionPerformed(evt);
            }
        });
        jMenu3.add(mmCaixa);

        mmCartao.setFont(new java.awt.Font("Bitstream Vera Sans Mono", 0, 12)); // NOI18N
        mmCartao.setMnemonic('a');
        mmCartao.setText("Cartão de Crédito/Débito");
        mmCartao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mmCartaoActionPerformed(evt);
            }
        });
        jMenu3.add(mmCartao);

        mmContaReceber.setFont(new java.awt.Font("Bitstream Vera Sans Mono", 0, 12)); // NOI18N
        mmContaReceber.setMnemonic('r');
        mmContaReceber.setText("Contas a Receber");
        mmContaReceber.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mmContaReceberActionPerformed(evt);
            }
        });
        jMenu3.add(mmContaReceber);

        jMenu1.setMnemonic('v');
        jMenu1.setText("Venda");
        jMenu1.setFont(new java.awt.Font("Bitstream Vera Sans Mono", 0, 12)); // NOI18N

        mmVenda.setFont(new java.awt.Font("Bitstream Vera Sans Mono", 0, 12)); // NOI18N
        mmVenda.setMnemonic('n');
        mmVenda.setText("Nova Venda");
        mmVenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mmVendaActionPerformed(evt);
            }
        });
        jMenu1.add(mmVenda);

        mmListarVendas.setFont(new java.awt.Font("Bitstream Vera Sans Mono", 0, 12)); // NOI18N
        mmListarVendas.setMnemonic('l');
        mmListarVendas.setText("Listar Vendas");
        mmListarVendas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mmListarVendasActionPerformed(evt);
            }
        });
        jMenu1.add(mmListarVendas);

        mmOrcamento.setFont(new java.awt.Font("Bitstream Vera Sans Mono", 0, 12)); // NOI18N
        mmOrcamento.setMnemonic('m');
        mmOrcamento.setText("Orçamentos");
        mmOrcamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mmOrcamentoActionPerformed(evt);
            }
        });
        jMenu1.add(mmOrcamento);

        jMenu3.add(jMenu1);

        jMenuBar1.add(jMenu3);

        jMenu4.setMnemonic('g');
        jMenu4.setText("Geral");
        jMenu4.setFont(new java.awt.Font("Bitstream Vera Sans Mono", 0, 12)); // NOI18N

        mmCaixaGeral.setFont(new java.awt.Font("Bitstream Vera Sans Mono", 0, 12)); // NOI18N
        mmCaixaGeral.setMnemonic('c');
        mmCaixaGeral.setText("Caixa Geral");
        mmCaixaGeral.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mmCaixaGeralActionPerformed(evt);
            }
        });
        jMenu4.add(mmCaixaGeral);

        mmContasPagar.setFont(new java.awt.Font("Bitstream Vera Sans Mono", 0, 12)); // NOI18N
        mmContasPagar.setMnemonic('p');
        mmContasPagar.setText("Contas Pagar");
        mmContasPagar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mmContasPagarActionPerformed(evt);
            }
        });
        jMenu4.add(mmContasPagar);

        mmListarCaixas.setFont(new java.awt.Font("Bitstream Vera Sans Mono", 0, 12)); // NOI18N
        mmListarCaixas.setMnemonic('l');
        mmListarCaixas.setText("Listar Caixas");
        mmListarCaixas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mmListarCaixasActionPerformed(evt);
            }
        });
        jMenu4.add(mmListarCaixas);

        mmMovimentContaBancaria.setFont(new java.awt.Font("Bitstream Vera Sans Mono", 0, 12)); // NOI18N
        mmMovimentContaBancaria.setMnemonic('m');
        mmMovimentContaBancaria.setText("Movimentação Conta Bancária");
        mmMovimentContaBancaria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mmMovimentContaBancariaActionPerformed(evt);
            }
        });
        jMenu4.add(mmMovimentContaBancaria);

        jMenuBar1.add(jMenu4);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mmClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mmClienteActionPerformed
        // TODO add your handling code here:
        TelaCliente tc = new TelaCliente();
        tc.setVisible(true);
    }//GEN-LAST:event_mmClienteActionPerformed

    private void mmProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mmProdutoActionPerformed
        // TODO add your handling code here:
        TelaProduto tp = new TelaProduto();
        tp.setVisible(true);
    }//GEN-LAST:event_mmProdutoActionPerformed

    private void mmGrupoProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mmGrupoProdutoActionPerformed
        // TODO add your handling code here:
        TelaGrupoProduto tgp = new TelaGrupoProduto();
        tgp.setVisible(true);
    }//GEN-LAST:event_mmGrupoProdutoActionPerformed

    private void mmCaixaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mmCaixaActionPerformed
        // TODO add your handling code here:
        TelaCaixa tc = new TelaCaixa();
        tc.setVisible(true);
    }//GEN-LAST:event_mmCaixaActionPerformed

    private void mmVendedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mmVendedorActionPerformed
        // TODO add your handling code here:
        TelaVendedor tv = new TelaVendedor();
        tv.setVisible(true);
    }//GEN-LAST:event_mmVendedorActionPerformed

    private void mmEmpresaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mmEmpresaActionPerformed
        // TODO add your handling code here:
        TelaEmpresa te = new TelaEmpresa();
        te.setVisible(true);
    }//GEN-LAST:event_mmEmpresaActionPerformed

    private void mmContaReceberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mmContaReceberActionPerformed
        // TODO add your handling code here:
        TelaContaPromissoria tc = new TelaContaPromissoria();
        tc.setVisible(true);
    }//GEN-LAST:event_mmContaReceberActionPerformed

    private void mmUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mmUsuarioActionPerformed
        TelaUsuario tu = new TelaUsuario();
        tu.setVisible(true);
        permissoes();
    }//GEN-LAST:event_mmUsuarioActionPerformed

    private void mmVendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mmVendaActionPerformed
        if (!Util.verificaCaixaAberto()) {
            JOptionPane.showMessageDialog(rootPane, "Caixa Fechado!");
            return;
        }

        TelaVenda tv = new TelaVenda();
        tv.setVisible(true);
    }//GEN-LAST:event_mmVendaActionPerformed

    private void mmListarVendasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mmListarVendasActionPerformed
        TelaListarVendas tlv = new TelaListarVendas();
        tlv.setVisible(true);
    }//GEN-LAST:event_mmListarVendasActionPerformed

    private void mmOrcamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mmOrcamentoActionPerformed
        TelaListarOrcamento to = new TelaListarOrcamento("");
        to.setVisible(true);
    }//GEN-LAST:event_mmOrcamentoActionPerformed

    private void mmCartaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mmCartaoActionPerformed
        TelaListarCartao tlc = new TelaListarCartao();
        tlc.setVisible(true);
    }//GEN-LAST:event_mmCartaoActionPerformed

    private void mmFornecedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mmFornecedorActionPerformed
        TelaFornecedor tf = new TelaFornecedor();
        tf.setVisible(true);
    }//GEN-LAST:event_mmFornecedorActionPerformed

    private void mmContaBancariaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mmContaBancariaActionPerformed
        TelaContaBancaria tcb = new TelaContaBancaria();
        tcb.setVisible(true);
    }//GEN-LAST:event_mmContaBancariaActionPerformed

    private void mmCaixaGeralActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mmCaixaGeralActionPerformed
        TelaCaixaGeral tcg = new TelaCaixaGeral();
        tcg.setVisible(true);
    }//GEN-LAST:event_mmCaixaGeralActionPerformed

    private void mmListarCaixasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mmListarCaixasActionPerformed
        TelaListarCaixas tlc = new TelaListarCaixas();
        tlc.setVisible(true);
    }//GEN-LAST:event_mmListarCaixasActionPerformed

    private void mmContasPagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mmContasPagarActionPerformed
        TelaContaPagar tcp = new TelaContaPagar();
        tcp.setVisible(true);
    }//GEN-LAST:event_mmContasPagarActionPerformed

    private void mmMovimentContaBancariaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mmMovimentContaBancariaActionPerformed
        TelaMovimentacaoContaBancaria tmcb = new TelaMovimentacaoContaBancaria();
        tmcb.setVisible(true);
    }//GEN-LAST:event_mmMovimentContaBancariaActionPerformed

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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JLabel lblImage;
    private javax.swing.JMenu mCadastro;
    private javax.swing.JMenuItem mmCaixa;
    private javax.swing.JMenuItem mmCaixaGeral;
    private javax.swing.JMenuItem mmCartao;
    private javax.swing.JMenuItem mmCliente;
    private javax.swing.JMenuItem mmContaBancaria;
    private javax.swing.JMenuItem mmContaReceber;
    private javax.swing.JMenuItem mmContasPagar;
    private javax.swing.JMenuItem mmEmpresa;
    private javax.swing.JMenuItem mmFornecedor;
    private javax.swing.JMenuItem mmGrupoProduto;
    private javax.swing.JMenuItem mmListarCaixas;
    private javax.swing.JMenuItem mmListarVendas;
    private javax.swing.JMenuItem mmMovimentContaBancaria;
    private javax.swing.JMenuItem mmOrcamento;
    private javax.swing.JMenuItem mmProduto;
    private javax.swing.JMenuItem mmUsuario;
    private javax.swing.JMenuItem mmVenda;
    private javax.swing.JMenuItem mmVendedor;
    // End of variables declaration//GEN-END:variables
}
