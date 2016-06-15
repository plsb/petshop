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
package br.contabancaria;

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
public class ItemContaBancariaTableModel extends AbstractTableModel {

    private String[] nomeColunas = {"Código", "Data", "", "Entrada", "Saída", "Saldo", "Descrição"};
    private List<ItemContaBancaria> contas;

    /**
     * Construtor sobrecarregado.
     *
     * @param lista List(Autor).
     */
    // construtor que adiciona a lista passada pelo método ao alunos  
    public ItemContaBancariaTableModel(List<ItemContaBancaria> lista) {
        contas = new ArrayList(new HashSet(lista));
//        this.leitores.clear();
//        this.leitores.addAll(lista);
        Collections.sort(contas);
        super.fireTableDataChanged();
    }

    /**
     * Método sobrescrito.
     *
     * @return int.
     */
    @Override
    public int getRowCount() {
        return contas.size();
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
        ItemContaBancaria conta = contas.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return Util.decimalFormat().format(conta.getId());
            case 1:
                return conta.getData();
            case 2:
                return conta.getBloqueada();
            case 3:
                return conta.getEntrada();
            case 4:
                return conta.getSaida();
            case 5:
                double saldo = 0;
                if (rowIndex == 0) {
                    ItemContaBancariaDAO dao = new ItemContaBancariaDAO();
                    if (conta.isBloqueada()) {
                        saldo = dao.saldoContaAntesDe(conta.getData(), conta.getContaBancaria());
                    } else {
                        saldo = (conta.getEntrada() - conta.getSaida())+
                                        dao.saldoContaAntesDe(conta.getData(),
                                                conta.getContaBancaria());
                    }
                } else {
                    Object o = getValueAt(rowIndex - 1, 5);
                    
                    if (conta.isBloqueada()) {
                        saldo = Double.parseDouble(String.valueOf(o).replaceFirst(",", "."));
                    } else {
                        saldo = Double.parseDouble(String.valueOf(o).replaceFirst(",", "."))
                                + (conta.getEntrada() - conta.getSaida());
                    }
                }
                return Util.acertarNumero(saldo);

            case 6:
                return conta.getDescricao();
        }
        return null;
    }

    public ItemContaBancaria getValueAt(int rowIndex) {
        ItemContaBancaria conta = contas.get(rowIndex);
        return conta;
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
