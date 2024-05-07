package peaksoft.dao;

import peaksoft.models.Customer;

import java.util.List;

public interface CustomerDao {
    void createCustomerTable();
    String addCustomer(Customer customer);
    Customer getCustomerById(Long id);
    String updateCustomerById(Long id, Customer newCustomer);
    String deleteCustomerById(Long id);
    List<Customer> sortCustomerByAge(String ascOrDesc);
}
