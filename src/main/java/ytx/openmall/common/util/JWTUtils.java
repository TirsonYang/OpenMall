package ytx.openmall.common.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ytx.openmall.common.properties.JwtProperty;

import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.Map;


public class JWTUtils {




    /**
     * 生成JWT
     * @param claims
     * @return JWT
     */
    public static String generateJWT(String key, long ttl,Map<String,Object> claims){
        byte[] bytes = key.getBytes(StandardCharsets.UTF_8);
        long ttlMillis=ttl+System.currentTimeMillis();
        Date expiration=new Date(ttlMillis);

        return Jwts.builder()
                .addClaims(claims)
                .signWith(SignatureAlgorithm.HS256,bytes)
                .setExpiration(expiration)
                .compact();
    }




    /**
     * 解析JWT
     * @param jwt
     * @return Claims
     */
    public static Claims parseJWT(String key , String jwt){
        byte[] bytes = key.getBytes(StandardCharsets.UTF_8);

        return Jwts.parser()
                .setSigningKey(bytes)
                .parseClaimsJws(jwt)
                .getBody();
    }


}
