
package DataAccess;

import entities.Customer;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class CustomerDA implements BaseDA<Customer>{
    
    private String id;
    private String name;
    
    private String age;
    private String gender;
    
    private String address;
    private String phone;
    
    private String email;
    
    
    @Override
    public ArrayList<Customer> findAll() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
        
        ArrayList<Customer> customers = new ArrayList<>();
        
        Connection connection = ConnectionManager.getConection();
        
        Statement statement = connection.createStatement();
        
        ResultSet resultSet = statement.executeQuery("select * from customer");
        
        Customer customer;
        
        while( resultSet.next() ) {
            
            customer = new Customer();
            
            id = resultSet.getString(1);
            name = resultSet.getString(2);
            
            age = resultSet.getString(3);
            gender = resultSet.getString(4);
            
            address = resultSet.getString(5);
            phone = resultSet.getString(6);
            
            email = resultSet.getString(7);
            
            customer.setId(id);
            customer.setName(name);
            
            customer.setAge(age);
            customer.setGender(gender);
            
            customer.setAddress(address);
            customer.setPhone(phone);
            
            customer.setEmail(email);
            
            customers.add(customer);
            
        }
         return customers;
        
    }

     @Override
    public Customer findById(int id) throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {

        Connection connection = ConnectionManager.getConection();

        Statement statement = connection.createStatement();

        ResultSet resultSet = statement.executeQuery("SELECT * from customer WHERE id =" + id);

        resultSet.next();

        Customer customer;

        customer = new Customer();

        
        
        this.id = resultSet.getString(1);
        name = resultSet.getString(2);
        
        age = resultSet.getString(3);
        gender = resultSet.getString(4);
        
        address = resultSet.getString(5);
        phone = resultSet.getString(6);
        
        email = resultSet.getString(7);
        
        

        customer.setId(this.id);
        customer.setName(name);
        
        customer.setAge(age);
        customer.setGender(gender);
        
        customer.setAddress(address);
        customer.setPhone(phone);
        
        customer.setEmail(email);

        
        return customer;

    }

    
    
    
    @Override
    public boolean save(Customer customer) throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {

        Connection connection = ConnectionManager.getConection();

        PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO customer "
                + "VALUES (? , ? , ? , ? , ? , ? , ?)");

        preparedStatement.setString(1, customer.getId());
        preparedStatement.setString(2, customer.getName());

        preparedStatement.setString(3, customer.getAge());
        preparedStatement.setString(4, customer.getGender());

        preparedStatement.setString(5, customer.getAddress());
        preparedStatement.setString(6, customer.getPhone());

        preparedStatement.setString(7, customer.getEmail());

        int resultInt = preparedStatement.executeUpdate();

        boolean result = false;

        if (resultInt == 1) {
            result = true;
        }

        System.out.println("Customer inserted|saved ? " + result);

        return result;

    }
    
    
    

    @Override
    public boolean update(Customer customer) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {

        Connection connection = ConnectionManager.getConection();

        PreparedStatement preparedStatement = connection.prepareStatement("update customer "
                + "set name = ? , age =  ? ,"
                
                + "gender = ? , address = ? ,"
                
                + "phone = ? , email = ? "
                
                + " where id =" + customer.getId());
        
        

        preparedStatement.setString(1, customer.getName());
        preparedStatement.setString(2, customer.getAge());

        preparedStatement.setString(3, customer.getGender());
        preparedStatement.setString(4, customer.getAddress());

        preparedStatement.setString(5, customer.getPhone());
        preparedStatement.setString(6, customer.getEmail());

        int resultInt = preparedStatement.executeUpdate();

        boolean result = false;

        if (resultInt == 1) {
            result = true;
        }

        System.out.println("Customer updateded ? " + result);

        return result;

    }

    
    
    
    @Override
    public boolean delete(int id) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {

        Connection connection = ConnectionManager.getConection();

        PreparedStatement preparedStatement = connection.prepareStatement("delete from customer where id =  " + id);

        int resultInt = preparedStatement.executeUpdate();

        boolean result = false;

        if (resultInt == 1) {
            result = true;
        }

        System.out.println("Customer deleted ? " + result);

        return result;

    }
    
}
