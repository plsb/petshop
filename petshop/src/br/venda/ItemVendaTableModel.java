package br.venda;

import br.produto.*;
import br.produto.Produto;
import br.util.Util;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import javax.swing.table.AbstractTableModel;

@SuppressWarnings("serial")
public class ItemVendaTableModel extends AbstractTableModel {

    private String[] nomeColunas = {"Ordem", "Código", "Descrição", "Tipo", "Quantidade", "Valor", "Parcial", "Desconto", "Subtotal"};
    private List<ItemVenda> produtos;

    /**
     * Construtor sobrecarregado.
     *
     * @param lista List(Autor).
     */
    // construtor que adiciona a lista passada pelo método ao alunos  
    public ItemVendaTableModel(List<ItemVenda> lista) {
//        produtos = new ArrayList(new HashSet(lista));
        produtos = lista;
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
        ItemVenda p = produtos.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return p.getOrdem();
            case 1:
                return p.getProduto().getCodigo();
            case 2:
                return p.getProduto().getDescricao();
            case 3:
                return p.getProduto().getTipo();
            case 4:
                return Util.acertarNumero(p.getQuantidade());
            case 5:
                return Util.acertarNumero(p.getValorUni());
            case 6:
                return Util.acertarNumero(p.getParcial());
            case 7:
                return Util.acertarNumero(p.getDesconto());
            case 8:
                return p.getSubtotal();

        }
        return null;
    }
    
     public ItemVenda getValueAt(int rowIndex) {
        ItemVenda p = produtos.get(rowIndex);
        return p;
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
            case 7:
                return nomeColunas[7];
            case 8:
                return nomeColunas[8];

        }
        return null;
    }
}
