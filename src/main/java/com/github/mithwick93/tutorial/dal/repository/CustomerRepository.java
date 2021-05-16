package com.github.mithwick93.tutorial.dal.repository;

import com.github.mithwick93.tutorial.model.Customer;

import java.util.List;

//@Repository
public interface CustomerRepository {// extends CrudRepository<Customer, Long> {

    List<Customer> findByLastName(String lastName);

    Customer findById(long id);
}
