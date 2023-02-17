
package DataAccess;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {
    
    private static String dbURL= "jdbc:mysql://localhost:3306/pointofsale";
    
    private static String username = "root";
    private static String password = "root"; 
    
    public static Connection getConection() throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        try {
//        Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
        // create connection
        Connection connection = DriverManager.getConnection( dbURL, username, password);
        
//        Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
        // create connection
        
        
        return connection;
        
        } catch(SQLException ex) {
            
            System.err.println(ex.toString());
            
            return null;
            
        }
}
    
}
