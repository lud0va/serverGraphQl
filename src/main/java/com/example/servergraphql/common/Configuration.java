package com.example.servergraphql.common;

import lombok.Getter;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


import java.io.IOException;
import java.util.Properties;

@org.springframework.context.annotation.Configuration
@Getter
public class Configuration {
    private String clave;
    private String nombreKeystore;
    private String serverName;


    public Configuration() {
        try {
            Properties p = new Properties();
            p.loadFromXML(Configuration.class.getClassLoader().getResourceAsStream(Constantes.CONFIG_CLAVE_KEYSTORE_XML));
            this.clave = p.getProperty(Constantes.CLAVEKEYSTORE);
            this.nombreKeystore=p.getProperty(Constantes.KEYSTORE_NAME);
            this.serverName=p.getProperty(Constantes.SERVER_NAME);
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }


   @Bean
    public PasswordEncoder createPasswordEncoder() {

        return new BCryptPasswordEncoder();
    }
}
