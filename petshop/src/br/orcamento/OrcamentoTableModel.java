package br.orcamento;

import br.util.Util;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import javax.swing.table.AbstractTableModel;

@SuppressWarnings("serial")
public class OrcamentoTableModel extends AbstractTableModel {

    private String[] nomeColunas = {"Id", "Data", "Tipo Pagamento", "Cliente", 
        "Vendedor", "Parcial", "Desconto", "Total"};
    private List<Orcamento> orcamentos;

    /**
     * Construtor sobrecarregado.
     *
     * @param lista List(Autor).
     */
    // construtor que adiciona a lista passada pelo método ao alunos  
    public OrcamentoTableModel(List<Orcamento> lista) {
        orcamentos = new ArrayList(new HashSet(lista));
//        this.leitores.clear();
//        this.leitores.addAll(lista);
        Collections.sort(orcamentos);
        super.fireTableDataChanged();
    }

    /**
     * Método sobrescrito.
     *
     * @return int.
     */
    @Override
    public int getRowCount() {
        return orcamentos.size();
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
        Orcamento o = orcamentos.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return Util.decimalFormat().format(o.getId());
            case 1:
                return o.getData();
            case 2:
                return tipoPagamento(o);
            case 3:
                return o.getCliente().getNome();
            case 4:
                return o.getVendedor().getNome();
            case 5:
                return o.getValorTotal();
            case 6:
                return o.getDesconto();
            case 7:
                return o.getValorTotal()-o.getDesconto();

        }
        return null;
    }
    
    public Orcamento getValueAt(int rowIndex) {
        Orcamento o = orcamentos.get(rowIndex);
        return o;
    }
    
    private String tipoPagamento(Orcamento v){
        if(v.getTipoPagamento().equals("VV")){
            return "Venda à Vista";
        } else if(v.getTipoPagamento().equals("VP")){
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
        }
        return null;
    }
}
