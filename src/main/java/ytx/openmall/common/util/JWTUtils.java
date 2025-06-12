package ytx.openmall.common.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import ytx.openmall.common.Properties.JwtProperty;

import java.util.Date;
import java.util.Map;

public class JWTUtils {

    private static final String JWTkey="TirsonYang.openmall";

    /**
     * 生成JWT
     * @param claims
     * @return JWT
     */
    public static String generateJWT(String keySecret,Long ttl,Map<String,Object> claims){
        return Jwts.builder()
                .addClaims(claims)
                .signWith(SignatureAlgorithm.HS256, keySecret)
                .setExpiration(new Date(System.currentTimeMillis()+ttl))
                .compact();
    }


    /**
     * 解析JWT
     * @param jwt
     * @return Claims
     */
    public static Claims parseJWT(String jwt){
        return Jwts.parser()
                .setSigningKey(JWTkey)
                .parseClaimsJws(jwt)
                .getBody();
    }


}
