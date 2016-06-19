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
public class Partitions {
    private int id;
    private int detailOrderId;
    private String contact;
    private String mobil;
    private String address;
    private String value;

    public Partitions() {
    }

    public Partitions(int detailOrderId, String contact, String mobil, String address, String value) {
        this.detailOrderId = detailOrderId;
        this.contact = contact;
        this.mobil = mobil;
        this.address = address;
        this.value = value;
    }

    public Partitions(int id, int detailOrderId, String contact, String mobil, String address, String value) {
        this.id = id;
        this.detailOrderId = detailOrderId;
        this.contact = contact;
        this.mobil = mobil;
        this.address = address;
        this.value = value;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDetailOrderId() {
        return detailOrderId;
    }

    public void setDetailOrderId(int detailOrderId) {
        this.detailOrderId = detailOrderId;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getMobil() {
        return mobil;
    }

    public void setMobil(String mobil) {
        this.mobil = mobil;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
    
    
}
