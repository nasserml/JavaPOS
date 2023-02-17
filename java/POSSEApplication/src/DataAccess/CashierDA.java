
package DataAccess;

import entities.Cashier;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class CashierDA implements BaseDA<Cashier>{
    
    private int id;
    private String name;
    
    private int age;
    private String gender;
    
    private String address;
    private String phone;
    
    private String email;
    private String password;
    
    private String dateCreated;
    
    @Override
    public ArrayList<Cashier> findAll() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
        
        ArrayList<Cashier> cashiers = new ArrayList<>();
        
        Connection connection = ConnectionManager.getConection();
        
        Statement statement = connection.createStatement();
        
        ResultSet resultSet = statement.executeQuery("select * from cashier");
        
        Cashier cashier;
        
        while(resultSet.next()){
            
            cashier = new Cashier();
            
            id = resultSet.getInt(1);
            name = resultSet.getString(2);
            
            age = resultSet.getInt(3);
            gender = resultSet.getString(4);
            
            address = resultSet.getString(5);
            phone = resultSet.getString(6);
            
            email = resultSet.getString(7);
            password = resultSet.getString(8);
            
            dateCreated = resultSet.getString(9);
            
            cashier.setId(id);
            cashier.setName(name);
            
            cashier.setAge(age);
            cashier.setGender(gender);
            
            cashier.setAddress(address);
            cashier.setPhone(phone);
            
            cashier.setEmail(email);
            cashier.setPassword(password);
            
            cashier.setDateCreated(dateCreated);
            
            cashiers.add(cashier);
        }
        
        return cashiers;
        
        
    }
    
    

    @Override
    public Cashier findById(int id) throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
        
        Connection connection = ConnectionManager.getConection();

        Statement statement = connection.createStatement();

        ResultSet resultSet = statement.executeQuery("SELECT * from cashier WHERE id =" + id);

        resultSet.next();

        Cashier cashier = new Cashier();

        
        
        this.id = resultSet.getInt(1);
        name = resultSet.getString(2);
            
        age = resultSet.getInt(3);
        gender = resultSet.getString(4);
            
        address = resultSet.getString(5);
        phone = resultSet.getString(6);
            
        email = resultSet.getString(7);
        password = resultSet.getString(8);
            
        dateCreated = resultSet.getString(9);
            
        cashier.setId(this.id);
        cashier.setName(name);
            
        cashier.setAge(age);
        cashier.setGender(gender);
            
        cashier.setAddress(address);
        cashier.setPhone(phone);
            
        cashier.setEmail(email);
        cashier.setPassword(password);
            
        cashier.setDateCreated(dateCreated);

        
        return cashier;
        
    }

    
    
    
    
    @Override
    public boolean save(Cashier cashier) throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
        
        Connection connection = ConnectionManager.getConection();

        PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO cashier "
                + "VALUES (? , ? , ? , ? , ? , ? , ?, ?, ?)");

        preparedStatement.setInt(1, cashier.getId());
        preparedStatement.setString(2, cashier.getName());

        preparedStatement.setInt(3, cashier.getAge());
        preparedStatement.setString(4, cashier.getGender());

        preparedStatement.setString(5, cashier.getAddress());
        preparedStatement.setString(6, cashier.getPhone());

        preparedStatement.setString(7, cashier.getEmail());
        preparedStatement.setString(8, cashier.getPassword());
        
        preparedStatement.setString(9, cashier.getDateCreated());

        int resultInt = preparedStatement.executeUpdate();

        boolean result = false;

        if (resultInt == 1) {
            result = true;
        }

        System.out.println("Cashier inserted|saved ? " + result);

        return result;
        
    }

    
    
    @Override
    public boolean update(Cashier cashier) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
        
        Connection connection = ConnectionManager.getConection();

        PreparedStatement preparedStatement = connection.prepareStatement("update cashier "
                + "set name = ? , age =  ? ,"
                
                + "gender = ? , address = ? ,"
                
                + "phone = ? , email = ?, "
                
                + "password = ? , datecreated = ? "
                
                + " where id =" + cashier.getId());
        
        

        preparedStatement.setString(1, cashier.getName());
        preparedStatement.setInt(2, cashier.getAge());

        preparedStatement.setString(3, cashier.getGender());
        preparedStatement.setString(4, cashier.getAddress());

        preparedStatement.setString(5, cashier.getPhone());
        preparedStatement.setString(6, cashier.getEmail());
        
        preparedStatement.setString(7, cashier.getPassword());
        preparedStatement.setString(8, cashier.getDateCreated());

        int resultInt = preparedStatement.executeUpdate();

        boolean result = false;

        if (resultInt == 1) {
            result = true;
        }

        System.out.println("Cashier updateded ? " + result);

        return result;
        
    }

    
    
    @Override
    public boolean delete(int id) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {

        Connection connection = ConnectionManager.getConection();

        PreparedStatement preparedStatement = connection.prepareStatement("delete from cashier where id =  " + id);

        int resultInt = preparedStatement.executeUpdate();

        boolean result = false;

        if (resultInt == 1) {
            result = true;
        }

        System.out.println("Cashier deleted ? " + result);

        return result;


    }
    
}
