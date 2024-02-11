package com.example.servergraphql.domain.model.mappers;

import com.example.servergraphql.data.model.CustomersEntity;
import com.example.servergraphql.domain.model.Customers;
import com.example.servergraphql.domain.model.graphql.CustomerInput;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CustomerMapper {
     CustomersEntity toCustomerEntity(CustomerInput input);

     Customers toCustomer(CustomersEntity entity);

     Customers toCustomer(CustomerInput input);
}
