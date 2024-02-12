package com.example.servergraphql.spring.graphql;

import com.example.servergraphql.domain.model.Command;
import com.example.servergraphql.domain.services.CommandsServices;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class CommandsController {

    private final CommandsServices serv;

    public CommandsController(CommandsServices serv) {
        this.serv = serv;
    }
    @QueryMapping
    @PreAuthorize("hasRole('admin') OR hasRole('user')")
    public List<Command> getCommandsByCustomer(@Argument int idCust){
        return serv.getCommandsByCustomer(idCust);
    }
}
