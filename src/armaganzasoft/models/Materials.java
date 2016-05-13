/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package armaganzasoft.models;

/**
 *
 * @author ErwinValle
 */



public class Materials {
    private int     id;
    private String  name; 
    private String  code;
    private String atributo;
    private String tipo;
    private String valor;

   
 
      
      public Materials(){
      
      }
    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
    
        public String getAtributo() {
        return atributo;
    }

    public void setAtributo(String atributo) {
        this.atributo = atributo;
    }
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }
     
  

    
}
