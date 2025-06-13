package ytx.openmall.common.properties;


import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "open.jwt")
public class JwtProperty {

    private String sellerSecretKey;
    private String sellerTokenName;
    private Long sellerTtl;


}
