package armaganzasoft.models;

import armaganzasoft.services.BaseDatos;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;

/**
 * @author Isaac Daniel
 */
public class User {
    
    String nombre;
    String clave;

   public void setNombre(String nombre){
         this.nombre = nombre;
   }
   
   public String getNombre(){
       return nombre;
   }
   
   public void setClave(String clave){
       this.clave = clave;
   }
   
   public String getClave(){
       return clave;
   }
   
    
}
