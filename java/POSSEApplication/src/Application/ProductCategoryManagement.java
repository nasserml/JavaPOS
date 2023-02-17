
package Application;

import DataAccess.ProductCategoryDA;
import entities.ProductCategory;
import java.sql.SQLException;
import java.util.ArrayList;


public class ProductCategoryManagement {
    
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
        
        ProductCategoryDA productCategoryDA = new ProductCategoryDA();
        
        ArrayList<ProductCategory> productCategories = productCategoryDA.findAll();
        
        for (ProductCategory productCategory : productCategories) {
            
            System.out.println(productCategory.getName());
        }
        
    }
    
}
