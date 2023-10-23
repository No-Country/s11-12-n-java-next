package com.selecionado.quizwiz.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Service
public class JWTUtils {
    @Value("${jwt.secret.key}")
    private String secretKey;

    @Value("${jwt.time.expiration}")
    private int timeExpiration;

    /**
     * Genera token con los detalles de usuario
     * @param userDetails informacion del usuario
     * @return string token jwt
     */
    public String generateToken(UserDetails userDetails) {
        Map<String, Object> claims = new HashMap<>();
        return createToken(claims, userDetails.getUsername());
    }

    /**
     * Crea token de acceso
     * @param claims reclamaciones
     * @param subject email
     * @return  string token jwt
     */
    private String createToken(Map<String, Object> claims, String subject) {

        return Jwts.builder()
                .setClaims(claims)
                .setSubject(subject)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + timeExpiration))
                .signWith(Keys.hmacShaKeyFor(secretKey.getBytes()), SignatureAlgorithm.HS256)
                .compact();
    }

    /**
     * Extrae el email del token
     * @param token string jwt token
     * @return string email
     */
    public String getEmail(String token) {
        return getClaim(token, Claims::getSubject);
    }

    /**
     * Obtener la fecha de expiracion del token
     * @param token string jwt token
     * @return date
     */
    public Date getExpirationDate(String token){
        return getClaim(token, Claims::getIssuedAt);
    }

    /**
     * Devuelve true si la fecha del token expiro, sino devuelve false
     * @param token string jwt token
     * @return boolean
     */
    public boolean isTokenExpired(String token) {
        Date expirationDate = getExpirationDate(token);
        return expirationDate.after(new Date());
    }


    /**
     * Validar el token de acceso
     * @param token string jwt token
     * @param user informacion de usuario
     * @return verdadero o falso
     */
    public boolean isTokenValid(String token, UserDetails user) {
        final String username = getEmail(token);
        return (username.equals(user.getUsername()));
    }

    /**
     * Obtener todos los claims del token
     * @param token string token jwt
     * @return claims
     */
    public Claims extractAllClaims(String token){
        return Jwts.parserBuilder()
                .setSigningKey(secretKey.getBytes())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    /**
     * Obtener un solo claim
     * @param token jwt string token
     * @param claimsTFunction funcion para obtener un claim
     * @param <T> objeto de claim a devolver
     * @return claim informacion de un claim del token
     */
    public <T> T getClaim(String token, Function<Claims, T> claimsTFunction){
        Claims claims = extractAllClaims(token);
        return claimsTFunction.apply(claims);
    }

    /**
     * Crear firma con algoritmo HMAC-SHA
     * @return algoritmo HMAC-SHA
     */
    public Key getSignatureKey(){
        byte[] keyBytes = Decoders.BASE64.decode(secretKey);
        return Keys.hmacShaKeyFor(keyBytes);
    }
}
