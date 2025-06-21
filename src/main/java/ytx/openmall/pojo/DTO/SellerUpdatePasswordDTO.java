package ytx.openmall.pojo.DTO;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SellerUpdatePasswordDTO implements Serializable {
    private Long id;
    private String oldPassword;
    private String newPassword;
}
