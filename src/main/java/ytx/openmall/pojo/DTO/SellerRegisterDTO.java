package ytx.openmall.pojo.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class SellerRegisterDTO implements Serializable {
    private Long id;

    private String username;

    private String password;
}
