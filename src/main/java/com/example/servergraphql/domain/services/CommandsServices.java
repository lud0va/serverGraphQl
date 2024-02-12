package com.example.servergraphql.domain.services;

import com.example.servergraphql.data.dao.CommandsDao;
import com.example.servergraphql.data.model.CommandsEntity;
import com.example.servergraphql.domain.model.Command;
import com.example.servergraphql.domain.model.mappers.CommandsMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CommandsServices {
    private final CommandsDao dao;
    private final CommandsMapper mapper;
    public CommandsServices(CommandsDao dao, CommandsMapper mapper) {
        this.dao = dao;
        this.mapper = mapper;
    }

    public List<Command> getCommandsByCustomer(int idcustomer){
        List<CommandsEntity> entity=dao.findAllByCustomerId(idcustomer).get();
        List<Command> commands=new ArrayList<>();
        for (CommandsEntity c:entity){
            commands.add(mapper.toCommand(c));
        }
        return commands;
    }
}
