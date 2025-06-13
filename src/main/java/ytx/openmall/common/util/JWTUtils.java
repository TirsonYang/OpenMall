package ytx.openmall.common.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ytx.openmall.common.properties.JwtProperty;

import java.util.Date;
import java.util.Map;


public class JWTUtils {




    /**
     * 生成JWT
     * @param claims
     * @return JWT
     */
    public static String generateJWT(String key, long ttl,Map<String,Object> claims){
        return Jwts.builder()
                .addClaims(claims)
                .signWith(SignatureAlgorithm.HS256,key)
                .setExpiration(new Date(System.currentTimeMillis()+ttl))
                .compact();
    }


    /**
     * 解析JWT
     * @param jwt
     * @return Claims
     */
    public static Claims parseJWT(String key , String jwt){
        return Jwts.parser()
                .setSigningKey(key)
                .parseClaimsJws(jwt)
                .getBody();
    }


}
