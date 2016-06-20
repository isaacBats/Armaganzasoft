/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package armaganzasoft.models;


/**
 *
 * @author Isaac Daniel < @codeisaac >
 */
public class DetailOrders {
    private int id;
    private int order_id;
    private int form_id;
    private String deadline;

    public DetailOrders() {
    
    }

    public DetailOrders(int order_id, int form_id, String deadline) {
        this.order_id = order_id;
        this.form_id = form_id;
        this.deadline = deadline;
    }

    
    public DetailOrders(int id, int order_id, int form_id, String deadline) {
        this.id = id;
        this.order_id = order_id;
        this.form_id = form_id;
        this.deadline = deadline;
    }
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public int getForm_id() {
        return form_id;
    }

    public void setForm_id(int form_id) {
        this.form_id = form_id;
    }

    public String getDeadline() {
        return deadline;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }

    @Override
    public String toString() {
        return "DetailOrders{" + "order_id=" + order_id + ", form_id=" + form_id + ", deadline=" + deadline + '}';
    }
    
    
}
