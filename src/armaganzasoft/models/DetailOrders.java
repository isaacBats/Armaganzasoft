/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package armaganzasoft.models;

import java.util.Date;

/**
 *
 * @author Isaac Daniel < @codeisaac >
 */
public class DetailOrders {
    private int id;
    private int order_id;
    private int form_id;
    Date deadline;

    public DetailOrders() {
    
    }

    public DetailOrders(int order_id, int form_id, Date deadline) {
        this.order_id = order_id;
        this.form_id = form_id;
        this.deadline = deadline;
    }

    
    public DetailOrders(int id, int order_id, int form_id, Date deadline) {
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

    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }
    
    
    
    
    
}
