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
import java.sql.SQLException;
import java.util.Date;
import armaganzasoft.interfaces.Menu;
import java.util.Hashtable;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Machines {
    
   private int     id;
    private String  name; 
    private String  code;
    private String material_uso;
    private String estado;
    private String alarma;
    private String atributo;
    private String u_medida;
   
   private Statement stm;
   private ResultSet rs;
   private Statement stmt;
   
      private String sql;
      private BaseDatos db;
      private Connection conn= null;
      
      /**
       * Default Construct 
       */
      public Object[][] ConsultarMaquina(){
    Object [][] datos =new Object[id][];
        try {
            if(conectar()){
                sql="SELECT *FROM machines";
                Statement stmt=this.stmt;
                ResultSet res=stmt.executeQuery(sql);
                int fila=0;
                while(res.next()){
                    for(int columna=0; columna<7; columna++)
                    datos [fila][columna]= res.getObject(columna+1);
                    fila ++;
            }
                res.close();
                stmt.close();
                //desconectar();
            }
        } catch (Exception e) {
            System.out.println("ExcepciÃ³n al Consultar Cliente : "+e);
        }
        return datos;
    }
      
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
       
    private boolean conectar() {
        this.db = new BaseDatos();
        this.conn = db.getConnection();
        if(this.conn != null){
            return true;
        }else{
            return false;
        }}

    
    
}
