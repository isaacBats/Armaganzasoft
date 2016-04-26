/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package armaganzasoft.models;

import armaganzasoft.services.BaseDatos;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import java.util.Date;
import armaganzasoft.interfaces.Menu;

/**
 *
 * @author daniel
 */
public class Branch {
     private int     id;
    private String  name;
    private String  adress;
    private String  telephone;
    private String  city;
    private String  zip_code;
    private String  rfc;
    private String email;
    
    private Statement stm;
    private ResultSet rs;
    private Statement stmt;
   
      private String sql;
      private BaseDatos db;
      private Connection conn= null;
      
      public Object[][] ConsultarCliente(){
    Object [][] datos =new Object[id][];
        try {
            if(conectar()){
                sql="SELECT *FROM branches";
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

      
      public Branch(){
      
      }     
           public int getid() {
        return id;
    }
    
   public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZip_code() {
        return zip_code;
    }

    public void setZip_code(String zip_code) {
        this.zip_code = zip_code;
    }

    public String getRfc() {
        return rfc;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }
    
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

