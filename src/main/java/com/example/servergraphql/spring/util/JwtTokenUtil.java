package com.example.servergraphql.spring.util;

import com.example.servergraphql.common.Configuration;
import com.example.servergraphql.data.model.Errors;
import com.example.servergraphql.security.VerifyTokens;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.vavr.control.Either;
import org.springframework.stereotype.Component;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.logging.Level;
import java.util.logging.Logger;

@Component
public class JwtTokenUtil {

    private final Configuration co;

    public JwtTokenUtil(Configuration co) {
        this.co = co;
    }

    public boolean validate(String token){
        try{
            KeyStore keyStore = KeyStore.getInstance("PKCS12");
            keyStore.load(new FileInputStream(co.getNombreKeystore()), co.getClave().toCharArray());
            X509Certificate cert = (X509Certificate) keyStore.getCertificate(co.getServerName());
            PublicKey publicKey = cert.getPublicKey();
            Jwts.parserBuilder()
                    .setSigningKey(publicKey)
                    .build()
                    .parseClaimsJws(token);
            return true;
        } catch (CertificateException | KeyStoreException | IOException |
                 NoSuchAlgorithmException e) {
            Logger.getLogger(VerifyTokens.class.getName()).log(Level.SEVERE, null, e);
            return false;
        }catch ( JwtException e){
            Logger.getLogger(VerifyTokens.class.getName()).log(Level.SEVERE, null, e);
            return false;
        }


    }
    public String getRole(String token) {

        Jws<Claims> claimsJws = Jwts.parserBuilder()
                .setSigningKey(getKey())
                .build()
                .parseClaimsJws(token);

        return claimsJws.getBody().get("role",String.class);
    }
    public String getUsername(String token) {


            Jws<Claims> claimsJws = Jwts.parserBuilder()
                    .setSigningKey(getKey())
                    .build()
                    .parseClaimsJws(token);
            return claimsJws.getBody().getSubject();

    }
   private PublicKey getKey(){
       try {
           KeyStore keyStore = KeyStore.getInstance("PKCS12");
           keyStore.load(new FileInputStream(co.getNombreKeystore()), co.getClave().toCharArray());
           X509Certificate cert = (X509Certificate) keyStore.getCertificate(co.getServerName());
           PublicKey publicKey = cert.getPublicKey();

           return publicKey;
       }  catch (CertificateException | KeyStoreException | IOException |
                 NoSuchAlgorithmException e) {
           Logger.getLogger(VerifyTokens.class.getName()).log(Level.SEVERE, "error al coger la clave", e);
           return null;
       }catch ( JwtException e){
           Logger.getLogger(VerifyTokens.class.getName()).log(Level.SEVERE, "error al coger la clave", e);
           return null;
       }
   }



}
