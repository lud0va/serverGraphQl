package com.example.servergraphql.domain.model.mappers;

import com.example.servergraphql.common.Constantes;
import com.example.servergraphql.data.model.CustomersEntity;
import com.example.servergraphql.domain.model.Customers;
import com.example.servergraphql.domain.model.graphql.CustomerInput;
import org.mapstruct.Mapper;

@Mapper(componentModel = Constantes.SPRING)
public interface CustomerMapper {
     CustomersEntity toCustomerEntity(CustomerInput input);

     Customers toCustomer(CustomersEntity entity);

     Customers toCustomer(CustomerInput input);
}
