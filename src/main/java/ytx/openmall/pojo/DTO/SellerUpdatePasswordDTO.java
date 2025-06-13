package ytx.openmall.pojo.DTO;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SellerUpdatePasswordDTO {
    private Long id;
    private String oldPassword;
    private String newPassword;
}
