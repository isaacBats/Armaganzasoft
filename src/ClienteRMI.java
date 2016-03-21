/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package armaganzasoft.interfaces;

import armaganzasoft.interfaces.InterfazRMI;
import java.rmi.RMISecurityManager;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 *
 * @author user
 */
public class ClienteRMI {
    
    private Registry registro=null;
    private InterfazRMI miInterfazCliente=null;
    
    
    public void inicializaSeguridad(){
        if(System.getSecurityManager()==null)
            System.setSecurityManager(new RMISecurityManager());
        try{
            registro=LocateRegistry.getRegistry("192.168.100.110", 12345);
            miInterfazCliente=(InterfazRMI)registro.lookup("rmiServidorRemoto");
        }catch(Exception e){
            System.out.println("Excepcion al inicializar la comunicación RMI");
        }
    }
    
    public String validarUsuarioRemoto(String login, String password, int indice){
        String nombre="";
        try {
            this.inicializaSeguridad();
            nombre=miInterfazCliente.validarUsuario(login, password, indice);
        } catch (Exception e) {
            System.out.println("Excepción al validar en cliente RMI");
        }        
        return nombre;    
}
}
