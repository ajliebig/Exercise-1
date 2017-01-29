package edu.matc.persistence;

import edu.matc.controller.SearchUser;
import edu.matc.entity.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.*;

/**
 * Access users in the user table.
 *
 * @author pwaite
 */
public class UserData {
    //Needed in every class with logging
    private final Logger logger = Logger.getLogger(this.getClass());

    public List<User> getAllUsers() {

        logger.info("Some message you want logged");
        logger.error("Demonstrating error level");

        List<User> users = new ArrayList<User>();
        Database database = Database.getInstance();
        Connection connection = null;
        String sql = "SELECT * FROM users";

        try {
            database.connect();
            connection = database.getConnection();
            Statement selectStatement = connection.createStatement();


            ResultSet results = selectStatement.executeQuery(sql);


            while (results.next()) {
                User employee = createUserFromResults(results);
                users.add(employee);
            }
            database.disconnect();
        } catch (SQLException e) {
            logger.error( "message: SearchUser.getAllUsers()...SQL Exception: " + e );

            //System.out.println("SearchUser.getAllUsers()...SQL Exception: " + e);
        } catch (Exception e) {
            System.out.println("SearchUser.getAllUsers()...Exception: " + e);
        }
        return users;
    }

    //TODO add a method or methods to return a single user based on search criteria
   public List<User> getOneUser(String searchTerm ) {
     List<User> usersSingle = new ArrayList<User>();
       Database database = Database.getInstance();
        Connection connection = null;
        String lame = "Curry";

     String sqlSingle = "SELECT * FROM users WHERE  last_name like '%" + searchTerm + "%'";

        try {
            database.connect();
            connection = database.getConnection();
            Statement selectStatement = connection.createStatement();

            ResultSet results = selectStatement.executeQuery(sqlSingle);

            while (results.next()) {
                User employee = createUserFromResults(results);
                usersSingle.add(employee);
            }
            database.disconnect();
        } catch (SQLException e) {
           // System.out.println("SearchUser.getAllUsers()...SQL Exception: " + e);
            logger.info("Some message you want logged SQL EXCEPTION");
        } catch (Exception e) {
           // System.out.println("SearchUser.getAllUsers()...Exception: " + e);
            logger.info("Some message you want logged EXCEPTION EXCEPTION");
        }

        return usersSingle;

    }

    private User createUserFromResults(ResultSet results) throws SQLException {
        User user = new User();
        user.setUserid(results.getString("id"));
        user.setLastName(results.getString("last_name"));
        user.setFirstName(results.getString("first_name"));
        user.setFirstName(results.getString("first_name"));
        user.setDob(results.getString("date_of_birth"));
        user.age();
        return user;
    }

}