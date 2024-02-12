package com.example.servergraphql.spring.graphql;

import com.example.servergraphql.domain.services.CredentialsServices;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.stereotype.Controller;

@Controller
public class RegisterController {
  private final    CredentialsServices services;

    public RegisterController(CredentialsServices services) {
        this.services = services;
    }

    @MutationMapping
    public Integer register(@Argument String name, String password){
     return services.register(name,password).get();
    }
}
