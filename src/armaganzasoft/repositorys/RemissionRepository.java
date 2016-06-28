/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package armaganzasoft.repositorys;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Isaac Daniel < @codeisaac >
 */
public class RemissionRepository extends BaseRepository {
    
    
    /**
     * Sentence to execute in database
     */
    private PreparedStatement query;
    
    public int getLastId( ){
    
        int id = 0;
        Statement stmt = null;       
        
        String sql = "SELECT max( id ) as id " +
                     "FROM remission ";
        try {
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery( sql );
            if(rs.next()){
                id = rs.getInt("id");
            }
            
            stmt.close();
            rs.close();
            
        } catch (SQLException e) {
            System.out.println("RemissionRepository[Class] : getLastId => No se ejecuto el Query "+ e);
            System.out.println(sql);
        }
        
        return id;
    }

    public int addRemission( String remission ) {
        boolean exito = false;
        int last = 0;
        
        try {
            query = con.prepareStatement("INSERT INTO remission (num_remision) "
                                        + "VALUES(?);"
                                        );
            
            
            query.setString(1, remission);
            
            if( !query.execute() ){
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT LAST_INSERT_ID() AS id;");
                if(rs.next()){
                        last = rs.getInt("id");
                }
            }
            query.close();
            
        } catch (SQLException ex) {
            System.out.println("RemissionRepository[Class] : getLastRemission => Error al agregar una remision: "+ ex);
            
        }
        
        return last;
    }
    
}
