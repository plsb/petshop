package br.fornecedor;

import br.cliente.*;
import br.util.Util;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import javax.swing.table.AbstractTableModel;

@SuppressWarnings("serial")
public class FornecedorTableModel extends AbstractTableModel {

    private String[] nomeColunas = {"Código", "Razão Social", "Nome Fantasia", "Endereço", "Cidade"};
    private List<Fornecedor> fornecedores;

    /**
     * Construtor sobrecarregado.
     *
     * @param lista List(Autor).
     */
    // construtor que adiciona a lista passada pelo método ao alunos  
    public FornecedorTableModel(List<Fornecedor> lista) {
        fornecedores = new ArrayList(new HashSet(lista));
//        this.leitores.clear();
//        this.leitores.addAll(lista);
        Collections.sort(fornecedores);
        super.fireTableDataChanged();
    }

    /**
     * Método sobrescrito.
     *
     * @return int.
     */
    @Override
    public int getRowCount() {
        return fornecedores.size();
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
        Fornecedor f = fornecedores.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return Util.decimalFormat().format(f.getId());
            case 1:
                return f.getRazaoSocial();
            case 2:
                return f.getNomeFantasia();
            case 3:
                return f.getEndereco();
            case 4:
                return f.getCidade()+"-"+f.getEstado();
            
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

        }
        return null;
    }
}
