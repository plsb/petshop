/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.telas;

import br.cliente.*;
import br.grupo_produto.GrupoProduto;
import br.grupo_produto.GrupoProdutoDAO;
import br.produto.Estoque;
import br.produto.EstoqueDAO;
import br.produto.ProdutoTableModel;
import br.produto.Produto;
import br.produto.ProdutoDAO;
import br.util.HibernateUtil;
import br.util.LoadPropriedade;
import br.util.UsuarioAtivo;
import br.util.Util;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collections;
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
public class TelaProduto extends javax.swing.JDialog {

    private double quantidade = 0;

    /**
     * Creates new form TelaCliente
     */
    public TelaProduto() {
        initComponents();
        setModal(true);
        setLocationRelativeTo(null);
        preencheGrupo();
        setTitle("Adiciona/Edita Produto");
    }

    private void preencheGrupo() {
        GrupoProdutoDAO dao = new GrupoProdutoDAO();
        List<GrupoProduto> lista = dao.list();
        Collections.sort(lista);
        for (GrupoProduto gr : lista) {
            cbGrupo.addItem(gr);
        }
    }

    private void produtoServico() {
        boolean b = !chbServico.isSelected();
        tfEstoqueMinimo.setEnabled(b);
        tfPrecoCompra.setEnabled(b);
        tfQtdEstoque.setEditable(b);
        cbUnidade.setEnabled(b);
    }

    private Produto produto;
    private ProdutoDAO dao = new ProdutoDAO();

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        sexo = new javax.swing.ButtonGroup();
        mpRelatorio = new javax.swing.JPopupMenu();
        imEstoqueMinimo = new javax.swing.JMenuItem();
        imHistoricoAlteracaoItem = new javax.swing.JMenuItem();
        imRelacaoProdutos = new javax.swing.JMenuItem();
        jPanel4 = new javax.swing.JPanel();
        lbTexto = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        btDelete = new javax.swing.JButton();
        btCancelar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        tfDescricao = new javax.swing.JTextField();
        btSalvar = new javax.swing.JButton();
        btNovo = new javax.swing.JButton();
        btPesquisar1 = new javax.swing.JButton();
        cbGrupo = new javax.swing.JComboBox();
        jLabel29 = new javax.swing.JLabel();
        chbServico = new javax.swing.JCheckBox();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        tfQtdEstoque = new javax.swing.JFormattedTextField();
        jLabel4 = new javax.swing.JLabel();
        tfPrecoVenda = new javax.swing.JFormattedTextField();
        jLabel5 = new javax.swing.JLabel();
        tfEstoqueMinimo = new javax.swing.JFormattedTextField();
        jLabel30 = new javax.swing.JLabel();
        cbUnidade = new javax.swing.JComboBox();
        tfPrecoCompra = new javax.swing.JFormattedTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        tfCodigo = new javax.swing.JTextField();
        btnImprimir = new javax.swing.JButton();

