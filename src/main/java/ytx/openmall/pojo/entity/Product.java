package ytx.openmall.pojo.entity;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class Product {
    private Integer productId;
    private String name;
    private String description;
    private BigDecimal price;
    private Integer categoryId;
    private String image;
    private Integer stock;
    private Integer status;
    private LocalDate createTime;
    private LocalDate updateTime;
}
