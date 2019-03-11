package service;

import dao.CustomerDao;
import model.Customer;

import java.sql.SQLException;
import java.util.List;

public class CustomerServiceImpl implements CustomerService{
    private CustomerDao customerDao = new CustomerDao();

    @Override
    public void createCustomer(int id, String firstName, String lastName) throws SQLException {
        customerDao.createCustomer(id,firstName,lastName);
    }

    @Override
    public void updateCustomer(int id, String firstName, String lastName) throws SQLException {
        customerDao.updateCustomer(id, firstName, lastName);
    }

    @Override
    public void findCustomerById(int id) {
        customerDao.findCustomerById(id);
    }

    @Override
    public void saveCustomer(Customer customer) {
        customerDao.saveCustomer(customer);
    }


    @Override
    public void deleteCustomer(int id) {
        customerDao.deleteById(id);
    }

    @Override
    public List<Customer> getAllCustomers() {
        List<Customer> customersList = customerDao.readCustomers();
        customersList.forEach(System.out::println);
        return customersList;
    }
}
