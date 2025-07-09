package ytx.openmall.server.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ytx.openmall.common.result.Result;
import ytx.openmall.pojo.DTO.ProductSaveDTO;
import ytx.openmall.server.service.ProductService;

@RestController
@RequestMapping("/product")
@Slf4j
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("/save")
    Result productSave(@RequestBody ProductSaveDTO productSaveDTO){
        if (productSaveDTO==null){
            return Result.error("参数不能为空");
        }
        log.info("新增商品：{}",productSaveDTO);
        productService.save(productSaveDTO);
        return Result.success();
    }


}
