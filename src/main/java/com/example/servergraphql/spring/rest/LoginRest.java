package com.example.servergraphql.spring.rest;

import com.example.servergraphql.data.model.Errors;
import com.example.servergraphql.domain.services.LoginServices;
import io.jsonwebtoken.Claims;
import io.vavr.control.Either;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class LoginRest {
   private final LoginServices serv;

    public LoginRest(LoginServices serv) {
        this.serv = serv;
    }

    @GetMapping("/verify")
    public String verify(@RequestParam(name="accesstoken")String token){
      Either<Errors, Claims>result= serv.verifyAccessToken(token);
      if (result.isRight()){
          return "token valido";
      }else {
          return result.getLeft().getMsg();
      }
    }
}
