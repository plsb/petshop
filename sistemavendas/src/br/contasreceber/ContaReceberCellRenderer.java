 package br.contasreceber;

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
public class ContaReceberCellRenderer extends DefaultTableCellRenderer{

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column); //To change body of generated methods, choose Tools | Templates.
        
        ContasReceberDAO dao = new ContasReceberDAO();
        ContasReceberTableModel vtm = (ContasReceberTableModel) table.getModel();       
        ContasReceber cr = vtm.getValueAt(row);
        Date d = new Date();
        Date vencimento = cr.getDataVencimento();
                
        if(d.after(vencimento) && !cr.isPaga()){
            setForeground(Color.RED);
        } else if(d.before(vencimento) && !cr.isPaga()) {
            setForeground(Color.BLUE);
        } else {
            setForeground(Color.BLACK);
        }
//        if(isSelected){
//            setBackground(Color.BLACK);
//        }
        
        
        return this;
    }
    
    
    
}
