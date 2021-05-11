package com.github.mithwick93.tutorial.dal.dao.mapper;

import com.github.mithwick93.tutorial.dal.dao.dto.CustomerTo;
import com.github.mithwick93.tutorial.model.Customer;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.springframework.beans.BeanUtils;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CustomerMapper {
    public static List<Customer> fromTo(@NonNull List<CustomerTo> customerTos) {
        List<Customer> customers = new ArrayList<>();

        for (CustomerTo customerTo : customerTos) {
            Customer customer = new Customer();
            BeanUtils.copyProperties(customerTo, customer);

            customers.add(customer);
        }
        return customers;
    }

    public static class CustomerRowMapper implements RowMapper<CustomerTo> {
        @Override
        public CustomerTo mapRow(ResultSet rs, int rowNum) throws SQLException {
            CustomerTo customerTo = new CustomerTo();
            customerTo.setId(rs.getLong("id"));
            customerTo.setFirstName(rs.getString("first_name"));
            customerTo.setLastName(rs.getString("last_name"));
            return customerTo;
        }
    }
}
