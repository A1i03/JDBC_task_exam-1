package peaksoft.services.serviceImpl;

import peaksoft.dao.CustomerDao;
import peaksoft.dao.daoImpl.CustomerDaoImpl;
import peaksoft.models.Customer;
import peaksoft.services.CustomerService;

import java.util.List;

public class CustomerServiceImpl implements CustomerService {
    CustomerDao customerDao = new CustomerDaoImpl();
    @Override
    public void createCustomerTable() {
    customerDao.createCustomerTable();
    }

    @Override
    public String addCustomer(Customer customer) {
        return customerDao.addCustomer(customer);
    }

    @Override
    public Customer getCustomerById(Long id) {
        return customerDao.getCustomerById(id);
    }

    @Override
    public String updateCustomerPhoneNumber(Long id, String phoneNUmber) {
        return customerDao.updateCustomerPhoneNumber(id,phoneNUmber);
    }

    @Override
    public String deleteCustomerById(Long id) {
        return customerDao.deleteCustomerById(id);
    }

    @Override
    public List<Customer> sortCustomerByAge(String ascOrDesc) {
        return customerDao.sortCustomerByAge(ascOrDesc);
    }
}
