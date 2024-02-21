package com.example.servergraphql.spring.security;

import com.example.servergraphql.common.Configuration;
import com.example.servergraphql.common.Constantes;
import io.jsonwebtoken.*;
import org.springframework.stereotype.Component;

import java.io.FileInputStream;
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

    public boolean validate(String token) throws ExpiredJwtException {
        try(FileInputStream fis = new FileInputStream(co.getNombreKeystore())) {
            KeyStore keyStore = KeyStore.getInstance(Constantes.PKCS_12);
            keyStore.load(fis, co.getClave().toCharArray());
            X509Certificate cert = (X509Certificate) keyStore.getCertificate(co.getServerName());
            PublicKey publicKey = cert.getPublicKey();
            Jwts.parserBuilder()
                    .setSigningKey(publicKey)
                    .build()
                    .parseClaimsJws(token);
            return true;
        } catch (CertificateException | KeyStoreException | IOException | NoSuchAlgorithmException e) {
            Logger.getLogger(JwtTokenUtil.class.getName()).log(Level.SEVERE, null, e);

            return false;
        }


    }
    public String getRole(String token) {

        Jws<Claims> claimsJws = Jwts.parserBuilder()
                .setSigningKey(getKey())
                .build()
                .parseClaimsJws(token);

        return claimsJws.getBody().get(Constantes.ROLE,String.class);
    }
    public String getUsername(String token) {


            Jws<Claims> claimsJws = Jwts.parserBuilder()
                    .setSigningKey(getKey())
                    .build()
                    .parseClaimsJws(token);
            return claimsJws.getBody().getSubject();

    }
   private PublicKey getKey(){
       try (FileInputStream fis = new FileInputStream(co.getNombreKeystore())){
           KeyStore keyStore = KeyStore.getInstance(Constantes.PKCS_12);
           keyStore.load(fis, co.getClave().toCharArray());
           X509Certificate cert = (X509Certificate) keyStore.getCertificate(co.getServerName());

           return cert.getPublicKey();
       }  catch (CertificateException | KeyStoreException | IOException | NoSuchAlgorithmException | JwtException e) {
           Logger.getLogger(JwtTokenUtil.class.getName()).log(Level.SEVERE, Constantes.ERROR_AL_COGER_LA_CLAVE, e);
           return null;
       }
   }



}
