package com.example.servergraphql.domain.model.mappers;

import com.example.servergraphql.common.Constantes;
import com.example.servergraphql.data.model.RestaurantTablesEntity;
import com.example.servergraphql.domain.model.RestaurantTables;
import org.mapstruct.Mapper;

@Mapper(componentModel =  Constantes.SPRING)
public interface RestaurantTablesMapper {
    RestaurantTables toTables(RestaurantTablesEntity entity);
}
