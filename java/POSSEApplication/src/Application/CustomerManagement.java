
package Application;

import DataAccess.CustomerDA;
import entities.Customer;
import java.sql.SQLException;
import java.util.ArrayList;


public class CustomerManagement {
    
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
        
        CustomerDA customerDA = new CustomerDA();
        
        ArrayList<Customer> customers = customerDA.findAll();
        
        for (Customer customer : customers) {
            System.out.println(customer.getName());
        }
        
        
          // update
//        CustomerDA customerDA = new CustomerDA();
//
//        Customer customer = new Customer();
//
//        customer.setId("11019");
//        customer.setName("Mahmougdd Nassgdser");
//
//        customer.setAge("2541");
//        customer.setGender("maleee");
//
//        customer.setAddress("maadshla");
//        customer.setPhone("0101233sdad54");
//
//        customer.setEmail("nas@masdai");
//
//        boolean result = customerDA.update(customer);
//
//        System.out.println(result);
        
        
        
        

        // delete
//        CustomerDA customerDA = new CustomerDA();
//        
//        boolean result = customerDA.delete(11020);
//        
//        System.out.println(result);







//        // save 
//        CustomerDA customerDA = new CustomerDA();
//        
//        Customer customer = new Customer();
//        
//        customer.setId("11020");
//        customer.setName("Mahmoud Nasser");
//        
//        customer.setAge("21");
//        customer.setGender("male");
//        
//        customer.setAddress("mahla");
//        customer.setPhone("010123354");
//        
//        customer.setEmail("nas@mai");
//        
//        boolean result = customerDA.save(customer);
//        
//        System.out.println(result);






//        // find by id
//         CustomerDA customerDA = new CustomerDA();
//        
//        Customer customer = customerDA.findById(11012);
//        
//        System.out.println(customer.getName());









//        // finAll
//        CustomerDA customerDA = new CustomerDA();
//        
//        ArrayList<Customer> customers = customerDA.findAll();
//        
//        for (Customer customer : customers) {
//            System.out.println(customer.getName());
//        }
        
    }
    
}
