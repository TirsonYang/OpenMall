package ytx.openmall.pojo.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Seller {
    private Long id;
    private String username;
    private String password;
    private String name;
    private String logo;
    private String phone;
    private LocalDate createTime;
    private LocalDate updateTime;
}
