/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package armaganzasoft.models;

/**
 *
 * @author Rodrigo
 */
import armaganzasoft.services.BaseDatos;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import java.util.Date;
import armaganzasoft.interfaces.Menu;
import armaganzasoft.interfaces.EquipoDeTrabajo;
import java.util.Hashtable;

public class Recet {
    
    private int     id;
    private String  code; 
    private String name;
    private String arena;
    private String agua; 
    private String grava;
    private String cemento;
    private String aditivo;
    

   
   private Statement stm;
   private ResultSet rs;
   
      private String sql;
      private BaseDatos db;
      private Connection conn= null;
      
      /**
       * Default Construct 
       */
      public Recet(){
      
      }
  
    
    public int getId() {
        return id;
    }
    
      public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
    
   public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

        
        public String getArena() {
        return arena;
    }

    public void setArena(String arena) {
        this.arena = arena;
    }

     public String getAgua() {
        return agua;
    }

    public void setAgua(String agua) {
        this.agua = agua;
    }

      public String getGrava() {
        return grava;
    }

    public void setGrava(String grava) {
        this.grava = grava;
    }

     public String getCemento() {
        return cemento;
    }

    public void setCemento(String cemento) {
        this.cemento = cemento;
    }
    
        public String getAditivo() {
        return aditivo;
    }

    public void setAditivo(String aditivo) {
        this.aditivo = aditivo;
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

    

