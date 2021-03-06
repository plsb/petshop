/* Este arquivo é parte do OSBiblio.
 * Copyright (C) 2014 (Pedro Saraiva, Túlio Vidal, Luís Henrique, Adriano Lima, Oziel Pereira,
 * Marcos Ellys, Francisco Júnior, Fátima Pinheiro, Darly Vinicio).
 *
 * OSBiblio é um software livre; você pode redistribuí-lo e/ou  modificá-lo dentro dos termos da 
 * Licença Pública Geral GNU como publicada pela Fundação do Software Livre (FSF); na versão 2 da Licença,
 * ou (na sua opinião) qualquer versão.
 *
 * Este programa é distribuído na esperança de que possa ser útil, mas SEM NENHUMA GARANTIA; sem uma garantia 
 * implícita de ADEQUAÇÃO a qualquer MERCADO ou APLICAÇÃO EM PARTICULAR. Veja a Licença Pública Geral GNU
 * para maiores detalhes.
 */
package br.livro;

import br.grupo_produto.*;
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
public class LivroCaixaTableModel extends AbstractTableModel {

    private String[] nomeColunas = {"Código", "Entrada", "Saída", "Saldo", "Descrição"};
    private List<LivroCaixa> livro;

    /**
     * Construtor sobrecarregado.
     *
     * @param lista List(Autor).
     */
    // construtor que adiciona a lista passada pelo método ao alunos  
    public LivroCaixaTableModel(List<LivroCaixa> lista) {
        livro = new ArrayList(new HashSet(lista));
//        this.leitores.clear();
//        this.leitores.addAll(lista);
        Collections.sort(livro);
        super.fireTableDataChanged();
    }

    /**
     * Método sobrescrito.
     *
     * @return int.
     */
    @Override
    public int getRowCount() {
        return livro.size();
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
        LivroCaixa l = livro.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return Util.decimalFormat().format(l.getId());

            case 1:
                return l.getValorEntrada();
            case 2:
                return l.getValorSaida();
            case 3:
                double saldo = 0;
                if (rowIndex == 0) {
                    saldo = l.getValorEntrada() - l.getValorSaida();
                } else {
                    Object o = getValueAt(rowIndex - 1, 3);
                    saldo = Double.parseDouble(String.valueOf(o).replaceFirst(",", "."))
                            + (l.getValorEntrada() - l.getValorSaida());
                }
                return Util.acertarNumero(saldo);
            case 4:
                return l.getDescricao();

        }
        return null;
    }

    public LivroCaixa getValueAt(int rowIndex) {
        LivroCaixa l = livro.get(rowIndex);
        return l;
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
