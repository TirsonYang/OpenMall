package ytx.openmall.server.service.serviceImpl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ytx.openmall.pojo.DTO.ProductSaveDTO;
import ytx.openmall.pojo.entity.Product;
import ytx.openmall.server.mapper.ProductMapper;
import ytx.openmall.server.service.ProductService;

import java.time.LocalDate;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductMapper productMapper;

    @Override
    public void save(ProductSaveDTO productSaveDTO) {
        Product product=new Product();
        BeanUtils.copyProperties(productSaveDTO,product);
        product.setCreateTime(LocalDate.now());
        product.setUpdateTime(LocalDate.now());
        productMapper.save(product);
    }
}
