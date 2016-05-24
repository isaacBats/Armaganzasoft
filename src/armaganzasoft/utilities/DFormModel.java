/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package armaganzasoft.utilities;

import armaganzasoft.repositorys.OrderRepository;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author daniel
 */
public class DFormModel extends AbstractTableModel{

    private ResultSet rs;
    private OrderRepository orderRepo;
    private ResultSetMetaData rsmd;
    private Object[] data;
    private String[] columnName = new String [] {
                "ORDEN", "CODIGO", "DESCRIPCION", "MATERIAL", "VALOR P1"
            };

    public DFormModel() {
    
            this.orderRepo = new OrderRepository();
            this.rs = orderRepo.getDetailForm( 1 );
        try {
            this.rsmd = this.rs.getMetaData();
        } catch (SQLException ex) {
            System.out.println("Algo paso al traer la metadata");
        }
    
    }

    public Object[] getData(){
    
        try {
            while (this.rs.next()) {
                this.data = new Object[this.rsmd.getColumnCount()];
                for (int i = 0; i < this.rsmd.getColumnCount(); i++) {
                    this.data[i]=rs.getObject(i+1);
                }
            }
        } catch (SQLException ex) {
                System.out.println("Error: "+ex);;
        }
        
        return this.data;
    
    }
    
    
    @Override
    public int getRowCount() {
        try {
            return this.rs.getRow();
        } catch (SQLException ex) {
            System.out.println("Algo paso al contar las filas: "+ex);
        }
        return 0;
    }

    @Override
    public int getColumnCount() {
        try {
            return this.rsmd.getColumnCount();
        } catch (SQLException ex) {
            System.out.println("Algo paso al contar las columnas: "+ex);
        }
        return 0;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
