package com.example.servergraphql.domain.services;

import com.example.servergraphql.common.Configuration;
import com.example.servergraphql.data.dao.CredentialsDao;
import com.example.servergraphql.data.model.Credentials;
import com.example.servergraphql.data.model.Errors;
import io.vavr.control.Either;
import org.springframework.stereotype.Service;

@Service
public class CredentialsServices {
    private final CredentialsDao dao;
    private final Configuration co;

    public CredentialsServices(CredentialsDao dao, Configuration co) {
        this.dao = dao;
        this.co = co;
    }


    public Either<Errors, Integer> register(String name, String passw) {
        String str = co.createPasswordEncoder().encode(passw);
        dao.save(new Credentials(name, str));
        return Either.right(0);
    }
}
