package armaganzasoft.models;

import armaganzasoft.services.BaseDatos;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import armaganzasoft.interfaces.Menu;

/**
 *
 * @author ErwinValle
 */
public class Costumers {
    
/**
 * @author ErwinValle
 */
    
    private int     id;
    private String  identified;
    private String  name;
    private String  last_name;
    private String  email;
    private String  telephone;
    private String  movil;
    private String  rfc;
    private String  adress;
    private String  city;
    private String  zip_code;
    private String sub_costumer;
    private String  customer_id;
   
   private Statement stmt;
   private ResultSet rs;
   
      private String sql;
      private BaseDatos db;
      private Connection conn= null;
      
      /**
       * Default Construct 
       */
      public Costumers(){
      
      }
       public Object[][] ConsultarCliente(){
    Object [][] datos =new Object[id][];
        try {
            if(conectar()){
                sql="SELECT *FROM orders";
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
            System.out.println("Excepción al Consultar Cliente : "+e);
        }
        return datos;
    }
    public int ContarClienteBuscado(String ClienteBuscado){
        int cantidad=0;
        try {
            if(conectar()){
                sql="SELECT count(identified) As cantidad FROM costumers WHERE (identified LIKE'%"+ClienteBuscado+"%' OR name LIKE'%"+ClienteBuscado+"%')";
                Statement  stmt= this.stmt;
                ResultSet res=stmt.executeQuery(sql);

                if(res.next())
                   cantidad=res.getInt("cantidad");
                res.close();
                stmt.close();
                //desconectar();
            }
        } catch (Exception e) {
            System.out.println("Excepción al Contar a Cliente Buscado: "+e);
        }
        return cantidad;
    }
    
    public Object[][] ConsultarClienteBuscado( String ClienteBuscado){
        Object [][] datos =new Object[ContarClienteBuscado(ClienteBuscado)][12];
        try {
            if(conectar()){
                sql="SELECT *FROM cotumers WHERE (identified LIKE'%"+ClienteBuscado+"%' OR name LIKE'%"+ClienteBuscado+"%') ";
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
               // desconectar();
            }
        } catch (Exception e) {
            System.out.println("Excepción al Consultar a un cliente buscado : "+e);
        }
        return datos;
    }
    public Object[] eligeOrden(String cliente){
        Object[] datos = new Object[8];
        try {
            if(conectar()){
                sql="SELECT * FROM costumers WHERE identified="+cliente;
                Statement stmt=this.stmt;
                ResultSet res=stmt.executeQuery(sql);
                if(res.next()){
                    

                    datos [0]=res.getString("identified");
                    datos [1]=res.getString("name");
                    datos [2]=res.getString("last_name");
                    datos [3]=res.getString("email");
                    datos [4]=res.getString("telephone");
                    datos [5]=res.getString("movil");
                    datos [6]=res.getString("rfc");
                    datos [7]=res.getString("adress");
                    datos [8]=res.getString("city");
                    datos [9]=res.getString("zip_code");
                    datos [10]=res.getString("sub_costumer");
                    datos [11]=res.getString("costumer_id");
                    
                  
                }
                res.close();
                stmt.close();
               // desconectar();
            }
        } catch (Exception e) {
            System.out.println("Excepción al Elegir un Cliente : "+e);
        }
        return datos;
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
    
   public String getIdentified() {
        return identified;
    }

    public void setIdentified(String identified) {
        this.identified = identified;
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
    
     public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
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
    
    public String getSub_customer() {
        return sub_costumer;
    }

    public void setSub_customer(String sub_costumer) {
        this.sub_costumer = sub_costumer;
    }

    public String getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(String customer_id) {
        this.customer_id = customer_id;
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
    

