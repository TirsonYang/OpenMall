package ytx.openmall.pojo.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SellerUpdateDTO {
    private Long id;
    private String name;
    private String logo;
    private String phone;
}