        imEstoqueMinimo.setText("Estoque Mínimo");
        imEstoqueMinimo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                imEstoqueMinimoActionPerformed(evt);
            }
        });
        mpRelatorio.add(imEstoqueMinimo);

        imHistoricoAlteracaoItem.setText("Histórico de Alteração do Ítem");
        imHistoricoAlteracaoItem.setEnabled(false);
        imHistoricoAlteracaoItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                imHistoricoAlteracaoItemActionPerformed(evt);
            }
        });
        mpRelatorio.add(imHistoricoAlteracaoItem);

        imRelacaoProdutos.setText("Relação Produtos");
        imRelacaoProdutos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                imRelacaoProdutosActionPerformed(evt);
            }
        });
        mpRelatorio.add(imRelacaoProdutos);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setBackground(new java.awt.Color(0, 153, 255));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbTexto.setFont(new java.awt.Font("Verdana", 1, 30)); // NOI18N
        lbTexto.setText("Produtos/Serviços");
        jPanel4.add(lbTexto, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 330, 40));

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
        jPanel1.add(btDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 360, 43, 40));

        btCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/imagens/close.png"))); // NOI18N
        btCancelar.setToolTipText("Sair");
        btCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCancelarActionPerformed(evt);
            }
        });
        jPanel1.add(btCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 360, 43, 41));

        jLabel1.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel1.setText("Descrição.: *");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, -1, -1));

        tfDescricao.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jPanel1.add(tfDescricao, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 400, -1));

        btSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/imagens/pataverde.png"))); // NOI18N
        btSalvar.setToolTipText("Salvar");
        btSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSalvarActionPerformed(evt);
            }
        });
        jPanel1.add(btSalvar, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 360, 43, -1));

        btNovo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/imagens/new.png"))); // NOI18N
        btNovo.setToolTipText("Novo");
        btNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btNovoActionPerformed(evt);
            }
        });
        jPanel1.add(btNovo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 360, 43, -1));

        btPesquisar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/imagens/find.png"))); // NOI18N
        btPesquisar1.setToolTipText("Pesquisar");
        btPesquisar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btPesquisar1ActionPerformed(evt);
            }
        });
        jPanel1.add(btPesquisar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 360, 43, 40));

        cbGrupo.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        cbGrupo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "--" }));
        jPanel1.add(cbGrupo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, 400, -1));

        jLabel29.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel29.setText("Grupo de Produtos.:*");
        jPanel1.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, -1, -1));

        chbServico.setBackground(new java.awt.Color(255, 255, 255));
        chbServico.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        chbServico.setText("Serviço?");
        chbServico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chbServicoActionPerformed(evt);
            }
        });
        chbServico.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                chbServicoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                chbServicoFocusLost(evt);
            }
        });
        jPanel1.add(chbServico, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, -1, -1));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel2.setText("Qtd Estoque.: *");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, -1));

        tfQtdEstoque.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));
        tfQtdEstoque.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jPanel2.add(tfQtdEstoque, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 160, -1));

        jLabel4.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel4.setText("Preço de Venda.: *");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 20, -1, -1));

        tfPrecoVenda.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));
        tfPrecoVenda.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jPanel2.add(tfPrecoVenda, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 40, 160, -1));

        jLabel5.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel5.setText("Estoque Mínimo.: *");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, -1, -1));

        tfEstoqueMinimo.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));
        tfEstoqueMinimo.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jPanel2.add(tfEstoqueMinimo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 160, -1));

        jLabel30.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel30.setText("Unidade de Media.: *");
        jPanel2.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, -1, -1));

        cbUnidade.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        cbUnidade.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "--", "CX", "L", "HOR", "KG", "PC", "SCO", "UNI" }));
        jPanel2.add(cbUnidade, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, 160, -1));

        tfPrecoCompra.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));
        tfPrecoCompra.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jPanel2.add(tfPrecoCompra, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 90, 160, -1));

        jLabel6.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel6.setText("Preço de Custo.: ");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 70, -1, -1));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, 400, 170));

        jLabel3.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel3.setText("Código Referência.: *");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        tfCodigo.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jPanel1.add(tfCodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 400, -1));

        btnImprimir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/imagens/print.png"))); // NOI18N
        btnImprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImprimirActionPerformed(evt);
            }
        });
        jPanel1.add(btnImprimir, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 360, 40, 40));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 430, 420));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btDeleteActionPerformed
        if (Util.verificaPermissao("EXCLUIR_PRODUTO", 1)) {
            if (JOptionPane.showConfirmDialog(rootPane, "Deseja Excluir o Produto?", "", JOptionPane.YES_NO_OPTION,
                    JOptionPane.INFORMATION_MESSAGE) == JOptionPane.YES_OPTION) {
                dao.remove(produto);
                limpaCampos();
            }
        }
    }//GEN-LAST:event_btDeleteActionPerformed

    private void btCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelarActionPerformed
        setVisible(false);
    }//GEN-LAST:event_btCancelarActionPerformed

    

    private void btSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSalvarActionPerformed
        if (Util.verificaPermissao("CE_PRODUTO", 1)) {
            if (produto == null) {
                produto = new Produto();
            }
            if (Util.chkVazio(tfDescricao.getText(), cbGrupo.getSelectedItem().toString(),
                    tfCodigo.getText(), tfPrecoVenda.getText())) {
                if (!chbServico.isSelected()) {
                    if (!Util.chkVazio(tfEstoqueMinimo.getText(),
                            tfQtdEstoque.getText(), cbUnidade.getSelectedItem().toString())) {
                        return;
                    }

                }
                produto.setDescricao(tfDescricao.getText());
                produto.setCodigo(tfCodigo.getText());
                produto.setGrupoProduto((GrupoProduto) cbGrupo.getSelectedItem());
                produto.setServico(chbServico.isSelected());
                if (!tfEstoqueMinimo.getText().equals("")) {
                    produto.setEstoqueMinimo(Double.parseDouble(tfEstoqueMinimo.getText().replaceFirst(",", ".")));
                } else {
                    produto.setEstoqueMinimo(0);
                }
                if (!tfPrecoVenda.getText().equals("")) {
                    produto.setPrecoVenda(Double.parseDouble(tfPrecoVenda.getText().replaceFirst(",", ".")));
                } else {
                    produto.setPrecoVenda(0);
                }
                if (!tfQtdEstoque.getText().equals("")) {
                    produto.setQtdEstoque(Double.parseDouble(tfQtdEstoque.getText().replaceFirst(",", ".")));
                } else {
                    produto.setQtdEstoque(0);
                }
                if (!tfPrecoCompra.getText().equals("")) {
                    produto.setPrecoCusto(Double.parseDouble(tfPrecoCompra.getText().replaceFirst(",", ".")));
                } else {
                    produto.setPrecoCusto(0);
                }
                if (cbUnidade.getSelectedIndex() != 0) {
                    produto.setDescricaoUnidade(cbUnidade.getSelectedItem().toString());
                } else {
                    produto.setDescricaoUnidade("");
                }

                if (produto.getId() == null) {
                    if (dao.checkExists("codigo", produto.getCodigo()).size() > 0) {
                        JOptionPane.showMessageDialog(rootPane, "Código/Referência já informado!", "ERRO", JOptionPane.ERROR_MESSAGE);
                        tfCodigo.requestFocus();
                        return;
                    }
                    if (produto.getQtdEstoque() <= 0) {
                        JOptionPane.showMessageDialog(rootPane, "Quantidade não pode ser menor ou igual a 0!", "ERRO", JOptionPane.ERROR_MESSAGE);
                        tfQtdEstoque.requestFocus();
                        return;
                    }
                    dao.add(produto);
                    Util.adicionaEstoque("PRODUTO CADASTRADO", produto.getQtdEstoque(), 0, produto);
                    JOptionPane.showMessageDialog(rootPane, "Produto Cadastrado Com Sucesso!", "INFO", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    dao.update(produto);
                    if (quantidade > produto.getQtdEstoque()) {
                        double saida = quantidade - produto.getQtdEstoque();
                        Util.adicionaEstoque("PRODUTO EDITADO", 0, saida, produto);
                    } else if (quantidade < produto.getQtdEstoque()) {
                        double entrada = produto.getQtdEstoque() - quantidade;
                        Util.adicionaEstoque("PRODUTO EDITADO", entrada, 0, produto);
                    }
                    JOptionPane.showMessageDialog(rootPane, "Produto Editado Com Sucesso!", "INFO", JOptionPane.INFORMATION_MESSAGE);
                }
                limpaCampos();
            }
        }
    }//GEN-LAST:event_btSalvarActionPerformed

    private void btNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btNovoActionPerformed
        limpaCampos();

    }//GEN-LAST:event_btNovoActionPerformed

    private void limpaCampos() {
        produto = new Produto();
        tfEstoqueMinimo.setText("");
        tfPrecoVenda.setText("");
        tfPrecoCompra.setText("");
        tfDescricao.setText("");
        tfQtdEstoque.setText("");
        tfCodigo.setText("");
        cbGrupo.setSelectedIndex(0);
        cbUnidade.setSelectedIndex(0);
        btDelete.setEnabled(false);
        imHistoricoAlteracaoItem.setEnabled(false);
        chbServico.setSelected(false);
        produtoServico();

    }

    private void btPesquisar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btPesquisar1ActionPerformed
        List<Produto> lista = (!(tfDescricao.getText().equals("")) ? dao.checkExists("descricao", tfDescricao.getText()) : dao.list());
        ProdutoTableModel stm = new ProdutoTableModel(lista);
        Object o = TelaPesquisa.exibeTela(stm, "Produto/Serviço");
        if (o != null) {
            produto = new Produto();
            produto = dao.checkExists("id", Integer.valueOf(String.valueOf(o))).get(0);
            tfDescricao.setText(produto.getDescricao());
            tfEstoqueMinimo.setText(String.valueOf(produto.getEstoqueMinimo()));
            tfPrecoVenda.setText(String.valueOf(produto.getPrecoVenda()));
            tfPrecoCompra.setText(String.valueOf(produto.getPrecoCusto()));
            tfQtdEstoque.setText(String.valueOf(produto.getQtdEstoque()));
            quantidade = produto.getQtdEstoque();
            cbGrupo.setSelectedItem(produto.getGrupoProduto());
            if (produto.getDescricaoUnidade().equals("")) {
                cbUnidade.setSelectedIndex(0);
            } else {
                cbUnidade.setSelectedItem(produto.getDescricaoUnidade());
            }
            chbServico.setSelected(produto.isServico());
            produtoServico();
            tfCodigo.setText(produto.getCodigo());
            btDelete.setEnabled(true);
            imHistoricoAlteracaoItem.setEnabled(true);
        }

    }//GEN-LAST:event_btPesquisar1ActionPerformed

    private void chbServicoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_chbServicoFocusGained
        // TODO add your handling code here:
        produtoServico();
    }//GEN-LAST:event_chbServicoFocusGained

    private void chbServicoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_chbServicoFocusLost
        // TODO add your handling code here:
        produtoServico();
    }//GEN-LAST:event_chbServicoFocusLost

    private void chbServicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chbServicoActionPerformed
        // TODO add your handling code here:
        produtoServico();
    }//GEN-LAST:event_chbServicoActionPerformed

    private void btnImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImprimirActionPerformed
        // TODO add your handling code here:
        mpRelatorio.show(btnImprimir, btnImprimir.getWidth(), btnImprimir.getHeight());
    }//GEN-LAST:event_btnImprimirActionPerformed

    private void imHistoricoAlteracaoItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_imHistoricoAlteracaoItemActionPerformed
        if (!produto.isServico()) {
            JasperReport pathjrxml;
            HashMap parametros = new HashMap();

            String sql = "", texto = "";

            sql += String.valueOf(produto.getId());

            try {
                parametros.put("sql", sql);
            } catch (Exception e) {
            }

            String caminho = Util.retornaCaminhoApp();
//        String caminho = "";

            Connection connection = HibernateUtil.getSessionFactory().openStatelessSession().connection();
            try {
                JDialog viewer = new JDialog(new javax.swing.JFrame(), "Visualização do Relatório", true);
                viewer.setSize(1000, 600);
                viewer.setLocationRelativeTo(null);
                viewer.setModal(true);
                File file = new File(caminho + "relatorios/reportHistoricoItem.jrxml");
                FileInputStream is = new FileInputStream(file);
                pathjrxml = JasperCompileManager.compileReport(is);
                JasperPrint printReport = JasperFillManager.fillReport(pathjrxml, parametros,
                        connection);
                JasperViewer jv = new JasperViewer(printReport, false);
                viewer.getContentPane().add(jv.getContentPane());
                viewer.setVisible(true);
                //JasperExportManager.exportReportToPdfFile(printReport, "src/relatorios/RelAcervo.pdf");

                //jv.setVisible(true);
            } catch (JRException ex) {
                JOptionPane.showMessageDialog(rootPane, ex.getMessage());
            } catch (FileNotFoundException ex) {
                JOptionPane.showMessageDialog(rootPane, ex.getMessage());
            }
        } else {
            JOptionPane.showMessageDialog(tfPrecoCompra, "Serviço não possui histórico!");
        }

    }//GEN-LAST:event_imHistoricoAlteracaoItemActionPerformed

    private void imRelacaoProdutosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_imRelacaoProdutosActionPerformed
        JasperReport pathjrxml;
        HashMap parametros = new HashMap();

        String sql = " order by g.descricao, p.descricao", texto = "Geral";

        try {
            parametros.put("sql", sql);
        } catch (Exception e) {
        }
        parametros.put("texto", texto);

        String caminho = Util.retornaCaminhoApp();
