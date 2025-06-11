package ytx.openmall.server.mapper.seller;


import org.apache.ibatis.annotations.Mapper;
import ytx.openmall.pojo.DTO.SellerRegisterDTO;
import ytx.openmall.pojo.entity.Seller;

@Mapper
public interface SellerRegisterMapper {

     void insert(Seller seller);
}
