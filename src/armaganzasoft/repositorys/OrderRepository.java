package armaganzasoft.repositorys;

import armaganzasoft.models.DetailOrders;
import armaganzasoft.models.Order;
import armaganzasoft.models.Partitions;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Isaac Daniel < @codeisaac >
 */
public class OrderRepository extends BaseRepository {
     
    /**
     * Sentence to execute in database
     */
    private PreparedStatement query;
    
    

    public OrderRepository() {
        
    }
    
    /**
     * Insert a new Order in data Base
     * @param order
     * @return int   True if I was inserted into the Data Base
     */
    public int addOrden(Order order){
        
        boolean exito = false;
        int last = 0;
        try {
            
            query = con.prepareStatement("INSERT INTO orders (costumer_id, "
                                                          + "branch_id, "
                                                          + "quantity, "
                                                          + "measurement_unit_id, "
                                                          + "total_price, "
                                                          + "num_orden, "
                                                          + "remission_id) "
                                        + "VALUES(?, ?, ?, ?, ?, ?, ?);"
                                        );
            
            
            query.setInt(1, order.getCostumerId());
            query.setInt(2, order.getBranchId());
            query.setFloat(3, order.getQuantity());
            query.setInt(4, order.getMeasurementUnit());
            query.setFloat(5, order.getTotal());
            query.setString(6, order.getNumOrden());
            query.setInt(7, order.getRemision());
            
            if( !query.execute() ){
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT LAST_INSERT_ID() AS id;");
                if(rs.next()){
//                    while(rs.next()){
                        last = rs.getInt("id");
//                    }
                }
            }
            query.close();
            
        } catch (SQLException ex) {
            System.out.println("OrderRepository => Error al agregar una orden: "+ ex);
            
        }

        return last;
        
    }
    
    /**
     * Insert a new detail_order in data Base
     * @param order
     * @return int   True if I was inserted into the Data Base
     */
    public int addDetailOrder(DetailOrders order){
        
        boolean exito = false;
        int last = 0;
        
        try {
            query = con.prepareStatement("INSERT INTO detail_orders (order_id, "
                                                          + "form_id, "
                                                          + "deadline) "
                                        + "VALUES(?, ?, ?);"
                                        );
            
            
            query.setInt(1, order.getOrder_id());
            query.setInt(2, order.getForm_id());
            query.setString(3, order.getDeadline());
            
            if( !query.execute() ){
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT LAST_INSERT_ID() AS id;");
                if(rs.next()){
//                    while(rs.next()){
                        last = rs.getInt("id");
//                    }
                }
            }
            query.close();
            
        } catch (SQLException ex) {
            System.out.println("OrderRepository => Error al agregar un detalle de  orden: "+ ex);
            
        }
        
        return last;
        
    }
    
    /**
     * Insert a new partition of an order in data Base
     * @param order
     * @return Boolean   True if I was inserted into the Data Base
     */
    public boolean addPartition(Partitions order){
        
        boolean exito = false;
        try {
            
            query = con.prepareStatement("INSERT INTO partitions (detail_order_id, "
                                                          + "contact, "
                                                          + "mobil,"
                                                          + "address,"
                                                          + "value) "
                                        + "VALUES(?, ?, ?, ?, ?);"
                                        );
            
            
            query.setInt(1, order.getDetailOrderId());
            query.setString(2, order.getContact());
            query.setString(3, order.getMobil());
            query.setString(4, order.getAddress());
            query.setString(5, order.getValue());
            
            if( !query.execute() ){
                exito = true;
            }
            query.close();
            
        } catch (SQLException ex) {
            System.out.println("OrderRepository => Error al agregar una particion de  orden: "+ ex);
            
        }
        
        return exito;
        
    }
    
