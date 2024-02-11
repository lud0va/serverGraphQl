package com.example.servergraphql.domain.services;

import com.example.servergraphql.data.model.Errors;
import com.example.servergraphql.security.VerifyTokens;
import io.jsonwebtoken.Claims;
import io.vavr.control.Either;
import org.springframework.stereotype.Service;

@Service
public class LoginServices {
    private final VerifyTokens verifyTokens;

    public LoginServices(VerifyTokens verifyTokens) {
        this.verifyTokens = verifyTokens;
    }
    public Either<Errors,Claims> verifyAccessToken(String token){
        return verifyTokens.verifyToken(token);
    }


}
