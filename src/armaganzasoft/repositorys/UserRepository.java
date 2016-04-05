/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package armaganzasoft.repositorys;

import armaganzasoft.components.Valvula;
import armaganzasoft.models.Usuarios;
import armaganzasoft.interfaces.Login;
import armaganzasoft.models.User;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author rodri
 */
public class UserRepository extends BaseRepository {
    
    private String name;
    private String lastname;
    private String employee_id;
    private String email;
    private boolean active;
    private String usuario;
    private String password;
    private String position;
    private String roll;
     
    /**
     * Sentence to execute in database
     */
    private PreparedStatement query;
    private int branch_id;

    

    public UserRepository(User user) {
        
        this.name = user.getName();
        this.lastname = user.getLast_name();
         this.employee_id = user.getNum_employee();
        this.email = user.getEmail();
        this.active = user.isActive();
        this.usuario = user.getName();
        this.password = user.getPassword();
        this.position = user.getPosition();
        this.roll = user.getRoll();
    }
    
    /**
     * Insert a Valvula in data Base when a new object is created
     * @return Boolean   True if I was inserted into the Data Base
     */
    public boolean addUsuario(){
        
        try {
            
            // String sql = "INSERT INTO machines (name, code) VALUES(?, ?)";   
            query = con.prepareStatement("INSERT INTO users (branch_id,num_employee, name, lastname, email, pass, posotion, roll, active) "
                                        + "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)");
            
            query.setInt(1, this.branch_id);
            query.setString(2, this.employee_id);
            query.setString(3, this.name);
            query.setString(4, this.lastname);
            query.setString(5, this.email);
            query.setString(6, this.password);
            query.setString(7, this.position);
            query.setString(8, this.roll);
            
            if( query.execute() )
                return true;
            
        } catch (SQLException ex) {
            System.out.println("Error: "+ ex);
        }finally{
            return false;
        }
    }
    
    /**
     * Insert a Valvula in data Base having a object Valvula parameter
     * @param valvula  A object type Valvula
     * @return Boolean   True if I was inserted into the Data Base 
     */
   

    
    
}