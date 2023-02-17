
package Application;

import DataAccess.SupplierDA;
import entities.Supplier;
import java.sql.SQLException;
import java.util.ArrayList;


public class SupplierManagement {
    
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
        
        SupplierDA supplierDA = new SupplierDA();
        
        ArrayList<Supplier> suppliers = supplierDA.findAll();
        
        for (Supplier supplier : suppliers) {
            
            System.out.println(supplier.getName());
        }
    }
    
}
