/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccess;

import entities.ProductItems;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author nasser
 */
public class ProductItemsDA implements BaseDA<ProductItems>{
    
    private String barcode;
    private String name;
    
    private int categoryId;
    private String price;
    
    private String stockAmount;
    private int suppliedId;
    
    private String dateAdded;
    private String expireDate;
    
    private String count;
    
    
    private String productItemsName = "`product items`";
    
    
    @Override
    public ArrayList<ProductItems> findAll() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
       
        ArrayList<ProductItems> productItemses = new ArrayList<>();
        
        Connection connection = ConnectionManager.getConection();
        
        Statement statement = connection.createStatement();
        
        ResultSet resultSet = statement.executeQuery("select * from " + productItemsName);
        
        ProductItems productItems;
        
        while( resultSet.next()) {
            
            productItems = new ProductItems();
            
            barcode = resultSet.getString(1);
            name = resultSet.getString(2);
            
            categoryId = resultSet.getInt(3);
            price = resultSet.getString(4);
            
            stockAmount = resultSet.getString(5);
            suppliedId = resultSet.getInt(6);
            
            dateAdded = resultSet.getString(7);
            expireDate = resultSet.getString(8);
    
            count = resultSet.getString(9);
            
            productItems.setBarcode(barcode);
            productItems.setName(name);
            
            productItems.setCategoryId(categoryId);
            productItems.setPrice(price);
            
            productItems.setStockAmount(stockAmount);
            productItems.setSuppliedId(suppliedId);
            
            productItems.setDateAdded(dateAdded);
            productItems.setExpireDate(expireDate);
            
            productItems.setCount(count);
            
            productItemses.add(productItems);
            
        }
        
        return productItemses;
    }
    
    
    
    

    @Override
    public ProductItems findById(int barcode) throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
        
        Connection connection = ConnectionManager.getConection();

        Statement statement = connection.createStatement();

        ResultSet resultSet = statement.executeQuery("SELECT * from " + productItemsName + " WHERE barcode =" + barcode);

        resultSet.next();

        ProductItems productItems = new ProductItems();

        
        this.barcode = resultSet.getString(1);
        name = resultSet.getString(2);
            
        categoryId = resultSet.getInt(3);
        price = resultSet.getString(4);
            
        stockAmount = resultSet.getString(5);
        suppliedId = resultSet.getInt(6);
            
        dateAdded = resultSet.getString(7);
        expireDate = resultSet.getString(8);
    
        count = resultSet.getString(9);
            
        productItems.setBarcode(this.barcode);
        productItems.setName(name);
            
        productItems.setCategoryId(categoryId);
        productItems.setPrice(price);
            
        productItems.setStockAmount(stockAmount);
        productItems.setSuppliedId(suppliedId);
            
        productItems.setDateAdded(dateAdded);
        productItems.setExpireDate(expireDate);
            
        productItems.setCount(count);

        
        return productItems;
    }

    
    
    @Override
    public boolean save(ProductItems productItems) throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
        
        
        Connection connection = ConnectionManager.getConection();

        PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO " + productItemsName
                + " VALUES (? , ? , ? , ? , ? , ? , ?, ?, ?)");

        preparedStatement.setString(1, productItems.getBarcode());
        preparedStatement.setString(2, productItems.getName());

        preparedStatement.setInt(3, productItems.getCategoryId());
        preparedStatement.setString(4, productItems.getPrice());

        preparedStatement.setString(5, productItems.getStockAmount());
        preparedStatement.setInt(6, productItems.getSuppliedId());

        preparedStatement.setString(7, productItems.getDateAdded());
        preparedStatement.setString(8, productItems.getExpireDate());
        
        preparedStatement.setString(9, productItems.getCount());

        int resultInt = preparedStatement.executeUpdate();

        boolean result = false;

        if (resultInt == 1) {
            result = true;
        }

        System.out.println( productItemsName + " inserted|saved ? " + result);

        return result;
    }

    @Override
    public boolean update(ProductItems productItems) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
        
        Connection connection = ConnectionManager.getConection();

        PreparedStatement preparedStatement = connection.prepareStatement("update " + productItemsName
                + "set name = ? , categoryid =  ? ,"
                
                + "price = ? , stockamount = ? ,"
                
                + "suppliedid = ? , dateadded = ? ,"
                
                + "expireddate = ? , count = ? "
                
                + " where id =" + productItems.getBarcode());
        
        

        preparedStatement.setString(1, productItems.getName());
        preparedStatement.setInt(2, productItems.getCategoryId());

        preparedStatement.setString(3, productItems.getPrice());
        preparedStatement.setString(4, productItems.getStockAmount());

        preparedStatement.setInt(5, productItems.getSuppliedId());
        preparedStatement.setString(6, productItems.getDateAdded());
        
        preparedStatement.setString(7, productItems.getExpireDate());
        preparedStatement.setString(8, productItems.getCount());

        int resultInt = preparedStatement.executeUpdate();

        boolean result = false;

        if (resultInt == 1) {
            result = true;
        }

        System.out.println( productItemsName + " updateded ? " + result )  ;

        return result;
    }

    @Override
    public boolean delete(int barcode) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
        
        
        Connection connection = ConnectionManager.getConection();

        PreparedStatement preparedStatement = connection.prepareStatement("delete from "+  productItemsName + " where barcode =  " + barcode);

        int resultInt = preparedStatement.executeUpdate();

        boolean result = false;

        if (resultInt == 1) {
            result = true;
        }

        System.out.println( productItemsName + " deleted ? " + result );

        return result;
    }
    
}
