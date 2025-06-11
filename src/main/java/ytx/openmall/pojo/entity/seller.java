package ytx.openmall.pojo.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class seller {
    private Long id;
    private String username;
    private String password;
    private Date createTime;
}
