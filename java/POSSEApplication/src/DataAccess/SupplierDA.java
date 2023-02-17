
package DataAccess;

import entities.Supplier;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class SupplierDA implements BaseDA<Supplier>{
    
    private int id;
    private String name;
    
    private String lastDateSupplied;
    
    @Override
    public ArrayList<Supplier> findAll() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException{
        
        ArrayList<Supplier> suppliers = new ArrayList<>();
        
        Connection connection = ConnectionManager.getConection();
        
        Statement statement = connection.createStatement();
        
        ResultSet resultSet = statement.executeQuery("select * from supplier");
        
        Supplier supplier;
        
        while(resultSet.next()) {
            
            supplier = new Supplier();
            
            id = resultSet.getInt(1);
            name = resultSet.getString(2);
            
            lastDateSupplied = resultSet.getString(3);
            
            supplier.setId(id);
            supplier.setName(name);
            
            supplier.setLastDateSupplied(lastDateSupplied);
            
            suppliers.add(supplier);
        }
        
        return suppliers;
        
    }

    @Override
    public Supplier findById(int id) throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
        Connection connection = ConnectionManager.getConection();

        Statement statement = connection.createStatement();

        ResultSet resultSet = statement.executeQuery("SELECT * from supplier WHERE id =" + id);

        resultSet.next();

         Supplier supplier;
        
            
        supplier = new Supplier();
            
        this.id = resultSet.getInt(1);
        name = resultSet.getString(2);
            
        lastDateSupplied = resultSet.getString(3);
            
        supplier.setId(this.id);
        supplier.setName(name);
            
        supplier.setLastDateSupplied(lastDateSupplied);

        
        return supplier;
        
    }

    @Override
    public boolean save(Supplier supplier) throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
       
        
        Connection connection = ConnectionManager.getConection();

        PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO supplier "
                + "VALUES (? , ? , ?)");

        preparedStatement.setInt(1, supplier.getId());
        preparedStatement.setString(2, supplier.getName());

        preparedStatement.setString(3, supplier.getLastDateSupplied());



        int resultInt = preparedStatement.executeUpdate();

        boolean result = false;

        if (resultInt == 1) {
            result = true;
        }

        System.out.println("supplier inserted|saved ? " + result);

        return result;}

    @Override
    public boolean update(Supplier supplier) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
        
        
        Connection connection = ConnectionManager.getConection();

        PreparedStatement preparedStatement = connection.prepareStatement("update supplier "
                + "set name = ? , lastdatesupplied =  ? "
                
                + " where id =" + supplier.getId());
        
        

        preparedStatement.setString(1, supplier.getName());
        preparedStatement.setString(2, supplier.getLastDateSupplied());

        int resultInt = preparedStatement.executeUpdate();

        boolean result = false;

        if (resultInt == 1) {
            result = true;
        }

        System.out.println("supplier updateded ? " + result);

        return result;}

    @Override
    public boolean delete(int id) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {

        
        Connection connection = ConnectionManager.getConection();

        PreparedStatement preparedStatement = connection.prepareStatement("delete from supplier where id =  " + id);

        int resultInt = preparedStatement.executeUpdate();

        boolean result = false;

        if (resultInt == 1) {
            result = true;
        }

        System.out.println("supplier deleted ? " + result);

        return result;
    }
}