//        String caminho = "";

        Connection connection = HibernateUtil.getSessionFactory().openStatelessSession().connection();
        try {
            JDialog viewer = new JDialog(new javax.swing.JFrame(), "Visualização do Relatório", true);
            viewer.setSize(1200, 600);
            viewer.setLocationRelativeTo(null);
            viewer.setModal(true);
            File file = new File(caminho + "relatorios/reportInvetarioEstoque.jrxml");
            FileInputStream is = new FileInputStream(file);
            pathjrxml = JasperCompileManager.compileReport(is);
            JasperPrint printReport = JasperFillManager.fillReport(pathjrxml, parametros,
                    connection);
            JasperViewer jv = new JasperViewer(printReport, false);
            viewer.getContentPane().add(jv.getContentPane());
            viewer.setVisible(true);
                //JasperExportManager.exportReportToPdfFile(printReport, "src/relatorios/RelAcervo.pdf");

            //jv.setVisible(true);
        } catch (JRException ex) {
            JOptionPane.showMessageDialog(rootPane, ex.getMessage());
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(rootPane, ex.getMessage());
        }
    }//GEN-LAST:event_imRelacaoProdutosActionPerformed

    private void imEstoqueMinimoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_imEstoqueMinimoActionPerformed
        JasperReport pathjrxml;
        HashMap parametros = new HashMap();

        String caminho = Util.retornaCaminhoApp();
