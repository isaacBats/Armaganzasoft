package armaganzasoft.models;



/**
 * @author Isaac Daniel
 */
public class Order {
    
    private int id;
    private int costumerId;
    private int branchId;
    private String date;
    float quantity;
    int measurementUnit;
    float total;

    public Order() {    }
    
    public Order(int id, int costumerId, int branchId, String date, float quantity, int measurementUnit, float total) {
        this.id = id;
        this.costumerId = costumerId;
        this.branchId = branchId;
        this.date = date;
        this.quantity = quantity;
        this.measurementUnit = measurementUnit;
        this.total = total;
    }

    public Order(int costumerId, int branchId, float quantity, int measurementUnit, float total) {
        this.costumerId = costumerId;
        this.branchId = branchId;
        this.quantity = quantity;
        this.measurementUnit = measurementUnit;
        this.total = total;
    }

    
    
    public Order(int costumerId, int branchId, String date, float quantity, int measurementUnit, float total) {
        this.costumerId = costumerId;
        this.branchId = branchId;
        this.date = date;
        this.quantity = quantity;
        this.measurementUnit = measurementUnit;
        this.total = total;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCostumerId() {
        return costumerId;
    }

    public void setCostumerId(int costumerId) {
        this.costumerId = costumerId;
    }

    public int getBranchId() {
        return branchId;
    }

    public void setBranchId(int branchId) {
        this.branchId = branchId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public float getQuantity() {
        return quantity;
    }

    public void setQuantity(float quantity) {
        this.quantity = quantity;
    }

    public int getMeasurementUnit() {
        return measurementUnit;
    }

    public void setMeasurementUnit(int measurementUnit) {
        this.measurementUnit = measurementUnit;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "Order{" + "costumerId=" + costumerId + ", branchId=" + branchId + ", date=" + date + ", quantity=" + quantity + ", measurementUnit=" + measurementUnit + ", total=" + total + '}';
    }
    
    
      
}
