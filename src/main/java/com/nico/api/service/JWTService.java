package com.nico.api.service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;
import com.nico.api.model.Usuario;
import java.util.Date;
import javax.crypto.SecretKey;

@Service
public class JWTService {
    private final SecretKey chaveSecreta = Keys.secretKeyFor(SignatureAlgorithm.HS256);

    public String gerarToken(Usuario usuario) {
        return Jwts.builder()
            .setSubject(usuario.getEmail())
            .claim("nome", usuario.getNome())
            .setIssuedAt(new Date())
            .setExpiration(new Date(System.currentTimeMillis() + 86400000)) // 24 horas
            .signWith(chaveSecreta)
            .compact();
    }
}