//        String caminho = "";

        Connection connection = HibernateUtil.getSessionFactory().openStatelessSession().connection();
        try {
            JDialog viewer = new JDialog(new javax.swing.JFrame(), "Visualização do Relatório", true);
            viewer.setSize(1200, 600);
            viewer.setLocationRelativeTo(null);
            viewer.setModal(true);
            File file = new File(caminho + "relatorios/reportEstoqueMinimo.jrxml");
            FileInputStream is = new FileInputStream(file);
            pathjrxml = JasperCompileManager.compileReport(is);
            JasperPrint printReport = JasperFillManager.fillReport(pathjrxml, parametros,
                    connection);
            JasperViewer jv = new JasperViewer(printReport, false);
            viewer.getContentPane().add(jv.getContentPane());
            viewer.setVisible(true);
                //JasperExportManager.exportReportToPdfFile(printReport, "src/relatorios/RelAcervo.pdf");

            //jv.setVisible(true);
        } catch (JRException ex) {
            JOptionPane.showMessageDialog(rootPane, ex.getMessage());
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(rootPane, ex.getMessage());
        }

    }//GEN-LAST:event_imEstoqueMinimoActionPerformed

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
            java.util.logging.Logger.getLogger(TelaProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaProduto().setVisible(true);
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
    private javax.swing.JComboBox cbGrupo;
    private javax.swing.JComboBox cbUnidade;
    private javax.swing.JCheckBox chbServico;
    private javax.swing.JMenuItem imEstoqueMinimo;
    private javax.swing.JMenuItem imHistoricoAlteracaoItem;
    private javax.swing.JMenuItem imRelacaoProdutos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JLabel lbTexto;
    private javax.swing.JPopupMenu mpRelatorio;
    private javax.swing.ButtonGroup sexo;
    private javax.swing.JTextField tfCodigo;
    private javax.swing.JTextField tfDescricao;
    private javax.swing.JFormattedTextField tfEstoqueMinimo;
    private javax.swing.JFormattedTextField tfPrecoCompra;
    private javax.swing.JFormattedTextField tfPrecoVenda;
    private javax.swing.JFormattedTextField tfQtdEstoque;
    // End of variables declaration//GEN-END:variables
}
