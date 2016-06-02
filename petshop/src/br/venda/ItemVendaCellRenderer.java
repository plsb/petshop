 package br.venda;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author Pedro Saraiva
 */
public class ItemVendaCellRenderer extends DefaultTableCellRenderer{

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column); //To change body of generated methods, choose Tools | Templates.
        
        ItemVendaDAO dao = new ItemVendaDAO();
        ItemVendaTableModel vtm = (ItemVendaTableModel) table.getModel();       
        ItemVenda v = vtm.getValueAt(row);
        if(v.isCancelado()){
            setBackground(Color.RED);
        } else {
            setBackground(null);
        }
        
        if(isSelected){
            setBackground(Color.BLUE);
        }
        
        return this;
    }
    
    
    
}
