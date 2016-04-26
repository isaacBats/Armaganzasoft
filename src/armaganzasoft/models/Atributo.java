/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package armaganzasoft.models;

import armaganzasoft.services.BaseDatos;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import java.util.Date;
import armaganzasoft.interfaces.Menu;
import armaganzasoft.models.Atributo;
import java.util.Hashtable;
/**

/**
 *
 * @author rodri
 */
public class Atributo {
   

    
    private int     id;
    private String  identified;

   
   private Statement stm;
   private ResultSet rs;
   
      private String sql;
      private BaseDatos db;
      private Connection conn= null;
      
      /**
       * Default Construct 
       */
      public Atributo(){
      
      }
  
    
    public int getId() {
        return id;
    }
    
   public String getIdentified() {
        return identified;
    }

    public void setIdentified(String identified) {
        this.identified = identified;
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
    


    

