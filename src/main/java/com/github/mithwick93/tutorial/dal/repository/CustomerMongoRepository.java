package com.github.mithwick93.tutorial.dal.repository;

import com.github.mithwick93.tutorial.model.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerMongoRepository extends MongoRepository<Customer, String> {
    Customer findByFirstName(String firstName);

    List<Customer> findByLastName(String lastName);

}