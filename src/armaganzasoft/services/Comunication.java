/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package armaganzasoft.services;

import com.serotonin.modbus4j.ModbusFactory;
import com.serotonin.modbus4j.ModbusMaster;
import com.serotonin.modbus4j.exception.ModbusInitException;
import com.serotonin.modbus4j.ip.IpParameters;
import com.serotonin.modbus4j.msg.ModbusRequest;
import com.serotonin.modbus4j.msg.ReadHoldingRegistersRequest;
import com.serotonin.modbus4j.msg.ReadResponse;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.serotonin.io.serial.*;
import com.serotonin.modbus4j.exception.ModbusTransportException;
import com.serotonin.modbus4j.msg.ReadDiscreteInputsRequest;
import com.serotonin.modbus4j.msg.ReadDiscreteInputsResponse;
import com.serotonin.modbus4j.msg.ReadHoldingRegistersResponse;
import com.serotonin.io.serial.*;
import com.serotonin.modbus4j.*;
import com.serotonin.modbus4j.exception.*;
import com.serotonin.modbus4j.msg.*;
import java.util.*;
import java.util.Arrays;

/**
 *
 * @author daniel
 */
public class Comunication {

    public static String LeoRegistroTCP(int identif, int elcont, int puerto, String IP, int PLCID) {
        ModbusFactory m = new ModbusFactory();
        IpParameters ip = new IpParameters();
        ip.setHost(IP);
        ip.setPort(puerto);
        String Valor = "";

        try {
            ModbusMaster mp = m.createTcpMaster(ip, false);
            mp.init();
            //ModbusRequest req = new WriteRegisterRequest(1,0,1800);  
            //mp.send(req);  
            ModbusRequest req2 = new ReadHoldingRegistersRequest(PLCID, identif, elcont);
            ReadResponse rep = (ReadResponse) mp.send(req2);
            Valor = String.valueOf(rep.getShortData()[0]);
        } catch (Exception ex) {
            //Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error: "+ex);
        }

        return Valor;
    };
    public static String LeoCoilsTCP(int identif, int elcont, int puerto, String IP, int PLCID) {
        ModbusFactory m = new ModbusFactory();
        IpParameters ip = new IpParameters();
        ip.setHost(IP);
        ip.setPort(puerto);
        String Valor = "";

        try {
            ModbusMaster mp = m.createTcpMaster(ip, false);
            mp.init();
            //ModbusRequest req = new WriteRegisterRequest(1,0,1800);  
            //mp.send(req);  
            ModbusRequest req2 = new ReadCoilsRequest(PLCID, identif, elcont);
            ReadResponse rep = (ReadResponse) mp.send(req2);
            byte [] Valor2;
            Valor2= rep.getData();
            Valor= Valor +  Byte.toString(Valor2[0]);
        } catch (Exception ex) {
            //Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error: "+ex);
        }

        return Valor;
    };
    public static String LeoDiscreteInputsTCP(int identif, int elcont, int puerto, String IP, int PLCID) {
        ModbusFactory m = new ModbusFactory();
        IpParameters ip = new IpParameters();
        ip.setHost(IP);
        ip.setPort(puerto);
        String Valor = "";

        try {
            ModbusMaster mp = m.createTcpMaster(ip, false);
            mp.init();
            //ModbusRequest req = new WriteRegisterRequest(1,0,1800);  
            //mp.send(req);  
            ModbusRequest req2 = new ReadDiscreteInputsRequest(PLCID, identif, elcont);
            ReadResponse rep = (ReadResponse) mp.send(req2);
            byte [] Valor2;
            Valor2= rep.getData();
            Valor= Valor +  Byte.toString(Valor2[0]);
        } catch (Exception ex) {
            //Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error "+ex);
        }

        return Valor;
    };
        public static String EscriboRegistroTCP(int identif, int elcont, int puerto, String IP, int PLCID) {
        ModbusFactory m = new ModbusFactory();
        IpParameters ip = new IpParameters();
        ip.setHost(IP);
        ip.setPort(puerto);
        String Valor = "";

        try {
            ModbusMaster mp = m.createTcpMaster(ip, false);
            mp.init();
            ModbusRequest req = new WriteRegisterRequest(PLCID, identif, elcont);  
            mp.send(req);  
            //ModbusRequest req2 = new ReadHoldingRegistersRequest(PLCID, identif, elcont);
            //ReadResponse rep = (ReadResponse) mp.send(req2);
            Valor = "OK";
        } catch (Exception ex) {
            //Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error "+ex);
        }

        return Valor;
    };
    
