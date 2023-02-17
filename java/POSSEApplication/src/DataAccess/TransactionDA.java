
package DataAccess;

import entities.Transaction;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class TransactionDA implements BaseDA<Transaction>{
    
    private String id;
    private int cashierId;
    
    private String cardId;
    private int purchaseId;
    
    private String amount;
    
    @Override
    public ArrayList<Transaction> findAll() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        
        ArrayList<Transaction> transactions = new ArrayList<>();
        
        Connection connection = ConnectionManager.getConection();
        
        Statement statement = connection.createStatement();
        
        ResultSet resultSet = statement.executeQuery("select * from transaction");
        
        Transaction transaction;
        
        while(resultSet.next()) {
            
            transaction = new Transaction();
            
            id = resultSet.getString(1);
            cashierId = resultSet.getInt(2);
            
            cardId = resultSet.getString(3);
            purchaseId = resultSet.getInt(4);
            
            amount = resultSet.getString(5);
            
            transaction.setId(id);
            transaction.setCashierId(cashierId);
            
            transaction.setCardId(cardId);
            transaction.setPurchaseId(purchaseId);
            
            transaction.setAmount(amount);
            
            transactions.add(transaction);
            
        }
        
        return transactions;
        
    }

    @Override
    public Transaction findById(int id) throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
       
        Connection connection = ConnectionManager.getConection();

        Statement statement = connection.createStatement();

        ResultSet resultSet = statement.executeQuery("SELECT * from transaction WHERE id =" + id);

        resultSet.next();

        Transaction transaction = new Transaction();
            
        this.id = resultSet.getString(1);
        cashierId = resultSet.getInt(2);
            
        cardId = resultSet.getString(3);
        purchaseId = resultSet.getInt(4);
            
        amount = resultSet.getString(5);
            
        transaction.setId(this.id);
        transaction.setCashierId(cashierId);
            
        transaction.setCardId(cardId);
        transaction.setPurchaseId(purchaseId);
            
        transaction.setAmount(amount);
        
        return transaction;

    }

    @Override
    public boolean save(Transaction transaction) throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
        
        Connection connection = ConnectionManager.getConection();

        PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO transaction "
                + "VALUES (? , ? , ? , ? , ?)");

        preparedStatement.setString(1, transaction.getId());
        preparedStatement.setInt(2, transaction.getCashierId());

        preparedStatement.setString(3, transaction.getCardId());
        preparedStatement.setInt(4, transaction.getPurchaseId());

        preparedStatement.setString(5, transaction.getAmount());


        int resultInt = preparedStatement.executeUpdate();

        boolean result = false;

        if (resultInt == 1) {
            result = true;
        }

        System.out.println("transaction inserted|saved ? " + result);

        return result;
    }

    @Override
    public boolean update(Transaction transaction) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
        
        
        Connection connection = ConnectionManager.getConection();

        PreparedStatement preparedStatement = connection.prepareStatement("update transaction "
                + "set cashierid = ? , cardid =  ? ,"
                
                + "purchaseid = ? , amount = ? "
                
                
                + " where id =" + transaction.getId());
        
        

        preparedStatement.setInt(1, transaction.getCashierId());
        preparedStatement.setString(2, transaction.getCardId());

        preparedStatement.setInt(3, transaction.getPurchaseId());
        preparedStatement.setString(4, transaction.getAmount());

        

        int resultInt = preparedStatement.executeUpdate();

        boolean result = false;

        if (resultInt == 1) {
            result = true;
        }

        System.out.println("transaction updateded ? " + result);

        return result;
    }

    @Override
    public boolean delete(int id) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
        
        Connection connection = ConnectionManager.getConection();

        PreparedStatement preparedStatement = connection.prepareStatement("delete from transaction where id =  " + id);

        int resultInt = preparedStatement.executeUpdate();

        boolean result = false;

        if (resultInt == 1) {
            result = true;
        }

        System.out.println("deleted ? " + result);

        return result;}
    
}
