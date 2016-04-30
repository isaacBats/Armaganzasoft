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
import armaganzasoft.services.BaseDatos;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;


public class Materials {
    private int     id;
    private String  name; 
    private String  code;
    private String atributo;
    private String tipo;

   
   private Statement stm;
   private ResultSet rs;
   
      private String sql;
      private BaseDatos db;
      private Connection conn= null;
    private Statement stmt;
      
      /**
       * Default Construct 
       */
      public Materials(){
      
      }
       public Object[][] ConsultarMaterial(){
    Object [][] datos =new Object[id][];
        try {
            if(conectar()){
                sql="SELECT *FROM materials";
                Statement stmt=this.stmt;
                ResultSet res=stmt.executeQuery(sql);
                int fila=0;
                while(res.next()){
                    for(int columna=0; columna<3; columna++)
                    datos [fila][columna]= res.getObject(columna+1);
                    fila ++;
            }
                res.close();
                stmt.close();
                //desconectar();
            }
        } catch (Exception e) {
            System.out.println("Excepcion al Consultar Material : "+e);
        }
        return datos;
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
    
    
    
    
   
   
    private boolean conectar() {
        this.db = new BaseDatos();
        this.conn = db.getConnection();
        if(this.conn != null){
            return true;
        }else{
            return false;
        }}

    
}
