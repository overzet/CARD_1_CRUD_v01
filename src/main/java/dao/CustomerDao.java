package dao;

public class CustomerDao {}



     /*   // C-R-U-D

        // Method to create customer
        public void createCustomer ( int id, String firstName, String lastName) throws SQLException {

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
*/