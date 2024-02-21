package com.example.servergraphql.domain.services;

import com.example.servergraphql.common.Constantes;
import com.example.servergraphql.data.dao.CommandsDao;
import com.example.servergraphql.data.model.CommandsEntity;
import com.example.servergraphql.domain.model.Command;
import com.example.servergraphql.domain.model.mappers.CommandsMapper;
import com.example.servergraphql.spring.errors.exceptions.NotFoundElementException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class CommandsServices {
    private final CommandsDao dao;
    private final CommandsMapper mapper;
    public CommandsServices(CommandsDao dao, CommandsMapper mapper) {
        this.dao = dao;
        this.mapper = mapper;
    }

    public List<Command> getCommandsByCustomer(int idcustomer){
        try {
        List<Command> commands=new ArrayList<>();
        Optional<List<CommandsEntity>> result=dao.findAllByCustomer(idcustomer);
        if (result.isPresent()) {
            List<CommandsEntity> entity=result.get();

            for (CommandsEntity c:entity){
                commands.add(mapper.toCommand(c));
            }
        }

        return commands;
        } catch (NoSuchElementException e) {
            throw new NotFoundElementException(Constantes.COMMAND_NO_ENCONTRADA);
        }
        }
}
