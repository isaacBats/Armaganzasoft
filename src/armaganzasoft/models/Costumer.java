package armaganzasoft.models;

import armaganzasoft.services.BaseDatos;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;


/**
 *
 * @author ErwinValle
 */
public class Costumer {
    
/**
 * @author ErwinValle
 */
    
    private int     id;
    private String identified;
    private String  name;
    private String  last_name;
    private String  email;
    private String  telephone;
    private String  movil;
    private String  rfc;
    private String  address;
    private String  city;
    private String  zip_code;
    private String sub_costumer;
    private String  costumer_id;
   
   private Statement stm;
   private ResultSet rs;
   private Statement stmt;
   
      private String sql;
      private BaseDatos db;
      private Connection conn= null;
      
      /**
       * Default Construct 
       */
     public Costumer(){
      
      }
   public Object[][] ConsultarCliente(){
    Object [][] datos =new Object[id][];
        try {
            if(conectar()){
                sql="SELECT *FROM costumers";
                Statement stmt=this.stmt;
                ResultSet res=stmt.executeQuery(sql);
                int fila=0;
                while(res.next()){
                    for(int columna=0; columna<12; columna++)
                    datos [fila][columna]= res.getObject(columna+1);
                    fila ++;
            }
                res.close();
                stmt.close();
                //desconectar();
            }
        } catch (Exception e) {
            System.out.println("Excepcion al Consultar Cliente : "+e);
        }
        return datos;
    }
   


  //ingreso datos  
    public int getId() {
        return id;
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

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getMovil() {
        return movil;
    }

    public void setMovil(String movil) {
        this.movil = movil;
    }
    
    public String getRfc() {
        return rfc;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }
    
     public String getAddress() {
        return address;
    }

    public void setAddress(String adress) {
        this.address = adress;
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
    
    public String getSub_costumer() {
        return sub_costumer;
    }

    public void setSub_costumer(String sub_costumer) {
        this.sub_costumer = sub_costumer;
    }

    public String getCostumer_id() {
        return costumer_id;
    }

    public void setCostumer_id(String costumer_id) {
        this.costumer_id = costumer_id;
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