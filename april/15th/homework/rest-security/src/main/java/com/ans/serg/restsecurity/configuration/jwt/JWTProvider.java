package com.ans.serg.restsecurity.configuration.jwt;

import com.ans.serg.restsecurity.entity.Role;
import com.ans.serg.restsecurity.exception.InvalidJWTException;
import io.jsonwebtoken.*;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import java.util.Base64;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class JWTProvider {

    @Value("${jwt.token.secret}")
    private String jwtSecret;

    @Value("${jwt.token.expired}")
    private long jwtExpirationTimeInMilliseconds;

    private UserDetailsService userDetailsService;

    public JWTProvider(UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @PostConstruct
    protected void init() {
        jwtSecret = Base64.getEncoder().encodeToString(jwtSecret.getBytes());
    }

    /**
     * why date?
     */
    public String generateJWT(String username, Set<Role> roles){
        Claims claims = Jwts.claims().setSubject(username);
        claims.put("roles", getUserRoleNamesFromJWT(roles));
        Date jwtCreationDate = new Date();
        Date jwtExpirationDate = new Date(jwtCreationDate.getTime() + jwtExpirationTimeInMilliseconds);
        return Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(jwtCreationDate)
                .setExpiration(jwtExpirationDate)
                .signWith(SignatureAlgorithm.HS256, jwtSecret)
                .compact();
    }

    public Authentication getAuthentication(String jsonWebToken) {
        UserDetails userDetails = userDetailsService.loadUserByUsername(getUsernameFromJWT(jsonWebToken));
        return new UsernamePasswordAuthenticationToken(userDetails, "", userDetails.getAuthorities());
    }

    private String getUsernameFromJWT(String jsonWebToken){
        return Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(jsonWebToken).getBody().getSubject();
    }

    public String getJWTFromRequest(HttpServletRequest req) {
        String authorizationHeader = req.getHeader("Authorization");
        String jsonWebToken = null;
        if (authorizationHeader != null && authorizationHeader.startsWith("Bearer")) {
            jsonWebToken = authorizationHeader.substring(7);
        }
        return jsonWebToken;
    }

    private List<String> getUserRoleNamesFromJWT(Set<Role> roles) {
        return roles.stream()
                .map(Role::getName)
                .collect(Collectors.toList());
    }

    /**
     * need use after?
     * ExpiredJwtException
     */
    @SneakyThrows
    public boolean isValidJWT(String jwtToken) {
        try {
            Jws<Claims> claims = Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(jwtToken);
            return claims.getBody().getExpiration().after(new Date());
//        } catch (ExpiredJwtException expiredJwtException) {

        } catch (IllegalArgumentException | UnsupportedJwtException | MalformedJwtException | SignatureException exception) {
            throw new InvalidJWTException();
        }
    }
}
