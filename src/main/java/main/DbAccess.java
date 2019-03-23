package main;

import java.sql.*;

public class DbAccess {

    public static void main(String[] args) throws Exception {

        try (Connection connection =
                     DriverManager.getConnection("jdbc:h2:~/customer", "", "" )) {
            System.out.println(connection.isValid(1000));
            Statement statement = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

                                  // C-R-U-D
    // Method to create customer
    public void createCustomer (int id, String firstName, String lastName, Connection connection ) throws SQLException {


        PreparedStatement stmt = connection.prepareStatement("INSERT into customers values (?,?,?)");

        stmt.setInt(1, 22);
        stmt.setString(2, "James");
        stmt.setString(3, "Baldwin");

        int insertion = stmt.executeUpdate();

        if (insertion != 0) {
            System.out.println("Inserted");
        } else {
            System.out.println("not Inserted");
        }
    }
}


//    CustomerServiceImpl service = new CustomerServiceImpl();
//        service.getAllCustomers();
//
//        System.out.println("----------UPDATE------------");
//        try
//
//    {
//        service.updateCustomer(102, "Wilhelmus", "Oranje");
//    } catch(
//    SQLException e)
//
//    {
//        e.printStackTrace();
//    }
//        System.out.println("----------------------");
//        service.getAllCustomers();
//
//        System.out.println("----------DELETE------------");
//        service.deleteCustomer(100);
//        service.getAllCustomers();
//        System.out.println("----------------------");
//
//
//
//        System.out.println("----------READ------------");
//        service.findCustomerById(101);
//        service.getAllCustomers();
//        System.out.println("----------------------");
//
//
