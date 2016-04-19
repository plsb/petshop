
package br.produto;

import br.produto.Produto;
import br.util.Util;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import javax.swing.table.AbstractTableModel;

@SuppressWarnings("serial")
public class ProdutoTableModel extends AbstractTableModel {

    private String[] nomeColunas = {"Id", "Código", "Descrição", "Grupo de Produto", "Tipo", "Qtd", "Valor"};
    private List<Produto> produtos;

    /**
     * Construtor sobrecarregado.
     *
     * @param lista List(Autor).
     */
    // construtor que adiciona a lista passada pelo método ao alunos  
    public ProdutoTableModel(List<Produto> lista) {
        produtos = new ArrayList(new HashSet(lista));
//        this.leitores.clear();
//        this.leitores.addAll(lista);
        Collections.sort(produtos);
        super.fireTableDataChanged();
    }

    /**
     * Método sobrescrito.
     *
     * @return int.
     */
    @Override
    public int getRowCount() {
        return produtos.size();
    }

    /**
     * Método sobrescrito.
     *
     * @return int.
     */
    @Override
    public int getColumnCount() {
        return nomeColunas.length;
    }

    /**
     * Método sobrescrito.
     *
     * @param rowIndex int
     * @param columnIndex int.
     * @return Object.
     */
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Produto p = produtos.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return Util.decimalFormat().format(p.getId());
            case 1:
                return p.getCodigo();
            case 2:
                return p.getDescricao();
            case 3:
                return p.getGrupoProduto().getDescricao();
            case 4:
                return p.getTipo();
            case 5:
                return p.getQtdEstoque();
            case 6:
                return p.getPrecoVenda();

        }
        return null;
    }

    /**
     * Método sobrescrito.
     *
     * @param column int.
     * @return String nomeColunas[index].
     */
    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return nomeColunas[0];
            case 1:
                return nomeColunas[1];
            case 2:
                return nomeColunas[2];
            case 3:
                return nomeColunas[3];
            case 4:
                return nomeColunas[4];
            case 5:
                return nomeColunas[5];
            case 6:
                return nomeColunas[6];

        }
        return null;
    }
}
