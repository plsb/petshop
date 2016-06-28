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
package br.cartao;

import br.cliente.*;
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
public class CartaoTableModel extends AbstractTableModel {

    private String[] nomeColunas = {"Código", "Data", "Tipo", "Bandeira", "Cliente", "Qtd Parc.", "Valor"};
    private List<CartaoCredito> cartoes;

    /**
     * Construtor sobrecarregado.
     *
     * @param lista List(Autor).
     */
    // construtor que adiciona a lista passada pelo método ao alunos  
    public CartaoTableModel(List<CartaoCredito> lista) {
        cartoes = new ArrayList(new HashSet(lista));
//        this.leitores.clear();
//        this.leitores.addAll(lista);
        Collections.sort(cartoes);
        super.fireTableDataChanged();
    }

    /**
     * Método sobrescrito.
     *
     * @return int.
     */
    @Override
    public int getRowCount() {
        return cartoes.size();
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
        CartaoCredito cartao = cartoes.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return Util.decimalFormat().format(cartao.getId());
            case 1:
                return cartao.getData();
            case 2:
                return cartao.getTipo();
            case 3:
                return cartao.getBandeira();
            case 4:
                return cartao.getDescricao()!=null?cartao.getDescricao():cartao.getCliente().getNome();
            case 5:
                return cartao.getQtdParcelas();
            case 6:
                return cartao.getValor();
        }
        return null;
    }

    public CartaoCredito getValueAt(int rowIndex) {
        CartaoCredito cartao = cartoes.get(rowIndex);

        return cartao;
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
