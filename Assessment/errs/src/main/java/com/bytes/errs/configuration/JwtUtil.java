//package com.bytes.errs.configuration;
//import java.util.Date;
//import java.util.List;
//import java.util.concurrent.TimeUnit;
//
//import javax.crypto.SecretKey;
//
//import org.springframework.security.core.AuthenticationException;
//import org.springframework.stereotype.Component;
//
//import com.bytes.errs.model.User;
//
//import io.jsonwebtoken.Claims;
//import io.jsonwebtoken.ExpiredJwtException;
//import io.jsonwebtoken.JwtParser;
//import io.jsonwebtoken.JwtParserBuilder;
//import io.jsonwebtoken.Jwts;
//import io.jsonwebtoken.SignatureAlgorithm;
//import io.jsonwebtoken.security.Keys;
//import jakarta.servlet.http.HttpServletRequest;
//
//@SuppressWarnings("deprecation")
//@Component
//public class JwtUtil {
//
//
//    private final SecretKey secret_key = Keys.secretKeyFor(SignatureAlgorithm.HS256);
//    private long accessTokenValidity = 60*60*1000;
//
//    private final JwtParserBuilder jwtParserBuilder;
//
//    private final String TOKEN_HEADER = "Authorization";
//    private final String TOKEN_PREFIX = "Bearer ";
//    
//    
//
////    public JwtUtil(long accessTokenValidity, JwtParser jwtParser) {
////		super();
////		this.accessTokenValidity = accessTokenValidity;
////		this.jwtParser = jwtParser;
////	}
//
////    public JwtUtil(){
////    	this.jwtParser = (JwtParser) Jwts.parser().setSigningKey(secret_key);
////    }
//    
//    public JwtUtil(){
//        this.jwtParserBuilder = Jwts.parser().setSigningKey(secret_key);
//    }
//    
////    @PostConstruct
////    public void init() {
////        // Generate a secure key with sufficient length
////        this.secretKey = Keys.secretKeyFor(SignatureAlgorithm.HS256);
////        this.jwtParser = Jwts.builder().setSigningKey(secretKey).build();
////    }
//
//    public String createToken(User user) {
//        Claims claims = (Claims) Jwts.claims().setSubject(user.getUserName());
//        claims.put("firstName",user.getFirstName());
//        Date tokenCreateTime = new Date();
//        Date tokenValidity = new Date(tokenCreateTime.getTime() + TimeUnit.MINUTES.toMillis(accessTokenValidity));
//        return Jwts.builder()
//        		.setClaims(claims)
//                .setExpiration(tokenValidity)
//                .signWith(SignatureAlgorithm.HS256, secret_key)
//                .compact();
//    }
//
//    private Claims parseJwtClaims(String token) {
//        return jwtParserBuilder.build().parseClaimsJws(token).getBody();
//    }
//
//    public Claims resolveClaims(HttpServletRequest req) {
//        try {
//            String token = resolveToken(req);
//            if (token != null) {
//                return parseJwtClaims(token);
//            }
//            return null;
//        } catch (ExpiredJwtException ex) {
//            req.setAttribute("expired", ex.getMessage());
//            throw ex;
//        } catch (Exception ex) {
//            req.setAttribute("invalid", ex.getMessage());
//            throw ex;
//        }
//    }
//
//    public String resolveToken(HttpServletRequest request) {
//
//        String bearerToken = request.getHeader(TOKEN_HEADER);
//        if (bearerToken != null && bearerToken.startsWith(TOKEN_PREFIX)) {
//            return bearerToken.substring(TOKEN_PREFIX.length());
//        }
//        return null;
//    }
//
//    public boolean validateClaims(Claims claims) throws AuthenticationException {
//        try {
//            return claims.getExpiration().after(new Date());
//        } catch (Exception e) {
//            throw e;
//        }
//    }
//
//    public String getEmail(Claims claims) {
//        return claims.getSubject();
//    }
//
//    @SuppressWarnings({ "unused", "unchecked" })
//    private List<String> getRoles(Claims claims) {
//        return (List<String>) claims.get("roles");
//    }
//
//
//}