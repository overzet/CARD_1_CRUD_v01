package main;

import java.sql.*;

public class DbAccess {

    public static void main(String[] args) throws Exception {

        String columnNamePattern = null;

        ResultSet resultSet = null;

        try (Connection connection =
                     DriverManager.getConnection("jdbc:h2:~/IdeaProjects/customers", "", "" )) {
            System.out.println(connection.isValid(1000));   //prints 'true' if connection is established

            Statement statement = connection.createStatement();

                            //This works
            statement.executeUpdate("INSERT INTO Customers " + "VALUES (5, 'Mike', 'Tyson')");

            resultSet = statement.executeQuery("SELECT * FROM CUSTOMERS");
            while (resultSet.next()) {
                System.out.println("\n");
                System.out.println(resultSet.getString("FIRSTNAME"));
                System.out.println(resultSet.getString("LASTNAME"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
                                                  // C-R-U-D
    // Method to create customer
    public void createCustomer(int id, String firstName, String lastName, Connection connection) throws SQLException {

        PreparedStatement stmt = connection.prepareStatement("INSERT INTO customers VALUES (?,?,?)");

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
