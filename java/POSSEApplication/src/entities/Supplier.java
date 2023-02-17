
package entities;


public class Supplier {
    
    private int id;
    private String name;
    private String lastDateSupplied;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastDateSupplied() {
        return lastDateSupplied;
    }

    public void setLastDateSupplied(String lastDateSupplied) {
        this.lastDateSupplied = lastDateSupplied;
    }
    
}
