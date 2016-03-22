/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package armaganzasoft.services;

import net.wimpi.modbus.Modbus;
import net.wimpi.modbus.ModbusCoupler;
import net.wimpi.modbus.net.ModbusSerialListener;
import net.wimpi.modbus.procimg.SimpleDigitalIn;
import net.wimpi.modbus.procimg.SimpleDigitalOut;
import net.wimpi.modbus.procimg.SimpleInputRegister;
import net.wimpi.modbus.procimg.SimpleProcessImage;
import net.wimpi.modbus.procimg.SimpleRegister;
import net.wimpi.modbus.util.SerialParameters;

/**
 *
 * @author daniel
 */
public class SerialSlave {

  public static void main(String[] args) {

    ModbusSerialListener listener = null;
    SimpleProcessImage spi = new SimpleProcessImage();
    String portname = "Com1";

    if (Modbus.debug) System.out.println("jModbus Modbus Serial Slave");
   
    try {

      //1. Prepare a process image
      spi = new SimpleProcessImage();
      spi.addDigitalOut(new SimpleDigitalOut(true));
      spi.addDigitalOut(new SimpleDigitalOut(false));
      spi.addDigitalIn(new SimpleDigitalIn(false));
      spi.addDigitalIn(new SimpleDigitalIn(true));
      spi.addDigitalIn(new SimpleDigitalIn(false));
      spi.addDigitalIn(new SimpleDigitalIn(true));
      
      spi.addRegister(new SimpleRegister(251));
      spi.addRegister(new SimpleRegister(251));
      spi.addRegister(new SimpleRegister(251));
      spi.addRegister(new SimpleRegister(251));
      spi.addRegister(new SimpleRegister(251));
      spi.addRegister(new SimpleRegister(251));
      spi.addRegister(new SimpleRegister(251));
      spi.addRegister(new SimpleRegister(251));
      spi.addRegister(new SimpleRegister(251));      
      spi.addRegister(new SimpleRegister(251));
      spi.addRegister(new SimpleRegister(251));      
      
      spi.addInputRegister(new SimpleInputRegister(45));
      spi.addInputRegister(new SimpleInputRegister(45));
      spi.addInputRegister(new SimpleInputRegister(45));
      spi.addInputRegister(new SimpleInputRegister(45));
      spi.addInputRegister(new SimpleInputRegister(45));
      spi.addInputRegister(new SimpleInputRegister(45));
      spi.addInputRegister(new SimpleInputRegister(45));

      //2. Create the coupler and set the slave identity
      ModbusCoupler.getReference().setProcessImage(spi);
      ModbusCoupler.getReference().setMaster(false);
      ModbusCoupler.getReference().setUnitID(1);

      //3. Set up serial parameters
      SerialParameters params = new SerialParameters();
      params.setPortName(portname);
      params.setBaudRate(9600);
      params.setDatabits(8);
      params.setParity("None");
      params.setStopbits(1);
      params.setEncoding("bin");
      params.setEcho(false);
      if (Modbus.debug) System.out.println("Encoding [" + params.getEncoding() + "]");

      //4. Set up serial listener
      listener = new ModbusSerialListener(params);
      listener.setListening(true);

    } catch (Exception ex) {
      ex.printStackTrace();
    }
  }//main

}


