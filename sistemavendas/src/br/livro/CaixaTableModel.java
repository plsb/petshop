package br.livro;

import br.caixageral.*;
import br.cliente.*;
import br.livro.Caixa;
import br.util.Util;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Francisco Junior
 */
@SuppressWarnings("serial")
public class CaixaTableModel extends AbstractTableModel {

    private String[] nomeColunas = {"Código", "Situação", "Data Aberto", "Hora Aberto", "Nº Caixa", "Usuário"};
    private List<Caixa> cg;

    /**
     * Construtor sobrecarregado.
     *
     * @param lista List(Autor).
     */
    // construtor que adiciona a lista passada pelo método ao alunos  
    public CaixaTableModel(List<Caixa> lista) {
        cg = new ArrayList(new HashSet(lista));
//        this.leitores.clear();
//        this.leitores.addAll(lista);
        Collections.sort(cg);
        super.fireTableDataChanged();
    }

    /**
     * Método sobrescrito.
     *
     * @return int.
     */
    @Override
    public int getRowCount() {
        return cg.size();
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
        Caixa caixa = cg.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return Util.decimalFormat().format(caixa.getId());
            case 1:
                return caixa.situacao();
            case 2:
                return caixa.getDataAbriu();
            case 3:
                return caixa.getHoraAbriu();
            case 4:
                return caixa.getNrCaixa();
            case 5:
                return caixa.getUser().getNome();

        }
        return null;
    }

    public Caixa getValueAt(int rowIndex) {
        Caixa caixa = cg.get(rowIndex);
        return caixa;
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

        }
        return null;
    }
}
