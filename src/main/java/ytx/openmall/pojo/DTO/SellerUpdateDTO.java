package ytx.openmall.pojo.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SellerUpdateDTO implements Serializable {
    private Long id;
    private String name;
    private String logo;
    private String phone;
}
