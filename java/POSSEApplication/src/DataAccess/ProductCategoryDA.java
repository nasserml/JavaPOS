
package DataAccess;

import entities.ProductCategory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class ProductCategoryDA  implements BaseDA<ProductCategory>{
    
    private int id;
    private String name;
    
    private String dateCreated;
    
    private String productCategoryName = "`product category`";
    
    
    
    @Override
    public ArrayList<ProductCategory> findAll() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
        
        ArrayList<ProductCategory> productCategories = new ArrayList<>();
        
        Connection connection = ConnectionManager.getConection();
        
        Statement statement = connection.createStatement();
        
        ResultSet resultSet = statement.executeQuery("select * from " + productCategoryName);
        
        ProductCategory productCategory;
        
        while( resultSet.next() ) {
            
            productCategory = new ProductCategory();
            
            id = resultSet.getInt(1);
            name = resultSet.getString(2);
            
            dateCreated = resultSet.getString(3);
            
            productCategory.setId(id);
            productCategory.setName(name);
            
            productCategory.setDateCreated(dateCreated);
            
            productCategories.add(productCategory);
        }
        
        return productCategories;
        
        
        
    }

    @Override
    public ProductCategory findById(int id) throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
        
        
        Connection connection = ConnectionManager.getConection();

        Statement statement = connection.createStatement();

        ResultSet resultSet = statement.executeQuery("SELECT * from " + productCategoryName + " WHERE id =" + id);

        resultSet.next();

        ProductCategory productCategory = new ProductCategory();

        
        
        this.id = resultSet.getInt(1);
        name = resultSet.getString(2);
            
        dateCreated = resultSet.getString(3);
            
        productCategory.setId(this.id);
        productCategory.setName(name);
            
        productCategory.setDateCreated(dateCreated);

        
        return productCategory;
    }
    
    
    

    @Override
    public boolean save(ProductCategory productCategory) throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
        
        Connection connection = ConnectionManager.getConection();

        PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO " + productCategoryName 
                + " VALUES ( ? , ? , ? )");

        preparedStatement.setInt(1, productCategory.getId());
        preparedStatement.setString(2, productCategory.getName());

        preparedStatement.setString(3, productCategory.getDateCreated());
        

        int resultInt = preparedStatement.executeUpdate();

        boolean result = false;

        if (resultInt == 1) {
            result = true;
        }

        System.out.println(productCategoryName + " inserted|saved ? " + result);

        return result;
        
    }

    
    
    @Override
    public boolean update(ProductCategory productCategory) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
        
        Connection connection = ConnectionManager.getConection();

        PreparedStatement preparedStatement = connection.prepareStatement("update " + productCategoryName
                + " set name = ? , datecreated =  ? "
                
                + " where id =" + productCategory.getId());
        
        

        preparedStatement.setString(1, productCategory.getName());
        preparedStatement.setString(2, productCategory.getDateCreated());

        

        int resultInt = preparedStatement.executeUpdate();

        boolean result = false;

        if (resultInt == 1) {
            result = true;
        }

        System.out.println( productCategoryName + " updateded ? " + result);

        return result;
        
    }

    @Override
    public boolean delete(int id) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
        
        Connection connection = ConnectionManager.getConection();

        PreparedStatement preparedStatement = connection.prepareStatement("delete from " 
                + productCategoryName +" where id =  " + id);

        int resultInt = preparedStatement.executeUpdate();

        boolean result = false;

        if (resultInt == 1) {
            result = true;
        }

        System.out.println(productCategoryName + " deleted ? " + result);

        return result;
    
    }
    
}
