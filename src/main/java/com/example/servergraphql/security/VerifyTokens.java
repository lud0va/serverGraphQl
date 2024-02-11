package com.example.servergraphql.security;

import com.example.servergraphql.common.Configuration;
import com.example.servergraphql.data.model.Errors;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.vavr.control.Either;
import org.springframework.stereotype.Component;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.security.*;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.logging.Level;
import java.util.logging.Logger;

@Component
public class VerifyTokens {


   private final Configuration  co;

    public VerifyTokens(Configuration co) {
        this.co = co;
    }

    public Either<Errors,Claims> verifyToken(String token){
        try{
            KeyStore keyStore = KeyStore.getInstance("PKCS12");
            keyStore.load(new FileInputStream(co.getNombreKeystore()), co.getClave().toCharArray());
            X509Certificate cert = (X509Certificate) keyStore.getCertificate(co.getServerName());
            PublicKey publicKey = cert.getPublicKey();
            Jws<Claims> jws = Jwts.parserBuilder()
                    .setSigningKey(publicKey)
                    .build()
                    .parseClaimsJws(token);
            return Either.right(jws.getBody());
        } catch (CertificateException | KeyStoreException | IOException |
                 NoSuchAlgorithmException e) {
            Logger.getLogger(VerifyTokens.class.getName()).log(Level.SEVERE, null, e);
            return Either.left(new Errors("error firmando el access token"));
        }catch ( JwtException e){
            Logger.getLogger(VerifyTokens.class.getName()).log(Level.SEVERE, null, e);
            return Either.left(new Errors("firma invalida"));
        }


    }








}