    public ResultSet getDetailForm( int formId ){
    
        Statement stmt = null;       
        
        String sql = "SELECT df.order, ope.code, ope.descripcion, mat.name, CONCAT(df.value, df.type) as value " +
                     "FROM detail_form df " +
                     "INNER JOIN operations ope ON df.operation_id = ope.id " +
                     "INNER JOIN materials mat ON df.material_id = mat.id " +
                     "WHERE form_id = " + formId;
        try {
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery( sql );

            return rs;
        } catch (SQLException e) {
            System.out.println("No se ejecuto el query "+ e);
            System.out.println(sql);
        }
        
        return null;
    }
    
    public ResultSet getForm( int formId ){
    
        Statement stmt = null;       
        
        String sql = "SELECT m.tipo, CONCAT(df.value, df.type) as porcentaje, '10%' as teorico " +
                     "FROM detail_form df " +
                     "INNER JOIN materials m ON df.material_id = m.id " +
                     "WHERE df.form_id = " + formId;
        try {
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery( sql );

            return rs;
        } catch (SQLException e) {
            System.out.println("No se ejecuto el query "+ e);
            System.out.println(sql);
        }
        
        return null;
    }
    
    public int getLastId( ){
    
        int id = 0;
        Statement stmt = null;       
        
        String sql = "SELECT max( id ) as id " +
                     "FROM orders ";
        try {
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery( sql );
            if(rs.next()){
                id = rs.getInt("id");
            }
            
            stmt.close();
            rs.close();
            
        } catch (SQLException e) {
            System.out.println("OrderRepository[Class] : getLastId => No se ejecuto el Query "+ e);
            System.out.println(sql);
        }
        
        return id;
    }
    
    public ResultSet getAllOrders(){
    
        Statement stmt;       
        
        String sql = "SELECT * FROM orders";
        try {
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery( sql );

            return rs;
        } catch (SQLException e) {
            System.out.println("OrderRepository[Class] : getAllOrders => No se ejecuto el query "+ e);
            System.out.println(sql);
        }
        
        return null;
    }
    
    public ResultSet getAllOrders( int limit ){
    
        Statement stmt;       
        
        String sql = "SELECT * FROM orders ORDER BY id DESC LIMIT " + limit;
        try {
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery( sql );

            return rs;
        } catch (SQLException e) {
            System.out.println("OrderRepository[Class] : getAllOrders => No se ejecuto el query "+ e);
            System.out.println(sql);
        }
        
        return null;
    }

    public ResultSet getOrderByNumOrder(String orden) {
        
        Statement stmt;       
        
        //String sql = "SELECT * FROM orders WHERE num_orden = '" + orden + "'";
        String sql = "SELECT " +
                            "o.date_issue AS 'fecha', " +
                            "o.quantity AS 'cantidad_orden', " +
                            "CONCAT(c.name, ' ', c.last_name ) AS 'cliente', " +
                            "c.address AS 'direccion', " +
                            "c.movil AS 'telefono', " +
                            "c.rfc AS 'rfc', " +
                            "( SELECT name FROM forms WHERE id = do.form_id ) AS 'formula', " +
                            "( SELECT id FROM forms WHERE id = do.form_id ) AS 'id_formula', " +
                            "do.id AS 'id_detalle', " +
                            "p.contact AS 'contacto_entrega', " +
                            "p.mobil AS 'telefono_entrega', " +
                            "p.address AS 'direccion_entrega', " +
                            "p.value AS 'cantidad_parcial', " +
                            "r.num_remision AS 'remision' " +
                    "FROM orders o " +
                    "INNER JOIN customers c ON o.costumer_id = c.id " +
                    "INNER JOIN detail_orders do ON do.order_id = o.id " +
                    "INNER JOIN partitions p ON p.detail_order_id = do.id " +
                    "INNER JOIN remission r ON o.remission_id = r.id " +
                    "WHERE o.num_orden = '"+ orden +"';";
        try {
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery( sql );

            return rs;
        } catch (SQLException e) {
            System.out.println("OrderRepository[Class] : getOrderByNumOrder => No se ejecuto el query "+ e);
            System.out.println(sql);
        }
        
        return null;
    }
        
}