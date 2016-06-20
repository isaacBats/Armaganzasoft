/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package armaganzasoft.models;

/**
 *
 * @author user
 */
public class Process {
     private int     id;
    private String  formula;
    private String  operacion;
    private String  des_operacion;
    private String  material1;
    private String  valor1;
    private String  tipop1;
        
   
    

public Process(){
      }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFormula() {
        return formula;
    }

    public void setFormula(String formula) {
        this.formula = formula;
    }

    public String getOperacion() {
        return operacion;
    }

    public void setOperacion(String operacion) {
        this.operacion = operacion;
    }

    public String getDes_operacion() {
        return des_operacion;
    }

    public void setDes_operacion(String des_operacion) {
        this.des_operacion = des_operacion;
    }

    public String getMaterial1() {
        return material1;
    }

    public void setMaterial1(String material1) {
        this.material1 = material1;
    }

    public String getValor1() {
        return valor1;
    }

    public void setValor1(String valor1) {
        this.valor1 = valor1;
    }

    public String getTipop1() {
        return tipop1;
    }

    public void setTipop1(String tipop1) {
        this.tipop1 = tipop1;
    }
 
}
