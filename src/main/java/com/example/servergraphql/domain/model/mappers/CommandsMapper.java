package com.example.servergraphql.domain.model.mappers;

import com.example.servergraphql.common.Constantes;
import com.example.servergraphql.data.model.CommandsEntity;
import com.example.servergraphql.domain.model.Command;
import org.mapstruct.Mapper;

@Mapper(componentModel = Constantes.SPRING)
public interface CommandsMapper {

        Command toCommand(CommandsEntity entity);
}
