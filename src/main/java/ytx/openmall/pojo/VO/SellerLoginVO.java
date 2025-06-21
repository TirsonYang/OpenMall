package ytx.openmall.pojo.VO;


import lombok.Data;

import java.io.Serializable;

@Data
public class SellerLoginVO implements Serializable {

    private Long id;
    private String username;
    private String jwt;

}
