package com.example.servergraphql.common;

import lombok.Getter;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;




@org.springframework.context.annotation.Configuration
@Getter
public class Configuration {


   @Bean
    public PasswordEncoder createPasswordEncoder() {

        return new BCryptPasswordEncoder();
    }
}
