
package Application;

import DataAccess.PurchaseDA;
import entities.Purchase;
import java.sql.SQLException;
import java.util.ArrayList;

public class PurchaseManagement {
    
    
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
        
        PurchaseDA purchaseDA = new PurchaseDA();
        
        ArrayList<Purchase> purchases = purchaseDA.findAll();
        
        for (Purchase purchase : purchases) {
            
            System.out.println(purchase.getId());
        }
        
        
        
    }
}
