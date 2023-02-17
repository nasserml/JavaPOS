
package Application;

import DataAccess.ProductItemsDA;
import entities.ProductItems;
import java.sql.SQLException;
import java.util.ArrayList;


public class ProductItemsManagement {
    
    public static void main(String[] args) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        
        ProductItemsDA productItemsDA = new ProductItemsDA();
        
        ArrayList<ProductItems> productItemses = productItemsDA.findAll();
        
        for (ProductItems productItemse : productItemses) {
            
            System.out.println(productItemse.getName());
        }
        
    }
    
}
