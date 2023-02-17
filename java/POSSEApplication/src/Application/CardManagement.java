
package Application;

import DataAccess.CardDA;
import entities.Card;
import java.sql.SQLException;
import java.util.ArrayList;

public class CardManagement {
    
    public static void main(String[] args) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        
        CardDA cardDA = new CardDA();
        
        ArrayList<Card> cards = cardDA.findAll();
        
        for (Card card : cards) {
            
            System.out.println(card.getCardNumber());
        }
        
        
    }
    
}
