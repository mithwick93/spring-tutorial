package com.github.mithwick93.tutorial.controller;

import com.github.mithwick93.tutorial.model.Customer;
import com.github.mithwick93.tutorial.service.CustomerService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CustomerController {
    private CustomerService customerService;

    @Autowired
    public void setCustomerService(CustomerService customerService) {
        this.customerService = customerService;
    }

    @ApiOperation(value = "Returns customers from database with matching name", notes = "get customers by name")
    @GetMapping("/customer")
    public List<Customer> greeting(@RequestParam(value = "name") String name) {
        return customerService.getCustomersInDatabaseByName(name);
    }
}
