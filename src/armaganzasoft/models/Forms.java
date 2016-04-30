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
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import armaganzasoft.interfaces.Menu;
import armaganzasoft.models.User;
import java.util.Hashtable;

public class Forms {
    
     private int     id;
    private String  code;
    private String  name;
    private String receta;
    
    private String operacion;
    private String material_id;
    private String valor;
    private String taraje;
    private String tolerancia;
    private String velocidad;
    private String habilitado;
  
   
   private Statement stm;
   private ResultSet rs;
   
      private String sql;
      private BaseDatos db;
      private Connection conn= null;
      
      /**
       * Default Construct 
       */
      public Forms(){
      
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
    
        public String getReceta() {
        return receta;
    }

    public void setReceta(String receta) {
        this.receta = receta;
    }
    
       public String getOperacion() {
        return operacion;
    }

    public void setOperacion(String operacion) {
        this.operacion = operacion;
    }
    
           public String getMaterial_id() {
        return material_id;
    }

    public void setMaterial_id(String material_id) {
        this.material_id = material_id;
    }
    
           public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }
    
     public String getTaraje() {
        return taraje;
    }

    public void setTaraje(String taraje) {
        this.taraje = taraje;
    }
    
       public String getTolerancia() {
        return tolerancia;
    }

    public void setTolerancia(String tolerancia) {
        this.tolerancia = tolerancia;
    }
    
       public String getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(String velocidad) {
        this.velocidad = velocidad;
    }
    
      public String getHabilitado(){
          return habilitado;
      }

    public void setHabilitado(String habilitado) {
        this.habilitado = habilitado;
    }
    
     
    private boolean conectar() {
        this.db = new BaseDatos();
        this.conn = db.getConnection();
        if(this.conn != null){
            return true;
        }else{
            return false;
        }}}

    
      
    

