package com.github.mithwick93.tutorial.dal.dao;

import com.github.mithwick93.tutorial.dal.dao.dto.CustomerTo;
import com.github.mithwick93.tutorial.dal.dao.mapper.CustomerMapper;
import com.github.mithwick93.tutorial.model.Customer;
import lombok.NonNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CustomerDao {
    private static final Logger LOG = LoggerFactory.getLogger(CustomerDao.class);

    NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    public void setJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    public List<Customer> getCustomerByName(@NonNull String name) {
        LOG.info("Querying for customer records where first_name = '" + name + "':");

        MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
        mapSqlParameterSource.addValue("NAME", name);
//        String GET_CUSTOMER_BY_NAME_QUERY = "SELECT id, first_name, last_name FROM customers WHERE first_name = :NAME";

        CustomerTo customerToQuery = new CustomerTo();
        customerToQuery.setFirstName(name);
        SqlParameterSource namedParameters = new BeanPropertySqlParameterSource(customerToQuery);
        String GET_CUSTOMER_BY_NAME_QUERY = "SELECT id, first_name, last_name FROM customers WHERE first_name = :firstName";

        List<CustomerTo> customerTos = namedParameterJdbcTemplate.query(
                GET_CUSTOMER_BY_NAME_QUERY,
                namedParameters,
                new CustomerMapper.CustomerRowMapper());

        return CustomerMapper.fromTo(customerTos);
    }
}
