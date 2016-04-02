package armaganzasoft.models;

import armaganzasoft.services.BaseDatos;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

/**
 * @author Isaac Daniel
 */
public class User {
    
    private int     id;
    private int     branch_id;
    private String  num_employee;
    private String  name;
    private String  last_name;
    private String  email;
    private String  password;
    private String  position;
    private String  roll;
    private boolean active;
    private Date    update_at;
    private Date    created_at;
   
      private String sql=null;
      private BaseDatos db;
      private Connection conn;
    
    public String validarUsario(String Login, String password) throws SQLException{
        String nombre="";
            if(conectar()){
                String sql = "SELECT * FROM users WHERE name like '"+Login+"';";
                Statement stmt = this.conn.createStatement();
                ResultSet res = stmt.executeQuery(sql);
                if(res.next()){
//                    nombre = res.getString("name");
                    
                    if( password.equals(res.getString("password"))){
                        nombre = "Bienvenido a Armaganza Soft";
                    }else{
                        nombre = "Contraseña invalida";
                    }
                }else{
                    return "No se encontro registro";
                }    
                res.close();
                stmt.close();
                this.conn.close();
                return nombre;
            }
        return "No se encontro registro";
        
    }

    public int getId() {
        return id;
    }
    
    public int getBranch_id() {
        return branch_id;
    }

    public void setBranch_id(int branch_id) {
        this.branch_id = branch_id;
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

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
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

    public String validarUsuario(String login, String password) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
}
