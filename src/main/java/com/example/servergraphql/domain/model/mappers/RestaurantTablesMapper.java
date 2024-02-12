package com.example.servergraphql.domain.model.mappers;

import com.example.servergraphql.data.model.CustomersEntity;
import com.example.servergraphql.data.model.RestaurantTablesEntity;
import com.example.servergraphql.domain.model.Customers;
import com.example.servergraphql.domain.model.RestaurantTables;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RestaurantTablesMapper {
    RestaurantTables toTables(RestaurantTablesEntity entity);
}
