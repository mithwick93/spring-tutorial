package com.github.mithwick93.tutorial.dal.dao.mapper;

import com.github.mithwick93.tutorial.dal.dao.dto.CustomerDTO;
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
    public static List<Customer> fromTo(@NonNull List<CustomerDTO> customerDTOS) {
        List<Customer> customers = new ArrayList<>();

        for (CustomerDTO customerDTO : customerDTOS) {
            Customer customer = new Customer();
            BeanUtils.copyProperties(customerDTO, customer);

            customers.add(customer);
        }
        return customers;
    }

    public static class CustomerRowMapper implements RowMapper<CustomerDTO> {
        @Override
        public CustomerDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
            CustomerDTO customerDTO = new CustomerDTO();
            customerDTO.setId(rs.getLong("id"));
            customerDTO.setFirstName(rs.getString("first_name"));
            customerDTO.setLastName(rs.getString("last_name"));
            return customerDTO;
        }
    }
}
