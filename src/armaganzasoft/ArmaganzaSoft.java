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
                       
         java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Usuarios().setVisible(true);
            }
        });
                
    }
    
}