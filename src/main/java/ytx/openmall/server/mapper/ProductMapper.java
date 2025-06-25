package ytx.openmall.server.mapper;


import org.apache.ibatis.annotations.Mapper;
import ytx.openmall.pojo.entity.Product;

@Mapper
public interface ProductMapper {

    void save(Product product);

}
