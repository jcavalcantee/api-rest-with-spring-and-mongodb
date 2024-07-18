package tech.project.Banco.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import tech.project.Banco.model.UserModel;

import java.util.Date;

@Service
public class TokenService {

     @Value("${api.banco.token.secret.key}")
     private String key;

     public static final int TOKEN_EXPIRATION = 600_000; //10min

    public String generateToken(UserModel user) {
        try {
            Algorithm algorithm = Algorithm.HMAC512(key);
            String token = JWT.create()
                    .withIssuer("api-auth-login")
                    .withSubject(user.getUsername())
                    .withExpiresAt(new Date(System.currentTimeMillis() + TOKEN_EXPIRATION))
                    .sign(algorithm);
            return token;
        } catch (JWTCreationException ex) {
            throw new RuntimeException("Error", ex);
        }
    }

    public String validateToken(String token) {
        if (token == null || token.trim().isEmpty()) {
            return null;
        }

        try {
            Algorithm algorithm = Algorithm.HMAC512(key);
            return JWT.require(algorithm)
                    .withIssuer("api-auth-login")
                    .build()
                    .verify(token)
                    .getSubject();
        } catch (JWTVerificationException ex) {
            return null;
        }
    }
}
