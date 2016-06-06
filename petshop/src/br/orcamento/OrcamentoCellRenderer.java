 package br.orcamento;

import br.venda.*;
import java.awt.Color;
import java.awt.Component;
import java.util.Calendar;
import java.util.Date;
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
        
        Calendar c = Calendar.getInstance();
        c.setTime(o.getDataValidade());
        c.add(Calendar.DATE, 1);
        
        if(new Date().after(c.getTime()) && !o.isImportado()){
            setForeground(Color.RED);
        } else if(o.isImportado()){
            setForeground(Color.BLUE);
        } else {
            setForeground(null);
        }
//        
//        if(isSelected){
//            setBackground(Color.BLUE);
//        }
        
        return this;
    }
    
    
    
}
