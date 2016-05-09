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
    private String material_uso;
    private String estado;
    private String alarma;
    private String atributo;
    private String u_medida;
    private String valor;
   
  
      
      /**
       * Default Construct 
       */
           
      public Machines(){
      
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
    
        public String getMaterial_uso() {
        return material_uso;
    }

    public void setMaterial_uso(String material_uso) {
        this.material_uso = material_uso;
    }
    
      public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
     
               public String getAlarma() {
        return alarma;
    }

    public void setAlarma(String alarma) {
        this.alarma = alarma;
    }
     
          public String getAtributo() {
        return atributo;
    }

    public void setAtributo(String atributo) {
        this.atributo = atributo;
    }
    
      public String getU_medida() {
        return u_medida;
    }

    public void setU_medida(String u_medida) {
        this.u_medida = u_medida;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }
           
}
