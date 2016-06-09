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
package br.contasreceber;

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
public class ContasReceberTableModel extends AbstractTableModel {

    private String[] nomeColunas = {"Código", "Nr Conta", "Cliente", "Nr Parcela", "Data Vencimento", "Valor", "Data Pagamento", "Valor Pago"};
    private List<ContasReceber> contas;

    /**
     * Construtor sobrecarregado.
     *
     * @param lista List(Autor).
     */
    // construtor que adiciona a lista passada pelo método ao alunos  
    public ContasReceberTableModel(List<ContasReceber> lista) {
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
        ContasReceber conta = contas.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return Util.decimalFormat().format(conta.getId());
            case 1:
                return conta.getNrConta()==null ? "" : conta.getNrConta();
            case 2:
                return conta.getCliente().getNome();
            case 3:
                return conta.getNrParcela() == 0 ? "01" : conta.getNrParcela();
            case 4:
                return conta.getDataVencimento() == null ? "" : conta.getDataVencimento();
            case 5:
                return conta.getValor();
            case 6:
                return conta.getDataPagamento();
            case 7:
                return conta.getValorPago();
        }
        return null;
    }
    
    public ContasReceber getValueAt(int rowIndex) {
        ContasReceber conta = contas.get(rowIndex);
        
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
            case 7:
                return nomeColunas[7];
        }
        return null;
    }
}
