package ytx.openmall.server.mapper;


import org.apache.ibatis.annotations.Mapper;
import ytx.openmall.pojo.DTO.SellerLoginDTO;
import ytx.openmall.pojo.VO.SellerLoginVO;
import ytx.openmall.pojo.entity.Seller;

@Mapper
public interface SellerMapper {

     void insert(Seller seller);

    SellerLoginVO login(SellerLoginDTO sellerLoginDTO);


    Seller queryById(Long id);

    void updateById(Seller seller);

    Seller queryByUsername(String username);
}
