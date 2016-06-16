/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package armaganzasoft.services;

import java.sql.ResultSet;
import java.util.ArrayList;

import armaganzasoft.models.Customer;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Isaac Daniel < @codeisaac >
 */
public class CustomerController {

    private List <Customer> customer;
    private List <Customer> listCustomers;
    
    public List<Customer> getCustomers (ResultSet rs){
        this.customer = new ArrayList<>();
        this.listCustomers = new ArrayList <>();
        try {
            while(rs.next()){
                Customer rowCliente = new Customer();
                
                rowCliente.setId(rs.getInt("id"));
                rowCliente.setName("name");
                rowCliente.setLast_name("last_name");
                rowCliente.setEmail("email");
                rowCliente.setTelephone("telephone");
                rowCliente.setMovil("movil");
                rowCliente.setRfc("rfc");
                rowCliente.setAddress("address");
                rowCliente.setCity("city");
                rowCliente.setZip_code("zip_code");
                
                customer.add(rowCliente);
            }
            listCustomers.addAll(customer);
            
            return listCustomers;
        } catch (SQLException ex) {
            System.out.println("CustomerController: A ocurrido un error: " + ex);
        }
        return null;
    }
    
    
}
