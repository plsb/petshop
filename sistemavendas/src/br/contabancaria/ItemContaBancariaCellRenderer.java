 package br.contabancaria;

import br.contaspagar.*;
import br.contasreceber.*;
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
public class ItemContaBancariaCellRenderer extends DefaultTableCellRenderer{

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column); //To change body of generated methods, choose Tools | Templates.
        
        ItemContaBancariaDAO dao = new ItemContaBancariaDAO();
        ItemContaBancariaTableModel vtm = (ItemContaBancariaTableModel) table.getModel();       
        ItemContaBancaria icb = vtm.getValueAt(row);
                        
        if(icb.isBloqueada()){ 
            setForeground(Color.BLUE);
        } else {
            setForeground(null);
        }
        
//        if(isSelected){
//            setBackground(Color.BLACK);
//        }
        
        
        return this;
    }
    
    
    
}
