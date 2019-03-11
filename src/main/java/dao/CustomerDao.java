package dao;

import model.Customer;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerDao {
    // JDBC driver name and database URL
    static final String JDBC_DRIVER = "org.h2.Driver";
    static final String DB_URL = "jdbc:h2:~/customer";

    //  Database credentials
    static final String USER = "";
    static final String PASS = "";

    public static Connection getConnection() throws SQLException {

        Connection conn = null;
        Statement stmt = null;

            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            return conn;
        }
        try {
            // STEP 1: Register JDBC driver
            Class.forName(JDBC_DRIVER);

            //STEP 2: Open a connection
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL,USER,PASS);

            //STEP 3: Execute a query
//            System.out.println("Creating table in given database...");
//            stmt = conn.createStatement();
//            String sql =  "CREATE TABLE   REGISTRATION " +
//                    "(id INTEGER not NULL, " +
//                    " first VARCHAR(255), " +
//                    " last VARCHAR(255), " +
//                    " age INTEGER, " +
//                    " PRIMARY KEY ( id ))";
//            stmt.executeUpdate(sql);
//            System.out.println("Created table in given database...");

            // STEP 4: Clean-up environment
            stmt.close();
            conn.close();
        } catch(SQLException se) {
            //Handle errors for JDBC
            se.printStackTrace();
        } catch(Exception e) {
            //Handle errors for Class.forName
            e.printStackTrace();
        } finally {
            //finally block used to close resources
            try{
                if(stmt!=null) stmt.close();
            } catch(SQLException se2) {
            } // nothing we can do
            try {
                if(conn!=null) conn.close();
            } catch(SQLException se){
                se.printStackTrace();
            } //end finally try
        } //end try
        System.out.println("Goodbye!");
    }
                                             // C-R-U-D

    // Method to create/insert customer
    public void createCustomer(int id, String firstName, String lastName) throws SQLException {


        PreparedStatement stmt = getConnection().prepareStatement("INSERT into CUSTOMERS values (?,?,?)");

        stmt.setInt(1, id);
        stmt.setString(2, firstName);
        stmt.setString(3, lastName);

        int insertion = stmt.executeUpdate();

        if (insertion != 0) {
            System.out.println("Inserted");
        } else {
            System.out.println("not Inserted");
        }
    }

    // Method to update customer
    public void updateCustomer(int id, String firstName, String lastName) throws SQLException {
        PreparedStatement stmt = getConnection().prepareStatement("UPDATE CUSTOMERS set firstName=?, lastName=?" +
                "WHERE id=?");

        stmt.setString(1, firstName);
        stmt.setString(2, lastName);
        stmt.setInt(3, id);

        int rowsUpdated = stmt.executeUpdate();

    }

    // Method to read all customers
    public List<Customer> readCustomers() {
        // STEP 3: Execute a query
        System.out.println("Connected database successfully...");

        List<Customer> customers = new ArrayList<>();

        try (Statement stmt = getConnection().createStatement()) {

            String sql = "SELECT id, firstName, lastName FROM customers";
            ResultSet rs = stmt.executeQuery(sql);

            // STEP 4: Extract data from result set
            while (rs.next()) {

                // Retrieve by column name
                int id = rs.getInt("id");
                String firstName = rs.getString("firstName");
                String lastName = rs.getString("lastName");

                // Display values
                customers.add(new Customer(id,firstName,lastName));

            }
            // STEP 5: Clean-up environment
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customers;
    }



    // Method to delete customer
    public void deleteById(int id) {
        PreparedStatement stmt = null;
        try {
            stmt = getConnection().prepareStatement("DELETE FROM CUSTOMERS where id=?");
            stmt.setInt(1, id);
            int deleted = stmt.executeUpdate();
            if (deleted != 0) {
                System.out.println("Customer with ID: " + id + " deleted");
            } else {
                System.out.println("Customer with ID: " + id + " NOT deleted");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void findCustomerById(int id) {
        PreparedStatement stmt = null;
        try {
            stmt = getConnection().prepareStatement("SELECT * FROM CUSTOMERS where id=?");
            stmt.setInt(1, id);
            ResultSet res = stmt.executeQuery();
            if (res.next()) {
                System.out.print(res.getInt(1));
                System.out.print(res.getString(2));
                System.out.print(res.getString(3));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void saveCustomer(Customer customer) {
    }
}

