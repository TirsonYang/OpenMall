package ytx.openmall.pojo.DTO;

import lombok.Data;

import java.math.BigDecimal;


@Data
public class ProductSaveDTO {

    private Integer productId;
    private String name;
    private BigDecimal price;
    private Integer categoryId;
    private Integer status;

}
