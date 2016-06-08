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
public class VendaTableModel extends AbstractTableModel {

    private String[] nomeColunas = {"Id", "Data", "Hora", "Tipo Pagamento", "Cliente",
        "Vendedor", "Parcial", "Desconto", "Total", "Vl. Dinh.", "Vl. Prom.", "Vl. Cartão", "Realizou Venda"};
    private List<Venda> vendas;

    /**
     * Construtor sobrecarregado.
     *
     * @param lista List(Autor).
     */
    // construtor que adiciona a lista passada pelo método ao alunos  
    public VendaTableModel(List<Venda> lista) {
        vendas = new ArrayList(new HashSet(lista));
//        this.leitores.clear();
//        this.leitores.addAll(lista);
        Collections.sort(vendas);
        super.fireTableDataChanged();
    }

    /**
     * Método sobrescrito.
     *
     * @return int.
     */
    @Override
    public int getRowCount() {
        return vendas.size();
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
        Venda v = vendas.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return Util.decimalFormat().format(v.getId());
            case 1:
                return v.getData();
            case 2:
                return v.getHora();
            case 3:
                return tipoPagamento(v);
            case 4:
                return v.getCliente().getNome();
            case 5:
                return v.getVendedor().getNome();
            case 6:
                return v.getValorTotal();
            case 7:
                return v.getDesconto();
            case 8:
                return v.getValorTotal() - v.getDesconto();
            case 9:
                return v.getVlVista();
            case 10:
                return v.getVlPromissoria();
            case 11:
                return v.getVlCartao();
            case 12:
                return v.getUsuario().getNome();

        }
        return null;
    }

    public Venda getValueAt(int rowIndex) {
        Venda v = vendas.get(rowIndex);
        return v;
    }

    private String tipoPagamento(Venda v) {
        if (v.getTipoPagamento().equals("VV")) {
            return "Venda à Vista";
        } else if (v.getTipoPagamento().equals("VP")) {
            return "Venda à Prazo";
        } else {
            return "Venda à Cartão";
        }
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
            case 9:
                return nomeColunas[9];
            case 10:
                return nomeColunas[10];
            case 11:
                return nomeColunas[11];
            case 12:
                return nomeColunas[12];

        }
        return null;
    }
}
