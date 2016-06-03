 package br.venda;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author Pedro Saraiva
 */
public class VendaCellRenderer extends DefaultTableCellRenderer{

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column); //To change body of generated methods, choose Tools | Templates.
        
        VendaDAO dao = new VendaDAO();
        VendaTableModel vtm = (VendaTableModel) table.getModel();       
        Venda v = vtm.getValueAt(row);
        if(v.isCancelada()){
            setForeground(Color.RED);
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
