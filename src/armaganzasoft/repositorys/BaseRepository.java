/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package armaganzasoft.repositorys;

import armaganzasoft.services.BaseDatos;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Isaac Daniel <@codeisaac>
 */
public class BaseRepository {

    /**
     * To connect to Data Base
     */
    private BaseDatos baseDatos = new BaseDatos();
    
    /**
     * Get connection a data Base
     */
    protected  Connection con = baseDatos.getConnection();
    
    public int getMyBranchId(){
        int sucursal = 0;
        Statement stmt;       
        
        String sql = "SELECT id FROM branches limit 1";
        try {
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery( sql );
            if(rs.next()){
//                while(rs.next()){
                    sucursal = rs.getRow();
//                }
            }

        } catch (SQLException e) {
            System.out.println("No se ejecuto el query "+ e);
            System.out.println(sql);
        }
        return sucursal;
    }
}