    public static String EscriboCoilTCP(int identif, int elcont, int puerto, String IP, int PLCID) {
        ModbusFactory m = new ModbusFactory();
        IpParameters ip = new IpParameters();
        ip.setHost(IP);
        ip.setPort(puerto);
        String Valor = "";

        try {
            ModbusMaster mp = m.createTcpMaster(ip, false);
            mp.init();
            if (Integer.toString(elcont).equals("0")){
             ModbusRequest req = new WriteCoilRequest(PLCID, identif, false);  
             mp.send(req);
            }
            else{
             ModbusRequest req = new WriteCoilRequest(PLCID, identif, true);  
             mp.send(req);
            }
            //ModbusRequest req2 = new ReadHoldingRegistersRequest(PLCID, identif, elcont);
            //ReadResponse rep = (ReadResponse) mp.send(req2);
            Valor = "OK";
        } catch (Exception ex) {
            //Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error "+ex);
        }

        return Valor;
    };

    
    

        
           public String LeoRegistroSerialASCII(String [] Args) {
      String Valor = "";
        SerialParameters serialParameters = new SerialParameters();

        //argumentos[0] = PRTSER;
        //argumentos[1] = ID;
        //argumentos[2] = Regi;
        //argumentos[3] = "1";
        //argumentos[4]= BPS;
        //argumentos[5]= BDD;
        //argumentos[6]= PAR;
        //argumentos[7]= BDP;
        //argumentos[8]= COD;
        //argumentos[9]= ECH;
        //argumentos[10]= REI;
        serialParameters.setCommPortId(Args[0]);
        if (Args[6].equals("None")){
           serialParameters.setParity(0); 
        }
        if (Args[6].equals("Even")){
           serialParameters.setParity(1); 
        }
        if (Args[6].equals("Odd")){
           serialParameters.setParity(2); 
        }
        if (Args[6].equals("Mark")){
           serialParameters.setParity(3); 
        }
        if (Args[6].equals("Space")){
           serialParameters.setParity(4); 
        }
        serialParameters.setDataBits(Integer.parseInt(Args[5]));
        serialParameters.setStopBits(Integer.parseInt(Args[7]));
        serialParameters.setPortOwnerName("PuertoSer");
        serialParameters.setBaudRate(Integer.parseInt(Args[4]));
        ModbusFactory modbusFactory = new ModbusFactory();
        ModbusMaster master = modbusFactory.createAsciiMaster(serialParameters, 1);
        try {
            master.init();
            //readDiscreteInputTest(master,5,0,8);
            //writeRegistersTest(master,5, 0, new short[]{0x31,0xb,0xc,0xd,0xe,0x9, 0x8, 0x7, 0x6} );
            try {
                ReadHoldingRegistersRequest request = new ReadHoldingRegistersRequest(Integer.parseInt(Args[1]), Integer.parseInt(Args[2]), Integer.parseInt(Args[3]));
                ReadHoldingRegistersResponse response = (ReadHoldingRegistersResponse) master.send(request);
                if (response.isException()) {
                    Valor = "Exception response: message=" + response.getExceptionMessage();
                } else {
                    Valor = Arrays.toString(response.getShortData());
                }
            } catch (ModbusTransportException e) {
                Valor = e.toString();
            }
        } catch (ModbusInitException ex) {
            Valor = ex.toString();
        } finally {
            master.destroy();
        }
        return Valor;
    };

    
    

        
           public String LeoRegistroSerialRTU(String [] Args) {
      String Valor = "";
        SerialParameters serialParameters = new SerialParameters();

        //argumentos[0] = PRTSER;
        //argumentos[1] = ID;
        //argumentos[2] = Regi;
        //argumentos[3] = "1";
        //argumentos[4]= BPS;
        //argumentos[5]= BDD;
        //argumentos[6]= PAR;
        //argumentos[7]= BDP;
        //argumentos[8]= COD;
        //argumentos[9]= ECH;
        //argumentos[10]= REI;
        serialParameters.setCommPortId(Args[0]);
        if (Args[6].equals("None")){
           serialParameters.setParity(0); 
        }
        if (Args[6].equals("Even")){
           serialParameters.setParity(1); 
        }
        if (Args[6].equals("Odd")){
           serialParameters.setParity(2); 
        }
        if (Args[6].equals("Mark")){
           serialParameters.setParity(3); 
        }
        if (Args[6].equals("Space")){
           serialParameters.setParity(4); 
        }
        serialParameters.setDataBits(Integer.parseInt(Args[5]));
        serialParameters.setStopBits(Integer.parseInt(Args[7]));
        serialParameters.setPortOwnerName("PuertoSer");
        serialParameters.setBaudRate(Integer.parseInt(Args[4]));
        ModbusFactory modbusFactory = new ModbusFactory();
        ModbusMaster master = modbusFactory.createRtuMaster(serialParameters, 1);
        try {
            master.init();
            //readDiscreteInputTest(master,5,0,8);
            //writeRegistersTest(master,5, 0, new short[]{0x31,0xb,0xc,0xd,0xe,0x9, 0x8, 0x7, 0x6} );
            try {
                ReadHoldingRegistersRequest request = new ReadHoldingRegistersRequest(Integer.parseInt(Args[1]), Integer.parseInt(Args[2]), Integer.parseInt(Args[3]));
                ReadHoldingRegistersResponse response = (ReadHoldingRegistersResponse) master.send(request);
                if (response.isException()) {
                    Valor = "Exception response: message=" + response.getExceptionMessage();
                } else {
                    Valor = Arrays.toString(response.getShortData());
                }
            } catch (ModbusTransportException e) {
                Valor = e.toString();
            }
        } catch (ModbusInitException ex) {
            Valor = ex.toString();
        } finally {
            master.destroy();
        }
        return Valor;
    };

    
    

       
           public String LeoDiscreteInputSerialASCII(String [] Args) {
      String Valor = "";
        SerialParameters serialParameters = new SerialParameters();

        //argumentos[0] = PRTSER;
        //argumentos[1] = ID;
        //argumentos[2] = Regi;
        //argumentos[3] = "1";
        //argumentos[4]= BPS;
        //argumentos[5]= BDD;
        //argumentos[6]= PAR;
        //argumentos[7]= BDP;
        //argumentos[8]= COD;
        //argumentos[9]= ECH;
        //argumentos[10]= REI;
        serialParameters.setCommPortId(Args[0]);
        if (Args[6].equals("None")){
           serialParameters.setParity(0); 
        }
        if (Args[6].equals("Even")){
           serialParameters.setParity(1); 
        }
        if (Args[6].equals("Odd")){
           serialParameters.setParity(2); 
        }
        if (Args[6].equals("Mark")){
           serialParameters.setParity(3); 
        }
        if (Args[6].equals("Space")){
           serialParameters.setParity(4); 
        }
        serialParameters.setDataBits(Integer.parseInt(Args[5]));
        serialParameters.setStopBits(Integer.parseInt(Args[7]));
        serialParameters.setPortOwnerName("PuertoSer");
        serialParameters.setBaudRate(Integer.parseInt(Args[4]));
        ModbusFactory modbusFactory = new ModbusFactory();
        ModbusMaster master = modbusFactory.createAsciiMaster(serialParameters, 1);             
            
        try {
            
            master.init();
            //readDiscreteInputTest(master,5,0,8);
            //writeRegistersTest(master,5, 0, new short[]{0x31,0xb,0xc,0xd,0xe,0x9, 0x8, 0x7, 0x6} );
            try {
                ReadDiscreteInputsRequest request = new ReadDiscreteInputsRequest(Integer.parseInt(Args[1]), Integer.parseInt(Args[2]), Integer.parseInt(Args[3]));

                ReadDiscreteInputsResponse response = (ReadDiscreteInputsResponse) master.send(request);
                if (response.isException()) {
                    Valor = "Exception response: message=" + response.getExceptionMessage();
                } else {
                    Valor = Arrays.toString(response.getBooleanData());
                }
            } catch (ModbusTransportException e) {
                Valor = e.toString();
            }
        } catch (ModbusInitException ex) {
            Valor = ex.toString();
        } finally {
            master.destroy();
        }
        return Valor;
    };

    
    

