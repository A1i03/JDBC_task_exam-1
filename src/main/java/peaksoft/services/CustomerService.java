package peaksoft.services;

import peaksoft.models.Customer;

import java.util.List;

public interface CustomerService {
    void createCustomerTable();
    String addCustomer(Customer customer);
    Customer getCustomerById(Long id);
    String updateCustomerById(Long id, Customer newCustomer);
    String deleteCustomerById(Long id);
    List<Customer> sortCustomerByAge(String ascOrDesc);
}
