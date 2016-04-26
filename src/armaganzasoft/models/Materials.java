/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package armaganzasoft.models;

/**
 *
 * @author rodri
 */
import armaganzasoft.services.BaseDatos;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;


public class Materials {
    private int     id;
    private String  name; 
    private String  code;
    private String value;
    

   
   private Statement stm;
   private ResultSet rs;
   
      private String sql;
      private BaseDatos db;
      private Connection conn= null;
      
      /**
       * Default Construct 
       */
      public Materials(){
      
      }
  
    
    public int getId() {
        return id;
    }
    
   public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

       public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
    
        public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
    
    
   
   
    private boolean conectar() {
        this.db = new BaseDatos();
        this.conn = db.getConnection();
        if(this.conn != null){
            return true;
        }else{
            return false;
        }}

    
}
