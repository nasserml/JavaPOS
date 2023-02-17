
package DataAccess;

import com.mysql.cj.protocol.Resultset;
import entities.Purchase;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class PurchaseDA implements BaseDA<Purchase>{
    
    private int id;
    private int cashierId;
    
    private String date;
    private String time;
    
    private String productBarcode;
    private String quantity;
    
    private String totalAmount;
    
    @Override
    public ArrayList<Purchase> findAll() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException{
        
        ArrayList<Purchase> purchases = new ArrayList<>();
        
        Connection connection = ConnectionManager.getConection();
        
        Statement statement = connection.createStatement();
        
        ResultSet resultSet = statement.executeQuery("select * from purchase");
        
        Purchase purchase;
        
        while(resultSet.next()){
            
            purchase = new Purchase();
            
            id = resultSet.getInt(1);
            cashierId = resultSet.getInt(2);
            
            date = resultSet.getString(3);
            time = resultSet.getString(4);
            
            productBarcode = resultSet.getString(5);
            quantity = resultSet.getString(6);
            
            totalAmount = resultSet.getString(7);
            
            purchase.setId(id);
            purchase.setCashierId(cashierId);
            
            purchase.setDate(date);
            purchase.setTime(time);
            
            purchase.setProductBarcode(productBarcode);
            purchase.setQuantity(quantity);
            
            purchase.setTotalAmount(totalAmount);
            
            purchases.add(purchase);
            
            
            
        }
        
        return purchases;
        
        
    }

    @Override
    public Purchase findById(int id) throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
        
         Connection connection = ConnectionManager.getConection();

        Statement statement = connection.createStatement();

        ResultSet resultSet = statement.executeQuery("SELECT * from purchase WHERE id =" + id);

        resultSet.next();

        Purchase purchase = new Purchase();
            
        id = resultSet.getInt(1);
        cashierId = resultSet.getInt(2);
            
        date = resultSet.getString(3);
        time = resultSet.getString(4);
            
        productBarcode = resultSet.getString(5);
        quantity = resultSet.getString(6);
            
        totalAmount = resultSet.getString(7);
            
        purchase.setId(id);
        purchase.setCashierId(cashierId);
            
        purchase.setDate(date);
        purchase.setTime(time);
            
        purchase.setProductBarcode(productBarcode);
        purchase.setQuantity(quantity);
            
        purchase.setTotalAmount(totalAmount);

        return purchase;
    }

    @Override
    public boolean save(Purchase purchase) throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
        
        Connection connection = ConnectionManager.getConection();

        PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO purchase "
                + "VALUES (? , ? , ? , ? , ? , ? , ?)");

        preparedStatement.setInt(1, purchase.getId());
        preparedStatement.setInt(2, purchase.getCashierId());

        preparedStatement.setString(3, purchase.getDate());
        preparedStatement.setString(4, purchase.getTime());

        preparedStatement.setString(5, purchase.getProductBarcode());
        preparedStatement.setString(6, purchase.getQuantity());

        preparedStatement.setString(7, purchase.getTotalAmount());

        int resultInt = preparedStatement.executeUpdate();

        boolean result = false;

        if (resultInt == 1) {
            result = true;
        }

        System.out.println("purchase inserted|saved ? " + result);

        return result;
        
    }

    @Override
    public boolean update(Purchase purchase) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
        
        Connection connection = ConnectionManager.getConection();

        String productBarcodeString = "`product barcode`";;
        
        PreparedStatement preparedStatement = connection.prepareStatement("update purchase "
                + "set cashierid = ? , date =  ? ,"
                
                + "time = ? , "+ productBarcodeString +" = ? ,"
                
                + "quantity = ? , totalamount = ? "
                
                + " where id =" + purchase.getId());
        
        

        preparedStatement.setInt(1, purchase.getCashierId());
        preparedStatement.setString(2, purchase.getDate());

        preparedStatement.setString(3, purchase.getTime());
        preparedStatement.setString(4, purchase.getProductBarcode());

        preparedStatement.setString(5, purchase.getQuantity());
        preparedStatement.setString(6, purchase.getTotalAmount());

        int resultInt = preparedStatement.executeUpdate();

        boolean result = false;

        if (resultInt == 1) {
            result = true;
        }

        System.out.println("purchase updateded ? " + result);

        return result;
    }

    @Override
    public boolean delete(int id) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
        
        
        Connection connection = ConnectionManager.getConection();

        PreparedStatement preparedStatement = connection.prepareStatement("delete from purchase where id =  " + id);

        int resultInt = preparedStatement.executeUpdate();

        boolean result = false;

        if (resultInt == 1) {
            result = true;
        }

        System.out.println("purchase deleted ? " + result);

        return result;
    }
    
}
