package fi.haagahelia.wafflehaus.security;

import io.jsonwebtoken.Jwts; // create + parse (decode) tokens
import io.jsonwebtoken.SignatureAlgorithm; // how JWT is signed
import io.jsonwebtoken.Claims; //the data inside the token object
import org.springframework.stereotype.Component; //auto-create a bean and make it injectable anywhere with @Autowired.

import java.util.Date;

@Component
public class JwtUtil {
    private final String SECRET = "brussels-liege-waffle-1711";
    private final long EXPIRATION_TIME = 1000 * 60 * 60 * 10; // 10 hours

     // Need to create a JWT from email
     public String generateToken(String email) {
        return Jwts.builder()
                .setSubject(email)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(SignatureAlgorithm.HS512, SECRET)
                .compact();
    }

     // Get email (username) from token
     public String extractUsername(String token) {
        return getClaims(token).getSubject();
    }

    // check if token is expired
    public boolean isTokenValid(String token) {
        return getClaims(token).getExpiration().after(new Date());
    }

    // helper function to read JWT data
    private Claims getClaims(String token) {
        return Jwts.parser()
                 .setSigningKey(SECRET)
                 .parseClaimsJws(token)
                 .getBody();
    }
}
