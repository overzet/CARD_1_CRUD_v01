package service;

import model.Customer;

import java.sql.SQLException;
import java.util.List;

public interface CustomerService {
    void findCustomerById(int id);

    void saveCustomer(Customer customer);

    void createCustomer(int id, String firstName, String lastName) throws SQLException;

    void updateCustomer(int id, String firstName, String lastName) throws SQLException;

    void deleteCustomer(int id);

    List<Customer> getAllCustomers();
}
