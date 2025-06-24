package ytx.openmall.common.properties;


import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
public class JwtProperty {

    @Value("${open.jwt.seller-secret-key}")
    private String sellerSecretKey;
    @Value("${open.jwt.seller-token-name}")
    private String sellerTokenName;
    @Value("${open.jwt.seller-ttl}")
    private Long sellerTtl;


}
