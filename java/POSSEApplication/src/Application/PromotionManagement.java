
package Application;

import DataAccess.PromotionDA;
import entities.Promotion;
import java.sql.SQLException;
import java.util.ArrayList;


public class PromotionManagement {
    
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
        
        PromotionDA promotionDA = new PromotionDA();
        
        ArrayList<Promotion> promotions = promotionDA.findAll();
        
        for (Promotion promotion : promotions) {
            
            System.out.println(promotion.getName());
        }
        
    }
}
