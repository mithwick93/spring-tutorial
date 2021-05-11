package com.github.mithwick93.tutorial.service;

import com.github.mithwick93.tutorial.dal.dao.CustomerDao;
import com.github.mithwick93.tutorial.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    private CustomerDao customerDao;

    @Autowired
    public void setCustomerDao(CustomerDao customerDao) {
        this.customerDao = customerDao;
    }

    public List<Customer> getCustomersInDatabaseByName(String name) {
        return customerDao.getCustomerByName(name);
    }
}
