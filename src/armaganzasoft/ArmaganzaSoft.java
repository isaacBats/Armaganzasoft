/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package armaganzasoft;

import armaganzasoft.interfaces.Usuarios;
import armaganzasoft.models.User;
import armaganzasoft.repositorys.UserRepository;

/**
 *
 * @author isaac daniel
 */
//prueba comentario
public class ArmaganzaSoft {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {        
               
//        User pedro;
//        
//        pedro = new User();
//        
//        pedro.setBranch_id(1);
//        pedro.setNum_employee("A023");
//        pedro.setName("Juan");
//        pedro.setLast_name("Gabriel");
//        pedro.setEmail("jgabriel@allgo.com");
//        pedro.setUser("pepe");
//        pedro.setPassword("1234");
//        pedro.setPosition("Colador");
//        pedro.setRoll("USER");
//        pedro.setActive(true);
//        
//        
//        UserRepository  userRepo = new UserRepository();
//
//        if( !userRepo.addUsuario(pedro) ){
//            System.out.println("El usuario "+pedro.getName()+" se ha insertado Correctamente");
//        }else{
//            System.out.println("El usuario "+pedro.getName()+" se ha insertado Correctamente");
//        }
        
         java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Usuarios().setVisible(true);
            }
        });
                
    }
    
}