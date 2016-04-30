package armaganzasoft.models;

import armaganzasoft.services.BaseDatos;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import armaganzasoft.interfaces.Maquinas;
import armaganzasoft.interfaces.Materiales;
import armaganzasoft.interfaces.Menu;
import java.util.Hashtable;
/**
 *
 * @author ErwinValle
 */
public class Measurement {
    
/**
 * @author ErwinOrlando
 */
    
    private int     id;
    private String  code;
    private String  name;
    private String agua;
    private String arena;
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
      public Measurement(){
      
      }
    /*
    public Boolean validarUsuario(String Login, String password) throws SQLException{
        String nombre="";
            if(conectar()){
                String sql = "SELECT * FROM users WHERE name like '"+Login+"';";
                Statement stmt = this.conn.createStatement();
                ResultSet res = stmt.executeQuery(sql);
                if(res.next() && password.equals(res.getString("password"))){
                        nombre = "Bienvenido a Armaganza Soft";
                        System.out.println(nombre);
                        //JOptionPane.showMessageDialog(this,"BIENVENIDO A ARMAGANZA SOFT");
                        return true;
                 
                }else{
                        nombre = "Contraseña invalida";
                        System.out.println(nombre);
                        return false;
                    }
                }else{
                    //return "No se encontro registro";
                    System.out.println("No se pudo conectar a la base de datos");
                    this.conn.close();
                    return false;
                }    
    }*/
    
    public int getId() {
        return id;
    }
    
   public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName(){
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAgua(){
        return agua;
    }

    public void setAgua(String agua) {
        this.agua = agua;
    }
        
       
   public String getArena(){
        return agua;
    }
    public void setArena(String arena) {
        this.arena = arena;
    }
    
    public String getGrava(){
        return grava;
    }
    public void setGrava(String grava) {
        this.grava = grava;
    }
    public String getCemento(){
        return cemento;
    }
    public void setCemento(String cemento) {
        this.cemento = cemento;
    }
     
    public String getAditivo(){
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
    

