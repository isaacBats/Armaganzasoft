package armaganzasoft.models;

import armaganzasoft.interfaces.Menu;
import armaganzasoft.models.User;
import armaganzasoft.services.BaseDatos;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.Hashtable;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Isaac Daniel
 */
public class User {
    
    private int     id;
    private String  num_employee;
    private String  name;
    private String  last_name;
    private String  email;
    private String  password;
    private String  usuario;
    private String  position;
    private String  roll;
    private String active;
    private Date    update_at;
    private Date    created_at;
   private Statement stm;
   private ResultSet rs;
   private Statement stmt;
   
      private String sql;
      private BaseDatos db;
      private Connection conn= null;
      
      /**
       * Default Construct 
       */
       public Object[][] ConsultarUsuario(){
    Object [][] datos =new Object[id][];
        try {
            if(conectar()){
                sql="SELECT *FROM users";
                Statement stmt=this.stmt;
                ResultSet res=stmt.executeQuery(sql);
                int fila=0;
                while(res.next()){
                    for(int columna=0; columna<9; columna++)
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
      
      public User(){
      
      }
    
    public boolean validarUsuario(String Login, String password) throws SQLException{
        String nombre="";
            if(conectar()){
               String sql = "SELECT * FROM users WHERE user like '"+Login+"';";
                
               //String sql = "SELECT * FROM users WHERE name like '"+Login+"';";
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
    }
    
    
    
    public boolean BuscarUsuario (String Clave)throws SQLException{
        if(conectar()){
            String sql = "SELECT * FROM users WHERE num_employee like'"+Clave+"';";
            Statement stmt = this.conn.createStatement();
            ResultSet res = stmt.executeQuery(sql);
            return true;
        }
     

else{
                   
                    System.out.println("No se encontro el registro");
        try {
            this.conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        } return false;
                } }   
    
    
    
    public int getId() {
        return id;
    }
    
    public String getNum_employee() {
        return num_employee;
    }

    public void setNum_employee(String num_employee) {
        this.num_employee = num_employee;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getRoll() {
        return roll;
    }

    public void setRoll(String roll) {
        this.roll = roll;
    }

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }

    public Date getUpdate_at() {
        return update_at;
    }

    public void setUpdate_at(Date update_at) {
        this.update_at = update_at;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }
     
    private boolean conectar() {
        this.db = new BaseDatos();
        this.conn = db.getConnection();
        if(this.conn != null){
            return true;
        }else{
            return false;
        }
    }
    
}
    
      
