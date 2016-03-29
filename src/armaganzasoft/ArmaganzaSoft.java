/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package armaganzasoft;

import armaganzasoft.components.Valvula;
import armaganzasoft.repositorys.ValvulaRepository;
import java.awt.Button;


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
               
        
        Valvula valvulaAgua;
        
        ValvulaRepository vr;        
        
        valvulaAgua = new Valvula("V002", "Valvula Agua 2");
        
//        vr = new ValvulaRepository();
//        vr.addValvula(valvulaAgua);

        if(valvulaAgua.getStatus() == 0){
            System.out.println("La valvula "+valvulaAgua.getName()+" se encuentra Cerrada");
        }        
        System.out.println("Abriendo valvula "+valvulaAgua.getName());
        valvulaAgua.open();
        
        Button boton;
        
        boton = new Button( "Abrir" );
        boton.setVisible(true);
        
        
        
        
        
    }
    
}