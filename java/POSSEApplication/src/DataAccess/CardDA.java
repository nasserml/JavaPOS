
package DataAccess;

import entities.Card;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class CardDA implements BaseDA<Card>{
    
    private String cardNumber;
    private String customerId;
    
    private String amount;
    private int pin;
    
    private String registerDate;
    private String lastDateUsed;
    
    private String expiredDate;
    
    @Override
    public ArrayList<Card> findAll() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException{
        
        ArrayList<Card> cards = new ArrayList<>();
        
        Connection connection = ConnectionManager.getConection();
        
        Statement  statement = connection.createStatement();
        
        ResultSet resultSet = statement.executeQuery("select * from card");
        
        Card card;
        
        while (resultSet.next()) {
            
            card = new Card();
            
            cardNumber = resultSet.getString(1);
            customerId = resultSet.getString(2);
            
            amount = resultSet.getString(3);
            pin = resultSet.getInt(4);
            
            registerDate = resultSet.getString(5);
            lastDateUsed = resultSet.getString(6);
            
            expiredDate = resultSet.getString(7);
            
            card.setCardNumber(cardNumber);
            card.setCustomerId(customerId);
            
            card.setAmount(amount);
            card.setPin(pin);
            
            card.setRegisterDate(registerDate);
            card.setLastDateUsed(lastDateUsed);
            
            card.setExpiredDate(expiredDate);
            
            cards.add(card);
            
            
            
        }
        
        return cards;
    }
    
    
    
    
    

    @Override
    public Card findById(int customerId) throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
        
        
        Connection connection = ConnectionManager.getConection();

        Statement statement = connection.createStatement();

        ResultSet resultSet = statement.executeQuery("SELECT * from card WHERE customerid =" + customerId);

        resultSet.next();

        Card card = new Card();

        
        
        cardNumber = resultSet.getString(1);
        this.customerId = resultSet.getString(2);
        
        amount = resultSet.getString(3);
        pin = resultSet.getInt(4);
        
        registerDate = resultSet.getString(5);
        lastDateUsed = resultSet.getString(6);
            
        expiredDate = resultSet.getString(7);
            
        card.setCardNumber(cardNumber);
        card.setCustomerId(this.customerId);
            
        card.setAmount(amount);
        card.setPin(pin);
            
        card.setRegisterDate(registerDate);
        card.setLastDateUsed(lastDateUsed);
            
        card.setExpiredDate(expiredDate);

        
        return card;
    }
    
    
    
    

    @Override
    public boolean save(Card card) throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {

        Connection connection = ConnectionManager.getConection();

        PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO card "
                + "VALUES (? , ? , ? , ? , ? , ? , ?)");

        preparedStatement.setString(1, card.getCardNumber());
        preparedStatement.setString(2, card.getCustomerId());

        preparedStatement.setString(3, card.getAmount());
        preparedStatement.setInt(4, card.getPin());

        preparedStatement.setString(5, card.getRegisterDate());
        preparedStatement.setString(6, card.getLastDateUsed());

        preparedStatement.setString(7, card.getExpiredDate());

        int resultInt = preparedStatement.executeUpdate();

        boolean result = false;

        if (resultInt == 1) {
            result = true;
        }

        System.out.println("Card inserted|saved ? " + result);

        return result;

    }

    
    
    @Override
    public boolean update(Card card) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {

        Connection connection = ConnectionManager.getConection();

        PreparedStatement preparedStatement = connection.prepareStatement("update card "
                + "set cardnumber = ? , amount =  ? ,"
                
                + "pin = ? , registerdate = ? ,"
                
                + "lastdateused = ? , expireddate = ? "
                
                + " where id =" + card.getCustomerId());
        
        

        preparedStatement.setString(1, card.getCardNumber());
        preparedStatement.setString(2, card.getAmount());

        preparedStatement.setInt(3, card.getPin());
        preparedStatement.setString(4, card.getRegisterDate());

        preparedStatement.setString(5, card.getLastDateUsed());
        preparedStatement.setString(6, card.getExpiredDate());

        int resultInt = preparedStatement.executeUpdate();

        boolean result = false;

        if (resultInt == 1) {
            result = true;
        }

        System.out.println("Card updateded ? " + result);

        return result;
        
    }

    @Override
    public boolean delete(int customerId) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
        
        Connection connection = ConnectionManager.getConection();

        PreparedStatement preparedStatement = connection.prepareStatement("delete from card where customerid =  " + customerId);

        int resultInt = preparedStatement.executeUpdate();

        boolean result = false;

        if (resultInt == 1) {
            result = true;
        }

        System.out.println("Card deleted ? " + result);

        return result;

    }
} 
