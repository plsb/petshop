 package br.orcamento;

import br.venda.*;
import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author Pedro Saraiva
 */
public class OrcamentoCellRenderer extends DefaultTableCellRenderer{

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column); //To change body of generated methods, choose Tools | Templates.
        
        OrcamentoDAO dao = new OrcamentoDAO();
        OrcamentoTableModel vtm = (OrcamentoTableModel) table.getModel();       
        Orcamento o = vtm.getValueAt(row);
        if(o.isImportado()){
            setBackground(Color.GREEN);
        } else {
            setBackground(null);
        }
        
        if(isSelected){
            setBackground(Color.BLUE);
        }
        
        return this;
    }
    
    
    
}
