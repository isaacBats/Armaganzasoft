/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package armaganzasoft.utilities;

import javax.swing.table.AbstractTableModel;

/**
 *
 * @author daniel
 */
public class DFormModel extends AbstractTableModel{

    @Override
    public int getRowCount() {
        return 25;
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
