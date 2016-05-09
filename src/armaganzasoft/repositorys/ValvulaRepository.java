/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package armaganzasoft.repositorys;

import armaganzasoft.components.Valvula;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Isaac Daniel <@codeisaac>
 */
public class ValvulaRepository extends BaseRepository{
    
    /**
     * The name of Valvula
     */
    private String name;
    
    /**
     * The code of Valvula 
     */
    private String code;
    
    /**
     * Sentence to execute in database
     */
    private PreparedStatement query;

    public ValvulaRepository() {
    
    }

    public ValvulaRepository(Valvula valvula) {
        
        this.code = valvula.getCode();
        this.name = valvula.getName();
    }
    
    /**
     * Insert a Valvula in data Base when a new object is created
     * @return Boolean   True if I was inserted into the Data Base
     */
    public Boolean addValvula(){
        
        try {
            
            // String sql = "INSERT INTO machines (name, code) VALUES(?, ?)";   
            query = con.prepareStatement("INSERT INTO machines (name, code) VALUES(?, ?)");
            
            query.setString(1, this.name);
            query.setString(2, this.code);
            
            if( query.execute() )
                return true;
            
        } catch (SQLException ex) {
            System.out.println("Error: "+ ex);
        }finally{
            return false;
        }
    }
    
    /**
     * Insert a Valvula in data Base having a object Valvula parameter
     * @param valvula  A object type Valvula
     * @return Boolean   True if I was inserted into the Data Base 
     */
    public Boolean addValvula(Valvula valvula){
        
        try {
            
            // String sql = "INSERT INTO machines (name, code) VALUES(?, ?)";   
            query = con.prepareStatement("INSERT INTO machines (name, code) VALUES(?, ?)");
            
            query.setString(1, valvula.getName());
            query.setString(2, valvula.getCode());
            
            if( query.execute() )
                return true;
            
        } catch (SQLException ex) {
            System.out.println("Error: "+ ex);
        }finally{
//            return false;
        }
        return false;
    }

    
    
}
