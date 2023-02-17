
package Application;

import DataAccess.TransactionDA;
import entities.Transaction;
import java.sql.SQLException;
import java.util.ArrayList;

public class TransactionManagement {
    
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
        
        TransactionDA transactionDA = new TransactionDA();
        
        ArrayList<Transaction> transactions = transactionDA.findAll();
        
        for (Transaction transaction : transactions) {
            
            System.out.println(transaction.getId());
        }
    }
    
}
