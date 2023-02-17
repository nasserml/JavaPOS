
package Application;

import DataAccess.CashierDA;
import entities.Cashier;
import java.sql.SQLException;
import java.util.ArrayList;


public class CashierManagement {
    
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
        
        CashierDA cashierDA = new CashierDA();
        
        ArrayList<Cashier> cashiers = cashierDA.findAll();
        
        for (Cashier cashier : cashiers) {
            
            System.out.println(cashier.getName());
        }
    }
    
}
