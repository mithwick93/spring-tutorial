package com.github.mithwick93.tutorial.console;

import com.github.mithwick93.tutorial.dal.repository.CustomerMongoRepository;
import com.github.mithwick93.tutorial.model.Customer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
public class DatabaseInitializer implements CommandLineRunner {
    private static final Logger LOG = LoggerFactory.getLogger(DatabaseInitializer.class);

    JdbcTemplate jdbcTemplate;

//    CustomerRepository repository;

    CustomerMongoRepository customerMongoRepository;

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

//    @Autowired
//    public void setRepository(CustomerRepository repository) {
//        this.repository = repository;
//    }

    @Autowired
    public void setCustomerMongoRepository(CustomerMongoRepository customerMongoRepository) {
        this.customerMongoRepository = customerMongoRepository;
    }

    @Override
    public void run(String... args) {
        LOG.info("Creating tables");

        jdbcTemplate.execute("DROP TABLE customers IF EXISTS");
        jdbcTemplate.execute("CREATE TABLE customers(id SERIAL, first_name VARCHAR(255), last_name VARCHAR(255))");

        // Split up the array of whole names into an array of first/last names
        List<Object[]> splitUpNames = Stream.of("John Woo", "Jeff Dean", "Josh Bloch", "Josh Long")
                .map(name -> name.split(" "))
                .collect(Collectors.toList());

        // Use a Java 8 stream to print out each tuple of the list
        splitUpNames.forEach(name -> LOG.info(String.format("Inserting customer record for %s %s", name[0], name[1])));

        // Uses JdbcTemplate's batchUpdate operation to bulk load data
        jdbcTemplate.batchUpdate("INSERT INTO customers(first_name, last_name) VALUES (?,?)", splitUpNames);

//        // - JPA -
//        // save a few customers
//        repository.save(new Customer("Jack", "Bauer"));
//        repository.save(new Customer("Chloe", "O'Brian"));
//        repository.save(new Customer("Kim", "Bauer"));
//        repository.save(new Customer("David", "Palmer"));
//        repository.save(new Customer("Michelle", "Dessler"));
//
//        // fetch all customers
//        LOG.info("Customers found with findAll():");
//        LOG.info("-------------------------------");
//        for (Customer customer : repository.findAll()) {
//            LOG.info(customer.toString());
//        }
//        LOG.info("");
//
//        // fetch an individual customer by ID
//        Customer customer = repository.findById(1L);
//        LOG.info("Customer found with findById(1L):");
//        LOG.info("--------------------------------");
//        LOG.info(customer.toString());
//        LOG.info("");
//
//        // fetch customers by last name
//        LOG.info("Customer found with findByLastName('Bauer'):");
//        LOG.info("--------------------------------------------");
//        repository.findByLastName("Bauer").forEach(bauer -> LOG.info(bauer.toString()));
//        // for (Customer bauer : repository.findByLastName("Bauer")) {
//        //  log.info(bauer.toString());
//        // }
//        LOG.info("");

        // - MongoDb -

        customerMongoRepository.deleteAll();

        // save a couple of customers
        customerMongoRepository.save(new Customer(1, "Alice", "Smith"));
        customerMongoRepository.save(new Customer(2, "Bob", "Smith"));

        // fetch all customers
        System.out.println("Customers found with findAll():");
        System.out.println("-------------------------------");
        for (Customer c : customerMongoRepository.findAll()) {
            System.out.println(c);
        }
        System.out.println();

        // fetch an individual customer
        System.out.println("Customer found with findByFirstName('Alice'):");
        System.out.println("--------------------------------");
        System.out.println(customerMongoRepository.findByFirstName("Alice"));

        System.out.println("Customers found with findByLastName('Smith'):");
        System.out.println("--------------------------------");
        for (Customer c : customerMongoRepository.findByLastName("Smith")) {
            System.out.println(c);
        }
    }
}
