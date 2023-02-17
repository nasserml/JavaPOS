
package DataAccess;


import java.sql.SQLException;
import java.util.ArrayList;

public interface BaseDA<E> {
    
    ArrayList<E> findAll() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException;
    
    E findById(int id) throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException;
    
    boolean save(E object) throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException;
    
    boolean update(E object) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException;
    
    boolean delete(int id) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException;
    
}
