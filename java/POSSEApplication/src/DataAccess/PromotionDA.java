
package DataAccess;

import entities.Promotion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class PromotionDA implements BaseDA<Promotion>{
    
    private String id;
    private String name;
    
    private String productBarcode;
    private String percentage;
    
    private String description;
    
    @Override
    public ArrayList<Promotion> findAll() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
        
        ArrayList<Promotion> promotions = new ArrayList<>();
        
        Connection connection = ConnectionManager.getConection();
        
        Statement statement = connection.createStatement();
        
        ResultSet resultSet = statement.executeQuery("select * from promotion");
        
        Promotion promotion;
        
        while(resultSet.next()) {
            
            promotion = new Promotion();
            
            id = resultSet.getString(1);
            name = resultSet.getString(2);
            
            productBarcode = resultSet.getString(3);
            percentage = resultSet.getString(4);
            
            description = resultSet.getString(5);
            
            promotion.setId(id);
            promotion.setName(name);
            
            promotion.setProductBarcode(productBarcode);
            promotion.setPercentage(percentage);
            
            promotion.setDescription(description);
            
            promotions.add(promotion);
            
        }
        
        return promotions;
    }

    
    
    @Override
    public Promotion findById(int id) throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
     
        Connection connection = ConnectionManager.getConection();

        Statement statement = connection.createStatement();

        ResultSet resultSet = statement.executeQuery("SELECT * from promotion WHERE id =" + id);

        resultSet.next();

        Promotion promotion = new Promotion();

        
        
        this.id = resultSet.getString(1);
        name = resultSet.getString(2);
            
        productBarcode = resultSet.getString(3);
        percentage = resultSet.getString(4);
            
        description = resultSet.getString(5);
            
        promotion.setId(this.id);
        promotion.setName(name);
            
        promotion.setProductBarcode(productBarcode);
        promotion.setPercentage(percentage);
            
        promotion.setDescription(description);

        
        return promotion;
    }

    
    @Override
    public boolean save(Promotion promotion) throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
        
        Connection connection = ConnectionManager.getConection();

        PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO promotion "
                + "VALUES (? , ? , ? , ? , ? )");

        preparedStatement.setString(1, promotion.getId());
        preparedStatement.setString(2, promotion.getName());

        preparedStatement.setString(3, promotion.getProductBarcode());
        preparedStatement.setString(4, promotion.getPercentage());

        preparedStatement.setString(5, promotion.getPercentage());
        
        int resultInt = preparedStatement.executeUpdate();

        boolean result = false;

        if (resultInt == 1) {
            result = true;
        }

        System.out.println("promotion inserted|saved ? " + result);

        return result;
    }

    
    @Override
    public boolean update(Promotion promotion) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
        
        Connection connection = ConnectionManager.getConection();
        
        String productBarcodeString = "`product barcode`";
   

        PreparedStatement preparedStatement = connection.prepareStatement("update promotion "
                + "set name = ? ,"+ productBarcodeString + " =  ? ,"
                
                + "percentage = ? , description = ? "

                + " where id =" + promotion.getId());
        
        

        preparedStatement.setString(1, promotion.getName());
        preparedStatement.setString(2, promotion.getProductBarcode());

        preparedStatement.setString(3, promotion.getPercentage());
        preparedStatement.setString(4, promotion.getDescription());


        int resultInt = preparedStatement.executeUpdate();

        boolean result = false;

        if (resultInt == 1) {
            result = true;
        }

        System.out.println("Promotion updateded ? " + result);

        return result;
    }

    @Override
    public boolean delete(int id) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
        
        Connection connection = ConnectionManager.getConection();

        PreparedStatement preparedStatement = connection.prepareStatement("delete from promotion where id =  " + id);

        int resultInt = preparedStatement.executeUpdate();

        boolean result = false;

        if (resultInt == 1) {
            result = true;
        }

        System.out.println("promotion deleted ? " + result);

        return result;
    }
    
}
