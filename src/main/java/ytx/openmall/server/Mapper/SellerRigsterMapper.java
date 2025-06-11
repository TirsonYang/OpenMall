package ytx.openmall.server.Mapper;


import org.apache.ibatis.annotations.Mapper;
import ytx.openmall.pojo.DTO.SellerRegisterDTO;

@Mapper
public interface SellerRigsterMapper {

    void insert(SellerRegisterDTO sellerRegisterDTO);
}
