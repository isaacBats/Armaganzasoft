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

public class Recet {
    
    private int     id;
    private String code; 
    private String name;
    private String arena;
    private String agua; 
    private String grava;
    private String cemento;
    private String aditivo;
    private String operacion;
    
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

    public String getOperacion() {
        return operacion;
    }

    public void setOperacion(String operacion) {
        this.operacion = operacion;
    }

      
    
}

    