           public String EscriboRegistroSerialASCII(String [] Args) {
      String Valor = "";
        SerialParameters serialParameters = new SerialParameters();

        //argumentos[0] = PRTSER;
        //argumentos[1] = ID;
        //argumentos[2] = Regi;
        //argumentos[3] = "1";
        //argumentos[4]= BPS;
        //argumentos[5]= BDD;
        //argumentos[6]= PAR;
        //argumentos[7]= BDP;
        //argumentos[8]= COD;
        //argumentos[9]= ECH;
        //argumentos[10]= REI;
        serialParameters.setCommPortId(Args[0]);
        if (Args[6].equals("None")){
           serialParameters.setParity(0); 
        }
        if (Args[6].equals("Even")){
           serialParameters.setParity(1); 
        }
        if (Args[6].equals("Odd")){
           serialParameters.setParity(2); 
        }
        if (Args[6].equals("Mark")){
           serialParameters.setParity(3); 
        }
        if (Args[6].equals("Space")){
           serialParameters.setParity(4); 
        }
        serialParameters.setDataBits(Integer.parseInt(Args[5]));
        serialParameters.setStopBits(Integer.parseInt(Args[7]));
        serialParameters.setPortOwnerName("PuertoSer");
        serialParameters.setBaudRate(Integer.parseInt(Args[4]));
        ModbusFactory modbusFactory = new ModbusFactory();
        ModbusMaster master = modbusFactory.createAsciiMaster(serialParameters, 1);
        try {
            master.init();
            //readDiscreteInputTest(master,5,0,8);
            //writeRegistersTest(master,5, 0, new short[]{0x31,0xb,0xc,0xd,0xe,0x9, 0x8, 0x7, 0x6} );
            try {
                WriteRegisterRequest request = new WriteRegisterRequest(Integer.parseInt(Args[1]), Integer.parseInt(Args[2]), Integer.parseInt(Args[3]));
                WriteRegisterResponse response = (WriteRegisterResponse) master.send(request);
                if (response.isException()) {
                    Valor = "Exception response: message=" + response.getExceptionMessage();
                } else {
                    Valor = "OK";
                }
            } catch (ModbusTransportException e) {
                Valor = e.toString();
            }
        } catch (ModbusInitException ex) {
            Valor = ex.toString();
        } finally {
            master.destroy();
        }
        return Valor;
    };
            public String LeoDiscreteInputSerialRTU(String [] Args) {
      String Valor = "";
        SerialParameters serialParameters = new SerialParameters();

        //argumentos[0] = PRTSER;
        //argumentos[1] = ID;
        //argumentos[2] = Regi;
        //argumentos[3] = "1";
        //argumentos[4]= BPS;
        //argumentos[5]= BDD;
        //argumentos[6]= PAR;
        //argumentos[7]= BDP;
        //argumentos[8]= COD;
        //argumentos[9]= ECH;
        //argumentos[10]= REI;
        serialParameters.setCommPortId(Args[0]);
        if (Args[6].equals("None")){
           serialParameters.setParity(0); 
        }
        if (Args[6].equals("Even")){
           serialParameters.setParity(1); 
        }
        if (Args[6].equals("Odd")){
           serialParameters.setParity(2); 
        }
        if (Args[6].equals("Mark")){
           serialParameters.setParity(3); 
        }
        if (Args[6].equals("Space")){
           serialParameters.setParity(4); 
        }
        serialParameters.setDataBits(Integer.parseInt(Args[5]));
        serialParameters.setStopBits(Integer.parseInt(Args[7]));
        serialParameters.setPortOwnerName("PuertoSer");
        serialParameters.setBaudRate(Integer.parseInt(Args[4]));
        ModbusFactory modbusFactory = new ModbusFactory();
        ModbusMaster master = modbusFactory.createRtuMaster(serialParameters, 1);
    
        try {
            
            master.init();
            //readDiscreteInputTest(master,5,0,8);
            //writeRegistersTest(master,5, 0, new short[]{0x31,0xb,0xc,0xd,0xe,0x9, 0x8, 0x7, 0x6} );
            try {
                ReadDiscreteInputsRequest request = new ReadDiscreteInputsRequest(Integer.parseInt(Args[1]), Integer.parseInt(Args[2]), Integer.parseInt(Args[3]));

                ReadDiscreteInputsResponse response = (ReadDiscreteInputsResponse) master.send(request);
                if (response.isException()) {
                    Valor = "Exception response: message=" + response.getExceptionMessage();
                } else {
                    Valor = Arrays.toString(response.getBooleanData());
                }
            } catch (ModbusTransportException e) {
                Valor = e.toString();
            }
        } catch (ModbusInitException ex) {
            Valor = ex.toString();
        } finally {
            master.destroy();
        }
        return Valor;
    };

    
    

        
           public String EscriboRegistroSerialRTU(String [] Args) {
      String Valor = "";
        SerialParameters serialParameters = new SerialParameters();

        //argumentos[0] = PRTSER;
        //argumentos[1] = ID;
        //argumentos[2] = Regi;
        //argumentos[3] = "1";
        //argumentos[4]= BPS;
        //argumentos[5]= BDD;
        //argumentos[6]= PAR;
        //argumentos[7]= BDP;
        //argumentos[8]= COD;
        //argumentos[9]= ECH;
        //argumentos[10]= REI;
        serialParameters.setCommPortId(Args[0]);
        if (Args[6].equals("None")){
           serialParameters.setParity(0); 
        }
        if (Args[6].equals("Even")){
           serialParameters.setParity(1); 
        }
        if (Args[6].equals("Odd")){
           serialParameters.setParity(2); 
        }
        if (Args[6].equals("Mark")){
           serialParameters.setParity(3); 
        }
        if (Args[6].equals("Space")){
           serialParameters.setParity(4); 
        }
        serialParameters.setDataBits(Integer.parseInt(Args[5]));
        serialParameters.setStopBits(Integer.parseInt(Args[7]));
        serialParameters.setPortOwnerName("PuertoSer");
        serialParameters.setBaudRate(Integer.parseInt(Args[4]));
        ModbusFactory modbusFactory = new ModbusFactory();
        ModbusMaster master = modbusFactory.createRtuMaster(serialParameters, 1);
       try {
            master.init();
            //readDiscreteInputTest(master,5,0,8);
            //writeRegistersTest(master,5, 0, new short[]{0x31,0xb,0xc,0xd,0xe,0x9, 0x8, 0x7, 0x6} );
            try {
                WriteRegisterRequest request = new WriteRegisterRequest(Integer.parseInt(Args[1]), Integer.parseInt(Args[2]), Integer.parseInt(Args[3]));
                WriteRegisterResponse response = (WriteRegisterResponse) master.send(request);
                if (response.isException()) {
                    Valor = "Exception response: message=" + response.getExceptionMessage();
                } else {
                    Valor = "OK";
                }
            } catch (ModbusTransportException e) {
                Valor = e.toString();
            }
        } catch (ModbusInitException ex) {
            Valor = ex.toString();
        } finally {
            master.destroy();
        }
        return Valor;
    };

}
