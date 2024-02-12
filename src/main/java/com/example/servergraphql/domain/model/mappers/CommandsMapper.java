package com.example.servergraphql.domain.model.mappers;

import com.example.servergraphql.data.model.CommandsEntity;
import com.example.servergraphql.data.model.CustomersEntity;
import com.example.servergraphql.domain.model.Command;
import com.example.servergraphql.domain.model.Customers;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CommandsMapper {
        Command toCommand(CommandsEntity entity);
}
