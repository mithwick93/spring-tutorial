package com.github.mithwick93.tutorial.dal.dao.mapper;

import com.github.mithwick93.tutorial.dal.dao.dto.CustomerDTO;
import com.github.mithwick93.tutorial.model.Customer;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.mapstruct.Mapper;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class DtoMapper {
    @Mapper(componentModel = "spring")
    public interface CustomerMapper {
        List<Customer> fromCustomerDTOStoCustomers(List<CustomerDTO> customerDTOS);
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
