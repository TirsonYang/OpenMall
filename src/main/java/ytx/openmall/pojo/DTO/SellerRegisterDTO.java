package ytx.openmall.pojo.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class SellerRegisterDTO {
    private Long id;
    private String username;
    private String password;
    private Date  createTime;
}
