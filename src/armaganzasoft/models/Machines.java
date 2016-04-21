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

public class Machines {
    
    private int     id;
    private String  name; 
    private String  code;
    private String value;
    private String identified;

   
      
      /**
       * Default Construct 
       */
      public Machines(){
      
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
   
       public String getIdentified() {
        return identified;
    }

    public void setIdentified(String identified) {
        this.identified = identified;
    }   
    
}
